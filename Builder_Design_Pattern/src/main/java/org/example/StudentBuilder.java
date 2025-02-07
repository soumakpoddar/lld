package org.example;

import java.util.List;

public abstract class StudentBuilder {
    String name;
    int age;
    String major;
    List<String> courses;

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setMajor(String major) {
        this.major = major;
        return this;
    }

    abstract public StudentBuilder setCourses();

    public Student build() {
        return new Student(this);
    }
}
