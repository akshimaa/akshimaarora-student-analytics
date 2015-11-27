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
 *
 * @author Dell
 */
public class ClassifierTrainer {

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
