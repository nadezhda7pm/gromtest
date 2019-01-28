package lesson13;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        //Save ---------------------------------------------------------
        // save user +
        // user with the same id should not be added +
        // full array +
        // save null

        User user1 = new User(1, "Anna", "126t7h");
        User user2 = new User(2, "Tom", "jnhgd876y");
        User user3 = new User(3, "John", "1236t7yh");
        User user4 = new User(4, "Anna", "456t7yuh");

        User[] users = new User[3];
        UserRepository userRepository = new UserRepository(users);

        userRepository.save(user1);
        userRepository.save(user1);
        userRepository.save(null);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));


        //Update ---------------------------------------------------------
        // update user +
        // no user to update +
        // update to null +
        // update null in users +

        User user5 = new User(1, "Kate", "12aaauh");
        userRepository.update(user5);
        User user6 = new User(6, "Bob", "12aa34auh");
        userRepository.update(user6);
        userRepository.update(null);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));


        User[] users1 = new User[3];
        UserRepository userRepository1 = new UserRepository(users1);
        userRepository1.update(user6);
        System.out.println(Arrays.deepToString(userRepository1.getUsers()));


        //Delete ---------------------------------------------------------
        // delete user +
        // no user to delete +

        userRepository.delete(1);
        userRepository.delete(1);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

}
}
