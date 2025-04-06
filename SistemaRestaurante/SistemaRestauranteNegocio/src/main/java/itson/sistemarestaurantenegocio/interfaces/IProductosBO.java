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

    /**
     * Metodo que agrega un nuevo producto a la base de datos
     *
     * @param nuevoProducto Nuevo producto a agregar
     * @throws NegocioException Si el producto no se puede agregar debido a un
     * error en la base de datos o de formato
     */
    public abstract void agregarProducto(NuevoProductoDTO nuevoProducto) throws NegocioException;

    /**
     * Metodo para obtener productos filtrados de la base de datos
     *
     * @param filtroBusqueda Filtro de busqueda de productos
     * @return Lista con todos los productos filtrados de la base de datos
     * @throws NegocioException Si los productos no se pueden obtener debido a
     * un error de la base de datos
     */
    public abstract List<ProductoDTO> obtenerProductos(String filtroBusqueda) throws NegocioException;

    /**
     * Metodo para obtener productos de la base de datos
     *
     * @return Lista de todos los productos de la base de datos
     * @throws NegocioException Si los productos no se pueden obtener debido a
     * un error de la base de datos
     */
    public abstract List<ProductoDTO> obtenerProductos() throws NegocioException;

}
