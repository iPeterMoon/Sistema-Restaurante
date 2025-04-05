package itson.sistemarestaurantepersistencia;

import java.util.List;

import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.dtos.NuevaMesaDTO;
import itson.sistemarestaurantedominio.dtos.MesaDTO;

/**
 *
 * @author Pc
 */
public interface IMesasDAO {
    
    public abstract Mesa registrarMesa(NuevaMesaDTO nuevaMesaDTO);
    
    public abstract Long obtenerNumMesas();

    public abstract List<MesaDTO> obtenerMesasDisponibles();
}
