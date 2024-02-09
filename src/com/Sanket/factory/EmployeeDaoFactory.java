package com.Sanket.factory;

import com.Sanket.dao.EmployeeDao;
import com.Sanket.dao.EmployeeDaoImpl;

public class EmployeeDaoFactory {
    private static EmployeeDao employeeDao;
    static{
        employeeDao = new EmployeeDaoImpl();
    }
    public static EmployeeDao getEmployeeDao(){
        return employeeDao;
    }
}
