package smsgui.gui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import smsgui.model.Course;
import smsgui.model.Student;
import smsgui.system.StudentManagementSystem;

/**
 * Represents the GUI panel for managing course enrollments.
 * Provides functionality to enroll students in courses.
 */
public class CoursePanel extends VBox {

    private final ComboBox<String> courseComboBox = new ComboBox<>();
    private final ComboBox<String> studentComboBox = new ComboBox<>();
    private final ListView<String> enrollmentListView = new ListView<>();

    /**
     * Constructs the CoursePanel GUI component.
     * Initializes dropdowns, buttons, and event handlers.
     */
    public CoursePanel() {
        setSpacing(10);
        setPadding(new Insets(10));

        Label titleLabel = new Label("Course Enrollment Panel");

        Button enrollButton = new Button("Enroll Student");
        Button viewEnrollmentsButton = new Button("View Enrollments");

        getChildren().addAll(titleLabel, courseComboBox, studentComboBox, enrollButton, viewEnrollmentsButton, enrollmentListView);

        enrollButton.setOnAction(e -> enrollStudent());
        viewEnrollmentsButton.setOnAction(e -> viewEnrollments());

        loadCourses();
        loadStudents();
    }

    /**
     * Handles the logic for enrolling a student in a selected course.
     */
    private void enrollStudent() {
        String courseCode = courseComboBox.getValue();
        String studentId = studentComboBox.getValue();

        if (courseCode != null && studentId != null) {
            StudentManagementSystem.enrollStudent(studentId, courseCode, 0);
            viewEnrollments();
        } else {
            showAlert("Enrollment Failed", "Please select both a course and a student.");
        }
    }

    /**
     * Displays the current course enrollments in the ListView.
     */
    private void viewEnrollments() {
        enrollmentListView.getItems().clear();
        StudentManagementSystem.getAllEnrollments().forEach(enrollment -> {
            enrollmentListView.getItems().add(enrollment.toString());
        });
    }

    /**
     * Loads the available courses into the ComboBox.
     */
    private void loadCourses() {
        courseComboBox.getItems().clear();
        StudentManagementSystem.getAllCourses().forEach(course -> courseComboBox.getItems().add(course.getCourseCode()));
    }

    /**
     * Loads the available students into the ComboBox.
     */
    private void loadStudents() {
        studentComboBox.getItems().clear();
        StudentManagementSystem.getAllStudents().forEach(student -> studentComboBox.getItems().add(student.getStudentId()));
    }

    /**
     * Displays an alert dialog with the specified title and message.
     *
     * @param title The title of the alert.
     * @param message The message to display.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

