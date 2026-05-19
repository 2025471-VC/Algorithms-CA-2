/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeesystem;

/**
 * Stores employees using a fixed-size array of 50 elements.
 * Provides basic operations such as add, check full and check empty.
 * @author valec
 */
public class EmployeeList {
    
    Employee[] employees = new Employee[20];
    int count = 0;

    //Checks if the array is full.
    public boolean isFull() {
        return count == 20;
    }

    //Checks if the array is empty.
    public boolean isEmpty() {
        return count == 0;
    }

    //Adds a new employee to the list if space is available.
    public void addEmployee(Employee e) {
        if (isFull()) {
            System.out.println("Storage full. Cannot add more employees.");
            return;
        }
        employees[count] = e;
        count++;
        System.out.println("Employee added: " + e.name);
    }
    
}
