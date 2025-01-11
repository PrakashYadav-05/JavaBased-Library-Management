import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void testLibraryFunctions() {
        // Create an example library
        Library library = new Library();

        // Create example books and electronic resources
        Book book1 = new Book("123456789", "Book 1", new Author("Author1", "Author1Surname", "Address1"), null);
        Book book2 = new Book("987654321", "Book 2", new Author("Author2", "Author2Surname", "Address2"), null);

        ElectronicResource electronicResource1 = new ElectronicResource(true,"123456789",new Author("Adam","Doe","123 Main St, City"),new LibraryMember(0));
        ElectronicResource electronicResource2 = new ElectronicResource(false, "987654321",new Author("Eric","Smith","456 Oak St, Town"),new LibraryMember(1));

        // Test adding resources to the catalogue
        library.addResource(book1);
        library.addResource(book2);
        library.addResource(electronicResource1);
        library.addResource(electronicResource2);

        // Test printing library details
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("Library Catalogue Details:");
            library.printDetails();
        });

        // Test searching by title
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("Search Results for Title 'Book 1':");
            library.searchByTitle("Book 1");
        });

        // Test searching by author surname
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("Search Results for Author Surname 'Author2Surname':");
            library.searchByAuthorSurname("Author2Surname");
        });

        // Test removing a resource
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("Resource removed successfully.");
            library.removeResource(book1);
        });

        // Test removing a resource at a specific position
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("Resource is not in the catalogue.");
            library.removeResourceAtPosition(1);
        });

        // Test lending a book
        LibraryMember member = new LibraryMember(1);
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("Book lent successfully.");
            library.lendBook(book2, member);
        });

        // Test accepting book return
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("Book returned successfully.");
            library.acceptBookReturn(book2, true, "Torn pages");
        });

        // Test printing available books
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("Available Books:");
            library.printAvailableBooks();
        });

        // Test printing physical books details
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("Physical Books Details:");
            library.printPhysicalBooksDetails();
        });

        // Test printing electronic resources details
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("Electronic Resources Details:");
            library.printElectronicResourcesDetails();
        });
    }

    // Helper method to capture console output for assertions
    private void assertConsoleOutputContains(String expected) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Code that prints to System.out will now write to outputStream

        System.out.flush();
        System.setOut(originalOut);

        assertTrue(outputStream.toString().contains(expected));
    }
}
