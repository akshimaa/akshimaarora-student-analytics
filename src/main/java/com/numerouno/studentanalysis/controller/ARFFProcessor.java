/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalysis.controller;

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
public class ARFFProcessor {
    
    protected static Instances readARFF() {

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
    
    protected static Instances filterData(Instances data) {

        // Set options to remove irrelevant columns of data
        String[] options = new String[2];
        options[1] = "-R";
        options[2] = "1-3, 6, 8-13, 16-18, 20-21, 30-31";

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
