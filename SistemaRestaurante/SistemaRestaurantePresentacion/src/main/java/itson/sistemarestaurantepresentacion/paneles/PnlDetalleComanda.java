package itson.sistemarestaurantepresentacion.paneles;

import itson.sistemarestaurantedominio.dtos.DetallesComandaDTO;
import itson.sistemarestaurantedominio.dtos.ProductoDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.factory.ObjetosNegocioFactory;
import itson.sistemarestaurantenegocio.interfaces.IProductosBO;
import itson.sistemarestaurantepresentacion.pantallas.PnlModificarComanda;

import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

/**
 * Clase que representa el panel de detalle de una comanda.
 * Este panel muestra los detalles de un producto en una comanda, incluyendo
 * su nombre, precio unitario, cantidad y comentarios adicionales.
 * Permite al usuario seleccionar la cantidad del producto y muestra el importe
 * total.
 * 
 * @author pc
 */
public class PnlDetalleComanda extends javax.swing.JPanel {

    private ProductoDTO producto;
    private PnlModificarComanda parent;
    private DetallesComandaDTO detallesComanda;

    /**
     * Creates new form PnlDetalleComanda
     */
    public PnlDetalleComanda(ProductoDTO producto) {
        this.producto = producto;
        initComponents();
        cargarDetallesProducto();
        this.btnEliminar.setVisible(false);
    }

    /**
     * Constructor para cuando se muestran las especificaciones de la comanda.
     * 
     * @param detallesComanda
     */
    public PnlDetalleComanda(DetallesComandaDTO detallesComanda) {
        this.detallesComanda = detallesComanda;
        initComponents();
        cargarDetallesComanda(false);
        cargarDetallesProducto();
        btnEliminar.setVisible(false);
    }

    /**
     * Constructor para cuando se muestran las especificaciones
     * de la comanda, pero en un panel de modificar
     */
    public PnlDetalleComanda(DetallesComandaDTO detalles, PnlModificarComanda parent) {
        this.detallesComanda = detalles;
        this.parent = parent;
        initComponents();
        cargarDetallesComanda(true);
        cargarDetallesProducto();
        btnEliminar.setVisible(true);

    }

    /**
     * Método para cargar los detalles del producto en el panel.
     * Se establece el nombre del producto, precio unitario y se inicializa
     * el importe total.
     */
    private void cargarDetallesProducto() {
        String nombreProducto = producto.getNombre();
        this.lblProducto.setText("Producto: " + nombreProducto);
        this.llblPrecio.setText("Precio Unitario: $" + producto.getPrecio().toString());
        this.lblImporte.setText("Importe: $" + producto.getPrecio().toString());
    }

    /**
     * Metodo para cargar los detalles de la comanda en el panel.
     */
    private void cargarDetallesComanda(boolean isEditable) {
        try {
            IProductosBO productosBO = ObjetosNegocioFactory.crearProductosBO();
            ProductoDTO producto = productosBO.obtenerProductoPorId(detallesComanda.getIdProducto());
            this.producto = producto;
            spinnerCantidad.setValue(detallesComanda.getCantidad());
            txtAreaComentarios.setText(detallesComanda.getComentario());
            if(!isEditable){
                spinnerCantidad.setEditor(new JSpinner.DefaultEditor(spinnerCantidad));
                spinnerCantidad.setForeground(new Color(0,0,0));
                txtAreaComentarios.setEditable(false);
            }
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedPanel1 = new itson.sistemarestaurantepresentacion.recursos.RoundedPanel();
        lblProducto = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        llblPrecio = new javax.swing.JLabel();
        lblComentarios = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaComentarios = new javax.swing.JTextArea();
        lblImporte = new javax.swing.JLabel();
        spinnerCantidad = new javax.swing.JSpinner();
        btnEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(31, 31, 31));
        setMaximumSize(new java.awt.Dimension(1000, 150));

        roundedPanel1.setBackground(new java.awt.Color(94, 94, 94));
        roundedPanel1.setRoundBottomLeft(50);
        roundedPanel1.setRoundBottomRight(50);
        roundedPanel1.setRoundTopLeft(50);
        roundedPanel1.setRoundTopRight(50);

        lblProducto.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblProducto.setForeground(new java.awt.Color(255, 255, 255));
        lblProducto.setText("Producto: ....");

        lblCantidad.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblCantidad.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidad.setText("Cantidad: ");

        llblPrecio.setFont(new Font("Poppins", Font.PLAIN, 18));
        llblPrecio.setForeground(new java.awt.Color(255, 255, 255));
        llblPrecio.setText("Precio Unitario: $...");

        lblComentarios.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblComentarios.setForeground(new java.awt.Color(255, 255, 255));
        lblComentarios.setText("Comentarios adicionales:");

        txtAreaComentarios.setBackground(new java.awt.Color(255, 255, 255));
        txtAreaComentarios.setColumns(20);
        txtAreaComentarios.setFont(new Font("Poppins", Font.PLAIN, 18));
        txtAreaComentarios.setForeground(new java.awt.Color(0, 0, 0));
        txtAreaComentarios.setRows(5);
        jScrollPane1.setViewportView(txtAreaComentarios);

        lblImporte.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblImporte.setForeground(new java.awt.Color(255, 255, 255));
        lblImporte.setText("Importe: $...");

        spinnerCantidad.setFont(new Font("Poppins", Font.PLAIN, 18));
        spinnerCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinnerCantidad.setToolTipText("");
        spinnerCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerCantidadStateChanged(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(217, 217, 217));
        btnEliminar.setFont(new Font("Poppins", Font.PLAIN, 16));
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundedPanel1Layout.createSequentialGroup()
                                .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(llblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblComentarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundedPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinnerCantidad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(llblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addGap(25, 25, 25))
                            .addGroup(roundedPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        List<PnlDetalleComanda> panelesDetalles = parent.getPanelesDetalles();
        if(panelesDetalles.size() <= 1){
            JOptionPane.showMessageDialog(
                null, 
                "No se puede quedar sin productos en la comanda", 
                "Error", 
                JOptionPane.ERROR_MESSAGE
                );
        } else {
            panelesDetalles.remove(this);
            parent.cargarPanelesDetalles();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * Método que se ejecuta cuando cambia el valor del spinner de cantidad.
     * Actualiza el importe total en función de la cantidad seleccionada.
     * 
     * @param evt el evento de cambio de estado del spinner
     */
    private void spinnerCantidadStateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_spinnerCantidadStateChanged
        
        // Obtener la cantidad seleccionada
        int cantidad = (int) spinnerCantidad.getValue();

        // Calcular el importe total
        BigDecimal precioUnitario = producto.getPrecio();
        BigDecimal importeTotal = precioUnitario.multiply(new BigDecimal(cantidad));

        // Actualizar el JLabel de importe
        lblImporte.setText("Importe: $" + String.format("%.2f", importeTotal));
    }// GEN-LAST:event_spinnerCantidadStateChanged

    /**
     * Método para obtener el spinner de cantidad.
     * 
     * @return el spinner de cantidad
     */
    public JSpinner getSpinnerCantidad() {
        return spinnerCantidad;
    }

    /**
     * Método para obtener el JTextArea de comentarios.
     * 
     * @return el JTextArea de comentarios
     */
    public JTextArea getTxtAreaComentarios() {
        return txtAreaComentarios;
    }

    /**
     * Método para obtener el importe total.
     * 
     * @return el importe total como BigDecimal
     */
    public ProductoDTO getProducto() {
        return producto;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblComentarios;
    private javax.swing.JLabel lblImporte;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel llblPrecio;
    private itson.sistemarestaurantepresentacion.recursos.RoundedPanel roundedPanel1;
    private javax.swing.JSpinner spinnerCantidad;
    private javax.swing.JTextArea txtAreaComentarios;
    // End of variables declaration//GEN-END:variables
}
