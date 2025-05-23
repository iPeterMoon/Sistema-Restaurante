package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.IngredienteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantepersistencia.IIngredientesDAO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Clase que implementa la interfaz IIngredientesDAO y proporciona
 * implementaciones para los métodos de persistencia de ingredientes en el
 *
 * @author PC
 */
public class IngredientesDAO implements IIngredientesDAO {

    /**
     * Metodo para agregar un nuevo ingrediente a la base de dats
     *
     * @param nuevoIngrediente Nuevo ingrediente a agregar
     * @return Ingrediente agregado en la base de datos
     */
    @Override
    public Ingrediente agregarIngrediente(NuevoIngredienteDTO nuevoIngrediente) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        Ingrediente ingrediente = new Ingrediente(nuevoIngrediente.getNombre(),
                nuevoIngrediente.getUnidadMedida(), nuevoIngrediente.getStock());
        entityManager.persist(ingrediente);
        entityManager.getTransaction().commit();
        return ingrediente;
    }

    /**
     * Metodo para obtener toda la lista de ingredientes de la base de datos
     * (Hecho con CriteriaQuery)
     *
     * @return Lista con todos los ingredientes de la base de datos
     */
    @Override
    public List<Ingrediente> obtenerIngredientes() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingrediente> criteria = builder.createQuery(Ingrediente.class);
        Root<Ingrediente> entidadIngrediente = criteria.from(Ingrediente.class);
        criteria.select(entidadIngrediente);
        TypedQuery<Ingrediente> query = entityManager.createQuery(criteria);
        List<Ingrediente> ingredientes = query.getResultList();
        return ingredientes;
    }

    /**
     * Metodo para obtener una lista con todos los ingredientes de la base de
     * datos que coincidan con el filtro de buscqueda
     *
     * @param filtroBusqueda Filtro para buscar los ingredientes
     * @return Lista con los ingredientes coincidentes con el filtro
     */
    @Override
    public List<Ingrediente> obtenerIngrediente(String filtroBusqueda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingrediente> criteria = builder.createQuery(Ingrediente.class);
        Root<Ingrediente> entidadIngrediente = criteria.from(Ingrediente.class);

        Predicate busquedaPorUnidadMedida = builder.like(entidadIngrediente.get("unidadMedida"),
                "%" + filtroBusqueda + "%");
        Predicate busquedaPorNombre = builder.like(entidadIngrediente.get("nombre"), "%" + filtroBusqueda + "%");

        criteria.select(entidadIngrediente).where(
                builder.or(busquedaPorNombre, busquedaPorUnidadMedida));
        TypedQuery<Ingrediente> query = entityManager.createQuery(criteria);
        List<Ingrediente> ingredientes = query.getResultList();
        return ingredientes;
    }

    /**
     * Metodo para obtener una lista con todos los ingredientes de la base de
     * datos que coinciden con ambos filtros de busqueda
     *
     * @param filtroNombre Filtro que busca el ingrediente por nombre
     * @param filtroUnidad Filtro que busca el ingrediente por unidad de medida
     * @return Lista con los ingredientes que coinciden con ambos filtros
     */
    @Override
    public List<Ingrediente> obtenerIngrediente(String filtroNombre, String filtroUnidad) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingrediente> criteria = builder.createQuery(Ingrediente.class);
        Root<Ingrediente> entidadIngrediente = criteria.from(Ingrediente.class);

        Predicate busquedaPorUnidadMedida = builder.like(entidadIngrediente.get("unidadMedida"), "%" + filtroUnidad + "%");
        Predicate busquedaPorNombre = builder.like(entidadIngrediente.get("nombre"), "%" + filtroNombre + "%");

        criteria.select(entidadIngrediente).where(
                builder.or(busquedaPorNombre, busquedaPorUnidadMedida));
        TypedQuery<Ingrediente> query = entityManager.createQuery(criteria);
        List<Ingrediente> ingredientes = query.getResultList();
        return ingredientes;
    }

    /**
     * Metodo para obtener una lista con todos los ingredientes de la base de
     * datos y convertirlos a DTO
     *
     * @return Lista con todos los ingredientes en formato DTO
     */
    @Override
    public List<IngredienteDTO> obtenerIngredientesDTO() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        String jpql = """
        SELECT new itson.sistemarestaurantedominio.dtos.IngredienteDTO(
          i.id, i.nombre, i.unidadMedida, i.stock)
        FROM Ingrediente i
        """;
        TypedQuery<IngredienteDTO> query = entityManager.createQuery(jpql, IngredienteDTO.class);
        List<IngredienteDTO> ingredientesDTO = query.getResultList();
        entityManager.getTransaction().commit();
        return ingredientesDTO;
    }

    /**
     * Metodo para obtener una lista con todos los ingredientes de la base de
     * datos que coincidan con el filtro de busqueda y convertirlos a DTO
     *
     * @param filtroBusqueda Filtro para buscar los ingredientes
     * @return Lista con los ingredientes coincidentes con el filtro en formato
     * DTO
     */
    @Override
    public List<IngredienteDTO> obtenerIngredientesDTO(String filtroBusqueda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        String jpql = """
        SELECT new itson.sistemarestaurantedominio.dtos.IngredienteDTO(
          i.id, i.nombre, i.unidadMedida, i.stock)
        FROM Ingrediente i
        WHERE
          i.nombre LIKE :filtroBusqueda OR
          i.unidadMedida LIKE :filtroBusqueda
        """;
        TypedQuery<IngredienteDTO> query = entityManager.createQuery(jpql, IngredienteDTO.class);
        query.setParameter("filtroBusqueda", "%" + filtroBusqueda + "%");
        List<IngredienteDTO> ingredientesDTO = query.getResultList();
        entityManager.getTransaction().commit();
        return ingredientesDTO;
    }

    /**
     * Metodo para obtener una lista con todos los ingredientes de la base de
     * datos que coincidan con ambos filtros de busqueda y convertirlos a DTO
     *
     * @param filtroNombre Filtro que busca el ingrediente por nombre
     * @param filtroUnidad Filtro que busca el ingrediente por unidad de medida
     * @return Lista con todos los ingredientes coincidentes con ambos filtros
     * en formato DTO
     */
    @Override
    public List<IngredienteDTO> obtenerIngredientesDTO(String filtroNombre, String filtroUnidad) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        String jpql = """
        SELECT new itson.sistemarestaurantedominio.dtos.IngredienteDTO(
          i.id, i.nombre, i.unidadMedida, i.stock)
        FROM Ingrediente i
        WHERE
          i.nombre LIKE :filtroNombre AND
          i.unidadMedida LIKE :filtroUnidad
        """;
        TypedQuery<IngredienteDTO> query = entityManager.createQuery(jpql, IngredienteDTO.class);
        query.setParameter("filtroNombre", "%" + filtroNombre + "%");
        query.setParameter("filtroUnidad", "%" + filtroUnidad + "%");
        List<IngredienteDTO> ingredientesDTO = query.getResultList();
        entityManager.getTransaction().commit();
        return ingredientesDTO;
    }

    /**
     * Metodo que verifica si existe un ingrediente con el mismo nombre y unidad
     * de medida
     *
     * @param nuevoIngrediente Ingrediente a verificar
     * @return True o False dependiendo si existe un ingrediente con el mismo
     * nombre y unidad de medida o no
     */
    @Override
    public boolean existeIngredienteYUnidad(NuevoIngredienteDTO nuevoIngrediente) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        boolean existeIngrediente = entityManager.createQuery(
                "SELECT COUNT(i) FROM Ingrediente i WHERE i.nombre = :nombre AND i.unidadMedida = :unidadMedida", Long.class)
                .setParameter("nombre", nuevoIngrediente.getNombre())
                .setParameter("unidadMedida", nuevoIngrediente.getUnidadMedida())
                .getSingleResult() > 0;
        return existeIngrediente;
    }

    /**
     * Metodo para obtener un ingrediente de la base de datos por su id y
     * convertirlo a DTO
     *
     * @param idIngrediente Id del ingrediente a buscar
     * @return IngredienteDTO con el ingrediente encontrado o null si no se
     * encuentra
     */
    @Override
    public IngredienteDTO obtenerIngredientePorId(Long idIngrediente) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        IngredienteDTO ingredienteDTO = null;
        Ingrediente ingrediente = entityManager.find(Ingrediente.class, idIngrediente);
        if (ingrediente != null) {
            ingredienteDTO = new IngredienteDTO(
                    ingrediente.getId(),
                    ingrediente.getNombre(),
                    ingrediente.getUnidadMedida(),
                    ingrediente.getStock()
            );
        }
        return ingredienteDTO;
    }

    /**
     * Metodo para agregar al stock de un ingrediente
     *
     * @param idIngrediente ID del ingrediente a modificar
     * @param stock Stock a agregarle al ingrediente
     */
    @Override
    public void agregarStock(Long idIngrediente, Integer stock) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        Ingrediente ingrediente = entityManager.find(Ingrediente.class, idIngrediente);
        if (ingrediente != null) {
            Integer stockGuardado = ingrediente.getStock();
            Integer nuevoStock = stockGuardado + stock;

            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaUpdate<Ingrediente> criteriaUpdate = builder.createCriteriaUpdate(Ingrediente.class);
            Root<Ingrediente> rootUpdate = criteriaUpdate.from(Ingrediente.class);
            criteriaUpdate.set("stock", nuevoStock);
            criteriaUpdate.where(builder.equal(rootUpdate.get("id"), idIngrediente));
            Query update = entityManager.createQuery(criteriaUpdate);
            update.executeUpdate();
        }

        entityManager.getTransaction().commit();
    }

    /**
     * Metodo para quitarle al stock de un ingrediente
     *
     * @param idIngrediente ID del ingrediente a modificar
     * @param stock Stock a eliminar
     * @throws PersistenciaException Si ocurre una excepcion al quitar el stock
     * de un ingrediente en la base de datos
     */
    @Override
    public void quitarStock(Long idIngrediente, Integer stock) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        Ingrediente ingrediente = entityManager.find(Ingrediente.class, idIngrediente);
        if (ingrediente == null) {
            throw new PersistenciaException("No se pudo encontrar el ingrediente");
        }
        Integer stockGuardado = ingrediente.getStock();
        Integer nuevoStock = stockGuardado - stock;

        if (nuevoStock < 0) {
            throw new PersistenciaException("El stock a eliminar no puede ser mayor al actual");
        }
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Ingrediente> criteriaUpdate = builder.createCriteriaUpdate(Ingrediente.class);
        Root<Ingrediente> rootUpdate = criteriaUpdate.from(Ingrediente.class);
        criteriaUpdate.set("stock", nuevoStock);
        criteriaUpdate.where(builder.equal(rootUpdate.get("id"), idIngrediente));
        Query update = entityManager.createQuery(criteriaUpdate);
        update.executeUpdate();

        entityManager.getTransaction().commit();
    }

}
