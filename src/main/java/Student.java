package main.java;

/**
 * Created by Maciek on 30.10.2017.
 */
public class Student {

    private String PESEL;
    private City city;
    private String streetName;
    private String homeNumber;
    private int mathNatureExamResult;
    private int humanisticExamResult;
    private int languageExamResult;

    public Student(String PESEL, City city, String streetName, String homeNumber, int mathNatureExamResult, int humanisticExamResult, int languageExamResult){
        this.PESEL = PESEL;
        this.city = city;
        this.streetName = streetName;
        this.homeNumber = homeNumber;
        this.mathNatureExamResult = mathNatureExamResult;
        this.humanisticExamResult = humanisticExamResult;
        this.languageExamResult = languageExamResult;
    }

    public String getPESEL() {
        return PESEL;
    }

    public City getCity() {
        return city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public int getMathNatureExamResult() {
        return mathNatureExamResult;
    }

    public int getHumanisticExamResult() {
        return humanisticExamResult;
    }

    public int getLanguageExamResult() {
        return languageExamResult;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }
}
