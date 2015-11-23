/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import weka.core.Instances;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.Filter;

/**
 *
 * @author Dell
 */
public class WekaAnalysis {
    
    private static Instances readARFF() {

        Instances data = null;
        
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(new File("Temp/temp.arff")));
            data = new Instances(reader);
            reader.close();
            // setting class attribute
            data.setClassIndex(data.numAttributes() - 1);
            
            
        } catch (IOException i) {
            System.out.println(i);
        }
        
        return data;

    }
    
    
    private static Instances filterData(Instances data) {
        
        String[] options = new String[2];
        options[1] = "-R";
        options[2] = "1-3, 6, 8-13, 16-18, 20-21, 30-31";
        
        Remove remove = new Remove();
        Instances filteredData = null;
        
        try {
            
            remove.setOptions(options);
            remove.setInputFormat(data);
            filteredData = Filter.useFilter(data, remove);
            
        } catch (Exception e) {
            // Insert Exception handling here, logger thingy
        }
        
        return filteredData;
        
    }
    
    public static void trainClassifier() {
        
    }
    
}
