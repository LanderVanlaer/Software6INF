package me.landervanlaer.school.informatica6.javaFx.oef7;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

















