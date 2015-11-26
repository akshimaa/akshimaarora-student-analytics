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

    protected static void writeClassifier(Classifier classifier, String path) throws Exception {

        String fileName = "";

        if (classifier instanceof MultilayerPerceptron) {
            fileName = "MultilayerPerceptron";
        } else if (classifier instanceof LinearRegression) {
            fileName = "LinearRegression";
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path + fileName)));
        oos.writeObject(classifier);
        oos.flush();
        oos.close();

    }

    protected static Classifier readClassifier(String path) throws Exception {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)));
        Classifier classifier = (Classifier) ois.readObject();
        ois.close();

        return classifier;

    }

}
