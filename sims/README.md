# Documentation: Student Information Management Scheme (SIMS)

## Introduction

### Program Name

**Student Information Management Scheme (SIMS)**

### Purpose

SIMS is a mini console application designed to efficiently manage students' data with a focus on data integrity and ease of use. Users can seamlessly add new students, edit existing details such as name, age, and grade, and list all students in a clear, organized format. This program not only simplifies data management but also provides a robust solution to the inefficiencies of traditional paper filing systems. By combining simplicity with effective data handling, SIMS ensures accuracy, reduces administrative overhead, and enhances the overall workflow for educational institutions.

### Target Audience

- **Students**: Aspiring developers looking to learn and practice Java programming can study and improve the application.
- **Institutions**: Schools or administrators who require a foundational tool to manage student data.
- **Developers**: Those who wish to enhance the program by adding new features or functionalities.

### Problem Statement

The increasing number of admitted students has rendered traditional paper filing systems ineffective. Manual systems are prone to delays in processing, data loss, and human error. This inefficiency has created a need for a reliable and automated solution to handle student information management effectively.

### Solution Overview

SIMS offers a Java-based mini application to store and manage student data. The program simplifies adding, editing, and listing student information while ensuring data integrity and reducing processing time. It presents student data in a human-readable format and streamlines administrative workflows.

## Features

1. **Add Student**: Input the student's name and age; the grade is set to 0 by default, and a unique ID is automatically generated.
2. **Update Student Information**: Modify existing student details, including name, age, or grade.
3. **List All Students**: View all registered students in a clear, human-readable format.

## System Requirements

- **Hardware**: Any system capable of compiling and running Java applications.
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
2. Extract the contents and navigate to the **Java-Algorithmia** folder.
3. Compile the program from the root directory:
   ```bash
   javac sims/AdministratorInterfaceConsole.java
   ```
4. Run the program from the root directory:
   ```bash
   java sims.AdministratorInterfaceConsole
   ```

## User Guide

1. Upon running the program, the console displays a list of available commands.
2. Enter integer values corresponding to the commands:
   - `1`: Add a new student.
   - `2`: Update student information.
   - `3`: List all students.
   - `4`: Exit the program.
   - `help`: Display the command list again.

### Updating Student Information

- After selecting `2` (Update Student Info), the console displays a submenu:
  - `1`: Update name.
  - `2`: Update age.
  - `3`: Update grade.
- Enter the appropriate command number and provide the requested data.
- Data like age and grade only accept integers. Invalid inputs result in an error, and the console exits the command.

### Error Handling

- Invalid commands or inputs result in an error message, and the console re-displays the list of available commands.

## Architecture and Design

### Class Structure

1. **Student Class**:

   - Attributes: `id`, `name`, `age`, `grade`.
   - Methods: Store and retrieve student data, auto-generate a unique student ID.

2. **StudentManagement Class**:

   - Stores the list of students and their count.
   - Performs operations such as adding, updating, and listing students.

3. **AdministratorInterfaceConsole Class**:

   - Handles the console interface.
   - Interacts with `StudentManagement` to perform operations.

### Visual Representation

```plaintext
+-----------------------------+
|  AdministratorInterfaceConsole |
+-----------------------------+
              |
              v
+-----------------+       +------------------+
| StudentManagement |<---->|     Student       |
+-----------------+       +------------------+
```

## Technologies Used

- **Programming Language**: Java
- **IDE**: Visual Studio Code

## Benefits and Impact

### For Investors

In Nigeria, educational institutions (from secondary to tertiary levels) increasingly seek digital solutions for student management. Investing in this project provides a practical solution for institutions willing to adopt efficient management systems.

### For Employers and Lecturers

This program demonstrates:

- Proficiency in Java programming.
- The ability to solve real-world problems with maintainable and readable code.
- Implementation of coding best practices and optimizations to enhance performance, such as minimizing nested loops, efficient data handling, and reusing objects to reduce overhead.

### For Students

Working on this project sharpens development skills, encourages creativity, and provides hands-on experience in solving practical problems using Java.

## Challenges and Limitations

### Challenges

- Debugging input issues with the `Scanner` class: Scanner leaves a `\n` after reading integers, which caused unexpected behavior in subsequent inputs. This was resolved by clearing the `\n` buffer before the next iteration.

### Limitations

- The project is limited to the current specifications. However, developers can extend the functionality by adding features like database integration, GUI, or user authentication.

## Contribution Guide

1. Fork or clone the repository from GitHub.
2. Adhere to the coding standards and guidelines provided in the repository.
3. Submit pull requests with clear descriptions of the changes made.

## Acknowledgments

- My lecturers for their guidance and inspiration.

## Contact Information

- **GitHub**: [Your GitHub Profile Link]
