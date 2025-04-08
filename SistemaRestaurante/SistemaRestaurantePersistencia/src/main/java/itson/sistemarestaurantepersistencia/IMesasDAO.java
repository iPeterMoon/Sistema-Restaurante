package itson.sistemarestaurantepersistencia;

import java.util.List;

import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.dtos.NuevaMesaDTO;
import itson.sistemarestaurantedominio.dtos.MesaDTO;

/**
 * Interfaz que define los métodos para la persistencia de las mesas en el sistema de restaurante.
 * Esta interfaz proporciona métodos para registrar nuevas mesas, obtener el número total de mesas y
 * @author Pc
 */
public interface IMesasDAO {
    
    /**
     * Método para registrar una nueva mesa en el sistema.
     *
     * @param nuevaMesaDTO Objeto que contiene los datos de la nueva mesa.
     * @return La entidad Mesa que fue registrada.
     */
    public abstract Mesa registrarMesa(NuevaMesaDTO nuevaMesaDTO);
    
    /**
     * Método para obtener el numero de mesas registradas en el sistema.
     *
     * @return el numero de mesas registradas.
     */
    public abstract Long obtenerNumMesas();

    /**
     * Método para obtener una lista de todas las mesas registradas en el sistema.
     *
     * @return Lista de objetos MesaDTO que representan las mesas.
     */
    public abstract List<MesaDTO> obtenerMesasDisponibles();
}
