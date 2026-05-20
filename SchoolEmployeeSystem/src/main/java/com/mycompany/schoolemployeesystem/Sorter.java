/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeesystem;

/**
 * Provides a recursive sorting algorithm (recursive insertion sort).
 * Sorts an array of Strings alphabetically.
 * @author valec
 */
public class Sorter {
    
    // Recursively sorts the first n elements of the array.
    public static void recursiveSort(String[] arr, int n) {

        // Base case: array of size 1 is already sorted
        if (n == 1) {
            return;
        }

        // Sort first n-1 elements recursively
        recursiveSort(arr, n - 1);

        // Insert last element into the sorted part
        String last = arr[n - 1];
        int j = n - 2;

        // Move elements that are greater than 'last'
        while (j >= 0 && arr[j].compareToIgnoreCase(last) > 0) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = last;
    }    
}
