/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeesystem;

/**
 *Represents a single employee in the school system.
 * Stores basic information such as name, manager type and department.
 * @author valec
 */
public class Employee {
    
    String name;
    Manager managerType;
    Department department;
    
    //Constructor to create a new Employee object
    
    public Employee(String name, Manager managerType, Department department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }
}
