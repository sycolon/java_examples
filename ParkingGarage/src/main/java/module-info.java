module com.appfx.parkinggarage {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.appfx.parkinggarage to javafx.fxml;
    exports com.appfx.parkinggarage;
}