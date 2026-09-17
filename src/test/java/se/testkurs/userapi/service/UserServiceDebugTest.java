package se.testkurs.userapi.service;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceDebugTest {

    @Test
    void additionShouldBeTen() {
        int result = 5 + 4;

        assertEquals(9, result);
    }

    @Test
    void stringShouldMatch() {
        String username = "jerrie";

        assertEquals("jerrie", username);
    }

    @Test
    void valueShouldBeTrue() {
        boolean loggedIn = true;

        assertTrue(loggedIn);
    }

    @Test
    void numbersShouldBeDifferent() {
        int first = 10;
        int second = 9;

        assertNotEquals(first, second);
    }

    @Test
    void correctUserId() {
        int userId = 42;

        assertEquals(42, userId);
    }
}