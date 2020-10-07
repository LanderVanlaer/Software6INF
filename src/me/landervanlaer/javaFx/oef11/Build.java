package me.landervanlaer.javaFx.oef11;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Build {
    public TextField naam;
    public GridPane gridUpperSection;
    public GridPane totalUpperSection;
    public GridPane gridLowerSection;
    private Label[][] labels;

    public void initialize() {
        setLabels(new Label[6][6]);
        for(int i = 0; i < gridUpperSection.getColumnCount(); i++) {
            for(int j = 0; j < gridUpperSection.getRowCount(); j++) {
                Label label = new Label(i + ", " + j);
                getLabels()[i][j] = label;
                gridUpperSection.add(label, i, j);
            }
        }
    }

    public Label[][] getLabels() {
        return labels;
    }

    public void setLabels(Label[][] labels) {
        this.labels = labels;
    }
}
