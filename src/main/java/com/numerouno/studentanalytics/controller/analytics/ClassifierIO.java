/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.controller.analytics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.Classifier;
import weka.classifiers.functions.LinearRegression;

/**
 *
 * @author Dell
 */
public class ClassifierIO {

    public static void writeClassifier(Classifier classifier, String path) throws Exception {

        String fileName = "";

        if (classifier instanceof MultilayerPerceptron) {
            fileName = "MultilayerPerceptron";
        } else if (classifier instanceof LinearRegression) {
            fileName = "LinearRegression";
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                new File(path + "/" + fileName + ".model")));
        oos.writeObject(classifier);
        oos.flush();
        oos.close();

    }

    public static Classifier readClassifier(String modelPath, String key) throws Exception {

        String modelName = "";
        if (Integer.parseInt(key) == 1) {
            modelName = "MultilayerPerceptron";
        } else if (Integer.parseInt(key) == 2){
            modelName = "LinearRegression";
        }
        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File(modelPath + "/" + modelName + ".model")));
        Classifier classifier = (Classifier) ois.readObject();
        ois.close();

        return classifier;

    }

}
