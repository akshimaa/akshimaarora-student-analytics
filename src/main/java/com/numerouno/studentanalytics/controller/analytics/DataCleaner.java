/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.controller.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.Remove;

/**
 *DataCleaner is used for processing and formatting the data on which data mining can be performed
 * @author Teck Jan Low
 */
public class DataCleaner {
   /**
    * Filters the data according to the options
    * @param data is the data that has to be filtered
    * @return returns the filtered data
    */ 
    public static Instances filterData(Instances data) {

        // Set options to remove irrelevant columns of data
        String[] options = new String[2];
        options[0] = "-R";
        options[1] = "1-2, 5, 7-12, 15-17, 19-20, 29-30";

        // Set options to change "numeric" equity data to nominal
        String[] optionsNTN = new String[2];
        optionsNTN[0] = "-R";
        optionsNTN[1] = "11-14";

        Remove remove = new Remove();
        NumericToNominal numToNom = new NumericToNominal();

        Instances interimData = null;
        Instances filteredData = null;

        try {

            remove.setOptions(options);
            remove.setInputFormat(data);
            interimData = Filter.useFilter(data, remove);
            numToNom.setOptions(optionsNTN);
            numToNom.setInputFormat(interimData);
            filteredData = Filter.useFilter(interimData, numToNom);

        } catch (Exception e) {
            System.out.println("exception occurred"+e.getMessage());
        }

        return filteredData;

    }
    
}
