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

    public static EntityManager getEntityManager() {
        EntityManagerFactory emFactory;
        emFactory = Persistence.createEntityManagerFactory("itson_SistemaRestauranteDominio_jar_1.0");
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }

}
