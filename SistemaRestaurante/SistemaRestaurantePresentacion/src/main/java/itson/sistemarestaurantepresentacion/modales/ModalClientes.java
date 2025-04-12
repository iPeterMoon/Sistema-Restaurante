package itson.sistemarestaurantepresentacion.modales;

import itson.sistemarestaurantedominio.dtos.ClienteComandaDTO;
import itson.sistemarestaurantedominio.dtos.ClienteDTO;

/**
 * Clase para representar una ventana modal de clientes, reutiliza el panel de
 * busqueda de clientes
 *
 * @author pc
 */
public class ModalClientes extends javax.swing.JDialog {

    /**
     * Constructor que inicializa los atributos de la clase al valor de sus
     * parametros
     *
     * @param parent Clase padre que utiliza el modal
     * @param modal Modal
     */
    public ModalClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.pnlBusquedaCliente1.setSelectionMode(true);
        this.pnlBusquedaCliente1.setModalClientes(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBusquedaCliente1 = new itson.sistemarestaurantepresentacion.paneles.PnlBusquedaCliente();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBusquedaCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBusquedaCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo para obtener la comanda del cliente
     *
     * @return Comanda del cliente
     */
    public ClienteComandaDTO obtenerClienteComanda() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        ClienteDTO cliente = pnlBusquedaCliente1.getClienteSeleccionado();
        if (cliente != null) {
            Long id = cliente.getId();
            String nombre = cliente.getNombre();
            String apellidoPaterno = cliente.getApellidoPaterno();
            String apellidoMaterno = cliente.getApellidoMaterno();
            ClienteComandaDTO clienteComanda = new ClienteComandaDTO(id, nombre, apellidoPaterno, apellidoMaterno);
            return clienteComanda;
        }
        return null;
    }

    /**
     * Cierra la ventana modal. Se utiliza para cerrar la ventana modal después
     * de seleccionar un cliente.
     */
    public void cerrarModal() {
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private itson.sistemarestaurantepresentacion.paneles.PnlBusquedaCliente pnlBusquedaCliente1;
    // End of variables declaration//GEN-END:variables
}
