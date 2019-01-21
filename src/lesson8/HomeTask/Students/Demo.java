package lesson8.HomeTask.Students;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        System.out.println(Demo.createHighestParent());
        System.out.println(Demo.createLowestChild());
    }

    static Student createHighestParent() {
        Course[] courses = new Course[10];
        Student student = new Student("Max", "Kosh", 2, courses);
        return student;
    }

    static SpecialStudent createLowestChild() {
        Course[] courses = new Course[10];
        SpecialStudent specialStudent = new SpecialStudent("Ann", "Jones", 3, courses, 6765443, "annj@gmail.com");
        return specialStudent;
    }
}
