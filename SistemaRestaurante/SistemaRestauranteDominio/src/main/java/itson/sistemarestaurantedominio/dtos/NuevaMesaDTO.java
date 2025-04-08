package itson.sistemarestaurantedominio.dtos;

/**
 * Clase que representa un Data Transfer Object (DTO) para una nueva mesa.
 * Contiene el número de la mesa que se desea crear.
 * @author pc
 */
public class NuevaMesaDTO {
    private int numeroMesa;

    /**
     * Constructor para inicializar un objeto NuevaMesaDTO con el número de mesa.
     * @param numeroMesa Número de la mesa que se desea crear.
     */
    public NuevaMesaDTO(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    /**
     * Método para obtener el número de la mesa.
     * @return Número de la mesa.
     */
    public int getNumeroMesa() {
        return numeroMesa;
    }
    
    
}
