/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantenegocio.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.interfaces.IIngredientesBO;
import itson.sistemarestaurantepersistencia.IIngredientesDAO;

/**
 *
 * @author PC
 */
public class IngredientesBO implements IIngredientesBO {

    private IIngredientesDAO ingredientesDAO;

    public IngredientesBO(IIngredientesDAO ingredientesDAO) {
        this.ingredientesDAO = ingredientesDAO;
    }

    /**
     * Metodo para agregar un ingrediente en la base de datos
     *
     * @param nuevoIngrediente Ingrediente a agregar
     * @throws NegocioException Si el ingrediente no se puede agregar debido a
     * un error en la base de datos o de formato
     */
    @Override
    public void agregarIngrediente(NuevoIngredienteDTO nuevoIngrediente)
            throws NegocioException {
        validarNombreYUnidadMedidaExistente(nuevoIngrediente);
        try {
            ingredientesDAO.agregarIngrediente(nuevoIngrediente);
        } catch (Exception e) {
            throw new NegocioException("No se ha podido agregar el usuario" + e);
        }
    }

    /**
     * Metodo que verifica si existe un ingrediente con el mismo nombre y unidad
     * de medida en la base de datos
     *
     * @param nuevoIngrediente Ingrediente a verificar
     * @throws NegocioException Si un ingrediente con el mismo nombre y unidad
     * de medida existe en la base de datos
     */
    public void validarNombreYUnidadMedidaExistente(NuevoIngredienteDTO nuevoIngrediente)
            throws NegocioException {
        if (ingredientesDAO.existeIngredienteYUnidad(nuevoIngrediente)) {
            throw new NegocioException("No puede agregar un ingrediente con el"
                    + " mismo nombre y unidad de medida que uno existente.");
        }
    }

}
