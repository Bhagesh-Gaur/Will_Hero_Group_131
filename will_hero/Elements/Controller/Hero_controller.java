package com.example.will_hero.Elements.Controller;

import com.example.will_hero.Elements.Hero;
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

public class Hero_controller implements Initializable {
//    @FXML
//    private Pane hero_pane;
//    @FXML
//    private ImageView hero;

    private Hero hero;
    private ImageView hero_pane;


    private Timeline gravityTimeline;
    private Timeline jumpTimeline;
    private Timeline xTimeline;

    private static double moveUpDist = 80, moveUpDur = 200, minY = 700/2, maxY = 700-50;

    private boolean paused;

    public Hero_controller(Hero hero){
        this.hero = hero;
        this.hero_pane = hero.getImage();
        this.gravityTimeline = new Timeline();
        this.jumpTimeline = new Timeline();
        this.xTimeline = new Timeline();
    }
//
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void gravity() {
        ImageView obj_pane = hero_pane;
        gravityTimeline.stop();
        if(paused)
            return;
        gravityTimeline = new Timeline();
        DoubleProperty layoutY = obj_pane.layoutYProperty();
//        gravityTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(moveUpDur * (maxY - layoutY.getValue())/moveUpDist), new KeyValue(layoutY, maxY, Interpolator.EASE_IN)));
        gravityTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(2500), new KeyValue(hero_pane.layoutYProperty(), 1000, Interpolator.LINEAR)));
        gravityTimeline.play();
    }

    public void start() {
        xTimeline.setCycleCount(Timeline.INDEFINITE);
        KeyValue kv = new KeyValue(hero_pane.layoutYProperty(), hero_pane.layoutYProperty().getValue() - moveUpDist, Interpolator.EASE_OUT);
        xTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(moveUpDur*2), kv));
        xTimeline.setAutoReverse(true);
        xTimeline.play();
    }

    public double jump() {
        ImageView obj_pane = hero_pane;
        gravityTimeline.stop();
        double ret = 0, value = moveUpDist;
        jumpTimeline.stop();
        if(paused)
            return 0;
        xTimeline.stop();
        gravityTimeline.stop();
        jumpTimeline = new Timeline();

        double layoutY = obj_pane.getLayoutY();

        if(layoutY - value < minY) {
            ret = minY - (layoutY - value);
            value = layoutY - minY;
        }
//        For Debugging purpose
//        System.out.println("ball y: "+ layoutY +" move ball up by: "+value + ", shift obstacles down by : "+ret);

        DoubleProperty posY = obj_pane.layoutYProperty();
        jumpTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(250), new KeyValue(hero_pane.layoutYProperty(), hero_pane.getLayoutY()-130, Interpolator.LINEAR)));
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









}
