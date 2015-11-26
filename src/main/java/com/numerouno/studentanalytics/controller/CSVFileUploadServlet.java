/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.controller;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import java.io.File;

import java.util.logging.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;



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
        
        if(req != null)
        {
            
            Logger log = Logger.getLogger(CSVFileUploadServlet.class.getName());
            log.info(req.getPart("file").getSubmittedFileName().concat(" file uploaded successfully!"));
            CSVFileProcessor.mergeCSV(req.getPart("file").getInputStream());
           // CSVFileProcessor.writeIntosS3(req.getPart("file").getInputStream());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index");
      
            try {
                
                CSVParser.parseIntoPOJO(req.getPart("file").getInputStream());
                log.info(req.getPart("file").getSubmittedFileName().concat(" file parsed successfully!"));
                File file = new File(getServletContext().getRealPath("/Temp")+"/upload.csv");
                FileUtils.copyInputStreamToFile(req.getPart("file").getInputStream(), file);
                CSVFileProcessor.writeIntosS3("student-beta", "student-upload.csv", file); //write into s3 bucket 1
                CSVFileProcessor.mergeCSV(req.getPart("file").getInputStream()); //merge to exsiting data
                req.setAttribute("status", req.getPart("file").getSubmittedFileName()+" has been parsed and uploaded successfully");
                
           
            } catch (Exception ex) {
                Logger.getLogger(CSVFileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
                req.setAttribute("status", "Oops something went wrong! Server side error while attempting to parse and upload");
         
            }
            requestDispatcher.forward(req, resp);

        }
        
        
        
        
        
                
                
        
        
            
              
 
          
     }
}
