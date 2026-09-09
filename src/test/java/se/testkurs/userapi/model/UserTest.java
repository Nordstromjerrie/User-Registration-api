package se.testkurs.userapi.model;


import org.junit.jupiter.api.Test;
import se.testkurs.userapi.model.User;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class UserTest {
    @Test
    void constructorSetUserFields(){
        User user = new User("anna", "anna@test.com", "password");
        assertNotNull(user);

       assertEquals("anna", user.getUsername());
       assertEquals("anna@test.com", user.getEmail());
       assertEquals("password", user.getPassword());
    }
}