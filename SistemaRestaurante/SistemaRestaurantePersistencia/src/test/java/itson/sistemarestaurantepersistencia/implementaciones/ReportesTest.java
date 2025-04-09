/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import itson.sistemarestaurantedominio.Ingrediente;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.junit.jupiter.api.*;

/**
 *
 * @author PC
 */
public class ReportesTest {

    public ReportesTest() {
    }

    @Test
    @Disabled
    public void generarReporte() {
        try {
            // Crea un documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("reportePrueba.pdf"));

            // Abre el documento para agregar contenido
            document.open();
            document.add(new Paragraph("Reporte de la Base de datos"));

            // Aqui agregas los datos de la base de datos, por ejemplo:
            // List<Objecto> datos = ... (Obtienes los datos de la DB usando JPA)
            // Luego recorres la lista e insertas cada dato en el documento PDF
            document.add(new Paragraph("Dato 1: ..."));
            document.add(new Paragraph("Dato 2: ..."));
            //...

            // Cierra el documento
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Disabled
    public void generarReporteConTabla() {
        try {
            // Crea un documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("reportePrueba.pdf"));

            // Abre el documento para agregarcontenido
            document.open();

            // Agregar titulo al reporte
            document.add(new Paragraph("Reporte de Datos"));
            document.add(Chunk.NEWLINE); // Salto de linea

            // Crear una tabla con 3 columnas (Ajustar el numero de columnas segun tu necesitad)
            PdfPTable table = new PdfPTable(4); // Numero de columnas

            // Crear celdas de encabezado
            PdfPCell cell = new PdfPCell(new Phrase("ID"));
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Nombre"));
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Stock"));
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Unidad de Medida"));
            table.addCell(cell);

            // Crear datos de prueba
            IngredientesDAO ingredientesDAO = new IngredientesDAO();
            List<Ingrediente> ingredientes = ingredientesDAO.obtenerIngredientes();

            // Agregar datos de la lista a la tabla
            for (Ingrediente ingrediente : ingredientes) {
                table.addCell(String.valueOf(ingrediente.getId()));
                table.addCell(String.valueOf(ingrediente.getNombre()));
                table.addCell(String.valueOf(ingrediente.getStock()));
                table.addCell(String.valueOf(ingrediente.getUnidadMedida()));
            }

            // Agregar la tabla al documento PDF
            document.add(table);

            // Cierra el documento
            document.close();

            System.out.println("Reporte generado con exito.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Disabled
    public void testGenerarReporteConJFileChooser() {
        // Abrir JFileChooser para seleccionar la ruta
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar reporte como PDF");

        int seleccion = fileChooser.showSaveDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            String ruta = archivo.getAbsolutePath();

            // Asegurar que tenga extension .pdf
            if (!ruta.toLowerCase().endsWith(".pdf")) {
                ruta += ".pdf";
            }

            // Crea el documentoPDF
            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(ruta));
                document.open();

                document.add(new Paragraph("Reporte de Personas\n\n"));

                // Crear tabla con 2 columnas
                PdfPTable table = new PdfPTable(4);
                table.addCell("ID");
                table.addCell("Nombre");
                table.addCell("Stock");
                table.addCell("Unidad de Medida");

                // Crear datos de prueba
                IngredientesDAO ingredientesDAO = new IngredientesDAO();
                List<Ingrediente> ingredientes = ingredientesDAO.obtenerIngredientes();

                // Agregar datos de la lista a la tabla
                for (Ingrediente ingrediente : ingredientes) {
                    table.addCell(String.valueOf(ingrediente.getId()));
                    table.addCell(String.valueOf(ingrediente.getNombre()));
                    table.addCell(String.valueOf(ingrediente.getStock()));
                    table.addCell(String.valueOf(ingrediente.getUnidadMedida()));
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
        } else {
            JOptionPane.showMessageDialog(null,
                    "Guardado cancelado", "INFO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Test
    public void testGenerarReporte() {
        generarReporte();
    }

    @Test
    public void testGenerarReporteConTabla() {
        generarReporteConTabla();
    }

}
