package itson.sistemarestaurantepresentacion.control;

import itson.sistemarestaurantenegocio.interfaces.IClientesBO;
import itson.sistemarestaurantenegocio.interfaces.IMesasBO;
import itson.sistemarestaurantepresentacion.pantallas.FramePrincipal;
import itson.sistemarestaurantepresentacion.pantallas.PnlBuscarCliente;
import itson.sistemarestaurantepresentacion.pantallas.PnlInicio;
import itson.sistemarestaurantepresentacion.pantallas.PnlMesas;
import itson.sistemarestaurantepresentacion.pantallas.PnlRegistrarCliente;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControlFlujo {
    
    private FramePrincipal framePrincipal;
    private static ControlFlujo instanciaControl;
    private IMesasBO mesasBO;
    private IClientesBO clientesBO;
    
    /**
     * Constructor privado para implementar el patrón Singleton.
     * Se inicializa el frame principal.
     */
    private ControlFlujo(){
        framePrincipal = new FramePrincipal();
    }
    
    /**
     * Método para obtener la instancia única de ControlFlujo.
     * @return instanciaControl Singleton de ControlFlujo.
     */
    public static ControlFlujo getInstance(){
        if(instanciaControl == null){
            instanciaControl = new ControlFlujo();
        }
        return instanciaControl;
    }
    
    /**
     * Método para iniciar el flujo de la aplicación.
     * Se muestra el panel de inicio y el frame principal.
     */
    public void iniciarFlujo(){
        mostrarInicio();
        mostrarFramePrincipal();
    }
    
    /**
     * Método para mostrar el frame principal de la aplicación.
     * Se establece la operación de cierre, la ubicación y la capacidad de redimensionar.
     */
    private void mostrarFramePrincipal(){
        framePrincipal.setVisible(true);
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.setResizable(false);
    }
    
    /**
     * Método para mostrar el panel de inicio en el frame principal.
     * Se crea una instancia del panel de inicio y se llama al método mostrarPanel.
     */
    public void mostrarInicio(){
        PnlInicio pnlInicio = new PnlInicio();
        mostrarPanel(pnlInicio);
    }
    
    /**
     * Método para mostrar el panel de mesas en el frame principal.
     * Se crea una instancia del panel de mesas y se llama al método mostrarPanel.
     */
    public void mostrarPnlMesas(){
        PnlMesas pnlMesas = new PnlMesas();
        mostrarPanel(pnlMesas);
    }

    /**
     * Método para mostrar el panel de búsqueda de clientes en el frame principal.
     * Se crea una instancia del panel de búsqueda de clientes y se llama al método mostrarPanel.
     */
    public void mostrarPnlClientes(){
        PnlBuscarCliente pnlBuscarCliente = new PnlBuscarCliente();
        mostrarPanel(pnlBuscarCliente);
    }

    /**
     * Método para mostrar el panel de registro de clientes en el frame principal.
     * Se crea una instancia del panel de registro de clientes y se llama al método mostrarPanel.
     */
    public void mostrarPnlRegistrarCliente(){
        PnlRegistrarCliente pnlRegistrarCliente = new PnlRegistrarCliente();
        mostrarPanel(pnlRegistrarCliente);
    }

    /**
     * Método privado para mostrar un panel específico en el frame principal.
     * Se eliminan todos los componentes del panel principal y se agrega el nuevo panel.
     * Luego se repinta y revalida el panel principal.
     * @param panel El panel a mostrar en el frame principal.
     */
    private void mostrarPanel(JPanel panel){
        framePrincipal.getPnlPrincipal().removeAll();
        framePrincipal.getPnlPrincipal().add(panel);
        framePrincipal.getPnlPrincipal().repaint();
        framePrincipal.getPnlPrincipal().revalidate();
    }

  
    /**
     * Metodo para obtener la instancia de IMesasBO.
     * @return mesasBO instancia de IMesasBO.
     */
    public IMesasBO getMesasBO() {
        return mesasBO;
    }

    /**
     * Metodo para establecer la instancia de IMesasBO.
     * @param mesasBO instancia de IMesasBO.
     */
    public void setMesasBO(IMesasBO mesasBO) {
        this.mesasBO = mesasBO;
    }

    /**
     * Metodo para obtener la instancia de IClientesBO.
     * @return clientesBO instancia de IClientesBO.
     */
    public IClientesBO getClientesBO() {
        return clientesBO;
    }

    /**
     * Metodo para establecer la instancia de IClientesBO.
     * @param clientesBO instancia de IClientesBO.
     */
    public void setClientesBO(IClientesBO clientesBO) {
        this.clientesBO = clientesBO;
    }
    
    
}
