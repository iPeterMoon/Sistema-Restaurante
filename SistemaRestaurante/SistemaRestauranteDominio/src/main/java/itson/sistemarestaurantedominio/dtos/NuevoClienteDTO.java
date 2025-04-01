package itson.sistemarestaurantedominio.dtos;

/**
 *
 * @author Peter
 */
public class NuevoClienteDTO {
    
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    private String telefono;
    private String correo;

    /**
     * Constructor para crear un nuevo cliente
     * @param nombre Nombre del cliente
     * @param apellidoPaterno Apellido Paterno del cliente
     * @param apellidoMaterno Apellido Materno del cliente
     * @param telefono Telefono del cliente
     * @param correo Correo del cliente
     */
    public NuevoClienteDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correo) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.correo = correo;
    }

    /**
     * Constructor para crear un nuevo cliente sin correo
     * @param nombre Nombre del cliente
     * @param apellidoPaterno Apellido Paterno del cliente
     * @param apellidoMaterno Apellido Materno del cliente
     * @param telefono Telefono del cliente
     */
    public NuevoClienteDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

}
