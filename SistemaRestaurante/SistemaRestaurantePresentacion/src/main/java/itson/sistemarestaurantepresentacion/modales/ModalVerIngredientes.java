package itson.sistemarestaurantepresentacion.modales;

import itson.sistemarestaurantedominio.dtos.ProductoDTO;

/**
 * Clase que representa un modal para ver los ingredientes de un producto
 * @author pc
 */
public class ModalVerIngredientes extends javax.swing.JDialog {

    
    /**
     * Creates new form ModalVerIngredientes
     */
    public ModalVerIngredientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.pnlIngredientesProducto.setModal(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIngredientesProducto = new itson.sistemarestaurantepresentacion.pantallas.PnlIngredientesProducto();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlIngredientesProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlIngredientesProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setProducto(ProductoDTO producto){
        this.pnlIngredientesProducto.setProducto(producto);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private itson.sistemarestaurantepresentacion.pantallas.PnlIngredientesProducto pnlIngredientesProducto;
    // End of variables declaration//GEN-END:variables
}
