package itson.sistemarestaurantenegocio.interfaces;

import java.util.List;

import itson.sistemarestaurantedominio.dtos.MesaDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;

/**
 *
 * @author Peter
 */
public interface IMesasBO {
    public abstract void registrarMesas(int numeroMesas) throws NegocioException;
    
    public abstract Long obtenerNumMesas();

    public abstract List<MesaDTO> obtenerMesasDisponibles() throws NegocioException;
}
