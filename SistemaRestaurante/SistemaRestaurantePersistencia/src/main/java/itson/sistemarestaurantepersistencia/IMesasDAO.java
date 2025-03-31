package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.dtos.NuevaMesaDTO;

/**
 *
 * @author Pc
 */
public interface IMesasDAO {
    
    public abstract Mesa registrarMesa(NuevaMesaDTO nuevaMesaDTO);
    
    public abstract Long obtenerNumMesas();
}
