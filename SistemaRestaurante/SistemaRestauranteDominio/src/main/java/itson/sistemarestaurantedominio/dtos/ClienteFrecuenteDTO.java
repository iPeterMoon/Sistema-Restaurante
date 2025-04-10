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
 * @author PC
 */
public class ClienteFrecuenteDTO {

    private Long id;
    private String nombreCompleto;
    private Long numeroVisitas;
    private BigDecimal totalGastado;
    private Integer puntosFidelidad;
    private Calendar fechaUltimaComanda;

    public ClienteFrecuenteDTO() {
    }

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
