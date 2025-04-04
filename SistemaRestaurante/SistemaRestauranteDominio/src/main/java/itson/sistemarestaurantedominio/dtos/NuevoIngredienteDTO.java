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

    /**
     * Constructor que inicializa los atributos de la clase al valor de sus
     * parametros
     *
     * @param nombre Nombre del ingrediente
     * @param unidadMedida Unidad de medida del ingrediente
     * @param stock Stock del ingrediente
     */
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
