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

        Producto producto = new Producto("Rollo California", 100.00);
        Mesa mesa = new Mesa(3);
        Calendar ahora = Calendar.getInstance();
        Cliente cliente = new Cliente("Patricio", "O'ward", "Junco", 1, "pato@gmail.com", "6441098765", ahora);
        Comanda comanda = new Comanda("OB-20250329-111", ahora, EstadoComanda.CANCELADA, 300.00, cliente, mesa);
        DetallesComanda detalleComanda = new DetallesComanda(3, comanda, producto);

        em.persist(producto);
        em.persist(cliente);
        em.persist(mesa);
        em.persist(comanda);
        em.persist(detalleComanda);

        em.getTransaction().commit();
    }

}
