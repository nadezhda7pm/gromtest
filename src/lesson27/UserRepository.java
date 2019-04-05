package lesson27;

import java.util.LinkedList;

public class UserRepository {
    private static LinkedList<User> users = new LinkedList<>();

    public static User save(User user) {
        if (user == null) return null;
        if (findById(user.getId()) != null) return null;
        if (!users.contains(null) && users.size() == 9) return null;
        if (users.contains(null)) users.add(users.indexOf(null), user);
        else users.add(user);
        return user;
    }

    public static User update(User user) {
        if (user == null) return null;
        if (findById(user.getId()) == null) return null;

        users.add(users.indexOf(findById(user.getId())), user);
        return user;
    }

    public static void delete(long id) {
        if (findById(id) == null) return;

        users.remove(users.indexOf(findById(id)));
    }

    public static User[] getUsers() {
        return (User[]) users.toArray();
    }

    private static User findById(long id) {
        if (users != null)
            for (User user : users) {
                if (user != null && id == user.getId())
                    return user;
            }
        return null;
    }
}


