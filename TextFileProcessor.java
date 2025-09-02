package assignments.module8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This program reads the data from a CSV file that is not formatted correctly and then it takes the
 * data from the unformatted file and makes a new file and input that data but in fomrat of (last
 * name, first name, middle name, and country name).
 *
 * @author muhammadnaseem
 * @version May 1, 2025
 *
 */
public class TextFileProcessor {

    /**
     * Read the data from the CSV file, sort them by last name, first name, middle name and city
     * name and then write a clean and formatted data into the file
     *
     * @param args NONE
     */
    public static void main(String[] args) {
        List<Person> people = readAndCleanData("50Names.csv");
        Collections.sort(people);
        for (Person person : people) {
            System.out.println(person);
        }
        writeCleanData("clean_data.csv", people);
    }

    /**
     * Reads and clean data from the file and grouping all 4 things into to person object.
     *
     * @param fileName the name of the input CSV file
     * @return a lost of person objects
     */
    public static List<Person> readAndCleanData(String fileName) {
        List<Person> people = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            reader.useDelimiter("[,\n\r]+");

            List<String> values = new ArrayList<>();

            while (reader.hasNext()) {
                String token = reader.next().trim();
                if (!token.isEmpty()) {
                    values.add(token);
                }
            }

            reader.close();

            for (int i = 0; i + 3 < values.size(); i += 4) {
                String firstName = values.get(i);
                String middleName = values.get(i + 1);
                String lastName = values.get(i + 2);
                String cityName = values.get(i + 3);
                people.add(new Person(firstName, middleName, lastName, cityName));
            }

        }
        catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + fileName);
        }

        return people;
    }

    /**
     * Writes the sorted list of Person objects to a new CSV file.
     *
     * @param fileName the name of the output CSV file
     * @param people the list of Person object to write
     */
    public static void writeCleanData(String fileName, List<Person> people) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Person names : people) {
                writer.println(names.toString());
            }
            System.out.println("clean_data.csv written successfully.");
        }
        catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
