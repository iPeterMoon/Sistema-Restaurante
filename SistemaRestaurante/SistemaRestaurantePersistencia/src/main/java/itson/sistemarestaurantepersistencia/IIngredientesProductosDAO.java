package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.dtos.IngredienteProductoDTO;
import java.util.List;

public interface IIngredientesProductosDAO {
    
    /**
     * Metodo para obtener una lista con todos los ingredientes de un producto
     * @param idProducto Id del producto
     * @return Lista con todos los ingredientes del producto
     */
    public abstract List<IngredienteProductoDTO> obtenerIngredientesProductoPorIdProducto(Long idProducto);
}
