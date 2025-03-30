package itson.sistemarestaurantedominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase mapeadora de la entidad Clientes
 *
 * @author PC
 */
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellido_paterno", length = 50, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 50, nullable = false)
    private String apellidoMaterno;

    @Column(name = "puntos", nullable = false)
    private Integer puntos;

    @Column(name = "correo", length = 100, nullable = true)
    private String correo;

    @Column(name = "telefono", length = 25, nullable = false)
    private String telefono;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_registro", nullable = false)
    private Calendar fechaRegistro;

    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST})
    private List<Comanda> comandas;

    /**
     * Constructor por omision
     */
    public Cliente() {
    }

    /**
     * Constructor que inicializa los atirbutos de la clase al valor de sus
     * parametros
     *
     * @param nombre Nombre del cliente
     * @param apellidoPaterno Apellido paterno del cliente
     * @param apellidoMaterno Apellido materno del cliente
     * @param puntos Puntos que el cliente tiene con el restaurante
     * @param correo Correo electronico del cliente
     * @param telefono Telefono del cliente
     * @param fechaRegistro Fecha en la que se registro el cliente
     */
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, Integer puntos, String correo, String telefono, Calendar fechaRegistro) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.puntos = puntos;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Metodo que obtiene el id del cliente
     *
     * @return ID del cliente
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo que establece el ID del cliente
     *
     * @param id ID del cliente a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo que obtiene el nombre del cliente
     *
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que establece el nombre del cliente
     *
     * @param nombre Nombre del cliente a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene el apellido paterno del cliente
     *
     * @return Apellido paterno del cliente
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Metodo que establece el apellido paterno del cliente
     *
     * @param apellidoPaterno Apellido paterno del cliente a establecer
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Metodo que obtiene el apellido materno del cliente
     *
     * @return Apellido materno del cliente
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Metodo que establece el apellido materno del cliente
     *
     * @param apellidoMaterno Apellido materno del cliente a establecer
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Metodo que obtiene los puntos del cliente en el restaurante
     *
     * @return Puntos del cliente en el restaurante
     */
    public Integer getPuntos() {
        return puntos;
    }

    /**
     * Metodo que establece los puntos del cliente en el restaurante
     *
     * @param puntos Puntos del cliente en el restaurante a establecer
     */
    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    /**
     * Metodo que obtiene el correo del cliente
     *
     * @return Correo del cliente
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo que establece el correo del cliente
     *
     * @param correo Correo del cliente a establecer
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo que obtiene el telefono del cliente
     *
     * @return Telefono del cliente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo que establece el telefono del cliente
     *
     * @param telefono telefono del cliente a establecer
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo que obtiene la fecha de registro del cliente
     *
     * @return Fecha de registro del cliente
     */
    public Calendar getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Metodo que establece la fecha de registro del cliente
     *
     * @param fechaRegistro Fecha de registro del cliente a establecer
     */
    public void setFechaRegistro(Calendar fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Metodo que obtiene la lista de comandas en la que esta presente el
     * cliente
     *
     * @return Lista de comandas en la que esta presente el cliente
     */
    public List<Comanda> getComandas() {
        return comandas;
    }

    /**
     * Metodo que establece la lista de comandas en la que esta presente el
     * cliente
     *
     * @param comandas Lista de comandas en la que esta presente el cliente a
     * establecer
     */
    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }

    /**
     * Metodo para obtener el HashCode del cliente
     *
     * @return Codigo Hash del cliente
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Metodo que compara si un cliente es igual a otro cliente
     *
     * @param object Objeto que es una instancia de Cliente
     * @return True or False dependiendo si el cliente es el mismo o no
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Metodo que convierte todos los atributos de la clase a un String
     *
     * @return String con el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", comandas=" + comandas + '}';
    }

}
