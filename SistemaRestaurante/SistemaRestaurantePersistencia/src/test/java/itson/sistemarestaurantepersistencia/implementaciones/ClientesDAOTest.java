package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
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

        List<Cliente> clientes = clientesDAO.buscarClientesPorTelefono("6441231231");
        assertNotNull(clientes);
        int TAMAÑO_ESPERADO = 1;
        assertEquals(TAMAÑO_ESPERADO, clientes.size());
        assertEquals(clienteGuardado.getNombre(), clientes.get(0).getNombre());
        assertEquals(clienteGuardado.getApellidoPaterno(), clientes.get(0).getApellidoPaterno());
        assertEquals(clienteGuardado.getApellidoMaterno(), clientes.get(0).getApellidoMaterno());
        assertEquals(clienteGuardado.getTelefono(), clientes.get(0).getTelefono());
        assertEquals(clienteGuardado.getCorreo(), clientes.get(0).getCorreo());
        
    }
}
