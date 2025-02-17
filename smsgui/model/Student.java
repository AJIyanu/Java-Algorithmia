package smsgui.model;

/**
 * Represents a student in the student management system.
 * This class stores the student's personal information and their enrolled courses.
 */
import java.util.ArrayList;
import java.util.List;

public class Student {

    /**
     * Unique identifier for the student.
     */
    private String studentId;

    /**
     * Full name of the student.
     */
    private String fullName;

    /**
     * Age of the student.
     */
    private int age;

    /**
     * Email address of the student.
     */
    private String email;

    /**
     * List of course codes in which the student is enrolled.
     */
    private List<String> enrolledCourses;

    /**
     * Constructs a new Student object with the given details.
     *
     * @param studentId Unique identifier for the student.
     * @param fullName Full name of the student.
     * @param age Age of the student.
     * @param email Email address of the student.
     */
    public Student(String studentId, String fullName, int age, String email) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.enrolledCourses = new ArrayList<>();
    }

    /**
     * Gets the student ID.
     *
     * @return The student ID.
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Gets the full name of the student.
     *
     * @return The full name.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name of the student.
     *
     * @param fullName The new full name.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets the age of the student.
     *
     * @return The age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the student.
     *
     * @param age The new age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the email of the student.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the student.
     *
     * @param email The new email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the list of enrolled course codes.
     *
     * @return The list of enrolled courses.
     */
    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    /**
     * Enrolls the student in a course by adding the course code to the list.
     *
     * @param courseCode The course code to enroll in.
     */
    public void enrollInCourse(String courseCode) {
        if (!enrolledCourses.contains(courseCode)) {
            enrolledCourses.add(courseCode);
        }
    }

    /**
     * Removes a course from the student's enrolled courses.
     *
     * @param courseCode The course code to remove.
     */
    public void removeCourse(String courseCode) {
        enrolledCourses.remove(courseCode);
    }

    /**
     * Returns a string representation of the student object.
     *
     * @return A string containing the student's ID, name, age, and email.
     */
    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + fullName + ", Age: " + age + ", Email: " + email;
    }
} 
