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
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.Filter;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Utils;
import weka.filters.unsupervised.attribute.NumericToNominal;

/**
 *
 * @author Dell
 */
public class MLPAnalyser {

    private static Evaluation eval;
    private static MultilayerPerceptron mlp = new MultilayerPerceptron();
    
    private static Instances filterData(Instances data) {

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

    public static void trainMLP() {

        Instances filteredData = filterData(CSVFileProcessor.readARFF());

        try {
            mlp.buildClassifier(filterData(CSVFileProcessor.readARFF()));
            eval = new Evaluation(filteredData);
            eval.crossValidateModel(mlp, filteredData, 10, filteredData.getRandomNumberGenerator(1));
        } catch (Exception e) {
            // Print Exception handling, logger thing
        }

    }

    @Override
    public String toString() {
        
        StringBuffer result;

        result = new StringBuffer();
        result.append("Weka - Demo\n===========\n\n");

        result.append("Classifier...: "
                + mlp.getClass().getName() + " "
                + Utils.joinOptions(mlp.getOptions()) + "\n");
        result.append("Training file: "
                + "Temp/temp.arff" + "\n");
        result.append("\n");

        result.append(mlp.toString() + "\n");
        result.append(eval.toSummaryString() + "\n");
        try {
            result.append(eval.toMatrixString() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            result.append(eval.toClassDetailsString() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString();
        
    }

}
