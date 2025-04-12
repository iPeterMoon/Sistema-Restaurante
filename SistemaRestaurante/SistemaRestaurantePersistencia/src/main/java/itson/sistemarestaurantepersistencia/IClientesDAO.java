package itson.sistemarestaurantepersistencia;

import java.util.List;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import itson.sistemarestaurantedominio.dtos.ClienteDTO;
import itson.sistemarestaurantedominio.dtos.ClienteFrecuenteDTO;

/**
 * Interfaz que define los métodos para la persistencia de los clientes en el
 * sistema de restaurante.
 */
public interface IClientesDAO {

    /**
     * Metodo para registrar un nuevo cliente en la base de datos
     *
     * @param nuevoCliente Cliente a agregar en la base de datos
     * @return Cliente agregado en la base de datos
     */
    public Cliente registrarCliente(NuevoClienteDTO nuevoCliente);

    /**
     * Metodo para obtener los clientes registrados en la bd
     *
     * @return lista de clientes registrados
     */
    public List<ClienteDTO> obtenerClientesFrecuentes();

    /**
     * Metodo que se encarga de buscar los clientes por su nombre en la base de
     * datos
     *
     * @param nombre Nombre de los clientes a buscar en la base de datos
     * @return Lista con los clientes que coincidan con el nombre en la base de
     * datos
     */
    public List<ClienteDTO> buscarClientesPorNombre(String nombre);

    /**
     * Metodo que se encarga de buscar los clietnes por su numero de telefono en
     * la base de datos
     *
     * @param telefono Numero de telefono de los clientes a buscar en la base de
     * datos
     * @return Lista con los clientes que coincidadn con el numero de telefono
     * en la base de datos
     */
    public List<ClienteDTO> buscarClientesPorTelefono(String telefono);

    /**
     * Metodo que se encarga de buscar los clientes por su correo en la base de
     * datos
     *
     * @param correo Correo de los clientes a buscar en la base de datos
     * @return Lista con los clientes que coinciden con el correo en la base de
     * datos
     */
    public List<ClienteDTO> buscarClientesPorCorreo(String correo);

    /**
     * Metodo que se encarga de buscar los clietnes por su nombre y por su
     * telefono en la base de datos
     *
     * @param nombre Nomrbe del cliente
     * @param telefono Numero de telefono del cliente
     * @return Lista con todos los clietnes que coincidan con ambos campos en la
     * base de datos
     */
    public List<ClienteDTO> buscarClientesPorNombreYTelefono(String nombre, String telefono);

    /**
     * Metodo que se encarga de buscar los lientes por su nombre y su correo en
     * la base de datos
     *
     * @param nombre Nombre del cliente
     * @param correo Correo del cliente
     * @return Lista con todos los clientes que coincidan con ambso campos en la
     * base de datos
     */
    public List<ClienteDTO> buscarClientesPorNombreYCorreo(String nombre, String correo);

    /**
     * Metodo que se encarga de buscar los cliente por su telefono y su correo
     * en la base de datos
     *
     * @param telefono Numero de telefono del cliente
     * @param correo Correo del cliente
     * @return Lista con todos los clientes que coincidan con ambos campos en la
     * base de datos
     */
    public List<ClienteDTO> buscarClientesPorTelefonoYCorreo(String telefono, String correo);

    /**
     * Metodo que se encarga de obtener los clientes por su nombre, telefono y
     * correo en la base de datos
     *
     * @param nombre Nombre del cliente
     * @param telefono Numero de telefono del cliente
     * @param correo Correo del cliente
     * @return Lista con todos los clientes que coincidan con los tres campos de
     * la base de datos
     */
    public List<ClienteDTO> buscarClientesPorNombreTelefonoYCorreo(String nombre, String telefono, String correo);

    /**
     * Metodo para obtener un cliente por su id
     *
     * @param idCliente Id del cliente a buscar
     * @return ClienteDTO representando el cliente
     */
    public abstract ClienteDTO obtenerClientePorId(Long idCliente);

    /**
     * Metodo para agregarle puntos a un cliente
     *
     * @param idCliente Id del cliente a agregarle puntos
     * @param puntos Puntos a agregar
     * @throws PersistenciaException Si ocurre un error al agregar los puntos
     * del cliente en la base de datos
     */
    public abstract void agregarPuntos(Long idCliente, Integer puntos) throws PersistenciaException;

    /**
     * Metodo que permite obtener los clientes frecuentes y su informacion.
     *
     * @return Lista de todos los clietnes frecuentes y su informacion.
     */
    public abstract List<ClienteFrecuenteDTO> obtenerClientesFrecuentesReporte();

    /**
     * Metodo que permite obtener los clientes frecuentes y su informacion de
     * base a un filtro de busqueda
     *
     * @param filtroVisitasMinimas Filtro de visitas minimas
     * @return Lista con todos los clientes frecuentes y su informacion de
     * manera filtrada por un campo
     */
    public abstract List<ClienteFrecuenteDTO> obtenerClientesFrecuentesReporte(Integer filtroVisitasMinimas);

    /**
     * Metodo que permite obtener los clientes frecuentes y su informacion de
     * base a un filtro de busqueda
     *
     * @param filtroNombre Filtro de nombre
     * @return Lista con todos los clientes frecuentes y su informacion de
     * manera filtrada por un campo
     */
    public abstract List<ClienteFrecuenteDTO> obtenerClientesFrecuentesReporte(String filtroNombre);

    /**
     * Metodo que permite obtener los clientes frecuentes y su informacion en
     * base a dos filtros de busqueda.
     *
     * @param filtroNombre Filtro del nombre del cliente
     * @param filtroVisitasMinimas Flitro de las visitas minimas de los clientes
     * @return Lista con todos los clientes frecuentes y su informacion de
     * manera filtrada por dos campos
     */
    public abstract List<ClienteFrecuenteDTO> obtenerClientesFrecuentesReporte(String filtroNombre, Integer filtroVisitasMinimas);

}
