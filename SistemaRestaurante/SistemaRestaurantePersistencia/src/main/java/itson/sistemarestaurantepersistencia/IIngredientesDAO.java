/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IIngredientesDAO {

    /**
     * Metodo para registrar un ingrediente en la base de datos
     *
     * @param nuevoIngrediente Nuevo ingrediente a agregar
     * @return Ingrediente agregado en la base de datos
     */
    public abstract Ingrediente agregarIngrediente(NuevoIngredienteDTO nuevoIngrediente);

    /**
     * Metodo apra obtener una lista con todos los ingredientes de la base de
     * datos
     *
     * @return Lista con todos los ingredientes
     */
    public abstract List<Ingrediente> obtenerIngredientes();

}
