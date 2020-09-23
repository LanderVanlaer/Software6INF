package me.landervanlaer.javaFx.oef8;

import com.sun.javafx.scene.control.DoubleField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    public TableView<Leerling> table;
    public TextField naam;
    public TextField punten;
    public Label titelNaam;

    @FXML
    private TableColumn<Leerling, String> naamKolom;
    @FXML
    private TableColumn<Leerling, Double> gemiddeldeKolom;

    public void initialize() {
        naamKolom.setCellValueFactory(new PropertyValueFactory<>("naam"));
        gemiddeldeKolom.setCellValueFactory(new PropertyValueFactory<>("gemiddelde"));
    }
}

















