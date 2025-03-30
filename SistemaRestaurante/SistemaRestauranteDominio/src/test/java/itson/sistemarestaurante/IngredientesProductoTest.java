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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC
 */
public class IngredientesProductoTest {

    public IngredientesProductoTest() {
    }

    private Ingrediente ingredienteCreado;
    private Producto productoCreado;
    private IngredientesProducto ingredienteProductoCreado;
    
    @AfterEach
    public void limpiar(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_SistemaRestauranteDominio_jar_1.0");
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        
        IngredientesProducto ingredientesProducto = em.find(IngredientesProducto.class, ingredienteProductoCreado.getId());
        if(ingredientesProducto != null){
            em.remove(ingredientesProducto);
        }
        Ingrediente ingrediente = em.find(Ingrediente.class, ingredienteCreado.getId());
        if(ingrediente != null){
            em.remove(ingrediente);
        }
        Producto producto = em.find(Producto.class, productoCreado.getId());
        if(producto != null){
            em.remove(producto);
        }
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

        ingredienteCreado = new Ingrediente("Manzana", UnidadMedida.PIEZAS, CANTIDAD_INGREDIENTE);
        productoCreado = new Producto("Pie de Manzana", PRECIO_PRODUCTO, TipoProducto.POSTRE);
        ingredienteProductoCreado = new IngredientesProducto(
                CANTIDAD_INGREDIENTE_POR_PRODUCTO, ingredienteCreado, productoCreado);

        em.persist(ingredienteCreado);
        em.persist(productoCreado);
        em.persist(ingredienteProductoCreado);

        em.getTransaction().commit();
    }

}
