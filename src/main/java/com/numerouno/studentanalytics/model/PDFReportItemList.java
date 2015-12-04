/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


/**
 *PDFReportItemList generates the pdf report of the bar and pie charts
 * @author Akshima
 */
public class PDFReportItemList {
    private static Set<String> itemList = new HashSet<>();
/**
 * gets the item list to generate as pdf
 * @return returns the list of items as pdf
 */
    public static Set<String> getItemList() {
        return itemList;
    }
/**
 * sets the item list to generate pdf
 * @param itemList sets the item list to generate pdf
 */
    public static void setItemList(Set<String> itemList) {
        PDFReportItemList.itemList = itemList;
    }

}
