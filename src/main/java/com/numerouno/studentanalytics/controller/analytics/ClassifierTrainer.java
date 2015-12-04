/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.controller.analytics;

import com.numerouno.studentanalytics.controller.CSVParser;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.classifiers.functions.MultilayerPerceptron;

/**
 *ClassifierTrainer trains the model that is used in data mining
 * @author Teck Jan Low
 */
public class ClassifierTrainer {
/**
 * 
 * @param data data on which machine learning process can be applied
 * @param key is used to identify the model
 * @return returns the data that is modified according to the machine learning process
 * @throws Exception while working on the data mining process which might cause exceptions.
 */
    public static Classifier trainClassifier(Instances data, int key) throws Exception {

        Classifier classifier;
        if (key == 1) {
            classifier = new MultilayerPerceptron();
        } else {
            classifier = new LinearRegression();
        }

        classifier.buildClassifier(data);
        return classifier;

    }

}
