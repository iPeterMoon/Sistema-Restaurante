/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.sistemarestaurantenegocio.interfaces;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.IngredienteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IIngredientesBO {

    /**
     * Metodo para agregar un ingrediente en la base de datos
     *
     * @param nuevoIngrediente Ingrediente a agregar
     * @return Ingrediente que se ha agregado a la base de datos
     * @throws NegocioException Si el ingrediente no se puede agregar debido a
     * un error en la base de datos
     */
    public abstract Ingrediente agregarIngrediente(NuevoIngredienteDTO nuevoIngrediente) throws NegocioException;

    /**
     * Metodo para obtener ingredientes de la base de datos
     *
     * @return Lista de todos los ingredientes de la base de datos
     * @throws NegocioException Si todos los ingredientes no se puede obtener
     * debido a un error de la base de datos
     */
    public abstract List<IngredienteDTO> obtenerIngredientes() throws NegocioException;

    /**
     * Metodo para obtener ingredientes filtrados de la base de datos
     *
     * @param filtroBusqueda Filtro de busqueda de ingredientes
     * @return Lista con todos los ingredientes filtrados de la base de datos
     * @throws NegocioException Si los ingredientes no se pueden obtener debido
     * a un error de la base de datos
     */
    public abstract List<IngredienteDTO> obtenerIngredientes(String filtroBusqueda) throws NegocioException;

}
