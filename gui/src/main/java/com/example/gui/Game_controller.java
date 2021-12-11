package com.example.gui;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Game_controller implements Initializable {
    @FXML
    private ImageView hero;
    @FXML
    private ImageView trees1;
    @FXML
    private ImageView trees2;
    @FXML
    private ImageView plr;
    @FXML
    private AnchorPane s2_anchor;
    @FXML
    private AnchorPane s_anchor;
    @FXML
    private ImageView si;
    @FXML
    private ImageView mi;
    @FXML
    private ImageView sai;

    @FXML
    private ImageView close_but;

    private Image b_i;
    private Image s_i;
    private Image m_i;

    @FXML
    private Label SCORE;
    @FXML
    private ImageView set_but;

    @FXML
    private ImageView isl1;
    @FXML
    private ImageView isl3;
    @FXML
    private ImageView is_2;
    @FXML
    private ImageView is_4;
    @FXML
    private Group islands;
    @FXML
    private ImageView TNT;
    @FXML
    private ImageView c1;
    @FXML
    private ImageView c2;
    @FXML
    private ImageView c3;
    @FXML
    private ImageView c4;
    @FXML
    private ImageView c5;
    boolean a = true;
    boolean inpause = true;
    boolean music = true;
    boolean sound = true;



    private TranslateTransition translate22;
    private TranslateTransition translate;
    private TranslateTransition transition;
    private TranslateTransition transition1;
    private TranslateTransition translate1;
    private TranslateTransition TI3;
    private TranslateTransition t;
    private TranslateTransition TI1;
    private TranslateTransition TI2;
    private TranslateTransition TI4;
    private TranslateTransition PLR;
    private TranslateTransition TREES1;
    private TranslateTransition TREES2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SCORE.setText("0");
        translate = new TranslateTransition();
        translate.setNode(hero);
        translate.setCycleCount(1);
        translate.setDuration(Duration.millis(30000));
        translate.setByY(10000);
        translate.play();
        translate22 = new TranslateTransition();
        translate22 = new TranslateTransition();
        translate22.setNode(TNT);
        translate22.setCycleCount(1);
        translate22.setDuration(Duration.millis(30000));
        translate22.setByY(10000);
        translate22.play();
        t = new TranslateTransition();
        TI1 = new TranslateTransition();
        TI2 = new TranslateTransition();
        transition = new TranslateTransition();
        transition1 = new TranslateTransition();
        translate1 = new TranslateTransition();
        TI3 = new TranslateTransition();
        TI4 = new TranslateTransition();
        PLR = new TranslateTransition();
        TREES1 = new TranslateTransition();
        TREES2 = new TranslateTransition();

        //Clouds Trans
        class mytimer extends AnimationTimer {
            @Override
            public void handle(long l) {

                c1.setLayoutX(c1.getLayoutX() + c1.getTranslateX() - 0.08);
                c2.setLayoutX(c2.getLayoutX() + c2.getTranslateX() - 0.12);
                c3.setLayoutX(c3.getLayoutX() + c3.getTranslateX() - 0.09);
                c4.setLayoutX(c4.getLayoutX() + c4.getTranslateX() - 0.1);
                c5.setLayoutX(c5.getLayoutX() + c5.getTranslateX() - 0.07);
                if ((c1.getLayoutX() + c1.getTranslateX()) < (-260)) {
                    c1.setLayoutX(1000);
                }
                if ((c2.getLayoutX() + c2.getTranslateX()) < (-300)) {
                    c2.setLayoutX(1000);
                }
                if ((c3.getLayoutX() + c3.getTranslateX()) < (-240)) {
                    c3.setLayoutX(1000);
                }
                if ((c4.getLayoutX() + c4.getTranslateX()) < (-200)) {
                    c4.setLayoutX(1000);
                }
                if ((c5.getLayoutX() + c5.getTranslateX()) < (-200)) {
                    c5.setLayoutX(1000);
                }
                if ((isl1.getLayoutX()+isl1.getTranslateX() < (-isl1.getFitWidth()))){
                    isl1.setLayoutX(1100);
                }
                if ((is_2.getLayoutX()+is_2.getTranslateX() < (-is_2.getFitWidth()))){
                    is_2.setLayoutX(1250);
                }
                if ((isl3.getLayoutX()+isl3.getTranslateX() < (-isl3.getFitWidth()))){
                    isl3.setLayoutX(1400);
                }
                if ((is_4.getLayoutX()+is_4.getTranslateX() < (-is_4.getFitWidth()))){
                    is_4.setLayoutX(1550);
                }
                if ((plr.getLayoutX()+plr.getTranslateX() < (-plr.getFitWidth()))){
                    plr.setLayoutX(1400);
                }
                if ((trees1.getLayoutX()+trees1.getTranslateX() < (-trees1.getFitWidth()))){
                    trees1.setLayoutX(1100);
                }
                if ((trees2.getLayoutX()+trees2.getTranslateX() < (-trees2.getFitWidth()))){
                    trees2.setLayoutX(1400);
                }

//                System.out.println(c1.getLayoutX());
            }
        }

        AnimationTimer timer = new mytimer();
        timer.start();


        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);

        EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
//
                if (hero.getTranslateY()+hero.getLayoutY()>700){
                    System.out.println("GAME OVER!!!");
                }

                boolean ret = isCollision(hero, isl1);
                boolean ret0 = isCollision(hero, is_2);
                boolean ret6 = isCollision(hero, is_4);
                boolean ret1 = isCollision(hero, TNT);
                boolean ret2 = isCollision(TNT, isl1);
                boolean ret3 = isCollision(TNT, is_2);
                boolean ret4 = isCollision(hero, isl3);
                boolean ret5 = isCollision(TNT, isl3);
                boolean ret7 = isCollision(TNT, is_4);
//                System.out.println(ret4);


                if (ret || ret0 || ret4 || ret6) {
                    translate.pause();
                    JUMP();
//

                }
                if (ret1) {

                    if (!a) {
                        translate22.pause();
                        t.pause();

                    }
                    move(-1);
                    fall(TNT);
                    detonate();
                    a = false;
                }
                if (ret2 || ret3 || ret5 || ret7) {
                    translate22.pause();
                } else {
                    translate22.play();
                }
            }

        };
        KeyFrame k = new KeyFrame(Duration.millis(3.178), onFinished);
        timeline.getKeyFrames().add(k);
        timeline.play();
        boolean a = false;
    }

    @FXML
    public void detonate() {
        System.out.println("BOOM");
        FadeTransition fd = new FadeTransition();
        ScaleTransition sc = new ScaleTransition();
        fd.setNode(TNT);
        sc.setNode(TNT);
        fd.setCycleCount(18);
        sc.setCycleCount(18);
        fd.setInterpolator(Interpolator.LINEAR);
        sc.setInterpolator(Interpolator.LINEAR);
        fd.setFromValue(1);
        fd.setToValue(0.6);
        sc.setByY(0.1);
        sc.setByX(0.1);
        fd.setAutoReverse(true);
        sc.setAutoReverse(true);
        fd.setDuration(Duration.millis(70));
        sc.setDuration(Duration.millis(70));
        fd.play();
    }



    public void fall(Node i){
        translate22.pause();
        translate22 = new TranslateTransition();
        translate22.setNode(TNT);
        translate22.setCycleCount(1);
        translate22.setDuration(Duration.millis(10000));
        translate22.setByY(10000);
        translate22.play();
    }



    @FXML
    protected void move(int dir) {
        t.pause();
        t = new TranslateTransition();
        t.setNode(TNT);
        t.setInterpolator(Interpolator.LINEAR);
        t.setCycleCount(1);
        t.setAutoReverse(false);
        t.setDuration(Duration.millis(200));
        int x = (dir == -1) ? 70 : -30;
        t.setByX(x);
        t.play();
        fall(TNT);
    }

    @FXML
    protected void move(){
        SCORE.setText(String.valueOf((Integer.parseInt(SCORE.getText())+1)));
        t.pause();
        TI1.pause();
        TI2.pause();
        TI3.pause();
        TI4.pause();
        PLR.pause();
        TREES1.pause();
        TREES2.pause();
        t = new TranslateTransition();
        t.setNode(TNT);
        t.setInterpolator(Interpolator.LINEAR);
        t.setCycleCount(1);
        t.setAutoReverse(false);
        t.setDuration(Duration.millis(200));
        t.setByX(-30);
        TI1 = new TranslateTransition();
        TI1.setNode(isl1);
        TI1.setInterpolator(Interpolator.LINEAR);
        TI1.setCycleCount(1);
        TI1.setAutoReverse(false);
        TI1.setDuration(Duration.millis(200));
        TI1.setByX(-30);
        TI2 = new TranslateTransition();
        TI2.setNode(is_2);
        TI2.setInterpolator(Interpolator.LINEAR);
        TI2.setCycleCount(1);
        TI2.setAutoReverse(false);
        TI2.setDuration(Duration.millis(200));
        TI2.setByX(-30);
        TI3 = new TranslateTransition();
        TI3.setNode(isl3);
        TI3.setInterpolator(Interpolator.LINEAR);
        TI3.setCycleCount(1);
        TI3.setAutoReverse(false);
        TI3.setDuration(Duration.millis(200));
        TI3.setByX(-30);
        TI4 = new TranslateTransition();
        TI4.setNode(is_4);
        TI4.setInterpolator(Interpolator.LINEAR);
        TI4.setCycleCount(1);
        TI4.setAutoReverse(false);
        TI4.setDuration(Duration.millis(200));
        TI4.setByX(-30);
        PLR = new TranslateTransition();
        PLR.setNode(plr);
        PLR.setInterpolator(Interpolator.LINEAR);
        PLR.setCycleCount(1);
        PLR.setAutoReverse(false);
        PLR.setDuration(Duration.millis(200));
        PLR.setByX(-30);
        TREES1 = new TranslateTransition();
        TREES1.setNode(trees1);
        TREES1.setInterpolator(Interpolator.LINEAR);
        TREES1.setCycleCount(1);
        TREES1.setAutoReverse(false);
        TREES1.setDuration(Duration.millis(200));
        TREES1.setByX(-30);
        TREES2 = new TranslateTransition();
        TREES2.setNode(trees2);
        TREES2.setInterpolator(Interpolator.LINEAR);
        TREES2.setCycleCount(1);
        TREES2.setAutoReverse(false);
        TREES2.setDuration(Duration.millis(200));
        TREES2.setByX(-30);

        t.play();
        TI1.play();
        TI2.play();
        TI3.play();
        TI4.play();
        PLR.play();
        TREES1.play();
        TREES2.play();
    }


    public boolean isCollision(ImageView img, ImageView obs){
//        Bounds boundsInScreen = img.localToScreen(img.getBoundsInLocal());
//
            double x =  img.getTranslateX()+img.getLayoutX();
        double y =  img.getTranslateY()+img.getLayoutY();
        double w =  img.getFitWidth();
        double h =  img.getFitHeight();

        double x_ =  obs.getTranslateX()+obs.getLayoutX();
        double y_ =  obs.getTranslateY()+obs.getLayoutY();
        double w_ =  obs.getFitWidth();
        double h_ =  obs.getFitHeight();

        boolean fxfx;
        fxfx = (x_ <= x+w && x+w <= x_+w_) || (x <= x_+w_ && x_+w_ <= x+w);
        boolean fyfy;
        fyfy = (y_ <= y && y <= y_+h_) || (y <= y_ && y_ <= y+h);
        return (fxfx&&fyfy);
    }



    public void JUMP(){
        translate.pause();
        translate = new TranslateTransition();
        translate.setNode(hero);
        translate.setCycleCount(1);
        translate.setDuration(Duration.millis(300));
        translate.setInterpolator(Interpolator.LINEAR);
        transition.setAutoReverse(false);
        translate.setByY(-100);
        translate.play();
        translate.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                translate = new TranslateTransition();
                translate.setNode(hero);
                translate.setCycleCount(1);
                translate.setDuration(Duration.millis(30000));
                translate.setAutoReverse(false);
                translate.setByY(10000);
                translate.setInterpolator(Interpolator.LINEAR);

                translate.play();
            }
        });
    }

    @FXML
    protected void go_to_pauseset(MouseEvent event) throws IOException {
        inpause = true;
//        System.out.println(stack_pane.getChildren());
//        Parent root = FXMLLoader.load(getClass().getResource("Pause_set.fxml"));
        Parent root = s2_anchor;
        Scene scene2 = set_but.getScene();
        root.translateYProperty().set(scene2.getHeight());
        root.translateYProperty().setValue(-2000);
//        stack_pane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(),0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.millis(750),kv);
        timeline.getKeyFrames().add(kf);
//        timeline.setOnFinished( (ActionEvent e)->{
////            stack_pane.getChildren().remove(s0_anchor);
////            stack_pane.getChildren().remove(s1_anchor);
//            stack_pane.getChildren().remove(s_anchor);
//        });
        timeline.play();


//        System.out.println(stack_pane.getChildren());



//        fxmlLoader = new FXMLLoader(getClass().getResource("Pause_set.fxml"));
//        scene = new Scene(fxmlLoader.load());
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setTitle("This Pause/Settings Menu");
//        stage.setScene(scene);
//        stage.show();
    }

    @FXML
    protected void go_to_home(MouseEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("Game_home.fxml"));
//        System.out.println(stack_pane.getChildren());
//        Scene scene2 = close_but.getScene();
//        root.translateXProperty().set(scene2.getWidth());
//        root.translateXProperty().setValue(-2000);
//        stack_pane.getChildren().add(root);
//        Timeline timeline = new Timeline();
//        KeyValue kv = new KeyValue(root.translateXProperty(),0, Interpolator.EASE_IN);
//        KeyFrame kf = new KeyFrame(Duration.millis(750),kv);
//        timeline.getKeyFrames().add(kf);
//        timeline.setOnFinished( (ActionEvent e)->{
//            stack_pane.getChildren().remove(s2_anchor);
//        });
//
//        timeline.play();
//        inpause = false;
//        System.out.println(stack_pane.getChildren());
//        Parent root = FXMLLoader.load(getClass().getResource("Game_home.fxml"));
        Parent root = s_anchor;
//        System.out.println(stack_pane.getChildren());
        Scene scene2 = close_but.getScene();
        root.translateXProperty().set(scene2.getWidth());
        root.translateXProperty().setValue(-2000);
//        stack_pane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(),0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.millis(750),kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished( (ActionEvent e)->{
//            stack_pane.getChildren().remove(s2_anchor);
        });

        timeline.play();
        inpause = false;
//        System.out.println(stack_pane.getChildren());


//        fxmlLoader = new FXMLLoader(getClass().getResource("Game_home.fxml"));
//        scene = new Scene(fxmlLoader.load());
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setTitle("This Pause/Settings Menu");
//        stage.setScene(scene);
//        stage.show();
//        System.out.println(stack_pane.getChildren());
    }

    @FXML
    public void music_onoff(MouseEvent event) throws IOException {
        try {
            if (music) {
                m_i = new Image(getClass().getResourceAsStream("Image_src/music_off.png"));
                music = false;
            } else {
                m_i = new Image(getClass().getResourceAsStream("Image_src/music_on.png"));
                music = true;
            }
        } catch (Exception e) {
            System.out.println("Not working m");
        }
        mi.setImage(m_i);
    }

    @FXML
    public void sound_onoff(MouseEvent event) throws IOException {
        try {
            if (sound) {
                s_i = new Image(getClass().getResourceAsStream("Image_src/sound_off.png"));
                sound = false;
            } else {
                s_i = new Image(getClass().getResourceAsStream("Image_src/s_on.png"));
                sound = true;
            }
        } catch (Exception e) {
            System.out.println("Not working s");
        }
        si.setImage(s_i);
    }

    @FXML
    public void save_tran(MouseEvent event) throws IOException {
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setNode(sai);
        fade.setFromValue(1);
        fade.setToValue(0.5);
        fade.play();
    }

}
