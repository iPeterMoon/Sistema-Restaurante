package itson.sistemarestaurantedominio.dtos;

import itson.sistemarestaurantedominio.enumeradores.UnidadMedida;

/**
 * Clase que representa un Data Transfer Object (DTO) para un nuevo ingrediente.
 * Contiene los atributos necesarios para crear un nuevo ingrediente en el sistema.
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

    /**
     * Metodo que obtiene el nombre de el ingrediente
     * @return Nombre de el ingrediente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que obtiene la unidad de medida de el ingrediente
     * @return Unidad de medida de el ingrediente
     */
    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    /**
     * Metodo que obtiene el stock de el ingrediente
     * @return Stock de el ingrediente
     */
    public Integer getStock() {
        return stock;
    }

}
