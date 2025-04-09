package itson.sistemarestaurantenegocio.interfaces;

import java.util.List;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.ClienteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;

public interface IClientesBO {

    /**
     * Metodo para registrar un cliente en la base de datos
     * 
     * @param nuevoCliente cliente a registrar
     */
    public Cliente registrarCliente(NuevoClienteDTO nuevoCliente) throws NegocioException;

    /**
     * Metodo para obtener los clientes registrados en la bd
     * 
     * @return lista de clientes registrados
     */
    public List<ClienteDTO> obtenerClientesFrecuentes() throws NegocioException;

    /**
     * Metodo para buscar clientes por nombre
     * 
     * @return lista de clientes encontrados
     */
    public List<ClienteDTO> buscarClientesPorNombre(String nombre) throws NegocioException;

    /**
     * Metodo para buscar clientes por telefono
     * 
     * @return lista de clientes encontrados
     */
    public List<ClienteDTO> buscarClientesPorTelefono(String telefono) throws NegocioException;

    /**
     * Metodo para buscar clientes por correo
     * 
     * @return lista de clientes encontrados
     */
    public List<ClienteDTO> buscarClientesPorCorreo(String correo) throws NegocioException;

    /**
     * Metodo para buscar clientes por nombre y telefono
     * 
     * @return lista de clientes encontrados
     */
    public List<ClienteDTO> buscarClientesPorNombreYTelefono(String nombre, String telefono) throws NegocioException;

    /**
     * Metodo para buscar clientes por telefono y correo
     * 
     * @return lista de clientes encontrados
     */
    public List<ClienteDTO> buscarClientesPorNombreYCorreo(String nombre, String correo) throws NegocioException;

    /**
     * Metodo para buscar clientes por telefono y correo
     * 
     * @return lista de clientes encontrados
     */
    public List<ClienteDTO> buscarClientesPorTelefonoYCorreo(String telefono, String correo) throws NegocioException;

    /**
     * Metodo para buscar clientes por nombre, telefono y correo
     * 
     * @return lista de clientes encontrados
     */
    public List<ClienteDTO> buscarClientesPorNombreTelefonoYCorreo(String nombre, String telefono, String correo)
            throws NegocioException;

    /**
     * Metodo para obtener un cliente por su id
     * 
     * @param idCliente Id del cliente a buscar
     * @return ClienteDTO representando el cliente encontrado
     */
    public ClienteDTO obtenerClientePorId(Long idCliente) throws NegocioException;

    /**
     * Metodo para agregarle puntos a un cliente
     * 
     * @param idCliente Id del cliente a agregarle puntos
     * @param puntos    Puntos a agregar
     */
    public abstract void agregarPuntos(Long idCliente, Integer puntos) throws NegocioException;
}
