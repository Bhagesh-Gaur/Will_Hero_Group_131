package com.example.will_hero.Islands.Controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Island_controller implements Initializable {

    @FXML
    private Pane islandPane;

    @FXML
    private ImageView island;

    private Timeline xTimeline;

    public Island_controller(){
        this.xTimeline = new Timeline();
    }



    public void move_x(){
//        final Timeline timeline = new Timeline();
        xTimeline.stop();
        xTimeline.setCycleCount(1);
//        timeline.setAutoReverse(true);
        final KeyValue kv = new KeyValue(this.islandPane.layoutXProperty(), -50);
        final KeyFrame kf = new KeyFrame(Duration.seconds(0.2), kv);
        xTimeline.getKeyFrames().add(kf);
        xTimeline.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
