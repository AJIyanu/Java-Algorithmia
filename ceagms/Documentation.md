Here's a comprehensive README file based on your Java project, explaining the purpose, usage of each class, methods, and variables, describing static methods and variables, and providing instructions for running the program and interacting with the administrator interface.

---

# Course Enrollment and Grade Management System (CEAGMS)

## **Introduction**

### Program Purpose

The **Course Enrollment and Grade Management System (CEAGMS)** is a Java-based console application designed for university administrators and faculty. It facilitates the management of student enrollments in courses, assignment of grades, and calculation of overall grades for students. The system automates common tasks, reducing manual errors and improving efficiency.

---

## **Class Descriptions**

### **1. Administrator Class**

- **Purpose**: Handles the main administrator interface, accepting and executing commands.
- **Key Static Variables**:
  - `scanner`: For reading user input.
  - `commandList`: A `HashMap` mapping integers to command methods, enabling dynamic command handling.
- **Static Methods**:
  - `console()`: Runs the command-line interface loop.
  - `displayInputOptions(int level)`: Shows the available commands based on the interaction level.
  - `addNewstudent()`, `addNewCourse()`: Add new students or courses.
  - `enrollStudentInCourse()`: Enrolls a student in a course.
  - `assignGrade()`: Assigns a grade to a student in a course.
  - `studentGrade()`, `allStudentGrade()`: Display grade information for individual/all students.
  - `studenDetails()`: Displays details of a specific student.

---

### **2. Course Class**

- **Purpose**: Represents a course offered by the university.
- **Attributes**:
  - `name`: The course's name.
  - `code`: The course's unique identifier.
  - `maximumCapacity`: Max students allowed in the course.
  - `count`: Current number of enrolled students.
  - `enrolledStudent`: (Static) Tracks total enrollments across all courses.
- **Methods**:
  - `newEnrolledStudent()`: Updates enrollment counts.
  - Getters and setters for all attributes to manage course properties.

---

### **3. Student Class**

- **Purpose**: Represents a student and their course-related activities.
- **Attributes**:
  - `id`: Unique identifier for each student.
  - `name`: Name of the student.
  - `courses`: A `HashMap` mapping enrolled courses to their respective grades.
- **Methods**:
  - `enrollCourse(Course course)`: Enrolls the student in a course (validates capacity and duplicates).
  - `assignGrade(Course course, int grade)`: Assigns a grade to a student for a specific course.
  - `overallGrade()`: Calculates the average grade across all enrolled courses.
  - `studentGradeInfo()`: Displays detailed grade information for the student.

---

### **4. CourseManagement Class**

- **Purpose**: Serves as the backend for managing students and courses.
- **Key Static Variables**:
  - `courses`: A list of all available courses.
  - `students`: A list of all registered students.
- **Static Methods**:
  - `addCourse(String name, String code)`: Adds a new course to the system.
  - `addStudent(String name)`: Registers a new student.
  - `getStudent(String searchString)`, `getCourse(String searchString)`: Search for students or courses by name or ID/code.
  - `enrollStudentInCourse(Student student, Course course)`: Facilitates enrollment in courses.
  - `assignGrade(Student student, Course course, int grade)`: Records a student's grade.
  - `calculateOverallGrade(Student student)`: Computes a student's overall grade.
  - `allStudentGrade()`: Lists grades for all students.

---

## **How Static Variables and Methods Are Utilized**

- **Tracking Global Data**:
  - The `CourseManagement` class uses static lists (`courses` and `students`) to manage all instances of `Student` and `Course`, ensuring centralized control.
  - The `Course` class tracks total enrollments (`enrolledStudent`) across all course instances.
- **Dynamic Command Handling**:
  - The `Administrator` class uses a static `commandList` to map input commands to methods, ensuring flexibility and ease of updates.

---

## **Instructions for Running the Program**

### **Prerequisites**

1. **Java JDK**: Ensure the Java Development Kit (JDK) is installed on your machine.
   - Check installation with: `java -version`.

### **Steps**

1. **Compile the Program**:
   Navigate to the project directory and run:
   ```bash
   javac ceagms/Administrator.java
   ```
2. **Run the Program**:
   Execute the program:
   ```bash
   java ceagms.Administrator
   ```

---

## **Interacting with the Administrator Interface**

Upon launching the program:

1. You’ll see a list of commands:

   - `1`: Add a new course.
   - `2`: Add a new student.
   - `3`: Enroll a student in a course.
   - `4`: Assign grades.
   - `5`: Calculate a student's overall grades.
   - `6`: Calculate all students' overall grades.
   - `7`: Display a student’s performance details.
   - `help`: Display the command list again.
   - `exit`: Exit the program.

2. Enter the number corresponding to the desired command.
3. Follow on-screen prompts to provide required data.

---

## **Features Summary**

- **Add Courses**: Register new courses with unique names and codes.
- **Enroll Students**: Link students to specific courses.
- **Grade Assignment**: Assign and update grades for enrolled students.
- **Performance Reporting**: Generate detailed or summarized grade reports for students.

---

## **Future Enhancements**

- Add database integration for persistent storage.
- Develop a graphical user interface (GUI) for improved usability.
- Implement advanced analytics for performance tracking.

---

Let me know if you'd like to refine or extend this documentation! 🚀
