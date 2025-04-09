package itson.sistemarestaurantepresentacion.modales;

import java.awt.Font;

import javax.swing.JOptionPane;

import itson.sistemarestaurantedominio.dtos.IngredienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.factory.ObjetosNegocioFactory;
import itson.sistemarestaurantenegocio.interfaces.IIngredientesBO;

/**
 *
 * @author pc
 */
public class ModalModificarStock extends javax.swing.JDialog {

    private IngredienteDTO ingrediente;

    /**
     * Creates new form ModalModificarStock
     */
    public ModalModificarStock(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setIngrediente(IngredienteDTO ingrediente){
        this.ingrediente = ingrediente;
        cargarIngrediente();
    }

    private void cargarIngrediente(){
        txtIngrediente.setText("Ingrediente: "+ ingrediente.getNombre());
        txtStock.setText(String.valueOf(ingrediente.getStock()));
        txtUnidad.setText(
            String.valueOf(ingrediente.getUnidadMedida()).substring(0,1)
            .concat(String.valueOf(ingrediente.getUnidadMedida()).substring(1).toLowerCase()));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        roundedPanel1 = new itson.sistemarestaurantepresentacion.recursos.RoundedPanel();
        txtIngrediente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        btnQuitar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtUnidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(37, 40, 54));

        jLabel1.setFont(new Font("Poppins", Font.BOLD, 32));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modificar Stock");

        roundedPanel1.setBackground(new java.awt.Color(31, 31, 31));
        roundedPanel1.setRoundBottomLeft(50);
        roundedPanel1.setRoundBottomRight(50);
        roundedPanel1.setRoundTopLeft(50);
        roundedPanel1.setRoundTopRight(50);

        txtIngrediente.setFont(new Font("Poppins", Font.PLAIN, 20));
        txtIngrediente.setForeground(new java.awt.Color(255, 255, 255));
        txtIngrediente.setText("Ingrediente:");

        jLabel3.setFont(new Font("Poppins", Font.PLAIN, 20));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Stock Actual");

        txtStock.setEditable(false);
        txtStock.setBackground(new java.awt.Color(255, 255, 255));
        txtStock.setFont(new Font("Poppins", Font.PLAIN, 20));
        txtStock.setForeground(new java.awt.Color(0, 0, 0));

        btnQuitar.setBackground(new java.awt.Color(255, 255, 255));
        btnQuitar.setFont(new Font("Poppins", Font.BOLD, 36));
        btnQuitar.setForeground(new java.awt.Color(0, 0, 0));
        btnQuitar.setText("-");
        btnQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setFont(new Font("Poppins", Font.BOLD, 28));
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("+");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new Font("Poppins", Font.PLAIN, 20));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Unidad de Medida:");

        txtUnidad.setFont(new Font("Poppins", Font.PLAIN, 20));
        txtUnidad.setForeground(new java.awt.Color(255, 255, 255));
        txtUnidad.setText("...");

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundedPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundedPanel1Layout.createSequentialGroup()
                                .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 32, Short.MAX_VALUE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(txtIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtStock)
                    .addComponent(btnQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        try{
            Integer menosStock = Integer.parseInt(
                JOptionPane.showInputDialog("Ingrese la cantidad de Stock que desea eliminar")
            );
            IIngredientesBO ingredientesBO = ObjetosNegocioFactory.crearIngredientesBO();
            ingredientesBO.eliminarStock(ingrediente.getId(), menosStock);
            IngredienteDTO ingredienteConNuevoStock = ingredientesBO.obtenerIngredientePorId(ingrediente.getId());
            setIngrediente(ingredienteConNuevoStock);
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(
                null,
                "Por favor ingrese un número válido",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        } catch(NegocioException e){
            JOptionPane.showMessageDialog(
                null,
                e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        };
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try{
            Integer masStock = Integer.parseInt(
                JOptionPane.showInputDialog("Ingrese la cantidad de Stock que desea agregar")
            );
            IIngredientesBO ingredientesBO = ObjetosNegocioFactory.crearIngredientesBO();
            ingredientesBO.agregarStock(ingrediente.getId(), masStock);
            IngredienteDTO ingredienteConNuevoStock = ingredientesBO.obtenerIngredientePorId(ingrediente.getId());
            setIngrediente(ingredienteConNuevoStock);
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(
                null,
                "Por favor ingrese un número válido",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        } catch(NegocioException e){
            JOptionPane.showMessageDialog(
                null,
                e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        };
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private itson.sistemarestaurantepresentacion.recursos.RoundedPanel roundedPanel1;
    private javax.swing.JLabel txtIngrediente;
    private javax.swing.JTextField txtStock;
    private javax.swing.JLabel txtUnidad;
    // End of variables declaration//GEN-END:variables
}
