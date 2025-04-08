package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantedominio.enumeradores.UnidadMedida;
import java.util.List;
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
    public static void activarModoPruebas() {
        ManejadorConexiones.activateTestMode();
    }

    private Ingrediente ingredienteGuardado;
    private final IngredientesDAO ingredientesDAO = new IngredientesDAO();

    @AfterEach
    public void limpiarBD() {
        if (ingredienteGuardado != null) {
            EntityManager entityManager = ManejadorConexiones.getEntityManager();
            entityManager.getTransaction().begin();

            Ingrediente ingrediente = entityManager.find(Ingrediente.class, ingredienteGuardado.getId());
            if (ingrediente != null) {
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
        ingredienteGuardado = ingredientesDAO.agregarIngrediente(nuevoIngrediente);
        assertNotNull(ingredienteGuardado.getId());
        assertEquals(nuevoIngrediente.getNombre(), ingredienteGuardado.getNombre());
        assertEquals(nuevoIngrediente.getUnidadMedida(), ingredienteGuardado.getUnidadMedida());
        assertEquals(nuevoIngrediente.getStock(), ingredienteGuardado.getStock());
    }

    @Test
    public void testObtenerIngredientesOK() {
        final Integer CANTIDAD_PRODUCTO = 3;
        final Integer CANTIDAD_INGREDIENTES_ESPERADOS = 1;
        NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO(
                "Calabaza", UnidadMedida.PIEZAS, CANTIDAD_PRODUCTO);
        ingredienteGuardado = ingredientesDAO.agregarIngrediente(nuevoIngrediente);
        List<Ingrediente> ingredientes = ingredientesDAO.obtenerIngredientes();
        assertNotNull(ingredientes);
        assertEquals(CANTIDAD_INGREDIENTES_ESPERADOS, ingredientes.size());
    }

    @Test
    public void testObtenerIngredientesFiltradoNombre() {
        final Integer CANTIDAD_PRODUCTO = 3;
        final String FILTRO_BUSCADO = "Calabaza";
        final Integer CANTIDAD_INGREDIENTES_ESPERADOS = 1;
        NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO(
                "Calabaza", UnidadMedida.PIEZAS, CANTIDAD_PRODUCTO);
        ingredienteGuardado = ingredientesDAO.agregarIngrediente(nuevoIngrediente);
        List<Ingrediente> ingredientes = ingredientesDAO.obtenerIngrediente(FILTRO_BUSCADO);
        assertNotNull(ingredientes);
        assertEquals(CANTIDAD_INGREDIENTES_ESPERADOS, ingredientes.size());
    }

    @Test
    public void testObtenerIngredientesFiltradoUnidadMedida() {
        final Integer CANTIDAD_PRODUCTO = 3;
        final String FILTRO_BUSCADO = "Pieza";
        final Integer CANTIDAD_INGREDIENTES_ESPERADOS = 1;
        NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO(
                "Calabaza", UnidadMedida.PIEZAS, CANTIDAD_PRODUCTO);
        ingredienteGuardado = ingredientesDAO.agregarIngrediente(nuevoIngrediente);
        List<Ingrediente> ingredientes = ingredientesDAO.obtenerIngrediente(FILTRO_BUSCADO);
        assertNotNull(ingredientes);
        assertEquals(CANTIDAD_INGREDIENTES_ESPERADOS, ingredientes.size());
    }

    @Test
    public void testIngredienteExistenteConMismoNombreYUnidadMedidaRegresaTrue() {
        final Integer CANTIDAD_PRODUCTO = 3;
        NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO(
                "Calabaza", UnidadMedida.PIEZAS, CANTIDAD_PRODUCTO);
        ingredienteGuardado = ingredientesDAO.agregarIngrediente(nuevoIngrediente);
        assertTrue(ingredientesDAO.existeIngredienteYUnidad(nuevoIngrediente));
    }

    @Test
    public void testIngredienteExistenteConMismoNombreYUnidadMedidaRegresaFalse() {
        final Integer CANTIDAD_PRODUCTO_1 = 3;
        final Integer CANTIDAD_PRODUCTO_2 = 2;
        NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO(
                "Calabaza", UnidadMedida.PIEZAS, CANTIDAD_PRODUCTO_1);
        ingredienteGuardado = ingredientesDAO.agregarIngrediente(nuevoIngrediente);
        NuevoIngredienteDTO ingredienteBuscado = new NuevoIngredienteDTO(
                "Arroz", UnidadMedida.GRAMOS, CANTIDAD_PRODUCTO_2);
        assertFalse(ingredientesDAO.existeIngredienteYUnidad(ingredienteBuscado));
    }

}
