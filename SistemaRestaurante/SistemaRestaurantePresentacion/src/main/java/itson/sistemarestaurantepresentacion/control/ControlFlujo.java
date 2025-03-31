package itson.sistemarestaurantepresentacion.control;

import itson.sistemarestaurantepresentacion.pantallas.FramePrincipal;
import itson.sistemarestaurantepresentacion.pantallas.PnlInicio;
import itson.sistemarestaurantepresentacion.pantallas.PnlMesas;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControlFlujo {
    
    private FramePrincipal framePrincipal;
    private static ControlFlujo instanciaControl;
    
    private ControlFlujo(){
        framePrincipal = new FramePrincipal();
    }
    
    public static ControlFlujo getInstance(){
        if(instanciaControl == null){
            instanciaControl = new ControlFlujo();
        }
        return instanciaControl;
    }
    
    public void iniciarFlujo(){
        mostrarInicio();
        mostrarFramePrincipal();
    }
    
    private void mostrarFramePrincipal(){
        framePrincipal.setVisible(true);
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.setResizable(false);
    }
    
    public void mostrarInicio(){
        PnlInicio pnlInicio = new PnlInicio();
        mostrarPanel(pnlInicio);
    }
    
    public void mostrarPnlMesas(){
        PnlMesas pnlMesas = new PnlMesas();
        mostrarPanel(pnlMesas);
    }
    
    private void mostrarPanel(JPanel panel){
        framePrincipal.getPnlPrincipal().removeAll();
        framePrincipal.getPnlPrincipal().add(panel);
        framePrincipal.getPnlPrincipal().repaint();
        framePrincipal.getPnlPrincipal().revalidate();
    }
}
