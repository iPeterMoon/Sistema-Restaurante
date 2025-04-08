package itson.sistemarestaurantedominio.dtos;

import java.math.BigDecimal;

/**
 * Clase que representa un Data Transfer Object (DTO) para un nuevo detalle de comanda.
 * Contiene información sobre la cantidad, comentario, precio unitario, total por producto y el ID del producto.
 * @author pc
 */
public class NuevoDetalleComandaDTO {
    
    private Integer cantidad;
    private String comentario;
    private BigDecimal precioUnitario;
    private BigDecimal totalPorProducto;
    private Long idProducto;

    /**
     * Constructor que inicializa sus atributos al valor de sus parametros
     * @param cantidad Cantidad de producto
     * @param comentario Comentario opcional del producto
     * @param precioUnitario Precio unitario del producto
     * @param totalPorProducto Precio total por los productos
     * @param idProducto ID del producto requerido por la comanda
     */
    public NuevoDetalleComandaDTO(Integer cantidad, String comentario, BigDecimal precioUnitario, BigDecimal totalPorProducto, Long idProducto) {
        this.cantidad = cantidad;
        this.comentario = comentario;
        this.precioUnitario = precioUnitario;
        this.totalPorProducto = totalPorProducto;
        this.idProducto = idProducto;
    }

    /**
     * Constructor que inicializa sus atributos al valor de sus parametros sin comentarios
     * @param cantidad Cantidad de producto
     * @param precioUnitario Precio unitario del producto
     * @param totalPorProducto Precio total por los productos
     * @param idProducto ID del producto requerido por la comanda
     */
    public NuevoDetalleComandaDTO(Integer cantidad, BigDecimal precioUnitario, BigDecimal totalPorProducto, Long idProducto){
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.totalPorProducto = totalPorProducto;
        this.idProducto = idProducto;
    }

    /**
     * Obtiene el ID de el producto del detalle de la comanda
     * @return ID del producto del detalle de la comanda
     */
    public Long getIdProducto() {
        return idProducto;
    }

    /**
     * Obtiene el ID de el detalle de la comanda
     * @return ID del detalle de la comanda
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Obtiene la cantidad de producto del detalle de la comanda 
     * @return Cantidad del producto del detalle de la comanda
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Obtiene el precio unitario del producto del detalle de la comanda
     * @return Precio unitario del producto del detalle de la comanda
     */
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Obtiene el precio total por producto del detalle de la comanda
     * @return Precio total por producto del detalle de la comanda
     */
    public BigDecimal getTotalPorProducto() {
        return totalPorProducto;
    }

}
