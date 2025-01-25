package ceagms;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Administrator Console app
 * 
 */
public class Administrator {
    private static Scanner scanner = new Scanner(System.in);
    private static HashMap<Integer, Runnable> commandList = new HashMap<>();

    public static void main(String[] args) {
        commandList.put(1, Administrator::addNewCourse);
        commandList.put(2, Administrator::addNewstudent);
        commandList.put(3, Administrator::enrollStudentInCourse);
        commandList.put(4, Administrator::assignGrade);
        commandList.put(5, Administrator::studentGrade);
        commandList.put(6, Administrator::allStudentGrade);
        commandList.put(7, Administrator::studenDetails);
        console();
    }

    public static void console() {
        boolean isRunning = true;
        System.out.println("Welcome to Course Enrollment and Grade Management SYstem!");
        System.out.println("***********************************************************\n");

        while (isRunning) {
            displayInputOptions(0);
            int choice = 0;
            try{
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                String command = scanner.nextLine();
                if (command.equals("exit")) {
                    isRunning = false;
                    continue;
                } else if (command.equals("help")) {
                    System.out.println("****************************************\n");
                    continue;
                } else {
                    displayInputOptions(1);
                    continue;
                }
            }
            
            try {
                commandList.get(choice).run();
                System.out.println("****************************************\n");
            } catch (Exception e) {
                System.err.println(e.getMessage());;
                displayInputOptions(1);
                continue;    
            }
        }
    }

    public static void displayInputOptions(int level) {
        System.out.println("Reply with the respective number to activate command!");
        if (level == 0) {
            System.out.println("1 --> Add a new course");
            System.out.println("2 --> Add a new student");
            System.out.println("3 --> Enroll a student to a course");
            System.out.println("4 --> Assign grades");
            System.out.println("5 --> Calculate a student's overall grades");
            System.out.println("6 --> Calculate all students' overall grades");
            System.out.println("7 --> Display a student performance detail");
            System.out.println("help --> Display options again");
            System.out.println("exit --> exit console");
            System.out.println();
        } else if (level == 1) {
            System.out.println("Console only accepts integer value that corresponds to command!");
            System.out.println("****************************************\n");
        }
    }
    
    public static void addNewstudent() {
        System.out.println("Please Enter the Student's Name:");
        String name = scanner.nextLine();
        CourseManagement.addStudent(name);
    }

    public static void addNewCourse() {
        System.out.println("Please Enter the course name");
        String name = scanner.nextLine();
        System.out.println("Please Enter the course code");
        String code = scanner.nextLine();
        CourseManagement.addCourse(name, code);
    }

    public static void enrollStudentInCourse() {
        System.out.println("Please Enter Student's Name or ID:");
        String searchString = scanner.nextLine();
        Student student = CourseManagement.getStudent(searchString);
        System.out.println("Please  Enter the Course name or code:");
        searchString = scanner.nextLine();
        Course course = CourseManagement.getCourse(searchString);
        if (student == null || course == null) {
            System.out.println("Please Enter a valid student name or id and a valid course or course code!");
        } else {
            try {
                if (CourseManagement.enrollStudentInCourse(student, course)) {
                    System.out.println("Sucessfull!");
                } else {
                    System.out.println("Course already enrolled");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void assignGrade() {
        System.out.println("Please provide student's name or ID");
        String searchString = scanner.nextLine();
        Student student = CourseManagement.getStudent(searchString);
        System.out.println("Please enter course name or course code");
        searchString = scanner.nextLine();
        Course course = CourseManagement.getCourse(searchString);
        int Grade = 0;
        try {
            System.out.println("Please Enter student grade");
            Grade = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("***Error! Console only accept integer value for grade***");
            System.out.println("***Please try again! Exiting command....***");
            scanner.nextLine();
        }
        if (CourseManagement.assignGrade(student, course, Grade)) {
            System.out.println("Successfull!");
        } else {
            System.out.println("Either student does not enrolled or course does not exist");
        }
    }

    public static void studenDetails() {
        System.out.println("Please provide student's name or ID:");
        String searchString = scanner.nextLine();
        Student student = CourseManagement.getStudent(searchString);
        if (student != null) {
            student.studentGradeInfo();
        } else {
            System.out.println("Not a valid student!");
        }
    }

    public static void studentGrade() {
        System.out.println("Please Enter Student's name or ID:");
        String searchString = scanner.nextLine();
        System.out.println(CourseManagement.calculateOverallGrade(CourseManagement.getStudent(searchString)));
    }

    public static void allStudentGrade() {
        CourseManagement.allStudentGrade();
    }
     
}