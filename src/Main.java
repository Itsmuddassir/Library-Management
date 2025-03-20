public abstract class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void borrowBook(Book book);
}
public abstract class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void borrowBook(Book book);
}

public class Student extends User {
    public Student(String name) {
        super(name);
    }

    @Override
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println(getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is not available.");
        }
    }
}

public class Teacher extends User {
    public Teacher(String name) {
        super(name);
    }

    @Override
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println(getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is not available.");
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    private List<Book> books;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user type (student/teacher): ");
        String userType = scanner.nextLine();
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        User user;
        if (userType.equalsIgnoreCase("student")) {
            user = new Student(name);
        } else {
            user = new Teacher(name);
        }

        library.showAvailableBooks();

        System.out.println("Enter the title of the book you want to borrow: ");
        String bookTitle = scanner.nextLine();

        for (Book book : library.books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                user.borrowBook(book);
                break;
            }
        }

        scanner.close();
    }
}
