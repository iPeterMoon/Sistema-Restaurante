package itson.sistemarestaurantepresentacion.pantallas;

import java.awt.Font;
import java.util.List;

import javax.swing.Box;
import javax.swing.JOptionPane;

import itson.sistemarestaurantedominio.dtos.ClienteDTO;
import itson.sistemarestaurantedominio.dtos.ComandaDTO;
import itson.sistemarestaurantedominio.dtos.DetallesComandaDTO;
import itson.sistemarestaurantedominio.dtos.MesaDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.factory.ObjetosNegocioFactory;
import itson.sistemarestaurantenegocio.interfaces.IClientesBO;
import itson.sistemarestaurantenegocio.interfaces.IDetallesComandaBO;
import itson.sistemarestaurantenegocio.interfaces.IMesasBO;
import itson.sistemarestaurantepresentacion.control.ControlFlujo;
import itson.sistemarestaurantepresentacion.paneles.PnlDetalleComanda;
import itson.sistemarestaurantepresentacion.recursos.Formatos;

/**
 * Clase que representa el panel de especificaciones de una comanda.
 * Este panel muestra información detallada sobre la comanda, incluyendo el
 * folio, la mesa, la fecha y el cliente. También permite marcar la comanda
 * como entregada o cancelada.
 * 
 * @author Peter
 */
public class PnlEspecificacionesComanda extends javax.swing.JPanel {

    private ComandaDTO comanda;

    /**
     * Creates new form PnlEspecificacionesComanda
     */
    public PnlEspecificacionesComanda(ComandaDTO comanda) {
        this.comanda = comanda;
        initComponents();
        cargarDatosComanda();
        cargarDetallesComanda();
    }

    /**
     * Metodo para cargar los datos de la comanda en los elementos graficos
     */
    private void cargarDatosComanda(){
        try{
            lblFolio.setText("Comanda con Folio: "+comanda.getFolio());
            IMesasBO mesasBO = ObjetosNegocioFactory.crearMesasBO();
            MesaDTO mesa = mesasBO.obtenerMesaPorId(comanda.getIdMesa());
            lblMesa.setText("Mesa "+ mesa.getNumeroMesa());
            lblFecha.setText(Formatos.cargarFecha(comanda.getFechaHora())+"   "+Formatos.cargarHora(comanda.getFechaHora()));
            if(comanda.getIdCliente() != null){
                IClientesBO clientesBO = ObjetosNegocioFactory.crearClientesBO();
                ClienteDTO cliente = clientesBO.obtenerClientePorId(comanda.getIdCliente());
                txtCliente.setText(cliente.getNombre()+" "+cliente.getApellidoPaterno()+" "+cliente.getApellidoMaterno());
            }
            txtTotal.setText("$"+String.valueOf(comanda.getTotal())); 
            lblEstado.setText(String.valueOf(comanda.getEstado()).substring(0,1).concat(String.valueOf(comanda.getEstado()).substring(1).toLowerCase()));
        } catch(NegocioException e){
            JOptionPane.showMessageDialog(
                null,
                "Error: "+e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
        
    }
    /**
     * Metodo para cargar los detalles de la comanda
     */
    private void cargarDetallesComanda(){
        try{
            IDetallesComandaBO detallesComandaBO = ObjetosNegocioFactory.crearDetallesComandaBO();
            List<DetallesComandaDTO> detallesComanda = detallesComandaBO.obtenerDetallesComanda(comanda.getIdComanda());
            if(!detallesComanda.isEmpty()){
                for(DetallesComandaDTO detalle : detallesComanda){
                    PnlDetalleComanda pnlDetalleComanda = new PnlDetalleComanda(detalle);
                    pnlDetallesComanda.add(pnlDetalleComanda);
                    pnlDetallesComanda.add(Box.createVerticalStrut(20));
                }
            }
        } catch(NegocioException e){
            JOptionPane.showMessageDialog(
                null,
                "Error: "+e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
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
        pnlComanda = new itson.sistemarestaurantepresentacion.recursos.RoundedPanel();
        lblFolio = new javax.swing.JLabel();
        scrollPnlDetallesComanda = new javax.swing.JScrollPane();
        pnlDetallesComanda = new javax.swing.JPanel();
        lblMesa = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();
        txtCliente = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        btnEntregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        pnlPrincipal.setBackground(new java.awt.Color(37, 40, 54));

        lblTitulo.setFont(new Font("Poppins", Font.BOLD, 36));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Especificaciones de Comanda");

        pnlComanda.setBackground(new java.awt.Color(31, 31, 31));
        pnlComanda.setRoundBottomLeft(50);
        pnlComanda.setRoundBottomRight(50);
        pnlComanda.setRoundTopLeft(50);
        pnlComanda.setRoundTopRight(50);

        lblFolio.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblFolio.setForeground(new java.awt.Color(255, 255, 255));
        lblFolio.setText("Comanda con Folio: ");

        scrollPnlDetallesComanda.setBorder(null);

        pnlDetallesComanda.setBackground(new java.awt.Color(31, 31, 31));
        pnlDetallesComanda.setLayout(new javax.swing.BoxLayout(pnlDetallesComanda, javax.swing.BoxLayout.Y_AXIS));
        scrollPnlDetallesComanda.setViewportView(pnlDetallesComanda);

        lblMesa.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblMesa.setForeground(new java.awt.Color(255, 255, 255));
        lblMesa.setText("Mesa ...");

        lblFecha.setFont(new Font("Poppins", Font.BOLD, 18));
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Fecha: ...");

        lblCliente.setFont(new Font("Poppins", Font.BOLD, 18));
        lblCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblCliente.setText("Cliente: ");

        jPanel1.setBackground(new java.awt.Color(80, 205, 137));

        lblEstado.setFont(new Font("Poppins", Font.PLAIN, 18));
        lblEstado.setForeground(new java.awt.Color(255, 255, 255));
        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstado.setText("Estado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtCliente.setFont(new Font("Poppins", Font.BOLD, 18));
        txtCliente.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lblTotal.setFont(new Font("Poppins", Font.BOLD, 18));
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setText("Total:");

        txtTotal.setFont(new Font("Poppins", Font.BOLD, 18));
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotal.setText("Total:");

        javax.swing.GroupLayout pnlComandaLayout = new javax.swing.GroupLayout(pnlComanda);
        pnlComanda.setLayout(pnlComandaLayout);
        pnlComandaLayout.setHorizontalGroup(
            pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComandaLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlComandaLayout.createSequentialGroup()
                        .addComponent(scrollPnlDetallesComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlComandaLayout.createSequentialGroup()
                        .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlComandaLayout.createSequentialGroup()
                                .addComponent(lblMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlComandaLayout.createSequentialGroup()
                                .addComponent(lblFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlComandaLayout.createSequentialGroup()
                                .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(72, 72, 72))))
        );
        pnlComandaLayout.setVerticalGroup(
            pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComandaLayout.createSequentialGroup()
                .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlComandaLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlComandaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPnlDetallesComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btnEntregar.setBackground(new java.awt.Color(80, 205, 137));
        btnEntregar.setFont(new Font("Poppins", Font.PLAIN, 18));
        btnEntregar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntregar.setText("Marcar como Entregada");

        btnCancelar.setBackground(new java.awt.Color(94, 94, 94));
        btnCancelar.setFont(new Font("Poppins", Font.PLAIN, 18));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Marcar como Cancelada");

        btnVolver.setBackground(new java.awt.Color(94, 94, 94));
        btnVolver.setFont(new Font("Poppins", Font.PLAIN, 18));
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(464, 464, 464))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(btnEntregar, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(64, 64, 64))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(pnlComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
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

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        ControlFlujo.mostrarComandas();
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEntregar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFolio;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private itson.sistemarestaurantepresentacion.recursos.RoundedPanel pnlComanda;
    private javax.swing.JPanel pnlDetallesComanda;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JScrollPane scrollPnlDetallesComanda;
    private javax.swing.JLabel txtCliente;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
