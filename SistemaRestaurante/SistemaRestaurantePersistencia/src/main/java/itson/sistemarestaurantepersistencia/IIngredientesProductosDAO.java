package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.dtos.IngredienteProductoDTO;
import java.util.List;

/**
 * Interfaz que define los métodos para la persistencia de los ingredientes de los productos en el sistema de restaurante.
 * @author PC
 */
public interface IIngredientesProductosDAO {
    
    /**
     * Metodo para obtener una lista con todos los ingredientes de un producto
     * @param idProducto Id del producto
     * @return Lista con todos los ingredientes del producto
     */
    public abstract List<IngredienteProductoDTO> obtenerIngredientesProductoPorIdProducto(Long idProducto);
}
