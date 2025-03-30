/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC
 */
public class ManejadorConexiones {

    private static boolean isTestMode = false;
    private String testPersistenceUnit = "itson_PruebasSistemaRestauranteDominio_jar_1.0";
    
    public static EntityManager getEntityManager() {
        if(isTestMode){
            
        }
    }
    
    private static EntityManager createEntityManager(String persistenceUnit){
        EntityManagerFactory emFactory =
                Persistence.createEntityManagerFactory(persistenceUnit);
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
    
    public static 

}
