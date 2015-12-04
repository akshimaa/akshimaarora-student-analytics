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
import static com.numerouno.studentanalytics.controller.CSVFileProcessor.readFromS3;
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
import com.numerouno.studentanalytics.model.StudentList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import org.json.JSONObject;
import org.ujmp.core.collections.list.ArrayIndexList;

/**
 * PieChartServlet generates the pie chart with the inputs as given by the user.
 * @author Melissa, Akshima
 */
public class PieChartServlet extends HttpServlet {

    Logger log = Logger.getLogger(PieChartServlet.class.getName());
    ArrayList<Student> studentList = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request requests the input of the pie chart
     * @param response servlet response generates the response pie chart
     * @throws ServletException handles if a servlet-specific error occurs
     * @throws IOException handles if an I/O error occurs in the program.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("content", "pieChart");
        String preset = request.getParameter("preset");
        String datasource = request.getParameter("datasource");
        String imageFileName = datasource.concat("_").concat(preset).concat("_pie.png");
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
     * @param request servlet request for the input data to generate the pie chart
     * @param response servlet response for the generation of the pie chart
     * @throws ServletException handles if a servlet-specific error occurs 
     * @throws IOException handles if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet requests the input to generate the pie chart
     * @param response servlet response is the generated chart
     * @throws ServletException handles if a servlet-specific error occurs
     * @throws IOException handles if an I/O error occurs
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
 * this method creates the chart from the input data values
 * @param request is the servlet request for the data
 * @return returns the chart generated
 * @throws FileNotFoundException which might occur on execution of the code
 */
    private JFreeChart getChart(HttpServletRequest request) throws FileNotFoundException {
        String preset = request.getParameter("preset");
        String datasource = request.getParameter("datasource");

        studentList = getStudentListFromDataSource(datasource);
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

            String kvpMap = key + ": " + val;

            dataset.setValue(key.toString(), (Integer) val);
            log.info(kvpMap);
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

        return chart;

    }
/**
 * gets the complex chart from the inputted data
 * @param request is the servlet request to generate complex charts
 * @return returns the generated complex chart
 * @throws FileNotFoundException  if the following code is executed, then there may be FileNotFoundException
 */
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

        studentList = getStudentListFromDataSource(datasource);

        DefaultPieDataset dataset = new DefaultPieDataset();

        HashMap<Object, Integer> mapOne = processObjects(studentList, argumentOne);
        HashMap<Object, Integer> mapTwo = processObjects(studentList, argumentTwo);
        HashMap<Object, Integer> mapThree = processObjects(studentList, argumentThree);
        HashMap<Object, Integer> mapFour = processObjects(studentList, argumentFour);

        Object valOne = mapOne.get(1);
        dataset.setValue(argumentOne, (Integer) valOne);
        //log.info(argumentOne);
        Object valTwo = mapTwo.get(1);
        //log.info(((Integer) valOne).toString());
        dataset.setValue(argumentTwo, (Integer) valTwo);
        Object valThree = mapThree.get(1);
        dataset.setValue(argumentThree, (Integer) valThree);
        Object valFour = mapFour.get(1);
        dataset.setValue(argumentThree, (Integer) valFour);
        
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

        return chart;

    }
/**
 * HashMap is used for the processing objects
 * @param studentList contains the list of the students on which the chart is generated
 * @param preset describes the index of the students in th elist
 * @return returns the map
 */
    public static HashMap<Object, Integer> processObjects(ArrayList<Student> studentList, String preset) {

        Logger log = Logger.getLogger(PieChartServlet.class.getName());

        HashMap<Object, Integer> map = new HashMap<>();
        for (Student student : studentList) {
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
        }
        return map;

    }
/**
 * gets the student list as the data source
 * @param source the list of students 
 * @return It does not return any thing
 */
    private ArrayList<Student> getDataSource(String source) {
        try {

            FileInputStream fis = new FileInputStream(getServletContext().getRealPath(source));
            ObjectInputStream in = new ObjectInputStream(fis);

            return (ArrayList<Student>) in.readObject();
        } catch (IOException ex) {
            Logger.getLogger(PieChartServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PieChartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/**
 * Gets the string value of the object
 * @param o is the instance of the object
 * @return returns the string representation of the object
 */
    private Object getStringValue(Object o) {
        {
            if (o instanceof Enum) {

                return ((Enum) o).name();
            } else {
                return o.toString();
            }

        }
    }

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
