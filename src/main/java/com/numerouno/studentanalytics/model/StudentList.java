/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.model;

import java.util.ArrayList;

/**
 * Creates the list of students both existing as well as merged
 *
 * @author madan
 */
public class StudentList {

    private static ArrayList<Student> list;
    private static ArrayList<Student> mergedList;

    /**
     * gets the list of the students
     *
     * @return returns the list of the students
     */
    public static ArrayList<Student> getList() {
        return list;
    }

    /**
     * sets the list of the students
     *
     * @param list returns the list of the students
     */
    public static void setList(ArrayList<Student> list) {
        StudentList.list = list;
    }

    /**
     * gets the merged list of students
     *
     * @return returns the merged list of students
     */
    public static ArrayList<Student> getMergedList() {
        return mergedList;
    }

    /**
     * sets the merged list of students
     *
     * @param mergedList sets the merged list of the students
     */
    public static void setMergedList(ArrayList<Student> mergedList) {
        StudentList.mergedList = mergedList;
    }

}
