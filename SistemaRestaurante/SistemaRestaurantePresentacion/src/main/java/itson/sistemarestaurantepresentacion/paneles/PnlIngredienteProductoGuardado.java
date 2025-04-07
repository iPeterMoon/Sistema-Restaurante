package itson.sistemarestaurantepresentacion.paneles;

import java.awt.Font;

import javax.swing.JOptionPane;

import itson.sistemarestaurantedominio.dtos.IngredienteDTO;
import itson.sistemarestaurantedominio.dtos.IngredienteProductoDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.factory.ObjetosNegocioFactory;
import itson.sistemarestaurantenegocio.interfaces.IIngredientesBO;

/**
 * Clase que representa un panel de ingrediente perteneciente a un producto en la interfaz de usuario.
 * Este panel muestra la información de un ingrediente como su nombre,
 * @author pc
 */
public class PnlIngredienteProductoGuardado extends javax.swing.JPanel {

    private IngredienteProductoDTO ingredienteProducto;

    /**
     * Creates new form PnlIngredienteProductoGuardado
     */
    public PnlIngredienteProductoGuardado(IngredienteProductoDTO ingredienteProducto) {
        this.ingredienteProducto = ingredienteProducto;
        initComponents();
        cargarIngrediente();
    }

    /**
     * Metodo que llena la informacion del ingrediente
     * Se obtiene el ingrediente de la base de datos y se muestra en el panel.
     */
    private void cargarIngrediente() {
        IIngredientesBO ingredientesBO = ObjetosNegocioFactory.crearIngredientesBO();
        try {
            IngredienteDTO ingrediente = ingredientesBO.obtenerIngredientePorId(ingredienteProducto.getIdIngrediente());
            this.lblIngrediente.setText("Ingrediente: " + ingrediente.getNombre());
            this.lblUnidadMedida.setText(
                    "Unidad de medida: " + ingrediente.getUnidadMedida().toString().substring(0, 1).toUpperCase()
                            + ingrediente.getUnidadMedida().toString().substring(1));
            this.lblCantidad.setText("Cantidad: " + ingredienteProducto.getCantidad().toString());
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al cargar el ingrediente: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
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
        lblIngrediente = new javax.swing.JLabel();
        lblUnidadMedida = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();

        setBackground(new java.awt.Color(31, 31, 31));
        setMaximumSize(new java.awt.Dimension(945, 100));

        roundedPanel1.setBackground(new java.awt.Color(94, 94, 94));
        roundedPanel1.setForeground(new java.awt.Color(0, 0, 0));
        roundedPanel1.setRoundBottomLeft(40);
        roundedPanel1.setRoundBottomRight(40);
        roundedPanel1.setRoundTopLeft(40);
        roundedPanel1.setRoundTopRight(40);

        lblIngrediente.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblIngrediente.setForeground(new java.awt.Color(255, 255, 255));
        lblIngrediente.setText("Ingrediente: ...");

        lblUnidadMedida.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblUnidadMedida.setForeground(new java.awt.Color(255, 255, 255));
        lblUnidadMedida.setText("Unidad de medida: ");

        lblCantidad.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblCantidad.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidad.setText("Cantidad:");

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblIngrediente;
    private javax.swing.JLabel lblUnidadMedida;
    private itson.sistemarestaurantepresentacion.recursos.RoundedPanel roundedPanel1;
    // End of variables declaration//GEN-END:variables
}
