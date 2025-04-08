package itson.sistemarestaurantedominio.dtos;

import java.math.BigDecimal;
import java.util.Calendar;

import itson.sistemarestaurantedominio.enumeradores.EstadoComanda;

/**
 * Clase que representa un Data Transfer Object (DTO) para una comanda.
 * Contiene los atributos necesarios para mostrar una comanda en el sistema.
 */
public class ComandaDTO {

    private Long idComanda;
    private String folio;
    private Calendar fechaHora;
    private EstadoComanda estado;
    private BigDecimal total;
    private Long idMesa;
    private Long idCliente;

    /**
     * Constructor que inicializa los atributos de la clase al valor de sus
     * parámetros.
     *
     * @param idComanda ID de la comanda.
     * @param folio Folio de la comanda.
     * @param fechaHora Fecha y hora de la comanda.
     * @param estado Estado de la comanda.
     * @param total Total de la comanda.
     */
    public ComandaDTO(Long idComanda, String folio, Calendar fechaHora, EstadoComanda estado, BigDecimal total, Long idMesa, Long idCliente) {
        this.idComanda = idComanda;
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.total = total;
        this.idMesa = idMesa;
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el ID de la comanda.
     *
     * @return ID de la comanda.
     */
    public Long getIdComanda() {
        return idComanda;
    }

    /**
     * Obtiene el folio de la comanda.
     *
     * @return Folio de la comanda.
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Obtiene la fecha y hora de la comanda.
     *
     * @return Fecha y hora de la comanda.
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Obtiene el estado de la comanda.
     *
     * @return Estado de la comanda.
     */
    public EstadoComanda getEstado() {
        return estado;
    }

    /**
     * Obtiene el total de la comanda.
     *
     * @return Total de la comanda.
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Obtiene el ID de la mesa asociada a la comanda.
     *
     * @return ID de la mesa.
     */
    public Long getIdMesa() {
        return idMesa;
    }

    /**
     * Obtiene el ID del cliente asociado a la comanda.
     *
     * @return ID del cliente.
     */
    public Long getIdCliente() {
        return idCliente;
    }
}