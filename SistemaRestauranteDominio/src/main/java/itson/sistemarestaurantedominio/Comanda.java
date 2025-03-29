/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantedominio;

import itson.sistemarestaurantedominio.enumeradores.EstadoComanda;
import java.io.Serializable;
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
 *
 * @author PC
 */
@Entity
@Table(name = "comandas")
public class Comanda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComanda")
    private Long id;

    @Column(name = "folio", length = 15, nullable = false)
    private String folio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaHora", nullable = false)
    private Calendar fechaHora;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoComanda estado;

    @Column(name = "nota", nullable = true)
    private String nota;

    @Column(name = "totalVenta", nullable = false)
    private Double totalVenta;

    @ManyToOne()
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name = "idMesa", nullable = false)
    private Mesa mesa;

    @OneToMany(mappedBy = "comanda", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<DetallesComanda> productos;

    public Comanda() {
    }

    public Comanda(String folio, Calendar fechaHora, EstadoComanda estado, String nota, Double totalVenta, Cliente cliente, Mesa mesa) {
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.nota = nota;
        this.totalVenta = totalVenta;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public EstadoComanda getEstado() {
        return estado;
    }

    public void setEstado(EstadoComanda estado) {
        this.estado = estado;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<DetallesComanda> getProductos() {
        return productos;
    }

    public void setProductos(List<DetallesComanda> productos) {
        this.productos = productos;
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
        if (!(object instanceof Comanda)) {
            return false;
        }
        Comanda other = (Comanda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comanda{" + "id=" + id + ", folio=" + folio + ", fechaHora=" + fechaHora + ", estado=" + estado + ", nota=" + nota + ", totalVenta=" + totalVenta + ", cliente=" + cliente + ", mesa=" + mesa + '}';
    }

}
