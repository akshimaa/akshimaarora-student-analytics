/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.service;

import com.numerouno.studentanalytics.controller.CSVParser;
import com.sun.istack.internal.logging.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author madan
 */
@MultipartConfig
public class CSVFileUploadServlet extends HttpServlet {
    
    @Override
    public void init() throws ServletException
    {
        
    }
 

    @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         
        PrintWriter out = resp.getWriter();
        if(req != null)
        {
            CSVParser.parseIntoPOJO(req.getPart("file").getInputStream());
            Logger log = Logger.getLogger(CSVFileUploadServlet.class);
            log.info("CSV file parsed successfully!");
            out.print("The file you uploaded is '" + req.getPart("file").getSubmittedFileName()+"' and it has been parsed successfully!");
            
        }
       
     }
}
