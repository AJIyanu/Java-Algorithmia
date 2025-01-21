import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    public void addBook(int quantity) {
        this.quantity += quantity;
    }

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

public class BasicLibrary {

    private static HashMap<String, Book> books = new HashMap<>();
    private static Map<String, Runnable> cmd = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    

    public static void main(String[] args) {

        //add commands
        cmd.put("Add Book", () -> BasicLibrary.addBook());
        cmd.put("Borrow Book", () -> BasicLibrary.borrowBook());
        cmd.put("Return Book", () -> BasicLibrary.returnBook());
        cmd.put("List Books", () -> BasicLibrary.listBooks());

        //welcome user
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
    
    public static void addBook() {
        System.out.println("What is the title of the book you are willing to add:");
        String title = scanner.nextLine();
        System.out.println("Who is the author of the book:");
        String author = scanner.nextLine();

        //handle error if user input not and integer
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
    
    public static void borrowBook() {
        System.out.println("What is the title of the book you are willing to borrow:");
        String title = scanner.nextLine();
        System.out.println("How many of this book are you willing to borrow:");
        int quantity = 0;

        //handle user input error
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

    public static void listBooks() {
        for (String title : books.keySet()) {
            System.out.println(title + " - " + books.get(title).getQuantity());
        }
    }

}