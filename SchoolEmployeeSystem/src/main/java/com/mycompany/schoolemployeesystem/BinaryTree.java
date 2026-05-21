/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeesystem;

/**
 *
 * @author valec
 */
public class BinaryTree {
    
    TreeNode root;

    /**
     * Inserts a new employee using LEVEL-ORDER (BFS) insertion.
     * This ensures the tree fills left-to-right, top-to-bottom.
     */
    public void insert(Employee e) {

        TreeNode newNode = new TreeNode(e);

        // If tree is empty → new node becomes root
        if (root == null) {
            root = newNode;
            return;
        }

        // BFS queue
        TreeNode[] queue = new TreeNode[200];
        int front = 0, rear = 0;

        queue[rear] = root;

        while (front <= rear) {

            TreeNode current = queue[front];
            front++;

            // Try left child
            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                rear++;
                queue[rear] = current.left;
            }

            // Try right child
            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                rear++;
                queue[rear] = current.right;
            }
        }
    }

    /**
     * BFS traversal to display the hierarchy.
     */
    public void bfs() {


        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        TreeNode[] queue = new TreeNode[200];
        int front = 0, rear = 0;

        queue[rear] = root;

        while (front <= rear) {
            TreeNode temp = queue[front];
            front++;

            System.out.println(temp.data.name + " (" + temp.data.managerType.getType() + ") - " + temp.data.department.getName());

            if (temp.left != null) {
                rear++;
                queue[rear] = temp.left;
            }

            if (temp.right != null) {
                rear++;
                queue[rear] = temp.right;
            }
        }
    }

    /**
     * Recursively calculates height.
     */
    public int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    /**
     * Recursively counts nodes.
     */
    public int getNodeCount(TreeNode node) {
        if (node == null) return 0;
        return 1 + getNodeCount(node.left) + getNodeCount(node.right);
    }

}
