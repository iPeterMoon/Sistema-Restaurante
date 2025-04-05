package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.dtos.MesaDTO;
import itson.sistemarestaurantedominio.dtos.NuevaMesaDTO;
import itson.sistemarestaurantepersistencia.IMesasDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author pc
 */
public class MesasDAO implements IMesasDAO{

    /**
     * Registra una nuevaMesa con un numero dado
     * @param nuevaMesa Objeto con el numero de la mesa dado
     * @return la entidad de la Mesa
     */
    @Override
    public Mesa registrarMesa(NuevaMesaDTO nuevaMesa) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        entityManager.getTransaction().begin();
        
        Mesa mesa = new Mesa();
        mesa.setNumeroMesa(nuevaMesa.getNumeroMesa());
        entityManager.persist(mesa);
        
        entityManager.getTransaction().commit();
        
        return mesa;
    }

    /**
     * Metodo para obtener el numero de mesas disponibles en la bd
     * @return el numero de mesas disponibles
     */
    @Override
    public Long obtenerNumMesas() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        
        String jpql = "Select COUNT(m.id) FROM Mesa m";
        Query query = entityManager.createQuery(jpql);
        Long numeroMesas = (Long) query.getSingleResult();
        
        entityManager.getTransaction().commit();
        return numeroMesas;
    }

    @Override
    public List<MesaDTO> obtenerMesasDisponibles() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        String jpql = "SELECT new itson.sistemarestaurantedominio.dtos.MesaDTO(m.id, m.numeroMesa) FROM Mesa m";
        Query query = entityManager.createQuery(jpql, MesaDTO.class);
        List<MesaDTO> mesas = query.getResultList();
        entityManager.getTransaction().commit();
        return mesas;
        
    }
    
}
