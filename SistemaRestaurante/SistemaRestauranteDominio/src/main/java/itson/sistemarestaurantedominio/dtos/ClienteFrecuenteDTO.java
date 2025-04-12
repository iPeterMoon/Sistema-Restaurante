/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantedominio.dtos;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

/**
 *
 * Clase que representa un cliente frecuente en el sistema de restaurante. Esta
 * clase es un DTO (Data Transfer Object) que se utiliza para transferir datos
 * del cliente frecuente entre las capas de la aplicación.
 *
 * @author PC
 */
public class ClienteFrecuenteDTO {

    private Long id;
    private String nombreCompleto;
    private Long numeroVisitas;
    private BigDecimal totalGastado;
    private Integer puntosFidelidad;
    private Calendar fechaUltimaComanda;

    /**
     * Constructor por omision
     */
    public ClienteFrecuenteDTO() {
    }

    /**
     * Constructor que inicializa los atirbutos de la clase al valor de sus
     * parametros
     *
     * @param nombreCompleto Nombre completo del cliente
     * @param numeroVisitas Numero de visitas que ha realizado el cliente al
     * restaurabte
     * @param totalGastado Total que ha gastado el cliente en el restaurante
     * @param puntosFidelidad Puntos de fidelidad del cliente
     * @param fechaUltimaComanda Fecha de la ultima comanda realizada por el
     * cliente
     */
    public ClienteFrecuenteDTO(String nombreCompleto, Long numeroVisitas, BigDecimal totalGastado, Integer puntosFidelidad, Calendar fechaUltimaComanda) {
        this.nombreCompleto = nombreCompleto;
        this.numeroVisitas = numeroVisitas;
        this.totalGastado = totalGastado;
        this.puntosFidelidad = puntosFidelidad;
        this.fechaUltimaComanda = fechaUltimaComanda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Long getNumeroVisitas() {
        return numeroVisitas;
    }

    public void setNumeroVisitas(Long numeroVisitas) {
        this.numeroVisitas = numeroVisitas;
    }

    public BigDecimal getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(BigDecimal totalGastado) {
        this.totalGastado = totalGastado;
    }

    public Integer getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public void setPuntosFidelidad(Integer puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    public Calendar getFechaUltimaComanda() {
        return fechaUltimaComanda;
    }

    public void setFechaUltimaComanda(Calendar fechaUltimaComanda) {
        this.fechaUltimaComanda = fechaUltimaComanda;
    }

}
