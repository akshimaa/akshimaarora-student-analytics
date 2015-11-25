/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.controller.analytics;

import java.util.ArrayList;
import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author Dell
 */
public class Predictor {

    public static double[] predict(Instances dataSet, Classifier classifier) {

        double[] output = new double[dataSet.numInstances()];
        
        try {
            for (int i = 0; i < dataSet.numInstances(); i++) {

                Instance newInstance = dataSet.instance(i);
                double prediction = classifier.classifyInstance(newInstance);
                output[i] = prediction;

            }
        } catch (Exception e) {
            // Exception handling here
        }

        return output;
        
    }

}
