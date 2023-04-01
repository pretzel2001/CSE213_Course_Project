
package automatedricemill;

import automatedricemill.Users.Client;
import automatedricemill.nonUsers.Address;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SalesUpdateClientsSceneController implements Initializable {

    @FXML
    private ComboBox<String> businessTypeComboBox;
    @FXML
    private TableView<Client> tableView;
    @FXML
    private TableColumn<Client, String> tableViewName;
    @FXML
    private TableColumn<Client, String> tableViewId;
    @FXML
    private TableColumn<Client, String> tableViewClientRepresentative;
    @FXML
    private TableColumn<Client, String> tableViewContactNumber;
    @FXML
    private TableColumn<Client, String> tableViewBusinessType;
    @FXML
    private TableColumn<Client, String> tableViewEmail;
    @FXML
    private TableColumn<Client, String> tableViewWebsite;
    @FXML
    private Label clientIdLabel;
    @FXML
    private ComboBox<String> cityComboBox;
    @FXML
    private TextField businessNameTextField;
    @FXML
    private TextField clientRepresentativeTextField;
    @FXML
    private TextField representativeContactNumber;
    @FXML
    private TextField wesbitetextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField zipCodeTextField;
    @FXML
    private TextField buildingNumberTextField;
    @FXML
    private TextField roadNumberTextField;
    @FXML
    private TextField areaNameTextField;
    
    private int autoID;
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        businessTypeComboBox.getItems().addAll(
                "Corporation","Sole Proprietor","Small Business","LLC"
        
        );
        cityComboBox.getItems().addAll(
                "Dhaka","Chittagong","Sylhet","Barishal","Noakhali","Khulna","Rajshahi","Bogra"
        
        );
        tableViewName.setCellValueFactory(new PropertyValueFactory<Client,String>("clientName"));
        tableViewId.setCellValueFactory(new PropertyValueFactory<Client, String>("clientID"));
        tableViewClientRepresentative.setCellValueFactory(new PropertyValueFactory<Client, String>("clientRepresentative"));
        tableViewContactNumber.setCellValueFactory(new PropertyValueFactory<Client,String>("representativeContactNo"));
        tableViewBusinessType.setCellValueFactory(new PropertyValueFactory<Client,String>("businessType"));
        tableViewEmail.setCellValueFactory(new PropertyValueFactory<Client,String>("email"));
        tableViewWebsite.setCellValueFactory(new PropertyValueFactory<Client,String>("businessWebsite"));  
        autoID = getAutomatedID();
        clientIdLabel.setText(Integer.toString(autoID));
    }    

    @FXML
    private void logoutOnClick(ActionEvent event)throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("loginPage.fxml"));  
        Scene sc = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sc);
        window.show();
    }

    @FXML
    private void returnToHomeOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("salesOfficerSceneOne.fxml"));  
        Scene sc = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sc);
        window.show();
    }
    private void textFieldClear(){
        businessNameTextField.clear();
        clientRepresentativeTextField.clear();
        representativeContactNumber.clear();
        wesbitetextField.clear();
        emailTextField.clear();
        zipCodeTextField.clear();
        buildingNumberTextField.clear();
        roadNumberTextField.clear();
        areaNameTextField.clear();
    }
    @FXML
    private void updateInformationOnClick(ActionEvent event) {
        
        String name =   businessNameTextField.getText();
        autoID = getAutomatedID();
        String ID = "CUS"+ Integer.toString(autoID);
        String representative = clientRepresentativeTextField.getText();
        String contactnumber = representativeContactNumber.getText();
        String businesstype =  businessTypeComboBox.getValue();
        String businesswesbite = wesbitetextField.getText();
        String email = emailTextField.getText();
        int zipcode = Integer.parseInt(zipCodeTextField.getText());
        String buildingnumber = buildingNumberTextField.getText();
        String roadnumber = roadNumberTextField.getText(); 
        String city = cityComboBox.getValue();
        String area = areaNameTextField.getText();
        
        Address add = new Address(city,zipcode,buildingnumber,roadnumber,area);
        
        Client clt = new Client(name,ID,representative,contactnumber,businesstype,businesswesbite,email,add);
        clt.addToClientDatabase();
        setAutomatedID();
        autoID = getAutomatedID();
        clientIdLabel.setText(Integer.toString(autoID));
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Clients Saved Successfully!");
        alert.show();
        textFieldClear();
         
    }

    @FXML
    private void viewIntableOnClick(ActionEvent event) 
    {    
        tableView.getItems().clear();
        setTableData();
    }
    private void setTableData(){
        ArrayList <Client> cltList = Client.readFromDatabase();
        tableView.getItems().addAll(cltList);
        /*
        for (int i = 0 ; i < cltList.size(); i++){
            System.out.println(cltList.get(i));
        } 
       */
        
    } 
   
    private void setAutomatedID()
    {
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("AutomedClientID.bin");
            fos = new FileOutputStream(f);
            dos = new DataOutputStream(fos);
            int ID = autoID + 1;
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
    
    private int getAutomatedID() {
        File f = null;
        FileInputStream fis = null;
        DataInputStream dis = null;
        int a = 0;
        try {
            f = new File("AutomedClientID.bin");
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
}
