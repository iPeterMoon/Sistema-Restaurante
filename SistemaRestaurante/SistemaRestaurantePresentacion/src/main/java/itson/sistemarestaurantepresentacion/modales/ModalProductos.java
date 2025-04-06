package itson.sistemarestaurantepresentacion.modales;

import itson.sistemarestaurantedominio.dtos.ProductoDTO;

/**
 *
 * @author pc
 */
public class ModalProductos extends javax.swing.JDialog {

    /**
     * Creates new form ModalProductos
     */
    public ModalProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.pnlBusquedaProducto.setSelectionMode(true);
        this.pnlBusquedaProducto.setModal(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBusquedaProducto = new itson.sistemarestaurantepresentacion.paneles.PnlBusquedaProducto();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBusquedaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBusquedaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Obtiene el producto seleccionado en el modal.
     * Esta función muestra el modal y espera a que el usuario seleccione un producto.
     * @return El producto seleccionado o null si no se seleccionó ninguno.
     */
    public ProductoDTO obtenerProductoSeleccionado(){
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        ProductoDTO producto = pnlBusquedaProducto.getProductoSeleccionado();
        if(producto != null){
            return producto;
        }
        return null;
    }

    /**
     * Cierra el modal.
     * Esta función se utiliza para cerrar el modal cuando ya no es necesario.
     */
    public void cerrarModal(){
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private itson.sistemarestaurantepresentacion.paneles.PnlBusquedaProducto pnlBusquedaProducto;
    // End of variables declaration//GEN-END:variables
}
