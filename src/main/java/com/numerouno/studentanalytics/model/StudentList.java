/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.model;

import java.util.List;

/**
 *
 * @author madan
 */
public class StudentList {
    
    private static List<Student> list;

    public static List<Student> getList() {
        return list;
    }

    public static void setList(List<Student> list) {
        StudentList.list = list;
    }
    
    
}
