/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantedominio.dtos;

/**
 *
 * @author PC
 */
public class IngredienteDTO {

    private Long id;
    private String nombre;
    private String unidadMedida; // Cambiado a String para simplificar el DTO
    private Integer stock;

    public IngredienteDTO(Long id, String nombre, String unidadMedida, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public Integer getStock() {
        return stock;
    }

}
