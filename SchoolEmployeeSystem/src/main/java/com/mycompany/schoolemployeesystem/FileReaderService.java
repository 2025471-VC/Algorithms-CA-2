/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeesystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author valec
 */
public class FileReaderService { // Reads applicant files line by line
    
    public static int loadApplicants(String[] names) { //Loads applicant names from the default file "Applicants_Form_2024.txt"
        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("Applicants_Form_2024.txt")); // BufferedReader allows efficient reading of text files line by line.
            br.readLine();  // Skips the header row (usually column titles).
            String line;

            // Extracts first and last name from CSV format
            while ((line = br.readLine()) != null && count < names.length) {
                String[] parts = line.split(","); // Splits CSV line into columns using comma as delimiter.
                
                if (parts.length >= 2) {
                    String fullName = parts[0].trim() + " " + parts[1].trim(); // Combines first name + last name into a single string.
                    names[count] = fullName;
                    count++;

            }
        }

            br.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return count;
    }
    
    public static int loadApplicantsFromFile(String filename, String[] names) { //Loads applicant names from a file chosen by the user.
    int count = 0;

    try {
        BufferedReader br = new BufferedReader(new FileReader(filename));

        br.readLine(); // Skip header
        String line;

        while ((line = br.readLine()) != null && count < names.length) {
            String[] parts = line.split(",");

            if (parts.length >= 2) {
                String fullName = parts[0].trim() + " " + parts[1].trim();
                names[count] = fullName;
                count++;
            }
        }

        br.close();
        return count;

    } catch (IOException e) {
        return -1; // File not found or unreadable
    }
}
    
    public static String[] listApplicantFiles() { //Scans the project directory and returns all files whose names follow the pattern "Applicants_Form_*.txt".


    File folder = new File("."); // current project folder
    File[] files = folder.listFiles();

    if (files == null) return new String[0];

    String[] result = new String[50];
    int count = 0;

    for (File f : files) {
        if (f.isFile() && f.getName().startsWith("Applicants_Form_") && f.getName().endsWith(".txt")) {
            result[count++] = f.getName();
        }
    }

    String[] finalList = new String[count];
    System.arraycopy(result, 0, finalList, 0, count);

    return finalList;
}
   
}
