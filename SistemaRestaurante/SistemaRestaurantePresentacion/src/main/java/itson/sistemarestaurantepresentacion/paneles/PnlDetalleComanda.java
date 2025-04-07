package itson.sistemarestaurantepresentacion.paneles;

import itson.sistemarestaurantedominio.dtos.ProductoDTO;
import java.awt.Font;
import java.math.BigDecimal;

/**
 *
 * @author pc
 */
public class PnlDetalleComanda extends javax.swing.JPanel {

    
    private ProductoDTO producto;
    
    /**
     * Creates new form PnlDetalleComanda
     */
    public PnlDetalleComanda(ProductoDTO producto) {
        this.producto = producto;
        initComponents();
        cargarDetallesProducto();
    }
    
    private void cargarDetallesProducto(){
        String nombreProducto = producto.getNombre();
        this.lblProducto.setText("Producto: "+nombreProducto);
        this.llblPrecio.setText("Precio Unitario: $" + producto.getPrecio().toString());
        this.lblImporte.setText("Importe: $" + producto.getPrecio().toString());
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

        setBackground(new java.awt.Color(31, 31, 31));
        setMaximumSize(new java.awt.Dimension(1000, 150));

        roundedPanel1.setBackground(new java.awt.Color(94, 94, 94));
        roundedPanel1.setRoundBottomLeft(50);
        roundedPanel1.setRoundBottomRight(50);
        roundedPanel1.setRoundTopLeft(50);
        roundedPanel1.setRoundTopRight(50);

        lblProducto.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblProducto.setText("Producto: ....");

        lblCantidad.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblCantidad.setText("Cantidad: ");

        llblPrecio.setFont(new Font("Poppins", Font.PLAIN, 18));
        llblPrecio.setText("Precio Unitario: $...");

        lblComentarios.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblComentarios.setText("Comentarios adicionales:");

        txtAreaComentarios.setBackground(new java.awt.Color(255, 255, 255));
        txtAreaComentarios.setColumns(20);
        txtAreaComentarios.setFont(new Font("Poppins", Font.PLAIN, 18));
        txtAreaComentarios.setForeground(new java.awt.Color(0, 0, 0));
        txtAreaComentarios.setRows(5);
        jScrollPane1.setViewportView(txtAreaComentarios);

        lblImporte.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblImporte.setText("Importe: $...");

        spinnerCantidad.setFont(new Font("Poppins", Font.PLAIN, 18));
        spinnerCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinnerCantidad.setToolTipText("");
        spinnerCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerCantidadStateChanged(evt);
            }
        });

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundedPanel1Layout.createSequentialGroup()
                                .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(llblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblComentarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(lblImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(lblComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(lblProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundedPanel1Layout.createSequentialGroup()
                                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(spinnerCantidad)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(llblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addGap(25, 25, 25))
                            .addGroup(roundedPanel1Layout.createSequentialGroup()
                                .addComponent(lblImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
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

    private void spinnerCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerCantidadStateChanged
        // Obtener la cantidad seleccionada
        int cantidad = (int) spinnerCantidad.getValue();
        
        // Calcular el importe total
        BigDecimal precioUnitario = producto.getPrecio();
        BigDecimal importeTotal = precioUnitario.multiply(new BigDecimal(cantidad));
        
        // Actualizar el JLabel de importe
        lblImporte.setText("Importe: $" + String.format("%.2f", importeTotal));
    }//GEN-LAST:event_spinnerCantidadStateChanged
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
