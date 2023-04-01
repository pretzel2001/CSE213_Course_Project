package automatedricemill;

import automatedricemill.Users.Client;
import automatedricemill.nonUsers.Order;
import automatedricemill.nonUsers.Product;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SalesOrderDetailsSceneController implements Initializable {

    @FXML
    private TextField clientNameTextField;
    @FXML
    private TextField clientRepresentativeTextField;
    @FXML
    private TextField representativeContactNumberTextField;
    @FXML
    private TableView<Client> clientListTable;
    @FXML
    private TableColumn<Client, String> clientListName;
    @FXML
    private TableColumn<Client, String> clientListID;
    @FXML
    private TableColumn<Client, String> clientListClientRepresentative;
    @FXML
    private TableColumn<Client, String> clientListContactNumber;    
    @FXML
    private TextField productNameTextField;
    @FXML
    private TextField productQuantityTextFeild;
    @FXML
    private TextField totalPriceTextField;
    @FXML
    private DatePicker deliveryDatePicker;
    @FXML
    private TextArea selectedProductListTextArea;
    @FXML
    private DatePicker orderDatePicker;
    @FXML
    private TextField sellPricePerUnit;
    @FXML
    private TextField productIDTextField;
    @FXML
    private TextField clientIDTextField;
    @FXML
    private Label orderIdLabel;
    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, String> productIDColumn;
    @FXML
    private TableColumn<Product, Float> unitCostColumn;
    
    private int autoOrderID;
    
      private void setClientTableData(){
        ArrayList <Client> cltList = Client.readFromDatabase();
        clientListTable.getItems().addAll(cltList);
    } 
    
    private void setProductTableData(){
        ArrayList <Product> prdList = Product.readFromProductDatabase();  
        productTable.getItems().addAll(prdList);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clientListName.setCellValueFactory(new PropertyValueFactory<Client,String>("clientName"));
        clientListID.setCellValueFactory(new PropertyValueFactory<Client, String>("clientID"));
        clientListClientRepresentative.setCellValueFactory(new PropertyValueFactory<Client, String>("clientRepresentative"));
        clientListContactNumber.setCellValueFactory(new PropertyValueFactory<Client,String>("representativeContactNo"));
        setClientTableData();
        
        productNameColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("productName"));
        productIDColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("productID"));
        unitCostColumn.setCellValueFactory(new PropertyValueFactory<Product,Float>("unitCost"));
        setProductTableData();
        
        autoOrderID = getAutomatedOrderID();
        orderIdLabel.setText(Integer.toString(autoOrderID));
        
    } 


    @FXML
    private void selectClientButtonOnClick(ActionEvent event) {
        Client clt = clientListTable.getSelectionModel().getSelectedItem();
        clientNameTextField.setText(clt.getClientName());
        clientRepresentativeTextField.setText(clt.getClientRepresentative());
        representativeContactNumberTextField.setText(clt.getRepresentativeContactNo());
        clientIDTextField.setText(clt.getClientID());
    }

    @FXML
    private void chooseProductButtonOnClick(ActionEvent event) {
        Product prd = productTable.getSelectionModel().getSelectedItem();
        productNameTextField.setText(prd.getProductName());
        productIDTextField.setText(prd.getProductID());

    }

    @FXML
    private void finishProductListingButtonOnClick(ActionEvent event) {
        float totalPrice = getTotalPrice();
        totalPriceTextField.setText(Float.toString(totalPrice));
    }
    

    @FXML
    private void returnToHomeButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("salesOfficerSceneOne.fxml"));  
        Scene sc = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sc);
        window.show();
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event)throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("loginPage.fxml"));  
        Scene sc = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sc);
        window.show();
    }
    private float getTotalPrice(){
        float price = 0.0f;
        for(int i=0;i<sellingPricePerUnit.size();i++){
            price += sellingPricePerUnit.get(i)*addedQuantity.get(i);
        }
        return price;
    }
    @FXML
    private void confirmOrderButtonOnClick(ActionEvent event) {
        String orderID = "ORD"+ orderIdLabel.getText();
        LocalDate orderDate = orderDatePicker.getValue();
        Client buyer = clientListTable.getSelectionModel().getSelectedItem();
        LocalDate expectedDeliveryDate = deliveryDatePicker.getValue();
        float totalPrice = getTotalPrice();
        Order ord = new Order(orderID,orderDate,buyer,addedProducts,addedQuantity,sellingPricePerUnit,expectedDeliveryDate,totalPrice);
        ord.addToOrderDatabase();
        setAutomatedOrderID();
        autoOrderID = getAutomatedOrderID();
        orderIdLabel.setText(Integer.toString(autoOrderID));

    }
    
    
    private void setAutomatedOrderID()
    {
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("AutomatedOrderID.bin");
            fos = new FileOutputStream(f);
            dos = new DataOutputStream(fos);
            int ID = autoOrderID + 1;
            dos.writeInt(ID);

        } 
        catch (Exception ex) {} 
        finally {
            try {
                if(dos != null) dos.close();
            } 
            catch (Exception ex) {}
        }  
}
    private int getAutomatedOrderID() {
        File f = null;
        FileInputStream fis = null;
        DataInputStream dis = null;
        int a = 0;
        try {
            f = new File("AutomatedOrderID.bin");
                fis = new FileInputStream(f);
                dis = new DataInputStream(fis);
                a = dis.readInt();
        } catch (Exception ex) {
            
        } finally {
            try {
                if(dis != null) dis.close();
            } catch (Exception ex) {
            }
        } 
        return a;
    }  
    private ArrayList<Product> addedProducts = new ArrayList<Product>();
    private ArrayList<Float> addedQuantity = new ArrayList<Float>();
    private ArrayList<Float> sellingPricePerUnit = new ArrayList<Float>();

    @FXML
    private void addButtonOnClick(ActionEvent event) {
        Product prd = productTable.getSelectionModel().getSelectedItem();
        Float q = Float.parseFloat(productQuantityTextFeild.getText());
        Float slp = Float.parseFloat(sellPricePerUnit.getText());
        
        addedProducts.add(prd);
        addedQuantity.add(q);
        sellingPricePerUnit.add(slp);
        
        String info = "";
        for(int i = 0;i<addedProducts.size();i++){
            info = "Product Name: "+productNameTextField.getText()+", Product Quantity: "+ Float.parseFloat(productQuantityTextFeild.getText()) +", Product total price: "+"\n";
        }
        selectedProductListTextArea.appendText(info);

    }
}
