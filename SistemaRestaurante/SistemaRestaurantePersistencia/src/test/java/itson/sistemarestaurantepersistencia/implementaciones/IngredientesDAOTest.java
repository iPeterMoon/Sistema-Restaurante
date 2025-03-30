package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantedominio.enumeradores.UnidadMedida;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC
 */
public class IngredientesDAOTest {

    public IngredientesDAOTest() {
    }

    @BeforeAll
    public static void activarModoPruebas(){
        ManejadorConexiones.activateTestMode();
    }
    
    private Ingrediente ingredienteGuardado;
    private final IngredientesDAO ingredientesDAO = new IngredientesDAO();
    
    @AfterEach
    public void limpiarBD(){
        if(ingredienteGuardado != null){
            EntityManager entityManager = ManejadorConexiones.getEntityManager();
            entityManager.getTransaction().begin();
            
            Ingrediente ingrediente = entityManager.find(Ingrediente.class, ingredienteGuardado.getId());
            if(ingrediente != null){
                entityManager.remove(ingrediente);
            }
            
            entityManager.getTransaction().commit();
        }
    }
    
    @Test
    public void testAgregarIngredienteOk() {
        final Integer CANTIDAD_PRODUCTO = 3;
        NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO(
                "Calabaza", UnidadMedida.PIEZAS, CANTIDAD_PRODUCTO);
        ingredienteGuardado = ingredientesDAO.agregar(nuevoIngrediente);
        assertNotNull(ingredienteGuardado.getId());
        assertEquals(nuevoIngrediente.getNombre(), ingredienteGuardado.getNombre());
        assertEquals(nuevoIngrediente.getUnidadMedida(), ingredienteGuardado.getUnidadMedida());
        assertEquals(nuevoIngrediente.getStock(), ingredienteGuardado.getStock());
    }

}
