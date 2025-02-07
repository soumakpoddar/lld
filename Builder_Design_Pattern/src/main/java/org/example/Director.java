package org.example;

public class Director {
    StudentBuilder studentBuilder;

    Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {
        if (studentBuilder instanceof EngineeringStudentBuilder) {
            return createEngineeringStudentBuilder();
        } else if (studentBuilder instanceof MbaStudentBuilder) {
            return createMedicalStudentBuilder();
        } else {
            return null;
        }
    }

    private Student createMedicalStudentBuilder() {
        return studentBuilder
                .setName("John")
                .setAge(22)
                .setMajor("Economics")
                .setCourses()
                .build();
    }

    private Student createEngineeringStudentBuilder() {
        return studentBuilder
                .setName("Soumak")
                .setAge(24)
                .setMajor("Computer Science")
                .setCourses()
                .build();
    }
}
