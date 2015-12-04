/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.view;

import static com.numerouno.studentanalytics.controller.CSVFileProcessor.readFromS3;
import com.numerouno.studentanalytics.controller.CSVParser;
import java.awt.Color;
import java.awt.GradientPaint;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.ujmp.core.collections.list.ArrayIndexList;
import com.numerouno.studentanalytics.model.Student;
import com.numerouno.studentanalytics.model.StudentList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.Integer;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.apache.commons.io.IOUtils;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.json.JSONObject;

/**
 * BarChartServlet
 *
 * @author madan
 */
public class BarChartServlet extends HttpServlet {

    ArrayList<Student> studentList = null;

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
        request.setAttribute("content", "barChart");
        String datasource = request.getParameter("datasource");
        String preset = request.getParameter("preset");
        String imageFileName = datasource.concat("_").concat(preset).concat("_bar.png");
        request.setAttribute("contextPath", getServletContext().getContextPath());
        File imageFile = new File(getServletContext().getRealPath("/images") + "/" + imageFileName);
        request.setAttribute("chart", imageFile.getName());

        FileOutputStream fos = new FileOutputStream(imageFile);
        if (request.getParameter("preset").contains("_")) {
            Logger.getLogger(BarChartServlet.class.getName()).log(Level.INFO, "complex chart");
            ChartUtilities.writeChartAsPNG(fos, getComplexChart(request), 800, 600);
            fos.close();
        } else {
            Logger.getLogger(BarChartServlet.class.getName()).log(Level.INFO, "simple chart");
            ChartUtilities.writeChartAsPNG(fos, getChart(request), 800, 600);
            fos.close();
        }
        //JSON Response from Servlet
        JSONObject json = new JSONObject();
        json.put("chart", getServletContext().getContextPath() + "/images" + "/" + imageFileName);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        out.println(json);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request requests for the data to generate the charts
     * @param response servlet response responds by processing the request
     * @throws ServletException is thrown if a servlet-specific error occurs
     * @throws IOException is thrown if an I/O error occurs
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

    /**
     * gets the jfree chart generated from the data source 
     * @param request requests for the data source
     * @return returns the generated chart
     * @throws FileNotFoundException is thrown if the code is executed
     */
    private JFreeChart getChart(HttpServletRequest request) throws FileNotFoundException {
        String preset = request.getParameter("preset");
        String datasource = request.getParameter("datasource");

        studentList = getStudentListFromDataSource(datasource);

        HashMap<Object, Integer> map = new HashMap<>();
        for (Student student : studentList) {
            if (map.containsKey(student.getParameter(preset))) {

                int count = map.get(student.getParameter(preset));
                map.put(student.getParameter(preset), count + 1);
            } else {
                map.put(student.getParameter(preset), 1);
            }
        }

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Object key : map.keySet()) {
            dataset.addValue(map.get(key), Student.getLegend(preset), key.toString());
        }

        final JFreeChart chart = ChartFactory.createBarChart(
                Student.getLegend(preset), // chart title
                "Category", // domain axis label
                "Value", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips?
                false // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(
                0.0f, 0.0f, Color.green,
                0.0f, 0.0f, Color.BLUE
        );
        final GradientPaint gp1 = new GradientPaint(
                0.0f, 0.0f, Color.red,
                0.0f, 0.0f, Color.BLUE
        );
        final GradientPaint gp2 = new GradientPaint(
                0.0f, 0.0f, Color.magenta,
                0.0f, 0.0f, Color.BLUE
        );
        final GradientPaint gp3 = new GradientPaint(
                0.0f, 0.0f, Color.yellow,
                0.0f, 0.0f, Color.BLUE
        );
        final GradientPaint gp4 = new GradientPaint(
                0.0f, 0.0f, Color.cyan,
                0.0f, 0.0f, Color.BLUE
        );
        final GradientPaint gp5 = new GradientPaint(
                0.0f, 0.0f, Color.orange,
                0.0f, 0.0f, Color.BLUE
        );
        final GradientPaint gp6 = new GradientPaint(
                0.0f, 0.0f, Color.black,
                0.0f, 0.0f, Color.BLUE
        );
        final GradientPaint gp7 = new GradientPaint(
                0.0f, 0.0f, Color.darkGray,
                0.0f, 0.0f, Color.BLUE
        );
        final GradientPaint gp8 = new GradientPaint(
                0.0f, 0.0f, Color.pink,
                0.0f, 0.0f, Color.BLUE
        );
        final GradientPaint gp9 = new GradientPaint(
                0.0f, 0.0f, Color.black,
                0.0f, 0.0f, Color.BLUE
        );

        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);
        renderer.setSeriesPaint(3, gp3);
        renderer.setSeriesPaint(4, gp4);
        renderer.setSeriesPaint(5, gp5);
        renderer.setSeriesPaint(6, gp6);
        renderer.setSeriesPaint(7, gp7);
        renderer.setSeriesPaint(8, gp8);
        renderer.setSeriesPaint(9, gp9);

        if (map.keySet().size() < 10) {
            renderer.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getInstance()));
            renderer.setSeriesItemLabelsVisible(0, true);
        }
        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 4.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;

    }

    /**
     * To create complex jfree chart
     *
     * @param request requests for the data source to generate data
     * @return returns the generated complex chart
     * @throws FileNotFoundException is thrown while execution of the code
     */
    private JFreeChart getComplexChart(HttpServletRequest request) throws FileNotFoundException {
        String preset = request.getParameter("preset");
        String[] presetArguments = preset.split("_");
        String argumentOne = presetArguments[0];
        String argumentTwo = presetArguments[1];
        Set argumentOneSet = new HashSet<>();
        Set argumentTwoSet = new HashSet<>();

        String datasource = request.getParameter("datasource");

        studentList = getStudentListFromDataSource(datasource);

        for (Student student : studentList) {

            argumentOneSet.add(student.getParameter(argumentOne));
            argumentTwoSet.add(student.getParameter(argumentTwo));
        }

        int count = 0;

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Object argOne : argumentOneSet) {
            for (Object argTwo : argumentTwoSet) {
                for (Student student : studentList) {
                    if (getStringValue(student.getParameter(argumentOne)).equals(getStringValue(argOne)) && getStringValue(student.getParameter(argumentTwo)).equals(getStringValue(argTwo))) {
                        count++;
                    }
                }
                String status = String.valueOf(count) + " " + getStringValue(argOne) + " " + getStringValue(argTwo);
                Logger.getLogger(BarChartServlet.class.getName()).log(Level.INFO, status);
                dataset.addValue(count, getStringValue(argOne), getStringValue(argTwo));
                count = 0;
            }
        }
        

        final JFreeChart chart = ChartFactory.createBarChart(
                Student.getLegend(preset), // chart title
                "Category", // domain axis label
                "Value", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips?
                false // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(
                0.0f, 0.0f, Color.orange,
                0.0f, 0.0f, Color.RED
        );
        final GradientPaint gp1 = new GradientPaint(
                0.0f, 0.0f, Color.green,
                0.0f, 0.0f, Color.BLUE
        );
        final GradientPaint gp2 = new GradientPaint(
                0.0f, 0.0f, Color.pink,
                0.0f, 0.0f, Color.MAGENTA
        );
        final GradientPaint gp3 = new GradientPaint(
                0.0f, 0.0f, Color.darkGray,
                0.0f, 0.0f, Color.BLUE
        );
        final GradientPaint gp4 = new GradientPaint(
                0.0f, 0.0f, Color.magenta,
                0.0f, 0.0f, Color.BLUE
        );
        final GradientPaint gp5 = new GradientPaint(
                0.0f, 0.0f, Color.cyan,
                0.0f, 0.0f, Color.BLUE
        );
        final GradientPaint gp6 = new GradientPaint(
                0.0f, 0.0f, Color.orange,
                0.0f, 0.0f, Color.BLUE
        );
        final GradientPaint gp7 = new GradientPaint(
                0.0f, 0.0f, Color.darkGray,
                0.0f, 0.0f, Color.BLUE
        );
        final GradientPaint gp8 = new GradientPaint(
                0.0f, 0.0f, Color.pink,
                0.0f, 0.0f, Color.BLUE
        );
        final GradientPaint gp9 = new GradientPaint(
                0.0f, 0.0f, Color.black,
                0.0f, 0.0f, Color.BLUE
        );

        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);
        renderer.setSeriesPaint(3, gp3);
        renderer.setSeriesPaint(4, gp4);
        renderer.setSeriesPaint(5, gp5);
        renderer.setSeriesPaint(6, gp6);
        renderer.setSeriesPaint(7, gp7);
        renderer.setSeriesPaint(8, gp8);
        renderer.setSeriesPaint(9, gp9);

        if (argumentTwoSet.size() < 10) {
            for (int x = 0; x < 5; x++) {
                renderer.setSeriesItemLabelGenerator(x, new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getInstance()));
                renderer.setSeriesItemLabelsVisible(x, true);
            }
        }

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 4.0)
        );

        // OPTIONAL CUSTOMISATION COMPLETED.
        return chart;

    }

    /**
     * creates array list of students with the data source
     *
     * @param source is the parameter that specifies the location of the file
     * @return does not return.
     */
    private ArrayList<Student> getDataSource(String source) {
        try {

            FileInputStream fis = new FileInputStream(getServletContext().getRealPath(source));
            ObjectInputStream in = new ObjectInputStream(fis);

            return (ArrayList<Student>) in.readObject();
        } catch (IOException ex) {
            Logger.getLogger(BarChartServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BarChartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * This method os used ot get the string value
     *
     * @param o is the instance of the object
     * @return returns the object as the sting representation
     */
    private static String getStringValue(Object o) {
        if (o instanceof Enum) {

            return ((Enum) o).name();
        } else {
            return o.toString();
        }
    }

    /**
     * Contains the list of students from the DataSource
     *
     * @param datasource data source specifies the type of data to generate the
     * charts
     * @return returns the student list
     */
    private ArrayList<Student> getStudentListFromDataSource(String datasource) {
        studentList = new ArrayIndexList<>();
        switch (datasource) {
            case "OriginalData":
                readFromS3("student-alpha", "STUDENT.dat", getServletContext().getRealPath("/Temp") + "/" + "original.dat");
                studentList = getDataSource("/Temp/original.dat");
                break;
            case "UploadedData":
                studentList = StudentList.getList();
                break;
            case "MergedData":
                parseMergedFile();
                break;
        }
        return studentList;
    }

    /**
     * Parses the merged file to produce the corresponding charts
     */
    private void parseMergedFile() {
        readFromS3("student-gamma", "student-merged.csv", getServletContext().getRealPath("/Temp") + "/" + "merged.csv");
        File mergedFile = new File(getServletContext().getRealPath("/Temp") + "/" + "merged.csv");

        try (InputStream stream = new FileInputStream(mergedFile);) {

            CSVParser.parseIntoPOJO(stream, "merged");
            studentList = StudentList.getMergedList();

        } catch (Exception ex) {
            Logger.getLogger(BarChartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
