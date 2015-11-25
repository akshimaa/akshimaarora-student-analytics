/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalysis.controller;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Utils;

/**
 *
 * @author Dell
 */
public class ClassifierTrainer {

    private static Evaluation eval;
    
    public static MultilayerPerceptron trainMLP() {
        
        MultilayerPerceptron mlp = new MultilayerPerceptron();
        Instances filteredData = ARFFProcessor.filterData(ARFFProcessor.readARFF());

        try {
            
            mlp.buildClassifier(ARFFProcessor.filterData(ARFFProcessor.readARFF()));
            eval = new Evaluation(filteredData);
            eval.crossValidateModel(mlp, filteredData, 10, filteredData.getRandomNumberGenerator(1));
            
            System.out.println("Classifier taining complete");
            
            ClassifierIO.writeClassifier(mlp);
            
        } catch (Exception e) {
            // Print Exception handling, logger thing
        }

        return mlp;
        
    }
    
    public static LinearRegression trainLR() {
        
        LinearRegression lr = new LinearRegression();
        
        Instances filteredData = ARFFProcessor.filterData(ARFFProcessor.readARFF());

        try {
            
            lr.buildClassifier(ARFFProcessor.filterData(ARFFProcessor.readARFF()));
            eval = new Evaluation(filteredData);
            eval.crossValidateModel(lr, filteredData, 10, filteredData.getRandomNumberGenerator(1));
            
            System.out.println("Classifier taining complete");
            
            ClassifierIO.writeClassifier(lr);
            
        } catch (Exception e) {
            // Print Exception handling, logger thing
        }

        return lr;
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
