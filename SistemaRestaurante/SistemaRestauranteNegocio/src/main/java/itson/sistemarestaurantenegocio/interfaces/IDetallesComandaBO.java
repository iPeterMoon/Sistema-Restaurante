package itson.sistemarestaurantenegocio.interfaces;

import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import java.util.List;

import itson.sistemarestaurantedominio.DetallesComanda;
import itson.sistemarestaurantedominio.dtos.DetallesComandaDTO;

public interface IDetallesComandaBO {


    public abstract List<DetallesComandaDTO> obtenerDetallesComanda(Long idComanda) throws NegocioException;

    /**
     * Metodo para guardar detalles de una comanda ya existente
     * @param detalle Detalle de la comanda a guardar
     * @return DetallesComanda guardada
     */
    public abstract DetallesComanda guardarDetallesComanda(DetallesComandaDTO detalle) throws NegocioException;

    /**
     * Metodo para eliminar un detalle de una comanda
     * @param idDetallesComanda Id del detalle a eliminar||
     */
    public abstract void eliminarDetallesComanda(Long idDetallesComanda) throws NegocioException;
}
