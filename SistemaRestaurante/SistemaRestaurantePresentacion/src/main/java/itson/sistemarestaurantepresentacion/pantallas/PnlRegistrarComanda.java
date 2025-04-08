package itson.sistemarestaurantepresentacion.pantallas;

import itson.sistemarestaurantedominio.dtos.ClienteComandaDTO;
import itson.sistemarestaurantedominio.dtos.MesaDTO;
import itson.sistemarestaurantedominio.dtos.ProductoDTO;
import itson.sistemarestaurantenegocio.factory.ObjetosNegocioFactory;
import itson.sistemarestaurantenegocio.interfaces.IMesasBO;
import itson.sistemarestaurantepresentacion.control.ControlFlujo;
import itson.sistemarestaurantepresentacion.modales.ModalClientes;
import itson.sistemarestaurantepresentacion.modales.ModalProductos;
import itson.sistemarestaurantepresentacion.paneles.PnlDetalleComanda;

import java.awt.Font;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Box;

/**
 * Clase que representa el panel de registro de comandas en la
 * interfaz de usuario. Este panel permite registrar una nueva comanda
 * @author Peter
 */
public class PnlRegistrarComanda extends javax.swing.JPanel {

    private ClienteComandaDTO clienteComanda;
    private List<PnlDetalleComanda> detallesComanda = new LinkedList<>();

    /**
     * Creates new form PnlRegistrarComanda
     */
    public PnlRegistrarComanda() {
        initComponents();
        cargarMesas();
    }

    private void cargarMesas(){
        IMesasBO mesasBO = ObjetosNegocioFactory.crearMesasBO();
        try {
            jComboBox1.removeAllItems();
            List<MesaDTO> mesas = mesasBO.obtenerMesasDisponibles();
            for(MesaDTO mesa : mesas) {
                jComboBox1.addItem("Mesa "+mesa.getNumeroMesa());
            }
        } catch (Exception e) {
            System.out.println("Error al cargar las mesas: " + e.getMessage());
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
        lblMesa = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnBuscarProductos = new javax.swing.JButton();
        btnBuscarClientes = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JLabel();
        scrollPnlDetallesComanda = new javax.swing.JScrollPane();
        pnlDetallesComanda = new javax.swing.JPanel();

        pnlPrincipal.setBackground(new java.awt.Color(37, 40, 54));

        lblTitulo.setFont(new Font("Poppins", Font.BOLD, 36));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Agregar Comanda");

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

        lblMesa.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblMesa.setForeground(new java.awt.Color(255, 255, 255));
        lblMesa.setText("Elegir Mesa: ");

        jComboBox1.setFont(new Font("Poppins", Font.PLAIN, 18));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnBuscarProductos.setBackground(new java.awt.Color(217, 217, 217));
        btnBuscarProductos.setFont(new Font("Poppins", Font.PLAIN, 16));
        btnBuscarProductos.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarProductos.setText("Buscar Productos");
        btnBuscarProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductosActionPerformed(evt);
            }
        });

        btnBuscarClientes.setBackground(new java.awt.Color(217, 217, 217));
        btnBuscarClientes.setFont(new Font("Poppins", Font.PLAIN, 16));
        btnBuscarClientes.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarClientes.setText("Buscar Clientes");
        btnBuscarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClientesActionPerformed(evt);
            }
        });

        lblCliente.setFont(new Font("Poppins", Font.BOLD, 18));
        lblCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblCliente.setText("Cliente:");

        txtCliente.setFont(new Font("Poppins", Font.PLAIN, 18));
        txtCliente.setForeground(new java.awt.Color(255, 255, 255));

        scrollPnlDetallesComanda.setBorder(null);

        pnlDetallesComanda.setBackground(new java.awt.Color(31, 31, 31));
        pnlDetallesComanda.setLayout(new javax.swing.BoxLayout(pnlDetallesComanda, javax.swing.BoxLayout.Y_AXIS));
        scrollPnlDetallesComanda.setViewportView(pnlDetallesComanda);

        javax.swing.GroupLayout pnlComandaLayout = new javax.swing.GroupLayout(pnlComanda);
        pnlComanda.setLayout(pnlComandaLayout);
        pnlComandaLayout.setHorizontalGroup(
            pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlComandaLayout.createSequentialGroup()
                .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlComandaLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnBuscarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlComandaLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177)
                        .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(107, 107, 107))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlComandaLayout.createSequentialGroup()
                .addGap(0, 37, Short.MAX_VALUE)
                .addComponent(scrollPnlDetallesComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        pnlComandaLayout.setVerticalGroup(
            pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComandaLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPnlDetallesComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addContainerGap(172, Short.MAX_VALUE))
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
        ControlFlujo.mostrarComandas();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClientesActionPerformed
        ModalClientes modalClientes = new ModalClientes(null, true);
        ClienteComandaDTO cliente = modalClientes.obtenerClienteComanda();
        if (cliente == null) {
            return;
        }
        clienteComanda = cliente;
        txtCliente.setText(cargarCliente(clienteComanda));
        
    }//GEN-LAST:event_btnBuscarClientesActionPerformed

    private void btnBuscarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductosActionPerformed
        ModalProductos modalProductos = new ModalProductos(null, true);
        ProductoDTO producto = modalProductos.obtenerProductoSeleccionado();
        if (producto == null) {
            return;
        }
        PnlDetalleComanda detalleComanda = new PnlDetalleComanda(producto);
        pnlDetallesComanda.add(detalleComanda);
        pnlDetallesComanda.add(Box.createVerticalStrut(20));
        pnlDetallesComanda.revalidate();
        pnlDetallesComanda.repaint();
        detallesComanda.add(detalleComanda);
        //TODO: Crear el DetallesComandaDTO y agregarlo a la lista de detalles de la comanda
    }//GEN-LAST:event_btnBuscarProductosActionPerformed

    /**
     * Carga el nombre del cliente en el label correspondiente.
     * @param cliente El cliente a cargar.
     */
    private String cargarCliente(ClienteComandaDTO cliente){
        if (cliente != null) {
            return cliente.getNombre() + " " + cliente.getApellidoPaterno()+ " "+ cliente.getApellidoMaterno();
        }
        return "";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarClientes;
    private javax.swing.JButton btnBuscarProductos;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JLabel lblTitulo;
    private itson.sistemarestaurantepresentacion.recursos.RoundedPanel pnlComanda;
    private javax.swing.JPanel pnlDetallesComanda;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JScrollPane scrollPnlDetallesComanda;
    private javax.swing.JLabel txtCliente;
    // End of variables declaration//GEN-END:variables
}
