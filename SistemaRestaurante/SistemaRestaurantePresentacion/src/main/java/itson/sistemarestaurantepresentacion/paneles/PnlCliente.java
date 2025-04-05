package itson.sistemarestaurantepresentacion.paneles;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantenegocio.seguridad.Cifrado;
import itson.sistemarestaurantepresentacion.modales.ModalClientes;
import itson.sistemarestaurantepresentacion.recursos.Formatos;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import java.awt.Font;
/**
 *
 * @author pc
 */
public class PnlCliente extends javax.swing.JPanel {

    private PnlBusquedaCliente parent;
    private Cliente cliente;
    
    /**
     * Creates new form panelCliente
     */
    public PnlCliente(PnlBusquedaCliente parent, Cliente cliente) {
        this.parent = parent;
        this.cliente = cliente;
        initComponents();
        cargarDatos();
    }
    
    public PnlCliente(Cliente cliente){
        this.cliente = cliente;
        initComponents();
        cargarDatos();
    }
    
    
    
    private void cargarDatos(){
        String nombreCompleto = cliente.getNombre()+ " "+ cliente.getApellidoPaterno()+ " " + cliente.getApellidoMaterno();
        this.txtCliente.setText(nombreCompleto);
        this.txtCorreo.setText(cliente.getCorreo());
        String telefono = "";
        try{
            telefono = Cifrado.descifrar(cliente.getTelefono());
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    this,
                    "Error al cargar el telefono",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        this.txtTelefono.setText(telefono);
        this.txtFecha.setText(Formatos.cargarFecha(cliente.getFechaRegistro()));
        this.txtPuntos.setText(String.valueOf(cliente.getPuntos()));
        if(parent != null){
            if(parent.isSelectionMode()){
                this.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedPanel1 = new itson.sistemarestaurantepresentacion.recursos.RoundedPanel();
        lblCliente = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        txtCliente = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblPuntos = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JLabel();
        txtPuntos = new javax.swing.JLabel();

        setBackground(new java.awt.Color(31, 31, 31));
        setMaximumSize(new java.awt.Dimension(1000, 150));

        roundedPanel1.setBackground(new java.awt.Color(94, 94, 94));
        roundedPanel1.setMaximumSize(new java.awt.Dimension(1000, 150));
        roundedPanel1.setRoundBottomLeft(40);
        roundedPanel1.setRoundBottomRight(40);
        roundedPanel1.setRoundTopLeft(40);
        roundedPanel1.setRoundTopRight(40);
        roundedPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundedPanel1MouseClicked(evt);
            }
        });

        lblCliente.setFont(new Font("Poppins", Font.BOLD, 18));
        lblCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblCliente.setText("Cliente: ");

        lblCorreo.setFont(new Font("Poppins", Font.BOLD, 18));
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("Correo electrónico:");

        lblFecha.setFont(new Font("Poppins", Font.BOLD, 18));
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Fecha de registro: ");

        txtCliente.setFont(new Font("Poppins", Font.PLAIN, 18));
        txtCliente.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente.setText("Cliente");

        lblTelefono.setFont(new Font("Poppins", Font.BOLD, 18));
        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setText("Telefono:");

        lblPuntos.setFont(new Font("Poppins", Font.BOLD, 18));
        lblPuntos.setForeground(new java.awt.Color(255, 255, 255));
        lblPuntos.setText("Puntos: ");

        txtCorreo.setFont(new Font("Poppins", Font.PLAIN, 18));
        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.setText("Correo");

        txtFecha.setFont(new Font("Poppins", Font.PLAIN, 18));
        txtFecha.setForeground(new java.awt.Color(255, 255, 255));
        txtFecha.setText("Fecha de Registro");

        txtTelefono.setFont(new Font("Poppins", Font.PLAIN, 18));
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setText("Telefono");

        txtPuntos.setFont(new Font("Poppins", Font.BOLD, 24));
        txtPuntos.setForeground(new java.awt.Color(255, 255, 255));
        txtPuntos.setText("00");

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(lblPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPuntos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void roundedPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundedPanel1MouseClicked
        if(parent != null){
            if(parent.isSelectionMode()){
                parent.setClienteSeleccionado(this.cliente);

                //Cerrar el modal
                ModalClientes modal = parent.getModalClientes();
                if(modal != null){
                    modal.dispose();
                }
            }
        }
    }//GEN-LAST:event_roundedPanel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblPuntos;
    private javax.swing.JLabel lblTelefono;
    private itson.sistemarestaurantepresentacion.recursos.RoundedPanel roundedPanel1;
    private javax.swing.JLabel txtCliente;
    private javax.swing.JLabel txtCorreo;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JLabel txtPuntos;
    private javax.swing.JLabel txtTelefono;
    // End of variables declaration//GEN-END:variables
}
