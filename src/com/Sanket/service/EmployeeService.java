package com.Sanket.service;

import com.Sanket.beans.Employee;

import java.util.List;

public interface EmployeeService {
    public String addEmployee(Employee employee);
    public Employee searchEmployee(int eno);
    public List<Employee> getAllEmployees();
    public String updateEmployee(Employee employee);
    public String deleteEmployee(int eno);
}
