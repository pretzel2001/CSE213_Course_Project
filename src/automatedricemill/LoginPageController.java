
package automatedricemill;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginPageController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private ComboBox<String> deptComboBox;
    @FXML
    private TextField passwordTextField;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        deptComboBox.getItems().addAll("Sales","HR","Accounts","Warehouse","Operations","Mill Tecnician","Transport","Supply");
    }    

    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
        String ID = idTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String department = deptComboBox.getValue();
        
        /*System.out.println(ID);
        System.out.println(username);
        System.out.println(password);System.out.println(department);*/
        
        
        int flag = 0;
        File f = null;
        FileInputStream fis = null;
        DataInputStream dis = null;
        try {
            f = new File("Users.bin");
            fis = new FileInputStream(f);
            dis = new DataInputStream(fis);
            
            while(true)
            {
                String fid = dis.readUTF();
                String fname = dis.readUTF();
                String fdept = dis.readUTF();
                String fpass = dis.readUTF();
                
                /*
                SALES001
                Anannya Preeta
                Sales
                1234
                ACC001
                Anannya Preeta
                Accounts
                1234
                
                */
                if (fid.equals(ID)&& fname.equals(username) && fdept.equals(department) && fpass.equals(password)){
                    flag = 1;
                    if(fdept.equals("Sales")){
                        Parent parent = FXMLLoader.load(getClass().getResource("salesOfficerSceneOne.fxml"));  
                        Scene sc = new Scene(parent);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                        window.setScene(sc);
                        window.show();
                    }
                    break;
                } 
                
            }
  
        } 
        catch (IOException ex) {

        } 
        finally 
        {
            try 
            {
                if(flag==0){
                    Alert error = new Alert(Alert.AlertType.WARNING);
                    error.setContentText("Your credentials does not match");
                    error.showAndWait();
                } 
                if(dis != null) dis.close();
            } 
            
            catch (IOException ex) {
               
            }
        }          
        
    }
    
}
