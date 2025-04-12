package itson.sistemarestaurantenegocio.interfaces;

import java.util.List;

import itson.sistemarestaurantedominio.dtos.MesaDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;

/**
 *
 * @author Peter
 */
public interface IMesasBO {

    /**
     * Metodo para hacer un registro masivo de mesas, con un numero de mesas
     * especificado
     *
     * @param numeroMesas numero de mesas a especificar
     * @throws NegocioException Si el numero de mesas es menor al mínimo de
     * mesas que se pueden registrar
     */
    public abstract void registrarMesas(int numeroMesas) throws NegocioException;

    /**
     * Metodo para obtener el numero de mesas disponibles en la bd
     *
     * @return numero de mesas disponibles en la bd
     */
    public abstract Long obtenerNumMesas();

    /**
     * Metodo que obtiene las mesas disponibles de la base de datos
     *
     * @return Lista de mesas disponibles
     * @throws NegocioException Si ocurre una excepcion de negocio al obtener
     * las mesas disponibles
     */
    public abstract List<MesaDTO> obtenerMesasDisponibles() throws NegocioException;

    /**
     * Metodo que obtiene una mesa por su ID
     *
     * @param idMesa ID de la mesa a obtener
     * @return Mesa obtenida por su ID
     * @throws NegocioException Si ocurre una excepcion de negocio al obtener la
     * mesa por ID
     */
    public abstract MesaDTO obtenerMesaPorId(Long idMesa) throws NegocioException;

    /**
     * Metodo para obtener la mesa segun su numero de mesa
     *
     * @param numeroMesa Numero de mesa a obtener
     * @return Mesa que coincida con el numero de mesa solicitado
     * @throws NegocioException Si ocurre una excepcion al obtener una mesa por
     * su numero de mesa
     */
    public abstract MesaDTO obtenerMesaPorNumero(Integer numeroMesa) throws NegocioException;
}
