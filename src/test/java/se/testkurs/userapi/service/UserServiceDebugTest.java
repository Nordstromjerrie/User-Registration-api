package se.testkurs.userapi.service;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceDebugTest {

    @Test
    void additionShouldBeTen() {
        int result = 5 + 4;

        assertEquals(10, result);
    }

    @Test
    void stringShouldMatch() {
        String username = "jerrie";

        assertEquals("Jerry", username);
    }

    @Test
    void valueShouldBeTrue() {
        boolean loggedIn = false;

        assertTrue(loggedIn);
    }

    @Test
    void numbersShouldBeDifferent() {
        int first = 10;
        int second = 10;

        assertNotEquals(first, second);
    }

    @Test
    void correctUserId() {
        int userId = 42;

        assertEquals(42, userId);
    }
}