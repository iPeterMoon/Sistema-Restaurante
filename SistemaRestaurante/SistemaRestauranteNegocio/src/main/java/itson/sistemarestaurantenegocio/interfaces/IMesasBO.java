package itson.sistemarestaurantenegocio.interfaces;

import itson.sistemarestaurantenegocio.excepciones.NegocioException;

/**
 *
 * @author Peter
 */
public interface IMesasBO {
    public abstract void registrarMesas(int numeroMesas) throws NegocioException;
    
    public abstract Long obtenerNumMesas();
}
