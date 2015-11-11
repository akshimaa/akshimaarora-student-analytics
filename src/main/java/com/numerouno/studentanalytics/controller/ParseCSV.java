/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.controller;

import java.io.File;
import java.io.IOException;
import org.jdmp.core.dataset.MatrixDataSet;
import org.ujmp.core.Matrix;
import org.ujmp.core.calculation.Calculation;
import org.ujmp.core.filematrix.FileFormat;

/**
 *
 * @author Dell
 */
public class ParseCSV {
    
    public void testMethod() {
        
        // Specify import file format
        FileFormat csv = FileFormat.CSV;
        // REPLACE THIS WITH YOUR FILEPATH READ FROM DIALOG BOX OPERATIONS
        File file = new File("C:\\Users\\Dell\\Documents\\studentdata.csv");
        // REPLACE WITH FILE EXPORT DIALOG BOX OPERATION
        File exportFile = new File("C:\\Users\\Dell\\Documents\\testOutput.csv");
        // Initialise new matrices
        Matrix m1, m3;
        
        try { 
            
            // Import .csv as a matrix
            m1 = Matrix.Factory.importFrom().file(file).asDenseCSV();
            
            // The .showGUI() method in the Matrix class serves as a visualisation tool
            // NOTE: It may not work after a single clean and build, requiring a system
            // restart. Currently only for personal visualisation purposes.
//            m1.showGUI();         // UNCOMMENT ME!
            
            // EXAMPLE CODE FOR ELEMENT EXTRACTION
            // Other .getAs() methods exist for other primitive datatypes
            for (int i = 5; i < 10; i++){
                String extractedElement = m1.getAsString(i,5);
                System.out.println(extractedElement);
            }
            
            // EXAMPLE CODE TO SHOW MATRIX DIMENSIONS
            long[] size1 = m1.getSize();
            System.out.println("MATRIX ONE SIZE:");
            System.out.println("Number of rows: " + size1[0]);
            System.out.println("Number of columns: " + size1[1]);

            // EXAMPLE CODE FOR COLUMN DELETION
            m3 = m1.deleteColumns(Calculation.Ret.NEW, 0);
            long[] size3 = m3.getSize();
            System.out.println("TRUNCATED MATRIX SIZE:");
            System.out.println("Number of rows: " + size3[0]);
            System.out.println("Number of columns: " + size3[1]);
            
            // Convert to MatrixDataSet for JDMP
            MatrixDataSet m4 = new MatrixDataSet(m3);
            
            // NOTE: I'm not entirely sure why getsize returns a column value of 
            // one for the MatrixDataSet. I'm still trying to figure that one out.
            long[] size2 = m4.getSize();
            System.out.println("MatrixDataSet SIZE:");
            System.out.println("Number of rows: " + size2[0]);
            System.out.println("Number of columns: " + size2[1]);
            
            // EXAMPLE CODE FOR MATRIX MERGING
            Matrix m5 = m1.appendVertically(Calculation.Ret.NEW, m1);
            long[] size5 = m5.getSize();
            System.out.println("MERGED DATA SIZE:");
            System.out.println("Number of rows: " + size5[0]);
            System.out.println("Number of columns: " + size5[1]);
            
            // EXAMPLE CODE FOR EXPORTING MATRIX OBJECTS
            m5.exportTo().file(exportFile).asDenseCSV(',');
            
        } catch (IOException i ) {
            // NOTE: Matrix.Factory.importFrom() requires IOException
            System.out.println("ERROR:" + i);
        }
        
        // ADDITIONAL TEST CODE (Currently only for testing)
        // Standardize will "standardize" columns of the matrix for statistical 
        // processing. Be careful when using
//        m2 = m1.standardize(Ret.NEW, "4-100;6,7,8-10,100-200");
//        m3 = m2.addMissing(Ret.NEW, Matrix.ROW);
//        m4 = m3.addMissing(Ret.NEW, Matrix.ALL, 0.05);
//        m5 = m4.impute(Ret.NEW, ImputationMethod.KNN, 2);
//        lu = m5.lu();
//        m6 = lu[0].bootstrap(Ret.LINK, 1000000);
//        double v = m6.getAsDouble(0,0);
        
    }
    
}
