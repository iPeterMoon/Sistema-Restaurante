package itson.sistemarestaurantepresentacion.pantallas;

import java.awt.Font;

/**
 * Clase que representa el panel de especificaciones de una comanda.
 * Este panel muestra información detallada sobre la comanda, incluyendo el
 * folio, la mesa, la fecha y el cliente. También permite marcar la comanda
 * como entregada o cancelada.
 * 
 * @author Peter
 */
public class PnlEspecificacionesComanda extends javax.swing.JPanel {

    /**
     * Creates new form PnlEspecificacionesComanda
     */
    public PnlEspecificacionesComanda() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
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
        lblCliente.setText("Cliente: ...");

        jPanel1.setBackground(new java.awt.Color(80, 205, 137));

        jLabel1.setFont(new Font("Poppins", Font.PLAIN, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Estado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlComandaLayout = new javax.swing.GroupLayout(pnlComanda);
        pnlComanda.setLayout(pnlComandaLayout);
        pnlComandaLayout.setHorizontalGroup(
            pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComandaLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlComandaLayout.createSequentialGroup()
                        .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlComandaLayout.createSequentialGroup()
                                .addComponent(lblFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlComandaLayout.createSequentialGroup()
                                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(72, 72, 72))
                    .addGroup(pnlComandaLayout.createSequentialGroup()
                        .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPnlDetallesComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(46, Short.MAX_VALUE))))
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
                .addComponent(lblMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEntregar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFolio;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JLabel lblTitulo;
    private itson.sistemarestaurantepresentacion.recursos.RoundedPanel pnlComanda;
    private javax.swing.JPanel pnlDetallesComanda;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JScrollPane scrollPnlDetallesComanda;
    // End of variables declaration//GEN-END:variables
}
