package itson.sistemarestaurantenegocio.interfaces;

import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import java.util.List;
import itson.sistemarestaurantedominio.dtos.DetallesComandaDTO;

public interface IDetallesComandaBO {


    public abstract List<DetallesComandaDTO> obtenerDetallesComanda(Long idComanda) throws NegocioException;
}
