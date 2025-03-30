/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurante;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.DetallesComanda;
import itson.sistemarestaurantedominio.enumeradores.EstadoComanda;
import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC
 */
public class DetallesComandaTest {

    public DetallesComandaTest() {
    }

    @Test
    public void testCrearComandaConProductos() {
        final int CANTIDAD_DE_PRODUCTO = 3;
        final int NUMERO_MESA = 3;
        final double PRECIO_PRODUCTO = 100.00;
        final double TOTAL_VENTA_COMANDA = 300;
        final int PUNTOS_CLIENTE = 1;

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_SistemaRestauranteDominio_jar_1.0");
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        Producto producto = new Producto("Rollo California", PRECIO_PRODUCTO, TipoProducto.PLATILLO);
        Mesa mesa = new Mesa(NUMERO_MESA);
        Calendar ahora = Calendar.getInstance();
        Cliente cliente = new Cliente("Patricio", "O'ward", "Junco", PUNTOS_CLIENTE,
                "pato@gmail.com", "6441098765", ahora);
        Comanda comanda = new Comanda("OB-20250329-111", ahora,
                EstadoComanda.CANCELADA, TOTAL_VENTA_COMANDA, cliente, mesa);
        DetallesComanda detalleComanda = new DetallesComanda(CANTIDAD_DE_PRODUCTO,
                "Comentario de PRUEBA", producto.getPrecio(),
                producto.getPrecio() * CANTIDAD_DE_PRODUCTO, comanda, producto);

        em.persist(producto);
        em.persist(cliente);
        em.persist(mesa);
        em.persist(comanda);
        em.persist(detalleComanda);

        em.getTransaction().commit();
    }

}
