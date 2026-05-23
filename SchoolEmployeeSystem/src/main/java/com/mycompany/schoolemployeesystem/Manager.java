/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeesystem;

/**
 *
 * @author valec
 */
public class Manager { // Simple data classes storing manager type
    
    private String type;

    public Manager(String type) { //Creates a new Manager object.
        this.type = type;
    }

    public String getType() { //Returns the role or position of the employee.
        return type;
    }

    @Override
    public String toString() { //This ensures readable output in lists, searches, and hierarchy displays.
        return type;
    }
    
}
