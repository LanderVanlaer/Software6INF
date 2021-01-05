package me.landervanlaer.school.informatica6.javaFx.oef5;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    public ImageView imageView;

    public void initialize() {
//        imageView.setImage(new Image("file:src/resources/fruit/" + ".png"));
    }

    public void closeAction(ActionEvent e) {
        Platform.exit();
    }

    public void openFile(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Foto selecteren");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(imageView.getScene().getWindow());
        imageView.setImage(new Image("file:" + selectedFile.getPath()));
    }
}

















