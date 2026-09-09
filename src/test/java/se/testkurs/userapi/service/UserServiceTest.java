package se.testkurs.userapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.testkurs.userapi.exception.InvalidEmailException;
import se.testkurs.userapi.exception.UserAlreadyExistsException;
import se.testkurs.userapi.exception.UserNotFoundException;
import se.testkurs.userapi.model.User;
import se.testkurs.userapi.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Test
    void registerUser_ValidData_shouldSaveUser(){
       //Arrange
        //1L används för id i test för att enklare se att det tillhör testet.
       User saveUser = new User(1L, "anna", "anna@test.com", "password");
       when(userRepository.findByEmail("anna@test.com")).thenReturn(Optional.empty());
       when(userRepository.save(any(User.class))).thenReturn(saveUser);
       //Act
        User result = userService.registerUser("anna", "anna@test.com", "password");
       //assert
        assertEquals("anna", result.getUsername());
        assertEquals("anna@test.com", result.getEmail());
        assertEquals("anna", result.getUsername());
        assertEquals(1L, result.getId());
    }
    @Test
    void registerUser_DuplicateEmail_ShouldThorwException(){
        //Arrange
        User existing = new User(1l, "excisting", "john@test.com", "password");
        when(userRepository.findByEmail("john@test.com")).thenReturn(Optional.of(existing));

        assertThrows(UserAlreadyExistsException.class, () -> userService.registerUser("john","john@test.com","password" ));
        verify(userRepository).findByEmail("john@test.com");
        verify(userRepository, never()).save(any(User.class));
    }
    @Test
    void registerUser_InvalidEmail_ShouldThrowException(){
        assertThrows(InvalidEmailException.class, () -> userService.registerUser("anna", "annatest.com", "password"));
        verifyNoInteractions(userRepository); // säkerställer noll anrop. Kollar så att inget överhuvudtaget anropades på objektet under testet.
    }
    @Test
    void findUserByEmail_ExistingUser(){
        //arrange
        User exsistinguser = new User(1L, "jerran", "Jerran@test.com", "password");
        when(userRepository.findByEmail("Jerran@test.com")).thenReturn(Optional.of(exsistinguser));

        User result = userService.findUserByEmail("Jerran@test.com");
        //act
        //Assert
        assertEquals("Jerran@test.com", result.getEmail());
        verify(userRepository).findByEmail("Jerran@test.com");
    }
    @Test
    void findUserByEmail_NonExistingUser_ShouldReturnNull(){
        when(userRepository.findByEmail("Jerran@test.com")).thenReturn(Optional.empty());
        User result = userService.findUserByEmail("Jerran@test.com");
        assertNull(result);
        verify(userRepository).findByEmail("Jerran@test.com");
    }


























    @Test
    //HappyPath TEST
    void getUserById_ShouldReturnUser_WhenInputId(){
        //Arrange
        User user1 = new User(1L ,"Jerran", "Jerrie@Test.com","Password" );

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user1));
        //Act
        User result = userService.getUserById(1L);

        //Assert
        assertEquals("Jerran", result.getUsername());
        verify(userRepository).findById(1L);


    }
    @Test
    void getUserById_ShouldThrowException_whenNoIdFound(){
        //Arrange
       when(userRepository.findById(2L)).thenReturn(Optional.empty());
       //Act-Assert
        assertThrows(UserNotFoundException.class, () -> userService.getUserById(2L));
    }















    @Test
    void getAllUsers_ShouldReturnUsers_WhenCalled(){
        //arrange
        User user = new User (1L, "test", "test@test.com","password" );
        when(userRepository.findAll()).thenReturn(List.of(user));
        //act
        List<User> result = userService.getAllUsers();
        //Assert
        assertEquals(user, result.getFirst());
        verify(userRepository).findAll();
        }

    @Test

        void ShouldReturnAllUser_WhenGetAllUserMethodIsCalled(){
            User user = new User(1L,"Jerran", "Test@test.com", "Password" );
            when(userRepository.findAll()).thenReturn(List.of(user));
            List <User> result = userService.getAllUsers();
            assertEquals(user, result.getFirst()); //Best praxis for assertEquals in this case
            assertEquals(user.getUsername(), result.getFirst().getUsername()); // Only test one field and leave to much
            assertEquals("User{id=1, username='Jerran', email='test@Test.com'}", result.getFirst()); // Worst case. Does not follow "dont test implentation details" Hard codede strings is too sensitive and break easy.
            verify(userRepository).findAll();
        }

    @Test
    void getUserById_ShouldThrowException_WhenNoIdFound(){
            when(userRepository.findById(null)).thenThrow(UserNotFoundException.class);
            assertThrows(UserNotFoundException.class, () -> userService.getUserById(null));
    }

    @Test
    void getUserById_shouldReturnUser_WhenIdIsFound(){
        User user = new User(1L, "Jerran", "Test@test.com","password");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        User result = userService.getUserById(1L);
        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.getId(), result.getId());


        assertEquals(user, result);
    }
}
