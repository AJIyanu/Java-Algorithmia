# Basic Library System

The **Basic Library System** is a simple Java-based console program that demonstrates how to manage a library's inventory of books. A "Basic Library System" refers to a foundational system that handles common library operations such as adding books, borrowing books, listing available books, and returning borrowed books.

This program is designed to:

- Allow users to add books to the library.
- Enable borrowing and returning books.
- Keep track of the available quantity of each book.
- Display the current inventory of books.

---

## Features and Commands

### 1. Add Books

- Prompts the user to enter the book title, author, and quantity.
- If the book already exists in the library, it updates the quantity.
- If the book is new, it adds the book to the library.

### 2. Borrow Books

- Prompts the user to enter the book title and the number of books to borrow.
- Checks if the requested number of books is available in the library.
- If the books are available, updates the quantity and displays a success message.
- If the books are not available, displays an error message.

### 3. Return Books

- Prompts the user to enter the book title and the number of books to return.
- Checks if the books being returned belong to the library system.
- If they belong, updates the quantity and displays a success message.
- If not, displays an error message.

### 4. List Books

- Displays all the books currently in the library along with their available quantity.

### 5. Exit

- Exits the program.

---

## Running the Program

### 1. Compile the Program

Navigate to the directory containing the `LibrarySystem.java` file and run:

```bash
javac LibrarySystem.java
```

### 2. Run the Program

Run the compiled program:

```bash
java LibrarySystem
```

---

Thank you for using the **Basic Library System**!
