package lesson15.homeTask.userRepository;

import java.util.Arrays;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public User save(User user) {
        if (users == null || user == null)
            return null;

        if (findUser(user) == null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    return user;
                }
            }
        }
        return null;
    }

    public User update(User user) {
        if (users != null && user != null) {
            for (int i = 0; i < users.length; i++) {
                if (user != null && users[i] != null && users[i].getId() == user.getId()) {
                    users[i] = user;
                    return users[i];
                }
            }
        }
        return null;
    }


    public void delete(long id) {
        if (users != null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null && users[i].getId() == id)
                    users[i] = null;
            }
        }
    }

    public User findUser(User user) {
        if (users != null) {
            for (User u : users) {
                if (u != null && u.equals(user))
                    return user;
                return null;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + Arrays.toString(users) +
                '}';
    }
}