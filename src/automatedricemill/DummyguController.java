
package automatedricemill;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class DummyguController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private ComboBox<String> department;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        department.getItems().addAll("Sales","HR","Accounts","Warehouse","Operations","Mill Tecnician","Transport","Supply");

    }    

    @FXML
    private void ok(ActionEvent event) {
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("Users.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);
            

            dos = new DataOutputStream(fos);
            
            dos.writeUTF(id.getText());
            dos.writeUTF(username.getText());
            dos.writeUTF(department.getValue());
            dos.writeUTF(password.getText());

        } catch (IOException ex) {
            //Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (IOException ex) {
               // Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
}
