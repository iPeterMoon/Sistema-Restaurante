package itson.sistemarestaurantepersistencia.excepciones;

/**
 * Clase que representa una excepción de todo lo que tenga que ver con
 * persistencia
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor por omision
     */
    public PersistenciaException() {
        super();
    }

    /**
     * Consturctor que inicializa el atributo de la clase padre
     *
     * @param message Mensaje a mostrar
     */
    public PersistenciaException(String message) {
        super(message);
    }
}
