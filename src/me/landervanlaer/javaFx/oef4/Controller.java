package me.landervanlaer.javaFx.oef4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class Controller {
    public ListView<String> listView;
    public ImageView image;

    public void initialize() {
        File[] files = new File("src/resources/fruit").listFiles();
        if(files == null) return;
        for(File file : files)
            if(file.isFile())
                listView.getItems().add(
                        file.getName().substring(0, file.getName().lastIndexOf('.'))
                );


        listView.getSelectionModel().selectedItemProperty().addListener(observable ->
                image.setImage(new Image("file:src/resources/fruit/" + listView.getSelectionModel().getSelectedItem() + ".png")));
    }
}
