/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurante;

import itson.sistemarestaurantedominio.Ingrediente;
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
public class IngredienteTest {

    public IngredienteTest() {
    }

    private Ingrediente ingredienteCreado;
    
    @AfterEach
    public void limpiar(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_SistemaRestauranteDominio_jar_1.0");
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Ingrediente ingrediente = em.find(Ingrediente.class, ingredienteCreado.getId());
        if(ingrediente != null){
            em.remove(ingrediente);
        }
        em.getTransaction().commit();
    }
    
    @Test
    public void testCrearIngrediente() {
        final int CANTIDAD_INGREDIENTE = 5;

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_SistemaRestauranteDominio_jar_1.0");
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        ingredienteCreado = new Ingrediente("Zanahoria", UnidadMedida.PIEZAS, CANTIDAD_INGREDIENTE);

        em.persist(ingredienteCreado);

        em.getTransaction().commit();
    }

}
