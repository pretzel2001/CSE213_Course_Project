
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UI1Controller implements Initializable {

    @FXML
    private BarChart<String,Number> barChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String,Number>("Miniket",95.0));
        series.getData().add(new XYChart.Data<String,Number>("Najirshail",90.0));
        series.getData().add(new XYChart.Data<String,Number>("Kalijira",100.0));
        series.getData().add(new XYChart.Data<String,Number>("Basmati",95.0));
        series.getData().add(new XYChart.Data<String,Number>("Premium Basmati",120.0));
        series.getData().add(new XYChart.Data<String,Number>("Brown Rice",110.0));
        series.getData().add(new XYChart.Data<String,Number>("Chinigura",80.0));
        series.setName("Unit Price");
        barChart.getData().add(series);
    }    

    @FXML
    private void returnToHomeButtonOnClick(ActionEvent event)throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("salesOfficerSceneOne.fxml"));  
        Scene sc = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sc);
        window.show();
    }
    
}
