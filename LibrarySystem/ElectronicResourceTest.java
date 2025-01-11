import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElectronicResourceTest {

    @Test
    public void testElectronicResourceDetails() {
        // Create an example electronic resource
        ElectronicResource electronicResource = new ElectronicResource(true,"JavaBook",new Author("John","D'mello","Glasgiow"),new LibraryMember(1));

        // Test the getter method
        assertTrue(electronicResource.isCanDownload());

        // Test the setter method
        electronicResource.setCanDownload(false);
        assertFalse(electronicResource.isCanDownload());

        // Test the printDetails method (capturing the console output for assertion)
        assertDoesNotThrow(() -> {
            assertConsoleOutputContains("Can Download: false");
            electronicResource.printDetails();
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