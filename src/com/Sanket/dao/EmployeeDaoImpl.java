package com.Sanket.dao;

import com.Sanket.beans.Employee;
import com.Sanket.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{

    Connection connection = ConnectionFactory.getConnection();
    @Override
    public String add(Employee employee) {
        String status="";
        try{
            Statement statement = connection.createStatement();
            int rowCount = statement.executeUpdate("insert into emp1 values("+employee.getEno()+",'"+employee.getEname()+"',"+employee.getEsal()+",'"+employee.getEaddr()+"')");
            if(rowCount == 1){
                status = "SUCCESS";
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return status;
    }

    @Override
    public Employee search(int eno) {
        Employee employee = null;
        try{
            Statement statement= connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from emp1 where ENO = "+eno);
            boolean b =resultSet.next();
            if(b == true){
                employee = new Employee();
                employee.setEno(resultSet.getInt("ENO"));
                employee.setEname(resultSet.getString("ENAME"));
                employee.setEsal(resultSet.getInt("ESAL"));
                employee.setEaddr(resultSet.getString("EADDR"));
            }else {
                employee = null;
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = null;
        try{
            employeeList = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from emp1");
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setEno(resultSet.getInt("ENO"));
                employee.setEname(resultSet.getString("ENAME"));
                employee.setEsal(resultSet.getInt("ESAL"));
                employee.setEaddr(resultSet.getString("EADDR"));
                employeeList.add(employee);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public String update(Employee employee) {
        String status="";
        try{
            Statement statement = connection.createStatement();
            int rowCount = statement.executeUpdate("update emp1 set ENAME= '"+employee.getEname()+"',ESAL="+employee.getEsal()+",EADDR='"+employee.getEaddr()+"' where ENO="+employee.getEno());
            if(rowCount == 1){
                status = "SUCCESSFULLY UPDATED";
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return status;
    }

    @Override
    public String delete(int eno) {
        String status="";
        try{
            Statement statement = connection.createStatement();
            int rowCount = statement.executeUpdate("delete from emp1 where ENO="+eno);
            if(rowCount == 1){
                status = "DELETED SUCCESSFULLY";
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return status;
    }
}
