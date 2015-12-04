/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.model;

import java.util.ArrayList;
import org.ujmp.core.collections.list.ArrayIndexList;

/**
 *PDFReportItemList generates the pdf report of the bar and pie charts
 * @author Akshima
 */
public class PDFReportItemList {
    private static ArrayList<String> itemList = new ArrayIndexList<>();
/**
 * gets the item list to generate as pdf
 * @return 
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
