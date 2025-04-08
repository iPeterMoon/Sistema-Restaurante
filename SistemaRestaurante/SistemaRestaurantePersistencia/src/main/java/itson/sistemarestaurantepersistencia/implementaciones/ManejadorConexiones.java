package itson.sistemarestaurantepersistencia.implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase que maneja las conexiones a la base de datos, dependiendo de si el modo de pruebas está activado o no
 * 
 * @author PC
 */
public class ManejadorConexiones {

    private static boolean isTestMode = false;
    private static final String TEST_PU = "itson_PruebasSistemaRestaurante_jar_1.0PU";
    private static final String REAL_PU = "itson_SistemaRestaurante_jar_1.0PU";
    
    /**
     * Regresa un entityManager dependiendo de si el modo de pruebas está activado o no
     * @return Un entityManager
     */
    public static EntityManager getEntityManager() {
        if(isTestMode){
            return createEntityManager(TEST_PU);
        } else {
            return createEntityManager(REAL_PU);
        }
    }
    /**
     * Crea un entityManager a partir de un String con el nombre de la persistence Unit
     * @param persistenceUnit String con el nombre de la persistence Unit
     * @return EntityManager de la persistence Unit
     */
    private static EntityManager createEntityManager(String persistenceUnit){
        EntityManagerFactory emFactory =
                Persistence.createEntityManagerFactory(persistenceUnit);
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
    
    /**
     * Activa el modo de pruebas
     */
    public static void activateTestMode(){
        isTestMode = true;
    }
    
    /**
     * Desactiva el modo de pruebas
     */
    public static void deactivateTestMode(){
        isTestMode = false;
    }
    
    

}
