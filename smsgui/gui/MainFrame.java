package smsgui.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 * Main application window for the Student Management System.
 * Integrates StudentPanel, CoursePanel, and GradePanel into a tabbed interface.
 */
public class MainFrame extends Application {

    /**
     * Starts the primary stage (window) and sets up the tabbed interface.
     *
     * @param primaryStage The main stage for the application.
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Management System");

        TabPane tabPane = new TabPane();

        Tab studentTab = new Tab("Students", new StudentPanel());
        Tab courseTab = new Tab("Courses", new CoursePanel());
        Tab gradeTab = new Tab("Grades", new GradePanel());

        studentTab.setClosable(false);
        courseTab.setClosable(false);
        gradeTab.setClosable(false);

        tabPane.getTabs().addAll(studentTab, courseTab, gradeTab);

        Scene scene = new Scene(tabPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Launches the JavaFX application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
