
package automatedricemill.Users;

import automatedricemill.AppendableObjectOutputStream;
import automatedricemill.nonUsers.Address;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable {
    private String clientName;
    private String clientID;
    private String clientRepresentative;
    private String representativeContactNo;
    private String businessType;
    private String businessWebsite;
    private String email;
    private Address clientAddress;
    
    public Client(String clientName, String clientID, String clientRepresentative,String representativeContactNo,String businessType,String businessWebsite,String email,Address clientAddress){
        this.clientName = clientName;
        this.clientID = clientID;
        this.clientRepresentative = clientRepresentative;
        this.representativeContactNo = representativeContactNo;
        this.businessType = businessType;
        this.businessWebsite = businessWebsite;
        this.email = email;
        this.clientAddress = clientAddress;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientRepresentative() {
        return clientRepresentative;
    }

    public void setClientRepresentative(String clientRepresentative) {
        this.clientRepresentative = clientRepresentative;
    }

    public String getRepresentativeContactNo() {
        return representativeContactNo;
    }

    public void setRepresentativeContactNo(String representativeContactNo) {
        this.representativeContactNo = representativeContactNo;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessWebsite() {
        return businessWebsite;
    }

    public void setBusinessWebsite(String businessWebsite) {
        this.businessWebsite = businessWebsite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(Address clientAddress) {
        this.clientAddress = clientAddress;
    }
    
    public void addToClientDatabase(){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("ClientDatabase.bin");
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
    public static ArrayList<Client> readFromDatabase()
    {
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        ArrayList<Client>clt = new ArrayList<Client>();
        
        try {
            f = new File("ClientDatabase.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            try
            {
                while(true)
                {
                    Client clt2 = (Client)ois.readObject();
                    clt.add(clt2);
                }
            }
            catch(Exception e){};            
        } 
        catch (IOException ex) {} 
        finally 
        {
            try {
                if(ois != null) ois.close();
            } 
            catch (IOException ex) {}
        }           
        return clt;
    }
 
}
