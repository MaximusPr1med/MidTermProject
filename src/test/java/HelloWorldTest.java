import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class HelloWorldTest {

    @Test
    public void testAdd() {
        assertEquals(5.0, HelloWorld.add(2.0, 3.0));
        assertEquals(-1.0, HelloWorld.add(-2.0, 1.0));
    }

    @Test
    public void testSubtract() {
        assertEquals(1.0, HelloWorld.subtract(3.0, 2.0));
        assertEquals(-3.0, HelloWorld.subtract(2.0, 5.0));
    }

    @Test
    public void testMultiply() {
        assertEquals(6.0, HelloWorld.multiply(2.0, 3.0));
        assertEquals(-8.0, HelloWorld.multiply(-2.0, 4.0));
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, HelloWorld.divide(6.0, 3.0));
        assertThrows(ArithmeticException.class, () -> HelloWorld.divide(1.0, 0));
    }

    @Test
    public void testTellFunFact() throws Exception {
        // Use reflection to access the private method
        Method method = HelloWorld.class.getDeclaredMethod("tellFunFact");
        method.setAccessible(true);
        String fact = (String) method.invoke(null);

        // Ensure the method returns a non-null and non-empty string
        assertNotNull(fact);
        assertFalse(fact.isEmpty());
    }
}
