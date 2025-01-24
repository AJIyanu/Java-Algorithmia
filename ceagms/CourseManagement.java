package ceagms;

import java.util.ArrayList;

public class CourseManagement {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();

    public static void addCourse(String courseName, String courseCode) {
        Course newCourse = new Course(courseName, courseCode);
        courses.add(newCourse);
    }

    public static void addStudent(String studentName) {
        Student newStudent = new Student(studentName);
        students.add(newStudent);
    }

    public static boolean enrollStudentInCourse(Student student, Course course) {
        if (verifyStudent(student) && verifyCourse(course)) {
            return (student.enrollCourse(course));
        }
        return false;
    }

    public static boolean assignGrade(Student student, Course course, int grade) {
        if (verifyStudent(student) && verifyCourse(course)) {
            return student.assignGrade(course, grade);
        }
        return false;
    }
    
    private static boolean verifyStudent(Student student) {
        if (!students.contains(student)) {
            return false;
        }
        return true;
    }
    
    
    private static boolean verifyCourse(Course course) {
        if (!courses.contains(course)) {
            return false;
        }
        return true;
    }
}
