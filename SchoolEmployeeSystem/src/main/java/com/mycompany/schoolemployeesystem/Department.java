/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeesystem;

/**
 *
 * @author valec
 */
public class Department { // Simple data classes storing department name
    
    private String name;

    public Department(String name) {
        this.name = name; // Stores department name internally
    }

    public String getName() { //This method provides controlled access to the private field.
        return name;
    }

    @Override
    public String toString() { //This improves readability when displaying employee information.
        return name;
    }

    
}
