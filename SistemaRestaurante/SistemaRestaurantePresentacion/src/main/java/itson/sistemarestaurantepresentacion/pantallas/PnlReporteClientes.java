/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package itson.sistemarestaurantepresentacion.pantallas;

import itson.sistemarestaurantepresentacion.control.ControlFlujo;
import itson.sistemarestaurantepresentacion.control.ControlReportes;
import java.awt.Font;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class PnlReporteClientes extends javax.swing.JPanel {

    /**
     * Creates new form PnlReporteComandas
     */
    public PnlReporteClientes() {
        initComponents();
    }

    private void generarReporte(String txtNombre, String txtMinVisitas) {
        if (validarCampos(txtNombre, txtMinVisitas)) {

            ControlReportes reportes = new ControlReportes();
            int campoMinVisitas = 0;

            if (!txtMinVisitas.isBlank()) {
                campoMinVisitas = Integer.parseInt(txtMinVisitas);
            }

            if ((txtNombre == null || txtNombre.isBlank()) && campoMinVisitas == 0) {
                reportes.generarReporteClientes();
            }

            if ((txtNombre != null || !txtNombre.isBlank()) && campoMinVisitas == 0) {
                reportes.generarReporteClientes(txtNombre);
            }

            if ((txtNombre.isBlank()) && campoMinVisitas > 0) {
                reportes.generarReporteClientes(campoMinVisitas);
            }

            if ((!txtNombre.isBlank()) && campoMinVisitas > 0) {
                reportes.generarReporteClientes(txtNombre, campoMinVisitas);
            }

        }
    }

    /**
     * Metodo que valida campos de texto
     *
     * @param txtNombre Campo de texto de nombre
     * @param txtMinVisitas Campo de texto de minimo de visitas
     * @return True si todo es correcto, False si se encuentra un problema en
     * los formatos
     */
    private boolean validarCampos(String txtNombre, String txtMinVisitas) {
        if (!txtNombre.isEmpty()) {
            if (!txtNombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("El nombre solo debe contener letras y espacios.");
                JOptionPane.showMessageDialog(this,
                        "El campo de nombre no puede tener numeros o caracteres especiales.",
                        "INFO", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }

        if (!txtMinVisitas.isEmpty()) {
            if (!txtMinVisitas.matches("^[0-9]+$")) {
                System.out.println("MinVisitas debe ser un número entero positivo sin caracteres especiales.");
                JOptionPane.showMessageDialog(this,
                        "El campo de nombre no puede tener letras o caracteres especiales.",
                        "INFO", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

            int visitas = Integer.parseInt(txtMinVisitas);
            if (visitas <= 0) {
                JOptionPane.showMessageDialog(this,
                        "El campo de nombre debe de ser mayor o igual a 0.",
                        "INFO", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        lblTitulo3 = new javax.swing.JLabel();
        lblTitulo4 = new javax.swing.JLabel();
        lblTitulo6 = new javax.swing.JLabel();
        btnGenerarReporte = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtMinNumVisitas = new javax.swing.JTextField();

        setBackground(new java.awt.Color(37, 40, 54));
        setMaximumSize(new java.awt.Dimension(1240, 930));

        jPanel4.setBackground(new java.awt.Color(37, 40, 54));

        lblTitulo3.setText("Buscar por nombre");
        lblTitulo3.setFont(new Font("Poppins", Font.BOLD, 20));
        lblTitulo3.setForeground(new java.awt.Color(255, 255, 255));

        lblTitulo4.setText("Reporte de Clientes Frecuentes");
        lblTitulo4.setFont(new Font("Poppins", Font.BOLD, 36));
        lblTitulo4.setForeground(new java.awt.Color(255, 255, 255));

        lblTitulo6.setText("Minimo numero de visitas");
        lblTitulo6.setFont(new Font("Poppins", Font.BOLD, 20));
        lblTitulo6.setForeground(new java.awt.Color(255, 255, 255));

        btnGenerarReporte.setText("GenerarReporte");
        btnGenerarReporte.setBackground(new java.awt.Color(80, 205, 137));
        btnGenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarReporte.setFont(new Font("Poppins", Font.PLAIN, 18));
        btnGenerarReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new Font("Poppins", Font.PLAIN, 18));
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));

        txtMinNumVisitas.setBackground(new java.awt.Color(255, 255, 255));
        txtMinNumVisitas.setFont(new Font("Poppins", Font.PLAIN, 18));
        txtMinNumVisitas.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMinNumVisitas)
                            .addComponent(lblTitulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(575, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(lblTitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(743, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMinNumVisitas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addComponent(btnGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(496, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(lblTitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(820, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed

        try{
            generarReporte(txtNombre.getText(), txtMinNumVisitas.getText());
            ControlFlujo.mostrarPnlMenuReportes();
        } catch (Exception e){
            JOptionPane.showMessageDialog(this,
                        "SABE PA: " + e.getMessage(),
                        "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnGenerarReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTitulo4;
    private javax.swing.JLabel lblTitulo6;
    private javax.swing.JTextField txtMinNumVisitas;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
