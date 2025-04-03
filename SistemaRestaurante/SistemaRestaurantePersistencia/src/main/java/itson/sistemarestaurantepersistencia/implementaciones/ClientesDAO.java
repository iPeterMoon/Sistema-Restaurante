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
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
    
        // Concatenar nombre, apellido paterno y apellido materno
        criteriaQuery.select(root).where(
            criteriaBuilder.like(
                criteriaBuilder.concat(
                    criteriaBuilder.concat(
                        criteriaBuilder.concat(root.get("nombre"), " "),
                        criteriaBuilder.concat(root.get("apellidoPaterno"), " ")
                    ),
                    root.get("apellidoMaterno")
                ),
                "%" + nombre + "%"
            )
        );
    
        TypedQuery<Cliente> clientes = entityManager.createQuery(criteriaQuery);
        List<Cliente> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
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
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("correo"), "%"+correo+"%"));
        TypedQuery<Cliente> clientes = entityManager.createQuery(criteriaQuery);
        List<Cliente> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }

    /**
     * Metodo para buscar clientes por nombre y telefono
     * @return lista de clientes encontrados
     */
    @Override
    public List<Cliente> buscarClientesPorNombreYTelefono(String nombre, String telefono) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
    
        // Concatenar nombre, apellido paterno y apellido materno
        criteriaQuery.select(root).where(
            criteriaBuilder.and(
                criteriaBuilder.like(
                    criteriaBuilder.concat(
                        criteriaBuilder.concat(
                            criteriaBuilder.concat(root.get("nombre"), " "),
                            criteriaBuilder.concat(root.get("apellidoPaterno"), " ")
                        ),
                        root.get("apellidoMaterno")
                    ),
                    "%" + nombre + "%"
                ),
                criteriaBuilder.equal(root.get("telefono"), telefono)
            )
        );
    
        TypedQuery<Cliente> clientes = entityManager.createQuery(criteriaQuery);
        List<Cliente> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }

    /**
     * Metodo para buscar clientes por nombre y correo
     * @return lista de clientes encontrados
     */
    @Override
    public List<Cliente> buscarClientesPorNombreYCorreo(String nombre, String correo) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
    
        // Concatenar nombre, apellido paterno y apellido materno
        criteriaQuery.select(root).where(
            criteriaBuilder.and(
                criteriaBuilder.like(
                    criteriaBuilder.concat(
                        criteriaBuilder.concat(
                            criteriaBuilder.concat(root.get("nombre"), " "),
                            criteriaBuilder.concat(root.get("apellidoPaterno"), " ")
                        ),
                        root.get("apellidoMaterno")
                    ),
                    "%" + nombre + "%"
                ),
                criteriaBuilder.like(root.get("correo"), "%"+correo+"%")
            )
        );
    
        TypedQuery<Cliente> clientes = entityManager.createQuery(criteriaQuery);
        List<Cliente> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }

    /**
     * Metodo para buscar clientes por telefono y correo
     * @return lista de clientes encontrados
     */
    @Override
    public List<Cliente> buscarClientesPorTelefonoYCorreo(String telefono, String correo) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
        criteriaQuery.select(root).where(
            criteriaBuilder.and(
                criteriaBuilder.equal(root.get("telefono"), telefono),
                criteriaBuilder.like(root.get("correo"), "%"+correo+"%")
            )
        );
    
        TypedQuery<Cliente> clientes = entityManager.createQuery(criteriaQuery);
        List<Cliente> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }

    /**
     * Metodo para buscar clientes por nombre, telefono y correo
     * @return lista de clientes encontrados
     */
    @Override
    public List<Cliente> buscarClientesPorNombreTelefonoYCorreo(String nombre, String telefono, String correo) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
    
        // Concatenar nombre, apellido paterno y apellido materno
        criteriaQuery.select(root).where(
            criteriaBuilder.and(
                criteriaBuilder.like(
                    criteriaBuilder.concat(
                        criteriaBuilder.concat(
                            criteriaBuilder.concat(root.get("nombre"), " "),
                            criteriaBuilder.concat(root.get("apellidoPaterno"), " ")
                        ),
                        root.get("apellidoMaterno")
                    ),
                    "%" + nombre + "%"
                ),
                criteriaBuilder.and(
                    criteriaBuilder.equal(root.get("telefono"), telefono),
                    criteriaBuilder.like(root.get("correo"), "%"+correo+"%")
                )
            )
        );
    
        TypedQuery<Cliente> clientes = entityManager.createQuery(criteriaQuery);
        List<Cliente> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }
    
}
