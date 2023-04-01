
package automatedricemill.nonUsers;

import automatedricemill.AppendableObjectOutputStream;
import automatedricemill.Users.Client;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable{
    private String productName;
    private String productID;
    private float unitCost;
    
    public Product(String productName, String productID, float unitCost){
        this.productName = productName;
        this.productID = productID;
        this.unitCost = unitCost;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(float unitCost) {
        this.unitCost = unitCost;
    }
    
    public static ArrayList<Product> readFromProductDatabase()
    {
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        ArrayList<Product>prd = new ArrayList<Product>();
        
        try {
            f = new File("ProductDatabase.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            try
            {
                while(true)
                {
                    Product prd2 = (Product)ois.readObject();
                    prd.add(prd2);
                }
            }
            catch(Exception e){};            
        } 
        catch (Exception ex) {} 
        finally 
        {
            try {
                if(ois != null) ois.close();
            } 
            catch (Exception ex) {}
        }           
        return prd;
    }
    //this function was used to create dummy product database
    public static void addToProductDatabase(Product prd){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("ProductDatabase.bin");
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
            oos.writeObject(prd);

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
