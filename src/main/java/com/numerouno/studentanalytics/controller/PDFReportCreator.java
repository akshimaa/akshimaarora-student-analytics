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
import org.json.JSONObject;

/**
 * PDFReportCreator creates the PDF report from the given data
 *
 * @author Akshima
 */
public class PDFReportCreator extends HttpServlet {

    Logger log = Logger.getLogger(PDFReportCreator.class.getName());

    public static ArrayList<String> pdfList = PDFReportItemList.getItemList();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet requests to generate pdf report of the analysis of
     * the given data
     * @param response servlet response responds and generate the PDF report
     * using the image from the image file name
     * @throws ServletException is thrown if a servlet-specific error occurs
     * @throws IOException is thrown if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<String> reportList = new ArrayList<>();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            log.info("In servlet");
            String datasource = request.getParameter("datasource");
            String preset = request.getParameter("preset");
            String generatePage = request.getParameter("showChart");
            int length = pdfList.size();
            if (generatePage.equals("showChart") && generatePage != null) {
                log.info("In LOOP");
                reportList = PDFReportItemList.getItemList();
            } else {
                log.info("In ELSE");
                String imageFileName = datasource.concat("_").concat(preset).concat("_bar.png");
                reportList = createReportList(imageFileName);
            }

            JSONObject json = new JSONObject();
            json.put("charts", reportList);
//             for(int i=0; i< reportList.size();i++){
//        json.put("charts_"+i,"<img src='"+ getServletContext().getContextPath() + "/images" + "/" + reportList.get(i)+"'>");
//              }

            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            out.println(json);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request gets the request to generate PDF report
     * from the data
     * @param response servlet responds to the request and processes the request
     * @throws ServletException is notified if a servlet-specific error occurs
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
     * @param request servlet request to create PDF report
     * @param response servlet response creates the PDF report to the request
     * @throws ServletException handles if a servlet-specific error occurs
     * @throws IOException notifies if an I/O error occurs
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
     * creates an array list of the image files that are being added
     *
     * @param imageFileName is the name of the file being added to the array
     * list to be generated as a PDF
     * @return returns the list which are generated as PDF
     */
    public ArrayList<String> createReportList(String imageFileName) {
        pdfList.add(imageFileName);
        log.info(pdfList.get(0));
        return PDFReportItemList.getItemList();
    }

}
