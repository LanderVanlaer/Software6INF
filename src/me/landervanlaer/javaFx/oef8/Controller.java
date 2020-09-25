package me.landervanlaer.javaFx.oef8;

import com.sun.javafx.scene.control.DoubleField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {
    public TableView<Punten> table;
    public Label titelNaam;

    public TextField naam;
    public TextField punten;
    public TextField vak;

    @FXML
    private TableColumn<Punten, String> naamKolom;
    @FXML
    private TableColumn<Punten, Double> puntenKolom;

    private Leerling leerling;

    public void initialize() {
        naamKolom.setCellValueFactory(new PropertyValueFactory<>("vak"));
        puntenKolom.setCellValueFactory(new PropertyValueFactory<>("punt"));
    }

    public void changeLeerling(ActionEvent actionEvent) {
        table.getItems().clear();

        Leerling leerling = new Leerling(this.naam.getText().toLowerCase());
        this.titelNaam.setText(leerling.getNaam());
        leerling.addToTable(table);
    }
}

















