package itson.sistemarestaurantedominio.dtos;

import java.util.List;

/**
 * DTO (Data Transfer Object) para representar una nueva comanda.
 * Contiene información sobre la mesa, el usuario que realiza la comanda
 * y los detalles de la misma.
 */
public class NuevaComandaDTO {

    private Long idMesa;
    private Long idCliente;
    private List<NuevoDetalleComandaDTO> detallesComanda;

    /**
     * Constructor para inicializar una nueva comanda.
     *
     * @param idMesa          Identificador de la mesa asociada a la comanda.
     * @param idCliente       Identificador del usuario que realiza la comanda.
     * @param detallesComanda Lista de detalles de la comanda.
     */
    public NuevaComandaDTO(Long idMesa, Long idCliente, List<NuevoDetalleComandaDTO> detallesComanda) {
        this.idMesa = idMesa;
        this.idCliente = idCliente;
        this.detallesComanda = detallesComanda;
    }

    /**
     * Obtiene el identificador de la mesa asociada a la comanda.
     *
     * @return Identificador de la mesa.
     */
    public Long getIdMesa() {
        return idMesa;
    }

    /**
     * Obtiene el identificador del usuario que realiza la comanda.
     *
     * @return Identificador del usuario.
     */
    public Long getIdCliente() {
        return idCliente;
    }

    /**
     * Obtiene la lista de detalles de la comanda.
     *
     * @return Lista de detalles de la comanda.
     */
    public List<NuevoDetalleComandaDTO> getDetallesComanda() {
        return detallesComanda;
    }
}