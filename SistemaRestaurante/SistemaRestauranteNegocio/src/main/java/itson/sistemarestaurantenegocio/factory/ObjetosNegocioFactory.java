package itson.sistemarestaurantenegocio.factory;

import itson.sistemarestaurantenegocio.implementaciones.MesasBO;
import itson.sistemarestaurantenegocio.interfaces.IMesasBO;
import itson.sistemarestaurantepersistencia.IMesasDAO;
import itson.sistemarestaurantepersistencia.implementaciones.MesasDAO;

/**
 *
 * @author pc
 */
public class ObjetosNegocioFactory {
    public static IMesasBO crearMesasBO(){
        IMesasDAO mesasDAO = new MesasDAO();
        IMesasBO mesasBO = new MesasBO(mesasDAO);
        return mesasBO;
    }
    
}
