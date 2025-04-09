package itson.sistemarestaurantepersistencia.implementaciones;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.DetallesComanda;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.DetallesComandaDTO;
import itson.sistemarestaurantepersistencia.IDetallesComandaDAO;

/**
 * Clase que implementa la interfaz de IDetallesComandaDAO,
 * contiene un metodo para obtener los detalles de la comanda
 */
public class DetallesComandaDAO implements IDetallesComandaDAO {

    /**
     * Metodo para obtener una lista de detalles de una comanda específica
     * 
     * @param idComanda Id de la comanda a obtener
     * @return Lista con los detalles de la comanda
     */
    @Override
    public List<DetallesComandaDTO> obtenerDetallesComanda(Long idComanda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DetallesComandaDTO> criteria = builder.createQuery(DetallesComandaDTO.class);
        Root<DetallesComanda> rootDetalles = criteria.from(DetallesComanda.class);

        Join<DetallesComanda, Comanda> join = rootDetalles.join("comanda");

        criteria.select(
                builder.construct(
                        DetallesComandaDTO.class,
                        rootDetalles.get("id"),
                        rootDetalles.get("cantidad"),
                        rootDetalles.get("comentario"),
                        rootDetalles.get("precioUnitario"),
                        rootDetalles.get("totalPorProducto"),
                        rootDetalles.get("comanda").get("id"),
                        rootDetalles.get("producto").get("id")))
                .where(builder.equal(join.get("id"), idComanda));

        TypedQuery<DetallesComandaDTO> query = entityManager.createQuery(criteria);
        List<DetallesComandaDTO> detallesComanda = query.getResultList();

        entityManager.getTransaction().commit();

        return detallesComanda;

    }

    /**
     * Metodo para guardar detalles de una comanda ya existente
     * 
     * @param detalle Detalle de la comanda a guardar
     * @return DetallesComanda guardada
     */
    @Override
    public DetallesComanda guardarDetallesComanda(DetallesComandaDTO detalle) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        DetallesComanda detallesComanda = new DetallesComanda();
        Comanda comanda = entityManager.find(Comanda.class, detalle.getIdComanda());
        Producto producto = entityManager.find(Producto.class, detalle.getIdProducto());
        detallesComanda.setCantidad(detalle.getCantidad());
        detallesComanda.setComentario(detalle.getComentario());
        detallesComanda.setPrecioUnitario(detalle.getPrecioUnitario());
        detallesComanda.setTotalPorProducto(detalle.getTotalPorProducto());
        detallesComanda.setComanda(comanda);
        detallesComanda.setProducto(producto);
        entityManager.persist(detallesComanda);
        entityManager.getTransaction().commit();

        return detallesComanda;
    }

    /**
     * Metodo para eliminar un detalle de una comanda
     * 
     * @param idDetallesComanda Id del detalle a eliminar||
     */
    @Override
    public void eliminarDetallesComanda(Long idDetallesComanda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        DetallesComanda detalle = entityManager.find(DetallesComanda.class, idDetallesComanda);
        if(detalle != null){
            entityManager.remove(detalle);
        }
        entityManager.getTransaction().commit();
    }

}
