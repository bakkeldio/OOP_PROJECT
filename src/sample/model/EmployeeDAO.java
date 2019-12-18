package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {


    public static Employee searchEmployee (String empId) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM `employees` WHERE employee_id="+empId;

        try {

            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);


            Employee employee = getEmployeeFromResultSet(rsEmp);

            //Return employee object
            return employee;
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + empId + " id, an error occurred: " + e);

            throw e;
        }
    }

    //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
    private static Employee getEmployeeFromResultSet(ResultSet rs) throws SQLException
    {
        Employee emp = null;
        if (rs.next()) {
            emp = new Employee();
            emp.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
            emp.setFirstName(rs.getString("FIRST_NAME"));
            emp.setLastName(rs.getString("LAST_NAME"));
            emp.setEmail(rs.getString("EMAIL"));
            emp.setSalary(rs.getInt("SALARY"));
            emp.setHireDate(rs.getDate("HIRE_DATE"));

        }
        return emp;
    }


    public static ObservableList<Employee> searchEmployees () throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM `employees`";


        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Employee> empList = getEmployeeList(rsEmps);

            //Return employee object
            return empList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    //Select * from employees operation
    private static ObservableList<Employee> getEmployeeList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Employee> empList = FXCollections.observableArrayList();

        while (rs.next()) {
            Employee emp = new Employee();
            emp.setEmployeeId(rs.getInt("employee_id"));
            emp.setFirstName(rs.getString("first_name"));
            emp.setLastName(rs.getString("last_name"));
            emp.setEmail(rs.getString("email"));
            emp.setSalary(rs.getInt("salary"));
            emp.setHireDate(rs.getDate("hire_date"));


            //Add employee to the ObservableList
            empList.add(emp);
        }
        //return empList (ObservableList of Employees)
        return empList;
    }


    public static void updateEmpEmail (String empId, String empEmail) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt =
                        "   UPDATE employees\n" +
                        "      SET EMAIL = '" + empEmail + "'\n" +
                        "    WHERE EMPLOYEE_ID = " + empId + ";\n";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }


    public static void deleteEmpWithId (String empId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =

                        "   DELETE FROM `employees`\n" +
                        "         WHERE employee_id ="+ empId +";\n";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }


    public static void insertEmp(String name, String lastName, String email, int salary) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "INSERT INTO `employees`\n(FIRST_NAME, LAST_NAME, EMAIL, SALARY)\n"+"VALUES\n" +
                        "( '"+name+"', '"+lastName+"','"+email+"', '"+salary+"');\n";



        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
}