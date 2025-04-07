
package itson.sistemarestaurantepresentacion.pantallas;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.IngredienteDTO;
import itson.sistemarestaurantedominio.enumeradores.TipoProducto;
import itson.sistemarestaurantepresentacion.control.ControlFlujo;
import itson.sistemarestaurantepresentacion.modales.ModalIngredientes;
import itson.sistemarestaurantepresentacion.paneles.PnlIngredienteProducto;

import java.awt.Font;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Box;

/**
 *
 * @author pc
 */
public class PnlAgregarProducto extends javax.swing.JPanel {

    List<PnlIngredienteProducto> ingredientes = new LinkedList<>();

    /**
     * Creates new form PnlAgregarProducto
     */
    public PnlAgregarProducto() {
        initComponents();
        cargarTiposProducto();
    }

    /**
     * Metodo que carga los tipos de producto al comboBox
     */
    private void cargarTiposProducto(){
        TipoProducto[] tipos = TipoProducto.values();
        comboBoxTipo.removeAllItems();
        comboBoxTipo.addItem("Selecciona un tipo");
        comboBoxTipo.setSelectedIndex(0);
        // Agregar los tipos de producto al comboBox
        for (TipoProducto tipo : tipos) {
            comboBoxTipo.addItem(tipo.toString().substring(0, 1).toUpperCase() + tipo.toString().substring(1).toLowerCase());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        pnlComanda = new itson.sistemarestaurantepresentacion.recursos.RoundedPanel();
        lblNombre = new javax.swing.JLabel();
        btnBuscarIngredientes = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JLabel();
        scrollPnlIngredientesProducto = new javax.swing.JScrollPane();
        pnlIngredientesProducto = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        comboBoxTipo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        pnlPrincipal.setBackground(new java.awt.Color(37, 40, 54));

        lblTitulo.setFont(new Font("Poppins", Font.BOLD, 36));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Agregar Nuevo Producto");

        btnCancelar.setBackground(new java.awt.Color(94, 94, 94));
        btnCancelar.setFont(new Font("Poppins", Font.PLAIN, 18));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        pnlComanda.setBackground(new java.awt.Color(31, 31, 31));
        pnlComanda.setRoundBottomLeft(50);
        pnlComanda.setRoundBottomRight(50);
        pnlComanda.setRoundTopLeft(50);
        pnlComanda.setRoundTopRight(50);

        lblNombre.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre del producto:");

        btnBuscarIngredientes.setBackground(new java.awt.Color(217, 217, 217));
        btnBuscarIngredientes.setFont(new Font("Poppins", Font.PLAIN, 16));
        btnBuscarIngredientes.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarIngredientes.setText("Buscar Ingredientes");
        btnBuscarIngredientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarIngredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarIngredientesActionPerformed(evt);
            }
        });

        lblCliente.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblCliente.setText("Precio: ");

        txtCliente.setFont(new Font("Poppins", Font.PLAIN, 18));
        txtCliente.setForeground(new java.awt.Color(255, 255, 255));

        scrollPnlIngredientesProducto.setBorder(null);

        pnlIngredientesProducto.setBackground(new java.awt.Color(31, 31, 31));
        pnlIngredientesProducto.setLayout(new javax.swing.BoxLayout(pnlIngredientesProducto, javax.swing.BoxLayout.Y_AXIS));
        scrollPnlIngredientesProducto.setViewportView(pnlIngredientesProducto);

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new Font("Poppins", Font.PLAIN, 18));
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));

        txtPrecio.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecio.setFont(new Font("Poppins", Font.PLAIN, 18));
        txtPrecio.setForeground(new java.awt.Color(0, 0, 0));

        lblTipo.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo.setText("Tipo de Producto:");

        comboBoxTipo.setBackground(new java.awt.Color(255, 255, 255));
        comboBoxTipo.setFont(new Font("Poppins", Font.PLAIN, 18));
        comboBoxTipo.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout pnlComandaLayout = new javax.swing.GroupLayout(pnlComanda);
        pnlComanda.setLayout(pnlComandaLayout);
        pnlComandaLayout.setHorizontalGroup(
            pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComandaLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlComandaLayout.createSequentialGroup()
                        .addComponent(scrollPnlIngredientesProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(pnlComandaLayout.createSequentialGroup()
                        .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlComandaLayout.createSequentialGroup()
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(pnlComandaLayout.createSequentialGroup()
                                .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27)))
                        .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlComandaLayout.createSequentialGroup()
                                .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnBuscarIngredientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(107, 107, 107))))
        );
        pnlComandaLayout.setVerticalGroup(
            pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComandaLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxTipo)
                    .addComponent(btnBuscarIngredientes, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(scrollPnlIngredientesProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(80, 205, 137));
        jButton1.setFont(new Font("Poppins", Font.PLAIN, 18));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Agregar Producto");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(pnlComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ControlFlujo.mostrarPnlProductos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarIngredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarIngredientesActionPerformed
        ModalIngredientes modal = new ModalIngredientes(null, true);
        IngredienteDTO ingrediente = modal.obtenerIngrediente();
        if(ingrediente == null){
            return;
        }
        PnlIngredienteProducto panelIngrediente = new PnlIngredienteProducto(ingrediente);
        ingredientes.add(panelIngrediente);
        cargarPanelesIngredientes();
    }//GEN-LAST:event_btnBuscarIngredientesActionPerformed

    /**
     * Método para cargar los paneles de ingredientes en el panel
     * pnlIngredientesProducto.
     * Este método recorre la lista de ingredientes y agrega cada panel
     * PnlIngredienteProducto al panel pnlIngredientesProducto.
     */
    private void cargarPanelesIngredientes() {
        pnlIngredientesProducto.removeAll();
        for (PnlIngredienteProducto ingrediente : ingredientes) {
            pnlIngredientesProducto.add(ingrediente);
            pnlIngredientesProducto.add(Box.createVerticalStrut(15));
        }
        pnlIngredientesProducto.revalidate();
        pnlIngredientesProducto.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarIngredientes;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> comboBoxTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private itson.sistemarestaurantepresentacion.recursos.RoundedPanel pnlComanda;
    private javax.swing.JPanel pnlIngredientesProducto;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JScrollPane scrollPnlIngredientesProducto;
    private javax.swing.JLabel txtCliente;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
