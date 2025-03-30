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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC
 */
public class ClienteTest {

    public ClienteTest() {

    }

    private Cliente clienteCreado;

    @AfterEach
    public void limpiarBase() {
        if (clienteCreado != null) {
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                    "itson_PruebasSistemaRestauranteDominio_jar_1.0");
            EntityManager em = emFactory.createEntityManager();
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, clienteCreado.getId());
            if(cliente != null){
                em.remove(cliente);
                
            }
            em.getTransaction().commit();
        }

    }

    @Test
    public void testCrearCliente() {
        final int PUNTOS_USUARIO = 0;

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_PruebasSistemaRestauranteDominio_jar_1.0");
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        Calendar ahora = Calendar.getInstance();
        clienteCreado = new Cliente("Juan", "Perez", "Martinez", PUNTOS_USUARIO, "juan@gmail.com", "6441123456", ahora);

        em.persist(clienteCreado);

        em.getTransaction().commit();
    }

}
