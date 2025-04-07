package itson.sistemarestaurantenegocio.implementaciones;

import java.util.List;

import itson.sistemarestaurantedominio.dtos.IngredienteProductoDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.interfaces.IIngredientesProductoBO;
import itson.sistemarestaurantepersistencia.IIngredientesProductosDAO;

public class IngredientesProductoBO implements IIngredientesProductoBO{

    private IIngredientesProductosDAO ingredientesProductoDAO;

    public IngredientesProductoBO(IIngredientesProductosDAO ingredientesProductoDAO) {
        this.ingredientesProductoDAO = ingredientesProductoDAO;
    }

    @Override
    public List<IngredienteProductoDTO> obtenerIngredientesProductoPorIdProducto(Long idProducto) throws NegocioException {
        List<IngredienteProductoDTO> ingredientesDTO = ingredientesProductoDAO.obtenerIngredientesProductoPorIdProducto(idProducto);
        if (ingredientesDTO == null || ingredientesDTO.isEmpty()) {
            throw new NegocioException("No se encontraron ingredientes para el producto con id: " + idProducto);
        }
        return ingredientesDTO;   
    }

}
