
package automatedricemill.Users;

import automatedricemill.nonUsers.Address;
import java.io.Serializable;
import java.time.LocalDate;

public abstract class Employee implements Serializable{
    private String EmpName;
    private int empID;
    private Address empAddress;
    private String bloodGroup;
    private String userName;
    private String password;
    private LocalDate dateOfJoining;
    private String gender;
    
    
    public Employee(String EmpName, int empID, Address empAddress, String bloodGroup, String userName, String password, LocalDate dateOfJoining, String gender){
        this.EmpName = EmpName;
        this.empID = empID;
        this.empAddress = empAddress;
        this.bloodGroup = bloodGroup;
        this.userName = userName;
        this.password = password;
        this.dateOfJoining = dateOfJoining;
        this.gender = gender;
    
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Address getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(Address empAddress) {
        this.empAddress = empAddress;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
}

