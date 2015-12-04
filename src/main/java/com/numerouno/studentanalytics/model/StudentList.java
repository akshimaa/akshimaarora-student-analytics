/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.model;

import java.util.ArrayList;

/**
 *
 * @author madan
 */
public class StudentList {
/**
 * 
 */
    private static ArrayList<Student> list;
    private static ArrayList<Student> mergedList;
/**
 * 
 * @return 
 */
    public static ArrayList<Student> getList() {
        return list;
    }
/**
 * 
 * @param list 
 */
    public static void setList(ArrayList<Student> list) {
        StudentList.list = list;
    }

    public static ArrayList<Student> getMergedList() {
        return mergedList;
    }

    public static void setMergedList(ArrayList<Student> mergedList) {
        StudentList.mergedList = mergedList;
    }

}
