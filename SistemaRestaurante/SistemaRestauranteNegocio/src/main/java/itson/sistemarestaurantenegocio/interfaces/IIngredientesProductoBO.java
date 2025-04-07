package itson.sistemarestaurantenegocio.interfaces;

import java.util.List;

import itson.sistemarestaurantedominio.dtos.IngredienteProductoDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;

public interface IIngredientesProductoBO {

    /**
     * Metodo para obtener una lista con todos los ingredientes de un producto
     * @param idProducto Id del producto
     * @return Lista con todos los ingredientes del producto
     */
    public abstract List<IngredienteProductoDTO> obtenerIngredientesProductoPorIdProducto(Long idProducto) throws NegocioException;
}
