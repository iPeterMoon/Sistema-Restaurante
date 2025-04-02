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
}
