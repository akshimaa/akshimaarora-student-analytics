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
 *
 * @author Dell
 */
public class DataCleaner {
    
    protected static Instances filterData(Instances data) {

        // Set options to remove irrelevant columns of data
        String[] options = new String[2];
        options[1] = "-R";
        options[2] = "1-2, 5, 7-12, 15-17, 19-20, 29-30";

        // Set options to change "numeric" equity data to nominal
        String[] optionsNTN = new String[2];
        optionsNTN[1] = "-R";
        optionsNTN[2] = "11-14";

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
            // Insert Exception handling here, logger thingy
        }

        return filteredData;

    }
    
}
