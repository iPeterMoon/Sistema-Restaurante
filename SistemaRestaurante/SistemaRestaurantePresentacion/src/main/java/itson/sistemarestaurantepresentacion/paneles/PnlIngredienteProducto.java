package itson.sistemarestaurantepresentacion.paneles;

import itson.sistemarestaurantedominio.dtos.IngredienteDTO;
import java.awt.Font;
import javax.swing.JTextField;

/**
 * Clase que representa un panel de ingrediente perteneciente a un producto en
 * la interfaz de usuario. Este panel muestra la información de un ingrediente
 * como su nombre, unidad de medida y cantidad necesaria para el producto.
 *
 * @author pc
 */
public class PnlIngredienteProducto extends javax.swing.JPanel {

    private IngredienteDTO ingrediente;

    /**
     * Constructor que inicializa el panel
     *
     * @param ingrediente Ingrediente
     */
    public PnlIngredienteProducto(IngredienteDTO ingrediente) {
        this.ingrediente = ingrediente;
        initComponents();
        cargarIngrediente();
    }

    /**
     * Metodo que llena la informacion del ingrediente
     */
    private void cargarIngrediente() {
        String nombreProducto = ingrediente.getNombre();
        this.jLabel1.setText(nombreProducto);
        this.jLabel2.setText(ingrediente.getUnidadMedida().toString().substring(0, 1).toUpperCase() + ingrediente.getUnidadMedida().toString().substring(1));
        this.txtCantidad.setText("1");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedPanel1 = new itson.sistemarestaurantepresentacion.recursos.RoundedPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();

        setBackground(new java.awt.Color(31, 31, 31));
        setMaximumSize(new java.awt.Dimension(1000, 100));

        roundedPanel1.setBackground(new java.awt.Color(94, 94, 94));
        roundedPanel1.setForeground(new java.awt.Color(0, 0, 0));
        roundedPanel1.setRoundBottomLeft(40);
        roundedPanel1.setRoundBottomRight(40);
        roundedPanel1.setRoundTopLeft(40);
        roundedPanel1.setRoundTopRight(40);

        jLabel1.setFont(new Font("Poppins", Font.PLAIN, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrediente: ...");

        jLabel2.setFont(new Font("Poppins", Font.PLAIN, 18));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Unidad de medida: ");

        jLabel3.setFont(new Font("Poppins", Font.PLAIN, 18));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad:");

        txtCantidad.setBackground(new java.awt.Color(255, 255, 255));
        txtCantidad.setFont(new Font("Poppins", Font.PLAIN, 18));
        txtCantidad.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que obtiene el ingrediente
     *
     * @return IngredienteDTO
     */
    public IngredienteDTO getIngrediente() {
        return ingrediente;
    }

    /**
     * Metodo que establece el ingrediente
     *
     * @param ingrediente IngredienteDTO
     */
    public void setIngrediente(IngredienteDTO ingrediente) {
        this.ingrediente = ingrediente;
    }

    /**
     * Metodo que obtiene el campo de texto de cantidad
     *
     * @return JTextField
     */
    public JTextField getTxtCantidad() {
        return txtCantidad;
    }

    /**
     * Metodo que establece el campo de texto de cantidad
     *
     * @param txtCantidad JTextField
     */
    public void setTxtCantidad(JTextField txtCantidad) {
        this.txtCantidad = txtCantidad;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private itson.sistemarestaurantepresentacion.recursos.RoundedPanel roundedPanel1;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
