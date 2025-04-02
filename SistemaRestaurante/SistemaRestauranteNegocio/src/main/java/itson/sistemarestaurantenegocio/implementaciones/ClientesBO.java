package itson.sistemarestaurantenegocio.implementaciones;

import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.interfaces.IClientesBO;
import itson.sistemarestaurantenegocio.seguridad.Cifrado;
import itson.sistemarestaurantepersistencia.IClientesDAO;

public class ClientesBO implements IClientesBO{

    private IClientesDAO clientesDAO;

    public ClientesBO(IClientesDAO clientesDAO){
        this.clientesDAO = clientesDAO;
    }

    /**
     * Metodo para registrar un cliente en la base de datos
     * @param nuevoCliente cliente a registrar
     * @throws NegocioException Si el cliente no se puede registrar
     * debido a un error en la base de datos o de formato
     * @throws Exception si hay un error de cifrado.
     */
    @Override
    public void registrarCliente(NuevoClienteDTO nuevoCliente) throws NegocioException{
        validarNoNulo(nuevoCliente.getNombre());
        validarNoNulo(nuevoCliente.getApellidoPaterno());
        validarNoNulo(nuevoCliente.getApellidoMaterno());
        validarNoNulo(nuevoCliente.getTelefono());
        if(nuevoCliente.getTelefono().length() != 10){
            throw new NegocioException("El telefono debe tener 10 digitos");
        }
        validarNoNulo(nuevoCliente.getCorreo());
        validarCorreo(nuevoCliente.getCorreo());
        try{
            String telefonoCifrado = Cifrado.cifrar(nuevoCliente.getTelefono());   
            nuevoCliente.setTelefono(telefonoCifrado);
        } catch (Exception e){
            throw new NegocioException("Error al cifrar el telefono");
        }
        // Llamar al DAO para registrar el cliente
        clientesDAO.registrarCliente(nuevoCliente);
    }
    
    private void validarNoNulo(String texto) throws NegocioException{
        if(texto == null || texto.isEmpty()){
            throw new NegocioException("Asegurese de llenar todos los campos obligatorios");
        }
    }
    private void validarCorreo(String correo) throws NegocioException{
        // Expresión regular para validar el formato del correo electrónico
        String regexEmail = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";
        if(correo.matches(regexEmail)){
            throw new NegocioException("El correo no es válido");
        }
    }
}

