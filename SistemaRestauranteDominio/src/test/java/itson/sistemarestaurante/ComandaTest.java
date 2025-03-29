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
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC
 */
public class ComandaTest {

    public ComandaTest() {
    }

    @Test
    public void testCrearComandaConClienteYMesa() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_SistemaRestauranteDominio_jar_1.0");
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        Mesa mesa = new Mesa(2);
        Calendar ahora = Calendar.getInstance();
        Cliente cliente = new Cliente("Checo", "Perez", "Mendoza", 1, "checo@gmail.com", "6441111111", ahora);
        Comanda comanda = new Comanda("OB-20250329-123", ahora, EstadoComanda.ENTREGADA, 123.00, cliente, mesa);

        em.persist(cliente);
        em.persist(mesa);
        em.persist(comanda);

        em.getTransaction().commit();

    }

}
