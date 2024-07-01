package org.example;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void create(String client, Employee employee) throws Exception {
        System.out.println("Creating new employee");
    }

    @Override
    public void delete(String client, int empId) throws Exception {
        System.out.println("Deleting employee " + empId);
    }

    @Override
    public Employee get(String client, int empId) throws Exception {
        return null;
    }
}
