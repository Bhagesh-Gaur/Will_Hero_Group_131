package com.example.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("Game_home.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),1000,700);
            Image img = new Image("file:Image_src/Hero_title.png");
            stage.getIcons().add(img);
            stage.setTitle("Will Hero");
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(event -> {
                event.consume();
                exit_fun(stage);
            });

        } catch (Exception e){
            e.printStackTrace();
        }
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("HomePage.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("This is Title!");
//        stage.setScene(scene);
//        stage.show();
    }
    public void exit_fun(Stage stage) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Exit Will Hero!");
        a.setHeaderText("You are about to close Will Hero!");
        a.setContentText("Do you really wish to exit Will Hero?");
        if(a.showAndWait().get() == ButtonType.OK){
            System.out.println("Will Hero Exited Successfully!");
            stage.close();
        }
    }


    public static void main(String[] args) {
        launch();
    }
}