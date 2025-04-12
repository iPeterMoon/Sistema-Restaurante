package itson.sistemarestaurantenegocio.interfaces;

import java.util.List;

import itson.sistemarestaurantedominio.dtos.IngredienteProductoDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;

public interface IIngredientesProductoBO {

    /**
     * Metodo para obtener la relacion entre un producto y sus ingredientes en
     * base a un ID de producto
     *
     * @param idProducto ID del producto para obtener sus ingredientes
     * @return Lista con los ingredientes pertenecientes a un producto
     * @throws NegocioException Si ocurre una excepcion de Negocio al obtener
     * los ingredientes del producto
     */
    public abstract List<IngredienteProductoDTO> obtenerIngredientesProductoPorIdProducto(Long idProducto) throws NegocioException;
}
