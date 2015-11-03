
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.model;

/**
 *
 * @author Madan Parameswaran, Melissa Burns
 */
 
 
public class CourseInformation extends Student{

    public enum Degree {UNDERGRAD, POSTGRAD};
    private Degree degreeLevel;
    public enum Course {};
    private Course courseInfo;
    public enum EducationField {CS, ENG, GES, LANG, BIO, ENGLISH, IT, MBA, MISM, PPM, MSIT, MCS, MS, MENG};
    private EducationField eduField;

    public Degree getDegreeLevel() {
        return degreeLevel;
    }

    public void setDegreeLevel(Degree degreeLevel) {
        this.degreeLevel = degreeLevel;
    }

    public Course getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(Course courseInfo) {
        this.courseInfo = courseInfo;
    }

    public EducationField getEduField() {
        return eduField;
    }

    public void setEduField(EducationField eduField) {
        this.eduField = eduField;
    }
    
    

    
}

