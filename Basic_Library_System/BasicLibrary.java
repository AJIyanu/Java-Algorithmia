package Basic_Library_System;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * Book class to represent a book with title, author, and quantity.
 * It provides methods to add books, borrow books, and display book details.
 * 
 */
class Book {
    private String title;
    private String author;
    private int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Adds the specified quantity of books to the current quantity.
     * @param quantity the quantity of books to add
     * 
     * returns void
     */
    public void addBook(int quantity) {
        this.quantity += quantity;
    }

    /**
     * Borrow the specified quantity of books if available.
     * 
     * @param quantity the quantity of books to borrow
     * @return true if the books were successfully borrowed, false otherwise
     */
    public boolean borrowBook(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Quantity: " + quantity;
    }
}

/**
 * BasicLibrary class to manage a collection of books.
 * It provides methods to add books, borrow books, return books, and list books.
 * 
 */
public class BasicLibrary {

    private static HashMap<String, Book> books = new HashMap<>();
    private static Map<String, Runnable> cmd = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        cmd.put("Add Book", () -> BasicLibrary.addBook());
        cmd.put("Borrow Book", () -> BasicLibrary.borrowBook());
        cmd.put("Return Book", () -> BasicLibrary.returnBook());
        cmd.put("List Books", () -> BasicLibrary.listBooks());

        System.out.println("Welcome to Basic Library System!\n");

        //Run Console Loop
        boolean isrunning = true;

        while (isrunning) {
            System.out.println("Please use any of these commands 'Add Book', 'Borrow Book', 'Return Book', 'Exit', 'List Books'");
            String command = scanner.nextLine();

            if (cmd.containsKey(command)) {
                cmd.get(command).run();
            } else if (command.equals("Exit")) {
                isrunning = false;
            } else if (command == null || command.trim().isEmpty()) {
                continue;
            } else {
                System.out.println("Please Enter a Valid Command!");
            }

            System.out.println("\n***************************************************************\n");
        }

    }

    /**
     * Adds a book to the library if new book
     * or adds quantity to the existing book
     * 
     * @return void
     */
    public static void addBook() {
        System.out.println("What is the title of the book you are willing to add:");
        String title = scanner.nextLine();
        System.out.println("Who is the author of the book:");
        String author = scanner.nextLine();

        boolean isInt = false;
        int quantity = 0;

        while (!isInt) {
            try {
                System.out.println("How many of this book are you willing to add:");
                quantity = scanner.nextInt();
                isInt = true;
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Quantity of book can only accept an integer value.");
                scanner.next();
            }
        }

        if (books.containsKey(title)) {
            books.get(title).addBook(quantity);
        } else {
            books.put(title, new Book(title, author, quantity));
        }

    }


    /**
     * Borrows a book from the library if available
     *
     * @return void
     */
    public static void borrowBook() {
        System.out.println("What is the title of the book you are willing to borrow:");
        String title = scanner.nextLine();
        System.out.println("How many of this book are you willing to borrow:");
        int quantity = 0;

        boolean isInt = false;
        while (!isInt) {
            try {
                quantity = scanner.nextInt();
                isInt = true;
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Quantity of book can only accept an integer value.");
                scanner.next();
            }
        }

        if (books.containsKey(title)) {
            if (!books.get(title).borrowBook(quantity)) {
                System.out.println("Sorry, we don't have enough of that book to lend.");
            } else {
                System.out.println("You have successfully borrowed " + quantity + " books titled - " + title);
            }

        } else {
            System.out.println("Sorry, we don't have that book in our library.");
        }
    }

    /**
     * Returns a book to the library
     * 
     * @return void
     */
    public static void returnBook() {
        System.out.println("What is the title of the book you are willing to return:");
        String title = scanner.nextLine();
        System.out.println("How many of this book are you willing to return:");
        int quantity = 0;
        boolean isInt = false;
        while (!isInt) {
            try {
                quantity = scanner.nextInt();
                isInt = true;
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Quantity of book can only accept an integer value.");
                scanner.next();
            }
        }
        if (books.containsKey(title)) {
            books.get(title).addBook(quantity);
            System.out.println("You have successfully returned " + quantity + " books titled - " + title);
        } else {
            System.out.println("Sorry, we don't have that book in our library.");
        }
    }

    /**
     * Lists all the books in the library
     * 
     * @return void
     */
    public static void listBooks() {
        for (String title : books.keySet()) {
            System.out.println(title + " - " + books.get(title).getQuantity());
        }
    }

}