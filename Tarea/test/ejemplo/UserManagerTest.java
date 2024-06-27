package ejemplo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserManagerTest {
    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        userManager = new UserManager();
    }

    @AfterEach
    public void tearDown() {
        userManager = null;
    }

    @Test
    public void testAddUser() {
        User user = new User("1", "Juan Pérez", "Departamento X", "Usuario de prueba");
        userManager.addUser(user);
        assertEquals(1, userManager.getUsers().size());
    }

    @Test
    public void testAddDuplicateUser() {
        User user1 = new User("1", "Juan", "Departamento", "Descripción");
        User user2 = new User("1", "Pedro", "Otro departamento", "Otra descripción");
        userManager.addUser(user1);
        assertFalse(userManager.addUser(user2));
    }

    @Test
    public void testGetUserById() {
        User user = new User("1", "Juan Pérez", "Departamento X", "Usuario de prueba");
        userManager.addUser(user);
        User retrievedUser = userManager.getUserById("1");
        assertNotNull(retrievedUser);
        assertEquals("Juan Pérez", retrievedUser.getName());
    }

    @Test
    public void testUpdateUser() {
        User user = new User("1", "Juan Pérez", "Departamento X", "Usuario de prueba");
        userManager.addUser(user);
        user.setName("Juan Pérez Modificado");
        userManager.updateUser(user);
        User updatedUser = userManager.getUserById("1");
        assertEquals("Juan Pérez Modificado", updatedUser.getName());
    }

    @Test
    public void testDeleteUser() {
        User user = new User("1", "Juan Pérez", "Departamento X", "Usuario de prueba");
        userManager.addUser(user);
        userManager.deleteUser("1");
        assertNull(userManager.getUserById("1"));
    }

}