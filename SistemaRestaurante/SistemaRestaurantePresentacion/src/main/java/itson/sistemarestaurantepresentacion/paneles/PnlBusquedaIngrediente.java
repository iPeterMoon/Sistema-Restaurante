/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package itson.sistemarestaurantepresentacion.paneles;

import itson.sistemarestaurantedominio.dtos.IngredienteDTO;
import itson.sistemarestaurantedominio.enumeradores.UnidadMedida;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.factory.ObjetosNegocioFactory;
import itson.sistemarestaurantenegocio.interfaces.IIngredientesBO;
import itson.sistemarestaurantepresentacion.modales.ModalIngredientes;

import java.awt.Font;
import java.util.List;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Clase que representa el panel de busqueda de ingredientes. Este panel
 * contiene un campo de texto para buscar ingredientes por nombre y un
 * comboBox para filtrar por unidad de medida. Ademas, contiene un panel que muestra
 * los ingredientes encontrados.
 * Este panel es reutilizable y puede ser utilizado en diferentes modales o
 * ventanas de la aplicacion.
 * @author PC
 */
public class PnlBusquedaIngrediente extends javax.swing.JPanel {

    private boolean selectionMode = false;
    private IngredienteDTO ingredienteSeleccionado = null;
    private ModalIngredientes modal;

    /**
     * Creates new form PnlBusquedaIngrediente
     */
    public PnlBusquedaIngrediente() {
        initComponents();
        if (!java.beans.Beans.isDesignTime()) {
            this.cargarTodosIngredientes();
            cargarUnidadesMedida();
            cargarEventos();
        }
    }

    /**
     * Metodo que llena la informacion del combo box de Unidades de medida
     */
    public void cargarUnidadesMedida() {
        UnidadMedida[] unidadesMedida = UnidadMedida.values();
        this.comboBoxUnidadMedida.removeAllItems();
        this.comboBoxUnidadMedida.addItem("Seleccionar Unidad de medida");
        for (UnidadMedida unidad : unidadesMedida) {
            this.comboBoxUnidadMedida.addItem(unidad.toString());
        }
    }

    /**
     * Metodo para cargar los ingredientes en el pnlIngredientes. Este metodo
     * debe ser llamado despues de inicializar el componente
     */
    public void cargarTodosIngredientes() {
        IIngredientesBO ingredientesBO = ObjetosNegocioFactory.crearIngredientesBO();
        List<IngredienteDTO> ingredientes = null;
        try {
            ingredientes = ingredientesBO.obtenerIngredientes();
        } catch (Exception e) {
            System.out.println("Error al cargar los productos:" + e.getMessage());
        }
        if (ingredientes != null) {
            cargarPanelesIngredientes(ingredientes);
        } else {
            System.out.println("No se encontraron ingredientes.");
        }
    }

    /**
     * Metodo para catgar los paneles de cada ingrediente dados por una lista
     *
     * @param ingredientes Lista de ingredientes a cargar
     */
    public void cargarPanelesIngredientes(List<IngredienteDTO> ingredientes) {
        pnlIngredientes.removeAll();

        for (IngredienteDTO ingrediente : ingredientes) {
            PnlIngrediente pnlIngrediente = new PnlIngrediente(this, ingrediente);
            pnlIngredientes.add(pnlIngrediente);
            pnlIngredientes.add(Box.createVerticalStrut(30));
        }

        pnlIngredientes.repaint();
        pnlIngredientes.revalidate();
    }

    private void cargarEventos(){
        DocumentListener buscarListener = new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                buscarIngredientes();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                buscarIngredientes();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                buscarIngredientes();
            }
        };

        campoTextoBuscar.getDocument().addDocumentListener(buscarListener);
        comboBoxUnidadMedida.addActionListener(e-> buscarIngredientes());
    }

    /**
     * Metodo para buscar ingredientes en base a un filtro
     *
     * @param filtroBusqueda Texto escrito en el campo de busqueda
     * @return Lista con todos los ingredientes filtrados obtenidos de la base
     *         de datos
     */
    private List<IngredienteDTO> buscarIngredientesConFiltro(String filtroBusqueda) {
        IIngredientesBO ingredientesBO = ObjetosNegocioFactory.crearIngredientesBO();
        List<IngredienteDTO> ingredientes = null;
        try {
            ingredientes = ingredientesBO.obtenerIngredientes(filtroBusqueda);
        } catch (NegocioException e) {
        }
        return ingredientes;
    }

    /**
     * Metodo para obtener ingredientes en base a ambos filtros
     *
     * @param filtroNombre Texto escrito en el campo de busqueda
     * @param filtroUnidad Opcion seleccionada del comboBox
     * @return Lista con todos los ingredientes filtrados obtenidos de la base
     *         de datos
     */
    private List<IngredienteDTO> buscarIngredientesConFiltro(String filtroNombre, String filtroUnidad) {
        IIngredientesBO ingredientesBO = ObjetosNegocioFactory.crearIngredientesBO();
        List<IngredienteDTO> ingredientes = null;
        try {
            ingredientes = ingredientesBO.obtenerIngredientes(filtroNombre, filtroUnidad);
        } catch (NegocioException e) {

        }
        return ingredientes;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal1 = new itson.sistemarestaurantepresentacion.recursos.RoundedPanel();
        campoTextoBuscar = new javax.swing.JTextField();
        comboBoxUnidadMedida = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlIngredientes = new javax.swing.JPanel();

        setBackground(new java.awt.Color(37, 40, 54));
        setPreferredSize(new java.awt.Dimension(1180, 760));

        pnlPrincipal1.setBackground(new java.awt.Color(31, 31, 31));
        pnlPrincipal1.setRoundBottomLeft(60);
        pnlPrincipal1.setRoundBottomRight(60);
        pnlPrincipal1.setRoundTopLeft(60);
        pnlPrincipal1.setRoundTopRight(60);

        campoTextoBuscar.setBackground(new java.awt.Color(255, 255, 255));
        campoTextoBuscar.setFont(new Font("Poppins", Font.PLAIN, 16));
        campoTextoBuscar.setForeground(new java.awt.Color(0, 0, 0));
        campoTextoBuscar.setText("Buscar");
        campoTextoBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoTextoBuscarMouseClicked(evt);
            }
        });

        comboBoxUnidadMedida.setBackground(new java.awt.Color(255, 255, 255));
        comboBoxUnidadMedida.setFont(new Font("Poppins", Font.PLAIN, 18));
        comboBoxUnidadMedida.setForeground(new java.awt.Color(0, 0, 0));

        jScrollPane1.setBackground(new java.awt.Color(31, 31, 31));
        jScrollPane1.setBorder(null);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(1120, 580));

        pnlIngredientes.setBackground(new java.awt.Color(31, 31, 31));
        pnlIngredientes.setLayout(new javax.swing.BoxLayout(pnlIngredientes, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(pnlIngredientes);

        javax.swing.GroupLayout pnlPrincipal1Layout = new javax.swing.GroupLayout(pnlPrincipal1);
        pnlPrincipal1.setLayout(pnlPrincipal1Layout);
        pnlPrincipal1Layout.setHorizontalGroup(
            pnlPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipal1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPrincipal1Layout.createSequentialGroup()
                        .addComponent(campoTextoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBoxUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(245, 245, 245)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlPrincipal1Layout.setVerticalGroup(
            pnlPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipal1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnlPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscarIngredientes(){
        String selectedUnidad = (String) comboBoxUnidadMedida.getSelectedItem();
        String filtroCampoTexto = campoTextoBuscar.getText();

        List<IngredienteDTO> ingredientesEncontrados = null;
        // Con valor en el campo de texto pero no en el comboBox
        if ((!campoTextoBuscar.getText().isEmpty()
                && !campoTextoBuscar.getText().equals("Buscar"))
                && selectedUnidad.equals("Seleccionar Unidad de medida")) {
                    ingredientesEncontrados = buscarIngredientesConFiltro(filtroCampoTexto);
        }

        // Con valor en el comboBox pero no en el campo de texto
        if ((campoTextoBuscar.getText().isEmpty()
                || campoTextoBuscar.getText().equals("Buscar"))
                && !selectedUnidad.equals("Seleccionar Unidad de medida")) {
            ingredientesEncontrados = buscarIngredientesConFiltro(selectedUnidad);
        }

        // Si cuenta con ambos filtros
        if ((!campoTextoBuscar.getText().isEmpty()
                || !campoTextoBuscar.getText().equals("Buscar"))
                && !selectedUnidad.equals("Seleccionar Unidad de medida")) {
                    ingredientesEncontrados = buscarIngredientesConFiltro(filtroCampoTexto, selectedUnidad);
        }

        if(ingredientesEncontrados != null && !ingredientesEncontrados.isEmpty()){
            cargarPanelesIngredientes(ingredientesEncontrados);
        } else {
            mostrarMensajeIngredientesNoEncontrados();
        }

        // Sin filtro
        if ((campoTextoBuscar.getText().isEmpty()
                || campoTextoBuscar.getText().equals("Buscar"))
                && selectedUnidad.equals("Seleccionar Unidad de medida")) {
            cargarTodosIngredientes();
        }
    }
        /**
     * Método para mostrar un mensaje en el panel cuando no se encuentran clientes.
     */
    private void mostrarMensajeIngredientesNoEncontrados() {
        pnlIngredientes.removeAll();
        JLabel mensaje = new JLabel("No se encontraron ingredientes");
        mensaje.setFont(new Font("Poppins", Font.PLAIN, 20));
        mensaje.setForeground(new java.awt.Color(255, 255, 255)); // Color blanco
        pnlIngredientes.add(mensaje);
        pnlIngredientes.repaint();
        pnlIngredientes.revalidate();
    }

    private void campoTextoBuscarMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_campoTextoBuscarMouseClicked
        if (campoTextoBuscar.getText().equals("Buscar")) {
            campoTextoBuscar.setText("");
        }
    }// GEN-LAST:event_campoTextoBuscarMouseClicked

    /**
     * Metodo para establecer el modo de seleccion
     */
    public void setSelectionMode(boolean selectionMode) {
        this.selectionMode = selectionMode;
        cargarTodosIngredientes();
    }

    /**
     * Metodo para obtener el modo de seleccion
     * 
     * @return true si el modo de seleccion esta activo, false en caso contrario
     */
    public boolean isSelectionMode() {
        return selectionMode;
    }

    /**
     * Metodo para obtener el ingrediente seleccionado
     * 
     * @return IngredienteDTO
     */
    public IngredienteDTO getIngredienteSeleccionado() {
        return ingredienteSeleccionado;
    }

    /**
     * Metodo para establecer el ingrediente seleccionado
     * 
     * @param ingredienteSeleccionado IngredienteDTO
     */
    public void setIngredienteSeleccionado(IngredienteDTO ingredienteSeleccionado) {
        this.ingredienteSeleccionado = ingredienteSeleccionado;
    }

    /**
     * Metodo para establecer el modal de ingredientes
     * 
     * @param modal ModalIngredientes
     */
    public void setModal(ModalIngredientes modal) {
        this.modal = modal;
    }

    /**
     * Metodo para obtener el modal de ingredientes
     * 
     * @return ModalIngredientes
     */
    public ModalIngredientes getModal() {
        return modal;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoTextoBuscar;
    private javax.swing.JComboBox<String> comboBoxUnidadMedida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlIngredientes;
    private itson.sistemarestaurantepresentacion.recursos.RoundedPanel pnlPrincipal1;
    // End of variables declaration//GEN-END:variables
}
