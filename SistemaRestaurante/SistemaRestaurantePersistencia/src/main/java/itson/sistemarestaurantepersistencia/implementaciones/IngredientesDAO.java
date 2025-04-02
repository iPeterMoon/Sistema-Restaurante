/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantepersistencia.IIngredientesDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
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

}
