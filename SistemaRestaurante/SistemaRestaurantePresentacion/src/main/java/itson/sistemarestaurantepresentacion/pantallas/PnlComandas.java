
package itson.sistemarestaurantepresentacion.pantallas;

import itson.sistemarestaurantedominio.dtos.ComandaDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.factory.ObjetosNegocioFactory;
import itson.sistemarestaurantenegocio.interfaces.IComandasBO;
import itson.sistemarestaurantepresentacion.control.ControlFlujo;
import itson.sistemarestaurantepresentacion.paneles.PnlComanda;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * Clase que representa el panel de comandas en la
 * interfaz de usuario. Este panel permite ir a la seccion para agregar nuevas comandas.
 * @author pc
 */
public class PnlComandas extends javax.swing.JPanel {

    /**
     * Creates new form PnlComandas
     */
    public PnlComandas() {
        initComponents();
        cargarComandas();
    }

    private void cargarComandas(){
        IComandasBO comandasBO = ObjetosNegocioFactory.crearComandasBO();
        List<ComandaDTO> comandas = null;
        try{
            comandas = comandasBO.obtenerComandas();
        } catch(NegocioException e){
            JOptionPane.showMessageDialog(
                null, 
                e.getMessage(), 
                "No se encontraron comandas", 
                JOptionPane.INFORMATION_MESSAGE
            );
        }
        if(comandas != null){
            cargarPanelesComandas(comandas);
        }
    }
        /**
     * Metodo para cargar los productos en paneles
     *
     * @param productos lista de productos a cargar
     */
    private void cargarPanelesComandas(List<ComandaDTO> comandas) {

        this.pnlComandas.removeAll();
        int contador = 1;
        JPanel pnlGridComandas = new JPanel();
        for (ComandaDTO comanda : comandas) {
            if (contador == 1) {
                pnlGridComandas = new JPanel();
                pnlGridComandas.setLayout(new GridLayout(0, 3, 25, 10));
                pnlGridComandas.setPreferredSize(new Dimension(1100, 250));
                pnlGridComandas.setMaximumSize(pnlGridComandas.getPreferredSize());
                pnlGridComandas.setBackground(new Color(37,40,54));

                pnlComandas.add(pnlGridComandas);
                pnlComandas.add(Box.createVerticalStrut(30));

            }
            PnlComanda pnlComanda = new PnlComanda(comanda);
            pnlGridComandas.add(pnlComanda);
            pnlGridComandas.repaint();
            pnlGridComandas.revalidate();
            contador++;
            if (contador > 3) {
                contador = 1;
            }
        }
        pnlComandas.revalidate();
        pnlComandas.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        lblBienvenido = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        scrollPnlComandas = new javax.swing.JScrollPane();
        pnlComandas = new javax.swing.JPanel();

        pnlPrincipal.setBackground(new java.awt.Color(37, 40, 54));

        lblBienvenido.setFont(new Font("Poppins", Font.BOLD, 36));
        lblBienvenido.setForeground(new java.awt.Color(255, 255, 255));
        lblBienvenido.setText("Comandas");

        btnCancelar.setBackground(new java.awt.Color(80, 205, 137));
        btnCancelar.setFont(new Font("Poppins", Font.PLAIN, 18));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Agregar Nueva Comanda");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        scrollPnlComandas.setBackground(new java.awt.Color(37, 40, 54));
        scrollPnlComandas.setBorder(null);

        pnlComandas.setBackground(new java.awt.Color(37, 40, 54));
        pnlComandas.setLayout(new javax.swing.BoxLayout(pnlComandas, javax.swing.BoxLayout.Y_AXIS));
        scrollPnlComandas.setViewportView(pnlComandas);

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lblBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(scrollPnlComandas, javax.swing.GroupLayout.PREFERRED_SIZE, 1157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPnlComandas, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ControlFlujo.mostrarPnlRegistroComanda();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JPanel pnlComandas;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JScrollPane scrollPnlComandas;
    // End of variables declaration//GEN-END:variables
}
