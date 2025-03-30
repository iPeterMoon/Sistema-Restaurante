package itson.sistemarestaurante;

import itson.sistemarestaurantedominio.Mesa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC
 */
public class MesaTest {

    public MesaTest() {
    }

    private Mesa mesaCreada;
    
    @AfterEach
    public void limpiar(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_PruebasSistemaRestaurante_jar_1.0PU");
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Mesa mesa = em.find(Mesa.class, mesaCreada.getId());
        if(mesa != null){
            em.remove(mesa);
        }
        em.getTransaction().commit();
    }
    
    @Test
    public void testCrearMesa() {
        final int NUMERO_MESA = 1;
        
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
                "itson_PruebasSistemaRestaurante_jar_1.0PU");
        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        mesaCreada = new Mesa(NUMERO_MESA);

        em.persist(mesaCreada);

        em.getTransaction().commit();
    }

}
