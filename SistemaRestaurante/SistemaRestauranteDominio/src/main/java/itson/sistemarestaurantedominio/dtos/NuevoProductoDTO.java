/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantedominio.dtos;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.IngredientesProducto;
import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author PC
 */
public class NuevoProductoDTO {

    private String nombre;
    private BigDecimal precio;
    private TipoProducto tipoProducto;

    /**
     * Constructor que inicializa los atributos de la clase al valor de sus
     * parametros a excepcion de los ingredientes
     *
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param tipoProducto Tipo del producto
     */
    public NuevoProductoDTO(String nombre, BigDecimal precio, TipoProducto tipoProducto) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

}
