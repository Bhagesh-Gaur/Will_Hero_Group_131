package com.example.will_hero.Elements;

import com.example.will_hero.Game_Commiter.GameObjects;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Hand extends GameObjects implements Cloneable {

    private transient Timeline sTimeline;
    private static double moveUpDist = 40, moveUpDur = 200;
    public Hand(){
        sTimeline = new Timeline();
        String path = "src/main/resources/com/example/will_hero/Image_src/tap.png";
        loadObjtoPane(path);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void start() {
        sTimeline.setCycleCount(Timeline.INDEFINITE);
        KeyValue kv = new KeyValue(this.getImage().layoutYProperty(), this.getImage().layoutYProperty().getValue() - moveUpDist, Interpolator.EASE_OUT);
        sTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(moveUpDur*2), kv));
        sTimeline.setAutoReverse(true);
        sTimeline.play();
    }

}
