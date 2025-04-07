package itson.sistemarestaurantedominio.dtos;

/**
 * Clase que representa un Data Transfer Object (DTO) para un nuevo ingrediente de un producto.
 * Contiene el ID del ingrediente y la cantidad requerida para el producto.
 */
public class NuevoIngredienteProductoDTO {
    private Long idIngrediente;
    private Integer cantidad;

    /**
     * Constructor con id del ingrediente y la cantidad
     * @param idIngrediente
     * @param cantidad
     */
    public NuevoIngredienteProductoDTO(Long idIngrediente, Integer cantidad) {
        this.idIngrediente = idIngrediente;
        this.cantidad = cantidad;
    }

    /**
     * Metodo que obtiene el id de el ingrediente
     * @return ID de el ingrediente
     */
    public Long getIdIngrediente() {
        return idIngrediente;
    }

    /**
     * Metodo que obtiene la cantidad de el ingrediente
     * @return Cantidad de el ingrediente
     */
    public Integer getCantidad(){
        return cantidad;
    }
}
