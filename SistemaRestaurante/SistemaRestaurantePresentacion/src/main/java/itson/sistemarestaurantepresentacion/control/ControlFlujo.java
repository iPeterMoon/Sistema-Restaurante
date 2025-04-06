package itson.sistemarestaurantepresentacion.control;

import itson.sistemarestaurantepresentacion.pantallas.FramePrincipal;
import itson.sistemarestaurantepresentacion.pantallas.PnlBuscarCliente;
import itson.sistemarestaurantepresentacion.pantallas.PnlBuscarIngredientes;
import itson.sistemarestaurantepresentacion.pantallas.PnlBuscarProductos;
import itson.sistemarestaurantepresentacion.pantallas.PnlComandas;
import itson.sistemarestaurantepresentacion.pantallas.PnlInicio;
import itson.sistemarestaurantepresentacion.pantallas.PnlMesas;
import itson.sistemarestaurantepresentacion.pantallas.PnlRegistrarCliente;
import itson.sistemarestaurantepresentacion.pantallas.PnlRegistrarComanda;

import javax.swing.JFrame;
import javax.swing.JPanel;

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

    public static void mostrarPnlRegistroComanda() {
        PnlRegistrarComanda pnlRegistrarComanda = new PnlRegistrarComanda();
        mostrarPanel(pnlRegistrarComanda);
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
     * Metodo para moestrar el panel de ingredientes en el frame principal. Se
     * crea una instancia del panel de productos y se llama al metodo
     * mostrarPanel.
     */
    public static void mostrarPnlIngredientes() {
        PnlBuscarIngredientes pnlBuscarIngredientes = new PnlBuscarIngredientes();
        mostrarPanel(pnlBuscarIngredientes);
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
