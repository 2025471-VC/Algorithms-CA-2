/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeesystem;

/**
 * Provides simple validation methods for employee input fields.
 * @author valec
 */
public class Validator {
    
    // Validates that name contains only letters and spaces
    public static boolean validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
        return false;
    }

    // Letters and spaces only including accent marks.
    if (!name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
        return false;
    }

    
    String clean = name.replace(" ", "");

    // 2 letters minimum
    return clean.length() >= 2; // Ensures minimum length of 2 characters
    }    

    //Validates allowed manager types.
    public static boolean validateManagerType(String type) {
        return type.equalsIgnoreCase("Manager") ||
               type.equalsIgnoreCase("Assistant") ||
               type.equalsIgnoreCase("Coordinator");
    }

    //Validates allowed departments.
    public static boolean validateDepartment(String dept) {
        return dept.equalsIgnoreCase("Math") ||
               dept.equalsIgnoreCase("Science") ||
               dept.equalsIgnoreCase("English") ||
               dept.equalsIgnoreCase("Sports");
    }
}
