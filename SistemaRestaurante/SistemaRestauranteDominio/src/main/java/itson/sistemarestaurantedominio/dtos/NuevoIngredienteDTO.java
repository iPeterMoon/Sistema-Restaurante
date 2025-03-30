/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantedominio.dtos;

import itson.sistemarestaurantedominio.enumeradores.UnidadMedida;

/**
 *
 * @author PC
 */
public class NuevoIngredienteDTO {

    private String nombre;
    private UnidadMedida unidadMedida;
    private Integer stock;

    public NuevoIngredienteDTO(String nombre, UnidadMedida unidadMedida, Integer stock) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public Integer getStock() {
        return stock;
    }

}
