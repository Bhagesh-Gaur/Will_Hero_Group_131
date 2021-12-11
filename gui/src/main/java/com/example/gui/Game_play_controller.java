package com.example.gui;

import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Game_play_controller implements Initializable {

//public static void main(String[]args){
//        launch(args);
//        }
    @FXML
    AnchorPane anc;
    @FXML
    ImageView c;
    @FXML
    ImageView c2;
    @FXML
    ImageView c1;
    @FXML
    ImageView i;
    @FXML
    StackPane stp;

    AnchorPane ap = new AnchorPane();
    Image img,img1;
    ImageView imgv,imgv1;




    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Image img = new Image("file:Image_src/NonCollide/nc_cloud1.png");
//
//        Image img1 = new Image("file:Image_src/Collide/c_island5.png");
//        ImageView imgv = new ImageView(img);
//        ImageView imgv1 = new ImageView(img1);
//        imgv.setX(0);
//        imgv.setY(0);
//
//        ap.getChildren().add(imgv);
//        stp.getChildren().add(ap);
//        imgv.setX(600);
//        imgv1.setX(600);
//        imgv1.setY(400);
//        Scene sc = new Scene(anc,1000,700);




        TranslateTransition tran = new TranslateTransition();
        tran.setDuration(Duration.millis(2500));
        tran.setNode(i);
        tran.setToY(20);
        tran.setAutoReverse(true);
        tran.setCycleCount(PathTransition.INDEFINITE);
        tran.play();



        ChangeListener<Number> listener = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                Bounds boundsInScene = i.localToScene(i.getBoundsInLocal());
                double xInScene = boundsInScene.getMinX();
                double yInScene = boundsInScene.getMinY();
                // do something with values...
//                System.out.println(xInScene);
//                System.out.println(yInScene);
            }
        };
        i.translateXProperty().addListener(listener);
        i.translateYProperty().addListener(listener);



        class mytimer extends AnimationTimer {
            @Override
            public void handle(long l) {
//                i.setX(i.getX() - 100);
                c.setLayoutX(c.getLayoutX() + c.getTranslateX() - 0.2);
                c1.setLayoutX(c1.getLayoutX() + c.getTranslateX() - 0.1);
                c2.setLayoutX(c.getLayoutX() + c.getTranslateX()- 0.3);
                if((c.getLayoutX() + c.getTranslateX())<0){
                    c.setLayoutX(700);
                }
                if((c1.getLayoutX() + c1.getTranslateX())<0){
                    c1.setLayoutX(700);
                }
                if((c2.getLayoutX() + c2.getTranslateX())<0){
                    c2.setLayoutX(700);
                }
                if((i.getLayoutX() + i.getTranslateX())<0){
                    i.setLayoutX(700);
                }
                System.out.println(c.getLayoutX());
//                System.out.println(i.getLayoutY()+","+i.getY());
            }
        }

        AnimationTimer timer = new mytimer();
        timer.start();
    }

    @FXML
    public void test(ActionEvent event) throws IOException {

        i.setLayoutX(i.getLayoutX() + i.getTranslateX() - 100);
//        c.setX(c.getX() - 20);

    }
}
