package com.example.will_hero.Elements;

import com.example.will_hero.Game_Commiter.Collideable;
import com.example.will_hero.Game_Commiter.GameObjects;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.Serializable;

public class Orcs extends GameObjects implements Collideable {
    protected String orc_type;
    protected String orc_colour;
    protected int orc_strength;

    public Orcs(String col, String type) {
        this.orc_colour = col;
        this.orc_type = type;
        if(col.equals("Red")){
            this.orc_strength = 6;
        }else if(type.equals("Normal")){
            this.orc_strength = 4;
        }
        else if(type.equals("Boss")){
            this.orc_strength = 15;
        }
    }

    public String getOrc_type() {
        return orc_type;
    }

    public int getOrc_strength() {
        return orc_strength;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public synchronized double jump() {
        ImageView obj_pane = this.getImage();
        getGravityTimeline().stop();
        double ret = 0, value = getMoveUpDist();
        getJumpTimeline().stop();
        if(isPaused())
            return 0;
        getGravityTimeline().stop();
        setJumpTimeline(new Timeline());

        double layoutY = obj_pane.getLayoutY();

        if(layoutY - value < getMinY()) {
            ret = getMinY() - (layoutY - value);
            value = layoutY - getMinY();
        }
//        For Debugging purpose
//        System.out.println("ball y: "+ layoutY +" move ball up by: "+value + ", shift obstacles down by : "+ret);

        DoubleProperty posY = obj_pane.layoutYProperty();
        getJumpTimeline().getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(this.getImage().layoutYProperty(), this.getImage().getLayoutY()-80, Interpolator.LINEAR)));
        getJumpTimeline().play();
        getJumpTimeline().setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gravity();
            }
        });
        return ret;


    }
    public void orc_die(){
        //code
    }


}
