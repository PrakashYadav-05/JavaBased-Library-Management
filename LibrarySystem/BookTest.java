import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookDetails() {
        // Create an example author
        Author author = new Author("John", "Doe", "123 Main St, City");

        // Create an example library member
        LibraryMember libraryMember = new LibraryMember(1);

        // Create an example book
        Book book = new Book("123456789", "Sample Book", author, libraryMember);

        // Test the getter methods
        assertEquals("123456789", book.getISBN());
        assertEquals("Sample Book", book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(libraryMember, book.getLibraryMember());
        assertEquals(0, book.getDamages().size());

        // Test isAvailable method
        assertTrue(book.isAvailable());

        // Test the printDetails method (capturing the console output for assertion)
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("ISBN: 123456789");
            assertConsoleOutputContains("Title: Sample Book");
            assertConsoleOutputContains("Author: John Doe");
            assertConsoleOutputContains("Currently Borrowed by: Library Member ID: 1");
            assertConsoleOutputContains("Damages: []");
            book.printDetails();
        });

        // Add damage to the book
        book.addDamage("Torn pages");
        book.addDamage("Coffee stain");

        // Test the damages list
        assertEquals(2, book.getDamages().size());

        // Test the printDetails method after adding damages
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("Damages: [Torn pages, Coffee stain]");
            book.printDetails();
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