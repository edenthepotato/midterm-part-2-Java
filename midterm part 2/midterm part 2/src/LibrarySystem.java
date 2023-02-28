import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        final Library library = new Library();
        final Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Please select an option:");
            System.out.println("1. Add a book");
            System.out.println("2. List books");
            System.out.println("3. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (option) {
                case 1:
                    addBook(library, scanner);
                    break;
                case 2:
                    listBooks(library);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addBook(Library library, Scanner scanner) {
        System.out.println("Please enter the title:");
        String title = scanner.nextLine();

        System.out.println("Please enter the author:");
        String author = scanner.nextLine();

        System.out.println("Please enter the publisher:");
        String publisher = scanner.nextLine();

        System.out.println("Please enter the year:");
        int year = scanner.nextInt();

        System.out.println("Please enter the number of pages:");
        int pages = scanner.nextInt();

        scanner.nextLine(); // consume the newline character

        Book book = new Book(title, author, publisher, year, pages);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void listBooks(Library library) {
        library.listBooks();
    }

    private static class Book {
        private String title;
        private String author;
        private String publisher;
        private int year;
        private int pages;

        public Book(String title, String author, String publisher, int year, int pages) {
            this.title = title;
            this.author = author;
            this.publisher = publisher;
            this.year = year;
            this.pages = pages;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getPublisher() {
            return publisher;
        }

        public int getYear() {
            return year;
        }

        public int getPages() {
            return pages;
        }

        @Override
        public String toString() {
            return "Title: " + title + ", Author: " + author + ", Publisher: " + publisher + ", Year: " + year + ", Pages: " + pages;
        }
    }

    private static class Library {
        private ArrayList<Book> books = new ArrayList<>();

        public void addBook(Book book) {
            books.add(book);
        }

        public void listBooks() {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
