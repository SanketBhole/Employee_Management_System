package com.Sanket.factory;

import com.Sanket.service.EmployeeService;
import com.Sanket.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {
    private static EmployeeService employeeService;
    static{
        employeeService = new EmployeeServiceImpl();
    }
    public static EmployeeService getEmployeeService(){
        return employeeService;
    }
}
