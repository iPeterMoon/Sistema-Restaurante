package itson.sistemarestaurantedominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase mapeadora de la entidad Mesas
 *
 * @author PC
 */
@Entity
@Table(name = "mesas")
public class Mesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesa")
    private Long id;

    @Column(name = "numero_mesa", nullable = false)
    private Integer numeroMesa;

    @OneToMany(mappedBy = "mesa", cascade = {CascadeType.PERSIST})
    private List<Comanda> comandas;

    /**
     * Constructor por omision
     */
    public Mesa() {
    }

    /**
     * Constructor que inicializa los atributos de la clase al valor de sus
     * parametros
     *
     * @param numeroMesa Numero de mesa
     */
    public Mesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    /**
     * Obtiene el ID de la mesa
     *
     * @return ID de la mesa
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la mesa
     *
     * @param id ID de la mesa a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el numero de la mesa
     *
     * @return Numero de la mesa
     */
    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    /**
     * Establece el numero de la mesa
     *
     * @param numeroMesa Numero de la mesa a establecer
     */
    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    /**
     * Obtiene la Lista de comandas en la que se encuentra la mesa
     *
     * @return Lista de comandas en la que se encuentra la maesa
     */
    public List<Comanda> getComandas() {
        return comandas;
    }

    /**
     * Establece la lista de comandas en la que se encuentra la mesa
     *
     * @param comandas Lista de comandas en la que se encuentra la maesa a
     * establecer
     */
    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }

    /**
     * Obtiene el HashCode de la mesa
     *
     * @return Codigo Hash de la mesa
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Metodo que compara si la mesa es igual a otra mesa
     *
     * @param object Objeto que es una instancia de Mesa
     * @return True or False dependiendo si la mesa es la misma o no
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesa)) {
            return false;
        }
        Mesa other = (Mesa) object;
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
        return "Mesa{" + "id=" + id + ", numeroMesa=" + numeroMesa + ", comandas=" + comandas + '}';
    }

}
