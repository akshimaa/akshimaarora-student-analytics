/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.controller;

import com.numerouno.studentanalytics.model.Student;
import com.numerouno.studentanalytics.model.StudentList;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

/**
 *
 * @author Dell
 */
public class CSVParser implements Serializable {

    public static void parseIntoPOJO(InputStream fileStream) throws Exception {

        try (ICsvBeanReader beanReader = new CsvBeanReader(new InputStreamReader(fileStream, "UTF8"), CsvPreference.STANDARD_PREFERENCE)) {

            // the header elements are used to map the values to the bean (names must match)
            final String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = Student.getProcessors();
            List<Student> studentList = new ArrayList();
            Student student;
            while ((student = beanReader.read(Student.class, header, processors)) != null) {

                Logger log = Logger.getLogger(CSVParser.class.getName());
                log.info(String.format("lineNo=%s, rowNo=%s, student=%s", beanReader.getLineNumber(),
                        beanReader.getRowNumber(), student));
                studentList.add(student);

            }
            StudentList.setList((ArrayList<Student>) studentList);

        }
    }

    public static Instances parseIntoInstances(InputStream inputStream) throws Exception {

        CSVLoader loader = new CSVLoader();
        loader.setSource(inputStream);
        Instances data = loader.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);
        
        return data;
        
    }

}