package itson.sistemarestaurantedominio;

import itson.sistemarestaurantedominio.enumeradores.UnidadMedida;
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
 * Clase mapeadorea de la entidad Ingredientes
 *
 * @author PC
 */
@Entity
@Table(name = "ingredientes")
public class Ingrediente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingrediente")
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "unidad_medida", nullable = false)
    private UnidadMedida unidadMedida;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @OneToMany(
            mappedBy = "ingrediente",
            //Al momento de eliminar ingrediente se elimina la relación con cualquier producto relacionado.
            cascade = {CascadeType.REMOVE}
    )
    private List<IngredientesProducto> productos;

    /**
     * Constructor por omision
     */
    public Ingrediente() {
    }

    /**
     * Constructor que inicializa los atributos de la clase al valor de sus
     * parametros
     *
     * @param nombre Nombre del ingrediente
     * @param unidadMedida Unidad de medida del ingrediente
     * @param stock Stock del ingrediente
     */
    public Ingrediente(String nombre, UnidadMedida unidadMedida, Integer stock) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
    }

    /**
     * Obtiene el ID del ingrediente
     *
     * @return ID del ingrediente
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del ingrediente
     *
     * @param id ID del ingrediente a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del ingrediente
     *
     * @return Nombre del ingrediente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del ingrediente
     *
     * @param nombre Nombre del ingrediente a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la unidad de medida del ingrediente
     *
     * @return Unidad de medida del ingrediente
     */
    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    /**
     * Establece la unidad de medida del ingrediente
     *
     * @param unidadMedida Unidad de medida del ingrediente a establecer
     */
    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    /**
     * Obtiene el stock del ingrediente
     *
     * @return Stock del ingrediente
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Establece el stock del ingrediente
     *
     * @param stock Stock del ingrediente a establecer
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Obtiene la lista de la relacion de productos e ingredientes
     *
     * @return Lista de relacion de productos e ingredientes
     */
    public List<IngredientesProducto> getProductos() {
        return productos;
    }

    /**
     * Establece la lista de la relacion de productos e ingredientes
     *
     * @param productos Lista de la relacion de productos e ingredientes a
     * establecer
     */
    public void setProductos(List<IngredientesProducto> productos) {
        this.productos = productos;
    }

    /**
     * Obtiene el HashCode de el ingrediente
     *
     * @return Codigo Hash de el ingrediente
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Metodo que compara si el ingrediente es igual a otro ingrediente
     *
     * @param object Objeto que es una instancia de Ingrediente
     * @return True or False dependiendo si el ingrediente es el mismo o no
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Ingrediente)) {
            return false;
        }
        Ingrediente other = (Ingrediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Metodo que convierte todos los atributos de la clase a un valor de tipo
     * string
     *
     * @return String con el valor de todos los atributos de la clase
     */
    @Override
    public String toString() {
        return "Ingrediente{" + "id=" + id + ", nombre=" + nombre + ", productos=" + productos + '}';
    }

}
