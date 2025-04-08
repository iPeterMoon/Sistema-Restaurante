package itson.sistemarestaurantedominio.dtos;

import java.util.Calendar;

/**
 * Clase que representa un cliente en el sistema de restaurante.
 * Esta clase es un DTO (Data Transfer Object) que se utiliza para transferir
 * datos del cliente entre las capas de la aplicación.
 */
public class ClienteDTO {


    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String telefono;
    private int puntos;
    private Calendar fechaRegistro;

    /**
     * Constructor para inicializar un objeto ClienteDTO con todos sus atributos.
     *
     * @param id              Identificador único del cliente.
     * @param nombre          Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param correo          Correo electrónico del cliente.
     * @param telefono        Teléfono del cliente.
     * @param puntos          Puntos acumulados por el cliente.
     * @param fechaRegistro   Fecha de registro del cliente en el sistema.
     */
    public ClienteDTO(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String telefono, int puntos, Calendar fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.telefono = telefono;
        this.puntos = puntos;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Obtiene el identificador único del cliente.
     *
     * @return Identificador del cliente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido paterno del cliente.
     *
     * @return Apellido paterno del cliente.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del cliente.
     *
     * @return Apellido materno del cliente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     *
     * @return Correo electrónico del cliente.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Obtiene el teléfono del cliente.
     *
     * @return Teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Obtiene los puntos acumulados por el cliente.
     *
     * @return Puntos acumulados por el cliente.
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Obtiene la fecha de registro del cliente en el sistema.
     *
     * @return Fecha de registro del cliente.
     */
    public Calendar getFechaRegistro() {
        return fechaRegistro;
    }
}