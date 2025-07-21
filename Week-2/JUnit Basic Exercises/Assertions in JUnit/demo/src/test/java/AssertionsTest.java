import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertEquals() {
        assertEquals(5, 2 + 3);
    }

    @Test
    public void testAssertTrue() {
        assertTrue(5 > 3);
    }

    @Test
    public void testAssertFalse() {
        assertFalse(5 < 3);
    }

    @Test
    public void testAssertNull() {
        assertNull(null);
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull(new Object());
    }

    @Test
    public void testAssertSame() {
        String str = "JUnit";
        assertSame(str, "JUnit"); // same reference in string pool
    }

    @Test
    public void testAssertNotSame() {
        String str = "JUnit";
        assertNotSame(str, new String("JUnit")); // different objects
    }
}
