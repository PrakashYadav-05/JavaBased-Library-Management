import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class LibraryMember here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LibraryMember
{
    // instance variables - replace the example below with your own
    private int memberId;
    private List<Book> borrowedBooks;

    // Constructors
    public LibraryMember(int memberId) {
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
        // Initialize other data fields if needed
    }

    // Getter and setter methods
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Method to print all details of a library member
    public void printDetails() {
        System.out.println("Library Member ID: " + memberId);
        System.out.println("Books Currently Borrowed:");
        printBorrowedBooks();
    }

    // Method to borrow a book
    public void borrowBook(Book book) {
        // Check if the book is already in the list
        if (!borrowedBooks.contains(book)) {
            borrowedBooks.add(book);
            System.out.println("Book '" + book.getTitle() + "' added to the borrowed books list.");
        } else {
            System.out.println("Book '" + book.getTitle() + "' is already in the borrowed books list.");
        }
    }

    // Method to print details of all books currently borrowed
    public void printBorrowedBooks() {
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getTitle());
        }
    }

    // Method to return the number of books currently borrowed
    public int getNumberOfBooksBorrowed() {
        return borrowedBooks.size();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create an example library member
        LibraryMember member = new LibraryMember(1);

        // Create example books
        Book book1 = new Book("123456789", "Book 1", new Author("Author1", "Author1Surname", "Address1"), null);
        Book book2 = new Book("987654321", "Book 2", new Author("Author2", "Author2Surname", "Address2"), null);

        // Test the functionality
        member.borrowBook(book1);
        member.borrowBook(book2);

        member.printDetails();
        System.out.println("Number of books borrowed: " + member.getNumberOfBooksBorrowed());
    }
}
