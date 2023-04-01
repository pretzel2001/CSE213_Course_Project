
package automatedricemill.nonUsers;

import java.io.Serializable;

public class Address implements Serializable{
    private String city;
    private int zipCode;
    private String houseNo;
    private String roadNo;
    private String areaName;
    
    public Address(String city, int zipCode,String houseNo, String roadNo,String areaName){
        this.city = city;
        this.zipCode = zipCode;
        this.houseNo = houseNo;
        this.roadNo = roadNo;
        this.areaName = areaName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getRoadNo() {
        return roadNo;
    }

    public void setRoadNo(String roadNo) {
        this.roadNo = roadNo;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    

}
