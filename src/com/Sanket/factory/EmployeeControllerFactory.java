package com.Sanket.factory;

import com.Sanket.controller.EmployeeController;

public class EmployeeControllerFactory {
    private static EmployeeController employeeController;
    static{
        employeeController = new EmployeeController();
    }

    public static EmployeeController getEmployeeController() {
        return employeeController;
    }
}
