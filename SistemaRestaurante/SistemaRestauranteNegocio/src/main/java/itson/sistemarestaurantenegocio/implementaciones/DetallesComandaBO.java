package itson.sistemarestaurantenegocio.implementaciones;

import java.util.List;

import itson.sistemarestaurantedominio.DetallesComanda;
import itson.sistemarestaurantedominio.dtos.DetallesComandaDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.interfaces.IDetallesComandaBO;
import itson.sistemarestaurantepersistencia.IDetallesComandaDAO;

public class DetallesComandaBO implements IDetallesComandaBO {

    private IDetallesComandaDAO detallesComandaDAO;

    public DetallesComandaBO(IDetallesComandaDAO detallesComandaDAO){
        this.detallesComandaDAO = detallesComandaDAO;
    }

    @Override
    public List<DetallesComandaDTO> obtenerDetallesComanda(Long idComanda) throws NegocioException {
        List<DetallesComandaDTO> detallesComanda = detallesComandaDAO.obtenerDetallesComanda(idComanda);
        if(detallesComanda== null || detallesComanda.isEmpty()){
            throw new NegocioException("La lista de detalles de la comanda");
        }
        return detallesComanda;
    }

    /**
     * Metodo para guardar detalles de una comanda ya existente
     * @param detalle Detalle de la comanda a guardar
     * @return DetallesComanda guardada
     */
    @Override
    public DetallesComanda guardarDetallesComanda(DetallesComandaDTO detalle) throws NegocioException {
        DetallesComanda detalleGuardado = detallesComandaDAO.guardarDetallesComanda(detalle);
        if(detalleGuardado == null){
            throw new NegocioException("Error al guardar un detalle de la comanda");
        }
        return detalleGuardado;
    }

    /**
     * Metodo para eliminar un detalle de una comanda
     * @param idDetallesComanda Id del detalle a eliminar||
     */
    @Override
    public void eliminarDetallesComanda(Long idDetallesComanda) {
        detallesComandaDAO.eliminarDetallesComanda(idDetallesComanda);
    } 
}
