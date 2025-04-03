package itson.sistemarestaurantenegocio.implementaciones;

import java.util.List;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.interfaces.IClientesBO;
import itson.sistemarestaurantenegocio.seguridad.Cifrado;
import itson.sistemarestaurantepersistencia.IClientesDAO;

public class ClientesBO implements IClientesBO {

    private IClientesDAO clientesDAO;

    public ClientesBO(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }

    /**
     * Metodo para registrar un cliente en la base de datos
     * 
     * @param nuevoCliente cliente a registrar
     * @return Cliente el cliente registrado
     * @throws NegocioException Si el cliente no se puede registrar
     *                          debido a un error en la base de datos o de formato
     */
    @Override
    public Cliente registrarCliente(NuevoClienteDTO nuevoCliente) throws NegocioException {
        validarNoNulo(nuevoCliente.getNombre());
        validarNoNulo(nuevoCliente.getApellidoPaterno());
        validarNoNulo(nuevoCliente.getApellidoMaterno());
        validarNoNulo(nuevoCliente.getTelefono());
        if (nuevoCliente.getTelefono().length() != 10) {
            throw new NegocioException("El telefono debe tener 10 digitos");
        }
        String correo = nuevoCliente.getCorreo();
        if(correo == null || correo.isBlank()) {
            nuevoCliente.setCorreo(null);
        } else {
            validarCorreo(correo);
        }
        try {
            String telefonoCifrado = Cifrado.cifrar(nuevoCliente.getTelefono());
            nuevoCliente.setTelefono(telefonoCifrado);
        } catch (Exception e) {
            throw new NegocioException("Error al cifrar el telefono");
        }
        // Llamar al DAO para registrar el cliente
        return clientesDAO.registrarCliente(nuevoCliente);
    }

    /**
     * Metodo para obtener los clientes registrados en la bd
     * 
     * @return lista de clientes registrados
     * @throws NegocioException Si no se pueden obtener los clientes
     */
    @Override
    public List<Cliente> obtenerClientesFrecuentes() throws NegocioException {

        List<Cliente> clientes = clientesDAO.obtenerClientesFrecuentes();
        if (clientes.isEmpty()) {
            throw new NegocioException("No hay clientes registrados");
        }
        return clientes;
    }

    private void validarNoNulo(String texto) throws NegocioException {
        if (texto == null || texto.isEmpty()) {
            throw new NegocioException("Asegurese de llenar todos los campos obligatorios");
        }
    }

    private void validarCorreo(String correo) throws NegocioException {
        // Expresión regular para validar el formato del correo electrónico
        String regexEmail = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$";
        if (!correo.matches(regexEmail)) {
            throw new NegocioException("El correo no es válido");
        }
    }

    @Override
    public List<Cliente> buscarClientesPorNombre(String nombre) throws NegocioException {
        List<Cliente> clientes = clientesDAO.buscarClientesPorNombre(nombre);
        if (clientes.isEmpty()) {
            throw new NegocioException("No hay ningun cliente registrado con ese nombre");
        }
        return clientes;
    }

    /**
     * Metodo para buscar clientes por telefono
     * 
     * @return lista de clientes encontrados
     * @throws NegocioException Si no se pueden obtener los clientes
     */
    @Override
    public List<Cliente> buscarClientesPorTelefono(String telefono) throws NegocioException {
        String telefonoCifrado;
        try{
            telefonoCifrado = Cifrado.cifrar(telefono);
        } catch (Exception e) {
            throw new NegocioException("Error al buscar el telefono");
        }
        List<Cliente> clientes = clientesDAO.buscarClientesPorTelefono(telefonoCifrado);
        if (clientes.isEmpty()) {
            throw new NegocioException("No hay ningun cliente registrado con ese telefono");
        }
        return clientes;
    }

    @Override
    public List<Cliente> buscarClientesPorCorreo(String correo) throws NegocioException {
        List<Cliente> clientes = clientesDAO.buscarClientesPorCorreo(correo);
        if (clientes.isEmpty()) {
            throw new NegocioException("No hay ningun cliente registrado con ese correo");
        }
        return clientes;
    }

    @Override
    public List<Cliente> buscarClientesPorNombreYTelefono(String nombre, String telefono) throws NegocioException {
        String telefonoCifrado;
        try{
            telefonoCifrado = Cifrado.cifrar(telefono);
        } catch (Exception e) {
            throw new NegocioException("Error al buscar el telefono");
        }
        List<Cliente> clientes = clientesDAO.buscarClientesPorNombreYTelefono(nombre, telefonoCifrado);
        if (clientes.isEmpty()) {
            throw new NegocioException("No hay ningun cliente registrado con ese nombre y telefono");
        }
        return clientes;
    }

    @Override
    public List<Cliente> buscarClientesPorNombreYCorreo(String nombre, String correo) throws NegocioException {
        List<Cliente> clientes = clientesDAO.buscarClientesPorNombreYCorreo(nombre, correo);
        if (clientes.isEmpty()) {
            throw new NegocioException("No hay ningun cliente registrado con ese nombre y correo");
        }
        return clientes;
    }

    @Override
    public List<Cliente> buscarClientesPorTelefonoYCorreo(String telefono, String correo) throws NegocioException {
        String telefonoCifrado;
        try{
            telefonoCifrado = Cifrado.cifrar(telefono);
        } catch (Exception e) {
            throw new NegocioException("Error al buscar el telefono");
        }
        List<Cliente> clientes = clientesDAO.buscarClientesPorTelefonoYCorreo(telefonoCifrado, correo);
        if (clientes.isEmpty()) {
            throw new NegocioException("No hay ningun cliente registrado con ese telefono y correo");
        }
        return clientes;
    }

    @Override
    public List<Cliente> buscarClientesPorNombreTelefonoYCorreo(String nombre, String telefono, String correo) throws NegocioException {
        String telefonoCifrado;
        try{
            telefonoCifrado = Cifrado.cifrar(telefono);
        } catch (Exception e) {
            throw new NegocioException("Error al buscar el telefono");
        }
        List<Cliente> clientes = clientesDAO.buscarClientesPorNombreTelefonoYCorreo(nombre, telefonoCifrado, correo);
        if (clientes.isEmpty()) {
            throw new NegocioException("No hay ningun cliente registrado con ese nombre, telefono y correo");
        }
        return clientes;
    }
}
