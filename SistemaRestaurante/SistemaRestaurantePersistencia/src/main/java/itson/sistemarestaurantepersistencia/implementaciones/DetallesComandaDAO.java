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
import itson.sistemarestaurantedominio.dtos.DetallesComandaDTO;
import itson.sistemarestaurantepersistencia.IDetallesComandaDAO;

/**
 * Clase que implementa la interfaz de IDetallesComandaDAO,
 * contiene un metodo para obtener los detalles de la comanda
 */
public class DetallesComandaDAO implements IDetallesComandaDAO {

    /**
     * Metodo para obtener una lista de detalles de una comanda específica
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
                rootDetalles.get("cantidad"),
                rootDetalles.get("comentario"),
                rootDetalles.get("precioUnitario"),
                rootDetalles.get("totalPorProducto"),
                rootDetalles.get("comanda").get("id"),
                rootDetalles.get("producto").get("id")
            )
        ).where(builder.equal(join.get("id"), idComanda));

        TypedQuery<DetallesComandaDTO> query = entityManager.createQuery(criteria);
        List<DetallesComandaDTO> detallesComanda = query.getResultList();  

        entityManager.getTransaction().commit();

        return detallesComanda;
        
    }
    
    

}
