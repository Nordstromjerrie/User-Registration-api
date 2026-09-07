package se.testkurs.userapi;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import se.testkurs.userapi.model.User;
import se.testkurs.userapi.repository.UserRepository;
import se.testkurs.userapi.service.UserService;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

/**
 * Enda testet som redan finns i basprojektet - kontrollerar bara att
 * Spring-kontexten startar. Alla ovriga tester (enhet, komponent,
 * integration) skrivs av eleverna under kursens veckor, enligt
 * Learnpoint-ovningarna.
 */
@SpringBootTest
class UserRegistrationApiApplicationTests {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    @Test
    void contextLoads() {
        // Om denna test gar igenom startar hela applikationen korrekt.
    }




}
