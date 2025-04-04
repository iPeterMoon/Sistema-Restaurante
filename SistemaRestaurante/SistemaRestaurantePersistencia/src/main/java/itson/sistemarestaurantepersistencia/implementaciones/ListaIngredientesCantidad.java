/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;

/**
 * Clase para generar una lista de ingredientes y su cantidad especifica para
 * cada producto. (Esta clase solo se utiliza dentro de la relacion de
 * IngredientesProducto)
 *
 * @author PC
 */
public class ListaIngredientesCantidad {

    private Ingrediente ingrediente;
    private Integer cantidad;

    /**
     * Constructor por omision
     */
    public ListaIngredientesCantidad() {
    }

    /**
     * Constructor que inicializa los atrbutos de la clase al valor de sus
     * parametros
     *
     * @param ingrediente Ingrediente con el que se realizara el producto
     * @param cantidad Cantidad de ingrediente para realizar el producto
     */
    public ListaIngredientesCantidad(Ingrediente ingrediente, Integer cantidad) {
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
