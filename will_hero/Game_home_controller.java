package com.example.will_hero;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Game_home_controller implements Initializable {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private FXMLLoader fxmlLoader;
    @FXML
    private ImageView si;
    @FXML
    private ImageView mi;
    @FXML
    private ImageView sai;
    @FXML
    private StackPane stack_pane;
    @FXML
    private AnchorPane s0_anchor;
    @FXML
    private AnchorPane s1_anchor;
    @FXML
    private AnchorPane s2_anchor;
    @FXML
    private AnchorPane s_anchor;
    @FXML
    private ImageView set_but;
    @FXML
    private ImageView close_but;
    @FXML
    private ImageView title;
    @FXML
    private ImageView leader_but;
    @FXML
    private ImageView newgame_but;
    @FXML
    private ImageView login_but;
    @FXML
    private ImageView loadgame_but;
    @FXML
    private ImageView exit_but;
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
    @FXML
    private Label coin_count;
    @FXML
    private Label best_score;



    private boolean music;
    private boolean sound;
    private boolean bi;
    private Image b_i;
    private Image s_i;
    private Image m_i;
    private int x;
    private boolean inpause;
    private Stage ps;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        music = true;
        sound = true;
        bi = true;
        inpause = false;
        x = 0;

//        stack_pane.getChildren().add(s0_anchor);
//        stack_pane.getChildren().add(s1_anchor);
        stack_pane.getChildren().add(s_anchor);
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

        //leader board icon tran
        RotateTransition leader_rot = new RotateTransition();
        leader_rot.setNode(leader_but);
        leader_rot.setDuration(Duration.millis(750));
        leader_rot.setCycleCount(PathTransition.INDEFINITE);
        leader_rot.setInterpolator(Interpolator.LINEAR);
        leader_rot.setByAngle(10);
        leader_rot.setAxis(Rotate.Z_AXIS);
        leader_rot.setAutoReverse(true);
        leader_rot.play();

        //NewGame icon tran
        ScaleTransition newgame_tran = new ScaleTransition();
        newgame_tran.setNode(newgame_but);
        newgame_tran.setDuration(Duration.millis(750));
        newgame_tran.setCycleCount(PathTransition.INDEFINITE);
        newgame_tran.setInterpolator(Interpolator.LINEAR);
        newgame_tran.setByX(0.01);
        newgame_tran.setByY(0.01);
        newgame_tran.setAutoReverse(true);
        newgame_tran.play();

        //LoadGame icon tran
        ScaleTransition loadgame_tran = new ScaleTransition();
        loadgame_tran.setNode(loadgame_but);
        loadgame_tran.setDuration(Duration.millis(750));
        loadgame_tran.setCycleCount(PathTransition.INDEFINITE);
        loadgame_tran.setInterpolator(Interpolator.LINEAR);
        loadgame_tran.setByX(0.01);
        loadgame_tran.setByY(0.01);
        loadgame_tran.setAutoReverse(true);
        loadgame_tran.play();

        //Login icon tran
        ScaleTransition login_tran = new ScaleTransition();
        login_tran.setNode(login_but);
        login_tran.setDuration(Duration.millis(750));
        login_tran.setCycleCount(PathTransition.INDEFINITE);
        login_tran.setInterpolator(Interpolator.LINEAR);
        login_tran.setByX(0.01);
        login_tran.setByY(0.01);
        login_tran.setAutoReverse(true);
        login_tran.play();

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
                if (!inpause) {
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
        }

        AnimationTimer timer = new mytimer();
        timer.start();

    }

//    public void change_boss(){
//
//        if(x%2 == 0){
//            try {
//                if (bi) {
//                    b_i = new Image(getClass().getResourceAsStream("Image_src/Collide/c_redorg1.png"));
//                    bi = false;
//                } else {
//                    b_i = new Image(getClass().getResourceAsStream("Image_src/Collide/c_redorg.png"));
//                    bi = true;
//                }
//            } catch (Exception e) {
//                System.out.println("Not working s");
//            }
//            king_org.setImage(b_i);
//            x += 1;
//            System.out.println(x);
//        }
//    }

    @FXML
    public void exit_fun(MouseEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Exit Will Hero!");
        a.setHeaderText("You are about to close Will Hero!");
        a.setContentText("Do you really wish to exit Will Hero?");
        if(a.showAndWait().get() == ButtonType.OK){
            stage = (Stage)s1_anchor.getScene().getWindow();
            Main.getInstance().getDb().serialize();
            System.out.println("Will Hero Exited Successfully!");
            stage.close();
        }
    }

    @FXML
    protected void go_to_pauseset(MouseEvent event) throws IOException {
//        inpause = true;
////        System.out.println(stack_pane.getChildren());
////        Parent root = FXMLLoader.load(getClass().getResource("Pause_set.fxml"));
//        Parent root = s2_anchor;
//        Scene scene2 = set_but.getScene();
//        root.translateYProperty().set(scene2.getHeight());
//        root.translateYProperty().setValue(-2000);
//        stack_pane.getChildren().add(root);
//        Timeline timeline = new Timeline();
//        KeyValue kv = new KeyValue(root.translateYProperty(),0, Interpolator.EASE_IN);
//        KeyFrame kf = new KeyFrame(Duration.millis(750),kv);
//        timeline.getKeyFrames().add(kf);
//        timeline.setOnFinished( (ActionEvent e)->{
////            stack_pane.getChildren().remove(s0_anchor);
////            stack_pane.getChildren().remove(s1_anchor);
//            stack_pane.getChildren().remove(s_anchor);
//        });
//        timeline.play();

        ps = Main.getInstance().getPrimaryStage();
        Scene sc = ps.getScene();
        System.out.println(sc.getRoot());
        Pane ap = (Pane) sc.getRoot();
        System.out.println(ap);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pause_set.fxml"));
        System.out.println(loader);
        Scene sc2 = loader.load();
        System.out.println(loader.load()+" ");//+sc2.getRoot());
//        Pane temp = (Pane)sc2.getRoot();
//        temp.setLayoutX(0);
//        temp.setLayoutY(700);
//        ap.getChildren().add(temp);
//        Parent root = temp;
//        Scene scene2 = set_but.getScene();
//        root.translateYProperty().set(scene2.getHeight());
//        root.translateYProperty().setValue(-2000);
////        stack_pane.getChildren().add(root);
//        Timeline timeline = new Timeline();
//        KeyValue kv = new KeyValue(root.translateYProperty(),0, Interpolator.EASE_IN);
//        KeyFrame kf = new KeyFrame(Duration.millis(750),kv);
//        timeline.getKeyFrames().add(kf);
//        timeline.setOnFinished( (ActionEvent e)->{
////            stack_pane.getChildren().remove(s0_anchor);
////            stack_pane.getChildren().remove(s1_anchor);
////            stack_pane.getChildren().remove(s_anchor);
//            temp.setLayoutX(0);
//            temp.setLayoutY(0);
//        });
//        timeline.play();



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
        System.out.println(stack_pane.getChildren());
        Scene scene2 = close_but.getScene();
        root.translateXProperty().set(scene2.getWidth());
        root.translateXProperty().setValue(-2000);
        stack_pane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(),0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.millis(750),kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished( (ActionEvent e)->{
            stack_pane.getChildren().remove(s2_anchor);
        });

        timeline.play();
        inpause = false;
        System.out.println(stack_pane.getChildren());


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

    @FXML
    public void startgame() throws IOException {
        Parent sc2 = (AnchorPane) FXMLLoader.load(getClass().getResource("Game_play.fxml"));
        Scene newScene = new Scene(sc2,1000,700);
        Stage currentStage = (Stage) s1_anchor.getScene().getWindow();
        currentStage.setScene(newScene);
    }

    @FXML
    public void gotologin(MouseEvent event) throws IOException {
//        AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
////        System.out.println(stack_pane.getChildren());
//        Scene scene2 = login_but.getScene();
//        s1_anchor.setOpacity(0);
////        root.translateXProperty().set(scene2.getWidth());
////        root.translateXProperty().setValue(-2000);
////        stack_pane.getChildren().add(root);
////        Timeline timeline = new Timeline();
////        KeyValue kv = new KeyValue(root.translateXProperty(),0, Interpolator.EASE_IN);
////        KeyFrame kf = new KeyFrame(Duration.millis(750),kv);
////        timeline.getKeyFrames().add(kf);
////        timeline.setOnFinished( (ActionEvent e)->{
////            stack_pane.getChildren().remove(s2_anchor);
////        });
////
////        timeline.play();
//        Pane x = (Pane)scene2.getRoot();
//        x.getChildren().add(root);
        Parent sc2 = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene newScene = new Scene(sc2,1000,700);
        Stage currentStage = (Stage) s1_anchor.getScene().getWindow();
        currentStage.setScene(newScene);

    }



}