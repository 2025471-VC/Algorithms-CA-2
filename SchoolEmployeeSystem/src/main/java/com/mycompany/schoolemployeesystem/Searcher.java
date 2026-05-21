/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeesystem;

/**
 *
 * @author valec
 */
public class Searcher {
    
    public static int recursiveSearch(Employee[] arr, String target, int left, int right) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        int compare = arr[mid].name.compareToIgnoreCase(target);

        if (compare == 0) {
            return mid;
        }

        if (compare > 0) {
            return recursiveSearch(arr, target, left, mid - 1);
        } else {
            return recursiveSearch(arr, target, mid + 1, right);
        }
    }    
}
