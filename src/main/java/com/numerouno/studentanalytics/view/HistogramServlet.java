/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.view;

import com.numerouno.studentanalytics.controller.CSVParser;
import com.numerouno.studentanalytics.controller.analytics.ClassifierIO;
import com.numerouno.studentanalytics.controller.analytics.DataCleaner;
import com.numerouno.studentanalytics.controller.analytics.Predictor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;
import weka.classifiers.Classifier;
import weka.core.Instances;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;
import org.json.JSONObject;

/**
 *
 * @author Dell
 */
@MultipartConfig
public class HistogramServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Logger log = Logger.getLogger(HistogramServlet.class.getName());
        //response.setContentType("image/png");
        request.setAttribute("content", "analytics");
        request.setAttribute("status", getServletContext().getRealPath("/models"));
        File imageFile = new File(getServletContext().getRealPath("/images") + "/chart.png");
        
//        log.info("File:" + request.getParameter("formData"));
//        log.info("Classifier: "+ request.getParameter("formData.classifier"));
//        log.info("File:"+request.getPart("file").getSubmittedFileName());
//        log.info("Classifier: "+ request.getParameter("classifier"));
        FileOutputStream fos = new FileOutputStream(imageFile);
        ChartUtilities.writeChartAsPNG(fos, getChart(request), 300, 300);
        request.setAttribute("contextPath", getServletContext().getContextPath());
        request.setAttribute("chart", imageFile.getName());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index");
        requestDispatcher.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    protected JFreeChart getChart(HttpServletRequest request) {

        JFreeChart chart;
        double[] predictions = null;

        try {
            String classifierKey = request.getParameter("classifier");
            InputStream inputStream = request.getPart("file").getInputStream();
            String modelsPath = getServletContext().getRealPath("/models");
            System.out.println(modelsPath);
            Classifier classifier = ClassifierIO.readClassifier(modelsPath, classifierKey);
            Instances unfilteredData = CSVParser.parseIntoInstances(inputStream);
            Instances data = DataCleaner.filterData(unfilteredData);
            predictions = Predictor.predict(data, classifier);
        } catch (Exception ex) {
            Logger.getLogger(HistogramServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("status", "Oops something went wrong! Server side error while attempting to parse and upload");
        }

        HistogramDataset dataset = new HistogramDataset();
        dataset.setType(HistogramType.FREQUENCY);
        dataset.addSeries("Histogram", predictions, 10);

        boolean show = false;
        boolean toolTips = false;
        boolean urls = false;
        String plotTitle = "Predicted GPA";
        String xaxis = "GPA";
        String yaxis = "Frequency";
        PlotOrientation orientation = PlotOrientation.VERTICAL;

        chart = ChartFactory.createHistogram(
                plotTitle,
                xaxis,
                yaxis,
                dataset,
                orientation,
                show,
                toolTips,
                urls
        );
        int width = 500;
        int height = 300;

        return chart;

    }

}
