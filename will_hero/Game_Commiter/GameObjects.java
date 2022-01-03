package com.example.will_hero.Game_Commiter;

import com.example.will_hero.Game;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class GameObjects implements Initializable, Serializable {

    private transient ImageView img;
    private DoubleProperty posX, posY;

    private transient Timeline gravityTimeline;
    private transient Timeline jumpTimeline;
    private transient Timeline xTimeline;
    private static double moveUpDist = 80, moveUpDur = 200, minY = 700/2, maxY = 700-50;
    private boolean paused;

    public void setImg(ImageView img) {
        this.img = img;
    }

    public DoubleProperty getPosX() {
        return posX;
    }

    public DoubleProperty getPosY() {
        return posY;
    }

    public ImageView getImage() {
        return img;
    }

    public Timeline getJumpTimeline() {
        return jumpTimeline;
    }

    protected void setPane(ImageView img) {
        this.img = img;
        System.out.println(this.img);
        this.posX = img.layoutXProperty();
        this.posY = img.layoutYProperty();
        this.gravityTimeline = new Timeline();
        this.jumpTimeline = new Timeline();
        this.xTimeline = new Timeline();
    }

    public double getWidth() {
        if(img == null)
            return 0;
        // Use only maxWidth Property in fxml objects associated with game objects
        return img.getFitWidth();
    }

    public double getHeight() {
        if(img == null) {
            System.out.println("Null Pointer!");
            return 0;
        }

        // As I've set max height property to fxml objects,
        // This means, set max height property to all game objects
        return img.getFitHeight();
    }

    // Attach itself to a particular Parent Node
    // To be modified later
    public void attachToGrid(GridPane parent, int i, int j) {
        parent.setAlignment(Pos.CENTER);
        parent.add(img, i, j);
    }

    public void attachToPane(Pane node, double i, double j) {
        node.getChildren().add(img);
        img.setLayoutX(i);
        img.setLayoutY(j);
//        For adding border to each GameObject
//        pane.setStyle("-fx-border-color: white;");
    }

    protected void loadObjtoPane(String FXMLPath) {
        ImageView temp;
        Image im;
        System.out.println(FXMLPath);
        try {
//            FXMLLoader loader = FXMLLoader.load(getClass().getResource(FXMLPath));
//            temp = loader.load();
            im = new Image(new FileInputStream(FXMLPath));
            temp = new ImageView(im);
            setPane(temp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPosX(double posX) {
        this.posX.set(posX);
    }

    public void setPosY(double posY) {
        this.posY.set(posY);
    }

    public void setGravityTimeline(Timeline gravityTimeline) {
        this.gravityTimeline = gravityTimeline;
    }

    public static void setMoveUpDist(double moveUpDist) {
        GameObjects.moveUpDist = moveUpDist;
    }

    public static void setMoveUpDur(double moveUpDur) {
        GameObjects.moveUpDur = moveUpDur;
    }

    public static void setMinY(double minY) {
        GameObjects.minY = minY;
    }

    public static void setMaxY(double maxY) {
        GameObjects.maxY = maxY;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public ImageView getImg() {
        return img;
    }

    public DoubleProperty posXProperty() {
        return posX;
    }

    public DoubleProperty posYProperty() {
        return posY;
    }

    public static double getMoveUpDur() {
        return moveUpDur;
    }

    public static double getMaxY() {
        return maxY;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        GameObjects cloned =  (GameObjects) super.clone();
        cloned.setGravityTimeline(new Timeline());
        cloned.setJumpTimeline(new Timeline());
        cloned.setxTimeline(new Timeline());
        return cloned;
    }


    public synchronized void gravity() {
        ImageView obj_pane = this.img;
        gravityTimeline.stop();
        if(paused)
            return;
        gravityTimeline = new Timeline();
        DoubleProperty layoutY = obj_pane.layoutYProperty();
//        gravityTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(moveUpDur * (maxY - layoutY.getValue())/moveUpDist), new KeyValue(layoutY, maxY, Interpolator.EASE_IN)));
        gravityTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(2300), new KeyValue(this.img.layoutYProperty(), 1000, Interpolator.LINEAR)));
        gravityTimeline.play();
    }

    public boolean isPaused() {
        return paused;
    }

    public void setJumpTimeline(Timeline jumpTimeline) {
        this.jumpTimeline = jumpTimeline;
    }

    public static double getMinY() {
        return minY;
    }

    public synchronized double jump() {
        ImageView obj_pane = this.img;
        gravityTimeline.stop();
        double ret = 0, value = moveUpDist;
        jumpTimeline.stop();
        if(paused)
            return 0;
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
        jumpTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(450), new KeyValue(this.img.layoutYProperty(), this.img.getLayoutY()-105, Interpolator.LINEAR)));
        jumpTimeline.play();
        jumpTimeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gravity();
            }
        });
        return ret;


    }

    public static double getMoveUpDist() {
        return moveUpDist;
    }

    public Timeline getGravityTimeline() {
        return gravityTimeline;
    }

    public synchronized double movX(){
        ImageView obj_pane = this.img;
        double ret = 0, value = 35;//move x units
        if(paused)
            return 0;
        xTimeline.stop();
        xTimeline = new Timeline();

        double layoutX = obj_pane.getLayoutX();

        if(layoutX - value < minY) {
            ret = minY - (layoutX - value);
            value = layoutX - minY;
        }
//        For Debugging purpose
//        System.out.println("ball y: "+ layoutY +" move ball up by: "+value + ", shift obstacles down by : "+ret);

        DoubleProperty posX = obj_pane.layoutXProperty();
        xTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(450), new KeyValue(this.img.layoutXProperty(), this.img.getLayoutX()-105, Interpolator.LINEAR)));
        xTimeline.play();
        xTimeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                xTimeline.stop();
            }
        });
        return ret;
    }




    public void setxTimeline(Timeline xTimeline) {
        this.xTimeline = xTimeline;
    }

    public synchronized double movX(int i){
        ImageView obj_pane = this.img;
        double ret = 0, value = 35;//move x units
        if(paused)
            return 0;
        xTimeline.stop();
        xTimeline = new Timeline();

        double layoutX = obj_pane.getLayoutX();

        if(layoutX - value < minY) {
            ret = minY - (layoutX - value);
            value = layoutX - minY;
        }
//        For Debugging purpose
//        System.out.println("ball y: "+ layoutY +" move ball up by: "+value + ", shift obstacles down by : "+ret);

        DoubleProperty posX = obj_pane.layoutXProperty();
        xTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(450), new KeyValue(this.img.layoutXProperty(), this.img.getLayoutX()+105, Interpolator.LINEAR)));
        xTimeline.play();
        xTimeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                xTimeline.stop();
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

    public Timeline getxTimeline() {
        return xTimeline;
    }
}