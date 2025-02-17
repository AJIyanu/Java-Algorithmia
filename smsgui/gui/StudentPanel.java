package smsgui.gui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import smsgui.model.Student;
import smsgui.system.StudentManagementSystem;

/**
 * Represents the GUI panel for managing student records.
 * Provides functionality to add, update, and view students.
 */
public class StudentPanel extends VBox {

    private final TextField studentIdField = new TextField();
    private final TextField fullNameField = new TextField();
    private final TextField ageField = new TextField();
    private final TextField emailField = new TextField();
    private final ListView<String> studentListView = new ListView<>();

    /**
     * Constructs the StudentPanel GUI component.
     * Initializes form fields, buttons, and event handlers.
     */
    public StudentPanel() {
        setSpacing(10);
        setPadding(new Insets(10));

        Label titleLabel = new Label("Student Management Panel");

        studentIdField.setPromptText("Student ID");
        fullNameField.setPromptText("Full Name");
        ageField.setPromptText("Age");
        emailField.setPromptText("Email");

        Button addButton = new Button("Add Student");
        Button updateButton = new Button("Update Student");
        Button viewButton = new Button("View Students");

        getChildren().addAll(titleLabel, studentIdField, fullNameField, ageField, emailField, addButton, updateButton, viewButton, studentListView);

        addButton.setOnAction(e -> addStudent());
        updateButton.setOnAction(e -> updateStudent());
        viewButton.setOnAction(e -> viewStudents());
    }

    /**
     * Handles the logic for adding a new student to the system.
     * Collects input values and creates a new Student object.
     */
    private void addStudent() {
        String studentId = studentIdField.getText();
        String fullName = fullNameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String email = emailField.getText();

        Student student = new Student(studentId, fullName, age, email);
        StudentManagementSystem.addStudent(student);
        clearFields();
        viewStudents();
    }

    /**
     * Handles the logic for updating an existing student's information.
     * Updates the student's details based on the ID.
     */
    private void updateStudent() {
        String studentId = studentIdField.getText();
        String fullName = fullNameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String email = emailField.getText();

        Student student = new Student(studentId, fullName, age, email);
        StudentManagementSystem.updateStudent(student);
        clearFields();
        viewStudents();
    }

    /**
     * Retrieves all students from the system and displays them in the ListView.
     */
    private void viewStudents() {
        studentListView.getItems().clear();
        for (Student student : StudentManagementSystem.getAllStudents()) {
            studentListView.getItems().add(student.toString());
        }
    }

    /**
     * Clears the input fields.
     */
    private void clearFields() {
        studentIdField.clear();
        fullNameField.clear();
        ageField.clear();
        emailField.clear();
    }
}
