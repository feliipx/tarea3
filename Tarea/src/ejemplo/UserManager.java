package ejemplo;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public boolean addUser(User user) {
        if (user.getId().isEmpty()) {
            return false;
        }
        if (getUserById(user.getId()) != null) {
            System.out.println("Error: El usuario con ID '" + user.getId() + "' ya está registrado.");
            return false;
        }

        users.add(user);
        return true;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i, user);
                break;
            }
        }
    }

    public void deleteUser(String id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
