package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utill.Driver;

public class AddDriverFormController {
    public AnchorPane root;
    public static AnchorPane root1;
    public TextField txtDriverName;
    public TextField txtNIC;
    public TextField txtLicenseNo;
    public TextField txtAddress;
    public TextField txtContact;
    public static Driver driver[]=new Driver[16];
    public static int nextIndex=0;

    public void initialize(){
        Park_SystemController.driver=driver;
    }
    public void btnAddDriver(ActionEvent actionEvent) {
        for (int i=0 ; i<driver.length ; i++){
            if (driver[nextIndex]==null){
                driver[nextIndex]=new Driver(txtDriverName.getText(),txtNIC.getText(),txtLicenseNo.getText(),txtAddress.getText(),Integer.valueOf(txtContact.getText()));
            }
        }
        nextIndex++;
        Stage stage=(Stage) this.root.getScene().getWindow();
        stage.close();
        root1.setDisable(false);
    }
}
