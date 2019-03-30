package lesson22.repository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        User user = new User(1001, "Daniil", "56765");
        UserRepository.save(user);
        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        User user2 = new User(1002, "Andrey", "567erwt65");
        UserRepository.save(user2);
        System.out.println(Arrays.deepToString(UserRepository.getUsers()));


        User user3 = new User(1001, "Test", "56765");
        UserRepository.update(user3);
        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));



    }
}
