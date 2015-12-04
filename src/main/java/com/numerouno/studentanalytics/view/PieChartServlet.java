/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.view;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import java.io.IOException;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import com.numerouno.studentanalytics.controller.CSVParser;
import com.numerouno.studentanalytics.model.Student.*;
import com.numerouno.studentanalytics.model.Student;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import org.ujmp.core.collections.list.ArrayIndexList;

/**
 *
 * @author Melissa, Akshima
 */
public class PieChartServlet extends HttpServlet {

    Logger log = Logger.getLogger(PieChartServlet.class.getName());

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

        String preset = request.getParameter("preset");
        String datasource = request.getParameter("datasource");

        if (datasource.equalsIgnoreCase("UploadedData")) {
            log.info("datasource=" + datasource);
            try {
                CSVParser.parseIntoPOJO(request.getPart("file").getInputStream());
                log.info(request.getPart("file").getSubmittedFileName().concat(" file parsed successfully!"));
            } catch (Exception ex) {
                Logger.getLogger(PieChartServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (request.getParameter("preset").contains("_")) {

            ServletOutputStream os = response.getOutputStream();
            Logger.getLogger(BarChartServlet.class.getName()).log(Level.INFO, "complex chart");
            ChartUtilities.writeChartAsPNG(os, getComplexChart(request), 800, 600);
            os.close();

        } else {
            ServletOutputStream os = response.getOutputStream();
            ChartUtilities.writeChartAsPNG(os, getChart(request), 800, 800);
            request.setAttribute("contextPath", getServletContext().getContextPath());

        }
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

    private JFreeChart getChart(HttpServletRequest request) throws FileNotFoundException {
        String preset = request.getParameter("preset");
        String datasource = request.getParameter("datasource");
        ArrayList<Student> studentList = new ArrayIndexList<>();

        try {

            FileInputStream fis = new FileInputStream(getServletContext().getRealPath("STUDENT.DAT"));
            ObjectInputStream in = new ObjectInputStream(fis);
            studentList = (ArrayList<Student>) in.readObject();
        } catch (IOException ex) {
            Logger.getLogger(PieChartServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PieChartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultPieDataset dataset = new DefaultPieDataset();

        HashMap<Object, Integer> map = processObjects(studentList, preset);

        double[] value = new double[100];
        Random generator = new Random();
        for (int i = 1; i < 100; i++) {

            value[i] = generator.nextDouble();
            int number = 10;
        }
        for (Object key : map.keySet()) {

            Object val = map.get(key);
            dataset.setValue(key.toString(), (Integer) val);
            //log.info(kvpMap);
        }
        JFreeChart chart = ChartFactory.createPieChart3D(
                "Pie Charts", // chart title                   
                dataset, // data 
                true, // include legend                   
                true,
                false);

        final PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(270);
        plot.setForegroundAlpha(0.60f);
        plot.setInteriorGap(0.02);
        int width = 1200; /* Width of the image */

        int height = 1200; /* Height of the image */

        File pieChart3D = new File(getServletContext().getRealPath("/Temp") + "/pie_Chart3D.png");

        try {
            ChartUtilities.saveChartAsPNG(pieChart3D, chart, width, height);
        } catch (IOException ex) {
            Logger.getLogger(PieChartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chart;

    }

    private JFreeChart getComplexChart(HttpServletRequest request) throws FileNotFoundException {
        String preset = request.getParameter("preset");
        String[] presetArguments = preset.split("_");
        String argumentOne = presetArguments[0];
        String argumentTwo = presetArguments[1];
        String argumentThree = presetArguments[2];
        String argumentFour = presetArguments[3];
        Set argumentOneSet = new HashSet<>();
        Set argumentTwoSet = new HashSet<>();
        Set argumentThreeSet = new HashSet<>();
        Set argumentFourSet = new HashSet<>();
        String datasource = request.getParameter("datasource");
        ArrayList<Student> studentList = new ArrayIndexList<>();

        switch (datasource) {
            case "OriginalData":
                
                //request.getContextPath()+ "/STUDENT.DAT")
                studentList = getDataSource("/STUDENT.DAT");
                break;
            case "UploadedData":
                break;
            case "MergedData":
                break;
        }

        DefaultPieDataset dataset = new DefaultPieDataset();

        HashMap<Object, Integer> mapOne = processObjects(studentList, argumentOne);
        HashMap<Object, Integer> mapTwo = processObjects(studentList, argumentTwo);
        HashMap<Object, Integer> mapThree = processObjects(studentList, argumentThree);
        HashMap<Object, Integer> mapFour = processObjects(studentList, argumentFour);

        Object valOne = mapOne.get(1);
        dataset.setValue(argumentOne, (Integer) valOne);
        Object valTwo = mapTwo.get(1);
        dataset.setValue(argumentTwo, (Integer) valTwo);
        Object valThree = mapThree.get(1);
        dataset.setValue(argumentThree, (Integer) valThree);
        Object valFour = mapFour.get(1);
        dataset.setValue(argumentFour, (Integer) valFour);

//        for (Object key : mapOne.keySet()) {
//            
//            Object val = mapOne.get(key);
//            dataset.setValue(key.toString(), (Integer) val);
//            
//        }
//
//        for (Student student : studentList) {
//
//            argumentOneSet.add(student.getParameter(argumentOne));
//            argumentTwoSet.add(student.getParameter(argumentTwo));
//            argumentThreeSet.add(student.getParameter(argumentThree));
//            argumentFourSet.add(student.getParameter(argumentFour));
//        }
//
//        int count = 0;
//
//        for (Object argOne : argumentOneSet) {
//            for (Object argTwo : argumentTwoSet) {
//                for (Object argThree : argumentThreeSet) {
//                    for (Object argFour : argumentFourSet) {
//                        for (Student student : studentList) {
//                            if (getStringValue(student.getParameter(argumentOne)).equals(getStringValue(argOne)) && getStringValue(student.getParameter(argumentTwo)).equals(getStringValue(argTwo))) {
//                                count++;
//                            }
//
//                        }
//                        String status = String.valueOf(count) + " " + getStringValue(argOne) + " " + getStringValue(argTwo) + " " + getStringValue(argThree) + " " + getStringValue(argFour);
//                        Logger.getLogger(PieChartServlet.class.getName()).log(Level.INFO, status);
//
//                        count = 0;
//                    }
//                }
//            }
//        }
//
//        double[] value = new double[100];
//        Random generator = new Random();
//        for (int i = 1; i < 100; i++) {
//
//            value[i] = generator.nextDouble();
//            int number = 10;
//        }
//        for (Object key : map.keySet()) {
//
//            Object val = map.get(key);
//            String kvpMap = key + ": " + val;
//            dataset.setValue(key.toString(), (Integer) val);
//            //log.info(kvpMap);
//        }
        JFreeChart chart = ChartFactory.createPieChart3D(
                "Pie Charts", // chart title                   
                dataset, // data 
                true, // include legend                   
                true,
                false);

        final PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(270);
        plot.setForegroundAlpha(0.60f);
        plot.setInteriorGap(0.02);
        int width = 1200; /* Width of the image */

        int height = 1200; /* Height of the image */

        File pieChart3D = new File(getServletContext().getRealPath("/Temp") + "/pie_Chart3D.png");

        try {
            ChartUtilities.saveChartAsPNG(pieChart3D, chart, width, height);
        } catch (IOException ex) {
            Logger.getLogger(PieChartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chart;

    }

    public static HashMap<Object, Integer> processObjects(ArrayList<Student> studentList, String preset) {

        Logger log = Logger.getLogger(PieChartServlet.class.getName());
        // log.info(studentList.get(5).getCourseInformation().name());
        HashMap<Object, Integer> map = new HashMap<>();
        for (Student student : studentList) {
            //  log.info(student.getParameter(preset).toString());

            if (map.containsKey(student.getParameter(preset))) {
                int count = map.get(student.getParameter(preset));
                map.put(student.getParameter(preset), count + 1);
            } else {
                map.put(student.getParameter(preset), 1);
            }

        }
        for (Object key : map.keySet()) {

            Object value = map.get(key);
            String kvpMap = key + ": " + value;
            // log.info(kvpMap);
        }
        return map;

    }

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

    private Object getStringValue(Object o) {
        {
            if (o instanceof Enum) {

                return ((Enum) o).name();
            } else {
                return o.toString();
            }

        }
    }
}
