import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryMemberTest {

    @Test
    public void testLibraryMemberFunctions() {
        // Create an example library member
        LibraryMember member = new LibraryMember(1);

        // Create example books
        Book book1 = new Book("123456789", "Book 1", new Author("Author1", "Author1Surname", "Address1"), null);
        Book book2 = new Book("987654321", "Book 2", new Author("Author2", "Author2Surname", "Address2"), null);

        // Test the getter method
        assertEquals(1, member.getMemberId());

        // Test borrowing a book
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("Book 'Book 1' added to the borrowed books list.");
            member.borrowBook(book1);
        });

        // Test borrowing the same book again
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("Book 'Book 1' is already in the borrowed books list.");
            member.borrowBook(book1);
        });

        // Test the printDetails method (capturing the console output for assertion)
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("Library Member ID: 1");
            assertConsoleOutputContains("Books Currently Borrowed:");
            assertConsoleOutputContains("- Book 1");
            member.printDetails();
        });

        // Test the getNumberOfBooksBorrowed method
        assertEquals(1, member.getNumberOfBooksBorrowed());

        // Test borrowing another book
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("Book 'Book 2' added to the borrowed books list.");
            member.borrowBook(book2);
        });

        // Test the getNumberOfBooksBorrowed method after borrowing another book
        assertEquals(2, member.getNumberOfBooksBorrowed());
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
