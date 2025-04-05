package itson.sistemarestaurantenegocio.factory;

import itson.sistemarestaurantenegocio.implementaciones.ClientesBO;
import itson.sistemarestaurantenegocio.implementaciones.MesasBO;
import itson.sistemarestaurantenegocio.implementaciones.ProductosBO;
import itson.sistemarestaurantenegocio.interfaces.IClientesBO;
import itson.sistemarestaurantenegocio.interfaces.IMesasBO;
import itson.sistemarestaurantenegocio.interfaces.IProductosBO;
import itson.sistemarestaurantepersistencia.IClientesDAO;
import itson.sistemarestaurantepersistencia.IMesasDAO;
import itson.sistemarestaurantepersistencia.IProductosDAO;
import itson.sistemarestaurantepersistencia.implementaciones.ClientesDAO;
import itson.sistemarestaurantepersistencia.implementaciones.MesasDAO;
import itson.sistemarestaurantepersistencia.implementaciones.ProductosDAO;

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

    public static IClientesBO crearClientesBO() {
        IClientesDAO clientesDAO = new ClientesDAO();
        IClientesBO clientesBO = new ClientesBO(clientesDAO);
        return clientesBO;
    }
    
    public static IProductosBO crearProductosBO(){
        IProductosDAO productosDAO = new ProductosDAO();
        IProductosBO productosBO = new ProductosBO(productosDAO);
        return productosBO;
    }
}
