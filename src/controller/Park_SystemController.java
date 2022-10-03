package controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utill.Driver;
import utill.OnDiliveryShift;
import utill.ParkVehicle;
import utill.Vehicle;
/*-------------------------------------------------------------------------*/
import java.text.SimpleDateFormat;
import java.util.Date;
/*-------------------------------------------------------------------------*/

import java.io.IOException;

public class Park_SystemController extends ParkVehicleFormController{

    public ComboBox cmbVehicle;
    public ComboBox cmbDriver;
    public Label lblVehicleType;
    public Label lblDate;
    public Label lblTime;
    public Label lblSlotNumber;
    public AnchorPane root;
    public static Vehicle vehicle[]=new Vehicle[14];
    public static Driver driver[]=new Driver[16];
    //-----------------parked vehicle object Arrays---------------------------
    public static ParkVehicle parkVehicle[]=new ParkVehicle[14];
    public static Park []park1;
    public String vNumber;
    public String type;
    /*----------------On diiveryShift objectt Arrays---------------------------*/
    public static OnDiliveryShift []diliveryShift=new OnDiliveryShift[14];
    public String dName;
    /*-------------------------------------------------------------------------*/
    static ObservableList<String>vehicleObList=FXCollections.observableArrayList();
    static ObservableList<String>driverObList=FXCollections.observableArrayList();

    public String vType;
    public static String aa;
    public JFXButton btnParkVehicleId;
    public JFXButton btnDiliveryShiftId;
    public Label lblSlotNumber1;

    public void check(){
        F2:for (int i = 0; i <parkVehicle.length ; i++) {
            if(parkVehicle[i]!=null){
                if (parkVehicle[i].getVehicleNumber().equals(vNumber)){
                    btnParkVehicleId.setDisable(true);
                    lblSlotNumber.setDisable(true);
                    lblSlotNumber1.setDisable(true);
                    cmbDriver.setDisable(false);
                    btnDiliveryShiftId.setDisable(false);
                    lblSlotNumber.setVisible(false);
                    lblSlotNumber1.setVisible(false);
                    break F2;
                }
            }else if (parkVehicle[i]==null){
                cmbDriver.setDisable(true);
                btnDiliveryShiftId.setDisable(true);
                //cmbVehicle.setDisable(false);
                btnParkVehicleId.setDisable(false);
                lblSlotNumber.setDisable(false);
                lblSlotNumber1.setDisable(false);
                lblSlotNumber.setVisible(true);
                lblSlotNumber1.setVisible(true);
                break F2;
            }
        }
    }
    public void initialize(){
        Management_ParkController.parkVehicles=parkVehicle;
        SimpleDateFormat datte = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        lblDate.setText(datte.format(date));
        lblTime.setText(time.format(date));
    /*-------------------------------------------------------------------------*/
        Management_LogController.r1=root;
        vehicleObList.clear();
        driverObList.clear();
   /*-------------------------------------------------------------------------*/
        for (Driver d:driver) {
            if (d!=null){
                driverObList.addAll(d.getName());
            }
        }
        cmbDriver.setItems(driverObList);

   /*-------------------------------------------------------------------------*/
        for (Vehicle v:vehicle) {
              if (v!=null){
                    vehicleObList.addAll(v.getVehicle_number());
                }
        }
        cmbVehicle.setItems(vehicleObList);

        cmbVehicle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            vNumber=(String ) newValue;
            check();
            for (Vehicle s:vehicle) {
                if (s!=null && s.getVehicle_number()==newValue){
                    vType=s.getVehicle_type();
                    type=vType;
                    lblVehicleType.setText(vType);
                    ParkVehicleFormController pV=new ParkVehicleFormController();
                    lblSlotNumber.setText(ParkVehicleFormController.getSlot(vType));
                }
            }
        });
        cmbDriver.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            dName=(String)newValue;
        });
    }

    public void tbnManagementLog(ActionEvent actionEvent) throws IOException {
        root.setDisable(true);
        Parent parent= FXMLLoader.load(getClass().getResource("../view/Management_Log.fxml"));
        Scene scene=new Scene(parent);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Log In Form");
        primaryStage.show();

    }

    public void btnparkVehical(ActionEvent actionEvent) {
       int a=Integer.valueOf(lblSlotNumber.getText());
        F1:for (int i = 0; i <parkVehicle.length ; i++) {
            if (parkVehicle[i]==null){
                parkVehicle[i]=new ParkVehicle(vNumber,type,a,lblTime.getText());
                park1[a-1].setIn(1);
                check();
                break F1;
            }
        }
    }

    public void btnonDeliveryShift(ActionEvent actionEvent) {
        F2:for (int b = 0; b <diliveryShift.length ; b++) {
            if (diliveryShift[b]==null){
                diliveryShift[b]=new OnDiliveryShift(vNumber,lblVehicleType.getText(),dName,lblTime.getText());
                break F2;
            }


        }
        F3:for (int i = 0; i < parkVehicle.length; i++) {
            System.out.println("in acton");
            if ((parkVehicle[i]!=null) && (parkVehicle[i].getVehicleNumber().equals(vNumber))){
                System.out.println("for 2"+parkVehicle[i].equals(vNumber));
                int a=parkVehicle[i].getParkingSlot();
                parkVehicle[i]=null;
                park[a-1].setIn(0);
                check();
                break F3;
            }
        }
    }

}
