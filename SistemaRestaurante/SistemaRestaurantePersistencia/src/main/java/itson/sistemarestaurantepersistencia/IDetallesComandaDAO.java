package itson.sistemarestaurantepersistencia;

import java.util.List;

import itson.sistemarestaurantedominio.dtos.DetallesComandaDTO;

/**
 * Interfaz con metodos para acceder a los datalles de las comanda en persistencia
 */
public interface IDetallesComandaDAO {

    /**
     * Metodo para obtener los detalles de una comanda en especifico
     * @param idComanda Id de la comanda
     * @return Lista con los detalles de la comanda
     */
    public abstract List<DetallesComandaDTO> obtenerDetallesComanda(Long idComanda);

}
