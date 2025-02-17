package smsgui.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a course in the student management system.
 * This class stores the course information and manages student grades.
 */
public class Course {
    private String courseCode;
    private String courseTitle;
    private int courseUnits;
    private Map<String, Integer> studentGrades;

    /**
     * Constructs a new Course object with the specified course code, title, and units.
     * Initializes an empty map for storing student grades.
     *
     * @param courseCode The unique code representing the course.
     * @param courseTitle The title of the course.
     * @param courseUnits The number of units assigned to the course.
     */
    public Course(String courseCode, String courseTitle, int courseUnits) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.courseUnits = courseUnits;
        this.studentGrades = new HashMap<>();
    }

    /**
     * Assigns a grade to a student for this course.
     *
     * @param studentId The ID of the student.
     * @param grade The grade assigned to the student.
     */
    public void assignGrade(String studentId, int grade) {
        studentGrades.put(studentId, grade);
    }

    /**
     * Retrieves the grade of a student for this course.
     *
     * @param studentId The ID of the student.
     * @return The grade assigned to the student, or null if no grade is found.
     */
    public Integer getGrade(String studentId) {
        return studentGrades.get(studentId);
    }

    /**
     * Returns a string representation of the course object.
     *
     * @return A string containing the course code, title, and units.
     */
    @Override
    public String toString() {
        return "Course Code: " + courseCode + ", Title: " + courseTitle + ", Units: " + courseUnits;
    }

    // Getters and Setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCourseUnits() {
        return courseUnits;
    }

    public void setCourseUnits(int courseUnits) {
        this.courseUnits = courseUnits;
    }

    public Map<String, Integer> getStudentGrades() {
        return studentGrades;
    }
} 
