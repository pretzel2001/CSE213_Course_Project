
package automatedricemill.nonUsers;

import automatedricemill.AppendableObjectOutputStream;
import automatedricemill.Users.Client;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order implements Serializable{
    private String orderID;
    private LocalDate orderDate;
    private Client buyer;
    private ArrayList <Product> productList;
    private ArrayList <Float> quantityList;
    private ArrayList <Float> sellPricelist;
    private LocalDate expectedDeliveryDate;
    private float totalPrice;
    private static final float DELIVERY_FEE = 80.0f;

    public Order(String orderID, LocalDate orderDate, Client buyer, ArrayList<Product> productL, ArrayList<Float> quantityL, ArrayList<Float> sellPriceL, LocalDate expectedDeliveryDate, float totalPrice) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.buyer = buyer;
        productList = productL;
        quantityList = quantityL;
        sellPricelist = sellPriceL;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.totalPrice = totalPrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Client getBuyer() {
        return buyer;
    }

    public void setBuyer(Client buyer) {
        this.buyer = buyer;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ArrayList<Float> getQuantityList() {
        return quantityList;
    }

    public void setQuantityList(ArrayList<Float> quantityList) {
        this.quantityList = quantityList;
    }

    public ArrayList<Float> getSellPricelist() {
        return sellPricelist;
    }

    public void setSellPricelist(ArrayList<Float> sellPricelist) {
        this.sellPricelist = sellPricelist;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }
    
    public void addToOrderDatabase(){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("OrderDatabase.bin");
            if(f.exists())
            {
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else
            {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(this);

        } 
        catch (Exception ex){} 
        finally 
        {
            try{
                if(oos != null) oos.close();
            } 
            catch (Exception ex){}
        }            
    }

}
