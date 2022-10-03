package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utill.Driver;

import java.io.IOException;

public class Management_LogController {
    final String name ="Admin";
    final String password ="q123";
    public JFXTextField txtName;
    public JFXPasswordField txtPassword;
    public AnchorPane root;
    public static AnchorPane r1;

    public void btnCancel(ActionEvent actionEvent) throws IOException {
       r1.setDisable(false);
       Stage primaryStage=(Stage ) this.root.getScene().getWindow();
       primaryStage.close();
    }

    public void btnLogIn(ActionEvent actionEvent) throws IOException {
        if (txtName.getText().equals("Admin")&& txtPassword.getText().equals("q123")){
            Parent parent=FXMLLoader.load(getClass().getResource("../view/Management_park.fxml"));
            Scene scene=new Scene(parent);
            Stage primaryStage=(Stage ) this.root.getScene().getWindow();
            primaryStage.close();
            primaryStage=(Stage ) this.r1.getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Parking System");
            primaryStage.show();


        }else{
            new Alert(Alert.AlertType.WARNING,"Your user name or password does not match", ButtonType.CLOSE).showAndWait();
            txtName.clear();
            txtPassword.clear();
            txtName.requestFocus();
        }
    }
}
