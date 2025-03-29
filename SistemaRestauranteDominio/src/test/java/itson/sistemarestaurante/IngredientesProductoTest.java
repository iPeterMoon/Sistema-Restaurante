/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurante;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.IngredientesProducto;
import itson.sistemarestaurantedominio.Producto;
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

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_SistemaRestauranteDominio_jar_1.0");
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        Ingrediente ingrediente = new Ingrediente("Manzana", UnidadMedida.PIEZAS, 3);
        Producto producto = new Producto("Pie de Manzana", 100.00);
        IngredientesProducto ingredientesProducto = new IngredientesProducto(ingrediente, producto);

        em.persist(ingrediente);
        em.persist(producto);
        em.persist(ingredientesProducto);

        em.getTransaction().commit();
    }

}
