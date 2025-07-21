import com.example.StringUtils;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void testCapitalizeNormalWord() {
        StringUtils utils = new StringUtils();
        String result = utils.capitalizeFirstLetter("hello");
        assertEquals("Hello", result);
    }

    @Test
    public void testCapitalizeEmptyString() {
        StringUtils utils = new StringUtils();
        String result = utils.capitalizeFirstLetter("");
        assertEquals("", result);
    }

    @Test
    public void testCapitalizeNull() {
        StringUtils utils = new StringUtils();
        String result = utils.capitalizeFirstLetter(null);
        assertNull(result);
    }

    @Test
    public void testCapitalizeAlreadyCapitalized() {
        StringUtils utils = new StringUtils();
        String result = utils.capitalizeFirstLetter("Java");
        assertEquals("Java", result);
    }
}
