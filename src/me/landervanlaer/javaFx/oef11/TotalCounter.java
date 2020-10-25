package me.landervanlaer.javaFx.oef11;


import javafx.scene.control.Label;

public class TotalCounter {
    private final Label label;
    private final Label[] targets;

    public TotalCounter(Label label, Label... targets) {
        this.label = label;
        this.targets = targets;
    }

    public void update() {
        int total = 0;
        for(Label t : targets)
            if(!t.getText().isBlank())
                total += Integer.parseInt(t.getText());
        label.setText(String.valueOf(total));
    }
}
