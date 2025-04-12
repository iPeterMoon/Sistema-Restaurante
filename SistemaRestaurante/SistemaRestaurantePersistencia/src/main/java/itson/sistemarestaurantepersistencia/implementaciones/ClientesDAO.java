package itson.sistemarestaurantepersistencia.implementaciones;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CompoundSelection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.ClienteDTO;
import itson.sistemarestaurantedominio.dtos.ClienteFrecuenteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantepersistencia.IClientesDAO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;

/**
 * Clase que implementa la interfaz IClientesDAO para la persistencia de los
 * clientes en el sistema de restaurante. Esta clase proporciona métodos para
 * registrar nuevos clientes y buscar clientes por diferentes criterios.
 *
 * @author Pc
 */
public class ClientesDAO implements IClientesDAO {

    /**
     * Metodo para registrar un nuevo cliente en la base de datos
     *
     * @param nuevoCliente Cliente a agregar en la base de datos
     * @return Cliente agregado en la base de datos
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
        if (nuevoCliente.getCorreo() != null) {
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
     *
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
     * Metodo que se encarga de buscar los clientes por su nombre en la base de
     * datos
     *
     * @param nombre Nombre de los clientes a buscar en la base de datos
     * @return Lista con los clientes que coincidan con el nombre en la base de
     * datos
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
     * Metodo que se encarga de buscar los clietnes por su numero de telefono en
     * la base de datos
     *
     * @param telefono Numero de telefono de los clientes a buscar en la base de
     * datos
     * @return Lista con los clientes que coincidadn con el numero de telefono
     * en la base de datos
     */
    @Override
    public List<ClienteDTO> buscarClientesPorTelefono(String telefono) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteDTO> criteriaQuery = criteriaBuilder.createQuery(ClienteDTO.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
        criteriaQuery.select(
                getClienteDTOSelection(root, criteriaBuilder)
        ).where(criteriaBuilder.like(root.get("telefono"), "%" + telefono + "%"));
        TypedQuery<ClienteDTO> clientes = entityManager.createQuery(criteriaQuery);
        List<ClienteDTO> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }

    /**
     * Metodo que se encarga de buscar los clientes por su correo en la base de
     * datos
     *
     * @param correo Correo de los clientes a buscar en la base de datos
     * @return Lista con los clientes que coinciden con el correo en la base de
     * datos
     */
    @Override
    public List<ClienteDTO> buscarClientesPorCorreo(String correo) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteDTO> criteriaQuery = criteriaBuilder.createQuery(ClienteDTO.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
        criteriaQuery.select(
                getClienteDTOSelection(root, criteriaBuilder)
        ).where(criteriaBuilder.like(root.get("correo"), "%" + correo + "%"));
        TypedQuery<ClienteDTO> clientes = entityManager.createQuery(criteriaQuery);
        List<ClienteDTO> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }

    /**
     * Metodo que se encarga de buscar los clietnes por su nombre y por su
     * telefono en la base de datos
     *
     * @param nombre Nomrbe del cliente
     * @param telefono Numero de telefono del cliente
     * @return Lista con todos los clientes que coincidan con ambos campos en la
     * base de datos
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
     * Metodo que se encarga de buscar los clientes por su nombre y su correo en
     * la base de datos
     *
     * @param nombre Nombre del cliente
     * @param correo Correo del cliente
     * @return Lista con todos los clientes que coincidan con ambos campos en la
     * base de datos
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
                        criteriaBuilder.like(root.get("correo"), "%" + correo + "%")
                )
        );

        TypedQuery<ClienteDTO> clientes = entityManager.createQuery(criteriaQuery);
        List<ClienteDTO> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }

    /**
     * Metodo que se encarga de buscar los clientes por su telefono y su correo
     * en la base de datos
     *
     * @param telefono Numero de telefono del cliente
     * @param correo Correo del cliente
     * @return Lista con todos los clientes que coincidan con ambos campos en la
     * base de datos
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
                        criteriaBuilder.like(root.get("correo"), "%" + correo + "%")
                )
        );

        TypedQuery<ClienteDTO> clientes = entityManager.createQuery(criteriaQuery);
        List<ClienteDTO> listaClientes = clientes.getResultList();
        entityManager.close();
        return listaClientes;
    }

    /**
     * Metodo que se encarga de obtener los clientes por su nombre, telefono y
     * correo en la base de datos
     *
     * @param nombre Nombre del cliente
     * @param telefono Numero de telefono del cliente
     * @param correo Correo del cliente
     * @return Lista con todos los clientes que coincidan con los tres campos de
     * la base de datos
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
                                criteriaBuilder.like(root.get("correo"), "%" + correo + "%")
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
     *
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
     *
     * @param idCliente Id del cliente a buscar
     * @return ClienteDTO representando al cliente
     */
    @Override
    public ClienteDTO obtenerClientePorId(Long idCliente) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        Cliente cliente = entityManager.find(Cliente.class, idCliente);
        ClienteDTO clienteDTO = null;
        if (cliente != null) {
            clienteDTO = new ClienteDTO(
                    idCliente,
                    cliente.getNombre(),
                    cliente.getApellidoPaterno(),
                    cliente.getApellidoMaterno(),
                    cliente.getCorreo(),
                    cliente.getTelefono(),
                    cliente.getPuntos(),
                    cliente.getFechaRegistro()
            );
        }

        return clienteDTO;
    }

    /**
     * Metodo para agregarle puntos a un cliente
     *
     * @param idCliente Id del cliente a agregarle puntos
     * @param puntos Puntos a agregar
     * @throws PersistenciaException Si ocurre un error al agregar los puntos
     * del cliente en la base de datos
     */
    @Override
    public void agregarPuntos(Long idCliente, Integer puntos) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        Cliente cliente = entityManager.find(Cliente.class, idCliente);
        if (cliente == null) {
            throw new PersistenciaException("No se pudo encontrar al cliente para sumarle puntos");
        }
        Integer puntosActuales = cliente.getPuntos();
        Integer puntosNuevos = puntosActuales + puntos;

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Cliente> update = builder.createCriteriaUpdate(Cliente.class);
        Root<Cliente> root = update.from(Cliente.class);
        update.set("puntos", puntosNuevos);
        update.where(builder.equal(root.get("id"), idCliente));
        Query query = entityManager.createQuery(update);
        query.executeUpdate();

        entityManager.getTransaction().commit();
    }

    /**
     * Metodo que permite obtener los clientes frecuentes y su informacion.
     *
     * @return Lista de todos los clietnes frecuentes y su informacion.
     */
    @Override
    public List<ClienteFrecuenteDTO> obtenerClientesFrecuentesReporte() {
        EntityManager em = ManejadorConexiones.getEntityManager();

        String jpql = """
        SELECT new itson.sistemarestaurantedominio.dtos.ClienteFrecuenteDTO(
                        CONCAT(
                            COALESCE(c.nombre, ''),
                            ' ',
                            COALESCE(c.apellidoPaterno, ''),
                            ' ',
                            COALESCE(c.apellidoMaterno, '')
                        ),
                        COUNT(cm),
                        SUM(cm.totalVenta),
                        c.puntos,
                        MAX(cm.fechaHora)
                    )
        FROM Cliente c
        JOIN c.comandas cm
        GROUP BY c
        HAVING COUNT(cm) >= 0
        """;

        TypedQuery<ClienteFrecuenteDTO> query = em.createQuery(jpql, ClienteFrecuenteDTO.class);
        List<ClienteFrecuenteDTO> resultado = query.getResultList();
        em.close();
        return resultado;
    }

    /**
     * Metodo que permite obtener los clientes frecuentes y su informacion de
     * base a un filtro de busqueda
     *
     * @param filtroVisitasMinimas Filtro de visitas minimas
     * @return Lista con todos los clientes frecuentes y su informacion de
     * manera filtrada por un campo
     */
    @Override
    public List<ClienteFrecuenteDTO> obtenerClientesFrecuentesReporte(Integer filtroVisitasMinimas) {
        EntityManager em = ManejadorConexiones.getEntityManager();

        String jpql = """
        SELECT new itson.sistemarestaurantedominio.dtos.ClienteFrecuenteDTO(
                        CONCAT(
                            COALESCE(c.nombre, ''),
                            ' ',
                            COALESCE(c.apellidoPaterno, ''),
                            ' ',
                            COALESCE(c.apellidoMaterno, '')
                        ),
                        COUNT(cm),
                        SUM(cm.totalVenta),
                        c.puntos,
                        MAX(cm.fechaHora)
                    )
        FROM Cliente c
        JOIN c.comandas cm
        GROUP BY c
        HAVING COUNT(cm) >= :filtroVisitasMinimas
        """;

        TypedQuery<ClienteFrecuenteDTO> query = em.createQuery(jpql, ClienteFrecuenteDTO.class);
        query.setParameter("filtroVisitasMinimas", filtroVisitasMinimas);
        List<ClienteFrecuenteDTO> resultado = query.getResultList();
        em.close();
        return resultado;
    }

    /**
     * Metodo que permite obtener los clientes frecuentes y su informacion de
     * base a un filtro de busqueda
     *
     * @param filtroNombre Filtro de nombre
     * @return Lista con todos los clientes frecuentes y su informacion de
     * manera filtrada por un campo
     */
    @Override
    public List<ClienteFrecuenteDTO> obtenerClientesFrecuentesReporte(String filtroNombre) {
        EntityManager em = ManejadorConexiones.getEntityManager();

        String jpql = """
        SELECT new itson.sistemarestaurantedominio.dtos.ClienteFrecuenteDTO(
                        CONCAT(
                            COALESCE(c.nombre, ''), 
                            ' ', 
                            COALESCE(c.apellidoPaterno, ''), 
                            ' ', 
                            COALESCE(c.apellidoMaterno, '')
                        ),
                        COUNT(cm),
                        SUM(cm.totalVenta),
                        c.puntos,
                        MAX(cm.fechaHora)
                    )
        FROM Cliente c
        JOIN c.comandas cm
        WHERE CONCAT(c.nombre, ' ', c.apellidoPaterno, ' ', c.apellidoMaterno) LIKE :filtroNombre
        GROUP BY c
        HAVING COUNT(cm) >= 0
        """;

        TypedQuery<ClienteFrecuenteDTO> query = em.createQuery(jpql, ClienteFrecuenteDTO.class);
        query.setParameter("filtroNombre", "%" + filtroNombre + "%");

        List<ClienteFrecuenteDTO> resultado = query.getResultList();
        em.close();
        return resultado;
    }

    /**
     * Metodo que permite obtener los clientes frecuentes y su informacion en
     * base a dos filtros de busqueda.
     *
     * @param filtroNombre Filtro del nombre del cliente
     * @param filtroVisitasMinimas Flitro de las visitas minimas de los clientes
     * @return Lista con todos los clientes frecuentes y su informacion de
     * manera filtrada por dos campos
     */
    @Override
    public List<ClienteFrecuenteDTO> obtenerClientesFrecuentesReporte(String filtroNombre, Integer filtroVisitasMinimas) {
        EntityManager em = ManejadorConexiones.getEntityManager();

        String jpql = """
        SELECT new itson.sistemarestaurantedominio.dtos.ClienteFrecuenteDTO(
                        CONCAT(
                            COALESCE(c.nombre, ''), 
                            ' ', 
                            COALESCE(c.apellidoPaterno, ''), 
                            ' ', 
                            COALESCE(c.apellidoMaterno, '')
                        ),
                        COUNT(cm),
                        SUM(cm.totalVenta),
                        c.puntos,
                        MAX(cm.fechaHora)
                    )
        FROM Cliente c
        JOIN c.comandas cm
        WHERE 1 = 1
        AND (CONCAT(c.nombre, ' ', c.apellidoPaterno, ' ', c.apellidoMaterno) LIKE :filtroNombre)
        GROUP BY c
        HAVING COUNT(cm) >= :filtroVisitasMinimas
        """;

        TypedQuery<ClienteFrecuenteDTO> query = em.createQuery(jpql, ClienteFrecuenteDTO.class);
        query.setParameter("filtroNombre", "%" + filtroNombre + "%");
        query.setParameter("filtroVisitasMinimas", filtroVisitasMinimas);

        List<ClienteFrecuenteDTO> resultado = query.getResultList();
        em.close();
        return resultado;
    }
}
