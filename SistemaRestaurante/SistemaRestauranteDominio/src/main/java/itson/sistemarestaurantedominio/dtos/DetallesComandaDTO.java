package itson.sistemarestaurantedominio.dtos;

import java.math.BigDecimal;

public class DetallesComandaDTO {

    private Long id;
    private Integer cantidad;
    private String comentario;
    private BigDecimal precioUnitario;
    private BigDecimal totalPorProducto;
    private Long idComanda;
    private Long idProducto;

    /**
     * Constructor para el DTO de Detalles de la Comanda
     * @param id Id del detalle de la comanda.
     * @param cantidad Cantidad del producto
     * @param comentario Comentarios adicionales
     * @param precioUnitario Precio Unitario del producto al momento de ser guardado
     * @param totalPorProducto Importe del producto
     * @param idComanda Id de la comanda a la que pertenece
     * @param idProducto Id del producto
     */
    public DetallesComandaDTO(Long id, Integer cantidad, String comentario, BigDecimal precioUnitario, BigDecimal totalPorProducto, Long idComanda, Long idProducto) {
        this.id = id;
        this.cantidad = cantidad;
        this.comentario = comentario;
        this.precioUnitario = precioUnitario;
        this.totalPorProducto = totalPorProducto;
        this.idComanda = idComanda;
        this.idProducto = idProducto;
    }
    /**
     * Constructor para el DTO de Detalles de la Comandas
     * @param cantidad Cantidad del producto
     * @param comentario Comentarios adicionales
     * @param precioUnitario Precio Unitario del producto al momento de ser guardado
     * @param totalPorProducto Importe del producto
     * @param idComanda Id de la comanda a la que pertenece
     * @param idProducto Id del producto
     */
    public DetallesComandaDTO(Integer cantidad, String comentario, BigDecimal precioUnitario, BigDecimal totalPorProducto, Long idComanda, Long idProducto){
        this.cantidad = cantidad;
        this.comentario = comentario;
        this.precioUnitario = precioUnitario;
        this.totalPorProducto = totalPorProducto;
        this.idComanda = idComanda;
        this.idProducto = idProducto;
    }

    /**
     * Obtiene el id del detalle de la comanda
     * @return ID del detalle de la comanda
     */
    public Long getId(){
        return id;
    };

    /**
     * Obtiene la cantidad del producto
     * @return Cantidad de productos
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Obtiene los comentarios adicionales
     * @return Comentarios adicionales
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Obtiene el precio unitario del producto
     * @return Precio Unitario del producto
     */
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Obtiene el importe del producto a la comanda
     * @return Importe del producto
     */
    public BigDecimal getTotalPorProducto() {
        return totalPorProducto;
    }

    /**
     * Obtiene el id de la comanda a la que pertenece
     * @return Id de la comanda
     */
    public Long getIdComanda() {
        return idComanda;
    }

    /**
     * Obtiene el Id del producto 
     * @return Id del producto
     */
    public Long getIdProducto() {
        return idProducto;
    }
    
    
    
    
}
