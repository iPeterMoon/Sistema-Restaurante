package itson.sistemarestaurantenegocio.implementaciones;

import itson.sistemarestaurantedominio.dtos.NuevaMesaDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.interfaces.IMesasBO;
import itson.sistemarestaurantepersistencia.implementaciones.MesasDAO;

/**
 *
 * @author Peter
 */
public class MesasBO implements IMesasBO {

    private final int MINIMO_NUMERO_MESAS = 20;
    
    /**
     * Metodo para hacer un registro masivo de mesas,
     * con un numero de mesas especificado
     * @param numeroMesas numero de mesas a especificar
     * @throws NegocioException Si el numero de mesas es menor al mínimo 
     * de mesas que se pueden registrar
     */
    @Override
    public void registrarMesas(int numeroMesas) throws NegocioException {
        if(numeroMesas < MINIMO_NUMERO_MESAS){
            throw new NegocioException("Debe registrar mínimo "+MINIMO_NUMERO_MESAS+" mesas");
        } 
        if(numeroMesas < 0){
            throw new NegocioException("No puede registrar un numero negativo");
        }
        MesasDAO mesasDAO = new MesasDAO();
        Long numeroMesasActual = obtenerNumMesas();
        
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
        MesasDAO mesasDAO = new MesasDAO();
        return mesasDAO.obtenerNumMesas();
    }
    
    
}
