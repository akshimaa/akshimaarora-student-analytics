/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.model;



import java.util.Locale;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;
/**
 * 
 * @author Madan Parameswaran
 */
public class Student {
    
    public int studentID;
    public enum Course {CS, ENG, GES, LANG, BIO, ENGLISH, IT, MBA, MISM, PPM, MSIT, MCS, MS, MENG};
    private Course courseInformation;
    public enum Degree {UNDERGRAD, POSTGRAD};
    private Degree degreeLevel;
    private String fieldEducation; 
    public int age;
    public enum Sex {M, F};
    private Sex gender;
    private String citizenship;
    private String termResidence;
    private String permanentHomeResidence;
    private String city;
    private String state;
    private String zipCode;
    private Locale country;
    public enum BasisEnrollment {TESTSCORE,GENDER,SOCIECONOMICAL,PARENTAL,RESIDENTIAL};
    private BasisEnrollment basisEnroll;
    public enum Attendance {FULL_TIME, PART_TIME};
    private Attendance attendanceType;
    private enum ModeAttendance {INTERNAL, EXTERNAL, MULTIMODAL};
    private ModeAttendance mode;
    private Locale countryOfBirth;
    private Locale language;
    private String yearOfArrivalInUSA;   
    private int enrollmentYear;  
    public enum Type {SAT, GRE, GMAT};
    private Type entranceExam;
    private int score;
    public enum Equity {D, LI, WNT, RR, NONE};
    private Equity equityData;
    public enum HighestEducationLevel {HS,AS,BS,MA};
    private HighestEducationLevel highestEduLevel;
    private String courseCompletionYear;
    private float earnedGPA;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Course getCourseInformation() {
        return courseInformation;
    }

    public void setCourseInformation(Course courseInformation) {
        this.courseInformation = courseInformation;
    }

    public Degree getDegreeLevel() {
        return degreeLevel;
    }

    public void setDegreeLevel(Degree degreeLevel) {
        this.degreeLevel = degreeLevel;
    }

    public String getFieldEducation() {
        return fieldEducation;
    }

    public void setFieldEducation(String fieldEducation) {
        this.fieldEducation = fieldEducation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
  
    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getTermResidence() {
        return termResidence;
    }

    public void setTermResidence(String termResidence) {
        this.termResidence = termResidence;
    }

    public String getPermanentHomeResidence() {
        return permanentHomeResidence;
    }

    public void setPermanentHomeResidence(String permanentHomeResidence) {
        this.permanentHomeResidence = permanentHomeResidence;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Locale getCountry() {
        return country;
    }

    public void setCountry(Locale country) {
        this.country = country;
    }

    public BasisEnrollment getBasisEnroll() {
        return basisEnroll;
    }

    public void setBasisEnroll(BasisEnrollment basisEnroll) {
        this.basisEnroll = basisEnroll;
    }

    public Attendance getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(Attendance attendanceType) {
        this.attendanceType = attendanceType;
    }

    public ModeAttendance getMode() {
        return mode;
    }

    public void setMode(ModeAttendance mode) {
        this.mode = mode;
    }
    public Locale getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(Locale countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getYearOfArrivalInUSA() {
        return yearOfArrivalInUSA;
    }

    public void setYearOfArrivalInUSA(String yearOfArrivalInUSA) {
        this.yearOfArrivalInUSA = yearOfArrivalInUSA;
    }
    public Locale getLanguage() {
        return language;
    }

    public void setLanguageSpokenAtHome(Locale language) {
        this.language = language;
    }
    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public Type getEntranceExam() {
        return entranceExam;
    }

    public void setEntranceExam(Type entranceExam) {
        this.entranceExam = entranceExam;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Equity getEquityData() {
        return equityData;
    }

    public void setEquityData(Equity equityData) {
        this.equityData = equityData;
    }

    public HighestEducationLevel getHighestEduLevel() {
        return highestEduLevel;
    }

    public void setHighestEduLevel(HighestEducationLevel highestEduLevel) {
        this.highestEduLevel = highestEduLevel;
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
 
    public static CellProcessor[] getProcessors() {
        
        final String emailRegex = "[a-z0-9\\._]+@[a-z0-9\\.]+"; // just an example, not very robust!
        StrRegEx.registerMessage(emailRegex, "must be a valid email address");
        
        final CellProcessor[] processors = new CellProcessor[] { 
                
                //new NotNull(new ParseInt()), // student ID
                new NotNull(new ParseInt()), // age
                new NotNull(new ParseSex()), //gender
                new NotNull(new ParseCountry()), //country
                new NotNull(new ParseLanguage()), //language
                //new NotNull(new Parese) //citizenship
        
        };
        
        return processors;
}
    
 
    private static class ParseSex extends CellProcessorAdaptor
    {
       
        public ParseSex()
        {
            super();
        }
        
        public ParseSex(CellProcessor next)
        {
          super(next);   
        }
        @Override
        public Object execute(Object value, CsvContext context) {
        
        validateInputNotNull(value, context);  // throws an Exception if the input is null
                
                for (Sex gender : Sex.values()){
                        if (gender.name().equalsIgnoreCase(value.toString())){
                                gender = Sex.valueOf(((String) value).toUpperCase());
                                return next.execute(gender, context);
                        }
                        
                }
               
                  throw new SuperCsvCellProcessorException(
                        String.format("Could not parse '%s' as a gender", value), context, this);
        }
                

        }
        
    private static class ParseCountry extends CellProcessorAdaptor
    {

        public ParseCountry()
        {
            super();
        }
        
        public ParseCountry(CellProcessor next)
        {
            super(next);
        }
        @Override
        public Object execute(Object value, CsvContext context) {
            validateInputNotNull(value, context);
            Locale.setDefault(Locale.US);
            for(Locale country : Locale.getAvailableLocales())
            {
                if(country.getDisplayCountry().equals(value.toString()))
                {
                    return next.execute(country, context);
                }
            }
            
            throw new SuperCsvCellProcessorException(
                        String.format("Could not parse '%s' as a locale-country", value), context, this);
     
        }
        
    }
    
    private static class ParseLanguage extends CellProcessorAdaptor
    {

        public ParseLanguage()
        {
            super();
        }
        
        public ParseLanguage(CellProcessor next)
        {
            super(next);
        }
        @Override
        public Object execute(Object value, CsvContext context) {
            validateInputNotNull(value, context);
            Locale.setDefault(Locale.US);
            for(Locale language : Locale.getAvailableLocales())
            {
                
                if(language.getDisplayLanguage().equals(value.toString().trim()))
                {
                    return next.execute(language, context);
                }
            }
            
            throw new SuperCsvCellProcessorException(
                        String.format("Could not parse '%s' as a locale-language", value), context, this);
     
        }
        
    }

}
