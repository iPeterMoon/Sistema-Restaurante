/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurante;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC
 */
public class ProductoTest {

    public ProductoTest() {
    }

    private Producto productoCreado;
    
    @AfterEach
    public void limpiar(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_PruebasSistemaRestaurante_jar_1.0PU");
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Producto producto = em.find(Producto.class, productoCreado.getId());
        if(producto!= null){
            em.remove(producto);
        }
        em.getTransaction().commit();
    }
    
    @Test
    public void testCrearProducto() {
        final BigDecimal PRECIO_PRODUCTO = BigDecimal.valueOf(120.00);

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_PruebasSistemaRestaurante_jar_1.0PU");
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        productoCreado = new Producto("Pozole", PRECIO_PRODUCTO, TipoProducto.PLATILLO);

        em.persist(productoCreado);

        em.getTransaction().commit();
    }

}
