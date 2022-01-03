package com.example.will_hero.Elements.Controller;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Orc_controller implements Initializable {

    @FXML
    private Pane orc_pane;
    @FXML
    private ImageView hero;

    private Timeline gravityTimeline;
    private Timeline jumpTimeline;
    private Timeline xTimeline;

    private static double moveUpDist = 80, moveUpDur = 200, minY = 700/2, maxY = 700-50;

    private boolean paused;

    public Orc_controller(){
        this.gravityTimeline = new Timeline();
        this.jumpTimeline = new Timeline();
        this.xTimeline = new Timeline();
    }
    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void gravity() {
        gravityTimeline.stop();
        if(paused)
            return;
        gravityTimeline = new Timeline();
        DoubleProperty layoutY = this.orc_pane.layoutYProperty();
//        gravityTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(moveUpDur * (maxY - layoutY.getValue())/moveUpDist), new KeyValue(layoutY, maxY, Interpolator.EASE_IN)));
        gravityTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(2500), new KeyValue(orc_pane.layoutYProperty(), 1000)));
        gravityTimeline.play();
    }


    public double jump() {
        gravityTimeline.stop();
        double ret = 0, value = moveUpDist;
        jumpTimeline.stop();
        if(paused)
            return 0;
        xTimeline.stop();
        gravityTimeline.stop();
        jumpTimeline = new Timeline();

        double layoutY = this.orc_pane.getLayoutY();

        if(layoutY - value < minY) {
            ret = minY - (layoutY - value);
            value = layoutY - minY;
        }
//        For Debugging purpose
//        System.out.println("ball y: "+ layoutY +" move ball up by: "+value + ", shift obstacles down by : "+ret);

        DoubleProperty posY = this.orc_pane.layoutYProperty();
        jumpTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(150), new KeyValue(orc_pane.layoutYProperty(), orc_pane.getLayoutY()-120, Interpolator.EASE_OUT)));
        jumpTimeline.play();
        jumpTimeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gravity();
            }
        });
        return ret;


    }


    public void pause() {
        paused = true;
        gravityTimeline.stop();
    }

    public void resume() {
        paused = false;
    }

    public void move_x(){
//        final Timeline timeline = new Timeline();
        xTimeline.stop();
        xTimeline.setCycleCount(1);
//        timeline.setAutoReverse(true);
        final KeyValue kv = new KeyValue(this.orc_pane.layoutXProperty(), -50);
        final KeyFrame kf = new KeyFrame(Duration.seconds(0.2), kv);
        xTimeline.getKeyFrames().add(kf);
        xTimeline.play();
    }




}
