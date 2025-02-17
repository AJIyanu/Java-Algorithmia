package smsgui.gui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import smsgui.system.StudentManagementSystem;

/**
 * Represents the GUI panel for managing student grades.
 * Provides functionality to assign and view grades for students in enrolled courses.
 */
public class GradePanel extends VBox {

    private final ComboBox<String> studentComboBox = new ComboBox<>();
    private final ComboBox<String> courseComboBox = new ComboBox<>();
    private final TextField gradeField = new TextField();
    private final ListView<String> gradeListView = new ListView<>();

    /**
     * Constructs the GradePanel GUI component.
     * Initializes dropdowns, text field, buttons, and event handlers.
     */
    public GradePanel() {
        setSpacing(10);
        setPadding(new Insets(10));

        Label titleLabel = new Label("Grade Management Panel");

        gradeField.setPromptText("Enter Grade");

        Button assignGradeButton = new Button("Assign Grade");
        Button viewGradesButton = new Button("View Grades");

        getChildren().addAll(titleLabel, studentComboBox, courseComboBox, gradeField, assignGradeButton, viewGradesButton, gradeListView);

        assignGradeButton.setOnAction(e -> assignGrade());
        viewGradesButton.setOnAction(e -> viewGrades());

        loadStudents();
    }

    /**
     * Handles the logic for assigning a grade to a student for a specific course.
     */
    private void assignGrade() {
        String studentId = studentComboBox.getValue();
        String courseCode = courseComboBox.getValue();
        String gradeInput = gradeField.getText();

        if (studentId != null && courseCode != null && !gradeInput.isEmpty()) {
            try {
                int grade = Integer.parseInt(gradeInput);
                StudentManagementSystem.assignGrade(studentId, courseCode, grade);
                viewGrades();
                gradeField.clear();
            } catch (NumberFormatException e) {
                showAlert("Invalid Input", "Grade must be a valid integer.");
            }
        } else {
            showAlert("Incomplete Data", "Please select a student, a course, and enter a grade.");
        }
    }

    /**
     * Displays the current grades for enrolled students in the ListView.
     */
    private void viewGrades() {
        gradeListView.getItems().clear();
        StudentManagementSystem.getAllEnrollments().forEach(enrollment -> {
            gradeListView.getItems().add(enrollment.toString());
        });
    }

    /**
     * Loads the available students into the ComboBox.
     */
    private void loadStudents() {
        studentComboBox.getItems().clear();
        StudentManagementSystem.getAllStudents().forEach(student -> {
            studentComboBox.getItems().add(student.getStudentId());
        });

        studentComboBox.setOnAction(e -> loadCoursesForStudent());
    }

    /**
     * Loads the enrolled courses for the selected student into the course ComboBox.
     */
    private void loadCoursesForStudent() {
        String studentId = studentComboBox.getValue();
        courseComboBox.getItems().clear();
        if (studentId != null) {
            StudentManagementSystem.getStudentById(studentId).getEnrolledCourses().forEach(courseCode -> {
                courseComboBox.getItems().add(courseCode);
            });
        }
    }

    /**
     * Displays an alert dialog with the specified title and message.
     *
     * @param title   The title of the alert.
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

