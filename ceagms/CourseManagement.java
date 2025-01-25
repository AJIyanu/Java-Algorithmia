package ceagms;

import java.util.ArrayList;

public class CourseManagement {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();

    public static Student getStudent(String studentString) {
        for (Student student : students) {
            if (student.getId().equals(studentString) || student.getName().equals(studentString))
                return student;
        }
        return null;
    }
    
    public static Course getCourse(String courseString) {
        for (Course course : courses) {
            if (course.getCode().equals(courseString) || course.getName().equals(courseString))
                return course;
        }
        return null;
    }

    public static void allStudentGrade() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Overallgrade: " + student.overallGrade());
            System.out.println("**************************\n");
        }
    }

    /**
     * Create a new course for enrollment
     * 
     * @param courseName - Name of course
     * @param courseCode - code for course
     */
    public static void addCourse(String courseName, String courseCode) {
        Course newCourse = new Course(courseName, courseCode);
        courses.add(newCourse);
    }

    /**
     * Add a new student data
     * 
     * @param studentName - student's name
     */
    public static void addStudent(String studentName) {
        Student newStudent = new Student(studentName);
        students.add(newStudent);
    }

    /**
     * enroll a course for a student
     * 
     * @param student - student object
     * @param course - course object
     * @return true if student exists and if course exists otherwise false
     */
    public static boolean enrollStudentInCourse(Student student, Course course) throws Exception {
        if (verifyStudent(student) && verifyCourse(course)) {
            try {
                return (student.enrollCourse(course));
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
        return false;
    }

    /**
     * assign grade to a student on a course
     * 
     * @param student student obect
     * @param course course object
     * @param grade student score/grade
     * @return true if both student and course exist, and student is enrolled
     * otherwise false
     */
    public static boolean assignGrade(Student student, Course course, int grade) {
        if (verifyStudent(student) && verifyCourse(course)) {
            return student.assignGrade(course, grade);
        }
        return false;
    }

    /**
     * calculates the student's average grade
     * 
     * @param student student object
     * @return overall grade if student is registered, 0 otherwise
     */
    public static int calculateOverallGrade(Student student) {
        if (verifyStudent(student)) {
            return student.overallGrade();
        }
        return 0;
    }
    
    /**
     * verifies if student is registered
     * 
     * @param student student object
     * @return true if registered otherwise false
     */
    private static boolean verifyStudent(Student student) {
        if (!students.contains(student)) {
            return false;
        }
        return true;
    }
    
    
    /**
     * verifies is course is registered
     * 
     * @param course course object
     * @return true if registered otherwise false
     */
    private static boolean verifyCourse(Course course) {
        if (!courses.contains(course)) {
            return false;
        }
        return true;
    }
}
