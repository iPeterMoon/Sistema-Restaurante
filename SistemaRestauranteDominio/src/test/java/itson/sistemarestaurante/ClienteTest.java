/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurante;

import itson.sistemarestaurantedominio.Cliente;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC
 */
public class ClienteTest {

    public ClienteTest() {

    }

    @Test
    public void testCrearCliente() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_SistemaRestauranteDominio_jar_1.0");
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        Calendar ahora = Calendar.getInstance();
        Cliente cliente = new Cliente("Juan", "Perez", "Martinez", 1, "juan@gmail.com", "6441123456", ahora);

        em.persist(cliente);

        em.getTransaction().commit();
    }

}
