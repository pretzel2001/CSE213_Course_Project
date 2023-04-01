
package automatedricemill;

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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SalesOfficerSceneOneController implements Initializable {

    @FXML
    private Label employeeNameLabel;
    @FXML
    private Label employeeIdLabel;
    @FXML
    private Label departmentLabel;
    @FXML
    private Label genderLabel;
    @FXML
    private Label dateOfBirthLabel;
    @FXML
    private Label bloodGroupLabel;
    @FXML
    private Label joiningDateLabel;
    @FXML
    private Label salesIdLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        employeeNameLabel.setText("Anannya Preeta");
        employeeIdLabel.setText("SALES001");
        departmentLabel.setText("Sales");
        genderLabel.setText("Female");
        dateOfBirthLabel.setText("19-06-2001");
        bloodGroupLabel.setText("O+");
        joiningDateLabel.setText("22-08-2021");
        salesIdLabel.setText("SA01");
    }    

    @FXML
    private void sendOrderDetailsButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("salesOrderDetailsScene.fxml"));  
        Scene sc = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sc);
        window.show();
    }

    @FXML
    private void updateClientsButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("salesUpdateClientsScene.fxml"));  
        Scene sc = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sc);
        window.show();
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("loginPage.fxml"));  
        Scene sc = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sc);
        window.show();
    }

    @FXML
    private void generateBarChartOnClick(ActionEvent event)throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("UI1.fxml"));  
        Scene sc = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sc);
        window.show();
    }
    
}
