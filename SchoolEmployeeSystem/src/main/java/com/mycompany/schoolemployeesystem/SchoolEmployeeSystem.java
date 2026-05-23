/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.schoolemployeesystem;

import java.util.Scanner;

/**
 *Main entry point of the School Employee System.
 * This class only starts the menu controller.
 * @author valec
 */

    public class SchoolEmployeeSystem {
        
        Scanner sc = new Scanner(System.in);
    EmployeeList list = new EmployeeList();

    public static void main(String[] args) {
        SchoolEmployeeSystem system = new SchoolEmployeeSystem();
        system.start();
    }

    /**
     * Main menu loop with input validation.
     */
    public void start() {

     while (true) {
        try {

            System.out.println("\n==============================");
            System.out.println("     SCHOOL EMPLOYEE SYSTEM");
            System.out.println("==============================");

            int i = 1;
            for (MenuOption option : MenuOption.values()) {
                System.out.println(i + ". " + option);
                i++;
            }

            System.out.println(" ");
            System.out.print("Choose option (From 1 to 5): ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice < 1 || choice > MenuOption.values().length) {
                System.out.println("Invalid option.");
                continue;
            }

            MenuOption selected = MenuOption.values()[choice - 1];

            switch (selected) {
                case ADD_EMPLOYEE -> addEmployeeMenu();
                case SORT_APPLICANTS -> sortApplicants();
                case SEARCH_EMPLOYEE -> searchEmployee();
                case BUILD_HIERARCHY -> buildHierarchy();
                case EXIT -> {
                    System.out.println("Exiting system...");
                    return;
                }
            }

        } catch (Exception e) {
            System.out.println("Invalid input. Numbers only.");
            sc.nextLine();
        }
      }
    }

    
    //Add a new employee to the system.
private void addEmployeeMenu() {

    System.out.println("\n--- ADD NEW EMPLOYEE ---\n");

    // NAME
    System.out.print("Enter full name: ");
    String name = sc.nextLine();

    if (!Validator.validateName(name)) {
        System.out.println("Error: Invalid name.");
        return;
    }

    // ============================
    // 1. CHOOSE DEPARTMENT
    // ============================
    System.out.println("\nChoose a Department:");
    System.out.println("1. Academic Department");
    System.out.println("2. Administration Department");
    System.out.println("3. Student Support Department");
    System.out.println("4. Facilities & Operations");

    System.out.print("Enter option (1-4): ");
    int deptChoice = sc.nextInt();
    sc.nextLine();

    String department = "";
    String position = "";
    String subject = "";

    switch (deptChoice) {

        case 1 -> {
            department = "Academic Department";

            // POSITIONS FOR ACADEMIC
            System.out.println("\nChoose a Position:");
            System.out.println("1. Principal");
            System.out.println("2. Head Teacher");
            System.out.println("3. Subject Teacher");

            System.out.print("Enter option (1-3): ");
            int pos = sc.nextInt();
            sc.nextLine();

            switch (pos) {
                case 1 -> position = "Principal";
                case 2 -> position = "Head Teacher";
                case 3 -> {
                    position = "Subject Teacher";

                    // SUBJECTS ONLY FOR SUBJECT TEACHER
                    System.out.println("\nChoose a Subject:");
                    System.out.println("1. Math");
                    System.out.println("2. Science");
                    System.out.println("3. English");
                    System.out.println("4. Languages");
                    System.out.println("5. History");
                    System.out.println("6. Art");
                    System.out.println("7. Physical Education");

                    System.out.print("Enter option (1-7): ");
                    int sub = sc.nextInt();
                    sc.nextLine();

                    subject = switch (sub) {
                        case 1 -> "Math";
                        case 2 -> "Science";
                        case 3 -> "English";
                        case 4 -> "Languages";
                        case 5 -> "History";
                        case 6 -> "Art";
                        case 7 -> "Physical Education";
                        default -> "";
                    };

                    if (subject.isEmpty()) {
                        System.out.println("Invalid subject.");
                        return;
                    }
                }
                default -> {
                    if (pos < 1 || pos > 3) {
                        System.out.println("Invalid position.");
                        return;
                    }
                }
            }
        }

        case 2 -> {
            department = "Administration Department";

            System.out.println("\nChoose a Position:");
            System.out.println("1. HR Assistant");
            System.out.println("2. Finance");
            System.out.println("3. School Secretary");

            System.out.print("Enter option (1-3): ");
            int pos = sc.nextInt();
            sc.nextLine();

            position = switch (pos) {
                case 1 -> "HR Assistant";
                case 2 -> "Finance";
                case 3 -> "School Secretary";
                default -> "";
            };

            if (position.isEmpty()) {
                System.out.println("Invalid position.");
                return;
            }
        }

        case 3 -> {
            department = "Student Support Department";

            System.out.println("\nChoose a Position:");
            System.out.println("1. School Counselor");
            System.out.println("2. School Nurse");
            System.out.println("3. Learning Support Assistant");

            System.out.print("Enter option (1-3): ");
            int pos = sc.nextInt();
            sc.nextLine();

            position = switch (pos) {
                case 1 -> "School Counselor";
                case 2 -> "School Nurse";
                case 3 -> "Learning Support Assistant";
                default -> "";
            };

            if (position.isEmpty()) {
                System.out.println("Invalid position.");
                return;
            }
        }

        case 4 -> {
            department = "Facilities & Operations";

            System.out.println("\nChoose a Position:");
            System.out.println("1. Maintenance Worker");
            System.out.println("2. Cleaner");
            System.out.println("3. Security Guard");
            System.out.println("4. Cafeteria Staff");

            System.out.print("Enter option (1-4): ");
            int pos = sc.nextInt();
            sc.nextLine();

            position = switch (pos) {
                case 1 -> "Maintenance Worker";
                case 2 -> "Cleaner";
                case 3 -> "Security Guard";
                case 4 -> "Cafeteria Staff";
                default -> "";
            };

            if (position.isEmpty()) {
                System.out.println("Invalid position.");
                return;
            }
        }

        default -> {
            System.out.println("Invalid department.");
            return;
        }
    }

    // CREATE OBJECTS
    Manager manager = new Manager(position);
    Department deptObj = new Department(department);

    Employee e = new Employee(name, manager, deptObj);
    list.addEmployee(e);

    // FINAL MESSAGE
    System.out.println();
    if (subject.isEmpty()) {
        System.out.println("\"" + name + "\" has been added as \"" 
                + position + "\" to \"" + department + "\" successfully!");
    } else {
        System.out.println("\"" + name + "\" has been added as \"" 
                + position + " (" + subject + ")\" to \"" 
                + department + "\" successfully!");
    }
    }

    private void sortApplicants() {

    System.out.println("\n--- SORT APPLICANTS ---\n");

    // 1. List available files
    String[] availableFiles = FileReaderService.listApplicantFiles();

    if (availableFiles.length == 0) {
        System.out.println("No applicant files found in the project folder.");
        return;
    }

    System.out.println("Available applicant files:");
    for (int i = 0; i < availableFiles.length; i++) {
        System.out.println((i + 1) + ". " + availableFiles[i]);
    }

    // 2. Ask user to choose a file by number
    int choice = -1;

    while (true) {
        System.out.print("\nChoose a file by number: ");
        
        try {
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice < 1 || choice > availableFiles.length) {
                System.out.println("Invalid option. Please choose a valid number.");
            } else {
                break;
            }

        } catch (Exception e) {
            System.out.println("Invalid input. Numbers only.");
            sc.nextLine();
        }
    }

    String filename = availableFiles[choice - 1];
    System.out.println("\n✔ Selected file: " + filename + "\n");

    // 3. Load selected file
    String[] fileNames = new String[200];
    int fileCount = FileReaderService.loadApplicantsFromFile(filename, fileNames);

    if (fileCount == -1) {
        System.out.println("Error loading file. Returning to menu.");
        return;
    }

    // 4. Read manually added employees
    String[] manualNames = list.getAllNames();
    int manualCount = list.getCount();

    // 5. Combine lists
    String[] combined = new String[fileCount + manualCount];
    int index = 0;

    for (int i = 0; i < fileCount; i++) combined[index++] = fileNames[i];
    for (int i = 0; i < manualCount; i++) combined[index++] = manualNames[i];

    // 6. Sort
    Sorter.recursiveSort(combined, combined.length);

    // 7. Display first 20
    System.out.println("FIRST 20 APPLICANTS (SORTED):\n");

    int limit = Math.min(20, combined.length);
    
    for (int i = 0; i < limit; i++) {
        System.out.printf("%-3d %-20s\n", (i + 1), combined[i]);
    }

    System.out.println("\nSorting completed successfully.");
}


    //Search for an employee using recursive binary search.
    private void searchEmployee() {

        if (list.isEmpty()) {
            System.out.println("No employees in the system.");
            return;
        }

        System.out.println("\n--- SEARCH EMPLOYEE ---");
        System.out.println(" ");

        System.out.print("Enter name to search: ");
        String target = sc.nextLine();

        String[] names = new String[list.count];

        for (int i = 0; i < list.count; i++) {
            names[i] = list.employees[i].name;
        }

        Sorter.recursiveSort(names, list.count);

        Employee[] sortedEmployees = new Employee[list.count];

        for (int i = 0; i < list.count; i++) {
            for (int j = 0; j < list.count; j++) {
                if (list.employees[j].name.equalsIgnoreCase(names[i])) {
                    sortedEmployees[i] = list.employees[j];
                    break;
                }
            }
        }

        int index = Searcher.recursiveSearch(sortedEmployees, target, 0, list.count - 1);

        if (index == -1) {
            System.out.println("Employee not found.");
        } else {
            Employee e = sortedEmployees[index];
            System.out.println("\nEMPLOYEE FOUND:");
            System.out.println("Name: " + e.name);
            System.out.println("Manager Type: " + e.managerType);
            System.out.println("Department: " + e.department);
        }

        System.out.println("\nSearch completed.");
    }

    
    //Build a binary tree hierarchy and display BFS, height and node count.
    private void buildHierarchy() {

        if (list.isEmpty()) {
            System.out.println("No employees to build hierarchy.");
            return;
        }

        System.out.println("\n--- BUILDING EMPLOYEE HIERARCHY ---");

        BinaryTree tree = new BinaryTree();

        for (int i = 0; i < list.count; i++) {
            tree.insert(list.employees[i]);
        }

        System.out.println("\nEMPLOYEE HIERARCHY (BFS Traversal):");
        System.out.println(" ");
        tree.bfs();

        System.out.println("\nTree Height: " + tree.getHeight(tree.root));
        System.out.println("Total Nodes: " + tree.getNodeCount(tree.root));

        System.out.println("\nHierarchy generated successfully.");
    }
    }

