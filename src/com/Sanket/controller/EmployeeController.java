package com.Sanket.controller;

import com.Sanket.beans.Employee;
import com.Sanket.factory.EmployeeServiceFactory;
import com.Sanket.service.EmployeeService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.List;

public class EmployeeController {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    EmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
    public void addEmployee(){
        try {
            System.out.print("Employee Number    :");
            int eno = Integer.parseInt(bufferedReader.readLine());
            Employee emp = employeeService.searchEmployee(eno);
            if(emp == null){
                System.out.print("Employee Name       :");
                String ename = bufferedReader.readLine();
                System.out.print("Employee Salary     :");
                float esal = Float.parseFloat(bufferedReader.readLine());
                System.out.print("Employee Address    :");
                String eaddr = bufferedReader.readLine();
                Employee employee = new Employee();
                employee.setEno(eno);
                employee.setEname(ename);
                employee.setEsal(esal);
                employee.setEaddr(eaddr);
                String status = employeeService.addEmployee(employee);
                System.out.println("Status : " +status);
            }else{
                System.out.println("Status: ALREADY EXISTED");
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
    public void searchEmployee(){
        try{
            System.out.print("Employee Number    :");
            int eno = Integer.parseInt(bufferedReader.readLine());
            Employee employee = employeeService.searchEmployee(eno);
            if(employee == null){
                System.out.println("Status: Employee Does Not Exist");
            }else{
                System.out.println("Employee Details");
                System.out.println("-------------------------");
                System.out.println("Employee Number    : "+employee.getEno());
                System.out.println("Employee Name      : "+employee.getEname());
                System.out.println("Employee Salary    : "+employee.getEsal());
                System.out.println("Employee Address   : "+employee.getEaddr());
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }

    }
    public void getAllEmployee(){
            List<Employee> employeeList = employeeService.getAllEmployees();
            Iterator<Employee> iterator = employeeList.iterator();
            System.out.println("ENO\tENAME\tESAL\tEADDR");
            System.out.println("------------------------------");
            while (iterator.hasNext()){
                Employee employee = iterator.next();
                System.out.print(employee.getEno()+"\t");
                System.out.print(employee.getEname()+"\t");
                System.out.print(employee.getEsal()+"\t");
                System.out.print(employee.getEaddr()+"\n");
            }

    }
    public void updateEmployee(){
        try {
            String nename="";
            float nesal=0;
            String neaddr="";
            System.out.print("Employee Number    :");
            int eno = Integer.parseInt(bufferedReader.readLine());
            Employee employee = employeeService.searchEmployee(eno);
            if(employee == null){
                System.out.println("Status: Employee Does Not Exist");
            }else {
                Employee employee1=new Employee();
                System.out.println("Update Employee Details");
                System.out.println("-------------------------");
                System.out.print("Employee Name      Old: "+employee.getEname()+" New: ");
                    nename = bufferedReader.readLine();
                if(nename == null || nename.equals("")){
                    nename = employee.getEname();
                }

                System.out.print("Employee Salary    Old: "+employee.getEsal()+" New: ");
                String salary = bufferedReader.readLine();
                if(salary == null || salary.equals("")){
                    nesal = employee.getEsal();
                }else{
                    nesal = Float.parseFloat(salary);
                }

                System.out.print("Employee Address   Old: "+employee.getEaddr()+" New: ");
                neaddr = bufferedReader.readLine();
                if(neaddr == null || neaddr.equals("  ")){
                    neaddr = employee.getEaddr();
                }
                employee1.setEno(eno);
                employee1.setEname(nename);
                employee1.setEsal(nesal);
                employee1.setEaddr(neaddr);

                String status = employeeService.updateEmployee(employee1);
                System.out.println("Status : " + status);
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
    public void deleteEmployee(){
        try {
            System.out.print("Employee Number    :");
            int eno = Integer.parseInt(bufferedReader.readLine());
            Employee employee = employeeService.searchEmployee(eno);
            if(employee == null){
                System.out.println("Status: Employee Does Not Exist");
            }else {
                String status = employeeService.deleteEmployee(eno);
                System.out.println("Status : " + status);
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
