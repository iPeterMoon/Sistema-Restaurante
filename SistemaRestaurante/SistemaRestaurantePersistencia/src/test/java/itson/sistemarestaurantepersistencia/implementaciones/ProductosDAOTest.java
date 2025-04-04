/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import itson.sistemarestaurantedominio.enumeradores.UnidadMedida;
import java.math.BigDecimal;
import java.util.Arrays;
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

    @AfterEach
    public void limpiarBD() {
        if (productoGuardado != null) {
            EntityManager entityManager = ManejadorConexiones.getEntityManager();
            entityManager.getTransaction().begin();

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
        NuevoProductoDTO nuevoProducto = new NuevoProductoDTO(
                "Rollo Sushi", PRECIO_PRODUCTO, TipoProducto.PLATILLO);
        productoGuardado = productosDAO.agregarProducto(nuevoProducto);
        assertNotNull(productoGuardado.getId());
        assertEquals(nuevoProducto.getNombre(), productoGuardado.getNombre());
        assertEquals(nuevoProducto.getPrecio(), productoGuardado.getPrecio());
        assertEquals(nuevoProducto.getTipoProducto(), productoGuardado.getTipoProducto());
    }
    
    @Test
    public void testAgregarProductoConIngredientesOk() {
        final BigDecimal PRECIO_PRODUCTO = BigDecimal.valueOf(200.00);
        List<Ingrediente> ingredientes = Arrays.asList(new Ingrediente[]{
            new Ingrediente("Arroz", UnidadMedida.GRAMOS, 200),
            new Ingrediente("Queso philadelphia", UnidadMedida.GRAMOS, 100)
        });
        NuevoProductoDTO nuevoProducto = new NuevoProductoDTO(
                "Rollo Sushi", PRECIO_PRODUCTO, TipoProducto.PLATILLO);
        productoGuardado = productosDAO.agregarProducto(nuevoProducto);
        assertNotNull(productoGuardado.getId());
        assertEquals(nuevoProducto.getNombre(), productoGuardado.getNombre());
        assertEquals(nuevoProducto.getPrecio(), productoGuardado.getPrecio());
        assertEquals(nuevoProducto.getTipoProducto(), productoGuardado.getTipoProducto());
    }

}
