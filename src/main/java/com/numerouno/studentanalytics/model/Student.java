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
    

    private int age;
    public enum Sex { MALE, FEMALE};
    private Sex gender;
    private String citizenship;
    private CourseInformation courseInformation;
    private Address termResidence;
    private Address permanentHomeResidence;
    public enum Attendance {FULL_TIME, PART_TIME};
    private Attendance attendanceType;
    private Locale countryOfBirth;
    private Locale languageSpokenAtHome;
    private String yearOfArrivalInUSA;
    private Score score;
    private String courseCompletionYear;
    private float earnedGPA;
    private String highestEducation;
    private EquityData equityData;

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

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
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

    public Locale getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(Locale countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public Locale getLanguageSpokenAtHome() {
        return languageSpokenAtHome;
    }

    public void setLanguageSpokenAtHome(Locale languageSpokenAtHome) {
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
    
    public static CellProcessor[] getProcessors() {
        
        final String emailRegex = "[a-z0-9\\._]+@[a-z0-9\\.]+"; // just an example, not very robust!
        StrRegEx.registerMessage(emailRegex, "must be a valid email address");
        
        final CellProcessor[] processors = new CellProcessor[] { 
                
                new NotNull(new ParseInt()), // age
                new NotNull(new ParseSex()), //gender
                new NotNull(new ParseCountry()), //country
                new NotNull(new ParseLanguage()), //language
                new NotNull() //citizenship
        
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
                        String.format("Could not parse '%s' as a locale-language", value), context, this);
     
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
