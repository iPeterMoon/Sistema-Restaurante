package itson.sistemarestaurantedominio.dtos;

import itson.sistemarestaurantedominio.enumeradores.UnidadMedida;

/**
 *
 * @author PC
 */
public class IngredienteDTO {

    private Long id;
    private String nombre;
    private UnidadMedida unidadMedida;
    private Integer stock;

    public IngredienteDTO(Long id, String nombre, UnidadMedida unidadMedida, Integer stock) {
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

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public Integer getStock() {
        return stock;
    }

}
