package org.example;

public class Main {
    public static void main(String[] args) {
        Director engineer = new Director(new EngineeringStudentBuilder());
        Director mba = new Director(new MbaStudentBuilder());
        Student engineeringStudent = engineer.createStudent();
        Student mbaStudent = mba.createStudent();
        System.out.println(engineeringStudent.toString());
        System.out.println(mbaStudent.toString());
    }
}