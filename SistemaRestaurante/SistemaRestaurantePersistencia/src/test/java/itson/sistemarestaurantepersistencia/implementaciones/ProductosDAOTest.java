package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.IngredientesProducto;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantedominio.dtos.IngredienteProductoDTO;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantedominio.dtos.ProductoDTO;
import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import itson.sistemarestaurantedominio.enumeradores.UnidadMedida;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class ProductosDAOTest {

    public ProductosDAOTest() {
    }

    @BeforeAll
    public static void activarModoPruebas() {
        ManejadorConexiones.activateTestMode();
    }

    private Producto productoGuardado;
    private final ProductosDAO productosDAO = new ProductosDAO();
    private Ingrediente ingredienteGuardado;
    private final IngredientesDAO ingredientesDAO = new IngredientesDAO();

    
    /**
     * Metodo que se ejecuta al final de cada prueba, para limpiar la base de
     * datos y evitar conflictos entre pruebas
     */
    @AfterEach
    public void limpiarBD() {
        if (productoGuardado != null) {
            EntityManager entityManager = ManejadorConexiones.getEntityManager();
            entityManager.getTransaction().begin();

            //Eliminar la relacion entre el producto y el ingrediente
            IngredientesProducto ingredientesProducto = entityManager.find(IngredientesProducto.class, 1L);
            if (ingredientesProducto != null) {
                entityManager.remove(ingredientesProducto);
            }
            //Eliminar el ingrediente guardado
            Ingrediente ingrediente = entityManager.find(Ingrediente.class, ingredienteGuardado.getId());
            if (ingrediente != null) {
                entityManager.remove(ingrediente);
            }
            //Eliminar el producto guardado
            Producto producto = entityManager.find(Producto.class, productoGuardado.getId());
            if (producto != null) {
                entityManager.remove(producto);
            }

            entityManager.getTransaction().commit();
        }
    }

    @Test
    public void testAgregarProductoOk() {
        final BigDecimal PRECIO_PRODUCTO = BigDecimal.valueOf(200.00);
        NuevoIngredienteDTO ingrediente = new NuevoIngredienteDTO(
                "Arroz", UnidadMedida.GRAMOS, 200);
        ingredienteGuardado = ingredientesDAO.agregarIngrediente(ingrediente);
        IngredienteProductoDTO nuevoIngredienteProducto = new IngredienteProductoDTO(
                ingredienteGuardado.getId(), 100);
        List<IngredienteProductoDTO> ingredientes = new LinkedList<>();
        ingredientes.add(nuevoIngredienteProducto);
        NuevoProductoDTO nuevoProducto = new NuevoProductoDTO(
                "Rollo Sushi", PRECIO_PRODUCTO, TipoProducto.PLATILLO, ingredientes);
        productoGuardado = productosDAO.agregarProducto(nuevoProducto);
        assertNotNull(productoGuardado.getId());
        assertEquals(nuevoProducto.getNombre(), productoGuardado.getNombre());
        assertEquals(nuevoProducto.getPrecio(), productoGuardado.getPrecio());
        assertEquals(nuevoProducto.getTipoProducto(), productoGuardado.getTipoProducto());
    }

    @Test
    public void testAgregarProductoSinIngredientesFail() {
        final BigDecimal PRECIO_PRODUCTO = BigDecimal.valueOf(200.00);
        NuevoProductoDTO nuevoProducto = new NuevoProductoDTO(
                "Rollo Sushi", PRECIO_PRODUCTO, TipoProducto.PLATILLO, null);
        assertThrows(IllegalArgumentException.class, () -> {
            productosDAO.agregarProducto(nuevoProducto);
        });
    }

    @Test
    public void testObtenerProductos(){
        final BigDecimal PRECIO_PRODUCTO = BigDecimal.valueOf(200.00);
        NuevoIngredienteDTO ingrediente = new NuevoIngredienteDTO(
                "Arroz", UnidadMedida.GRAMOS, 200);
        ingredienteGuardado = ingredientesDAO.agregarIngrediente(ingrediente);
        IngredienteProductoDTO nuevoIngredienteProducto = new IngredienteProductoDTO(
                ingredienteGuardado.getId(), 100);
        List<IngredienteProductoDTO> ingredientes = new LinkedList<>();
        ingredientes.add(nuevoIngredienteProducto);
        NuevoProductoDTO nuevoProducto = new NuevoProductoDTO(
                "Rollo Sushi", PRECIO_PRODUCTO, TipoProducto.PLATILLO, ingredientes);
        productoGuardado = productosDAO.agregarProducto(nuevoProducto);
        
        List<ProductoDTO> productos = productosDAO.obtenerProductosDTO();
        
        assertNotNull(productos);
        assertFalse(productos.isEmpty());
        assertEquals(productoGuardado.getNombre(), productos.get(0).getNombre());
        assertEquals(productoGuardado.getTipoProducto(), productos.get(0).getTipoProducto());
    }

    @Test
    public void testObtenerProductosConFiltro(){
        final BigDecimal PRECIO_PRODUCTO = BigDecimal.valueOf(200.00);
        NuevoIngredienteDTO ingrediente = new NuevoIngredienteDTO(
                "Arroz", UnidadMedida.GRAMOS, 200);
        ingredienteGuardado = ingredientesDAO.agregarIngrediente(ingrediente);
        IngredienteProductoDTO nuevoIngredienteProducto = new IngredienteProductoDTO(
                ingredienteGuardado.getId(), 100);
        List<IngredienteProductoDTO> ingredientes = new LinkedList<>();
        ingredientes.add(nuevoIngredienteProducto);
        NuevoProductoDTO nuevoProducto = new NuevoProductoDTO(
                "Rollo Sushi", PRECIO_PRODUCTO, TipoProducto.PLATILLO, ingredientes);
        productoGuardado = productosDAO.agregarProducto(nuevoProducto);
        
        List<ProductoDTO> productos = productosDAO.obtenerProductosDTO("Sushi");
        
        assertNotNull(productos);
        assertFalse(productos.isEmpty());
        assertEquals(productoGuardado.getNombre(), productos.get(0).getNombre());
        assertEquals(productoGuardado.getTipoProducto(), productos.get(0).getTipoProducto());
    }

    @Test
    public void testObtenerProductosConFiltroFail(){
        final BigDecimal PRECIO_PRODUCTO = BigDecimal.valueOf(200.00);
        NuevoIngredienteDTO ingrediente = new NuevoIngredienteDTO(
                "Arroz", UnidadMedida.GRAMOS, 200);
        ingredienteGuardado = ingredientesDAO.agregarIngrediente(ingrediente);
        IngredienteProductoDTO nuevoIngredienteProducto = new IngredienteProductoDTO(
                ingredienteGuardado.getId(), 100);
        List<IngredienteProductoDTO> ingredientes = new LinkedList<>();
        ingredientes.add(nuevoIngredienteProducto);
        NuevoProductoDTO nuevoProducto = new NuevoProductoDTO(
                "Rollo Sushi", PRECIO_PRODUCTO, TipoProducto.PLATILLO, ingredientes);
        productoGuardado = productosDAO.agregarProducto(nuevoProducto);
        
        List<ProductoDTO> productos = productosDAO.obtenerProductosDTO("Tacos");
        
        assertNotNull(productos);
        assertTrue(productos.isEmpty());
    }

    @Test
    public void testObtenerProductosConFiltroYTipo(){
        final BigDecimal PRECIO_PRODUCTO = BigDecimal.valueOf(200.00);
        NuevoIngredienteDTO ingrediente = new NuevoIngredienteDTO(
                "Arroz", UnidadMedida.GRAMOS, 200);
        ingredienteGuardado = ingredientesDAO.agregarIngrediente(ingrediente);
        IngredienteProductoDTO nuevoIngredienteProducto = new IngredienteProductoDTO(
                ingredienteGuardado.getId(), 100);
        List<IngredienteProductoDTO> ingredientes = new LinkedList<>();
        ingredientes.add(nuevoIngredienteProducto);
        NuevoProductoDTO nuevoProducto = new NuevoProductoDTO(
                "Rollo Sushi", PRECIO_PRODUCTO, TipoProducto.PLATILLO, ingredientes);
        productoGuardado = productosDAO.agregarProducto(nuevoProducto);
        
        List<ProductoDTO> productos = productosDAO.obtenerProductosDTO("Sushi", "Platillo");
        
        assertNotNull(productos);
        assertFalse(productos.isEmpty());
        assertEquals(productoGuardado.getNombre(), productos.get(0).getNombre());
        assertEquals(productoGuardado.getTipoProducto(), productos.get(0).getTipoProducto());
    }

    @Test
    public void testObtenerObtenerProductosConFiltroYTipoFail(){
        final BigDecimal PRECIO_PRODUCTO = BigDecimal.valueOf(200.00);
        NuevoIngredienteDTO ingrediente = new NuevoIngredienteDTO(
                "Arroz", UnidadMedida.GRAMOS, 200);
        ingredienteGuardado = ingredientesDAO.agregarIngrediente(ingrediente);
        IngredienteProductoDTO nuevoIngredienteProducto = new IngredienteProductoDTO(
                ingredienteGuardado.getId(), 100);
        List<IngredienteProductoDTO> ingredientes = new LinkedList<>();
        ingredientes.add(nuevoIngredienteProducto);
        NuevoProductoDTO nuevoProducto = new NuevoProductoDTO(
                "Rollo Sushi", PRECIO_PRODUCTO, TipoProducto.PLATILLO, ingredientes);
        productoGuardado = productosDAO.agregarProducto(nuevoProducto);
        
        List<ProductoDTO> productos = productosDAO.obtenerProductosDTO("Sushi", "Bebida");
        
        assertNotNull(productos);
        assertTrue(productos.isEmpty());
    }



}
