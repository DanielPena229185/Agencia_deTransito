/**
 * GenerarReporte.java
 * 13 abr. 2023 11:23:38
 */
package org.itson.utils;
//importanciones

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.itson.dominio.Reporte;
import org.itson.excepciones.ReportePDFException;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class GenerarReporte {

    public static void generarReporte(List<Reporte> listaReportes) {
        try {
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listaReportes);
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("CollectionBeanParam", itemsJRBean);
            InputStream input = new FileInputStream("..\\reportesJrxml\\ReporteHistorial.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(input);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (Exception e) {
            throw new ReportePDFException("Error al generar el reporte: " + e.getMessage(), e);
        }
    }
}
