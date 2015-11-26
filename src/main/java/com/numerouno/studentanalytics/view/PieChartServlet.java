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
import com.numerouno.studentanalytics.model.Student;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;
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

      
   String preset= request.getParameter("preset");
   String datasource= request.getParameter("datasource");

   
       
       ServletOutputStream os = response.getOutputStream();
        ChartUtilities.writeChartAsPNG(os, getChart(request), 300, 300);
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
          String preset= request.getParameter("preset");
   String datasource= request.getParameter("datasource");
         ArrayList<Student> studentList=new ArrayIndexList<>();
      
     try {
          
      FileInputStream fis = new FileInputStream("STUDENT.DAT");
      ObjectInputStream in = new ObjectInputStream(fis);
         studentList= (ArrayList<Student> )in.readObject();
     } catch (IOException ex) {
         Logger.getLogger(PieChartServlet.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(PieChartServlet.class.getName()).log(Level.SEVERE, null, ex);
     }
      
      for(Student student : studentList){
      log.info(student.getPermanentHomeResidence());
      }
        
        
      DefaultPieDataset dataset = new DefaultPieDataset( );             
      dataset.setValue( "IPhone 5s" , new Double( 20 ) );
      dataset.setValue( "SamSung Grand" , new Double( 20 ) );             
      dataset.setValue( "MotoG" , new Double( 40 ) );             
      dataset.setValue( "Nokia Lumia" , new Double( 10 ) ); 
      
        double[] value = new double[100];
        Random generator = new Random();
        for (int i = 1; i < 100; i++) {

            value[i] = generator.nextDouble();
            int number = 10;
            dataset.setValue("IPhone 5s" , new Double( 20 ));

        }


      JFreeChart chart = ChartFactory.createPieChart3D( 
         "Mobile Sales" ,  // chart title                   
         dataset ,         // data 
         true ,            // include legend                   
         true, 
         false);

      final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( );             
      plot.setStartAngle( 270 );             
      plot.setForegroundAlpha( 0.60f );             
      plot.setInteriorGap( 0.02 );             
      int width = 640; /* Width of the image */             
      int height = 480; /* Height of the image */                             
      File pieChart3D = new File( getServletContext().getRealPath("/Temp")+"/pie_Chart3D.png" );  
      
        try { 
            ChartUtilities.saveChartAsPNG( pieChart3D , chart , width , height );
        } catch (IOException ex) {
            Logger.getLogger(PieChartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
      return chart;

    }

}