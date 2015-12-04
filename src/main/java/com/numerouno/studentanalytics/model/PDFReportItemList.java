/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.model;

import java.util.ArrayList;

/**
 *
 * @author Akshima
 */
public class PDFReportItemList {
    private static ArrayList<Student> itemList;

    public static ArrayList<Student> getItemList() {
        return itemList;
    }

    public static void setItemList(ArrayList<Student> itemList) {
        PDFReportItemList.itemList = itemList;
    }
    
}
