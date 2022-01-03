package com.example.will_hero.Elements.Controller;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Hand_controller implements Initializable {

    @FXML
    private Pane hand_pane;

    private Timeline xTimeline;
    private static double moveUpDist = 80, moveUpDur = 200;

    public Hand_controller(){
        this.xTimeline = new Timeline();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void start() {
        xTimeline.setCycleCount(Timeline.INDEFINITE);
        KeyValue kv = new KeyValue(hand_pane.layoutYProperty(), hand_pane.layoutYProperty().getValue() - moveUpDist, Interpolator.EASE_OUT);
        xTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(moveUpDur*2), kv));
        xTimeline.setAutoReverse(true);
        xTimeline.play();
    }

    public void vanish(){
        this.hand_pane.setOpacity(0);
        this.hand_pane.setLayoutX(1100);
        this.hand_pane.setLayoutY(800);
    }

}
