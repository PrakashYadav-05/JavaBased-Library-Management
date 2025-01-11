

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PrimaryResourseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PrimaryResourseTest
{
    /**
     * Default constructor for test class PrimaryResourseTest
     */
    public PrimaryResourseTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    public void testConstructor() {
        Author author = new Author("Adam", "Smit", "42 Main St");

        PrimaryResourse actualPrimaryResourse = new PrimaryResourse("Dr", author, new LibraryMember(1));
        Author author2 = new Author("Adam", "Smit", "42 Main St");

        actualPrimaryResourse.setAuthor(author2);
        LibraryMember libraryMember = new LibraryMember(1);
        actualPrimaryResourse.setLibraryMember(libraryMember);
        actualPrimaryResourse.setTitle("Dr");
        Author actualAuthor = actualPrimaryResourse.getAuthor();
        LibraryMember actualLibraryMember = actualPrimaryResourse.getLibraryMember();
        assertEquals("Dr", actualPrimaryResourse.getTitle());
        assertSame(author2, actualAuthor);
        assertSame(libraryMember, actualLibraryMember);
    }
}

