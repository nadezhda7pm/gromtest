package lesson9.User;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User[] users = new User[6];
        users[0] = new User(0, "Anna", "20");
        users[1] = new User(1, "Tom", "201");
        users[2] = new User(3, "Ben", "40");
        users[3] = new User(4, "Jack", "5");
        users[4] = new User(4, "Jack", "5");


        User usr = new User(7, "Oleg", "2000");
        User usr2 = new User(8, "Jim", "2000");


        UserRepository array = new UserRepository(users);
        System.out.println(Arrays.toString(array.getUsers()));

        System.out.println(Arrays.toString(array.getUserIds()));
        System.out.println(Arrays.toString(array.getUserNames()));
        System.out.println(array.getUserNameById(10));

        System.out.println(array.save(usr));

        System.out.println(Arrays.toString(array.getUserIds()));
        System.out.println(Arrays.toString(array.getUserNames()));
        System.out.println(array.getUserNameById(7));

        System.out.println(array.update(usr));
        System.out.println(array.update(usr2));

    }
}
