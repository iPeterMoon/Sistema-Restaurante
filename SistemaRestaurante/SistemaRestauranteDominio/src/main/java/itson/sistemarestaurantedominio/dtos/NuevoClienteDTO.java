package itson.sistemarestaurantedominio.dtos;

/**
 * Clase que representa un Data Transfer Object (DTO) para un nuevo cliente.
 * Contiene los atributos necesarios para crear un nuevo cliente en el sistema.
 * @author pc
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

    /**
     * Metodo que obtiene el nombre del cliente
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que obtiene el apellido paterno del cliente
     * @return Apellido Paterno del cliente
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Metodo que obtiene el apellido materno del cliente
     * @return Apellido Materno del cliente
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Metodo que obtiene el telefono del cliente
     * @return Telefono del cliente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo que obtiene el correo del cliente
     * @return Correo del cliente
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo que establece el nombre del cliente
     * @param telefono Telefono del cliente
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo que establece el nombre del cliente
     * @param correo Correo del cliente
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
