package lesson20.task1;

import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServerException;
import lesson20.task1.exception.UserNotFoundException;

public class UserRepository {
    private User[] users = new User[10];
    public User[] getUsers() {
        return users;
    }


    public User save(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't save null user");

        try {
            findById(user.getId());
            throw new BadRequestException("User with id:" + user.getId() + " already exists");
        } catch (UserNotFoundException e) {
            System.out.println("User with id:" + user.getId() + " not found, will be saved");
        }

        int i = 0;
        for (User u : users){
            if (u == null) {
                users[i] = user;
                return users[i];
            }
            i++;
        }
        throw new InternalServerException("Not enough space to save user with id: " + user.getId());
    }

    public User update(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't update null user");

        findById(user.getId());

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == user.getId()) {
                users[i] = user;
                return users[i];
            }
        }
        throw new InternalServerException("Unexpected error");
    }

    public void delete(long id) throws  Exception{
        findById(id);

        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == id)
                users[i] = null;
            break;
        }
    }

    public User findById(long id) throws UserNotFoundException {
        for (User user : users) {
            if (user != null && id == user.getId())
                return user;
        }
        throw new UserNotFoundException("User with id " + id + "not found");
    }
}


