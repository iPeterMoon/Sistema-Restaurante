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
 *
 * @author PC
 */
@Entity
@Table(name = "ingredientes_producto")
public class IngredientesProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredientes_producto")
    private Long id;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @ManyToOne()
    @JoinColumn(name = "id_ingrediente", nullable = false)
    private Ingrediente ingrediente;

    @ManyToOne()
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    public IngredientesProducto() {
    }

//    public IngredientesProducto(Ingrediente ingrediente, Producto producto) {
//        this.ingrediente = ingrediente;
//        this.producto = producto;
//    }

    public IngredientesProducto(Integer cantidad, Ingrediente ingrediente, Producto producto) {
        this.cantidad = cantidad;
        this.ingrediente = ingrediente;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngredientesProducto)) {
            return false;
        }
        IngredientesProducto other = (IngredientesProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public IngredientesProducto(Long id, Ingrediente ingrediente, Producto producto) {
        this.id = id;
        this.ingrediente = ingrediente;
        this.producto = producto;
    }

}
