package org.example;

public class EmployeeDaoProxy implements EmployeeDao {
    private final EmployeeDao employeeDao;

    public EmployeeDaoProxy() {
        this.employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, Employee employee) throws Exception {
        if (client.equals("admin")) {
            employeeDao.create(client, employee);
        } else {
            throw new Exception("Client not authorized to perform this operation");
        }
    }

    @Override
    public void delete(String client, int empId) throws Exception {
        if (client.equals("admin")) {
            employeeDao.delete(client, empId);
        } else {
            throw new Exception("Client not authorized to perform this operation");
        }
    }

    @Override
    public Employee get(String client, int empId) throws Exception {
        if (client.equals("admin") || client.equals("user")) {
            return employeeDao.get(client, empId);
        } else {
            throw new Exception("Client not authorized to perform this operation");
        }
    }
}
