/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csi.studentanalytics.model;

import java.util.Date;
import java.util.Locale;

/**
 * 
 * @author Madan Parameswaran
 */
public class Student {
    

    private Date dateOfBirth;
    public enum Sex { MALE, FEMALE};
    private Sex gender;
    private Locale citizenship;
    private CourseInformation courseInformation;
    private Address termResidence;
    private Address permanentHomeResidence;
    public enum Attendance {FULL_TIME, PART_TIME};
    private Attendance attendanceType;
    private String countryOfBirth;
    private String languageSpokenAtHome;
    private String yearOfArrivalInUSA;
    private Score score;
    private String courseCompletionYear;
    private float earnedGPA;
    private String highestEducation;
    private EquityData equityData;
    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public Locale getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Locale citizenship) {
        this.citizenship = citizenship;
    }

    public CourseInformation getCourseInformation() {
        return courseInformation;
    }

    public void setCourseInformation(CourseInformation courseInformation) {
        this.courseInformation = courseInformation;
    }

    public Address getTermResidence() {
        return termResidence;
    }

    public void setTermResidence(Address termResidence) {
        this.termResidence = termResidence;
    }

    public Address getPermanentHomeResidence() {
        return permanentHomeResidence;
    }

    public void setPermanentHomeResidence(Address permanentHomeResidence) {
        this.permanentHomeResidence = permanentHomeResidence;
    }

    public Attendance getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(Attendance attendanceType) {
        this.attendanceType = attendanceType;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getLanguageSpokenAtHome() {
        return languageSpokenAtHome;
    }

    public void setLanguageSpokenAtHome(String languageSpokenAtHome) {
        this.languageSpokenAtHome = languageSpokenAtHome;
    }

    public String getYearOfArrivalInUSA() {
        return yearOfArrivalInUSA;
    }

    public void setYearOfArrivalInUSA(String yearOfArrivalInUSA) {
        this.yearOfArrivalInUSA = yearOfArrivalInUSA;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getCourseCompletionYear() {
        return courseCompletionYear;
    }

    public void setCourseCompletionYear(String courseCompletionYear) {
        this.courseCompletionYear = courseCompletionYear;
    }

    public float getEarnedGPA() {
        return earnedGPA;
    }

    public void setEarnedGPA(float earnedGPA) {
        this.earnedGPA = earnedGPA;
    }

    public String getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
    }

    public EquityData getEquityData() {
        return equityData;
    }

    public void setEquityData(EquityData equityData) {
        this.equityData = equityData;
    }
    
    
}
