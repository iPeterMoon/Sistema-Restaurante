package itson.sistemarestaurantenegocio.interfaces;

import java.util.List;

import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantedominio.dtos.ProductoDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;

/**
 *
 * @author PC
 */
public interface IProductosBO {
    
    public abstract void agregarProducto(NuevoProductoDTO nuevoProducto) throws NegocioException;
    
    public abstract List<ProductoDTO> obtenerProductos(String filtroBusqueda) throws NegocioException;

    public abstract List<ProductoDTO> obtenerProductos() throws NegocioException;

}
