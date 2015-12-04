/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.controller;

import com.amazonaws.AmazonClientException;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
 *
 * @author Teck Jan Low
 * @version 1.0
 */
public class CSVFileProcessor {

    /**
     * reads the data from amazon S3 into the file
     * @param bucket data is written from the bucket to the file 
     * @param key key is used to compare the value
     * @param filePath stores the location of file
     */
    public static void readFromS3(String bucket, String key, String filePath) {
        //student-alpha, STUDENT.dat, 
        AWSCredentials credentials = new ProfileCredentialsProvider().getCredentials();
        AmazonS3 s3client = new AmazonS3Client(credentials);
        s3client.getObject(new GetObjectRequest(bucket, key),
                new File(filePath));

    }

    /**
     * writeIntoS3 method is used to write the data into the S3 bucket
     *
     * @param bucket the data is written into the bucket
     * @param key determines the model that is used for the data mining
     * @param file data from the file is written into the bucket
     */
    public static void writeIntoS3(String bucket, String key, File file) {

        AWSCredentials credentials = new ProfileCredentialsProvider().getCredentials();

        try {
            AmazonS3 s3client = new AmazonS3Client(credentials);
            s3client.putObject(new PutObjectRequest(bucket, key, file));
        } catch (AmazonClientException ex) {
            Logger.getLogger(CSVFileProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * merges the uploaded data and original data and processes the data
     * @param inputStream input stream gives the data to be processed. 
     * @param path path defines the location of the file
     */
    public static void mergeCSV(InputStream inputStream, String path) {

        // Specify import file format
        FileFormat csv = FileFormat.CSV;
        // create new File objects
        File remoteFile = new File(path + "/remote.csv");
        File mergedFile = new File(path + "/merge.csv");

        try {
            //FileUtils.copyInputStreamToFile(inputStream, localFile);
            // Import .csv as matrices
            Matrix local = Matrix.Factory.importFrom().stream(inputStream).asDenseCSV();
            Matrix temp = local.deleteRows(Calculation.Ret.NEW, 0);
            readFromS3("student-alpha", "STUDENT.csv", path + "/remote.csv");
            Matrix remote = Matrix.Factory.importFrom().file(remoteFile).asDenseCSV();
            Matrix merged = remote.appendVertically(Calculation.Ret.NEW, temp);

            // Export merged matrix as .csv
            merged.exportTo().file(mergedFile).asDenseCSV(',');
            writeIntoS3("student-gamma", "student-merged.csv", mergedFile);

        } catch (IOException i) {
            Logger log = Logger.getLogger(CSVFileProcessor.class.getName());
            log.severe(i.toString());
        }

    }

}
