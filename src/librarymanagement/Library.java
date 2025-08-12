package librarymanagement;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();

        // Pre-loaded books
        books.add(new Book("The Alchemist", "Paulo Coelho"));
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void issueBook(String title) {
        for (Book book : books) {
//            if (book.getTitle().equalsIgnoreCase(title) && !book.isIssued())   if using this line of code only search for = To Kill a Mockingbird (only book title)
            if (title.toLowerCase().contains(book.getTitle().toLowerCase()) && !book.isIssued()) {
                book.issue();
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not found or already issued.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isIssued()) {
                book.returnBook();
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }
}
