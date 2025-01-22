package sims;

import java.util.ArrayList;

public class StudentManagement {
    private static ArrayList<Student> students  = new ArrayList<>();
    private static int count = 0;
    
    public static String addStudent(String name, int age) {
        Student student = new Student(name, age, 0);
        students.add(student);
        count++;
        return student.getId();
    }

    public static int getCount() {
        return count;
    }

    /**
     * Searches for a student by name or ID
     * 
     * @param searchString the name or ID of the student
     * @return the student object if found, null otherwise
     */
    public static Student getStudent(String searchString) {
        for (Student student : students) {
            if (student.getName().equals(searchString) || student.getId().equals(searchString)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Returns a string with the student's information
     * 
     * @param searchString the name or ID of the student
     * @return a string with the student's information or "Student not found" if the student is not found
     */
    public static String studentInfo(String searchString) {
        Student student = getStudent(searchString);
        if (student.equals(null)) {
            return "Student not Found";
        }

        return "ID: " + student.getId() +
                "\nName: " + student.getName() +
                "\nAge: " + student.getAge() +
                "\nGrade: " + student.getGrade();
    }

    /**
     * Updates the grade of a student
     * 
     * @param searchString the name or ID of the student
     * @param grade        the new grade of the student
     * @return true if the grade was updated, false if the student was not found
     */
    public static boolean updateGrade(String searchString, int grade) {
        Student student = getStudent(searchString);
        if (student.equals(null)) {
            return false;
        }
        student.setGrade(grade);
        return true;
    }

    /**
     * Updates the age of a student
     * 
     * @param searchString
     * @param age
     * @return true if the age was updated, false if the student was not found
     */
    public static boolean updateAge(String searchString, int age) {
        Student student = getStudent(searchString);
        if (student.equals(null)) {
            return false;
        }
        student.setAge(age);
        return true;
    }

    /**
     * Updates the name of a student
     * 
     * @param searchString the name or ID of the student
     * @param name         the new name of the student
     * @return true if the name was updated, false if the student was not found
     */
    public static boolean updateName(String searchString, String name) {
        Student student = getStudent(searchString);
        if (student.equals(null)) {
            return false;
        }
        student.setName(name);
        return true;
    }
}
