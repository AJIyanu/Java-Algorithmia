# Documentation: Course Enrollment and Grade Management System

## Introduction

### Program Name

**Course Enrollment and Grade Management System**

### Purpose

The Course Enrollment and Grade Management System is a Java-based console application designed for universities to efficiently manage course enrollments and student grades. This system empowers administrators and faculty members to enroll students in courses, assign grades, and calculate overall course grades for each student. It streamlines academic operations, minimizes errors, and provides accurate performance tracking.

### Target Audience

- **University Administrators**: To manage student enrollments and grade assignments.
- **Faculty Members**: To input and update course grades for students.
- **Students**: To monitor their academic progress through system-generated reports.
- **Developers**: To enhance the system with additional features or functionalities.

### Problem Statement

Managing course enrollments and grades using traditional manual systems is prone to delays, errors, and data inconsistencies. These inefficiencies hinder academic institutions from effectively tracking student performance and maintaining accurate records.

### Solution Overview

The Course Enrollment and Grade Management System offers an automated solution to handle student enrollments and grading processes. The program simplifies record management, enhances accuracy, and saves time by automating calculations of overall grades based on course performances.

## Features

1. **Enroll Students**: Add students to specific courses with unique student IDs.
2. **Assign Grades**: Record grades for enrolled students in their respective courses.
3. **Calculate Overall Grades**: Automatically compute cumulative grades for each student across all courses.
4. **List Enrollments and Grades**: Display enrolled students, their courses, and grades in a clear, organized format.
5. **Error Handling**: Validate inputs and provide error messages for invalid operations.

## System Requirements

- **Hardware**: Any system capable of running Java applications.
- **Software**:
  - Java Development Kit (JDK)

## Installation

### Setting Up Java

#### On Windows

1. Download and install the JDK from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk-downloads.html).
2. Add the `bin` directory of the JDK to the system’s `PATH` environment variable.
3. Verify installation by running `java -version` in the command prompt.

#### On Linux

1. Install the JDK using your package manager. For example:
   ```bash
   sudo apt update
   sudo apt install openjdk-11-jdk
   ```
2. Verify installation by running `java -version` in the terminal.

### Running the Program

1. Clone or download the repository from GitHub.
2. Extract the contents and navigate to the project folder.
3. Compile the program:
   ```bash
   javac cms/UniversityManagementSystem.java
   ```
4. Run the program:
   ```bash
   java cms.UniversityManagementSystem
   ```

## User Guide

1. Upon running the program, the console displays a list of available commands.
2. Enter integer values corresponding to the commands:
   - `1`: Add a new course (requires name and course code).
   - `2`: Add a new student (requires name only).
   - `3`: Enroll a student in a course (requires name/ID and course/course code).
   - `4`: Assign grades (requires name/ID, course/course code, and grade as an integer value).
   - `5`: Calculate a student's overall grades (requires student name).
   - `6`: Calculate all students' overall grades (displays formatted grades for all students).
   - `7`: Display a student’s performance details (requires student name).
   - `help`: Display the available options again.
   - `exit`: Exit the console.

### Example Workflow

#### Enrolling Students

- Enter `3` to enroll a student. Provide the student’s name, unique ID, and the course name.

#### Assigning Grades

- Enter `4` to assign grades. Provide the student’s unique ID, course name, and grade.

#### Calculating Overall Grades

- Enter `5` to calculate a student’s cumulative grade based on their course grades.

#### Listing Enrollments and Grades

- Enter `6` to display all students, their enrolled courses, and assigned grades in a human-readable format.

### Error Handling

- Invalid commands or inputs result in an error message, and the console re-displays the list of available commands.

## Architecture and Design

### Class Structure

1. **Student Class**:

   - **Attributes**: `id`, `name`, `courses` (list of enrolled courses).
   - **Methods**: Enroll in a course, retrieve course list, and calculate overall grade.

2. **Course Class**:

   - **Attributes**: `courseName`, `grades` (mapping of student IDs to grades).
   - **Methods**: Assign grades, retrieve grades for a student.

3. **CourseManagement Class**:

   - **Attributes**: Handles the console interface.
   - **Methods**: Manages `Student` and `Course` objects.

4. **Administrator Class**:

   - **Purpose**: Facilitates interaction with users via the command-line interface.

### Visual Representation

```plaintext
+-------------------------------+        +-------------+
| CourseManagement Class        |   <--- |Administrator|
+-------------------------------+        +-------------+
              |
              v
+-----------------+       +-----------------+
|     Student     |<----->|      Course     |
+-----------------+       +-----------------+
```

## Technologies Used

- **Programming Language**: Java
- **IDE**: Visual Studio Code or IntelliJ IDEA

## Benefits and Impact

### For Administrators

- Simplifies enrollment and grading workflows.
- Ensures data accuracy and minimizes manual errors.

### For Faculty Members

- Streamlines grade assignment.
- Provides a quick overview of student performance.

### For Students

- Offers clear, accurate performance records.
- Enables easy tracking of academic progress.

## Challenges and Limitations

### Challenges

- Handling large datasets with efficient performance.
- Addressing input validation issues for various scenarios.

### Limitations

- Limited to console-based interaction. Enhancements can include a GUI or web-based interface.
- No database integration; data is not persistent across sessions.

## Contribution Guide

1. Fork or clone the repository from GitHub.
2. Follow the coding standards outlined in the repository.
3. Submit pull requests with clear descriptions of the changes made.

## Acknowledgments

- Professors and mentors for their guidance in developing this system.

## Contact Information

- **GitHub**: [Your GitHub Profile Link]

