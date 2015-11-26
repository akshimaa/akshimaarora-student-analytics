/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.numerouno.studentanalytics.model;



import java.io.Serializable;
import java.util.Locale;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.supercsv.cellprocessor.ParseDate;
/**
 * 
 * @author Madan Parameswaran
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 611625980304671996L;
    public int studentID;
    public enum Course {ARCHITECTURE,ART,BIOLOGY,BUSINESS,CHEMICAL_ENGINEERING,CHEMISTRY,DESIGN,DRAMA,ELECTRICAL_ENGINEERING,ENGLISH,HISTORY,INFORMATION_SYSTEMS_MANAGEMENT,INFORMATION_TECHNOLOGY,LANGUAGE,MATHEMATHICS,MECHANICAL_ENGINEERING,MUSIC,PHILOSOPHY,PHYSICS,PSYCHOLOGY,PUBLIC_POLICY,PUBLIC_POLICY_MANAGEMENT,STATISTICS}; //awaiting final  
    private Course courseInformation;
    public enum Degree {UNDERGRADUATE, POSTGRADUATE, PHD};
    private Degree degreeLevel;
    public enum Field {ARCHITECTURE,ART,BUSINESS,DESIGN,DRAMA,ENGINEERING,ENGLISH,HISTORY,INFORMATION_SYSTEMS_MANAGEMENT,INFORMATION_TECHNOLOGY,LANGUAGE,MATHEMATHICS,MUSIC,PHILOSOPHY,PSYCHOLOGY,PUBLIC_POLICY,PUBLIC_POLICY_MANAGEMENT,SCIENCE,STATISTICS};
    private Field fieldEducation; 
    private Date dOb;
    public enum Sex {M, F};
    private Sex gender;
    private String citizenship;
    private String termResidence;
    private String permanentHomeResidence;
    private String city;
    private String state;
    private int zipCode;
    private Locale country;
    public enum BasisAdmission {ACADEMICS,AUDITION,EQUITY,PARENTAL,RESIDENT,PORTFOLIO,SPORTS};
    private BasisAdmission basisAdmission;
    public enum AttendanceType {FULLTIME, PARTTIME};
    private AttendanceType attendanceType;
    public enum ModeAttendance {INTERNAL, EXTERNAL, MULTIMODAL};
    private ModeAttendance modeOfAttendance;
    private Locale countryOfBirth;
    private Locale LanguageSpokenAtHome;
    private int yearOfArrivalInUSA;   
    private int enrollmentYear;  
    public enum Type {SAT, GRE, GMAT};
    private Type entranceExam;
    private int verbal;
    private int quantitative;
    private int writing;
    private int disability;
    private int regionalRemote;
    private int womenNontraditionalRole;
    private int lowIncome;
    public enum HighestEducationLevel {HS_DIPLOMA,UNDERGRADUATE,POSTGRADUATE};
    private HighestEducationLevel highestEducationLevel;
    private int courseCompletionYear;
    private double earnedGPA;



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

    public Field getFieldEducation() {
        return fieldEducation;
    }

    public void setFieldEducation(Field fieldEducation) {
        this.fieldEducation = fieldEducation;
    }

    public int getWomenNontraditionalRole() {
        return womenNontraditionalRole;
    }

    public void setWomenNontraditionalRole(int womenNontraditionalRole) {
        this.womenNontraditionalRole = womenNontraditionalRole;
    }

    public Date getdOb() {
        return dOb;
    }

    public void setdOb(Date dOb) {
        this.dOb = dOb;
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

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public Locale getCountry() {
        return country;
    }

    public void setCountry(Locale country) {
        this.country = country;
    }

    public BasisAdmission getBasisAdmission() {
        return basisAdmission;
    }

    public void setBasisAdmission(BasisAdmission basisAdmission) {
        this.basisAdmission = basisAdmission;
    }

    public AttendanceType getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(AttendanceType attendanceType) {
        this.attendanceType = attendanceType;
    }

    public ModeAttendance getModeOfAttendance() {
        return modeOfAttendance;
    }

    public void setModeOfAttendance(ModeAttendance modeOfAttendance) {
        this.modeOfAttendance = modeOfAttendance;
    }

    public Locale getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(Locale countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public int getYearOfArrivalInUSA() {
        return yearOfArrivalInUSA;
    }

    public void setYearOfArrivalInUSA(int yearOfArrivalInUSA) {
        this.yearOfArrivalInUSA = yearOfArrivalInUSA;
    }

    public Locale getLanguageSpokenAtHome() {
        return LanguageSpokenAtHome;
    }

    public void setLanguageSpokenAtHome(Locale LanguageSpokenAtHome) {
        this.LanguageSpokenAtHome = LanguageSpokenAtHome;
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

    public int getVerbal() {
        return verbal;
    }

    public void setVerbal(int verbal) {
        this.verbal = verbal;
    }

    public int getQuantitative() {
        return quantitative;
    }

    public void setQuantitative(int quantitative) {
        this.quantitative = quantitative;
    }

    public int getWriting() {
        return writing;
    }

    public void setWriting(int writing) {
        this.writing = writing;
    }

    public int getDisability() {
        return disability;
    }

    public void setDisability(int disability) {
        this.disability = disability;
    }

    public int getRegionalRemote() {
        return regionalRemote;
    }

    public void setRegionalRemote(int reginalRemote) {
        this.regionalRemote = reginalRemote;
    }

    public int getLowIncome() {
        return lowIncome;
    }

    public void setLowIncome(int lowIncome) {
        this.lowIncome = lowIncome;
    }

    public HighestEducationLevel getHighestEducationLevel() {
        return highestEducationLevel;
    }

    public void setHighestEducationLevel(HighestEducationLevel highestEducationLevel) {
        this.highestEducationLevel = highestEducationLevel;
    }

    public int getCourseCompletionYear() {
        return courseCompletionYear;
    }

    public void setCourseCompletionYear(int courseCompletionYear) {
        this.courseCompletionYear = courseCompletionYear;
    }

    public double getEarnedGPA() {
        return earnedGPA;
    }

    public void setEarnedGPA(double earnedGPA) {
        this.earnedGPA = earnedGPA;
    }
 
    public static CellProcessor[] getProcessors() {
        
     
        final CellProcessor[] processors = new CellProcessor[] { 
                
                new NotNull(new ParseInt()), // student ID
                new NotNull(new ParseCourse()), //course information
                new NotNull(new ParseDegree()), //degree level             
                new NotNull(new ParseField()), // field of study
                new NotNull(new ParseDate ("MM-dd-yy")), // date of birth US Format
                new NotNull(new ParseSex()), //gender
                new NotNull(), //citizenship
                new NotNull(), //term residence
                new NotNull(), //permanant residence
                new NotNull(), //city
                new NotNull(), //state
                new NotNull(new ParseInt()), //zip
                new NotNull(new ParseCountry()), //country
                new NotNull(new ParseBasisAdmission()), //admission basis
                new NotNull(new ParseAttendanceType()), //type attendance
                new NotNull(new ParseMode()), //type of mode attendance
                new NotNull(new ParseCountryOfBirth()), //birth country
                new NotNull(new ParseLanguage()), //language
                new NotNull(new ParseInt()), //year of arrival in USA
                new NotNull(new ParseInt()), // Enrollment year
                new NotNull(new ParseExam()),// exam type
                new NotNull(new ParseInt()), //verbal score
                new NotNull(new ParseInt()), //quantitatvie score
                new NotNull(new ParseInt()), //writing score
                new NotNull(new ParseInt()), //disability
                new NotNull(new ParseInt()), //rural/remote
                new NotNull(new ParseInt()), //women in non-traditional role
                new NotNull(new ParseInt()), //low-income
                new NotNull(new ParseHighestEducationLevel()), //highest level of degree prior to commencement
                new NotNull(new ParseInt()), //year of course completion year
                new NotNull(new ParseDouble())//over gpa score
        };      
        return processors;
}

    private static class ParseCourse extends CellProcessorAdaptor
    {
        public ParseCourse()
        {
            super();
        }
        
        public ParseCourse(CellProcessor next)
        {
            super(next);
        }  
        
        @Override
        public Object execute(Object value, CsvContext context) {
        
        validateInputNotNull(value, context); // throws an Exception if the input is null
            
            for (Course courseInformation : Course.values()) {
                if (courseInformation.name().equals(value.toString())){
                    courseInformation = Course.valueOf(((String) value).toUpperCase());
                        return next.execute(courseInformation, context);
                }
            }   
                throw new SuperCsvCellProcessorException(
                        String.format("Could not parse '%s' as a course information", value), context, this);
        }
        
        }
    private static class ParseDegree extends CellProcessorAdaptor{
        public ParseDegree()
        {
            super();
        }
        
        public ParseDegree(CellProcessor next)
        {
            super(next);
        }  
        
        @Override
        public Object execute(Object value, CsvContext context) {
        
        validateInputNotNull(value, context); // throws an Exception if the input is null
            
            for(Degree degreeLevel : Degree.values()) {
                if (degreeLevel.name().equalsIgnoreCase(value.toString())){
                    degreeLevel = Degree.valueOf(((String) value).toUpperCase());
                        return next.execute(degreeLevel, context);
                }
            }   
                throw new SuperCsvCellProcessorException(
                        String.format("Could not parse '%s' as a course information", value), context, this);
        }
        
        }  
        private static class ParseField extends CellProcessorAdaptor{
        public ParseField()
        {
            super();
        }
        
        public ParseField(CellProcessor next)
        {
            super(next);
        }  
        
        @Override
        public Object execute(Object value, CsvContext context) {
        
        validateInputNotNull(value, context); // throws an Exception if the input is null
            
            for(Field fieldEducation : Field.values()) {
                if (fieldEducation.name().equalsIgnoreCase(value.toString())){
                    fieldEducation = Field.valueOf(((String) value).toUpperCase());
                        return next.execute(fieldEducation, context);
                }
            }   
                throw new SuperCsvCellProcessorException(
                        String.format("Could not parse '%s' as a field education", value), context, this);
        }
        
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
    private static class ParseBasisAdmission extends CellProcessorAdaptor
    {
       
        public ParseBasisAdmission()
        {
            super();
        }
        
        public ParseBasisAdmission(CellProcessor next)
        {
          super(next);   
        }
        @Override
        public Object execute(Object value, CsvContext context) {
        
        validateInputNotNull(value, context);  // throws an Exception if the input is null
                
                for (BasisAdmission basisAdmission : BasisAdmission.values()){
                        if (basisAdmission.name().equalsIgnoreCase(value.toString())){
                                basisAdmission = BasisAdmission.valueOf(((String) value).toUpperCase());
                                return next.execute(basisAdmission, context);
                        }      
                }           
                  throw new SuperCsvCellProcessorException(
                        String.format("Could not parse '%s' as an acceptable Basis for admission", value), context, this);
        }
        }      
    private static class ParseAttendanceType extends CellProcessorAdaptor
    {
       
        public ParseAttendanceType()
        {
            super();
        }
        
        public ParseAttendanceType(CellProcessor next)
        {
          super(next);   
        }
        @Override
        public Object execute(Object value, CsvContext context) {
        
        validateInputNotNull(value, context);  // throws an Exception if the input is null
           

                for (AttendanceType attendanceType : AttendanceType.values()){
                        if (attendanceType.name().equalsIgnoreCase(value.toString())){
                                attendanceType = AttendanceType.valueOf(((String) value).toUpperCase());
                                return next.execute(attendanceType, context);
                        }      
                }           
                  throw new SuperCsvCellProcessorException(
                        String.format("Could not parse '%s' for attendance Type", value), context, this);
        }
        }    
    private static class ParseMode extends CellProcessorAdaptor
    {
       
        public ParseMode()
        {
            super();
        }
                
        public ParseMode(CellProcessor next)
        {
          super(next);   
        }
        @Override
        public Object execute(Object value, CsvContext context) {
        
        validateInputNotNull(value, context);  // throws an Exception if the input is null
           

                for (ModeAttendance modeOfAttendance : ModeAttendance.values()){
                        if (modeOfAttendance.name().equalsIgnoreCase(value.toString())){
                                modeOfAttendance = ModeAttendance.valueOf(((String) value).toUpperCase());
                                return next.execute(modeOfAttendance, context);
                        }      
                }           
                  throw new SuperCsvCellProcessorException(
                        String.format("Could not parse '%s' as an acceptable attendance mode", value), context, this);
        }
        } 
     private static class ParseCountryOfBirth extends CellProcessorAdaptor
    {

        public ParseCountryOfBirth()
        {
            super();
        }
        
        public ParseCountryOfBirth(CellProcessor next)
        {
            super(next);
        }
        @Override
        public Object execute(Object value, CsvContext context) {
            validateInputNotNull(value, context);
            Locale.setDefault(Locale.US);
            for(Locale countryOfBirth : Locale.getAvailableLocales())
            {
                if(countryOfBirth.getDisplayCountry().equals(value.toString()))
                {
                    return next.execute(countryOfBirth, context);
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
            for(Locale languageSpokenAtHome : Locale.getAvailableLocales())
            {
                
                if(languageSpokenAtHome.getDisplayLanguage().equals(value.toString().trim()))
                {
                    return next.execute(languageSpokenAtHome, context);
                }
            }
            
            throw new SuperCsvCellProcessorException(
                        String.format("Could not parse '%s' as a locale-language", value), context, this);
     
        }
        
    }
       private static class ParseExam extends CellProcessorAdaptor
    {
       
        public ParseExam()
        {
            super();
        }
                
        public ParseExam(CellProcessor next)
        {
          super(next);   
        }
        @Override
        public Object execute(Object value, CsvContext context) {
        
        validateInputNotNull(value, context);  // throws an Exception if the input is null
       

                for (Type entranceExam : Type.values()){
                        if (entranceExam.name().equalsIgnoreCase(value.toString())){
                                entranceExam = Type.valueOf(((String) value).toUpperCase());
                                return next.execute(entranceExam, context);
                        }      
                }           
                  throw new SuperCsvCellProcessorException(
                        String.format("Could not parse '%s' as an acceptable exam", value), context, this);
        }
        } 
      
       private static class ParseHighestEducationLevel extends CellProcessorAdaptor
    {
       
        public ParseHighestEducationLevel()
        {
            super();
        }
                
        public ParseHighestEducationLevel(CellProcessor next)
        {
          super(next);   
        }
        @Override
        public Object execute(Object value, CsvContext context) {
        
        validateInputNotNull(value, context);  // throws an Exception if the input is null
           

                for (HighestEducationLevel highestEducationLevel : HighestEducationLevel.values()){
                        if (highestEducationLevel.name().equalsIgnoreCase(value.toString())){
                                highestEducationLevel = HighestEducationLevel.valueOf(((String) value).toUpperCase());
                                return next.execute(highestEducationLevel, context);
                        }      
                }           
                  throw new SuperCsvCellProcessorException(
                        String.format("Could not parse '%s' as an acceptable level of education", value), context, this);
        }
        } 
        
    @SuppressWarnings("UnnecessaryBoxing")
    public <T> T getParameter(String parameter)
    {
        switch(parameter)
        {
            case "attendanceType":
                return (T)this.getAttendanceType();
            case "languageSpokenAtHome":
                return (T)this.getLanguageSpokenAtHome().getLanguage();
            case "courseInformation":
                return (T)this.getCourseInformation();
            case "degreeLevel":
                return (T)this.getDegreeLevel();
            case "basisAdmission":
                return (T)this.getBasisAdmission();
            case "modeOfAttendance":
                return (T)this.getModeOfAttendance();
            case "entranceExam":
                return (T)this.getEntranceExam();
            case "verbal":
                return (T)Integer.valueOf(this.getVerbal());
            case "quantitative":
                return (T)Integer.valueOf(this.getQuantitative());
            case "writing":
                return (T)Integer.valueOf(this.getWriting());
            case "disability":
                return (T)Integer.valueOf(this.getDisability());
            case "regionalRemote":
                return(T)Integer.valueOf(this.getRegionalRemote());
            case "womenNontraditionalRole":
                return (T)Integer.valueOf(this.getWomenNontraditionalRole());
            case "lowIncome":
                return (T)Integer.valueOf(this.getLowIncome());
            case "higestEducationLevel":
                return (T)this.getHighestEducationLevel();
            case "courseCompletionYear":
                return (T) Integer.valueOf(this.getCourseCompletionYear());
            case "gpa":
                return (T)Double.valueOf(this.getEarnedGPA());
            case "gender":
                return (T)this.getGender();
            case "country":
                return (T)this.getCountry().getDisplayCountry();

                
            default:
                return null;
        }
    }
    
    
    public String getLegend(String parameter)
    {
        switch(parameter)
        {
            case "attendanceType":
                return "Attendance Type";
            case "languageSpokenAtHome":
                return "Language Spoken at Home";
            case "courseInformation":
                return "Course Information";
            case "degreeLevel":
                return "Degree Level";
            case "basisAdmission":
                return "Basis of Admission";
            case "modeOfAttendance":
                return "Mode of Attendance";
            case "entranceExam":
                return "Entrance exam";
            case "verbal":
                return "Verbal";
            case "quantitative":
                return "Quantitative Score";
            case "writing":
                return "Writing Score";
            case "disability":
                return "Disability";
            case "regionalRemote":
                return "Regional Remote";
            case "womenNontraditionalRole":
                return "Women in non-traditional role";
            case "lowIncome":
                return "Low Income";
            case "higestEducationLevel":
                return "Highest Education Level";
            case "courseCompletionYear":
                return "Course Completion Year";
            case "gpa":
                return "Grade Point Aggregate (GPA)";
            case "gender":
                return "Gender";
            case "country":
                return "Country";

                
            default:
                return null;
        }
    }
}
