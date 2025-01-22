package sims;

import java.util.Scanner;
import java.util.ArrayList;

public class AdminInterfaceConsole {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Runnable> commandList = new ArrayList<>();
    
    public static void main(String[] args) {
        commandList.add(null);
        commandList.add(AdminInterfaceConsole::newStudent);
        Console();
    }
    
    public static void Console() {
        System.out.println("Welcome to Student Information Management System");
        System.out.println("<---------------------------------------------------------------->\n");
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
                } else {
                    System.out.println("\n******Invalid input*********");
                    System.out.println("Console only accepts integer values that correspond to the commands\n");
                    displayConsoleCommands(0);
                }
            }
            
            if (choice == 4) {
                isRunning = false;
            } else if (choice != 0 && choice <= commandList.size()) {
                commandList.get(choice).run();
                System.out.println("<------------------------------------------------------------>\n");
                displayConsoleCommands(0);
            } else if (choice > 4) {
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
}
