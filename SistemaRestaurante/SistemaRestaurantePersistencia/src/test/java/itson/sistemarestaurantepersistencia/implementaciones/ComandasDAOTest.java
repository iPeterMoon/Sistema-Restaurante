package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.DetallesComanda;
import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.IngredientesProducto;
import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantedominio.dtos.NuevoDetalleComandaDTO;
import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import itson.sistemarestaurantedominio.enumeradores.UnidadMedida;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComandasDAOTest {

    private EntityManager entityManager;
    private Ingrediente ingredienteGuardado;
    private Producto productoGuardado;
    private Cliente clienteGuardado;
    private Comanda comandaGuardada;
    private Mesa mesaGuardada;

    @BeforeAll
    public static void activarModoPruebas() {
        ManejadorConexiones.activateTestMode();
    }

    @BeforeEach
    public void setUp() {
        entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        // Crear y guardar una mesa
        mesaGuardada = new Mesa();
        mesaGuardada.setNumeroMesa(1);
        entityManager.persist(mesaGuardada);

        // Crear y guardar un ingrediente
        ingredienteGuardado = new Ingrediente();
        ingredienteGuardado.setNombre("Tomate");
        ingredienteGuardado.setUnidadMedida(UnidadMedida.GRAMOS);
        ingredienteGuardado.setStock(1000);
        entityManager.persist(ingredienteGuardado);

        // Crear y guardar un producto
        productoGuardado = new Producto();
        productoGuardado.setNombre("Ensalada");
        productoGuardado.setPrecio(BigDecimal.valueOf(50.00));
        productoGuardado.setTipoProducto(TipoProducto.PLATILLO);

        IngredientesProducto ingredientesProducto = new IngredientesProducto();
        ingredientesProducto.setIngrediente(ingredienteGuardado);
        ingredientesProducto.setCantidad(200);
        ingredientesProducto.setProducto(productoGuardado);

        productoGuardado.setIngredientes(List.of(ingredientesProducto));
        entityManager.persist(productoGuardado);

        // Crear y guardar un cliente
        clienteGuardado = new Cliente();
        clienteGuardado.setNombre("Juan");
        clienteGuardado.setApellidoPaterno("Pérez");
        clienteGuardado.setApellidoMaterno("Gómez");
        clienteGuardado.setCorreo("juan.perez@example.com");
        clienteGuardado.setTelefono("1234567890");
        clienteGuardado.setPuntos(0);
        clienteGuardado.setFechaRegistro(Calendar.getInstance());
        entityManager.persist(clienteGuardado);

        entityManager.getTransaction().commit();
    }

    @AfterEach
    public void tearDown() {
    entityManager.getTransaction().begin();

    // Eliminar relaciones y limpiar la base de datos
    if (comandaGuardada != null) {
        // Asegurarse de que la comanda esté gestionada
        comandaGuardada = entityManager.merge(comandaGuardada);

        // Eliminar los detalles de la comanda
        comandaGuardada.getProductos().forEach(detalle -> {
            DetallesComanda detalleGestionado = entityManager.merge(detalle);
            entityManager.remove(detalleGestionado);
        });

        // Eliminar la comanda
        entityManager.remove(comandaGuardada);
    }

    if (mesaGuardada != null) {
        mesaGuardada = entityManager.merge(mesaGuardada);
        entityManager.remove(mesaGuardada);
    }

    if (productoGuardado != null) {
        productoGuardado = entityManager.merge(productoGuardado);
        productoGuardado.getIngredientes().forEach(ingredienteProducto -> {
            IngredientesProducto ingredienteProductoGestionado = entityManager.merge(ingredienteProducto);
            entityManager.remove(ingredienteProductoGestionado);
        });
        entityManager.remove(productoGuardado);
    }

    if (ingredienteGuardado != null) {
        ingredienteGuardado = entityManager.merge(ingredienteGuardado);
        entityManager.remove(ingredienteGuardado);
    }

    if (clienteGuardado != null) {
        clienteGuardado = entityManager.merge(clienteGuardado);
        entityManager.remove(clienteGuardado);
    }

    entityManager.getTransaction().commit();
    entityManager.close();
}

    @Test
    public void testGuardarComandaSinComentarioOK() {
        System.out.println("guardarComanda");

        // Crear detalles de la comanda
        List<NuevoDetalleComandaDTO> detallesComanda = new LinkedList<>();
        NuevoDetalleComandaDTO detalleComanda = 
        new NuevoDetalleComandaDTO(
            2,
            BigDecimal.valueOf(50.00),
            BigDecimal.valueOf(100.00),
            productoGuardado.getId()  
        );
        detallesComanda.add(detalleComanda);

        // Crear la nueva comanda DTO
        NuevaComandaDTO nuevaComandaDTO = new NuevaComandaDTO(mesaGuardada.getId(), clienteGuardado.getId(), detallesComanda);

        // Guardar la comanda
        ComandasDAO instance = new ComandasDAO();
        comandaGuardada = instance.guardarComanda(nuevaComandaDTO);

        // Verificar que la comanda se guardó correctamente
        assertNotNull(comandaGuardada);
        assertEquals(clienteGuardado.getId(), comandaGuardada.getCliente().getId());
        assertEquals(1, comandaGuardada.getProductos().size());
        assertEquals(BigDecimal.valueOf(100.00), comandaGuardada.getTotalVenta());
    }

    @Test
    public void testGuardarComandaConComentarioOK() {
        System.out.println("guardarComandaConComentario");

        // Crear detalles de la comanda
        List<NuevoDetalleComandaDTO> detallesComanda = new LinkedList<>();
        NuevoDetalleComandaDTO detalleComanda = 
        new NuevoDetalleComandaDTO(
            2,
            "Sin pepinos",
            BigDecimal.valueOf(50.00),
            BigDecimal.valueOf(100.00),
            productoGuardado.getId()  
        );
        detallesComanda.add(detalleComanda);

        // Crear la nueva comanda DTO
        NuevaComandaDTO nuevaComandaDTO = new NuevaComandaDTO(mesaGuardada.getId(), clienteGuardado.getId(), detallesComanda);

        // Guardar la comanda
        ComandasDAO instance = new ComandasDAO();
        comandaGuardada = instance.guardarComanda(nuevaComandaDTO);

        // Verificar que la comanda se guardó correctamente
        assertNotNull(comandaGuardada);
        assertEquals(clienteGuardado.getId(), comandaGuardada.getCliente().getId());
        assertEquals(1, comandaGuardada.getProductos().size());
        assertEquals(BigDecimal.valueOf(100.00), comandaGuardada.getTotalVenta());
    }

    @Test
    public void testGuardarComandaSinDetalles() {
        System.out.println("guardarComandaSinDetalles");

        // Crear la nueva comanda DTO sin detalles
        NuevaComandaDTO nuevaComandaDTO = new NuevaComandaDTO(mesaGuardada.getId(), clienteGuardado.getId(), new ArrayList<>());

        // Guardar la comanda
        ComandasDAO instance = new ComandasDAO();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            instance.guardarComanda(nuevaComandaDTO);
        });

        // Verificar que se lanzó la excepción esperada
        String expectedMessage = "La lista de detalles de la comanda no puede estar vacía.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGuardarComandaConProductoNoExistente() {
        System.out.println("guardarComandaConProductoNoExistente");

        // Crear detalles de la comanda con un producto no existente
        List<NuevoDetalleComandaDTO> detallesComanda = new LinkedList<>();
        NuevoDetalleComandaDTO detalleComanda = 
        new NuevoDetalleComandaDTO(
            2,
            BigDecimal.valueOf(50.00),
            BigDecimal.valueOf(100.00),
            99999L  
        );
        detallesComanda.add(detalleComanda);

        // Crear la nueva comanda DTO
        NuevaComandaDTO nuevaComandaDTO = new NuevaComandaDTO(mesaGuardada.getId(), clienteGuardado.getId(), detallesComanda);

        // Guardar la comanda
        ComandasDAO instance = new ComandasDAO();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            instance.guardarComanda(nuevaComandaDTO);
        });

        // Verificar que se lanzó la excepción esperada
        String expectedMessage = "El producto con ID 99999 no existe.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test 
    public void testGuardarComandaSinCliente(){
        System.out.println("guardarComanda");

        // Crear detalles de la comanda
        List<NuevoDetalleComandaDTO> detallesComanda = new LinkedList<>();
        NuevoDetalleComandaDTO detalleComanda = 
        new NuevoDetalleComandaDTO(
            2,
            BigDecimal.valueOf(50.00),
            BigDecimal.valueOf(100.00),
            productoGuardado.getId()  
        );
        detallesComanda.add(detalleComanda);

        // Crear la nueva comanda DTO
        NuevaComandaDTO nuevaComandaDTO = new NuevaComandaDTO(mesaGuardada.getId(), null, detallesComanda);

        // Guardar la comanda
        ComandasDAO instance = new ComandasDAO();
        comandaGuardada = instance.guardarComanda(nuevaComandaDTO);

        // Verificar que la comanda se guardó correctamente
        assertNotNull(comandaGuardada);
        assertNull(comandaGuardada.getCliente());
        assertEquals(1, comandaGuardada.getProductos().size());
        assertEquals(BigDecimal.valueOf(100.00), comandaGuardada.getTotalVenta());
    }
}