/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.IngredientesProducto;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import itson.sistemarestaurantedominio.enumeradores.UnidadMedida;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author PC
 */
public class IngredientesProductoDAOTest {

    public IngredientesProductoDAOTest() {
    }

    @BeforeAll
    public static void activarModoPruebas() {
        ManejadorConexiones.activateTestMode();
    }

    private IngredientesProducto relacionGuardada;
    private Ingrediente ingredienteGuardado;
    private Producto productoGuardado;
    private final IngredientesProductoDAO relacionDAO = new IngredientesProductoDAO();
    private final IngredientesDAO ingredientesDAO = new IngredientesDAO();
    private final ProductosDAO productosDAO = new ProductosDAO();

    @AfterEach
    public void limpiarBD() {
        if (relacionGuardada != null) {
            EntityManager entityManager = ManejadorConexiones.getEntityManager();
            entityManager.getTransaction().begin();

            IngredientesProducto ingredientesProducto = entityManager.find(IngredientesProducto.class, relacionGuardada.getId());
            Ingrediente ingrediente = entityManager.find(Ingrediente.class, ingredienteGuardado.getId());
            Producto producto = entityManager.find(Producto.class, productoGuardado.getId());
            if (ingredientesProducto != null) {
                entityManager.remove(ingredientesProducto);
                entityManager.remove(ingrediente);
                entityManager.remove(producto);
            }
            entityManager.getTransaction().commit();
        }
    }

    @Test
    public void testRelacionarProductoConIngredienteUnicoOk() {
        final BigDecimal PRECIO_PRODUCTO = BigDecimal.valueOf(200.00);
        final int CANTIDAD_A_AGREGAR_DE_INGREDIENTE = 200;
        NuevoIngredienteDTO ingredienteDTO = new NuevoIngredienteDTO(
                "Arroz", UnidadMedida.GRAMOS, 1000);
        ingredienteGuardado = ingredientesDAO.agregarIngrediente(ingredienteDTO);
        NuevoProductoDTO productoDTO = new NuevoProductoDTO(
                "Rollo Sushi", PRECIO_PRODUCTO, TipoProducto.PLATILLO);
        productoGuardado = productosDAO.agregarProducto(productoDTO);
        relacionGuardada = relacionDAO.relacionarIngredientesProducto(
                productoGuardado, ingredienteGuardado, CANTIDAD_A_AGREGAR_DE_INGREDIENTE);
        assertNotNull(relacionGuardada.getId());
    }

    // Este esta en veremos
    @Test
    @Disabled
    public void testRelacionarProductoConVariosIngredientesOk() {
        final BigDecimal PRECIO_PRODUCTO = BigDecimal.valueOf(200.00);
        NuevoIngredienteDTO ingrediente1 = new NuevoIngredienteDTO(
                "Arroz", UnidadMedida.GRAMOS, 1000);
        Ingrediente ingredienteA = ingredientesDAO.agregarIngrediente(ingrediente1);
        NuevoIngredienteDTO ingrediente2 = new NuevoIngredienteDTO(
                "Queso philadelphia", UnidadMedida.GRAMOS, 1000);
        Ingrediente ingredienteB = ingredientesDAO.agregarIngrediente(ingrediente2);
        NuevoIngredienteDTO ingrediente3 = new NuevoIngredienteDTO(
                "Alga Nori", UnidadMedida.PIEZAS, 50);
        Ingrediente ingredienteC = ingredientesDAO.agregarIngrediente(ingrediente3);
        List<ListaIngredientesCantidad> ingredientesARelacionar
                = Arrays.asList(new ListaIngredientesCantidad[]{
            new ListaIngredientesCantidad(ingredienteA, 1),
            new ListaIngredientesCantidad(ingredienteB, 2),
            new ListaIngredientesCantidad(ingredienteC, 3)
        });
        NuevoProductoDTO productoDTO = new NuevoProductoDTO(
                "Rollo Sushi", PRECIO_PRODUCTO, TipoProducto.PLATILLO);
        Producto productoA = productosDAO.agregarProducto(productoDTO);
        List<IngredientesProducto> relacionVerificar
                = relacionDAO.relacionarIngredientesProducto(
                        ingredientesARelacionar, productoA);
    }

}
