import java.util.ArrayList;
import java.util.List;
/**
 * A class Book that hold inheriantance method of PrimaryResourse .
 */
public class Book extends PrimaryResourse
{
    private String ISBN;
    private List<String> damages;
    // Constructors
    public Book(String ISBN, String title, Author author, LibraryMember libraryMember) {
        super(title,author,libraryMember);
        this.ISBN = ISBN;
        this.damages = new ArrayList<>();
    }
    // Getter and setter methods
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public List<String> getDamages() {
        return damages;
    }

    public void setDamages(List<String> damages) {
        this.damages = damages;
    }

    // Method to check if the book is available
    public boolean isAvailable() {
        return this.getLibraryMember() == null;
    }
    // Method to print all details of the book
    public void printDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + getTitle());

        if (this.getAuthor() != null) {
            System.out.println("Author: " + getAuthor().toString());
        } else {
            System.out.println("Author: Not specified");
        }

        if (this.getLibraryMember() != null) {
            System.out.println("Currently Borrowed by: " + this.getLibraryMember().toString());
        } else {
            System.out.println("Available for Borrowing");
        }

        System.out.println("Damages: " + damages.toString());
    }
    // Method to add damage to the damages list
    public void addDamage(String damage) {
        damages.add(damage);
    }
    // Main Method for Testing
    public static void main(String[] args) {
        // Create an example author
        Author author = new Author("John", "Doe", "123 Main St, City");

        // Create an example library member
        LibraryMember member = new LibraryMember(1);

        // Create an example book
        Book book = new Book("123456789", "Sample Book", author, null);

        // Print details of the book before any changes
        System.out.println("Book Details Before Changes:");
        book.printDetails();

        // Update book details
        book.setISBN("987654321");
        book.setTitle("Updated Book Title");
        book.setAuthor(new Author("Jane", "Smith", "456 Oak St, Town"));
        book.setLibraryMember(member);
        book.addDamage("Torn pages");

        // Print details of the book after changes
        System.out.println("\nBook Details After Changes:");
        book.printDetails();
    }
}
