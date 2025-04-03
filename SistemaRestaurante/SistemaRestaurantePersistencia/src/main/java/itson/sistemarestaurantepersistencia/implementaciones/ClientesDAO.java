package itson.sistemarestaurantepersistencia.implementaciones;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

    /**
     * Metodo para buscar clientes por nombre
     * @return lista de clientes encontrados
     */
    @Override
    public List<Cliente> buscarClientesPorNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarClientesPorNombre'");
    }

    /**
     * Metodo para buscar clientes por telefono
     * @return lista de clientes encontrados
     */
    @Override
    public List<Cliente> buscarClientesPorTelefono(String telefono) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("telefono"), "%"+telefono+"%"));
        TypedQuery<Cliente> clientes = entityManager.createQuery(criteriaQuery);
        List<Cliente> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }

    /**
     * Metodo para buscar clientes por correo
     * @return lista de clientes encontrados
     */
    @Override
    public List<Cliente> buscarClientesPorCorreo(String correo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarClientesPorCorreo'");
    }
    
}
