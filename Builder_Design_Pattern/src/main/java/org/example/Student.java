package org.example;

import java.util.List;

public class Student {
    String name;
    int age;
    String major;
    List<String> courses;

    public Student(StudentBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.major = builder.major;
        this.courses = builder.courses;
    }

    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nMajor: " + major + "\nCourses: " + courses;
    }
}
