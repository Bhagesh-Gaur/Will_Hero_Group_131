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

public class Game_controller implements Initializable, Serializable {

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
    private Pane gameover_pane;
    @FXML
    private Pane resur_pane;
    @FXML
    private Pane pause_pane;
    @FXML
    private Label gm_score;
    @FXML
    private Label gm_coin;


    @FXML
    private ImageView set_but;

    private boolean resurrectSuccess;
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
    private ImageView exit_but;
    @FXML
    private Pane Proot_pane;
    @FXML
    private Pane Creroot_pane;








    @FXML
    Pane obstaclesBox;

    @FXML
    BorderPane paused, resurrect;

    @FXML
    Text score, resurrectCount;

    @FXML
    Label score_count,coin_count;

    @FXML Text game_over_score, game_over_highscore;

    @FXML ImageView inGameSaveBtn;

    private Game game;

    private boolean res_in;


    @FXML
    private void backToHome(MouseEvent me) throws Exception {
        Main.getInstance().load_homepage();
    }

    public void setGameOverScores(int score, int highscore){
        game_over_score.setText(score + "");
        game_over_highscore.setText(highscore + "");
    }


    public void setScore(int _score) {
        score_count.setText(_score+"");
    }

    public void setCoinCount(int _score) {
        coin_count.setText(_score+"");
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

        //Clouds Trans
        class mytimer extends AnimationTimer {
            @Override
            public void handle(long l) {
                if (!inpause) {

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
        if(Main.getInstance().getCurrentPlayer().getPassword().length()>0) {
            Main.getInstance().getCurrentPlayer().setHighScore(Math.max(game.getScore(), Main.getInstance().getCurrentPlayer().getHighScore()));
            Main.getInstance().getCurrentPlayer().setCurrentScore(game.getScore());
            if (Main.getInstance().getCurrentPlayer().getHelmet().isHas_axe()) {
                Main.getInstance().getCurrentPlayer().setLevel(Main.getInstance().getCurrentPlayer().getHelmet().getAxe().getLevel());
            } else if (Main.getInstance().getCurrentPlayer().getHelmet().isHas_spear()) {
                Main.getInstance().getCurrentPlayer().setLevel(Main.getInstance().getCurrentPlayer().getHelmet().getSpear().getLevel());
            }

            Main.getInstance().getDb().getDetails().get(Main.getInstance().getDb().getDetails().size() - 1).set(2, Main.getInstance().getCurrentPlayer().getHighScore() + "");
            Main.getInstance().getDb().getDetails().get(Main.getInstance().getDb().getDetails().size() - 1).set(3, Main.getInstance().getCurrentPlayer().getCoin().getCoinVal() + "");
            Main.getInstance().getDb().getDetails().get(Main.getInstance().getDb().getDetails().size() - 1).set(4, Main.getInstance().getCurrentPlayer().getCurrentScore() + "");
            Main.getInstance().getDb().getDetails().get(Main.getInstance().getDb().getDetails().size() - 1).set(5, Main.getInstance().getCurrentPlayer().getWeap());
            Main.getInstance().getDb().getDetails().get(Main.getInstance().getDb().getDetails().size() - 1).set(6, Main.getInstance().getCurrentPlayer().getLevel() + "");
        }
//        Main.getInstance().getDb().serialize();
    }

    @FXML
    public void loadPrivacypage(MouseEvent event) throws Exception {
        TranslateTransition tp = new TranslateTransition();
        tp.setNode(Proot_pane);
        tp.setToX(1020);
        tp.setDuration(Duration.millis(750));
        tp.play();
    }

    @FXML
    public void loadPriBack(MouseEvent event) throws Exception {
        TranslateTransition tp = new TranslateTransition();
        tp.setNode(Proot_pane);
        tp.setToX(-1020);
        tp.setDuration(Duration.millis(750));
        tp.play();
    }

    @FXML
    public void loadCredits(MouseEvent event) throws Exception {
        TranslateTransition tp = new TranslateTransition();
        tp.setNode(Creroot_pane);
        tp.setToX(1020);
        tp.setDuration(Duration.millis(750));
        tp.play();
    }

    @FXML
    public void loadCreBack(MouseEvent event) throws Exception {
        TranslateTransition tp = new TranslateTransition();
        tp.setNode(Creroot_pane);
        tp.setToX(-1020);
        tp.setDuration(Duration.millis(750));
        tp.play();
    }

    @FXML
    public void loadQuit(MouseEvent event) throws Exception {
        Main.getInstance().load_homepage();
    }

    @FXML
    public void loadPause(MouseEvent event) throws Exception {
        inpause = true;
        TranslateTransition tp = new TranslateTransition();
        tp.setNode(pause_pane);
        tp.setToY(720);
        tp.setDuration(Duration.millis(750));
        tp.play();
    }

    @FXML
    public void loadBack(MouseEvent event) throws Exception {
        inpause = false;
        TranslateTransition tp = new TranslateTransition();
        tp.setNode(pause_pane);
        tp.setToY(-720);
        tp.setDuration(Duration.millis(750));
        tp.play();
    }

    public synchronized void gameover(int coin_count, int score){
//        TranslateTransition tp = new TranslateTransition();
//        tp.setNode(gameover_pane);
//        tp.setToX(-770);
//        tp.setDuration(Duration.millis(750));
//        tp.play();
        gm_score.setText(score+"");
        gm_coin.setText(coin_count+"");
        FadeTransition fade = new FadeTransition();
        fade.setNode(gameover_pane);
        fade.setDuration(Duration.millis(350));
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent e)->{
            gameover_pane.setLayoutX(250);
            gameover_pane.setLayoutY(150);
            FadeTransition fade1 = new FadeTransition();
            fade1.setNode(gameover_pane);
            fade1.setDuration(Duration.millis(350));
            fade1.setFromValue(0);
            fade1.setToValue(1);
            fade1.play();
        });
    }

    public void resurrect_open(){
        FadeTransition fade = new FadeTransition();
        fade.setNode(resur_pane);
        fade.setDuration(Duration.millis(350));
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent e)->{
            resur_pane.setLayoutX(250);
            resur_pane.setLayoutY(150);
            FadeTransition fade1 = new FadeTransition();
            fade1.setNode(resur_pane);
            fade1.setDuration(Duration.millis(350));
            fade1.setFromValue(0);
            fade1.setToValue(1);
            fade1.play();
        });
    }


    public void res_inT(MouseEvent e) throws Exception{
        resurrect_close();
        game.getHero().getImage().setLayoutX(180);
        game.getHero().getImage().setLayoutY(120);
        if(game.getPlayer().getHelmet().isHas_spear()){
            game.getPlayer().getHelmet().getSpear().getImage().setOpacity(1);
        }
        if(game.getPlayer().getHelmet().isHas_axe()){
            game.getPlayer().getHelmet().getAxe().getImage().setOpacity(1);
        }


        game.getHero().gravity();
        game.getPlayer().res();

            game.setCoin_count(game.getCoin_count() -10);
            coin_count.setText(game.getCoin_count()+"");
            game.getPlayer().getCoin().setCoinValue(game.getCoin_count());
//            Main.getInstance().getDb().get

        res_in = true;
    }
    public void res_inF(MouseEvent e) throws Exception{
        resurrect_close();
        res_in = false;
        game.gm(game.getCoin_count(),game.getScoreCount());


    }

    public void input(MouseEvent e) throws IOException{
        game.jum();
    }


    public void resurrect_close(){
        FadeTransition fade = new FadeTransition();
        fade.setNode(resur_pane);
        fade.setDuration(Duration.millis(350));
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent e)->{
            resur_pane.setLayoutX(250);
            resur_pane.setLayoutY(720);
            FadeTransition fade1 = new FadeTransition();
            fade1.setNode(resur_pane);
            fade1.setDuration(Duration.millis(350));
            fade1.setFromValue(0);
            fade1.setToValue(1);
            fade1.play();
        });
    }






    public void pause() {
        System.out.println("Game was paused!");
        paused.setVisible(true);
//        overlay.setVisible(true);
    }

    public void toggleResurrectSuccess() {
        resurrectSuccess = !resurrectSuccess;
    }

    public boolean displayResurrect() {
        resurrectSuccess = false;
//        resurrect.setVisible(true);
//        overlay.setVisible(true);
//
//        System.out.println("Hello World, resurecting");
//
//        for(int i=5; i>=0; --i) {
//            if(resurrectSuccess)
//                break;
//
//            resurrectCount.setText(i+"");
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        resurrect.setVisible(false);
//        overlay.setVisible(false);
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
//        overlay.setVisible(false);
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

    public void gameOverHome(MouseEvent e) throws Exception {
        Main.getInstance().load_homepage();
    }




}
