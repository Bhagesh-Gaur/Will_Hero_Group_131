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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class homepage_controller implements Initializable, Serializable {

    @FXML
    private Pane pane_root;
    @FXML
    private Pane pane_background;
    @FXML
    private Pane pane_background1;
    @FXML
    private Pane pane_gamehome;
    @FXML
    private Pane pane_clouds;
    @FXML
    private Group group_clouds;
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
    private ImageView grp_is3;
    @FXML
    private Group grp_is1;
    @FXML
    private Group grp_is2;
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
    private ImageView set_but;
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

    private boolean music;
    private boolean sound;
    private boolean bi;
    private Image b_i;
    private Image s_i;
    private Image m_i;
    private int x;
    private boolean inpause;
    private Stage ps;
    @FXML
    private ImageView si;
    @FXML
    private ImageView mi;
    @FXML
    private ImageView sai;
    @FXML
    private Label coin_count;
    @FXML
    private Label best_score;






    @FXML
    Pane obstaclesBox, overlay;

    @FXML
    BorderPane paused, resurrect;

    @FXML
    Text score, resurrectCount;

    @FXML Text game_over_score, game_over_highscore;

    @FXML ImageView inGameSaveBtn;

    private Game game;

    @FXML
    private void backToHome(MouseEvent me) throws Exception {
        Main.getInstance().load_homepage();
    }

    public void setGameOverScores(int score, int highscore){
        game_over_score.setText(score + "");
        game_over_highscore.setText(highscore + "");
    }

    public void set_bestcore(int s){
        best_score.setText(s+"");
    }

    public void set_coincount(int s){
        coin_count.setText(s+"");
    }


    public void setScore(int _score) {
        score.setText(_score+"");
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        music = true;
        sound = true;
        bi = true;
        inpause = false;
        x = 0;


        //title trans
        TranslateTransition tran = new TranslateTransition();
        tran.setDuration(Duration.millis(2500));
        tran.setNode(title);
        tran.setToY(17);
        tran.setAutoReverse(true);
        tran.setCycleCount(PathTransition.INDEFINITE);
        tran.play();

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
        m_prin1.setAutoReverse(true);
        m_prin1.play();


        //Clouds Trans
        class mytimer extends AnimationTimer {
            @Override
            public void handle(long l) {
                set_bestcore(Main.getInstance().getCurrentPlayer().getHighScore());
                set_coincount(Main.getInstance().getCurrentPlayer().getCoin().getCoinVal());
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
                    }
            }
        }

        AnimationTimer timer = new mytimer();
        timer.start();

    }

    @FXML
    public void exit_fun(MouseEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        Stage stage;
        a.setTitle("Exit Will Hero!");
        a.setHeaderText("You are about to close Will Hero!");
        a.setContentText("Do you really wish to exit Will Hero?");
        if(a.showAndWait().get() == ButtonType.OK){
            stage = (Stage)pane_background.getScene().getWindow();
            Main.getInstance().getDb().serialize();
            System.out.println("Will Hero Exited Successfully!");
            stage.close();
        }
    }

    @FXML
    protected void go_to_pauseset(MouseEvent event) throws IOException {
        inpause = true;
        ps = Main.getInstance().getPrimaryStage();
        Scene sc = ps.getScene();
        System.out.println(sc.getRoot());
        Pane ap = (Pane) sc.getRoot();
        System.out.println(ap);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pause_set.fxml"));
        System.out.println(loader);
        Scene sc2 = loader.load();
        System.out.println(loader.load()+" ");
    }

    @FXML
    protected void go_to_home(MouseEvent event) throws IOException {

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
        Stage currentStage = (Stage) pane_background.getScene().getWindow();
        currentStage.setScene(newScene);
    }

    @FXML
    public void gotologin(MouseEvent event) throws Exception {
//        Parent sc2 = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
//        Scene newScene = new Scene(sc2,1000,700);
//        Stage currentStage = (Stage) pane_background.getScene().getWindow();
//        currentStage.setScene(newScene);
        Main.getInstance().load_login();

    }

    @FXML
    public void gotolead(MouseEvent event) throws Exception {
//        Parent sc2 = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
//        Scene newScene = new Scene(sc2,1000,700);
//        Stage currentStage = (Stage) pane_background.getScene().getWindow();
//        currentStage.setScene(newScene);
        Main.getInstance().load_leaderboard();

    }

    @FXML
    public void gotoload(MouseEvent event) throws Exception {
        Main.getInstance().load_SavedGames();
    }

    @FXML
    public void gotonew(MouseEvent event) throws Exception {
        Main.getInstance().load_NewGame();
    }

    @FXML
    private void loadPauseset(MouseEvent me) throws Exception {
        inpause = true;

        Main.getInstance().load_pauseset();
    }






    private boolean resurrectSuccess;

    public void pause() {
        System.out.println("Game was paused!");
        paused.setVisible(true);
        overlay.setVisible(true);
    }

    public void toggleResurrectSuccess() {
        resurrectSuccess = !resurrectSuccess;
    }

    public boolean displayResurrect() {
        resurrectSuccess = false;
        resurrect.setVisible(true);
        overlay.setVisible(true);

        System.out.println("Hello World, resurecting");

        for(int i=5; i>=0; --i) {
            if(resurrectSuccess)
                break;

            resurrectCount.setText(i+"");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        resurrect.setVisible(false);
        overlay.setVisible(false);
        return resurrectSuccess;
    }

    public void mouseClicked(MouseEvent mouseEvent) {
//        Main.getInstance().playTapSound();
//        game.shiftObstacles();
    }

    public void backToHome() throws Exception {
        Main.getInstance().load_homepage();
    }

    public void resume() throws Exception {
        overlay.setVisible(false);
        paused.setVisible(false);
    }

    public void keyPressed(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        if (keyCode == KeyCode.SPACE){
//            Main.getInstance().playKeyPressedSound();
//            game.shiftObstacles();
        }
    }

    public void inGameSaveOption(MouseEvent mouseEvent) {

    }
}
