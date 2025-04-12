package itson.sistemarestaurantenegocio.interfaces;

import java.util.List;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.ClienteDTO;
import itson.sistemarestaurantedominio.dtos.ClienteFrecuenteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;

public interface IClientesBO {

    /**
     * Metodo para registrar un cliente en la base de datos
     *
     * @param nuevoCliente cliente a registrar
     * @return Cliente el cliente registrado
     * @throws NegocioException Si el cliente no se puede registrar debido a un
     * error en la base de datos o de formato
     */
    public Cliente registrarCliente(NuevoClienteDTO nuevoCliente) throws NegocioException;

    /**
     * Metodo para obtener los clientes registrados en la bd
     *
     * @return lista de clientes registrados
     * @throws NegocioException Si no se pueden obtener los clientes
     */
    public List<ClienteDTO> obtenerClientesFrecuentes() throws NegocioException;

    /**
     * Busca clientes por nombre.
     *
     * @param nombre Nombre del cliente a buscar.
     * @return Lista de clientes encontrados.
     * @throws NegocioException Si no se encuentran clientes con ese nombre.
     */
    public List<ClienteDTO> buscarClientesPorNombre(String nombre) throws NegocioException;

    /**
     * Metodo para obtener clientes filtrados por el numero de telefono
     *
     * @param telefono Numero de telefono a buscar
     * @return Lista con los clientes que concidan con el numero de telefono
     * @throws NegocioException Si ocurre una excepcion de Negocio al obtener un
     * cliente por numero de telefono
     */
    public List<ClienteDTO> buscarClientesPorTelefono(String telefono) throws NegocioException;

    /**
     * Busca clientes por correo.
     *
     * @param correo Correo del cliente a buscar.
     * @return Lista de clientes encontrados.
     * @throws NegocioException Si no se encuentran clientes con ese correo.
     */
    public List<ClienteDTO> buscarClientesPorCorreo(String correo) throws NegocioException;

    /**
     * Busca clientes por correo.
     *
     * @param nombre Nombre del cliente a buscar
     * @param telefono telefono del cliente a buscar.
     * @return Lista de clientes encontrados.
     * @throws NegocioException Si no se encuentran clientes con ese correo.
     */
    public List<ClienteDTO> buscarClientesPorNombreYTelefono(String nombre, String telefono) throws NegocioException;

    /**
     * Busca clientes por correo.
     *
     * @param nombre Nombre del cliente a buscar
     * @param correo Correo del cliente a buscar.
     * @return Lista de clientes encontrados.
     * @throws NegocioException Si no se encuentran clientes con ese correo.
     */
    public List<ClienteDTO> buscarClientesPorNombreYCorreo(String nombre, String correo) throws NegocioException;

    /**
     * Busca clientes por correo.
     *
     * @param telefono telefono del cliente a buscar
     * @param correo Correo del cliente a buscar.
     * @return Lista de clientes encontrados.
     * @throws NegocioException Si no se encuentran clientes con ese correo.
     */
    public List<ClienteDTO> buscarClientesPorTelefonoYCorreo(String telefono, String correo) throws NegocioException;

    /**
     * Busca clientes por correo.
     *
     * @param nombre Nombre del cliente a buscar
     * @param telefono Telefono del cliente a buscar
     * @param correo Correo del cliente a buscar.
     * @return Lista de clientes encontrados.
     * @throws NegocioException Si no se encuentran clientes con ese correo.
     */
    public List<ClienteDTO> buscarClientesPorNombreTelefonoYCorreo(String nombre, String telefono, String correo)
            throws NegocioException;

    /**
     * Metodo para obtener un cliente por su id
     *
     * @param idCliente Id del cliente a buscar
     * @return ClienteDTO representando al cliente
     * @throws NegocioException si no se encontró al cliente
     */
    public ClienteDTO obtenerClientePorId(Long idCliente) throws NegocioException;

    /**
     * Metodo para agregarle puntos a un cliente
     *
     * @param idCliente Id del cliente a agregarle puntos
     * @param puntos Puntos a agregar
     * @throws NegocioException Si ocurre alguna excepcion al agregar puntos a
     * un cliente
     */
    public abstract void agregarPuntos(Long idCliente, Integer puntos) throws NegocioException;

    /**
     * Metodo para obtener los clientes frecuentes para el reporte.
     *
     * @return Lista con todos los clientes frecuentes
     * @throws NegocioException Si no se puede obtener clientes frecuentes de la
     * base de datos
     */
    public abstract List<ClienteFrecuenteDTO> obtenerClienteFreguenteReporte() throws NegocioException;

    /**
     * Metodo para obtener los clientes frecuentes para el reporte en base a un
     * filtro de vistas minimas
     *
     * @param filtroVisitasMinimas Filtro de vistas minimas
     * @return Lista con todos los clientes frecuentes de la base de datos
     * @throws NegocioException Si no se puede obtener clientes frecuentes de la
     * base de datos
     */
    public abstract List<ClienteFrecuenteDTO> obtenerClientesFrecuentesReporte(Integer filtroVisitasMinimas) throws NegocioException;

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
    public abstract List<ClienteFrecuenteDTO> obtenerClientesFrecuentesReporte(String filtroNombre) throws NegocioException;

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
    public abstract List<ClienteFrecuenteDTO> obtenerClientesFrecuentesReporte(String filtroNombre, Integer filtroVisitasMinimas) throws NegocioException;

}
