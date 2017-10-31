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

public class Main {

    public static void main(String[] args) {

        StudentsGenerator studentsGenerator = new StudentsGenerator(2002, 55.3);
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < 10; i++)
            students.add(studentsGenerator.getNextStudent());

        for (Student student: students) {
            System.out.println(student.toString());

        }


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
        Path outputMale = Paths.get("nazwiska_meskie.txt");
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
