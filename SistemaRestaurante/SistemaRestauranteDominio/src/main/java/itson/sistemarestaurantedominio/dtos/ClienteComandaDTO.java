package itson.sistemarestaurantedominio.dtos;

/**
 * Clase que representa un cliente en una comanda, solo se necesita su nombre y su id.
 * @author pc
 */
public class ClienteComandaDTO {
    
    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    /**
     * Constructor para cliente en una comanda
     * @param id Id del cliente
     * @param nombre Nombre o nombres del cliente
     * @param apellidoPaterno apellido paterno del cliente
     * @param apellidoMaterno Apellido Materno del cliente
     */
    public ClienteComandaDTO(Long id, String nombre, String apellidoPaterno, String apellidoMaterno){
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el id del cliente
     * @return id del cliente
     */
    public Long getId(){
        return this.id;
    }

    /**
     * Obtiene el nombre del cliente
     * @return nombre del cliente
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Obtiene el apellido paterno del cliente
     * @return apellido paterno del cliente
     */
    public String getApellidoPaterno(){
        return this.apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del cliente
     * @return apellido materno del cliente
     */
    public String getApellidoMaterno(){
        return this.apellidoMaterno;
    }
}
