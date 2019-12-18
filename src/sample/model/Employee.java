package sample.model;
import javafx.beans.property.*;
import java.sql.Date;

public class Employee {

    private IntegerProperty employee_id;
    private StringProperty first_name;
    private StringProperty last_name;
    private StringProperty email;
    private SimpleObjectProperty<Date> hire_date;
    private IntegerProperty salary;


    public Employee() {
        this.employee_id = new SimpleIntegerProperty();
        this.first_name = new SimpleStringProperty();
        this.last_name = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.hire_date = new SimpleObjectProperty<>();
        this.salary = new SimpleIntegerProperty();

    }


    public int getEmployeeId() {
        return employee_id.get();
    }

    public void setEmployeeId(int employeeId){
        this.employee_id.set(employeeId);
    }

    public IntegerProperty employeeIdProperty(){
        return employee_id;
    }

    //first_name
    public String getFirstName () {
        return first_name.get();
    }

    public void setFirstName(String firstName){
        this.first_name.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return first_name;
    }

    //last_name
    public String getLastName () {
        return last_name.get();
    }

    public void setLastName(String lastName){
        this.last_name.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return last_name;
    }

    //email
    public String getEmail () {
        return email.get();
    }

    public void setEmail (String email){
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    //phone_number


    //hire_date
    public Date getHireDate(){
        return hire_date.get();
    }

    public void setHireDate(Date hireDate){
        this.hire_date.set(hireDate);
    }

    public SimpleObjectProperty<Date> hireDateProperty(){
        return hire_date;
    }

    //salary
    public int getSalary() {
        return salary.get();
    }

    public void setSalary (int jobId){
        this.salary.set(jobId);
    }

    public IntegerProperty jobIdProperty() {
        return salary;
    }

}