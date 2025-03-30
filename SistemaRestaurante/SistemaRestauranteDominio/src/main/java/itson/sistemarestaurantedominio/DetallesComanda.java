package itson.sistemarestaurantedominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase mapeadora de la entidad DetallesComanda
 *
 * @author PC
 */
@Entity
@Table(name = "detalles_comanda")
public class DetallesComanda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalles_comanda")
    private Long id;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "comentario", length = 100, nullable = true)
    private String comentario;

    @Column(name = "precio_unitario", nullable = false)
    private Double precioUnitario;

    @Column(name = "total_por_producto", nullable = false)
    private Double totalPorProducto;

    @ManyToOne()
    @JoinColumn(name = "id_comanda", nullable = false)
    private Comanda comanda;

    @ManyToOne()
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    /**
     * Constructor por omision
     */
    public DetallesComanda() {
    }

    /**
     * Constructor que inicializa los atributos de la clase al valor de sus
     * parametros
     *
     * @param cantidad Cantidad de producto
     * @param comentario Comentario opcional del producto
     * @param precioUnitario Precio unitario del producto
     * @param totalPorProducto Precio total por los productos
     * @param comanda Comanda a la que pertenecen los detalles
     * @param producto Producto requerido por la comanda
     */
    public DetallesComanda(Integer cantidad, String comentario, Double precioUnitario, Double totalPorProducto, Comanda comanda, Producto producto) {
        this.cantidad = cantidad;
        this.comentario = comentario;
        this.precioUnitario = precioUnitario;
        this.totalPorProducto = totalPorProducto;
        this.comanda = comanda;
        this.producto = producto;
    }

    /**
     * Obtiene el ID de el detalle de la comanda
     *
     * @return ID del detalle de la comanda
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la comanda
     *
     * @param id ID de la comanda a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la cantidad de producto solicitado en la comanda
     *
     * @return Cantidad del producto solicitado en la comanda
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del producto solicitado en la comanda
     *
     * @param cantidad Cantidad del producto solicitado en la comanda
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el comentario opcional de un producto del detalle de la comanda
     *
     * @return Comentario opcional de un producto del detalle de la comanda
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Establece un comentario opcional de un producto del detalle de la comanda
     *
     * @param comentario Comentario a establecer
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Obtiene el precio unitario del producto de la comanda
     *
     * @return Precio unitario del producto de la comanda
     */
    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Establece el precio unitario de el producto de la comanda
     *
     * @param precioUnitario Precio unitario del producto a establecer
     */
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * Obtiene el total por producto de los detalles de la comanda
     *
     * @return Total por producto de los detalles de la comanda
     */
    public Double getTotalPorProducto() {
        return totalPorProducto;
    }

    /**
     * Establece el total por producto de los detalles de la comanda
     *
     * @param totalPorProducto Total de producto a establecer
     */
    public void setTotalPorProducto(Double totalPorProducto) {
        this.totalPorProducto = totalPorProducto;
    }

    /**
     * Obtiene la comanda a la que pertenecen los detalles
     *
     * @return Comanda a la que le pertenecen los detalles
     */
    public Comanda getComanda() {
        return comanda;
    }

    /**
     * Establece la comanda a la que le pertenecen los detalles
     *
     * @param comanda Comanda a la que le pertenecen los detalles a establecer
     */
    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    /**
     * Obtiene el producto perteneciente a la comanda
     *
     * @return Producto perteneciente a la comanda
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el producto perteneciente a la comanda
     *
     * @param producto Producto perteneciente a la comanda a establecer
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Obtiene el HashCode de el detalle de la comanda
     *
     * @return Codigo Hash de el detalle de la comanda
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Metodo que compara si el detalle de la comanda es igual a otro detalle de
     * comanda
     *
     * @param object Objeto que es una instancia de DetalleComanda
     * @return True or False dependiendo si el detalle de la comanda es el
     * mismoo no
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallesComanda)) {
            return false;
        }
        DetallesComanda other = (DetallesComanda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Metodo que convierte los valores de los atributos de la clase a un String
     *
     * @return String con el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "itson.sistemarestaurantedominio.DetallesComanda[ id=" + id + " ]";
    }

}
