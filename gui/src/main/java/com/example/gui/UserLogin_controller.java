package com.example.gui;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class UserLogin_controller implements Initializable {
    @FXML
    private AnchorPane login_anchor;
    @FXML
    private Button login_but1;
    @FXML
    private Button createaccount_but;
    @FXML
    private ImageView close_but;







    @FXML
    private ImageView title;
    @FXML
    private ImageView hero;
    @FXML
    private ImageView king_org;
    @FXML
    private ImageView hero1;
    @FXML
    private ImageView hero2;
    @FXML
    private ImageView princess;
    @FXML
    private Group grp_is1;
    @FXML
    private Group grp_is2;
    @FXML
    private ImageView grp_is3;
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

    private boolean bi;
    private Image b_i;
    private int x;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bi = true;
        x = 0;
        //Title trans
        TranslateTransition tran = new TranslateTransition();
        tran.setDuration(Duration.millis(2500));
        tran.setNode(title);
        tran.setToY(20);
        tran.setAutoReverse(true);
        tran.setCycleCount(PathTransition.INDEFINITE);
        tran.play();

        //island trans
        TranslateTransition island1 = new TranslateTransition();
        island1.setDuration(Duration.millis(2500));
        island1.setNode(grp_is1);
        island1.setToX(65);
        island1.setAutoReverse(true);
        island1.setCycleCount(PathTransition.INDEFINITE);
        island1.play();
        TranslateTransition island2 = new TranslateTransition();
        island2.setDuration(Duration.millis(2000));
        island2.setNode(grp_is2);
        island2.setToX(-45);
        island2.setAutoReverse(true);
        island2.setCycleCount(PathTransition.INDEFINITE);
        island2.play();
        TranslateTransition island3 = new TranslateTransition();
        island3.setDuration(Duration.millis(3000));
        island3.setNode(grp_is3);
        island3.setToX(35);
        island3.setAutoReverse(true);
        island3.setCycleCount(PathTransition.INDEFINITE);
        island3.play();


        //hero trans
        TranslateTransition m_hero = new TranslateTransition();
        m_hero.setDuration(Duration.millis(700));
        m_hero.setNode(hero);
        m_hero.setToY(-80);
        m_hero.setAutoReverse(true);
        m_hero.setCycleCount(PathTransition.INDEFINITE);
        m_hero.play();
        ScaleTransition m_heros = new ScaleTransition();
        m_heros.setNode(hero);
        m_heros.setDuration(Duration.millis(750));
        m_heros.setCycleCount(PathTransition.INDEFINITE);
        m_heros.setInterpolator(Interpolator.LINEAR);
        m_heros.setByX(0.05);
        m_heros.setByY(0.05);
        m_heros.setAutoReverse(true);
        m_heros.play();


        //King org trans
        TranslateTransition kingorg = new TranslateTransition();
        kingorg.setDuration(Duration.millis(400));
        kingorg.setNode(king_org);
        kingorg.setToY(-7);
        kingorg.setAutoReverse(true);
        kingorg.setCycleCount(PathTransition.INDEFINITE);
        kingorg.play();
//        ScaleTransition m_heros = new ScaleTransition();
//        m_heros.setNode(hero);
//        m_heros.setDuration(Duration.millis(750));
//        m_heros.setCycleCount(PathTransition.INDEFINITE);
//        m_heros.setInterpolator(Interpolator.LINEAR);
//        m_heros.setByX(0.05);
//        m_heros.setByY(0.05);
//        m_heros.setAutoReverse(true);
//        m_heros.play();

        //hero1 trans
        TranslateTransition m_hero1 = new TranslateTransition();
        m_hero1.setDuration(Duration.millis(600));
        m_hero1.setNode(hero1);
        m_hero1.setToY(-50);
        m_hero1.setAutoReverse(true);
        m_hero1.setCycleCount(PathTransition.INDEFINITE);
        m_hero1.play();
        ScaleTransition m_heros1 = new ScaleTransition();
        m_heros1.setNode(hero1);
        m_heros1.setDuration(Duration.millis(750));
        m_heros1.setCycleCount(PathTransition.INDEFINITE);
        m_heros1.setInterpolator(Interpolator.LINEAR);
        m_heros1.setByX(0.05);
        m_heros1.setByY(0.05);
        m_heros1.setAutoReverse(true);
        m_heros1.play();

        //hero2 trans
        TranslateTransition m_hero2 = new TranslateTransition();
        m_hero2.setDuration(Duration.millis(400));
        m_hero2.setNode(hero2);
        m_hero2.setToY(-20);
        m_hero2.setAutoReverse(true);
        m_hero2.setCycleCount(PathTransition.INDEFINITE);
        m_hero2.play();
        ScaleTransition m_heros2 = new ScaleTransition();
        m_heros2.setNode(hero2);
        m_heros2.setDuration(Duration.millis(750));
        m_heros2.setCycleCount(PathTransition.INDEFINITE);
        m_heros2.setInterpolator(Interpolator.LINEAR);
        m_heros2.setByX(0.05);
        m_heros2.setByY(0.05);
        m_heros2.setAutoReverse(true);
        m_heros2.play();

        //princess trans
        TranslateTransition m_prin = new TranslateTransition();
        m_prin.setDuration(Duration.millis(300));
        m_prin.setNode(princess);
        m_prin.setToY(-10);
        m_prin.setAutoReverse(true);
        m_prin.setCycleCount(PathTransition.INDEFINITE);
        m_prin.play();
        ScaleTransition m_prin1 = new ScaleTransition();
        m_prin1.setNode(princess);
        m_prin1.setDuration(Duration.millis(650));
        m_prin1.setCycleCount(PathTransition.INDEFINITE);
        m_prin1.setInterpolator(Interpolator.LINEAR);
        m_prin1.setByX(0.01);
//        m_prin1.setByY(0.05);
        m_prin1.setAutoReverse(true);
        m_prin1.play();

        //Clouds Trans
        class mytimer extends AnimationTimer {
            @Override
            public void handle(long l) {
                System.out.println(king_org);
                if (x % 26 == 0) {
                        try {
                            if (bi) {
                                b_i = new Image(getClass().getResourceAsStream("Image_src/Collide/c_redorg1.png"));
                                bi = false;
                            } else {
                                b_i = new Image(getClass().getResourceAsStream("Image_src/Collide/c_redorg.png"));
                                bi = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Not working s");
                        }
                        king_org.setImage(b_i);
                        if (!bi) {
                            king_org.setOpacity(0.87);
                        } else {
                            king_org.setOpacity(1);
                        }
                        System.out.println(x);
                    }
                    x += 1;

                    king_org.setImage(b_i);
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
                    System.out.println(c1.getLayoutX());
                }
        }

        AnimationTimer timer = new mytimer();
        timer.start();

    }




















    @FXML
    public void close_login(MouseEvent event) throws Exception{
        Parent sc2 = (Pane) FXMLLoader.load(getClass().getResource("Game_home.fxml"));
        Scene newScene = new Scene(sc2,1000,700);
        Stage currentStage = (Stage) login_anchor.getScene().getWindow();
        currentStage.setScene(newScene);
    }

    @FXML
    public void login() throws Exception{
//        Parent root = login_anchor;
////        System.out.println(stack_pane.getChildren());
//        Scene scene2 = close_but.getScene();
//        root.translateXProperty().set(scene2.getWidth());
//        root.translateXProperty().setValue(-2000);
////        stack_pane.getChildren().add(root);
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
//        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
//        System.out.println(stack_pane.getChildren());
//        Scene scene2 = login_but1.getScene();
//        Pane x = (Pane)scene2.getRoot();
//        AnchorPane home = (AnchorPane) x.getChildren().get(1);
//        AnchorPane home2 =(AnchorPane) home.getChildren().get(2);
//        home2.setOpacity(1);
        Parent sc2 = (Pane) FXMLLoader.load(getClass().getResource("Game_home.fxml"));
        Scene newScene = new Scene(sc2,1000,700);
        Stage currentStage = (Stage) login_anchor.getScene().getWindow();
        currentStage.setScene(newScene);

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


    }

    @FXML
    public void createaccount() throws Exception{
        Parent sc2 = (Pane) FXMLLoader.load(getClass().getResource("Game_home.fxml"));
        Scene newScene = new Scene(sc2,1000,700);
        Stage currentStage = (Stage) login_anchor.getScene().getWindow();
        currentStage.setScene(newScene);
    }

}
