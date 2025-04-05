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

    @Override
    public void agregarProducto(NuevoProductoDTO nuevoProducto) throws NegocioException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarProducto'");
    }

    @Override
    public List<ProductoDTO> obtenerProductos(String filtroBusqueda) throws NegocioException {
        List<ProductoDTO> productos = productosDAO.obtenerProductosDTO(filtroBusqueda);
        if (productos == null || productos.isEmpty()) {
            throw new NegocioException("No se encontraron productos con el filtro de busqueda: " + filtroBusqueda);
        }
        return productos;
    }

    @Override
    public List<ProductoDTO> obtenerProductos() throws NegocioException {
        List<ProductoDTO> productos = productosDAO.obtenerProductosDTO();
        if (productos == null || productos.isEmpty()) {
            throw new NegocioException("No se encontraron productos en la base de datos");
        }
        return productos;
    }



}
