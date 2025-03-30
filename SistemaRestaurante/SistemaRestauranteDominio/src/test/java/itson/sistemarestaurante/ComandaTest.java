/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurante;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.enumeradores.EstadoComanda;
import itson.sistemarestaurantedominio.Mesa;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC
 */
public class ComandaTest {

    public ComandaTest() {
    }

    private Cliente clienteCreado;
    private Comanda comandaCreada;
    private Mesa mesaCreada;

    @AfterEach
    public void limpiarBD() {

        if (comandaCreada != null) {
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                    "itson_SistemaRestauranteDominio_jar_1.0");
            EntityManager em = emFactory.createEntityManager();
            em.getTransaction().begin();
            Comanda comanda = em.find(Comanda.class, comandaCreada.getId());
            if (comanda != null) {
                em.remove(comanda);

            }
            em.getTransaction().commit();
        }
        if (clienteCreado != null) {
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                    "itson_SistemaRestauranteDominio_jar_1.0");
            EntityManager em = emFactory.createEntityManager();
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, clienteCreado.getId());
            if (cliente != null) {
                em.remove(cliente);

            }
            em.getTransaction().commit();
        }
        if (mesaCreada != null) {
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                    "itson_SistemaRestauranteDominio_jar_1.0");
            EntityManager em = emFactory.createEntityManager();
            em.getTransaction().begin();
            Mesa mesa = em.find(Mesa.class, mesaCreada.getId());
            if (mesa != null) {
                em.remove(mesa);

            }
            em.getTransaction().commit();
        }
        

    }

    @Test
    public void testCrearComandaConClienteYMesa() {
        final int PUNTOS_CLIENTE = 1;
        final double TOTAL_VENTA_COMANDA = 123.00;
        final int NUMERO_MESA = 2;

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_SistemaRestauranteDominio_jar_1.0");
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        mesaCreada = new Mesa(NUMERO_MESA);
        Calendar ahora = Calendar.getInstance();
        clienteCreado = new Cliente("Checo", "Perez", "Mendoza", PUNTOS_CLIENTE, "checo@gmail.com", "6441111111", ahora);
        comandaCreada = new Comanda("OB-20250329-123", ahora, EstadoComanda.ENTREGADA, TOTAL_VENTA_COMANDA, clienteCreado, mesaCreada);

        em.persist(clienteCreado);
        em.persist(mesaCreada);
        em.persist(comandaCreada);

        em.getTransaction().commit();

    }

}
