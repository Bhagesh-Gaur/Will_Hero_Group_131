package com.example.will_hero.Elements;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class Boss_orc extends Orcs {
    public Boss_orc(){
        super("Green","Boss");
        String path = "src/main/resources/com/example/will_hero/Image_src/Collide/c_bossorg.png";
        loadObjtoPane(path);
        this.orc_strength = 30;
    }

        public boolean damage(int dmg){
            this.orc_strength -= dmg;
            if(orc_strength<=0){
                return true;
            }
            return false;
        }

//    @Override
//    public synchronized double movX(){
//        ImageView obj_pane = this.getImage();
//        double ret = 0, value = 35;//move x units
//        if(isPaused())
//            return 0;
//        getxTimeline().stop();
//        setxTimeline(new Timeline());
//
//        double layoutX = obj_pane.getLayoutX();
//
//        if(layoutX - value < getMinY()) {
//            ret = getMinY() - (layoutX - value);
//            value = layoutX - getMinY();
//        }
////        For Debugging purpose
////        System.out.println("ball y: "+ layoutY +" move ball up by: "+value + ", shift obstacles down by : "+ret);
//
//        DoubleProperty posX = obj_pane.layoutXProperty();
//        getxTimeline().getKeyFrames().add(new KeyFrame(Duration.millis(550), new KeyValue(this.getImage().layoutXProperty(), this.getImage().getLayoutX()-45, Interpolator.LINEAR)));
//        getxTimeline().play();
//        getxTimeline().setOnFinished(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                getxTimeline().stop();
//            }
//        });
//        return ret;
//    }
}
