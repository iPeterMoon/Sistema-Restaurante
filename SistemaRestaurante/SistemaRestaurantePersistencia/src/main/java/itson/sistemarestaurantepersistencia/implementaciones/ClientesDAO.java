package itson.sistemarestaurantepersistencia.implementaciones;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CompoundSelection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.ClienteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantepersistencia.IClientesDAO;

/**
 * Clase que implementa la interfaz IClientesDAO para la persistencia de los clientes en el sistema de restaurante.
 * Esta clase proporciona métodos para registrar nuevos clientes y buscar clientes por diferentes criterios.
 * @author Pc
 */
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
    public List<ClienteDTO> obtenerClientesFrecuentes() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        String jpqlQuery = """
            SELECT new 
            itson.sistemarestaurantedominio.dtos.ClienteDTO
            (c.id, c.nombre, c.apellidoPaterno, c.apellidoMaterno, c.correo, c.telefono, c.puntos, c.fechaRegistro)
             FROM Cliente c
        """;
        TypedQuery<ClienteDTO> query = entityManager.createQuery(jpqlQuery, ClienteDTO.class);
        List<ClienteDTO> clientes = query.getResultList();
        entityManager.close();
        return clientes;
    }

    /**
     * Metodo para buscar clientes por nombre
     * @return lista de clientes encontrados
     */
    @Override
    public List<ClienteDTO> buscarClientesPorNombre(String nombre) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteDTO> criteriaQuery = criteriaBuilder.createQuery(ClienteDTO.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
    
        // Concatenar nombre, apellido paterno y apellido materno
        criteriaQuery.select(
            getClienteDTOSelection(root, criteriaBuilder)
        ).where(
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
    
        TypedQuery<ClienteDTO> clientes = entityManager.createQuery(criteriaQuery);
        List<ClienteDTO> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }

    /**
     * Metodo para buscar clientes por telefono
     * @return lista de clientes encontrados
     */
    @Override
    public List<ClienteDTO> buscarClientesPorTelefono(String telefono) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteDTO> criteriaQuery = criteriaBuilder.createQuery(ClienteDTO.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
        criteriaQuery.select(
            getClienteDTOSelection(root, criteriaBuilder)
        ).where(criteriaBuilder.like(root.get("telefono"), "%"+telefono+"%"));
        TypedQuery<ClienteDTO> clientes = entityManager.createQuery(criteriaQuery);
        List<ClienteDTO> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }

    /**
     * Metodo para buscar clientes por correo
     * @return lista de clientes encontrados
     */
    @Override
    public List<ClienteDTO> buscarClientesPorCorreo(String correo) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteDTO> criteriaQuery = criteriaBuilder.createQuery(ClienteDTO.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
        criteriaQuery.select(
            getClienteDTOSelection(root, criteriaBuilder)
        ).where(criteriaBuilder.like(root.get("correo"), "%"+correo+"%"));
        TypedQuery<ClienteDTO> clientes = entityManager.createQuery(criteriaQuery);
        List<ClienteDTO> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }

    /**
     * Metodo para buscar clientes por nombre y telefono
     * @return lista de clientes encontrados
     */
    @Override
    public List<ClienteDTO> buscarClientesPorNombreYTelefono(String nombre, String telefono) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteDTO> criteriaQuery = criteriaBuilder.createQuery(ClienteDTO.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
    
        // Concatenar nombre, apellido paterno y apellido materno
        criteriaQuery.select(
            getClienteDTOSelection(root, criteriaBuilder)
        ).where(
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
    
        TypedQuery<ClienteDTO> clientes = entityManager.createQuery(criteriaQuery);
        List<ClienteDTO> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }

    /**
     * Metodo para buscar clientes por nombre y correo
     * @return lista de clientes encontrados
     */
    @Override
    public List<ClienteDTO> buscarClientesPorNombreYCorreo(String nombre, String correo) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteDTO> criteriaQuery = criteriaBuilder.createQuery(ClienteDTO.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
    
        // Concatenar nombre, apellido paterno y apellido materno
        criteriaQuery.select(
            getClienteDTOSelection(root, criteriaBuilder)
        ).where(
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
    
        TypedQuery<ClienteDTO> clientes = entityManager.createQuery(criteriaQuery);
        List<ClienteDTO> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }

    /**
     * Metodo para buscar clientes por telefono y correo
     * @return lista de clientes encontrados
     */
    @Override
    public List<ClienteDTO> buscarClientesPorTelefonoYCorreo(String telefono, String correo) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteDTO> criteriaQuery = criteriaBuilder.createQuery(ClienteDTO.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
        criteriaQuery.select(
            getClienteDTOSelection(root, criteriaBuilder)
        ).where(
            criteriaBuilder.and(
                criteriaBuilder.equal(root.get("telefono"), telefono),
                criteriaBuilder.like(root.get("correo"), "%"+correo+"%")
            )
        );
    
        TypedQuery<ClienteDTO> clientes = entityManager.createQuery(criteriaQuery);
        List<ClienteDTO> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }

    /**
     * Metodo para buscar clientes por nombre, telefono y correo
     * @return lista de clientes encontrados
     */
    @Override
    public List<ClienteDTO> buscarClientesPorNombreTelefonoYCorreo(String nombre, String telefono, String correo) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteDTO> criteriaQuery = criteriaBuilder.createQuery(ClienteDTO.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
    
        // Concatenar nombre, apellido paterno y apellido materno
        criteriaQuery.select(
            getClienteDTOSelection(root, criteriaBuilder)
        ).where(
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
    
        TypedQuery<ClienteDTO> clientes = entityManager.createQuery(criteriaQuery);
        List<ClienteDTO> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }
    
    /**
     * Metodo para obtener una seleccion de ClienteDTO
     * @param root Raiz de la consulta
     * @param criteriaBuilder Constructor de criterios
     * @return Seleccion de ClienteDTO
     */
    private CompoundSelection<ClienteDTO> getClienteDTOSelection(Root<Cliente> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.construct(
                ClienteDTO.class,
                root.get("id"),
                root.get("nombre"),
                root.get("apellidoPaterno"),
                root.get("apellidoMaterno"),
                root.get("correo"),
                root.get("telefono"),
                root.get("puntos"),
                root.get("fechaRegistro")
            );  
    }

    /**
     * Metodo que obtiene un cliente por su id
     * @param idCliente Id del cliente a buscar
     * @return ClienteDTO representando al cliente
     */
    @Override
    public ClienteDTO obtenerClientePorId(Long idCliente) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteDTO> criteria = builder.createQuery(ClienteDTO.class);
        Root<Cliente> root = criteria.from(Cliente.class);
        criteria.select(getClienteDTOSelection(root, builder)).where(builder.equal(root.get("id"), idCliente));
        TypedQuery<ClienteDTO> query = entityManager.createQuery(criteria);
        ClienteDTO cliente = query.getSingleResult();
        return cliente;
    }
}
