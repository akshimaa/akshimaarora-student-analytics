/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.processor;

import java.io.IOException;
import org.ujmp.core.Matrix;
import org.ujmp.core.calculation.Calculation;
import org.ujmp.core.filematrix.FileFormat;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.ujmp.core.util.io.FileUtil;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

/**
 * Used to perform all Weka file parsing and data analytics functionality.
 * @author Teck Jan Low
 * @version 1.0
 */
public class CSVFileProcessor {

    /**
     * Reads from the Amazon AWS S3 bucket and saves the file as a temp file.
     */
    public static void readFromsS3() {
        
        AWSCredentials credentials = new ProfileCredentialsProvider().getCredentials();
        AmazonS3 s3client = new AmazonS3Client(credentials);
        s3client.getObject(new GetObjectRequest("student-alpha", "student.csv"),
                new File("Temp/tempRemote.csv"));
        
    }
    
       public static void writeIntosS3(InputStream stream) {
        
        AWSCredentials credentials = new ProfileCredentialsProvider().getCredentials();
        AmazonS3 s3client = new AmazonS3Client(credentials);
        File tempFile = new File("Temp/tempFile.csv");
        try {
            FileUtils.copyInputStreamToFile(stream, tempFile);
            s3client.putObject(new PutObjectRequest("student-beta","student-upload.csv",tempFile));
        } catch (IOException ex) {
            Logger.getLogger(CSVFileProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }

    /**
     * Merges the remote and local .csv files and saves it as a temp file.
     * @param filePath The file path of the local .csv file
     */
    public static void mergeCSV(InputStream inputStream) {

        // Specify import file format
        FileFormat csv = FileFormat.CSV;
        // create new File objects
        File localFile = new File("Temp/tempLocal.csv");
        File remoteFile = new File("Temp/tempRemote.csv");
        File exportFile = new File("Temp/tempMerged.csv");
        

        try {
            FileUtils.copyInputStreamToFile(inputStream, localFile);
            // Import .csv as matrices
            Matrix local = Matrix.Factory.importFrom().file(localFile).asDenseCSV();
            Matrix remote = Matrix.Factory.importFrom().file(remoteFile).asDenseCSV();
            Matrix merged = remote.appendVertically(Calculation.Ret.NEW, local);

            // Export merged matrix as .csv
            merged.exportTo().file(exportFile).asDenseCSV(',');

        } catch (IOException i) {
            Logger log = Logger.getLogger(CSVFileProcessor.class.getName());
            log.severe(i.toString());
        }

    }

    /**
     * Parses .csv files into .arff files for use by the Weka package.
     * @param fileName The path of the file to be parsed.
     */
    public static void CSVtoARFF(String filePath) {
        
        try {
            
            // load CSV
            CSVLoader loader = new CSVLoader();
            loader.setSource(new File(filePath));
            Instances data = loader.getDataSet();

            // save ARFF
            ArffSaver saver = new ArffSaver();
            saver.setInstances(data);
            saver.setFile(new File("Temp/temp.arff"));
            saver.writeBatch();
            
        } catch (IOException i) {
            
        }

    }

    /**
     * Creates a prediction of a dataset based on a trained classifier.
     */
    public static void predict() {

    }

    /**
     * Trains a new classifier from existing data.
     */
    public static void train() {

    }

}
