package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.IngredientesProducto;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantedominio.dtos.IngredienteProductoDTO;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantedominio.dtos.ProductoDTO;
import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import itson.sistemarestaurantedominio.enumeradores.UnidadMedida;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class IngredientesProductosDAOTest {

    public IngredientesProductosDAOTest() {
    }

    @BeforeAll
    public static void activarModoPruebas() {
        ManejadorConexiones.activateTestMode();
    }

    private Producto productoGuardado;
    private final ProductosDAO productosDAO = new ProductosDAO();
    private Ingrediente ingredienteGuardado;
    private final IngredientesDAO ingredientesDAO = new IngredientesDAO();

    
    @BeforeEach
    public void setup(){
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        ingredienteGuardado = new Ingrediente();
        ingredienteGuardado.setNombre("Azucar");
        ingredienteGuardado.setStock(40);
        ingredienteGuardado.setUnidadMedida(UnidadMedida.GRAMOS);

        entityManager.persist(ingredienteGuardado);

        IngredientesProducto ingrediente = new IngredientesProducto();
        ingrediente.setIngrediente(ingredienteGuardado);
        ingrediente.setCantidad(20);
        List<IngredientesProducto> listaIngredientes = new LinkedList<>();
        
        productoGuardado = new Producto();
        productoGuardado.setNombre("Azucar en cubo");
        productoGuardado.setPrecio(new BigDecimal(10));
        productoGuardado.setTipoProducto(TipoProducto.ENTRADA);
        productoGuardado.setIngredientes(listaIngredientes);
        
        ingrediente.setProducto(productoGuardado);

        listaIngredientes.add(ingrediente);
        
        entityManager.persist(productoGuardado);
        
        entityManager.getTransaction().commit();
    }

    /**
     * Metodo que se ejecuta al final de cada prueba, para limpiar la base de
     * datos y evitar conflictos entre pruebas
     */
    @AfterEach
    public void limpiarBD() {
        if (productoGuardado != null) {
            EntityManager entityManager = ManejadorConexiones.getEntityManager();
            entityManager.getTransaction().begin();

            //Eliminar la relacion entre el producto y el ingrediente
            IngredientesProducto ingredientesProducto = entityManager.find(IngredientesProducto.class, 1L);
            if (ingredientesProducto != null) {
                entityManager.remove(ingredientesProducto);
            }
            //Eliminar el ingrediente guardado
            Ingrediente ingrediente = entityManager.find(Ingrediente.class, ingredienteGuardado.getId());
            if (ingrediente != null) {
                entityManager.remove(ingrediente);
            }
            //Eliminar el producto guardado
            Producto producto = entityManager.find(Producto.class, productoGuardado.getId());
            if (producto != null) {
                entityManager.remove(producto);
            }

            entityManager.getTransaction().commit();
        }
    }

    @Test
    public void testObtenerIngredientesProducto(){
        IngredientesProductosDAO ingredientesProductosDAO = new IngredientesProductosDAO();
        List<IngredienteProductoDTO> ingredientes = ingredientesProductosDAO.obtenerIngredientesProductoPorIdProducto(productoGuardado.getId());
        assertNotNull(ingredientes);
        assertEquals(1, ingredientes.size());
        assertEquals(20, ingredientes.get(0).getCantidad());
        assertEquals(ingredienteGuardado.getId(), ingredientes.get(0).getIdIngrediente());
    }



}
