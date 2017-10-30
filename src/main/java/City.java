package main.java;

/**
 * Created by Maciek on 30.10.2017.
 */
public class City {

    private String postCode;
    private String name;

    public City(String postCode, String name) {
        this.name = name;
        this.postCode = postCode;
    }

    public String getName() {
        return name;
    }

    public String getPostCode() {
        return postCode;
    }


}
