package itson.sistemarestaurantedominio.dtos;

import itson.sistemarestaurantedominio.enumeradores.UnidadMedida;

/**
 * Clase que representa un ingrediente en el sistema de restaurante.
 * Esta clase es un DTO (Data Transfer Object) que se utiliza para transferir
 * datos del ingrediente entre las capas de la aplicación.
 */
public class IngredienteDTO {


    private Long id;
    private String nombre;
    private UnidadMedida unidadMedida;
    private Integer stock;

    /**
     * Constructor para inicializar un objeto IngredienteDTO con todos sus atributos.
     *
     * @param id           Identificador único del ingrediente.
     * @param nombre       Nombre del ingrediente.
     * @param unidadMedida Unidad de medida del ingrediente.
     * @param stock        Cantidad disponible en stock del ingrediente.
     */
    public IngredienteDTO(Long id, String nombre, UnidadMedida unidadMedida, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
    }

    /**
     * Obtiene el identificador único del ingrediente.
     *
     * @return Identificador del ingrediente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Obtiene el nombre del ingrediente.
     *
     * @return Nombre del ingrediente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la unidad de medida del ingrediente.
     *
     * @return Unidad de medida del ingrediente.
     */
    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    /**
     * Obtiene la cantidad disponible en stock del ingrediente.
     *
     * @return Cantidad disponible en stock.
     */
    public Integer getStock() {
        return stock;
    }
}