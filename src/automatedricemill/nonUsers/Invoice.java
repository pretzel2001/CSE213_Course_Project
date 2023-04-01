package automatedricemill.nonUsers;

import automatedricemill.Users.SalesPerson;
import java.io.Serializable;
import java.time.LocalDate;

public class Invoice implements Serializable{
    private Order orderDetails;
    private LocalDate purchaseDate;
    private float unitPrice;
    private SalesPerson seller;
    private int transactionID;
    
    public Invoice( Order orderDetails, LocalDate purchaseDate, float unitPrice, SalesPerson seller, int transactionID){
        this.orderDetails = orderDetails;
        this.purchaseDate = purchaseDate;
        this.unitPrice = unitPrice;
        this.seller = seller;
        this.transactionID = transactionID;
    
    }

    public Order getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Order orderDetails) {
        this.orderDetails = orderDetails;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public SalesPerson getSeller() {
        return seller;
    }

    public void setSeller(SalesPerson seller) {
        this.seller = seller;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }
    
    

    
}
