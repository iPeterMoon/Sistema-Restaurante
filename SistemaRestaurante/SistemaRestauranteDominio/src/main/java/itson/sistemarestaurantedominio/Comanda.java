package itson.sistemarestaurantedominio;

import itson.sistemarestaurantedominio.enumeradores.EstadoComanda;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase mapeadora de la entidad Comnada
 *
 * @author PC
 */
@Entity
@Table(name = "comandas")
public class Comanda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comanda")
    private Long id;

    @Column(name = "folio", length = 15, nullable = false)
    private String folio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora", nullable = false)
    private Calendar fechaHora;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoComanda estado;

    @Column(name = "total_venta", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalVenta;

    @ManyToOne()
    @JoinColumn(name = "id_cliente", nullable = true)
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name = "id_mesa", nullable = false)
    private Mesa mesa;

    @OneToMany(mappedBy = "comanda", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<DetallesComanda> productos;

    /**
     * Constructor por omision
     */
    public Comanda() {
    }

    /**
     * Constructor que inicializa los atributos de la clase al valor de sus
     * parametros
     *
     * @param folio Folio de la comanda
     * @param fechaHora Fecha y hora en la que se realizo la comanda
     * @param estado Estado en el que se encuentra la Comanda
     * @param totalVenta Total de venta de la Comanda
     * @param cliente Cliente al que se le proporciona la comanda
     * @param mesa Mesa en la que se entrega la comanda
     */
    public Comanda(String folio, Calendar fechaHora, EstadoComanda estado, BigDecimal totalVenta, Cliente cliente, Mesa mesa) {
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.totalVenta = totalVenta;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    /**
     * Obtiene el ID de la comanda
     *
     * @return ID de la comanda
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
     * Obtiene el folio de la comanda
     *
     * @return Folio de la comanda
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Establece el folio de la comanda
     *
     * @param folio Folio de la comanda a establecer
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * Obtiene la fecha y hora en la que se realizo la comanda
     *
     * @return Fecha y hora en la que se realizo la comanda
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora en la que se realizo la comanda
     *
     * @param fechaHora Fecha y hora en la que se realizo la comanda a
     * establecer
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el estado actual de la comanda
     *
     * @return Estado actual de la comanda
     */
    public EstadoComanda getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual de la comanda
     *
     * @param estado Estado actual de la comanda a establecer
     */
    public void setEstado(EstadoComanda estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el total de venta de la comanda
     *
     * @return Total de venta de la comanda
     */
    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    /**
     * Establece el total de venta de la comanda
     *
     * @param totalVenta Total de venta de la comanda a establecer
     */
    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }

    /**
     * Obtiene el cliente que proporciono la comanda
     *
     * @return Cliente que proporciono la comanda
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente que proporciono la comanda
     *
     * @param cliente Cliente que proporciono la comanda a establecer
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene la mesa a la que se le entregara la comanda
     *
     * @return Mesa a la que se le entregara la comanda
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * Establece la mesa a la que se entregara la comanda
     *
     * @param mesa Mesa a la que se le entregara la comanda a establecer
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    /**
     * Obtiene una lista de los productos que contiene la comanda
     *
     * @return Lista de productos que contiene la comanda
     */
    public List<DetallesComanda> getProductos() {
        return productos;
    }

    /**
     * Establece la lista de los productos que contine la comanda
     *
     * @param productos Lista de productos que contine la comanda a establecer
     */
    public void setProductos(List<DetallesComanda> productos) {
        this.productos = productos;
    }

    /**
     * Obtiene el HashCode de la Comanda
     *
     * @return Codigo Hash de la comanda
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Metodo que compara si una comanda es igual a otra comanda
     *
     * @param object Objeto que es una instancia de Comanda
     * @return True or False dependiendo si la comanda es la misma o no
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comanda)) {
            return false;
        }
        Comanda other = (Comanda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Metodo que obtiene el valor de los atributos de la clase en forma de
     * String
     *
     * @return String con el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Comanda{" + "id=" + id + ", folio=" + folio + ", fechaHora=" + fechaHora + ", estado=" + estado + ", totalVenta=" + totalVenta + ", cliente=" + cliente + ", mesa=" + mesa + ", productos=" + productos + '}';
    }

}
