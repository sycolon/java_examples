package com.appfx.parkinggarage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GarageApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GarageApplication.class.getResource("garage-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800 , 900);
        stage.setTitle("Parking Garage");
        stage.setScene(scene);
        stage.show();
    }
}
