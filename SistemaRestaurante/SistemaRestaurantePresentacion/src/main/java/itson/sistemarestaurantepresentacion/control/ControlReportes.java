/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantepresentacion.control;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.dtos.ClienteFrecuenteDTO;
import itson.sistemarestaurantenegocio.factory.ObjetosNegocioFactory;
import itson.sistemarestaurantenegocio.interfaces.IComandasBO;
import itson.sistemarestaurantepersistencia.implementaciones.ClientesDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Clase que se encarga de llevar el control de los reportes
 *
 * @author PC
 */
public class ControlReportes {

    IComandasBO factoryComanda = ObjetosNegocioFactory.crearComandasBO();

    /**
     * Consturctor por omision
     */
    public ControlReportes() {
    }

    /**
     * Metodo que genera el reporte para las comandas
     *
     * @param fechaInicio Fecha de inicio del periodo
     * @param fechaFin Fecha de fin del periodo
     */
    public void generarReporteComandas(Calendar fechaInicio, Calendar fechaFin) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar reporte como PDF");
        int seleccion = fileChooser.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            String ruta = archivo.getAbsolutePath();
            // Asegurar que tenga la extension .pdf
            if (!ruta.toLowerCase().endsWith(".pdf")) {
                ruta += ".pdf";
            }

            // Crea el documento
            try {
                Document document = new Document();
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta));

                // Numero de paginas
                writer.setPageEvent(new NumeradorPaginas());
                document.open();

                Calendar ahora = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");

                String fechaHoraActual = sdf.format(ahora.getTime());
                document.add(new Paragraph("Reporte de Clientes Frecuentes\n\n"));
                document.add(new Paragraph("Generado en: " + fechaHoraActual + "\n\n"));

                // Crear tabla con 5 columnas
                PdfPTable table = new PdfPTable(5);
                table.addCell("Fecha y hora");
                table.addCell("Mesa");
                table.addCell("Total de venta");
                table.addCell("Estado");
                table.addCell("Cliente");

                List<Comanda> comandas = factoryComanda.obtenerComandasPorPeriodo(fechaInicio, fechaFin);

                for (Comanda comanda : comandas) {
                    String fechaUltimaComanda = comanda.getFechaHora() != null
                            ? sdfFecha.format(comanda.getFechaHora().getTime()) : "N/A";
                    table.addCell(fechaUltimaComanda);

                    table.addCell(String.valueOf(comanda.getMesa().getNumeroMesa()));
                    table.addCell("$" + String.valueOf(comanda.getTotalVenta()));
                    table.addCell(String.valueOf(comanda.getEstado()));

                    String nombre = comanda.getCliente() != null
                            ? comanda.getCliente().getNombre() + " "
                            + comanda.getCliente().getApellidoPaterno() + " "
                            + comanda.getCliente().getApellidoMaterno() : "N/A";
                    table.addCell(String.valueOf(nombre));
                }
                document.add(table);

                String fechaInicioFormato = sdfFecha.format(fechaInicio.getTime());
                String fechaFinFormato = sdfFecha.format(fechaFin.getTime());

                BigDecimal totalVentaPeriodo = factoryComanda.calcularTotalVentasPorPeriodo(fechaInicio, fechaFin);

                document.add(new Paragraph("Total de venta del periodo "
                        + fechaInicioFormato + " a " + fechaFinFormato + ": $" + totalVentaPeriodo));

                document.close();
                JOptionPane.showMessageDialog(null,
                        "PDF guardado correctamente en:\n" + ruta, "INFO",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "Error al generar el PDF:\n" + e.getMessage(), "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Metodo que genera el reporte de clientes frecuentes sin ningun filtro
     */
    public void generarReporteClientes() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar reporte como PDF");
        int seleccion = fileChooser.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            String ruta = archivo.getAbsolutePath();
            // Asegurar que tenga la extension .pdf
            if (!ruta.toLowerCase().endsWith(".pdf")) {
                ruta += ".pdf";
            }

            try {
                Document document = new Document();
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta));
                // Numero de paginas
                writer.setPageEvent(new NumeradorPaginas());
                document.open();

                Calendar ahora = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String fechaHoraActual = sdf.format(ahora.getTime());
                document.add(new Paragraph("Reporte de Clientes Frecuentes\n\n"));
                document.add(new Paragraph("Generado en: " + fechaHoraActual + "\n\n"));

                // Crear tabla con 6 columnas
                PdfPTable table = new PdfPTable(5);
                table.addCell("Nombre Completo");
                table.addCell("Número de Visitas");
                table.addCell("Total Gastado");
                table.addCell("Puntos de Fidelidad");
                table.addCell("Última Comanda");
                // Obtener los datos reales
                ClientesDAO clientesDAO = new ClientesDAO();
                List<ClienteFrecuenteDTO> clientes = clientesDAO.obtenerClientesFrecuentesReporte();
                // Agregar datos de la lista a la tabla
                SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");
                for (ClienteFrecuenteDTO cliente : clientes) {
                    table.addCell(cliente.getNombreCompleto());
                    table.addCell(String.valueOf(cliente.getNumeroVisitas()));
                    table.addCell("$" + String.valueOf(cliente.getTotalGastado()));
                    table.addCell(String.valueOf(cliente.getPuntosFidelidad()));

                    String fechaUltimaComanda = cliente.getFechaUltimaComanda() != null
                            ? sdfFecha.format(cliente.getFechaUltimaComanda().getTime()) : "N/A";
                    table.addCell(fechaUltimaComanda);
                }
                document.add(table);
                document.close();
                JOptionPane.showMessageDialog(null,
                        "PDF guardado correctamente en:\n" + ruta, "INFO",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "Error al generar el PDF:\n" + e.getMessage(), "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Metodo que genera el reporte de clientes frecuentes con el filtro de
     * visitas minimas
     *
     * @param filtroVisitasMinimas Filtro de visitas minimas para el reporte
     */
    public void generarReporteClientes(Integer filtroVisitasMinimas) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar reporte como PDF");
        int seleccion = fileChooser.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            String ruta = archivo.getAbsolutePath();
            // Asegurar que tenga la extension .pdf
            if (!ruta.toLowerCase().endsWith(".pdf")) {
                ruta += ".pdf";
            }

            try {
                Document document = new Document();
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta));
                // Numero de paginas
                writer.setPageEvent(new NumeradorPaginas());
                document.open();

                Calendar ahora = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String fechaHoraActual = sdf.format(ahora.getTime());
                document.add(new Paragraph("Reporte de Clientes Frecuentes\n\n"));
                document.add(new Paragraph("Generado en: " + fechaHoraActual + "\n\n"));

                // Crear tabla con 6 columnas
                PdfPTable table = new PdfPTable(5);
                table.addCell("Nombre Completo");
                table.addCell("Número de Visitas");
                table.addCell("Total Gastado");
                table.addCell("Puntos de Fidelidad");
                table.addCell("Última Comanda");
                // Obtener los datos reales
                ClientesDAO clientesDAO = new ClientesDAO();
                List<ClienteFrecuenteDTO> clientes = clientesDAO.obtenerClientesFrecuentesReporte(filtroVisitasMinimas);
                // Agregar datos de la lista a la tabla
                SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");
                for (ClienteFrecuenteDTO cliente : clientes) {
                    table.addCell(cliente.getNombreCompleto());
                    table.addCell(String.valueOf(cliente.getNumeroVisitas()));
                    table.addCell("$" + String.valueOf(cliente.getTotalGastado()));
                    table.addCell(String.valueOf(cliente.getPuntosFidelidad()));

                    String fechaUltimaComanda = cliente.getFechaUltimaComanda() != null
                            ? sdfFecha.format(cliente.getFechaUltimaComanda().getTime()) : "N/A";
                    table.addCell(fechaUltimaComanda);
                }
                document.add(table);
                document.close();
                JOptionPane.showMessageDialog(null,
                        "PDF guardado correctamente en:\n" + ruta, "INFO",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "Error al generar el PDF:\n" + e.getMessage(), "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Metodo que genera el reporte de clietnes frecuentes con un filtro de
     * nombre de usuario
     *
     * @param filtroNombre Filtro de nombre de usuario para el reporte
     */
    public void generarReporteClientes(String filtroNombre) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar reporte como PDF");
        int seleccion = fileChooser.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            String ruta = archivo.getAbsolutePath();
            // Asegurar que tenga la extension .pdf
            if (!ruta.toLowerCase().endsWith(".pdf")) {
                ruta += ".pdf";
            }

            try {
                Document document = new Document();
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta));
                // Numero de paginas
                writer.setPageEvent(new NumeradorPaginas());
                document.open();

                Calendar ahora = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String fechaHoraActual = sdf.format(ahora.getTime());
                document.add(new Paragraph("Reporte de Clientes Frecuentes\n\n"));
                document.add(new Paragraph("Generado en: " + fechaHoraActual + "\n\n"));

                // Crear tabla con 6 columnas
                PdfPTable table = new PdfPTable(5);
                table.addCell("Nombre Completo");
                table.addCell("Número de Visitas");
                table.addCell("Total Gastado");
                table.addCell("Puntos de Fidelidad");
                table.addCell("Última Comanda");
                // Obtener los datos reales
                ClientesDAO clientesDAO = new ClientesDAO();
                List<ClienteFrecuenteDTO> clientes = clientesDAO.obtenerClientesFrecuentesReporte(filtroNombre);
                // Agregar datos de la lista a la tabla
                SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");
                for (ClienteFrecuenteDTO cliente : clientes) {
                    table.addCell(cliente.getNombreCompleto());
                    table.addCell(String.valueOf(cliente.getNumeroVisitas()));
                    table.addCell("$" + String.valueOf(cliente.getTotalGastado()));
                    table.addCell(String.valueOf(cliente.getPuntosFidelidad()));

                    String fechaUltimaComanda = cliente.getFechaUltimaComanda() != null
                            ? sdfFecha.format(cliente.getFechaUltimaComanda().getTime()) : "N/A";
                    table.addCell(fechaUltimaComanda);
                }
                document.add(table);
                document.close();
                JOptionPane.showMessageDialog(null,
                        "PDF guardado correctamente en:\n" + ruta, "INFO",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "Error al generar el PDF:\n" + e.getMessage(), "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Metodo que genera el reporte de clientes frecuentes en base a dos filtros
     *
     * @param filtroNombre Filtro de nombre del cliente
     * @param filtroVisitasMinimas Filtro de visitas minimas
     */
    public void generarReporteClientes(String filtroNombre, Integer filtroVisitasMinimas) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar reporte como PDF");
        int seleccion = fileChooser.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            String ruta = archivo.getAbsolutePath();
            // Asegurar que tenga la extension .pdf
            if (!ruta.toLowerCase().endsWith(".pdf")) {
                ruta += ".pdf";
            }

            try {
                Document document = new Document();
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta));
                // Numero de paginas
                writer.setPageEvent(new NumeradorPaginas());
                document.open();

                Calendar ahora = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String fechaHoraActual = sdf.format(ahora.getTime());
                document.add(new Paragraph("Reporte de Clientes Frecuentes\n\n"));
                document.add(new Paragraph("Generado en: " + fechaHoraActual + "\n\n"));

                // Crear tabla con 6 columnas
                PdfPTable table = new PdfPTable(5);
                table.addCell("Nombre Completo");
                table.addCell("Número de Visitas");
                table.addCell("Total Gastado");
                table.addCell("Puntos de Fidelidad");
                table.addCell("Última Comanda");
                // Obtener los datos reales
                ClientesDAO clientesDAO = new ClientesDAO();
                List<ClienteFrecuenteDTO> clientes = clientesDAO.obtenerClientesFrecuentesReporte(filtroNombre, filtroVisitasMinimas);
                // Agregar datos de la lista a la tabla
                SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");
                for (ClienteFrecuenteDTO cliente : clientes) {
                    table.addCell(cliente.getNombreCompleto());
                    table.addCell(String.valueOf(cliente.getNumeroVisitas()));
                    table.addCell("$" + String.valueOf(cliente.getTotalGastado()));
                    table.addCell(String.valueOf(cliente.getPuntosFidelidad()));

                    String fechaUltimaComanda = cliente.getFechaUltimaComanda() != null
                            ? sdfFecha.format(cliente.getFechaUltimaComanda().getTime()) : "N/A";
                    table.addCell(fechaUltimaComanda);
                }
                document.add(table);
                document.close();
                JOptionPane.showMessageDialog(null,
                        "PDF guardado correctamente en:\n" + ruta, "INFO",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "Error al generar el PDF:\n" + e.getMessage(), "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Clase/Metodo que se encarga de enumerar las paginas del reporte
     */
    static class NumeradorPaginas extends PdfPageEventHelper {

        com.itextpdf.text.Font fuente = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 10, com.itextpdf.text.Font.ITALIC);

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte canvas = writer.getDirectContent();
            Phrase pie = new Phrase("Página " + writer.getPageNumber(), fuente);
            ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER,
                    pie,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.bottom() - 10, 0);
        }
    }

}
