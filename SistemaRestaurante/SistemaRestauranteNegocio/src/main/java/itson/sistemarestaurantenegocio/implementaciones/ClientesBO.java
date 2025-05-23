package itson.sistemarestaurantenegocio.implementaciones;

import java.util.List;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.ClienteDTO;
import itson.sistemarestaurantedominio.dtos.ClienteFrecuenteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.interfaces.IClientesBO;
import itson.sistemarestaurantenegocio.seguridad.Cifrado;
import itson.sistemarestaurantepersistencia.IClientesDAO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;

/**
 * Implementación de la lógica de negocio para la gestión de clientes.
 */
public class ClientesBO implements IClientesBO {

    private IClientesDAO clientesDAO;

    /**
     * Constructor que inicializa el objeto ClientesBO con un DAO de clientes.
     *
     * @param clientesDAO DAO para la persistencia de clientes.
     */
    public ClientesBO(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }

    /**
     * Metodo para registrar un cliente en la base de datos
     *
     * @param nuevoCliente cliente a registrar
     * @return Cliente el cliente registrado
     * @throws NegocioException Si el cliente no se puede registrar debido a un
     * error en la base de datos o de formato
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
        if (correo == null || correo.isBlank()) {
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
    public List<ClienteDTO> obtenerClientesFrecuentes() throws NegocioException {

        List<ClienteDTO> clientes = clientesDAO.obtenerClientesFrecuentes();
        if (clientes.isEmpty()) {
            throw new NegocioException("No hay clientes registrados");
        }
        return clientes;
    }

    /**
     * Valida que un texto no sea nulo ni vacío.
     *
     * @param texto Texto a validar.
     * @throws NegocioException Si el texto es nulo o vacío.
     */
    private void validarNoNulo(String texto) throws NegocioException {
        if (texto == null || texto.isEmpty()) {
            throw new NegocioException("Asegurese de llenar todos los campos obligatorios");
        }
    }

    /**
     * Valida el formato de un correo electrónico.
     *
     * @param correo Correo a validar.
     * @throws NegocioException Si el correo no tiene un formato válido.
     */
    private void validarCorreo(String correo) throws NegocioException {
        // Expresión regular para validar el formato del correo electrónico
        String regexEmail = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$";
        if (!correo.matches(regexEmail)) {
            throw new NegocioException("El correo no es válido");
        }
    }

    /**
     * Busca clientes por nombre.
     *
     * @param nombre Nombre del cliente a buscar.
     * @return Lista de clientes encontrados.
     * @throws NegocioException Si no se encuentran clientes con ese nombre.
     */
    @Override
    public List<ClienteDTO> buscarClientesPorNombre(String nombre) throws NegocioException {
        List<ClienteDTO> clientes = clientesDAO.buscarClientesPorNombre(nombre);
        if (clientes.isEmpty()) {
            throw new NegocioException("No hay ningun cliente registrado con ese nombre");
        }
        return clientes;
    }

    /**
     * Metodo para obtener clientes filtrados por el numero de telefono
     *
     * @param telefono Numero de telefono a buscar
     * @return Lista con los clientes que concidan con el numero de telefono
     * @throws NegocioException Si ocurre una excepcion de Negocio al obtener un
     * cliente por numero de telefono
     */
    @Override
    public List<ClienteDTO> buscarClientesPorTelefono(String telefono) throws NegocioException {
        String telefonoCifrado;
        try {
            telefonoCifrado = Cifrado.cifrar(telefono);
        } catch (Exception e) {
            throw new NegocioException("Error al buscar el telefono");
        }
        List<ClienteDTO> clientes = clientesDAO.buscarClientesPorTelefono(telefonoCifrado);
        if (clientes.isEmpty()) {
            throw new NegocioException("No hay ningun cliente registrado con ese telefono");
        }
        return clientes;
    }

    /**
     * Busca clientes por correo.
     *
     * @param correo Correo del cliente a buscar.
     * @return Lista de clientes encontrados.
     * @throws NegocioException Si no se encuentran clientes con ese correo.
     */
    @Override
    public List<ClienteDTO> buscarClientesPorCorreo(String correo) throws NegocioException {
        List<ClienteDTO> clientes = clientesDAO.buscarClientesPorCorreo(correo);
        if (clientes.isEmpty()) {
            throw new NegocioException("No hay ningun cliente registrado con ese correo");
        }
        return clientes;
    }

    /**
     * Busca clientes por correo.
     *
     * @param nombre Nombre del cliente a buscar
     * @param telefono telefono del cliente a buscar.
     * @return Lista de clientes encontrados.
     * @throws NegocioException Si no se encuentran clientes con ese correo.
     */
    @Override
    public List<ClienteDTO> buscarClientesPorNombreYTelefono(String nombre, String telefono) throws NegocioException {
        String telefonoCifrado;
        try {
            telefonoCifrado = Cifrado.cifrar(telefono);
        } catch (Exception e) {
            throw new NegocioException("Error al buscar el telefono");
        }
        List<ClienteDTO> clientes = clientesDAO.buscarClientesPorNombreYTelefono(nombre, telefonoCifrado);
        if (clientes.isEmpty()) {
            throw new NegocioException("No hay ningun cliente registrado con ese nombre y telefono");
        }
        return clientes;
    }

    /**
     * Busca clientes por correo.
     *
     * @param nombre Nombre del cliente a buscar
     * @param correo Correo del cliente a buscar.
     * @return Lista de clientes encontrados.
     * @throws NegocioException Si no se encuentran clientes con ese correo.
     */
    @Override
    public List<ClienteDTO> buscarClientesPorNombreYCorreo(String nombre, String correo) throws NegocioException {
        List<ClienteDTO> clientes = clientesDAO.buscarClientesPorNombreYCorreo(nombre, correo);
        if (clientes.isEmpty()) {
            throw new NegocioException("No hay ningun cliente registrado con ese nombre y correo");
        }
        return clientes;
    }

    /**
     * Busca clientes por correo.
     *
     * @param telefono telefono del cliente a buscar
     * @param correo Correo del cliente a buscar.
     * @return Lista de clientes encontrados.
     * @throws NegocioException Si no se encuentran clientes con ese correo.
     */
    @Override
    public List<ClienteDTO> buscarClientesPorTelefonoYCorreo(String telefono, String correo) throws NegocioException {
        String telefonoCifrado;
        try {
            telefonoCifrado = Cifrado.cifrar(telefono);
        } catch (Exception e) {
            throw new NegocioException("Error al buscar el telefono");
        }
        List<ClienteDTO> clientes = clientesDAO.buscarClientesPorTelefonoYCorreo(telefonoCifrado, correo);
        if (clientes.isEmpty()) {
            throw new NegocioException("No hay ningun cliente registrado con ese telefono y correo");
        }
        return clientes;
    }

    /**
     * Busca clientes por correo.
     *
     * @param nombre Nombre del cliente a buscar
     * @param telefono Telefono del cliente a buscar
     * @param correo Correo del cliente a buscar.
     * @return Lista de clientes encontrados.
     * @throws NegocioException Si no se encuentran clientes con ese correo.
     */
    @Override
    public List<ClienteDTO> buscarClientesPorNombreTelefonoYCorreo(String nombre, String telefono, String correo)
            throws NegocioException {
        String telefonoCifrado;
        try {
            telefonoCifrado = Cifrado.cifrar(telefono);
        } catch (Exception e) {
            throw new NegocioException("Error al buscar el telefono");
        }
        List<ClienteDTO> clientes = clientesDAO.buscarClientesPorNombreTelefonoYCorreo(nombre, telefonoCifrado, correo);
        if (clientes.isEmpty()) {
            throw new NegocioException("No hay ningun cliente registrado con ese nombre, telefono y correo");
        }
        return clientes;
    }

    /**
     * Metodo para obtener un cliente por su id
     *
     * @param idCliente Id del cliente a buscar
     * @return ClienteDTO representando al cliente
     * @throws NegocioException si no se encontró al cliente
     */
    @Override
    public ClienteDTO obtenerClientePorId(Long idCliente) throws NegocioException {
        ClienteDTO cliente = clientesDAO.obtenerClientePorId(idCliente);
        if (cliente == null) {
            throw new NegocioException("No se encontró el cliente");
        }
        return cliente;
    }

    /**
     * Metodo para agregarle puntos a un cliente
     *
     * @param idCliente Id del cliente a agregarle puntos
     * @param puntos Puntos a agregar
     * @throws NegocioException Si ocurre alguna excepcion al agregar puntos a
     * un cliente
     */
    @Override
    public void agregarPuntos(Long idCliente, Integer puntos) throws NegocioException {
        if (puntos < 0) {
            throw new NegocioException("No se pueden agregar puntos negativos");
        }
        try {
            clientesDAO.agregarPuntos(idCliente, puntos);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Metodo para obtener los clientes frecuentes para el reporte.
     *
     * @return Lista con todos los clientes frecuentes
     * @throws NegocioException Si no se puede obtener clientes frecuentes de la
     * base de datos
     */
    @Override
    public List<ClienteFrecuenteDTO> obtenerClienteFreguenteReporte() throws NegocioException {
        List<ClienteFrecuenteDTO> clienteFrecuente;
        try {
            clienteFrecuente = clientesDAO.obtenerClientesFrecuentesReporte();
        } catch (Exception e) {
            throw new NegocioException("No hay ningun cliente frecuente.");
        }

        return clienteFrecuente;
    }

    /**
     * Metodo para obtener los clientes frecuentes para el reporte en base a un
     * filtro de vistas minimas
     *
     * @param filtroVisitasMinimas Filtro de vistas minimas
     * @return Lista con todos los clientes frecuentes de la base de datos
     * @throws NegocioException Si no se puede obtener clientes frecuentes de la
     * base de datos
     */
    @Override
    public List<ClienteFrecuenteDTO> obtenerClientesFrecuentesReporte(Integer filtroVisitasMinimas) throws NegocioException {
        List<ClienteFrecuenteDTO> clientesFrecuentes;

        if (filtroVisitasMinimas == null || filtroVisitasMinimas <= 0) {
            throw new NegocioException("El filtro de nombre tiene que tener al menos un numero positivo mayor a 0.");
        }
        try {
            clientesFrecuentes = clientesDAO.obtenerClientesFrecuentesReporte(filtroVisitasMinimas);
        } catch (Exception e) {
            throw new NegocioException("No hay ningun cliente frecuente que coincida con el filtro.");
        }
        return clientesFrecuentes;
    }

    /**
     * Metodo para obtener los clientes frecuentes para el reporte en base a un
     * filtro de nombre
     *
     * @param filtroNombre Filtro de nombres
     * @return Lista con todos los clientes frecuentes de la base de datos en
     * base a su filtro de nombre
     * @throws NegocioException Si no se puede obtener clientes frecuentes de la
     * base de datos
     */
    @Override
    public List<ClienteFrecuenteDTO> obtenerClientesFrecuentesReporte(String filtroNombre) throws NegocioException {
        List<ClienteFrecuenteDTO> clientesFrecuentes;

        if (filtroNombre == null || !filtroNombre.matches("[a-zA-Z\\s]+")) {
            throw new NegocioException("El filtro de nombre solo debe contener letras y espacios.");
        }

        try {
            clientesFrecuentes = clientesDAO.obtenerClientesFrecuentesReporte(filtroNombre);
        } catch (Exception e) {
            throw new NegocioException("No hay ningun cliente frecuente que coincida con el filtro.");
        }
        return clientesFrecuentes;
    }

    /**
     * Metodo para obtener los clientes frecuentes de la base de datos en base a
     * dos filtros
     *
     * @param filtroNombre Filtro de nombre
     * @param filtroVisitasMinimas Filtro de visitas minimas
     * @return Lista de todos los clientes frecuentes que coincidan con ambos
     * filtros
     * @throws NegocioException Si no se puede obtener clientes frecuentes de la
     * base de datos
     */
    @Override
    public List<ClienteFrecuenteDTO> obtenerClientesFrecuentesReporte(String filtroNombre, Integer filtroVisitasMinimas) throws NegocioException {
        if (filtroNombre == null || !filtroNombre.matches("[a-zA-Z\\s]+")) {
            throw new NegocioException("El filtro de nombre solo debe contener letras y espacios.");
        }
        if (filtroVisitasMinimas == null || filtroVisitasMinimas <= 0) {
            throw new NegocioException("El filtro de nombre tiene que tener al menos un numero positivo mayor a 0.");
        }

        List<ClienteFrecuenteDTO> clientesFrecuentes;
        try {
            clientesFrecuentes = clientesDAO.obtenerClientesFrecuentesReporte(filtroNombre, filtroVisitasMinimas);
        } catch (Exception e) {
            throw new NegocioException("No hay ningun cliente frecuente que coincida con los filtros.");
        }

        return clientesFrecuentes;
    }
}
