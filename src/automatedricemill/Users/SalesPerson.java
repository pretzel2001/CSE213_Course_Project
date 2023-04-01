
package automatedricemill.Users;

import automatedricemill.nonUsers.Address;
import java.io.Serializable;
import java.time.LocalDate;

public class SalesPerson extends Employee implements Serializable {
    private static final String DEPT_STRING = "Sales";
    private String salesID;
    private String bankAcc;

    public SalesPerson(String DEPT_STRING,String salesID,String bankAcc,String EmpName, int empID, Address empAddress, String bloodGroup, String userName, String password, LocalDate dateOfJoining, String gender){
        super(EmpName,empID,empAddress,bloodGroup,userName,password,dateOfJoining,gender);
        this.salesID = salesID;
        this.bankAcc = bankAcc;
    }

    public String getSalesID() {
        return salesID;
    }

    public void setSalesID(String salesID) {
        this.salesID = salesID;
    }

    public String getBankAcc() {
        return bankAcc;
    }

    public void setBankAcc(String bankAcc) {
        this.bankAcc = bankAcc;
    }
    
}
