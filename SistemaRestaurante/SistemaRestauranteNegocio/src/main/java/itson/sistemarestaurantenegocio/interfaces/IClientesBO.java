package itson.sistemarestaurantenegocio.interfaces;

import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;

public interface IClientesBO {
    
    /**
     * Metodo para registrar un cliente en la base de datos
     * @param nuevoCliente cliente a registrar
     */
    public void registrarCliente(NuevoClienteDTO nuevoCliente) throws NegocioException;
    
}
