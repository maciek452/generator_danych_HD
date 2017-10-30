package main.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {


        Random random = new Random();
        TestResultsGenerator testResultsGenerator = new TestResultsGenerator();
        PESELGenerator PESELgenerator = new PESELGenerator();
        ArrayList<City> cities = loadCities(Paths.get("miasta.txt"));
        ArrayList<String> streets = loadLines(Paths.get("ulice.txt"));
        ArrayList<String> maleNames = loadLines(Paths.get("imiona_meskie.txt"));
        ArrayList<String> femaleNames = loadLines(Paths.get("imiona_zenskie.txt"));
        ArrayList<String> maleSurnames = loadLines(Paths.get("nazwiska_meskie.txt"));
        ArrayList<String> femaleSurnames = loadLines(Paths.get("nazwiska_zenskie.txt"));
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

    public static void changeStreets(Path file){
        Charset charset = Charset.forName("UTF-8");
        Path output = Paths.get("ulice2.txt");
        try (BufferedReader reader = Files.newBufferedReader(file, charset); BufferedWriter writer = Files.newBufferedWriter(output, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitedLine = line.split(" ");
                splitedLine = Arrays.copyOf(splitedLine, splitedLine.length-1);
                for (String element: splitedLine) {
                    writer.write(element + " ");
                }
                writer.newLine();
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public static void splitSurnames(Path file){
        Charset charset = Charset.forName("UTF-8");
        Path outputMale = Paths.get("nazwska_meskie.txt");
        Path outputFemale = Paths.get("nazwiska_zenskie.txt");
        try (BufferedReader reader = Files.newBufferedReader(file, charset);
             BufferedWriter writerMale = Files.newBufferedWriter(outputMale, charset);
             BufferedWriter writerFemale = Files.newBufferedWriter(outputFemale, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitedLine =  line.split(" ");
                writerFemale.write(splitedLine[0]);
                writerFemale.newLine();
                writerMale.write(splitedLine[2]);
                writerMale.newLine();
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

}
