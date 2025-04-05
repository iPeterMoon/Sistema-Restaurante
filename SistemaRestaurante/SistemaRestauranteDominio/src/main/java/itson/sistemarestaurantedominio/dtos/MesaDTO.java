package itson.sistemarestaurantedominio.dtos;

/**
 * Clase para representar una mesa en el sistema de restaurante.
 * Contiene información sobre la mesa, como su id y su numero
 */
public class MesaDTO {
    private Long id;
    private int numeroMesa;

    /**
     * Constructor de la clase MesaDTO.
     * @param id El id de la mesa.
     * @param numeroMesa El número de la mesa.
     */
    public MesaDTO(Long id, int numeroMesa) {
        this.id = id;
        this.numeroMesa = numeroMesa;
    }

    /**
     * Método para obtener el id de la mesa.
     * @return El id de la mesa. .
     */
    public Long getId() {
        return id;
    }

    /**
     * Método para obtener el id de la mesa.
     * @return El id de la mesa.
     */
    public int getNumeroMesa() {
        return numeroMesa;
    }
}
