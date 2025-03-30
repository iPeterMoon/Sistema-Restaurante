package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantedominio.enumeradores.UnidadMedida;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC
 */
public class IngredientesDAOTest {

    public IngredientesDAOTest() {
    }

    @Test
    public void testAgregarIngredienteSinProductosOk() {
        final Integer CANTIDAD_PRODUCTO = 3;
        IngredientesDAO ingredientesDAO = new IngredientesDAO();
        NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO(
                "Calabaza", UnidadMedida.PIEZAS, CANTIDAD_PRODUCTO);
        Ingrediente ingredienteGuardado = ingredientesDAO.agregar(nuevoIngrediente);
        assertNotNull(ingredienteGuardado.getId());
        assertEquals(nuevoIngrediente.getNombre(), ingredienteGuardado.getNombre());
        assertEquals(nuevoIngrediente.getUnidadMedida(), ingredienteGuardado.getUnidadMedida());
        assertEquals(nuevoIngrediente.getStock(), ingredienteGuardado.getStock());
    }

}
