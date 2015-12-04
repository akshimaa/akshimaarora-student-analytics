/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.model;

import java.util.ArrayList;


/**
 *PDFReportItemList generates the pdf report of the bar and pie charts
 * @author Akshima
 */
public class PDFReportItemList {
    private static ArrayList<String> itemList = new ArrayList<>();
/**
 * gets the item list to generate as pdf
 * @return returns the list of items as pdf
 */
    public static ArrayList<String> getItemList() {
        return itemList;
    }
/**
 * sets the item list to generate pdf
 * @param itemList sets the item list to generate pdf
 */
    public static void setItemList(ArrayList<String> itemList) {
        PDFReportItemList.itemList = itemList;
    }

}
