package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.dtos.MesaDTO;
import itson.sistemarestaurantedominio.dtos.NuevaMesaDTO;
import itson.sistemarestaurantepersistencia.IMesasDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Clase que implementa la interfaz IMesasDAO y proporciona
 * implementaciones para los métodos de persistencia de mesas en el
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
        
        String jpql = "Select COUNT(m.id) FROM Mesa m";
        Query query = entityManager.createQuery(jpql);
        Long numeroMesas = (Long) query.getSingleResult();
        
        return numeroMesas;
    }

    /**
     * Metodo para obtener una lista con todas las mesas de la base de datos
     * y convertirlas a DTO
     * @return Lista con todas las mesas en formato DTO
     */
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

    /**
     * Metodo para obtener una mesa por su ID
     * @param idMesa ID de la mesa a buscar
     */
    @Override
    public MesaDTO obtenerMesaPorId(Long idMesa) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        Mesa mesa = entityManager.find(Mesa.class, idMesa);
        MesaDTO mesaDTO = null;
        if(mesa != null){
            mesaDTO = new MesaDTO(idMesa, mesa.getNumeroMesa());
        }
        
        return mesaDTO;
    }

    /**
     * Metodo para obtener una mesa por su numero
     * @param numeroMesa numero de la mesa a buscar
     * @return la mesa que tiene el numero dado
     */
    @Override
    public MesaDTO obtenerMesaPorNumero(Integer numeroMesa) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        String jpql = "SELECT new itson.sistemarestaurantedominio.dtos.MesaDTO(m.id, m.numeroMesa) FROM Mesa m WHERE m.numeroMesa = :numeroMesa";
        TypedQuery<MesaDTO> query = entityManager.createQuery(jpql, MesaDTO.class);
        query.setParameter("numeroMesa", numeroMesa);
        
        MesaDTO mesa = query.getSingleResult();
             
        if(mesa == null){
            return null;
        }   
        return mesa;
    }
    
}
