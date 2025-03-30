/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;

/**
 *
 * @author PC
 */
public interface IIngredientesDAO {
    
    public abstract Ingrediente agregar(NuevoIngredienteDTO nuevoIngrediente);
    
}
