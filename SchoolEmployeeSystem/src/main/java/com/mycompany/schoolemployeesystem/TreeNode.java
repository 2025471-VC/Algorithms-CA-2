/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeesystem;

/**
 *
 * @author valec
 */
public class TreeNode {
    
    Employee data;
    TreeNode left;
    TreeNode right;

    public TreeNode(Employee data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
