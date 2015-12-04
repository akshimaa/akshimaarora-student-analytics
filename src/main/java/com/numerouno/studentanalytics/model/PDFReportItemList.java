/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.model;

import java.util.ArrayList;
import org.ujmp.core.collections.list.ArrayIndexList;

/**
 *
 * @author Akshima
 */
public class PDFReportItemList {
    private static ArrayList<String> itemList = new ArrayIndexList<>();

    public static ArrayList<String> getItemList() {
        return itemList;
    }

    public static void setItemList(ArrayList<String> itemList) {
        PDFReportItemList.itemList = itemList;
    }

   

    
}
