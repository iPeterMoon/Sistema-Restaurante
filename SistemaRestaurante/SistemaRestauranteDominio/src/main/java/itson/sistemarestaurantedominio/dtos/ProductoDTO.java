package itson.sistemarestaurantedominio.dtos;

import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import java.math.BigDecimal;

/**
 * Clase que representa un producto en el sistema de restaurante.
 * Esta clase es un DTO (Data Transfer Object) que se utiliza para transferir
 * datos del producto entre las capas de la aplicación.
 */
public class ProductoDTO {

    private Long id;
    private String nombre;
    private BigDecimal precio;
    private TipoProducto tipoProducto;

    /**
     * Constructor para inicializar un objeto ProductoDTO con todos sus atributos.
     *
     * @param id           Identificador único del producto.
     * @param nombre       Nombre del producto.
     * @param precio       Precio del producto.
     * @param tipoProducto Tipo del producto.
     */
    public ProductoDTO(Long id, String nombre, BigDecimal precio, TipoProducto tipoProducto) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
    }

    /**
     * Obtiene el identificador único del producto.
     *
     * @return Identificador del producto.
     */
    public Long getId() {
        return id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return Precio del producto.
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * Obtiene el tipo del producto.
     *
     * @return Tipo del producto.
     */
    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }
}