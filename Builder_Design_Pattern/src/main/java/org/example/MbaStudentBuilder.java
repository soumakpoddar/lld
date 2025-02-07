package org.example;

import java.util.ArrayList;
import java.util.List;

public class MbaStudentBuilder extends StudentBuilder {
    @Override
    public StudentBuilder setCourses() {
        List<String> subs = new ArrayList<>();
        subs.add("Micro Economics");
        subs.add("Business Studies");
        subs.add("Operations Management");
        this.courses = subs;
        return this;
    }
}
