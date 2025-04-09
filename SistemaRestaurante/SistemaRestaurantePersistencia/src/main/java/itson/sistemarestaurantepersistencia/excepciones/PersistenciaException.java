package itson.sistemarestaurantepersistencia.excepciones;

/**
 * Clase que representa una excepción de todo lo que tenga que ver con persistencia
 */
public class PersistenciaException extends Exception{

    public PersistenciaException(){
        super();
    }

    public PersistenciaException(String message){
        super(message);
    }
}
