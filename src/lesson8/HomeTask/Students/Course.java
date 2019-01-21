package lesson8.HomeTask.Students;

import java.util.Date;

public class Course {
    Date startDate;
    String name;
    int hoursDuration;
    String teacherName;
    Student[] students;
    int[] groups;

    public Course(Date startDate, String name, int hoursDuration, String teacherName, Student[] students) {
        this.startDate = startDate;
        this.name = name;
        this.hoursDuration = hoursDuration;
        this.teacherName = teacherName;
        this.students = students;
    }
}
