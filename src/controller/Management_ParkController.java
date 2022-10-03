package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utill.ParkVehicle;

import java.io.IOException;

public class Management_ParkController extends ParkVehicle{
    public JFXComboBox <String>cmbParkDeliver;
    public AnchorPane root;
    public AnchorPane rootTbl;

    public TableColumn clmVehicleNumber;
    public TableColumn clmVehicleType;
    public TableColumn clmParkingSlot;
    public TableColumn cmParkedTime;
    public TableView tblId;
    public static ParkVehicle []parkVehicles;
    ObservableList<ParkVehicle>parkList=FXCollections.observableArrayList();

    public void initialize(){
        ObservableList<String>obList= FXCollections.observableArrayList("In Parking","On Delivery");
        cmbParkDeliver.setItems(obList);
        cmbParkDeliver.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            parkList.clear();
            if (newValue.equals("In Parking")){
                for (ParkVehicle p:parkVehicles) {
                    if (p!=null){
                        parkList.add(new ParkVehicle(p.getVehicleNumber(),p.getVehicleType(),p.getParkingSlot(),p.getParkedTime()));
                    }
                }
            }
            tblId.setItems(parkList);
        });
        clmVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        clmVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        clmParkingSlot.setCellValueFactory(new PropertyValueFactory<>("parkingSlot"));
        cmParkedTime.setCellValueFactory(new PropertyValueFactory<>("parkedTime"));
        AddVehicleFormController.root1=root;
        AddDriverFormController.root1=root;
    }
    public void btnAddDriver(ActionEvent actionEvent) throws IOException {
        Parent parent=FXMLLoader.load(getClass().getResource("../view/AddDriverForm.fxml"));
        Scene scene=new Scene(parent);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add Driver");
        primaryStage.show();
        root.setDisable(true);
    }

    public void btnAddVehicle(ActionEvent actionEvent) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("../view/AddVehicleForm.fxml"));
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Add Vehicle");
        root.setDisable(true);
        stage.show();
    }

    public void btnLogOut(ActionEvent actionEvent) throws IOException {
        Stage primaryStage=(Stage ) this.root.getScene().getWindow();
        primaryStage.close();

        Parent parent=FXMLLoader.load(getClass().getResource("../view/Park_System.fxml"));
        Scene scene=new Scene(parent);
        Stage stage=(Stage ) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
}
