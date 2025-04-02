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
     * Metodo para obtener una lista con todos los ingredientes de la base de
     * datos
     *
     * @return Lista con todos los ingredientes
     */
    public abstract List<Ingrediente> obtenerIngredientes();

    /**
     * Metodo para obtener una lista con todos los ingredientes de la base de
     * datos que coincidan con el filtro de buscqueda
     *
     * @param filtroBusqueda Filtro para buscar los ingredientes
     * @return Lista con los ingredientes coincidentes con el filtro
     */
    public abstract List<Ingrediente> obtenerIngrediente(String filtroBusqueda);

    /**
     * Metodo que verifica si existe un ingrediente con el mismo nombre y unidad
     * de medida
     *
     * @param nuevoIngrediente Ingrediente a verificar
     * @return True o False dependiendo si existe un ingrediente con el mismo
     * nombre y unidad de medida o no
     */
    public abstract boolean existeIngredienteYUnidad(NuevoIngredienteDTO nuevoIngrediente);

}
