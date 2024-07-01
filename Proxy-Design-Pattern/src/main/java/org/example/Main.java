package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            EmployeeDao emp = new EmployeeDaoProxy();
            emp.create("user", new Employee());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}