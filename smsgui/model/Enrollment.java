package smsgui.model;

/**
 * Represents an enrollment record that links a student to a course with an assigned grade.
 * This class stores the relationship between a student and a course, including the grade achieved.
 */
public class Enrollment {
    private String studentId;
    private String courseCode;
    private int grade;

    /**
     * Constructs a new Enrollment object with the given student ID, course code, and grade.
     *
     * @param studentId The unique identifier of the student.
     * @param courseCode The unique code representing the course.
     * @param grade The grade assigned to the student for the course.
     */
    public Enrollment(String studentId, String courseCode, int grade) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.grade = grade;
    }

    /**
     * Gets the student ID associated with this enrollment.
     *
     * @return The student ID.
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Sets the student ID for this enrollment.
     *
     * @param studentId The new student ID.
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Gets the course code associated with this enrollment.
     *
     * @return The course code.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Sets the course code for this enrollment.
     *
     * @param courseCode The new course code.
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Gets the grade assigned to the student for this course.
     *
     * @return The grade.
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Sets the grade for this enrollment.
     *
     * @param grade The new grade.
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * Returns a string representation of the enrollment object.
     *
     * @return A string containing the student ID, course code, and grade.
     */
    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Course Code: " + courseCode + ", Grade: " + grade;
    }
} 

