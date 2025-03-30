/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantepersistencia.IIngredientesDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author PC
 */
public class IngredientesDAO implements IIngredientesDAO {

    @Override
    public Ingrediente agregar(NuevoIngredienteDTO nuevoIngrediente) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        Ingrediente ingrediente = new Ingrediente(nuevoIngrediente.getNombre(),
                nuevoIngrediente.getUnidadMedida(), nuevoIngrediente.getStock());
        entityManager.persist(ingrediente);
        entityManager.getTransaction().commit();
        return ingrediente;
    }

}
