import com.Sanket.controller.EmployeeController;
import com.Sanket.factory.EmployeeControllerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome To Employee Management System");
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            EmployeeController employeeController = EmployeeControllerFactory.getEmployeeController();

            while(true){
                System.out.println();
                System.out.println("1. ADD Employee");
                System.out.println("2. SEARCH Employee");
                System.out.println("3. GET ALL Employee");
                System.out.println("4. UPDATE Employee");
                System.out.println("5. DELETE Employee");
                System.out.println("6. EXIT");
                System.out.print("Choose Your Option: ");

                int userOperation = Integer.parseInt(bufferedReader.readLine());

                switch (userOperation){
                    case 1:
                        System.out.println();
                        System.out.println("ADD Employee Module");
                        System.out.println("=====================");
                        employeeController.addEmployee();
                        break;

                    case 2:
                        System.out.println();
                        System.out.println("SEARCH Employee Module");
                        System.out.println("======================");
                        employeeController.searchEmployee();
                        break;

                    case 3:
                        System.out.println();
                        System.out.println("GET ALL Employee Module");
                        System.out.println("========================");
                        employeeController.getAllEmployee();
                        break;

                    case 4:
                        System.out.println();
                        System.out.println("UPDATE Employee Module");
                        System.out.println("======================");
                        employeeController.updateEmployee();
                        break;

                    case 5:
                        System.out.println();
                        System.out.println("DELETE Employee Module");
                        System.out.println("======================");
                        employeeController.deleteEmployee();
                        break;

                    case 6:
                        System.out.println("Thankyou fro using Employee Management System");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Wrong Option, please select the optionfrom 1,2,3,4 and 5");
                        break;
                }
            }

        }catch(Exception exception){
            exception.printStackTrace();
        }

    }
}