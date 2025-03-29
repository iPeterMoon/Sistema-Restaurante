/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurante;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.DetallesComanda;
import itson.sistemarestaurantedominio.EstadoComanda;
import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.Producto;
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
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_SistemaRestauranteDominio_jar_1.0");
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        Cliente cliente = new Cliente("Patricio", "O'ward", "Junco");
        Producto producto = new Producto("Rollo California", 100.00);
        Mesa mesa = new Mesa(3);
        Calendar ahora = Calendar.getInstance();
        Comanda comanda = new Comanda("OB-20250329-111", ahora, EstadoComanda.CANCELADA, "Prueba", 300.00, cliente, mesa);
        DetallesComanda detalleComanda = new DetallesComanda(3, comanda, producto);

        em.persist(producto);
        em.persist(cliente);
        em.persist(mesa);
        em.persist(comanda);
        em.persist(detalleComanda);

        em.getTransaction().commit();
    }

}
