package itson.sistemarestaurantenegocio.implementaciones;

import java.util.List;

import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantedominio.dtos.ProductoDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.interfaces.IProductosBO;
import itson.sistemarestaurantepersistencia.IProductosDAO;

public class ProductosBO implements IProductosBO {

    private IProductosDAO productosDAO;

    public ProductosBO(IProductosDAO productosDAO) {
        this.productosDAO = productosDAO;
    }

    /**
     * Metodo que agrega un nuevo producto a la base de datos
     *
     * @param nuevoProducto Nuevo producto a agregar
     * @throws NegocioException Si el producto no se puede agregar debido a un
     * error en la base de datos o de formato
     */
    @Override
    public void agregarProducto(NuevoProductoDTO nuevoProducto) throws NegocioException {
        try {
            productosDAO.agregarProducto(nuevoProducto);
        } catch (Exception e) {
            throw new NegocioException("No se ha podido agregar al usuario: " + e);
        }
    }

    /**
     * Metodo para obtener productos filtrados de la base de datos
     *
     * @param filtroBusqueda Filtro de busqueda de productos
     * @return Lista con todos los productos filtrados de la base de datos
     * @throws NegocioException Si los productos no se pueden obtener debido a
     * un error de la base de datos
     */
    @Override
    public List<ProductoDTO> obtenerProductos(String filtroBusqueda) throws NegocioException {
        List<ProductoDTO> productos = productosDAO.obtenerProductosDTO(filtroBusqueda);
        if (productos == null || productos.isEmpty()) {
            throw new NegocioException("No se encontraron productos con el filtro de busqueda: " + filtroBusqueda);
        }
        return productos;
    }

    /**
     * Metodo para obtener productos de la base de datos
     *
     * @return Lista de todos los productos de la base de datos
     * @throws NegocioException Si los productos no se pueden obtener debido a
     * un error de la base de datos
     */
    @Override
    public List<ProductoDTO> obtenerProductos() throws NegocioException {
        List<ProductoDTO> productos = productosDAO.obtenerProductosDTO();
        if (productos == null || productos.isEmpty()) {
            throw new NegocioException("No se encontraron productos en la base de datos");
        }
        return productos;
    }

}
