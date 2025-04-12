package itson.sistemarestaurantenegocio.excepciones;

/**
 * Excepciones para el proyecto de Negocio
 *
 * @author Peter
 */
public class NegocioException extends Exception {

    /**
     * Constructor por omision
     */
    public NegocioException() {
    }

    /**
     * Constructor que inicializa el mensaje de la clase padre (Exception)
     *
     * @param message Mensaje a mostrar en la excepcion
     */
    public NegocioException(String message) {
        super(message);
    }

}
