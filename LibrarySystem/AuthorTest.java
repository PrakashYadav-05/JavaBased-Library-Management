import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthorTest {

    @Test
    public void testAuthorDetails() {
        // Create an example author
        Author author = new Author("John", "Doe", "123 Main St, City");

        // Test the getter methods
        assertEquals("John", author.getFirstName());
        assertEquals("Doe", author.getSurname());
        assertEquals("123 Main St, City", author.getAddress());

        // Test the printDetails method (capturing the console output for assertion)
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("John Doe");
            assertConsoleOutputContains("123 Main St, City");
            author.printDetails();
        });

        // Update author details
        author.setAddress("456 Oak St, Town");

        // Test the setter methods
        assertEquals("456 Oak St, Town", author.getAddress());

        // Test the printDetails method after the update
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("John Doe");
            assertConsoleOutputContains("456 Oak St, Town");
            author.printDetails();
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