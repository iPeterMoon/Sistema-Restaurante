package itson.sistemarestaurantedominio.dtos;

import java.util.Calendar;

/**
 * Clase que representa un cliente en el sistema de restaurante.
 * Esta clase es un DTO que solo se usa para mostrar los datos del cliente.
 */
public class ClienteDTO{

    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String telefono;
    private int puntos;
    private Calendar fechaRegistro;

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

    public Long getId() {
        return id;
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

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getPuntos() {
        return puntos;
    }

    public Calendar getFechaRegistro() {
        return fechaRegistro;
    }

}