package itson.sistemarestaurantenegocio.implementaciones;

import java.util.List;

import itson.sistemarestaurantedominio.dtos.MesaDTO;
import itson.sistemarestaurantedominio.dtos.NuevaMesaDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.interfaces.IMesasBO;
import itson.sistemarestaurantepersistencia.IMesasDAO;

/**
 * Clase que implementa la interfaz IMesasBO y proporciona
 * implementaciones para los métodos de negocio relacionados con las mesas.
 * @author Peter
 */
public class MesasBO implements IMesasBO {

    private final int MINIMO_NUMERO_MESAS = 20;
    
    private IMesasDAO mesasDAO;
    
    public MesasBO(IMesasDAO mesasDAO){
        this.mesasDAO = mesasDAO;
    }
    
    /**
     * Metodo para hacer un registro masivo de mesas,
     * con un numero de mesas especificado
     * @param numeroMesas numero de mesas a especificar
     * @throws NegocioException Si el numero de mesas es menor al mínimo 
     * de mesas que se pueden registrar
     */
    @Override
    public void registrarMesas(int numeroMesas) throws NegocioException {
        if(numeroMesas < 0){
            throw new NegocioException("No puede registrar un numero negativo");
        }
        if(numeroMesas < MINIMO_NUMERO_MESAS){
            throw new NegocioException("Debe registrar mínimo "+MINIMO_NUMERO_MESAS+" mesas");
        }
        Long numeroMesasActual = this.obtenerNumMesas();
        for (int i = 1; i <= numeroMesas; i++) {
            NuevaMesaDTO nuevaMesa = new NuevaMesaDTO(numeroMesasActual.intValue() + i);
            mesasDAO.registrarMesa(nuevaMesa);
        }
        
    }

    /**
     * Metodo para obtener el numero de mesas disponibles en la bd
     * @return numero de mesas disponibles en la bd
     */
    @Override
    public Long obtenerNumMesas() {
        return mesasDAO.obtenerNumMesas();
    }

    @Override
    public List<MesaDTO> obtenerMesasDisponibles() throws NegocioException {
        Long numeroMesas = this.obtenerNumMesas();
        if(numeroMesas == 0){
            throw new NegocioException("No hay mesas disponibles");
        }
        return mesasDAO.obtenerMesasDisponibles();
    }

    @Override
    public MesaDTO obtenerMesaPorId(Long idMesa) throws NegocioException {
        if(idMesa == null){
            throw new NegocioException("El id de la mesa no puede ser nulo");
        }
        MesaDTO mesa = mesasDAO.obtenerMesaPorId(idMesa);
        if(mesa == null){
            throw new NegocioException("No existe una mesa con ese id");
        }
        return mesa;
    }

    @Override
    public MesaDTO obtenerMesaPorNumero(Integer numeroMesa) throws NegocioException {
        if(numeroMesa == null){
            throw new NegocioException("El numero de la mesa no puede ser nulo");
        }
        MesaDTO mesa = mesasDAO.obtenerMesaPorNumero(numeroMesa);
        if(mesa == null){
            throw new NegocioException("No existe una mesa con ese numero");
        }
        return mesa;
    }
}
