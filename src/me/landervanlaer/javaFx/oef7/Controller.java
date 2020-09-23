package me.landervanlaer.javaFx.oef7;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;

public class Controller {
    public TableView<Leerling> table;
    private Klas klas;

    @FXML
    private TableColumn<Leerling, String> naamKolom;
    @FXML
    private TableColumn<Leerling, Double> gemiddeldeKolom;

    public void initialize() {
        naamKolom.setCellValueFactory(new PropertyValueFactory<>("naam"));
        gemiddeldeKolom.setCellValueFactory(new PropertyValueFactory<>("gemiddelde"));
        klas = new Klas(
                new Leerling("Jos", 5),
                new Leerling("Rik", 7),
                new Leerling("Jan", 6),
                new Leerling("Jan", 6),
                new Leerling("Jan", 6),
                new Leerling("Jan", 6),
                new Leerling("Jan", 6),
                new Leerling("Jan", 6),
                new Leerling("Jan", 6),
                new Leerling("Jan", 6),
                new Leerling("Zoë", 8)
        );
        klas.getLeerlingen().forEach(leerling -> table.getItems().add(leerling));
    }
}

















