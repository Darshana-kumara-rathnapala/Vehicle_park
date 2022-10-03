package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utill.Vehicle;

public class AddVehicleFormController {
    public AnchorPane root;
    public static AnchorPane root1;
    public TextField txtVehicleNumber;
    public TextField txtWeight;
    public TextField txtNoOfPassenger;
    public JFXComboBox<String> cmbVehicleType;
    public String cmbvalue;

    public static Vehicle vehicle[]=new Vehicle[14];
    public static int nextIndex=0;

    public void initialize(){
        Park_SystemController.vehicle=vehicle;
       cmbVehicleType.getItems().addAll(
               "Bus",
                        "Van",
                        "Cargo Lorry"
       );
       cmbVehicleType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {cmbvalue=(String)newValue;});
    }

    public void cmbVehicleSelect(ActionEvent actionEvent) {

    }
    public void btnAddVehicle(ActionEvent actionEvent) {
        for (int i=0;i<14;i++){
            if (vehicle[nextIndex]==null){
                vehicle[nextIndex]=new Vehicle(txtVehicleNumber.getText(),cmbvalue,txtWeight.getText() ,Integer.valueOf(txtNoOfPassenger.getText()));
            }
            txtVehicleNumber.clear();
            txtWeight.clear();
            txtNoOfPassenger.clear();
        }
        nextIndex++;
        root1.setDisable(false);
        Stage primaryStage=(Stage ) this.root.getScene().getWindow();
        primaryStage.close();

       System.out.println(vehicle[0].getVehicle_type()+"\n"+vehicle[0].getVehicle_number()+"\n"+vehicle[0].getWeight()+"\n"+vehicle[0].getPassengers());
    }

}
