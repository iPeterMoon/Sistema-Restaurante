package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.dtos.NuevaMesaDTO;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author pc
 */
public class MesasDAOTest {
    
    public MesasDAOTest() {
    }
    
    private MesasDAO mesasDAO = new MesasDAO();
    private Mesa mesaCreada;
    
    @BeforeAll
    public static void activarModoPruebas() {
        ManejadorConexiones.activateTestMode();
    }
   
    @AfterEach
    public void limpiar() {
        if(mesaCreada != null){
            EntityManager entityManager = ManejadorConexiones.getEntityManager();
            entityManager.getTransaction().begin();
            Mesa mesa = entityManager.find(Mesa.class, mesaCreada.getId());
            if(mesa!= null){
                entityManager.remove(mesa);
            }
            entityManager.getTransaction().commit();
        }
        
    }

    /**
     * Test of registrarMesa method, of class MesasDAO.
     */
    @Test
    public void testRegistrarMesa() {
        System.out.println("registrarMesa");
        NuevaMesaDTO nuevaMesa = new NuevaMesaDTO(1);
        mesaCreada = mesasDAO.registrarMesa(nuevaMesa);
        assertNotNull(mesaCreada);
        assertEquals(nuevaMesa.getNumeroMesa(), mesaCreada.getNumeroMesa());
        
    }
    
    @Test
    public void testObtenerNumMesas(){
        System.out.println("obtenerNumMesa");
        Long expected = 0L;
        Long result = mesasDAO.obtenerNumMesas();
        assertEquals(expected, result);
        NuevaMesaDTO nuevaMesa = new NuevaMesaDTO(1);
        mesaCreada = mesasDAO.registrarMesa(nuevaMesa);
        expected = 1L;
        result = mesasDAO.obtenerNumMesas();
        assertEquals(expected, result);
    }
    
}
