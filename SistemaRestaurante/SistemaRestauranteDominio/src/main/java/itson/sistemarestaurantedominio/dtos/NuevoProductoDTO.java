package itson.sistemarestaurantedominio.dtos;

import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import java.math.BigDecimal;
import java.util.List;

/**
 * Clase que representa un Data Transfer Object (DTO) para un nuevo producto.
 * Contiene los atributos necesarios para crear un nuevo producto en el sistema.
 * @author PC
 */
public class NuevoProductoDTO {

    private String nombre;
    private BigDecimal precio;
    private TipoProducto tipoProducto;
    private List<IngredienteProductoDTO> ingredientes;

    /**
     * Constructor que inicializa los atributos de la clase al valor de sus
     * parametros a excepcion de los ingredientes
     *
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param tipoProducto Tipo del producto
     * @param ingredientes Ingredientes del producto
     */
    public NuevoProductoDTO(String nombre, BigDecimal precio, TipoProducto tipoProducto, List<IngredienteProductoDTO> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.ingredientes = ingredientes;
    }

    /**
     * Metodo que obtiene el nombre del producto
     * @return Nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que obtiene el precio del producto
     * @return Precio del producto
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * Metodo que obtiene el tipo del producto
     * @return Tipo del producto
     */
    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    /**
     * Metodo que obtiene la lista de ingredientes del producto
     * @return Ingredientes del producto
     */
    public List<IngredienteProductoDTO> getIngredientes() {
        return ingredientes;
    }
}
