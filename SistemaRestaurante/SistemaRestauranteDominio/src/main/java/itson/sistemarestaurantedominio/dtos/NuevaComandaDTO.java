package itson.sistemarestaurantedominio.dtos;

import java.util.List;

/**
 * DTO (Data Transfer Object) para representar una nueva comanda.
 * Contiene información sobre la mesa, el usuario que realiza la comanda
 * y los detalles de la misma.
 */
public class NuevaComandaDTO {

    /**
     * Identificador de la mesa asociada a la comanda.
     */
    private Long idMesa;

    /**
     * Identificador del usuario que realiza la comanda.
     */
    private Long idUsuario;

    /**
     * Lista de detalles de la comanda, que incluye los productos y sus cantidades.
     */
    private List<NuevoDetalleComandaDTO> detallesComanda;

    /**
     * Constructor para inicializar una nueva comanda.
     *
     * @param idMesa          Identificador de la mesa asociada a la comanda.
     * @param idUsuario       Identificador del usuario que realiza la comanda.
     * @param detallesComanda Lista de detalles de la comanda.
     */
    public NuevaComandaDTO(Long idMesa, Long idUsuario, List<NuevoDetalleComandaDTO> detallesComanda) {
        this.idMesa = idMesa;
        this.idUsuario = idUsuario;
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
    public Long getIdUsuario() {
        return idUsuario;
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