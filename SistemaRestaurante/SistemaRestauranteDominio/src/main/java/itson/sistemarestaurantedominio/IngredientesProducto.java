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
 * Clase mapeadora de la relacion de ingredientes y productos
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

    /**
     * Constructor por omision
     */
    public IngredientesProducto() {
    }

    /**
     * Constructor que inicializa los atributos de la clase al valor de sus
     * parametros
     *
     * @param cantidad Cantidad de el ingrediente
     * @param ingrediente Ingrediente relacionado
     * @param producto Producto relacionado
     */
    public IngredientesProducto(Integer cantidad, Ingrediente ingrediente, Producto producto) {
        this.cantidad = cantidad;
        this.ingrediente = ingrediente;
        this.producto = producto;
    }

    /**
     * Obtiene el ID de la relacion de productos e ingredientes
     *
     * @return ID de la relacion de procductos e ingredientes
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la relacion de productos e ingredientes
     *
     * @param id ID de la relacion de productos e ingredientes a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la cantidad de el ingrediente
     *
     * @return Cantidad de el ingrediente
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de el ingrediente
     *
     * @param cantidad Cantidad de el ingrediente a establecer
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el ingrediente relacionado
     *
     * @return Ingrediente relacionado
     */
    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    /**
     * Establece el ingrediente relacionado
     *
     * @param ingrediente Ingrediente relacionado a establecer
     */
    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    /**
     * Obtiene el producto relacionado
     *
     * @return Producto relacionado
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el producto relacionado
     *
     * @param producto Producto relacionado a establecer
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Obtiene el HashCode de la relacion de el producto y el ingrediente
     *
     * @return Codigo Hash de la relacion de el producto y el ingrediente
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Metodo que compara si la relacion es igual a otra relacion
     *
     * @param object Objeto que es una instancia de IngredienteProducto
     * @return True or False dependiendo si la relacion es la misma o no
     */
    @Override
    public boolean equals(Object object) {
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

    /**
     * Metodo que convierte el valor de todos los atributos de la clase a una
     * string
     *
     * @return String con el valor de todos los atributos de la clase
     */
    @Override
    public String toString() {
        return "IngredientesProducto{" + "id=" + id + ", cantidad=" + cantidad + ", ingrediente=" + ingrediente + ", producto=" + producto + '}';
    }

}
