package co.edu.uniquindio.billeteravirtual.appbilleteravirtual;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BilleteraVirtualApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BilleteraVirtualApplication.class.getResource("Usuario.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Información del Usuario");
        stage.setScene(scene);
        stage.setWidth(850);
        stage.setHeight(700);
        stage.centerOnScreen();
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}