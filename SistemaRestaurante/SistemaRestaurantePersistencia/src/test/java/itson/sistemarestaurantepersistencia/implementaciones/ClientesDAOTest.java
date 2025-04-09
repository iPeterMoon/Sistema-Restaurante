package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.ClienteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;

/**
 *
 * @author pc
 */
public class ClientesDAOTest {
    
    public ClientesDAOTest() {
    }

    private Cliente clienteGuardado;
    private final ClientesDAO clientesDAO = new ClientesDAO();
    
    @BeforeAll
    public static void activarModoPruebas() {
        ManejadorConexiones.activateTestMode();
    }
    
    @AfterEach
    public void limpiarBD() {
        if(clienteGuardado != null) {
            EntityManager entityManager = ManejadorConexiones.getEntityManager();
            entityManager.getTransaction().begin(); 
            clienteGuardado = entityManager.find(Cliente.class, clienteGuardado.getId());
            if(clienteGuardado != null) {
                entityManager.remove(clienteGuardado);
            }
            entityManager.getTransaction().commit();
        }

        
    }

    /**
     * Test of registrarCliente method, of class ClientesDAO.
     */
    @Test
    public void testRegistrarClienteCompletoOK() {
        System.out.println("registrarClienteCompletoOK");
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
            "Jefferson",
            "Gutierritos",
            "Gonzalez",
            "6441234567",
            "jeff.gutierrez@gmail.com");
        clienteGuardado = clientesDAO.registrarCliente(nuevoCliente);
        assertNotNull(clienteGuardado);
        assertEquals(nuevoCliente.getNombre(), clienteGuardado.getNombre());
        assertEquals(nuevoCliente.getApellidoPaterno(), clienteGuardado.getApellidoPaterno());
        assertEquals(nuevoCliente.getApellidoMaterno(), clienteGuardado.getApellidoMaterno());
        assertEquals(nuevoCliente.getTelefono(), clienteGuardado.getTelefono());
        assertEquals(nuevoCliente.getCorreo(), clienteGuardado.getCorreo());
        assertEquals(0, clienteGuardado.getPuntos());
        assertNotNull(clienteGuardado.getFechaRegistro());
    }

    @Test
    public void testRegistrarClienteSinCorreoOK(){
        System.out.println("registrarClienteSinCorreoOK");
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
            "Jefferson",
            "Gutierritos",
            "Gonzalez",
            "6441234567");
        clienteGuardado = clientesDAO.registrarCliente(nuevoCliente);
        assertNotNull(clienteGuardado);
        assertEquals(nuevoCliente.getNombre(), clienteGuardado.getNombre());
        assertEquals(nuevoCliente.getApellidoPaterno(), clienteGuardado.getApellidoPaterno());
        assertEquals(nuevoCliente.getApellidoMaterno(), clienteGuardado.getApellidoMaterno());
        assertEquals(nuevoCliente.getTelefono(), clienteGuardado.getTelefono());
        assertNull(clienteGuardado.getCorreo());
        assertEquals(0, clienteGuardado.getPuntos());
        assertNotNull(clienteGuardado.getFechaRegistro());
    }
    
    @Test
    public void testRegistrarClienteSinNombre(){
        System.out.println("registrarClienteSinNombre");
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
            null,
            null,
            null,
            "6441231231");
        assertThrows(Exception.class, ()-> clientesDAO.registrarCliente(nuevoCliente));
    }
    
    @Test
    public void testRegistrarClienteSinTelefono(){
        System.out.println("registrarClienteSinTelefono");
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
            "Jefferson",
            "Gutierritos",
            "Gonzalez",
            null);
        assertThrows(Exception.class, ()-> clientesDAO.registrarCliente(nuevoCliente));
    }

    @Test
    public void testBuscarClientesPorTelefono(){
        System.out.println("buscarClientesPorTelefono");
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
            "Jefferson",
            "Gutierritos",
            "Gonzalez",
            "6441231231");
        clienteGuardado = clientesDAO.registrarCliente(nuevoCliente);
        assertNotNull(clienteGuardado);

        List<ClienteDTO> clientes = clientesDAO.buscarClientesPorTelefono("6441231231");
        assertNotNull(clientes);
        int TAMAÑO_ESPERADO = 1;
        assertEquals(TAMAÑO_ESPERADO, clientes.size());
        assertEquals(clienteGuardado.getNombre(), clientes.get(0).getNombre());
        assertEquals(clienteGuardado.getApellidoPaterno(), clientes.get(0).getApellidoPaterno());
        assertEquals(clienteGuardado.getApellidoMaterno(), clientes.get(0).getApellidoMaterno());
        assertEquals(clienteGuardado.getTelefono(), clientes.get(0).getTelefono());
        assertEquals(clienteGuardado.getCorreo(), clientes.get(0).getCorreo());
    }

    @Test
    public void testBuscarClientesPorNombre(){
        System.out.println("buscarClientesPorNombre");
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
            "Jefferson",
            "Gutierritos",
            "Gonzalez",
            "6441231231");
        clienteGuardado = clientesDAO.registrarCliente(nuevoCliente);
        assertNotNull(clienteGuardado);

        List<ClienteDTO> clientes = clientesDAO.buscarClientesPorNombre("Jefferson");
        assertEqualsCliente(clienteGuardado, clientes);
        
        clientes = clientesDAO.buscarClientesPorNombre("Jefferson Gutierritos Gonzalez");
        assertEqualsCliente(clienteGuardado, clientes);

        clientes = clientesDAO.buscarClientesPorNombre("Gutierritos G");
        assertEqualsCliente(clienteGuardado, clientes);
        
    }
    
    @Test
    public void testBuscarClientesPorCorreo(){
        System.out.println("buscarClientesPorCorreo");
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
            "Jefferson",
            "Gutierritos",
            "Gonzalez",
            "6441231231",
            "jeff.gutierrez@gmail.com");
        clienteGuardado = clientesDAO.registrarCliente(nuevoCliente);
        assertNotNull(clienteGuardado);

        List<ClienteDTO> clientes = clientesDAO.buscarClientesPorCorreo("jeff.gutierrez@gmail.com");
        assertEqualsCliente(clienteGuardado, clientes);

        clientes = clientesDAO.buscarClientesPorCorreo("jeff");
        assertEqualsCliente(clienteGuardado, clientes);
        
    }

    @Test
    public void testBuscarClientesPorNombreYCorreo(){
        System.out.println("buscarClientesPorNombreYCorreo");
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
            "Jefferson",
            "Gutierritos",
            "Gonzalez",
            "6441231231",
            "jeff.gutierrez@gmail.com");
        clienteGuardado = clientesDAO.registrarCliente(nuevoCliente);
        assertNotNull(clienteGuardado);

        List<ClienteDTO> clientes = clientesDAO.buscarClientesPorNombreYCorreo("Jefferson","jeff.gutierrez@gmail.com");
        assertEqualsCliente(clienteGuardado, clientes);
        clientes = clientesDAO.buscarClientesPorNombreYCorreo("Pedro","jeff.gutierrez@gmail.com");
        int TAMAÑO_ESPERADO = 0;
        assertEquals(TAMAÑO_ESPERADO, clientes.size());
    }

    @Test
    public void testBuscarClientesPorNombreYTelefono(){
        System.out.println("buscarClientesPorNombreYTelefono");
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
            "Jefferson",
            "Gutierritos",
            "Gonzalez",
            "6441231231",
            "jeff.gutierrez@gmail.com");
        clienteGuardado = clientesDAO.registrarCliente(nuevoCliente);
        assertNotNull(clienteGuardado);

        List<ClienteDTO> clientes = clientesDAO.buscarClientesPorNombreYTelefono("Jefferson","6441231231");
        assertEqualsCliente(clienteGuardado, clientes);
        clientes = clientesDAO.buscarClientesPorNombreYCorreo("Jefferson","6441231232");
        int TAMAÑO_ESPERADO = 0;
        assertEquals(TAMAÑO_ESPERADO, clientes.size());
        clientes = clientesDAO.buscarClientesPorNombreYTelefono("Pedro","6441231231");
        TAMAÑO_ESPERADO = 0;
        assertEquals(TAMAÑO_ESPERADO, clientes.size());
    }

    @Test
    public void testBuscarClientesPorTelefonoYCorreo(){
        System.out.println("BuscarClientesPorTelefonoYCorreo");
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
            "Jefferson",
            "Gutierritos",
            "Gonzalez",
            "6441231231",
            "jeff.gutierrez@gmail.com");
        clienteGuardado = clientesDAO.registrarCliente(nuevoCliente);
        assertNotNull(clienteGuardado);

        List<ClienteDTO> clientes = clientesDAO.buscarClientesPorTelefonoYCorreo("6441231231","jeff.gutierrez@gmail.com");
        assertEqualsCliente(clienteGuardado, clientes);
        clientes = clientesDAO.buscarClientesPorTelefonoYCorreo("6441231231", null);
        int TAMAÑO_ESPERADO = 0;
        assertEquals(TAMAÑO_ESPERADO, clientes.size());
        clientes = clientesDAO.buscarClientesPorTelefonoYCorreo("2234","jeff");
        TAMAÑO_ESPERADO = 0;
        assertEquals(TAMAÑO_ESPERADO, clientes.size());
    }

    @Test
    public void testBuscarClientesPorNombreTelefonoYCorreo(){
        System.out.println("BuscarClientesPorNombreTelefonoYCorreo");
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
            "Jefferson",
            "Gutierritos",
            "Gonzalez",
            "6441231231",
            "jeff.gutierrez@gmail.com");
        clienteGuardado = clientesDAO.registrarCliente(nuevoCliente);
        assertNotNull(clienteGuardado);

        List<ClienteDTO> clientes = clientesDAO.buscarClientesPorNombreTelefonoYCorreo("Jeff","6441231231","jeff.gutierrez@gmail.com");
        assertEqualsCliente(clienteGuardado, clientes);
        clientes = clientesDAO.buscarClientesPorNombreTelefonoYCorreo("Jefferson","6441231232", "jeff");
        int TAMAÑO_ESPERADO = 0;
        assertEquals(TAMAÑO_ESPERADO, clientes.size());
        clientes = clientesDAO.buscarClientesPorNombreTelefonoYCorreo("Peter","6441231231","jeff");
        TAMAÑO_ESPERADO = 0;
        assertEquals(TAMAÑO_ESPERADO, clientes.size());
    }

    /**
     * Metodo para hacer todos los asserts para comparar un cliente con otro.
     * @param cliente Cliente a comparar
     * @param clientes Lista obtenida, con un cliente.
     */
    private void assertEqualsCliente(Cliente cliente, List<ClienteDTO> clientes){
        assertNotNull(clientes);
        int TAMAÑO_ESPERADO = 1;
        assertEquals(TAMAÑO_ESPERADO, clientes.size());
        assertEquals(cliente.getNombre(), clientes.get(0).getNombre());
        assertEquals(cliente.getApellidoPaterno(), clientes.get(0).getApellidoPaterno());
        assertEquals(cliente.getApellidoMaterno(), clientes.get(0).getApellidoMaterno());
        assertEquals(cliente.getTelefono(), clientes.get(0).getTelefono());
        assertEquals(cliente.getCorreo(), clientes.get(0).getCorreo());
        assertEquals(cliente.getPuntos(), clientes.get(0).getPuntos()); 
    }

    @Test
    public void testAgregarPuntos() throws PersistenciaException{
        System.out.println("Agregar Puntos");
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
            "Jefferson",
            "Gutierritos",
            "Gonzalez",
            "6441231231",
            "jeff.gutierrez@gmail.com");
        clienteGuardado = clientesDAO.registrarCliente(nuevoCliente);

        final Integer PUNTOS_ACTUALES = 0;
        final Integer PUNTOS_NUEVOS = 15;
        assertNotNull(clienteGuardado);
        assertEquals(PUNTOS_ACTUALES, clienteGuardado.getPuntos());
        clientesDAO.agregarPuntos(clienteGuardado.getId(), 15);
        ClienteDTO cliente = clientesDAO.obtenerClientePorId(clienteGuardado.getId());
        assertNotNull(cliente);
        assertEquals(PUNTOS_NUEVOS, cliente.getPuntos());
        
    }
}
