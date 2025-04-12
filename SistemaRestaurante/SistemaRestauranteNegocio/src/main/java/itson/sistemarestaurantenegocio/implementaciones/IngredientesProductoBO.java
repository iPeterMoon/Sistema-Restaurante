package itson.sistemarestaurantenegocio.implementaciones;

import java.util.List;

import itson.sistemarestaurantedominio.dtos.IngredienteProductoDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.interfaces.IIngredientesProductoBO;
import itson.sistemarestaurantepersistencia.IIngredientesProductosDAO;

public class IngredientesProductoBO implements IIngredientesProductoBO {

    private IIngredientesProductosDAO ingredientesProductoDAO;

    /**
     * Constructor que inicaliza los atributos de la clase al valor de sus
     * parametros
     *
     * @param ingredientesProductoDAO Instancia de la clase DAO para utilizar
     * sus metodos
     */
    public IngredientesProductoBO(IIngredientesProductosDAO ingredientesProductoDAO) {
        this.ingredientesProductoDAO = ingredientesProductoDAO;
    }

    /**
     * Metodo para obtener la relacion entre un producto y sus ingredientes en
     * base a un ID de producto
     *
     * @param idProducto ID del producto para obtener sus ingredientes
     * @return Lista con los ingredientes pertenecientes a un producto
     * @throws NegocioException Si ocurre una excepcion de Negocio al obtener
     * los ingredientes del producto
     */
    @Override
    public List<IngredienteProductoDTO> obtenerIngredientesProductoPorIdProducto(Long idProducto) throws NegocioException {
        List<IngredienteProductoDTO> ingredientesDTO = ingredientesProductoDAO.obtenerIngredientesProductoPorIdProducto(idProducto);
        if (ingredientesDTO == null || ingredientesDTO.isEmpty()) {
            throw new NegocioException("No se encontraron ingredientes para el producto con id: " + idProducto);
        }
        return ingredientesDTO;
    }

}
