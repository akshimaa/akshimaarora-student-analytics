/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.service;


import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;


/**
 *
 * @author madan
 */
public class ReportGeneratorServlet extends HttpServlet {

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
        



PDDocument document = new PDDocument();
File imageFile = new File(getServletContext().getRealPath("/Temp/grumpy_cat.jpg"));
InputStream in = new FileInputStream(imageFile);
BufferedImage bimg = ImageIO.read(in);
float width = bimg.getWidth();
float height = bimg.getHeight();
PDPage page = new PDPage(new PDRectangle(width, height));
document.addPage(page); 
PDXObjectImage img = new PDJpeg(document, new FileInputStream(imageFile));
PDPageContentStream contentStream = new PDPageContentStream(document, page);
contentStream.drawImage(img, 0, 0);
contentStream.close();
in.close();
File saveFile = null;
        try {
            saveFile = new File(getServletContext().getRealPath("/Temp")+"/test.pdf");
            Logger.getLogger(ReportGeneratorServlet.class.getName()).log(Level.INFO, saveFile.getAbsolutePath());
            document.save(saveFile);
            document.close();
        } catch (COSVisitorException ex) {
            Logger.getLogger(ReportGeneratorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String pdfFileName = getServletContext().getRealPath("/Temp/test.pdf");
		String contextPath = getServletContext().getRealPath(File.separator);
		//File pdfFile = new File(contextPath + pdfFileName);

		response.setContentType("application/pdf");
		//response.addHeader("Content-Disposition", "attachment; filename=" + "report.pdf");
		response.setContentLength((int) saveFile.length());

		FileInputStream fileInputStream = new FileInputStream(saveFile);
		OutputStream responseOutputStream = response.getOutputStream();
		int bytes;
		while ((bytes = fileInputStream.read()) != -1) {
			responseOutputStream.write(bytes);
		}
                fileInputStream.close();


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

}
