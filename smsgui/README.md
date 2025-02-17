# **Student Management System – GUI Application (Java Swing/JavaFX)**

## **Introduction**

### **Program Overview**

The **Student Management System GUI Application** is a desktop-based system built using **Java Swing/JavaFX** to streamline the management of student records, course enrollments, and grade assignments. It provides a **user-friendly graphical interface** that allows administrators to efficiently **add, update, and view student records, enroll students in courses, and assign grades**.

The system is **event-driven**, with **real-time updates** to the interface whenever student records, enrollments, or grades are modified.

---

## **Key Features**

### **Student Management Functionality**

- **Add New Students**: Displays a form for entering student details and adding them to the system.
- **Update Student Information**: Provides a selection menu to choose a student and update their information.
- **View Student Details**: Displays a table or list showing student information (ID, name, age, and other details).
- **Event Handling**: Buttons and menu items trigger corresponding actions using event listeners.

### **Course Enrollment Functionality**

- **Enroll Students in Courses**: Allows selecting a student and enrolling them in a course.
- **Dropdown for Courses**: Lists available courses; selecting a course shows eligible students.
- **Student Selection for Enrollment**: Enables selecting a student from the list and confirming enrollment.

### **Grade Management Functionality**

- **Assign Grades**: Select a student and view their enrolled courses, then assign grades.
- **View Enrolled Courses & Grades**: Display current grades of the student and update upon grade assignment.

### **Dynamic Interface Updates**

- The **GUI reflects changes** immediately when:
  - A student is added, updated, or deleted.
  - A student is enrolled in a course.
  - A grade is assigned to a student.
- The **table views, dropdown menus, and course enrollment lists update in real time**.

---

## **Class Structure**

| **Class Name**            | **Purpose**                                                                                              |
| ------------------------- | -------------------------------------------------------------------------------------------------------- |
| `Student`                 | Represents a student (attributes: `id`, `name`, `age`, `email`, `List<Course>`).                         |
| `Course`                  | Represents a course (attributes: `code`, `name`, `List<Student>`).                                       |
| `Enrollment`              | Represents enrollment of a student in a course (attributes: `student`, `course`, `grade`).               |
| `StudentManagementSystem` | Backend logic: stores and manages students, courses, enrollments.                                        |
| `MainFrame`               | Main GUI window, containing tabs/panels for Student Management, Course Enrollment, and Grade Assignment. |
| `StudentPanel`            | GUI component to handle adding, updating, and viewing students.                                          |
| `CoursePanel`             | GUI component to handle course enrollments.                                                              |
| `GradePanel`              | GUI component to handle grade assignments.                                                               |
| `EventHandlers`           | Event listeners for buttons, dropdowns, and other UI components.                                         |

---

## **Detailed Explanation of Core Components**

### **Student Class**

- **Attributes**: `id` (String), `name` (String), `age` (int), `email` (String), `enrolledCourses` (List<Course>).
- **Methods**: Getters and setters for all attributes.

### **Course Class**

- **Attributes**: `code` (String), `name` (String), `enrolledStudents` (List<Student>).
- **Methods**: Getters and setters for all attributes.

### **Enrollment Class**

- **Attributes**: `student` (Student), `course` (Course), `grade` (String or int).
- **Methods**: Getters and setters.

### **StudentManagementSystem Class**

- **Static Variables**:
  - `List<Student> students`: Tracks all students.
  - `List<Course> courses`: Tracks all courses.
  - `List<Enrollment> enrollments`: Tracks all enrollments and grades.
- **Static Methods**:
  - `addStudent(Student student)`: Adds a student.
  - `updateStudent(Student student)`: Updates student details.
  - `getStudentById(String id)`: Retrieves a student by ID.
  - `addCourse(Course course)`: Adds a course.
  - `enrollStudent(Student student, Course course)`: Enrolls a student.
  - `assignGrade(Student student, Course course, String grade)`: Assigns a grade.
  - `getEnrolledCourses(Student student)`: Retrieves a student's enrolled courses.

### **MainFrame Class (GUI Entry Point)**

- **Purpose**: Initializes the GUI window with tabs or sections for:
  - Student Management (Add/Update/View)
  - Course Enrollment
  - Grade Assignment

### **StudentPanel Class**

- **Purpose**: Handles Student Management UI.
- **Key Components**:
  - Add Student Form (Text fields for `name`, `age`, `email`).
  - Update Student Form (Dropdown to select a student, fields for `name`, `age`, `email`).
  - View Students Table.

### **CoursePanel Class**

- **Purpose**: Handles Course Enrollment UI.
- **Key Components**:
  - Dropdown to select a course.
  - List of students available for enrollment.
  - Enroll Button.

### **GradePanel Class**

- **Purpose**: Handles Grade Assignment UI.
- **Key Components**:
  - Dropdown to select a student.
  - Table showing enrolled courses and current grades.
  - Assign Grade Input.

---

## **Event Handling and Dynamic Updates**

- **Event Listeners** attached to:
  - **Buttons** (Add, Update, Enroll, Assign Grade).
  - **Dropdown Menus** (Select Student, Select Course).
  - **Table Selections** (Select a row to view student details).
- **Dynamic Updates**:
  - After adding a student, the student table refreshes.
  - After enrollment, course enrollment lists update.
  - When a grade is assigned, the grade view updates.

---

## **Running the Program**

### **Prerequisites**

- **Java JDK**: Install JDK 11 or later.
- **IDE**: Recommended to use **IntelliJ IDEA** or **Eclipse** for GUI design.

### **Steps to Run**

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/student-management-system.git
   ```
2. **Navigate to the Project Folder**:
   ```bash
   cd student-management-system
   ```
3. **Compile the Program** (if not using an IDE):
   ```bash
   javac MainFrame.java
   ```
4. **Run the Program**:
   ```bash
   java MainFrame
   ```

---

## **Suggested Package Structure**

```
src/
│
├── model/
│   ├── Student.java
│   ├── Course.java
│   └── Enrollment.java
│
├── system/
│   └── StudentManagementSystem.java
│
├── gui/
│   ├── MainFrame.java
│   ├── StudentPanel.java
│   ├── CoursePanel.java
│   └── GradePanel.java
```

---

## **Future Enhancements**

- Persistent storage using a database.
- Export and import functionality for student records.
- Advanced performance analytics for students.

---

## **Contributing**

1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Make changes and commit:
   ```bash
   git commit -m "Add your feature"
   ```
4. Push to your branch:
   ```bash
   git push origin feature/your-feature-name
   ```
5. Open a pull request.

---

## **Acknowledgments**

- Java Swing and JavaFX Documentation.
- Open-source developer community.

---

## **Contact**

- **GitHub Profile**: [Your Profile URL]
- **Email**: your-email@example.com
