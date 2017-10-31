package main.java;

/**
 * Created by Maciek on 30.10.2017.
 */

public class Student {

    private String PESEL;
    private City city;
    private String streetName;
    private String homeNumber;
    private String name;
    private String surname;


    private JuniorSchoolResults juniorSchoolResults;

    public Student(String PESEL, City city, String streetName, String homeNumber,
                   JuniorSchoolResults juniorSchoolResults, String name, String surname){
        this.PESEL = PESEL;
        this.city = city;
        this.streetName = streetName;
        this.homeNumber = homeNumber;
        this.juniorSchoolResults = juniorSchoolResults;
        this.name = name;
        this.surname = surname;
        }

    public String toString(){
        return PESEL + "\t" + name + "\t" + surname + "\t" + city.getPostCode() + "\t" + city.getName() + "\t" + streetName + "\t" +
                homeNumber + "\t" + juniorSchoolResults.toString();
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

    public void setCity(City city) {
        this.city = city;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public JuniorSchoolResults getJuniorSchoolResults() {
        return juniorSchoolResults;
    }
}
