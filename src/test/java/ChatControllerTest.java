import com.mt.controller.ChatController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChatControllerTest {

    private ChatController chatController;

    @BeforeEach
    public void setUp() {
        chatController = new ChatController();
    }

    @Test
    public void testGreet() {
        String response = chatController.greet();
        assertEquals("Hello, World! How are you today? (respond with 'good', 'bad', or 'okay')", response);
    }

    @Test
    public void testRespondGood() {
        String response = chatController.respond("good");
        assertEquals("I'm glad to hear that! What would you like to do today?", response);
    }

    @Test
    public void testMathAdd() {
        String response = chatController.performMath("add", 2, 3);
        assertEquals("The sum of 2.0 and 3.0 is 5.0.", response);
    }

    @Test
    public void testTellFunFact() {
        String fact = chatController.tellFunFact();
        assertNotNull(fact);
        assertFalse(fact.isEmpty());
    }
}
