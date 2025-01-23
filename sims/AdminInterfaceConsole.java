package sims;

import java.util.Scanner;
import java.util.ArrayList;

public class AdminInterfaceConsole {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Runnable> commandList = new ArrayList<>();
    
    public static void main(String[] args) {
        commandList.add(null);
        commandList.add(AdminInterfaceConsole::newStudent);
        commandList.add(AdminInterfaceConsole::updateStudent);
        commandList.add(StudentManagement::allStudentsinfo);
        Console();
    }
    
    public static void Console() {
        System.out.println("Welcome to Student Information Management System");
        System.out.println("\n<---------------------------------------------------------------->");
        displayConsoleCommands(0);
        boolean isRunning = true;

        while (isRunning) {
            int choice = 0;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                String help = sc.nextLine();
                if (help.equals("help")) {
                    displayConsoleCommands(0);
                    continue;
                } else {
                    System.out.println("\n******Invalid input*********");
                    System.out.println("Console only accepts integer values that correspond to the commands\n");
                    displayConsoleCommands(0);
                    continue;
                }
            }
            
            if (choice == 4) {
                isRunning = false;
            } else if (choice != 0 && choice <= commandList.size()) {
                commandList.get(choice).run();
                System.out.println("\n<------------------------------------------------------------>");
                displayConsoleCommands(0);
            } else if (choice > commandList.size()) {
                System.out.println("\n******Invalid input*********");
                System.out.println("Console only accepts integer values that correspond to the commands\n");
                displayConsoleCommands(0);
            } else {
                System.out.println("\n******You have not entered a command yet*********");
                displayConsoleCommands(0);
            }
        }
    }
    
    public static void displayConsoleCommands(int level) {
        if (level == 0) {
            System.out.println("Reply 1 to add a student");
            System.out.println("Reply 2 to update a student information");
            System.out.println("Reply 3 to view all students");
            System.out.println("Reply 4 to exit");
            System.out.println("Reply 'help' to display commands again");
        } else if (level == 1) {
            System.out.println("Reply 1 to update student name");
            System.out.println("Reply 2 to update student age");
            System.out.println("Reply 3 to update student grade");
        }

    }
    
    public static void newStudent() {
        System.out.println("Enter student name");
        String name = sc.nextLine();
        boolean isInt = false;
        int age = 0;
        while (!isInt) {
            try {
                System.out.println("Enter student age:");
                age = sc.nextInt();
                isInt = true;
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Student age can only accept an integer value.");
                sc.next();
            }
        }
        String id = StudentManagement.addStudent(name, age);
        System.out.println("--------Student added successfully; Info below------------");
        System.out.println(StudentManagement.studentInfo(id));
    }

    public static void updateStudent() {
        displayConsoleCommands(1);

        boolean subLevel = true;
        while (subLevel) {
            int choice = 0;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                String help = sc.nextLine();
                if (help.equals("help")) {
                    displayConsoleCommands(1);
                    continue;
                } else {
                    System.out.println("\n******Invalid input*********");
                    System.out.println("Console only accepts integer values that correspond to the commands\n");
                    displayConsoleCommands(1);
                    continue;
                }
            }
            if (choice == 1) {
                System.out.println("Please Enter Student's Old Name or ID:");
                String name = sc.nextLine();
                System.out.println("Please Enter Student's New Name:");
                String newName = sc.nextLine();
                if (StudentManagement.updateName(name, newName)) {
                    System.out.println("*********** Updated *****************");
                    System.out.println(StudentManagement.studentInfo(newName));
                    subLevel = false;
                } else {
                    System.out.println("***** Error Updating! Please check the name or ID and try again *********");
                    subLevel = false;
                }
            } else if (choice == 2) {
                System.out.println("Please Enter Student's Name or ID:");
                String name = sc.nextLine();
                int age = 0;
                try {
                    System.out.println("Please Enter Student's New Age:");
                    age = sc.nextInt();
                    sc.nextLine();
                } catch (Exception e) {
                    sc.nextLine();
                    System.out.println("***** Error! Age accepts only interger value*****");
                    displayConsoleCommands(1);
                    continue;
                }
                if (StudentManagement.updateAge(name, age)) {
                    System.out.println("*********** Updated *****************");
                    System.out.println(StudentManagement.studentInfo(name));
                    subLevel = false;
                } else {
                    System.out.println("***** Error Updating! Please check the name or ID and try again *********");
                    subLevel = false;
                }
            } else if (choice == 3) {
                System.out.println("Please Enter Student's Name or ID:");
                String name = sc.nextLine();
                int grade = 0;
                try {
                    System.out.println("Please Enter Student's New Grade:");
                    grade = sc.nextInt();
                    sc.nextLine();
                } catch (Exception e) {
                    sc.nextLine();
                    System.out.println("***** Error! Grade accepts only interger value*****");
                    displayConsoleCommands(1);
                    continue;
                }
                if (StudentManagement.updateGrade(name, grade)) {
                    System.out.println("*********** Updated *****************");
                    System.out.println(StudentManagement.studentInfo(name));
                    subLevel = false;
                } else {
                    System.out.println("***** Error Updating! Please check the name or ID and try again *********");
                    subLevel = false;
                }
            } else {
                System.out.println("***** Invalid Command! *********");
                subLevel = false;
            }
        }
    }
    
    public static void listStudent() {
        StudentManagement.allStudentsinfo();
    }
}
 