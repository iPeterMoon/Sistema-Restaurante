package itson.sistemarestaurantenegocio.factory;

import itson.sistemarestaurantenegocio.implementaciones.ClientesBO;
import itson.sistemarestaurantenegocio.implementaciones.ComandasBO;
import itson.sistemarestaurantenegocio.implementaciones.DetallesComandaBO;
import itson.sistemarestaurantenegocio.implementaciones.IngredientesBO;
import itson.sistemarestaurantenegocio.implementaciones.IngredientesProductoBO;
import itson.sistemarestaurantenegocio.implementaciones.MesasBO;
import itson.sistemarestaurantenegocio.implementaciones.ProductosBO;
import itson.sistemarestaurantenegocio.interfaces.IClientesBO;
import itson.sistemarestaurantenegocio.interfaces.IComandasBO;
import itson.sistemarestaurantenegocio.interfaces.IDetallesComandaBO;
import itson.sistemarestaurantenegocio.interfaces.IIngredientesBO;
import itson.sistemarestaurantenegocio.interfaces.IIngredientesProductoBO;
import itson.sistemarestaurantenegocio.interfaces.IMesasBO;
import itson.sistemarestaurantenegocio.interfaces.IProductosBO;
import itson.sistemarestaurantepersistencia.IClientesDAO;
import itson.sistemarestaurantepersistencia.IComandasDAO;
import itson.sistemarestaurantepersistencia.IDetallesComandaDAO;
import itson.sistemarestaurantepersistencia.IIngredientesDAO;
import itson.sistemarestaurantepersistencia.IIngredientesProductosDAO;
import itson.sistemarestaurantepersistencia.IMesasDAO;
import itson.sistemarestaurantepersistencia.IProductosDAO;
import itson.sistemarestaurantepersistencia.implementaciones.ClientesDAO;
import itson.sistemarestaurantepersistencia.implementaciones.ComandasDAO;
import itson.sistemarestaurantepersistencia.implementaciones.DetallesComandaDAO;
import itson.sistemarestaurantepersistencia.implementaciones.IngredientesDAO;
import itson.sistemarestaurantepersistencia.implementaciones.MesasDAO;
import itson.sistemarestaurantepersistencia.implementaciones.ProductosDAO;
import itson.sistemarestaurantepersistencia.implementaciones.IngredientesProductosDAO;

/**
 * Clase que crea los objetos de negocio de la aplicacion
 * @author pc
 */
public class ObjetosNegocioFactory {

    /**
     * Metodo para crear un objeto de negocio de mesas
     * @return Objeto de negocio de mesas
     */
    public static IMesasBO crearMesasBO(){
        IMesasDAO mesasDAO = new MesasDAO();
        IMesasBO mesasBO = new MesasBO(mesasDAO);
        return mesasBO;
    }

    /**
     * Metodo para crear un objeto de negocio de clientes
     * @return Objeto de negocio de clientes
     */
    public static IClientesBO crearClientesBO() {
        IClientesDAO clientesDAO = new ClientesDAO();
        IClientesBO clientesBO = new ClientesBO(clientesDAO);
        return clientesBO;
    }
    
    /**
     * Metodo para crear un objeto de negocio de productos
     * @return Objeto de negocio de productos
     */
    public static IProductosBO crearProductosBO(){
        IProductosDAO productosDAO = new ProductosDAO();
        IProductosBO productosBO = new ProductosBO(productosDAO);
        return productosBO;
    }
    
    /**
     * Metodo para crear un objeto de negocio de ingredientes
     * @return Objeto de negocio de ingredientes
     */
    public static IIngredientesBO crearIngredientesBO(){
        IIngredientesDAO ingredientesDAO = new IngredientesDAO();
        IIngredientesBO ingredientesBO = new IngredientesBO(ingredientesDAO);
        return ingredientesBO;
    }

    /**
     * Metodo para crear un objeto de negocio de ingredientes productos
     * @return Objeto de negocio de ingredientes productos
     */
    public static IIngredientesProductoBO crearIngredientesProductoBO(){
        IIngredientesProductosDAO ingredientesDAO = new IngredientesProductosDAO();
        IIngredientesProductoBO ingredientesProductoBO = new IngredientesProductoBO(ingredientesDAO);
        return ingredientesProductoBO;
    }

    /**
     * Metodo para crear un objeto de negocio de comandas
     * @return Objeto de negocio de comandas
     */
    public static IComandasBO crearComandasBO(){
        IComandasDAO comandasDAO = new ComandasDAO();
        IComandasBO comandasBO = new ComandasBO(comandasDAO);
        return comandasBO;
    }

    public static IDetallesComandaBO crearDetallesComandaBO(){
        IDetallesComandaDAO detallesComandaDAO = new DetallesComandaDAO();
        IDetallesComandaBO detallesComandaBO = new DetallesComandaBO(detallesComandaDAO);
        return detallesComandaBO;
    }
}
