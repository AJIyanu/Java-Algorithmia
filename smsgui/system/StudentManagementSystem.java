package smsgui.system;

import smsgui.model.Student;
import smsgui.model.Course;
import smsgui.model.Enrollment;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the data and operations related to students, courses, and enrollments.
 * Acts as the backend logic for the Student Management System.
 */
public class StudentManagementSystem {

    private static final List<Student> students = new ArrayList<>();
    private static final List<Course> courses = new ArrayList<>();
    private static final List<Enrollment> enrollments = new ArrayList<>();

    /**
     * Adds a new student to the system.
     *
     * @param student The student to be added.
     */
    public static void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Updates the details of an existing student.
     *
     * @param student The student with updated details.
     */
    public static void updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(student.getStudentId())) {
                students.set(i, student);
                break;
            }
        }
    }

    /**
     * Retrieves a student by their ID.
     *
     * @param studentId The ID of the student.
     * @return The student object, or null if not found.
     */
    public static Student getStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Adds a new course to the system.
     *
     * @param course The course to be added.
     */
    public static void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * Enrolls a student in a course and assigns an initial grade.
     *
     * @param studentId The ID of the student.
     * @param courseCode The code of the course.
     * @param grade The initial grade assigned to the student.
     */
    public static void enrollStudent(String studentId, String courseCode, int grade) {
        Student student = getStudentById(studentId);
        if (student != null) {
            student.enrollInCourse(courseCode);
        }
        Enrollment enrollment = new Enrollment(studentId, courseCode, grade);
        enrollments.add(enrollment);
    }

    /**
     * Assigns a grade to a student for a specific course.
     *
     * @param studentId The ID of the student.
     * @param courseCode The code of the course.
     * @param grade The grade to assign.
     */
    public static void assignGrade(String studentId, String courseCode, int grade) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId().equals(studentId) && enrollment.getCourseCode().equals(courseCode)) {
                enrollment.setGrade(grade);
                break;
            }
        }
    }

    /**
     * Retrieves the list of all students in the system.
     *
     * @return The list of students.
     */
    public static List<Student> getAllStudents() {
        return students;
    }

    /**
     * Retrieves the list of all courses in the system.
     *
     * @return The list of courses.
     */
    public static List<Course> getAllCourses() {
        return courses;
    }

    /**
     * Retrieves the list of all enrollments in the system.
     *
     * @return The list of enrollments.
     */
    public static List<Enrollment> getAllEnrollments() {
        return enrollments;
    }
}

