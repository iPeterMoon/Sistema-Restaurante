package paneles;
import java.awt.Font;
import java.util.List;

import javax.swing.Box;
import javax.swing.JOptionPane;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.interfaces.IClientesBO;
import itson.sistemarestaurantepresentacion.control.ControlFlujo;
/**
 *
 * @author pc
 */
public class PnlBusquedaCliente extends javax.swing.JPanel {

    /**
     * Creates new form PnlBusquedaCliente
     */
    public PnlBusquedaCliente() {
        initComponents();
        cargarClientes();
    }


    /**
     * Método para cargar los clientes en el panel pnlClientes.
     * Este método debe ser llamado después de inicializar el componente.
     */
    private void cargarClientes(){
        IClientesBO clientesBO = obtenerClientesBO();
        try{
            List<Cliente> clientes = clientesBO.obtenerClientesFrecuentes();
            pnlClientes.removeAll();
            for(Cliente cliente : clientes){
                PnlCliente pnlCliente = new PnlCliente(cliente);
                pnlClientes.add(pnlCliente);
                pnlClientes.add(Box.createVerticalStrut(30));
            }
        } catch(NegocioException ex){
            System.out.println(ex.getMessage());
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoTextoNombre = new javax.swing.JTextField();
        campoTextoCorreo = new javax.swing.JTextField();
        campoTextoTelefono = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlClientes = new javax.swing.JPanel();

        setBackground(new java.awt.Color(31, 31, 31));

        campoTextoNombre.setBackground(new java.awt.Color(255, 255, 255));
        campoTextoNombre.setFont(new Font("Poppins", Font.PLAIN, 16));
        campoTextoNombre.setForeground(new java.awt.Color(0, 0, 0));
        campoTextoNombre.setText("Buscar por Nombre");
        campoTextoNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoTextoNombreMouseClicked(evt);
            }
        });

        campoTextoCorreo.setBackground(new java.awt.Color(255, 255, 255));
        campoTextoCorreo.setFont(new Font("Poppins", Font.PLAIN, 16));
        campoTextoCorreo.setForeground(new java.awt.Color(0, 0, 0));
        campoTextoCorreo.setText("Buscar por Correo");
        campoTextoCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoTextoCorreoMouseClicked(evt);
            }
        });

        campoTextoTelefono.setBackground(new java.awt.Color(255, 255, 255));
        campoTextoTelefono.setFont(new Font("Poppins", Font.PLAIN, 16));
        campoTextoTelefono.setForeground(new java.awt.Color(0, 0, 0));
        campoTextoTelefono.setText("Buscar por Telefono");
        campoTextoTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoTextoTelefonoMouseClicked(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(80, 205, 137));
        btnBuscar.setFont(new Font("Poppins", Font.PLAIN, 16));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jScrollPane1.setBorder(null);

        pnlClientes.setBackground(new java.awt.Color(31, 31, 31));
        pnlClientes.setLayout(new javax.swing.BoxLayout(pnlClientes, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(pnlClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(campoTextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campoTextoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campoTextoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTextoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTextoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoTextoNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoTextoNombreMouseClicked
        this.campoTextoNombre.setText("");
    }//GEN-LAST:event_campoTextoNombreMouseClicked

    private void campoTextoCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoTextoCorreoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoCorreoMouseClicked

    private void campoTextoTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoTextoTelefonoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoTelefonoMouseClicked


    /**
     * Método para obtener el objeto IClientesBO.
     * @return IClientesBO objeto de negocio de clientes.
     */
    private IClientesBO obtenerClientesBO(){
        ControlFlujo controlFlujo = ControlFlujo.getInstance();
        return controlFlujo.getClientesBO();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JTextField campoTextoCorreo;
    private javax.swing.JTextField campoTextoNombre;
    private javax.swing.JTextField campoTextoTelefono;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlClientes;
    // End of variables declaration//GEN-END:variables
}
