package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Maciek on 31.10.2017.
 */
public class StudentsGenerator {

    public static String[] towns = {"Szczytno"};
    private enum Sex {
        MALE, FEMALE
    }
    int year;
    double middle;
    Random random;
    PESELGenerator PESELgenerator;
    TestResultsGenerator testResultsGenerator;
    ArrayList<City> cities;
    ArrayList<String> streets;
    ArrayList<String> maleNames;
    ArrayList<String> femaleNames;
    ArrayList<String> maleSurnames;
    ArrayList<String> femaleSurnames;


    public StudentsGenerator(int year, double middle) {
        this.year = year;
        this.middle = middle;
        random = new Random();
        testResultsGenerator = new TestResultsGenerator();
        PESELgenerator = new PESELGenerator();
        cities = loadCities(Paths.get("miasta.txt"));
        streets = loadLines(Paths.get("ulice.txt"));
        maleNames = loadLines(Paths.get("imiona_meskie.txt"));
        femaleNames = loadLines(Paths.get("imiona_zenskie.txt"));
        maleSurnames = loadLines(Paths.get("nazwiska_meskie.txt"));
        femaleSurnames = loadLines(Paths.get("nazwiska_zenskie.txt"));
    }

    public Student getNextStudent(){
        String tmpPESEL = PESELgenerator.nextPESEL(year);
        City tmpCity = cities.get(random.nextInt(cities.size()));
        String tmpStreet;
        String tmpHomeNumber;
        if (Arrays.asList(towns).contains(tmpCity.getName())){
            tmpStreet = streets.get(random.nextInt(streets.size()));
            tmpHomeNumber = random.nextInt(60) + "/" + random.nextInt(30);
        }else {
            tmpStreet = tmpCity.getName();
            tmpHomeNumber = String.valueOf(random.nextInt(100));
        }
        String tmpName;
        String tmpSurname;
        switch (getSex(tmpPESEL)){
            case MALE:
                tmpName = maleNames.get(random.nextInt(maleNames.size()));
                tmpSurname = maleSurnames.get(random.nextInt(maleNames.size()));
                break;
            case FEMALE:
                tmpName = femaleNames.get(random.nextInt(maleNames.size()));
                tmpSurname = femaleSurnames.get(random.nextInt(maleNames.size()));
                break;
            default:
                tmpName = "";
                tmpSurname = "";
                break;
        }
        return new Student(tmpPESEL, tmpCity, tmpStreet, tmpHomeNumber,
                new JuniorSchoolResults(middle), tmpName, tmpSurname);
    }

    private Sex getSex(String PESEL){
        return Character.getNumericValue(PESEL.charAt(9))%2==0 ? Sex.FEMALE : Sex.MALE;
    }

    public static ArrayList<City> loadCities(Path file){
        ArrayList<City> cities = new ArrayList<>();
        Charset charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                cities.add(new City(line.split(" ")[0], line.split(" ")[1]));
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return cities;
    }

    public static ArrayList<String> loadLines(Path file){
        ArrayList<String> lines = new ArrayList<>();
        Charset charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return lines;
    }
}
