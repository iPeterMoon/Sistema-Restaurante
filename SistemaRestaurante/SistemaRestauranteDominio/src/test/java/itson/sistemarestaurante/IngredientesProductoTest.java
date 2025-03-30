/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurante;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.IngredientesProducto;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import itson.sistemarestaurantedominio.enumeradores.UnidadMedida;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC
 */
public class IngredientesProductoTest {

    public IngredientesProductoTest() {
    }

    @Test
    public void testCrearProductoConIngredientes() {
        final int CANTIDAD_INGREDIENTE = 3;
        final double PRECIO_PRODUCTO = 100.00;
        final int CANTIDAD_INGREDIENTE_POR_PRODUCTO = 2;

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_SistemaRestauranteDominio_jar_1.0");
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        Ingrediente ingrediente = new Ingrediente("Manzana", UnidadMedida.PIEZAS, CANTIDAD_INGREDIENTE);
        Producto producto = new Producto("Pie de Manzana", PRECIO_PRODUCTO, TipoProducto.POSTRE);
        IngredientesProducto ingredientesProducto = new IngredientesProducto(
                CANTIDAD_INGREDIENTE_POR_PRODUCTO, ingrediente, producto);

        em.persist(ingrediente);
        em.persist(producto);
        em.persist(ingredientesProducto);

        em.getTransaction().commit();
    }

}
