package itson.sistemarestaurantedominio;

import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import java.io.Serializable;
import java.math.BigDecimal;
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
 * Clase mapeadora de la entidad Producto
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

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_producto", nullable = false)
    private TipoProducto tipoProducto;

    @OneToMany(mappedBy = "producto", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<IngredientesProducto> ingredientes;

    @OneToMany(mappedBy = "producto", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<DetallesComanda> comandas;

    /**
     * Constructor por omision
     */
    public Producto() {
    }

    /**
     * Constructor que inicializa los atributos de la clase al valor de sus
     * parametros
     *
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param tipoProducto Tipo del producto
     */
    public Producto(String nombre, BigDecimal precio, TipoProducto tipoProducto) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
    }

    /**
     * Obtiene el ID del producto
     *
     * @return ID del producto
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del producto
     *
     * @param id ID del producto a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto
     *
     * @return Nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto
     *
     * @param nombre Nombre del producto a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto
     *
     * @return Precio del producto
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto
     *
     * @param precio Precio del producto a establecer
     */
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el tipo del producto
     *
     * @return Tipo del producto
     */
    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    /**
     * Establece el tipo de produto
     *
     * @param tipoProducto Tipo de producto a establecer
     */
    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    /**
     * Obtiene la lista de la relacion entre productos e ingredientes
     *
     * @return Lista de la relacion entre productos e ingredientes
     */
    public List<IngredientesProducto> getIngredientes() {
        return ingredientes;
    }

    /**
     * Estalece la lista de la relacion entre productos e ingredientes
     *
     * @param ingredientes Lista de la relacion entre productos e ingredientes a
     * establecer
     */
    public void setIngredientes(List<IngredientesProducto> ingredientes) {
        this.ingredientes = ingredientes;
    }

    /**
     * Establece la lista de los detalles de la comanda
     *
     * @return Lista de los detalles de la comanda
     */
    public List<DetallesComanda> getComandas() {
        return comandas;
    }

    /**
     * Establece la lista de los detalles de la comanda
     *
     * @param comandas Lista de los detalles de la comanda a establecer
     */
    public void setComandas(List<DetallesComanda> comandas) {
        this.comandas = comandas;
    }

    /**
     * Obtiene el HashCode del producto
     *
     * @return Codigo Hash del producto
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Metodo que compara si el producto es igual a el producto
     *
     * @param object Objeto que es una instancia del Producto
     * @return True or False dependiendo si el producto es la misma o no
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Metodo que convierte el valor de todos los atributos de la clase a una
     * string
     *
     * @return String con el valor de todos los atributos de la clase
     */
    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", ingredientes=" + ingredientes + '}';
    }

}
