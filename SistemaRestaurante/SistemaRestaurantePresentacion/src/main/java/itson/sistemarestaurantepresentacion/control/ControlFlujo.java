package itson.sistemarestaurantepresentacion.control;

import itson.sistemarestaurantepresentacion.pantallas.FramePrincipal;
import itson.sistemarestaurantepresentacion.pantallas.PantallaPrincipal;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControlFlujo {
    
    private FramePrincipal framePrincipal;
    
    public ControlFlujo(){
        framePrincipal = new FramePrincipal();
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
        framePrincipal.getPnlPrincipal().removeAll();
        framePrincipal.getPnlPrincipal().add(new PantallaPrincipal());
        framePrincipal.getPnlPrincipal().repaint();
        framePrincipal.getPnlPrincipal().revalidate();
    }
}
