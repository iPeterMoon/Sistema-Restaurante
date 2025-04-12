package itson.sistemarestaurantenegocio.implementaciones;

import java.util.List;

import itson.sistemarestaurantedominio.dtos.MesaDTO;
import itson.sistemarestaurantedominio.dtos.NuevaMesaDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.interfaces.IMesasBO;
import itson.sistemarestaurantepersistencia.IMesasDAO;

/**
 * Clase que implementa la interfaz IMesasBO y proporciona implementaciones para
 * los métodos de negocio relacionados con las mesas.
 *
 * @author Peter
 */
public class MesasBO implements IMesasBO {

    private final int MINIMO_NUMERO_MESAS = 20;

    private IMesasDAO mesasDAO;

    /**
     * Constructor por omision que inicializa los atirbutos de la calse al valor
     * de sus parametros
     *
     * @param mesasDAO Instancia de la clase DAO para utilizar sus metodos
     */
    public MesasBO(IMesasDAO mesasDAO) {
        this.mesasDAO = mesasDAO;
    }

    /**
     * Metodo para hacer un registro masivo de mesas, con un numero de mesas
     * especificado
     *
     * @param numeroMesas numero de mesas a especificar
     * @throws NegocioException Si el numero de mesas es menor al mínimo de
     * mesas que se pueden registrar
     */
    @Override
    public void registrarMesas(int numeroMesas) throws NegocioException {
        if (numeroMesas < 0) {
            throw new NegocioException("No puede registrar un numero negativo");
        }
        if (numeroMesas < MINIMO_NUMERO_MESAS) {
            throw new NegocioException("Debe registrar mínimo " + MINIMO_NUMERO_MESAS + " mesas");
        }
        Long numeroMesasActual = this.obtenerNumMesas();
        for (int i = 1; i <= numeroMesas; i++) {
            NuevaMesaDTO nuevaMesa = new NuevaMesaDTO(numeroMesasActual.intValue() + i);
            mesasDAO.registrarMesa(nuevaMesa);
        }

    }

    /**
     * Metodo para obtener el numero de mesas disponibles en la bd
     *
     * @return numero de mesas disponibles en la bd
     */
    @Override
    public Long obtenerNumMesas() {
        return mesasDAO.obtenerNumMesas();
    }

    /**
     * Metodo que obtiene las mesas disponibles de la base de datos
     *
     * @return Lista de mesas disponibles
     * @throws NegocioException Si ocurre una excepcion de negocio al obtener
     * las mesas disponibles
     */
    @Override
    public List<MesaDTO> obtenerMesasDisponibles() throws NegocioException {
        Long numeroMesas = this.obtenerNumMesas();
        if (numeroMesas == 0) {
            throw new NegocioException("No hay mesas disponibles");
        }
        return mesasDAO.obtenerMesasDisponibles();
    }

    /**
     * Metodo que obtiene una mesa por su ID
     *
     * @param idMesa ID de la mesa a obtener
     * @return Mesa obtenida por su ID
     * @throws NegocioException Si ocurre una excepcion de negocio al obtener la
     * mesa por ID
     */
    @Override
    public MesaDTO obtenerMesaPorId(Long idMesa) throws NegocioException {
        if (idMesa == null) {
            throw new NegocioException("El id de la mesa no puede ser nulo");
        }
        MesaDTO mesa = mesasDAO.obtenerMesaPorId(idMesa);
        if (mesa == null) {
            throw new NegocioException("No existe una mesa con ese id");
        }
        return mesa;
    }

    /**
     * Metodo para obtener la mesa segun su numero de mesa
     *
     * @param numeroMesa Numero de mesa a obtener
     * @return Mesa que coincida con el numero de mesa solicitado
     * @throws NegocioException Si ocurre una excepcion al obtener una mesa por
     * su numero de mesa
     */
    @Override
    public MesaDTO obtenerMesaPorNumero(Integer numeroMesa) throws NegocioException {
        if (numeroMesa == null) {
            throw new NegocioException("El numero de la mesa no puede ser nulo");
        }
        MesaDTO mesa = mesasDAO.obtenerMesaPorNumero(numeroMesa);
        if (mesa == null) {
            throw new NegocioException("No existe una mesa con ese numero");
        }
        return mesa;
    }
}
