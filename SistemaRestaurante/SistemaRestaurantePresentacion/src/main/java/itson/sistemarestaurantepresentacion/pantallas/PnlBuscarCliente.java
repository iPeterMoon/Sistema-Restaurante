package itson.sistemarestaurantepresentacion.pantallas;

import java.awt.Font;

import itson.sistemarestaurantenegocio.interfaces.IClientesBO;
import itson.sistemarestaurantepresentacion.control.ControlFlujo;
/**
 *
 * @author pc
 */
public class PnlBuscarCliente extends javax.swing.JPanel {

    
    /**
     * Creates new form PnlBuscarCliente
     */
    public PnlBuscarCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBusquedaCliente1 = new paneles.PnlBusquedaCliente();
        pnlPrincipal = new javax.swing.JPanel();
        lblBienvenido = new javax.swing.JLabel();
        btnRegistrarMesas = new javax.swing.JButton();
        pnlBusquedaCliente2 = new paneles.PnlBusquedaCliente();

        pnlPrincipal.setBackground(new java.awt.Color(37, 40, 54));

        lblBienvenido.setFont(new Font("Poppins", Font.BOLD, 36));
        lblBienvenido.setForeground(new java.awt.Color(255, 255, 255));
        lblBienvenido.setText("Clientes Frecuentes");

        btnRegistrarMesas.setBackground(new java.awt.Color(80, 205, 137));
        btnRegistrarMesas.setFont(new Font("Poppins", Font.PLAIN, 18));
        btnRegistrarMesas.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarMesas.setText("Registrar Nuevo Cliente");
        btnRegistrarMesas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarMesasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lblBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrarMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(pnlBusquedaCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlBusquedaCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarMesasActionPerformed
        ControlFlujo.mostrarPnlRegistrarCliente();
    }//GEN-LAST:event_btnRegistrarMesasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarMesas;
    private javax.swing.JLabel lblBienvenido;
    private paneles.PnlBusquedaCliente pnlBusquedaCliente1;
    private paneles.PnlBusquedaCliente pnlBusquedaCliente2;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
