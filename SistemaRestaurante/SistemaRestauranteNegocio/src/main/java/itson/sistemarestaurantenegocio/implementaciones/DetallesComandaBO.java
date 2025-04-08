package itson.sistemarestaurantenegocio.implementaciones;

import java.util.List;

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

}
