package com.appfx.parkinggarage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class GarageController {
    @FXML
    private TextField addCarLicensePlateTxt;

    @FXML
    private TextField addMotorcycleLicensePlateTxt;

    @FXML
    private RadioButton carFilterRadioBtn;

    @FXML
    private TextArea filterTxtArea;

    @FXML
    private ToggleGroup filterVehiclesRadioBtnToggleGrp;

    @FXML
    private TextField floorTxt;

    @FXML
    private TextField licensePlateOperationtxt;

    @FXML
    private RadioButton motorcycleFilterRadioBtn;

    @FXML
    private TextField spacesTxt;

    @FXML
    private TextArea statusTxtArea;

    private ParkingGarage parkingGarage = null;
    //private Pair<String , AbstractVehicle> vehiclePair = null; nur für eine KeyValue

    private Map<String , AbstractVehicle> vehiclePair =  new HashMap<>();

    @FXML
    void StatusBtn(ActionEvent event) {
        //statusTxtArea.setText(""); not working for some reaseon
        // statusTxtArea.clear();
            statusTxtArea.setText(parkingGarage.getStatus());
    }

    @FXML
    void createCarWithLicensePlateBtn(ActionEvent event) {
    AbstractVehicle car = new Car(addCarLicensePlateTxt.getText());
    vehiclePair.put(car.getLicensePlate(), car);
    }

    @FXML
    void createMotorcycleWithLicensePlateBtn(ActionEvent event) {
        AbstractVehicle motor = new Motorcycle(addMotorcycleLicensePlateTxt.getText());
        vehiclePair.put(motor.getLicensePlate(), motor);
    }

    @FXML
    void createGarageBtn(ActionEvent event) {
        int totalFloors = Integer.parseInt(floorTxt.getText());
        int spaces = Integer.parseInt(spacesTxt.getText());

        parkingGarage = new ParkingGarage(totalFloors, spaces);
    }

    @FXML
    void licensePlateDriveOutBtn(ActionEvent event) {
    parkingGarage.removeVehicle(licensePlateOperationtxt.getText());
    }
    public String vehicleText;
    @FXML
    void licensePlateFilterBtn(ActionEvent event) {
        Toggle  selectedToggle = filterVehiclesRadioBtnToggleGrp.getSelectedToggle();
        vehicleText = "";
        if(selectedToggle == motorcycleFilterRadioBtn) {
            //filterTxtArea.clear();
            vehicleText ="\n--- All motorcycles in the Parking Garage ---";
            List<AbstractVehicle> motorcycles  = parkingGarage.floors.stream()
                    .flatMap(floor -> floor.getSpaces().stream())
                    .filter(ParkingSpace::isOccupied)
                    .map(ParkingSpace::getVehicle)
                    .filter(v -> v instanceof Motorcycle)
                    .toList();

            motorcycles.forEach(m-> vehicleText+="\n"+m);
            filterTxtArea.setText(vehicleText);
        } else if(selectedToggle == carFilterRadioBtn) {
           // filterTxtArea.clear();
            vehicleText = "\n--- All cars in the Parking Garage ---";
            List<AbstractVehicle> cars  = parkingGarage.floors.stream()
                    .flatMap(floor -> floor.getSpaces().stream())
                    .filter(ParkingSpace::isOccupied)
                    .map(ParkingSpace::getVehicle)
                    .filter(v -> v instanceof Car)
                    .toList();

            cars.forEach(c-> vehicleText+="\n"+c);
            filterTxtArea.setText(vehicleText);
        }

    }

    @FXML
    void licensePlateParkingBtn(ActionEvent event) {
parkingGarage.parkVehicle(vehiclePair.get(licensePlateOperationtxt.getText()));
    }

    @FXML
    void licensePlateSearchBtn(ActionEvent event) {

        String targetId = (vehiclePair.get(licensePlateOperationtxt.getText())).getId() ; // car1.getId();
        Optional<AbstractVehicle> foundVehicle = parkingGarage.findVehicleByIdWithAnonymousClass(targetId);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Searching ...");
        alert.setHeaderText(null);
        if(foundVehicle.isPresent()) {
            alert.setContentText("Found vehicle with ID " + targetId + ": " + foundVehicle.get());
        }else {
            alert.setContentText("No vehicle found with ID " + targetId);
        }
        alert.showAndWait();
    }
}
