package itson.sistemarestaurantepersistencia.implementaciones;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantepersistencia.IClientesDAO;

public class ClientesDAO implements IClientesDAO {

    /**
     * Metodo para registrar un cliente en la base de datos
     * @param nuevoCliente cliente a registrar
     */
    @Override
    public Cliente registrarCliente(NuevoClienteDTO nuevoCliente) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        entityManager.getTransaction().begin();

        Cliente cliente = new Cliente();
        cliente.setNombre(nuevoCliente.getNombre());
        cliente.setApellidoPaterno(nuevoCliente.getApellidoPaterno());
        cliente.setApellidoMaterno(nuevoCliente.getApellidoMaterno());
        cliente.setTelefono(nuevoCliente.getTelefono());
        if(nuevoCliente.getCorreo() != null){
            cliente.setCorreo(nuevoCliente.getCorreo());
        }
        cliente.setFechaRegistro(new GregorianCalendar());
        cliente.setPuntos(0);

        entityManager.persist(cliente);

        entityManager.getTransaction().commit();

        return cliente;
    }

    /**
     * Metodo para obtener los clientes registrados en la bd
     * @return lista de clientes registrados
     */
    @Override
    public List<Cliente> obtenerClientesFrecuentes() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        String jpqlQuery = "SELECT c FROM Cliente c";
        TypedQuery<Cliente> query = entityManager.createQuery(jpqlQuery, Cliente.class);
        List<Cliente> clientes = query.getResultList();
        entityManager.close();
        return clientes;
    }
    
}
