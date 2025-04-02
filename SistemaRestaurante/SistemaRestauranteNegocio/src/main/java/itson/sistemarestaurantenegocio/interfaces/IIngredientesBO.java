/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.sistemarestaurantenegocio.interfaces;

import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;

/**
 *
 * @author PC
 */
public interface IIngredientesBO {

    public abstract void agregarIngrediente(NuevoIngredienteDTO nuevoIngrediente) throws NegocioException;

}
