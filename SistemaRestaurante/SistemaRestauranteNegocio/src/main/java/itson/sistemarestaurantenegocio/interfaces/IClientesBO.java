package itson.sistemarestaurantenegocio.interfaces;

import java.util.List;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;

public interface IClientesBO {
    
    /**
     * Metodo para registrar un cliente en la base de datos
     * @param nuevoCliente cliente a registrar
     */
    public Cliente registrarCliente(NuevoClienteDTO nuevoCliente) throws NegocioException;
    
    /**
     * Metodo para obtener los clientes registrados en la bd
     * @return lista de clientes registrados
     */
    public List<Cliente> obtenerClientesFrecuentes() throws NegocioException;

    /**
     * Metodo para buscar clientes por nombre
     * @return lista de clientes encontrados
     */
    public List<Cliente> buscarClientesPorNombre(String nombre) throws NegocioException;

    /**
     * Metodo para buscar clientes por telefono
     * @return lista de clientes encontrados
     */
    public List<Cliente> buscarClientesPorTelefono(String telefono) throws NegocioException;

    /**
     * Metodo para buscar clientes por correo
     * @return lista de clientes encontrados
     */
    public List<Cliente> buscarClientesPorCorreo(String correo) throws NegocioException;

    /**
     * Metodo para buscar clientes por nombre y telefono
     * @return lista de clientes encontrados
     */
    public List<Cliente> buscarClientesPorNombreYTelefono(String nombre, String telefono) throws NegocioException;

    /**
     * Metodo para buscar clientes por telefono y correo
     * @return lista de clientes encontrados
     */
    public List<Cliente> buscarClientesPorNombreYCorreo(String nombre, String correo) throws NegocioException;

    /**
     * Metodo para buscar clientes por telefono y correo
     * @return lista de clientes encontrados
     */
    public List<Cliente> buscarClientesPorTelefonoYCorreo(String telefono, String correo) throws NegocioException;
    
    /**
     * Metodo para buscar clientes por nombre, telefono y correo
     * @return lista de clientes encontrados
     */
    public List<Cliente> buscarClientesPorNombreTelefonoYCorreo(String nombre, String telefono, String correo) throws NegocioException;

}
