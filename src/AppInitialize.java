import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sun.plugin2.applet.FXAppletSecurityManager;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.IOException;

public class AppInitialize extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("view/Park_System.fxml"));
        Scene scene=new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Park Vehicles");
        primaryStage.show();
        //primaryStage.setResizable(false);
    }
}
