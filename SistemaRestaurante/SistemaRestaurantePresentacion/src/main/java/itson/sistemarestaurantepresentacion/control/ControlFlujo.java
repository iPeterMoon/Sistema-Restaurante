package itson.sistemarestaurantepresentacion.control;

import itson.sistemarestaurantedominio.dtos.ComandaDTO;
import itson.sistemarestaurantedominio.dtos.ProductoDTO;
import itson.sistemarestaurantepresentacion.pantallas.FramePrincipal;
import itson.sistemarestaurantepresentacion.pantallas.PnlAgregarIngrediente;
import itson.sistemarestaurantepresentacion.pantallas.PnlAgregarProducto;
import itson.sistemarestaurantepresentacion.pantallas.PnlBuscarCliente;
import itson.sistemarestaurantepresentacion.pantallas.PnlBuscarIngredientes;
import itson.sistemarestaurantepresentacion.pantallas.PnlBuscarProductos;
import itson.sistemarestaurantepresentacion.pantallas.PnlComandas;
import itson.sistemarestaurantepresentacion.pantallas.PnlEspecificacionesComanda;
import itson.sistemarestaurantepresentacion.pantallas.PnlIngredientesProducto;
import itson.sistemarestaurantepresentacion.pantallas.PnlInicio;
import itson.sistemarestaurantepresentacion.pantallas.PnlMesas;
import itson.sistemarestaurantepresentacion.pantallas.PnlModificarComanda;
import itson.sistemarestaurantepresentacion.pantallas.PnlRegistrarCliente;
import itson.sistemarestaurantepresentacion.pantallas.PnlRegistrarComanda;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Clase ControlFlujo que maneja el flujo de la aplicación. Permite mostrar
 * diferentes paneles en el frame principal y gestionar la navegación entre
 * ellos.
 * @author PC
 */
public class ControlFlujo {

    private static final FramePrincipal framePrincipal = new FramePrincipal();

    /**
     * Método para iniciar el flujo de la aplicación. Se muestra el panel de
     * inicio y el frame principal.
     */
    public static void iniciarFlujo() {
        mostrarInicio();
        mostrarFramePrincipal();
    }

    /**
     * Método para mostrar el frame principal de la aplicación. Se establece la
     * operación de cierre, la ubicación y la capacidad de redimensionar.
     */
    private static void mostrarFramePrincipal() {
        framePrincipal.setVisible(true);
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.setResizable(false);
    }

    /**
     * Método para mostrar el panel de inicio en el frame principal. Se crea una
     * instancia del panel de inicio y se llama al método mostrarPanel.
     */
    public static void mostrarInicio() {
        PnlInicio pnlInicio = new PnlInicio();
        mostrarPanel(pnlInicio);
    }

    /**
     * Método para mostrar el panel de comandas en el frame principal. Se crea
     * una instancia del panel de comandas y se llama al método mostrarPanel.
     */
    public static void mostrarComandas() {
        PnlComandas pnlComandas = new PnlComandas();
        mostrarPanel(pnlComandas);
    }

    /**
     * Metodo para mostrar el panel con las especificaciones de una comanda
     * @param comanda Comanda a mostrar.
     */
    public static void mostrarEspecificacionesComanda(ComandaDTO comanda){
        PnlEspecificacionesComanda pnlEspecificacionesComanda = new PnlEspecificacionesComanda(comanda);
        mostrarPanel(pnlEspecificacionesComanda);
    }

    /**
     * Método para mostrar el panel de registro de comandas en el frame
     * principal. Se crea una instancia del panel de registro de comandas y se
     */
    public static void mostrarPnlRegistroComanda() {
        PnlRegistrarComanda pnlRegistrarComanda = new PnlRegistrarComanda();
        mostrarPanel(pnlRegistrarComanda);
    }

    /**
     * Metodo para mostrar el panel de modificacion de una comanda en 
     * el frame principal.
     * @param comanda
     */
    public static void mostrarPnlModificarComanda(ComandaDTO comanda){
        PnlModificarComanda pnlModificarComanda = new PnlModificarComanda(comanda);
        mostrarPanel(pnlModificarComanda);
    }

    /**
     * Metodo para mostrar el panel de productos en el frame principal. Se crea
     * una instancia del panel de productos y se llama al metodo mostrarPanel.
     */
    public static void mostrarPnlProductos() {
        PnlBuscarProductos pnlBuscarProductos = new PnlBuscarProductos();
        mostrarPanel(pnlBuscarProductos);
    }

    /**
     * Metodo para mostrar el panel de agregar productos en el frame principal.
     * Se crea una instancia del panel de agregar productos y se llama al metodo
     * mostrarPanel.
     */
    public static void mostrarPnlAgregarProducto(){
        PnlAgregarProducto pnlAgregarProducto = new PnlAgregarProducto();
        mostrarPanel(pnlAgregarProducto);
    }

    /**
     * Metodo para mostrar el panel de ingredientes de un producto en el frame
     * principal. Se crea una instancia del panel de ingredientes y se llama al
     * metodo mostrarPanel.
     *
     * @param producto ProductoDTO que contiene la informacion del producto
     */
    public static void mostrarPnlIngredientesProducto(ProductoDTO producto){
        PnlIngredientesProducto pnlIngredientesProducto = new PnlIngredientesProducto(producto);
        mostrarPanel(pnlIngredientesProducto);
    }

    /**
     * Metodo para moestrar el panel de ingredientes en el frame principal. Se
     * crea una instancia del panel de productos y se llama al metodo
     * mostrarPanel.
     */
    public static void mostrarPnlIngredientes() {
        PnlBuscarIngredientes pnlBuscarIngredientes = new PnlBuscarIngredientes();
        mostrarPanel(pnlBuscarIngredientes);
    }

    /**
     * Metodo para mostrar el panel con el que se agregan los clientes en el
     * frame principal. Se crea una instancia del panel de busqueda de clientes
     * y se llama al metodo mostrarPanel.
     */
    public static void mostrarPnlAgregarIngrediente() {
        PnlAgregarIngrediente pnlAgregarIngrediente = new PnlAgregarIngrediente();
        mostrarPanel(pnlAgregarIngrediente);
    }

    /**
     * Método para mostrar el panel de mesas en el frame principal. Se crea una
     * instancia del panel de mesas y se llama al método mostrarPanel.
     */
    public static void mostrarPnlMesas() {
        PnlMesas pnlMesas = new PnlMesas();
        mostrarPanel(pnlMesas);
    }

    /**
     * Método para mostrar el panel de búsqueda de clientes en el frame
     * principal. Se crea una instancia del panel de búsqueda de clientes y se
     * llama al método mostrarPanel.
     */
    public static void mostrarPnlClientes() {
        PnlBuscarCliente pnlBuscarCliente = new PnlBuscarCliente();
        mostrarPanel(pnlBuscarCliente);
    }

    /**
     * Método para mostrar el panel de registro de clientes en el frame
     * principal. Se crea una instancia del panel de registro de clientes y se
     * llama al método mostrarPanel.
     */
    public static void mostrarPnlRegistrarCliente() {
        PnlRegistrarCliente pnlRegistrarCliente = new PnlRegistrarCliente();
        mostrarPanel(pnlRegistrarCliente);
    }

    /**
     * Método privado para mostrar un panel específico en el frame principal. Se
     * eliminan todos los componentes del panel principal y se agrega el nuevo
     * panel. Luego se repinta y revalida el panel principal.
     *
     * @param panel El panel a mostrar en el frame principal.
     */
    private static void mostrarPanel(JPanel panel) {
        framePrincipal.getPnlPrincipal().removeAll();
        framePrincipal.getPnlPrincipal().add(panel);
        framePrincipal.getPnlPrincipal().repaint();
        framePrincipal.getPnlPrincipal().revalidate();
    }

}
