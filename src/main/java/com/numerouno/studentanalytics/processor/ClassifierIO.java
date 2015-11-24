/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.processor;

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

    protected static void writeClassifier(Classifier classifier) {

        String fileName;

        if (classifier instanceof MultilayerPerceptron) {
            fileName = "MLP";
        } else {
            fileName = "LinearRegression";
        }

        // Serialize trained model
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("Classifiers/" + fileName + ".model"))) {

            oos.writeObject(classifier);
            oos.flush();
            oos.close();

        } catch (IOException i) {
            // Exception handling here
        }

    }

    protected static void readClassifier(String name) {

        Classifier cls;
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("Classifiers/" + name + ".model"))) {
            
            cls = (Classifier) ois.readObject();
            ois.close();
            
        } catch (IOException | ClassNotFoundException e) {
            // Exception handling code here
        }

    }

}
