

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class VisitorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VisitorTest
{
    /**
     * Default constructor for test class VisitorTest
     */
    public VisitorTest()
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

    @Test
    public void testConstructor()
    {
        Visitor visitor2 = new Visitor("Eric", "Math", 2);
        visitor2.setTimeDuration(3);
        visitor2.setTimeDuration(3);
        assertEquals(2, visitor2.getTimeDuration(3));
        assertEquals(5, visitor2.getTimeDuration(1));
    }
}

