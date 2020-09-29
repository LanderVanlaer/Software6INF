package me.landervanlaer.javaFx.oef8;

import com.sun.javafx.scene.control.DoubleField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
    public TableView<Punten> table;
    public Label titelNaam;

    public TextField naam;
    public TextField punten;
    public TextField vak;

    private Leerling leerling;

    @FXML
    private TableColumn<Punten, String> naamKolom;
    @FXML
    private TableColumn<Punten, Double> puntenKolom;

    public void initialize() {
        naamKolom.setCellValueFactory(new PropertyValueFactory<>("vak"));
        puntenKolom.setCellValueFactory(new PropertyValueFactory<>("punt"));
    }

    public void changeLeerling(ActionEvent actionEvent) throws IOException {
        if(this.leerling != null) leerling.write();
        this.table.getItems().clear();
        this.punten.setText(null);
        this.vak.setText(null);

        if(this.naam.getText().isBlank()) {
            leerling = null;
            return;
        }

        leerling = new Leerling(this.naam.getText().toLowerCase().trim());
        this.titelNaam.setText(leerling.getNaam());
        leerling.initializePunten(table);
    }

    public void addVak(ActionEvent actionEvent) {
        if(leerling == null) return;

        double punt;
        if(this.vak.getText() == null ||
                this.punten.getText() == null ||
                this.vak.getText().isBlank() ||
                this.punten.getText().isBlank())
            return;

        try {
            punt = Double.parseDouble(punten.getText().trim());
        } catch(NumberFormatException ignored) {
            return;
        }
        if(punt < 0) return;
        leerling.addVak(new Punten(vak.getText().trim(), punt));
        leerling.updateTable(table);
    }
}

















