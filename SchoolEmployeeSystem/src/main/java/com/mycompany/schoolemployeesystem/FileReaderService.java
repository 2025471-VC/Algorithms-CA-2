/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeesystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author valec
 */
public class FileReaderService {
    
    public static int loadApplicants(String[] names) {

        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("Applicants_Form.txt"));
            br.readLine();
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

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return count;
    }
}
