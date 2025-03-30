package itson.sistemarestaurantedominio;

import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_producto", nullable = false)
    private TipoProducto tipoProducto;

    @OneToMany(mappedBy = "producto", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<IngredientesProducto> ingredientes;

    @OneToMany(mappedBy = "producto", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<DetallesComanda> comandas;

    public Producto() {
    }

    public Producto(String nombre, Double precio, TipoProducto tipoProducto) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public List<IngredientesProducto> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredientesProducto> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<DetallesComanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<DetallesComanda> comandas) {
        this.comandas = comandas;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", ingredientes=" + ingredientes + '}';
    }

}
