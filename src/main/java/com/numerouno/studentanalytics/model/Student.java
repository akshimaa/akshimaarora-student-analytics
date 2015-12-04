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
 * Student contains details about the student like course, degree, field, gender
 * etc.
 *
 * @author Madan Parameswaran
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 611625980304671996L;
    public int studentID;

    /**
     * Contains information regarding courses.
     */
    public enum Course {

        ARCHITECTURE, ART, BIOLOGY, BUSINESS, CHEMICAL_ENGINEERING, CHEMISTRY, DESIGN, DRAMA, ELECTRICAL_ENGINEERING, ENGLISH, HISTORY, INFORMATION_SYSTEMS_MANAGEMENT, INFORMATION_TECHNOLOGY, LANGUAGE, MATHEMATHICS, MECHANICAL_ENGINEERING, MUSIC, PHILOSOPHY, PHYSICS, PSYCHOLOGY, PUBLIC_POLICY, PUBLIC_POLICY_MANAGEMENT, STATISTICS
    }; //awaiting final  
    private Course courseInformation;

    /**
     * Contains information regarding degree level.
     */
    public enum Degree {

        UNDERGRADUATE, POSTGRADUATE, PHD
    };
    private Degree degreeLevel;

    /**
     * Contains information regarding the field of study.
     */
    public enum Field {

        ARCHITECTURE, ART, BUSINESS, DESIGN, DRAMA, ENGINEERING, ENGLISH, HISTORY, INFORMATION_SYSTEMS_MANAGEMENT, INFORMATION_TECHNOLOGY, LANGUAGE, MATHEMATHICS, MUSIC, PHILOSOPHY, PSYCHOLOGY, PUBLIC_POLICY, PUBLIC_POLICY_MANAGEMENT, SCIENCE, STATISTICS
    };
    private Field fieldEducation;
    private Date dOb;

    /**
     * Contains information regarding the gender of the student.
     */
    public enum Sex {

        M, F
    };
    private Sex gender;
    private String citizenship;
    private String termResidence;
    private String permanentHomeResidence;
    private String city;
    private String state;
    private int zipCode;
    private Locale country;

    /**
     * Contains information regarding the student's basis of admission.
     */
    public enum BasisAdmission {

        ACADEMICS, AUDITION, EQUITY, PARENTAL, RESIDENT, PORTFOLIO, SPORTS
    };
    private BasisAdmission basisAdmission;

    /**
     * Contains information regarding the full-time status of the student.
     */
    public enum AttendanceType {

        FULLTIME, PARTTIME
    };
    private AttendanceType attendanceType;

    /**
     * Contains information regarding the student's mode of attendance.
     */
    public enum ModeAttendance {

        INTERNAL, EXTERNAL, MULTIMODAL
    };
    private ModeAttendance modeOfAttendance;
    private Locale countryOfBirth;
    private Locale LanguageSpokenAtHome;
    private int yearOfArrivalInUSA;
    private int enrollmentYear;

    /**
     * Contains information regarding the type of entrance exam taken by the
     * student.
     */
    public enum Type {

        SAT, GRE, GMAT
    };
    private Type entranceExam;
    private int verbal;
    private int quantitative;
    private int writing;
    private int disability;
    private int regionalRemote;
    private int womenNontraditionalRole;
    private int lowIncome;

    /**
     * Contains information regarding the highest education level achieved prior
     * to admission.
     */
    public enum HighestEducationLevel {

        HS_DIPLOMA, UNDERGRADUATE, POSTGRADUATE
    };
    private HighestEducationLevel highestEducationLevel;
    private int courseCompletionYear;
    private double earnedGPA;

    /**
     * getStudentID method gets the details about student's ID
     *
     * @return returns the student Id.
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Student ID sets the student ID
     *
     * @param studentID sets the value of student ID in the studentID of the
     * current class.
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * getCourseInformation method gets the details about course
     *
     * @return returns the course information of the student
     */
    public Course getCourseInformation() {
        return courseInformation;
    }

    /**
     * sets the course information of the student
     *
     * @param courseInformation returns details about the course taken by the
     * student.
     */
    public void setCourseInformation(Course courseInformation) {
        this.courseInformation = courseInformation;
    }

    /**
     * getDegreeLevel method gets the information about student degree level.
     *
     * @return returns the degree level of the student
     */
    public Degree getDegreeLevel() {
        return degreeLevel;
    }

    /**
     * setDegreeLevel method sets the degree information of the student
     *
     * @param degreeLevel sets the details about degree level of the student
     */
    public void setDegreeLevel(Degree degreeLevel) {
        this.degreeLevel = degreeLevel;
    }

    /**
     * getFieldEducation gets the field of education of the student
     *
     * @return returns the education field of the student
     */
    public Field getFieldEducation() {
        return fieldEducation;
    }

    /**
     * setFieldEducation method sets the education field of the student
     *
     * @param fieldEducation sets the field of education of the student.
     */
    public void setFieldEducation(Field fieldEducation) {
        this.fieldEducation = fieldEducation;
    }

    /**
     * getWomenNonTraditionalRole method gives the details about the women in
     * different departments like science, engineering.
     *
     * @return returns the data about Women in Non traditional role.
     */
    public int getWomenNontraditionalRole() {
        return womenNontraditionalRole;
    }

    /**
     * sets the data about women students in non traditional role
     *
     * @param womenNontraditionalRole sets the number of women in non
     * traditional role.
     */
    public void setWomenNontraditionalRole(int womenNontraditionalRole) {
        this.womenNontraditionalRole = womenNontraditionalRole;
    }

    /**
     * getdOb method gets the date of birth of the student
     *
     * @return returns the date of birth of the student
     */
    public Date getdOb() {
        return dOb;
    }

    /**
     * setdOb method sets the date of birth of the student
     *
     * @param dOb sets the date of birth of the student
     */
    public void setdOb(Date dOb) {
        this.dOb = dOb;
    }

    /**
     * getGender gets the gender of the student
     *
     * @return returns the gender of the student.
     */
    public Sex getGender() {
        return gender;
    }

    /**
     * sets the gender of the student
     *
     * @param gender sets the student of the student
     */
    public void setGender(Sex gender) {
        this.gender = gender;
    }

    /**
     * sets the citizenship of the student
     *
     * @param citizenship sets the citizenship of the student
     */
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    /**
     * getCitizenship method gets the citizenship status of the student
     *
     * @return returns the citizenship status of the student.
     */
    public String getCitizenship() {
        return citizenship;
    }

    /**
     * getTermResidence method gets the term residence address of the student.
     *
     * @return returns the term residence address of the students.
     */
    public String getTermResidence() {
        return termResidence;
    }

    /**
     * sets the term residence address of the student
     *
     * @param termResidence sets the residence address of the student
     */
    public void setTermResidence(String termResidence) {
        this.termResidence = termResidence;
    }

    /**
     * gets the permanent home residence of the student
     *
     * @return returns the home residence of the student
     */
    public String getPermanentHomeResidence() {
        return permanentHomeResidence;
    }

    /**
     * permanent home residence sets the home residence of the student
     *
     * @param permanentHomeResidence sets the home residence of the student
     */
    public void setPermanentHomeResidence(String permanentHomeResidence) {
        this.permanentHomeResidence = permanentHomeResidence;
    }

    /**
     * getCity method returns the city of the student
     *
     * @return returns the city of student
     */
    public String getCity() {
        return city;
    }

    /**
     * setCity method sets the city of the student.
     *
     * @param city sets the city of the student.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * getState method gets the state of the student
     *
     * @return returns the state of the student
     */
    public String getState() {
        return state;
    }

    /**
     * setState method sets the state of the student.
     *
     * @param state sets the state of the student
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * getZipCode gets the zip code of the residence of student.
     *
     * @return returns the zip code of the residence of the state
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * setZipCode sets the zip code of the student
     *
     * @param zipCode sets the zip code of student.
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * getCountry gets the country of the student.
     *
     * @return returns the country of the student.
     */
    public Locale getCountry() {
        return country;
    }

    /**
     * setCountry method sets the country of the student
     *
     * @param country sets the country of the student
     */
    public void setCountry(Locale country) {
        this.country = country;
    }

    /**
     * gets the basis of admission of the student
     *
     * @return returns the basis of the student admission
     */
    public BasisAdmission getBasisAdmission() {
        return basisAdmission;
    }

    /**
     * sets the basis of admission of the student
     *
     * @param basisAdmission sets the basis of student admission
     */
    public void setBasisAdmission(BasisAdmission basisAdmission) {
        this.basisAdmission = basisAdmission;
    }

    /**
     * gets the attendance type of the student
     *
     * @return returns the attendance type of the student
     */
    public AttendanceType getAttendanceType() {
        return attendanceType;
    }

    /**
     * sets the attendance type of the student
     *
     * @param attendanceType sets the attendance type of the student
     */
    public void setAttendanceType(AttendanceType attendanceType) {
        this.attendanceType = attendanceType;
    }

    /**
     * gets the mode of attendance of the student
     *
     * @return returns the mode of attendance of the student
     */
    public ModeAttendance getModeOfAttendance() {
        return modeOfAttendance;
    }

    /**
     * sets the mode of attendance of the student
     *
     * @param modeOfAttendance sets the mode of attendance of the student
     */
    public void setModeOfAttendance(ModeAttendance modeOfAttendance) {
        this.modeOfAttendance = modeOfAttendance;
    }

    /**
     * gets the country of Birth of the student
     *
     * @return returns the country of Birth of the student
     */
    public Locale getCountryOfBirth() {
        return countryOfBirth;
    }

    /**
     * sets the country of birth of the student
     *
     * @param countryOfBirth sets the student's country of birth
     */
    public void setCountryOfBirth(Locale countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    /**
     * gets the year of Arrival in USA
     *
     * @return returns the year of arrival in USA
     */
    public int getYearOfArrivalInUSA() {
        return yearOfArrivalInUSA;
    }

    /**
     * sets the year of arrival in USA of the student
     *
     * @param yearOfArrivalInUSA sets the year of arrival in USA
     */
    public void setYearOfArrivalInUSA(int yearOfArrivalInUSA) {
        this.yearOfArrivalInUSA = yearOfArrivalInUSA;
    }

    /**
     * this method gets the language spoken at home of the student
     *
     * @return returns the language spoken in the house of the student
     */
    public Locale getLanguageSpokenAtHome() {
        return LanguageSpokenAtHome;
    }

    /**
     * sets the language that is spoken at home
     *
     * @param LanguageSpokenAtHome sets the language that is spoken in the home
     */
    public void setLanguageSpokenAtHome(Locale LanguageSpokenAtHome) {
        this.LanguageSpokenAtHome = LanguageSpokenAtHome;
    }

    /**
     * gets the enrollment year of the student
     *
     * @return returns the enrollment year of the student
     */
    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    /**
     * sets the enrollment year of the student
     *
     * @param enrollmentYear sets the enrollment year of the student
     */
    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    /**
     * gets the entrance exam of the student
     *
     * @return returns the entrance exam of the student
     */
    public Type getEntranceExam() {
        return entranceExam;
    }

    /**
     * sets the entrance exam of the student
     *
     * @param entranceExam sets the entrance exam of the student
     */
    public void setEntranceExam(Type entranceExam) {
        this.entranceExam = entranceExam;
    }

    /**
     * gets the verbal score of the student
     *
     * @return returns the verbal score of the student
     */
    public int getVerbal() {
        return verbal;
    }

    /**
     * sets the verbal score of the student
     *
     * @param verbal sets the verbal score of the student
     */
    public void setVerbal(int verbal) {
        this.verbal = verbal;
    }

    /**
     * gets the quantitative score of the student
     *
     * @return returns the quantitative score of the student
     */
    public int getQuantitative() {
        return quantitative;
    }

    /**
     * sets the quantitative score of the student
     *
     * @param quantitative sets the quantitative score of the student
     */
    public void setQuantitative(int quantitative) {
        this.quantitative = quantitative;
    }

    /**
     * gets the writing score of the student
     *
     * @return returns the writing score of the student
     */
    public int getWriting() {
        return writing;
    }

    /**
     * sets the writing score of the student
     *
     * @param writing sets the writing score of the student
     */
    public void setWriting(int writing) {
        this.writing = writing;
    }

    /**
     * gets the information if the student has any disability or not
     *
     * @return returns the information if the student has any disability
     */
    public int getDisability() {
        return disability;
    }

    /**
     * sets the information if any student has any disability or not
     *
     * @param disability sets the information if any student has any disability
     * or not
     */
    public void setDisability(int disability) {
        this.disability = disability;
    }

    /**
     * gets the regional remote of the student
     *
     * @return returns the regional remote of the student
     */
    public int getRegionalRemote() {
        return regionalRemote;
    }

    /**
     * sets the regional remote of the student
     *
     * @param reginalRemote sets the regional remote of the student
     */
    public void setRegionalRemote(int reginalRemote) {
        this.regionalRemote = reginalRemote;
    }

    /**
     * gets the information of the student if he has low income
     *
     * @return returns the information if the student has low income
     */
    public int getLowIncome() {
        return lowIncome;
    }

    /**
     * lowIncome sets if the student has low income
     *
     * @param lowIncome sets the income of the student
     */
    public void setLowIncome(int lowIncome) {
        this.lowIncome = lowIncome;
    }

    /**
     * gets the highest education level of the student
     *
     * @return returns the highest educational level of the student
     */
    public HighestEducationLevel getHighestEducationLevel() {
        return highestEducationLevel;
    }

    /**
     * sets the highest educational level of the student
     *
     * @param highestEducationLevel sets the highest educational level of the
     * student
     */
    public void setHighestEducationLevel(HighestEducationLevel highestEducationLevel) {
        this.highestEducationLevel = highestEducationLevel;
    }

    /**
     * gets the year of course completion of the student
     *
     * @return returns the completion year of the student
     */
    public int getCourseCompletionYear() {
        return courseCompletionYear;
    }

    /**
     * sets the course completion year of the student
     *
     * @param courseCompletionYear sets the completion year of the student
     */
    public void setCourseCompletionYear(int courseCompletionYear) {
        this.courseCompletionYear = courseCompletionYear;
    }

    /**
     * gets the earned gpa of the student
     *
     * @return returns the earned gpa of the student
     */
    public double getEarnedGPA() {
        return earnedGPA;
    }

    /**
     * sets the earned gpa of the student
     *
     * @param earnedGPA sets the earned gpa of the student
     */
    public void setEarnedGPA(double earnedGPA) {
        this.earnedGPA = earnedGPA;
    }

    /**
     * getProcessors method is used to process the information of the student
     *
     * @return returns the processors of the information of the student
     */
    public static CellProcessor[] getProcessors() {

        final CellProcessor[] processors = new CellProcessor[]{
            new NotNull(new ParseInt()), // student ID
            new NotNull(new ParseCourse()), //course information
            new NotNull(new ParseDegree()), //degree level             
            new NotNull(new ParseField()), // field of study
            new NotNull(new ParseDate("MM-dd-yy")), // date of birth US Format
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

    /**
     * This method is used to process the course information
     */
    private static class ParseCourse extends CellProcessorAdaptor {

        public ParseCourse() {
            super();
        }

        /**
         * Parse Course is the parameterized constructor for the class
         *
         * @param next is the parameter for obtaining the data from the next
         * field
         */
        public ParseCourse(CellProcessor next) {
            super(next);
        }

        /**
         * Execute method parses the data of the student after processing
         *
         * @param value values of the course are parsed
         * @param context describes the context in which the values are parsed
         * @return returns the object with the parsed data
         */
        @Override
        public Object execute(Object value, CsvContext context) {

            validateInputNotNull(value, context); // throws an Exception if the input is null

            for (Course courseInformation : Course.values()) {
                if (courseInformation.name().equals(value.toString())) {
                    courseInformation = Course.valueOf(((String) value).toUpperCase());
                    return next.execute(courseInformation, context);
                }
            }
            throw new SuperCsvCellProcessorException(
                    String.format("Could not parse '%s' as a course information", value), context, this);
        }

    }

    /**
     * This method processes the degree of the student
     */
    private static class ParseDegree extends CellProcessorAdaptor {

        public ParseDegree() {
            super();
        }

        /**
         * Parameterized constructor
         *
         * @param next is the parameter for obtaining the data from the next
         * field
         */
        public ParseDegree(CellProcessor next) {
            super(next);
        }

        /**
         * This method parses the degree level of the student after processing
         * it using processors.
         *
         * @param value parses the value of the degree level of the student
         * @param context sets the context where the values are parsed
         * @return returns the object with parsed degree value
         */
        @Override
        public Object execute(Object value, CsvContext context) {

            validateInputNotNull(value, context); // throws an Exception if the input is null

            for (Degree degreeLevel : Degree.values()) {
                if (degreeLevel.name().equalsIgnoreCase(value.toString())) {
                    degreeLevel = Degree.valueOf(((String) value).toUpperCase());
                    return next.execute(degreeLevel, context);
                }
            }
            throw new SuperCsvCellProcessorException(
                    String.format("Could not parse '%s' as a course information", value), context, this);
        }

    }

    /**
     * This method parses the education field of the student
     */
    private static class ParseField extends CellProcessorAdaptor {

        public ParseField() {
            super();
        }

        public ParseField(CellProcessor next) {
            super(next);
        }

        /**
         * This method parses the data of the education field of the student
         *
         * @param value value of the education field that is parsed
         * @param context context stores the parsed value of the education field
         * @return returns the object with the parsed values of the education
         * field
         */
        @Override
        public Object execute(Object value, CsvContext context) {

            validateInputNotNull(value, context); // throws an Exception if the input is null

            for (Field fieldEducation : Field.values()) {
                if (fieldEducation.name().equalsIgnoreCase(value.toString())) {
                    fieldEducation = Field.valueOf(((String) value).toUpperCase());
                    return next.execute(fieldEducation, context);
                }
            }
            throw new SuperCsvCellProcessorException(
                    String.format("Could not parse '%s' as a field education", value), context, this);
        }

    }

    /**
     * Parses the gender of the student
     */
    private static class ParseSex extends CellProcessorAdaptor {

        public ParseSex() {
            super();
        }

        public ParseSex(CellProcessor next) {
            super(next);
        }

        /**
         * Calls the parsed data to store in the context
         *
         * @param value contains the value of parsed data
         * @param context context is used to store the value of parsed data
         * @return returns the object with the value and context
         */
        @Override
        public Object execute(Object value, CsvContext context) {

            validateInputNotNull(value, context);  // throws an Exception if the input is null

            for (Sex gender : Sex.values()) {
                if (gender.name().equalsIgnoreCase(value.toString())) {
                    gender = Sex.valueOf(((String) value).toUpperCase());
                    return next.execute(gender, context);
                }
            }
            throw new SuperCsvCellProcessorException(
                    String.format("Could not parse '%s' as a gender", value), context, this);
        }
    }

    /**
     * Parses the country of the student
     */
    private static class ParseCountry extends CellProcessorAdaptor {

        public ParseCountry() {
            super();
        }

        public ParseCountry(CellProcessor next) {
            super(next);
        }

        /**
         * Parsed data country of the student is stored
         *
         * @param value value contains the parsed information of the country of
         * the student
         * @param context context stores the country of the student
         * @return returns the object with the stored values of the country of
         * birth
         */
        @Override
        public Object execute(Object value, CsvContext context) {
            validateInputNotNull(value, context);
            Locale.setDefault(Locale.US);
            for (Locale country : Locale.getAvailableLocales()) {
                if (country.getDisplayCountry().equals(value.toString())) {
                    return next.execute(country, context);
                }
            }
            throw new SuperCsvCellProcessorException(
                    String.format("Could not parse '%s' as a locale-country", value), context, this);
        }
    }

    /**
     * Parses the basis of admission of the student
     */
    private static class ParseBasisAdmission extends CellProcessorAdaptor {

        public ParseBasisAdmission() {
            super();
        }

        public ParseBasisAdmission(CellProcessor next) {
            super(next);
        }

        /**
         * Parses the value of basis of admission of the student
         *
         * @param value value of the parsed basis of the admission of the
         * student is stored
         * @param context contains the stored value of the parsed data of the
         * basis of admission of the student
         * @return returns the object value of the basis of admission
         */
        @Override
        public Object execute(Object value, CsvContext context) {

            validateInputNotNull(value, context);  // throws an Exception if the input is null

            for (BasisAdmission basisAdmission : BasisAdmission.values()) {
                if (basisAdmission.name().equalsIgnoreCase(value.toString())) {
                    basisAdmission = BasisAdmission.valueOf(((String) value).toUpperCase());
                    return next.execute(basisAdmission, context);
                }
            }
            throw new SuperCsvCellProcessorException(
                    String.format("Could not parse '%s' as an acceptable Basis for admission", value), context, this);
        }
    }

    /**
     * Type of attendance is parsed
     */
    private static class ParseAttendanceType extends CellProcessorAdaptor {

        public ParseAttendanceType() {
            super();
        }

        public ParseAttendanceType(CellProcessor next) {
            super(next);
        }

        /**
         * Parsed data of type of attendance of the student is stored
         *
         * @param value value of the parsed data of the type of attendance of
         * the student
         * @param context context of the type of the attendance of the student
         * @return returns the object with parsed data of type of attendance of
         * the student
         */
        @Override
        public Object execute(Object value, CsvContext context) {

            validateInputNotNull(value, context);  // throws an Exception if the input is null

            for (AttendanceType attendanceType : AttendanceType.values()) {
                if (attendanceType.name().equalsIgnoreCase(value.toString())) {
                    attendanceType = AttendanceType.valueOf(((String) value).toUpperCase());
                    return next.execute(attendanceType, context);
                }
            }
            throw new SuperCsvCellProcessorException(
                    String.format("Could not parse '%s' for attendance Type", value), context, this);
        }
    }

    /**
     * Parsed the mode of the data
     */
    private static class ParseMode extends CellProcessorAdaptor {

        public ParseMode() {
            super();
        }

        public ParseMode(CellProcessor next) {
            super(next);
        }

        /**
         * Parsed the data of mode of attendance of the student
         *
         * @param value contains the parsed value of the mode of attendance
         * @param context context stores the parsed value of the mode of
         * attendance
         * @return returns the object which contains the parsed data with mode
         * of the attendance
         */
        @Override
        public Object execute(Object value, CsvContext context) {

            validateInputNotNull(value, context);  // throws an Exception if the input is null

            for (ModeAttendance modeOfAttendance : ModeAttendance.values()) {
                if (modeOfAttendance.name().equalsIgnoreCase(value.toString())) {
                    modeOfAttendance = ModeAttendance.valueOf(((String) value).toUpperCase());
                    return next.execute(modeOfAttendance, context);
                }
            }
            throw new SuperCsvCellProcessorException(
                    String.format("Could not parse '%s' as an acceptable attendance mode", value), context, this);
        }
    }

    /**
     * Parses the country of birth of the student
     */
    private static class ParseCountryOfBirth extends CellProcessorAdaptor {

        public ParseCountryOfBirth() {
            super();
        }

        public ParseCountryOfBirth(CellProcessor next) {
            super(next);
        }

        /**
         * Parses the values of country of birth of the student
         *
         * @param value contains the parsed values of the country of birth of
         * the student
         * @param context stores the value of the country of birth of the
         * student
         * @return returns the object consisting of the parsed information about
         * country of birth of the student
         */
        @Override
        public Object execute(Object value, CsvContext context) {
            validateInputNotNull(value, context);
            Locale.setDefault(Locale.US);
            for (Locale countryOfBirth : Locale.getAvailableLocales()) {
                if (countryOfBirth.getDisplayCountry().equals(value.toString())) {
                    return next.execute(countryOfBirth, context);
                }
            }
            throw new SuperCsvCellProcessorException(
                    String.format("Could not parse '%s' as a locale-country", value), context, this);
        }
    }

    /**
     * Parses the language spoken at the home of the student
     */
    private static class ParseLanguage extends CellProcessorAdaptor {

        public ParseLanguage() {
            super();
        }

        public ParseLanguage(CellProcessor next) {
            super(next);
        }

        /**
         * Parses the data of the languages spoken at the home of the student
         *
         * @param value contains the data of the languages spoken at the home of
         * the student is parsed
         * @param context stores the parsed data of the student
         * @return returns the value of the object containing the parsed data
         */
        @Override
        public Object execute(Object value, CsvContext context) {
            validateInputNotNull(value, context);
            Locale.setDefault(Locale.US);
            for (Locale languageSpokenAtHome : Locale.getAvailableLocales()) {

                if (languageSpokenAtHome.getDisplayLanguage().equals(value.toString().trim())) {
                    return next.execute(languageSpokenAtHome, context);
                }
            }

            throw new SuperCsvCellProcessorException(
                    String.format("Could not parse '%s' as a locale-language", value), context, this);

        }

    }

    /**
     * Parses the type of entrance exam of the student
     */
    private static class ParseExam extends CellProcessorAdaptor {

        public ParseExam() {
            super();
        }

        public ParseExam(CellProcessor next) {
            super(next);
        }

        /**
         * Parses the the type of entrance exam of the student
         *
         * @param value contains the parsed data of the entrance exam of the
         * student
         * @param context store parsed data based on the type of the entrance
         * exam of the student
         * @return returns the the value of the entrance exam of the student
         */
        @Override
        public Object execute(Object value, CsvContext context) {

            validateInputNotNull(value, context);  // throws an Exception if the input is null

            for (Type entranceExam : Type.values()) {
                if (entranceExam.name().equalsIgnoreCase(value.toString())) {
                    entranceExam = Type.valueOf(((String) value).toUpperCase());
                    return next.execute(entranceExam, context);
                }
            }
            throw new SuperCsvCellProcessorException(
                    String.format("Could not parse '%s' as an acceptable exam", value), context, this);
        }
    }

    /**
     * Parses the highest education level of the student
     */
    private static class ParseHighestEducationLevel extends CellProcessorAdaptor {

        public ParseHighestEducationLevel() {
            super();
        }

        public ParseHighestEducationLevel(CellProcessor next) {
            super(next);
        }

        /**
         * Parses the highest education level of the student
         *
         * @param value contains the parsed data of the highest education level
         * of the student
         * @param context store parsed data based on the highest education level
         * of the student
         * @return returns the the value of the highest education level of the
         * student
         */
        @Override
        public Object execute(Object value, CsvContext context) {

            validateInputNotNull(value, context);  // throws an Exception if the input is null

            for (HighestEducationLevel highestEducationLevel : HighestEducationLevel.values()) {
                if (highestEducationLevel.name().equalsIgnoreCase(value.toString())) {
                    highestEducationLevel = HighestEducationLevel.valueOf(((String) value).toUpperCase());
                    return next.execute(highestEducationLevel, context);
                }
            }
            throw new SuperCsvCellProcessorException(
                    String.format("Could not parse '%s' as an acceptable level of education", value), context, this);
        }
    }

    /**
     * Gets the details of the student
     *
     * @param <T> describes the type of the parameter chosen by the student
     * @param parameter describes the detail of the student being selected
     * @return returns the required detail of the object
     */
    @SuppressWarnings("UnnecessaryBoxing")
    public <T> T getParameter(String parameter) {
        switch (parameter) {
            case "attendanceType":
                return (T) this.getAttendanceType();
            case "languageSpokenAtHome":
                return (T) this.getLanguageSpokenAtHome().getLanguage();
            case "courseInformation":
                return (T) this.getCourseInformation();
            case "degreeLevel":
                return (T) this.getDegreeLevel();
            case "basisAdmission":
                return (T) this.getBasisAdmission();
            case "modeOfAttendance":
                return (T) this.getModeOfAttendance();
            case "entranceExam":
                return (T) this.getEntranceExam();
            case "verbal":
                return (T) Integer.valueOf(this.getVerbal());
            case "quantitative":
                return (T) Integer.valueOf(this.getQuantitative());
            case "writing":
                return (T) Integer.valueOf(this.getWriting());
            case "disability":
                return (T) Integer.valueOf(this.getDisability());
            case "regionalRemote":
                return (T) Integer.valueOf(this.getRegionalRemote());
            case "womenNontraditionalRole":
                return (T) Integer.valueOf(this.getWomenNontraditionalRole());
            case "lowIncome":
                return (T) Integer.valueOf(this.getLowIncome());
            case "higestEducationLevel":
                return (T) this.getHighestEducationLevel();
            case "courseCompletionYear":
                return (T) Integer.valueOf(this.getCourseCompletionYear());
            case "gpa":
                return (T) Double.valueOf(this.getEarnedGPA());
            case "gender":
                return (T) this.getGender();
            case "country":
                return (T) this.getCountry().getDisplayCountry();

            default:
                return null;
        }
    }

    /**
     * Gets the index of the details to be chosen
     *
     * @param parameter the parameter to be chosen by the student
     * @return returns the information about the chosen parameter
     */
    public static String getLegend(String parameter) {
        switch (parameter) {
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
            case "highestEducationLevel":
                return "Highest Education Level";
            case "courseCompletionYear":
                return "Course Completion Year";
            case "gpa":
                return "Grade Point Aggregate (GPA)";
            case "gender":
                return "Gender";
            case "country":
                return "Country";
            case "degreeLevel_gender":
                return "Degree by Gender";
            case "modeOfAttendance_attendanceType":
                return "Mode of Attendance by Attendance Type";
            case "disability_regionalRemote_womenNonTraditionalRole_lowIncome":
                return "Equity Data";

            default:
                return null;
        }
    }

}
