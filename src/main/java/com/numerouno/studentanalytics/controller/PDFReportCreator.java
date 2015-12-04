/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.controller;


import com.numerouno.studentanalytics.model.PDFReportItemList;
import com.numerouno.studentanalytics.view.BarChartServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Akshima
 */
public class PDFReportCreator extends HttpServlet {
 Logger log = Logger.getLogger(PDFReportCreator.class.getName());
 
 public static ArrayList<String> pdfList= PDFReportItemList.getItemList();
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet PDFReportItemCreator</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet PDFReportItemCreator at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
            
            log.info("In servlet");
        String datasource = request.getParameter("datasource");
        String preset = request.getParameter("preset");
        String imageFileName = datasource.concat("_").concat(preset).concat("_bar.png");
            ArrayList<String> reportList= createReportList(imageFileName);
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
    
    public ArrayList<String> createReportList(String imageFileName){
        pdfList.add(imageFileName);
      log.info(pdfList.get(0));
    return PDFReportItemList.getItemList();
    }

}
