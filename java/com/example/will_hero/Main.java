package com.example.will_hero;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;


public class Main extends Application {

    private static Main main;
    private static ArrayList<Game> gms_all;


    public static ArrayList<Game> getGms_all() {
        return gms_all;
    }
    private SmallData db;

    private static ArrayList<Player> usrs_all;
    private double width, height;
    private String color = "#26A8FE";
    private static Stage primaryStage;
    private Player currentPlayer;

    private boolean autoSave;

    public static Main getInstance() {
        if(main == null) {
            main = new Main();
            // Do set the stage when calling from outside
        }
        return main;
    }

    public boolean isAutoSave() {
        return autoSave;
    }
    public void toggleAutoSave() {
        autoSave = !autoSave;
    }

    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }

    public String getColor() { return color; }

    public static void main(String[] args) {
        launch(args);
    }

    protected void scale(Parent root) {
        Scale scale = new Scale();
        scale.setPivotY(0);
        scale.setPivotX(0);
        scale.setY(1);
        scale.setX(1);
        root.getTransforms().addAll(scale);
    }

    protected void load_homepage() throws Exception {
//        currentPlayer = new Player("","");
        System.out.println(currentPlayer.getCoin());
        Parent root = FXMLLoader.load(Main.class.getResource("homepage.fxml"));
        FadeTransition fade = new FadeTransition();
        fade.setNode(primaryStage.getScene().getRoot());
        fade.setDuration(Duration.millis(350));
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent e)->{
            primaryStage.getScene().setRoot(root);
            FadeTransition fade1 = new FadeTransition();
            fade1.setNode(primaryStage.getScene().getRoot());
            fade1.setDuration(Duration.millis(350));
            fade1.setFromValue(0);
            fade1.setToValue(1);
            fade1.play();
        });
    }
    protected void load_pauseset() throws Exception, IllegalArgumentException {
        Parent root = FXMLLoader.load(Main.class.getResource("Pause_set.fxml"));
//        scale(root);
//        root.setLayoutX(0);
//        root.setLayoutY(0);
//        primaryStage.getScene().setRoot(root);
//        //        System.out.println(stack_pane.getChildren());
////        Scene scene2 = set_but.getScene();
//        root.translateYProperty().set(700);
//        root.translateYProperty().setValue(-1400);
//        Timeline timeline = new Timeline();
//        KeyValue kv = new KeyValue(root.translateYProperty(),0, Interpolator.EASE_IN);
//        KeyFrame kf = new KeyFrame(Duration.millis(750),kv);
//        timeline.getKeyFrames().add(kf);
//        timeline.setOnFinished( (ActionEvent e)->{
//            root.setLayoutX(0);
//            root.setLayoutY(0);
//        });
//        timeline.play();

        FadeTransition fade = new FadeTransition();
        fade.setNode(primaryStage.getScene().getRoot());
        fade.setDuration(Duration.millis(350));
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent e)->{
            primaryStage.getScene().setRoot(root);
            FadeTransition fade1 = new FadeTransition();
            fade1.setNode(primaryStage.getScene().getRoot());
            fade1.setDuration(Duration.millis(350));
            fade1.setFromValue(0);
            fade1.setToValue(1);
            fade1.play();
        });
    }

    protected void load_creditspage() throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("credPage.fxml"));
        FadeTransition fade = new FadeTransition();
        fade.setNode(primaryStage.getScene().getRoot());
        fade.setDuration(Duration.millis(350));
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent e)->{
            primaryStage.getScene().setRoot(root);
            FadeTransition fade1 = new FadeTransition();
            fade1.setNode(primaryStage.getScene().getRoot());
            fade1.setDuration(Duration.millis(350));
            fade1.setFromValue(0);
            fade1.setToValue(1);
            fade1.play();
        });
    }

    protected void load_privacypage() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("PrivacyPage.fxml"));
        FadeTransition fade = new FadeTransition();
        fade.setNode(primaryStage.getScene().getRoot());
        fade.setDuration(Duration.millis(350));
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent e)->{
            primaryStage.getScene().setRoot(root);
            FadeTransition fade1 = new FadeTransition();
            fade1.setNode(primaryStage.getScene().getRoot());
            fade1.setDuration(Duration.millis(350));
            fade1.setFromValue(0);
            fade1.setToValue(1);
            fade1.play();
        });
    }


    protected void load_SavedGames() throws Exception{
//        FXMLLoader loader = new FXMLLoader(Main.class.getResource("scenes/load_game.fxml"));
//        Parent root = loader.load();
//        Controller controller = loader.getController();
//        controller.displaySavedGames();
//        scale(root);
//        primaryStage.getScene().setRoot(root);
        Parent root = FXMLLoader.load(Main.class.getResource("LoadSavedGame.fxml"));
        FadeTransition fade = new FadeTransition();
        fade.setNode(primaryStage.getScene().getRoot());
        fade.setDuration(Duration.millis(350));
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent e)->{
            primaryStage.getScene().setRoot(root);
            FadeTransition fade1 = new FadeTransition();
            fade1.setNode(primaryStage.getScene().getRoot());
            fade1.setDuration(Duration.millis(350));
            fade1.setFromValue(0);
            fade1.setToValue(1);
            fade1.play();
        });

    }

    protected void load_NewGame() throws Exception{
//        FXMLLoader loader = new FXMLLoader(Main.class.getResource("scenes/load_game.fxml"));
//        Parent root = loader.load();
//        Controller controller = loader.getController();
//        controller.displaySavedGames();
//        scale(root);
//        primaryStage.getScene().setRoot(root);
//        setCurrentPlayer(new Player("Bhagesh","Rishabh"));
        System.out.println(getCurrentPlayer());
        Game game = new Game(getCurrentPlayer(), primaryStage.getScene());
        if(getCurrentPlayer().getPassword().length() > 0){
//            db.getScore_Date().get()
        }
//        Parent root = FXMLLoader.load(Main.class.getResource("Game.fxml"));
//        FadeTransition fade = new FadeTransition();
//        fade.setNode(primaryStage.getScene().getRoot());
//        fade.setDuration(Duration.millis(350));
//        fade.setFromValue(1);
//        fade.setToValue(0);
//        fade.play();
//        fade.setOnFinished((ActionEvent e)->{
//            primaryStage.getScene().setRoot(root);
//            FadeTransition fade1 = new FadeTransition();
//            fade1.setNode(primaryStage.getScene().getRoot());
//            fade1.setDuration(Duration.millis(350));
//            fade1.setFromValue(0);
//            fade1.setToValue(1);
//            fade1.play();
//        });
    }

    protected void loadGame() throws Exception {
        System.out.println("hi");
        Game game = new Game(primaryStage.getScene());
        if(getCurrentPlayer().getPassword().length() > 0){
//            db.getScore_Date().get()
        }
        System.out.println("ho");
    }


    protected void loadGameOver(int score, int highScore) throws Exception{
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/game_over.fxml"));
//        Parent root = loader.load();
//        GameController controller = loader.getController();
//        controller.setGameOverScores(score, highScore);
//        scale(root);
//        primaryStage.getScene().setRoot(root);
    }

    protected void load_login() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("UserLogin.fxml"));
        FadeTransition fade = new FadeTransition();
        fade.setNode(primaryStage.getScene().getRoot());
        fade.setDuration(Duration.millis(350));
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent e)->{
            primaryStage.getScene().setRoot(root);
            FadeTransition fade1 = new FadeTransition();
            fade1.setNode(primaryStage.getScene().getRoot());
            fade1.setDuration(Duration.millis(350));
            fade1.setFromValue(0);
            fade1.setToValue(1);
            fade1.play();
        });
    }

    protected void load_leaderboard() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("Leaderboard.fxml"));
        FadeTransition fade = new FadeTransition();
        fade.setNode(primaryStage.getScene().getRoot());
        fade.setDuration(Duration.millis(350));
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent e)->{
            primaryStage.getScene().setRoot(root);
            FadeTransition fade1 = new FadeTransition();
            fade1.setNode(primaryStage.getScene().getRoot());
            fade1.setDuration(Duration.millis(350));
            fade1.setFromValue(0);
            fade1.setToValue(1);
            fade1.play();
        });
    }



    protected Player getCurrentPlayer() {
        return currentPlayer;
    }

    protected void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public void setupScreen(Stage stage) {
        primaryStage = stage;
        height = 700;
        width = 1000;
    }

    @Override
    public void start(Stage stage) throws Exception{
        db = new SmallData();
        db.deserialize();
        setupScreen(stage);
        Pane p = new Pane();
        Scene scene = new Scene(p,1000,700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Will Hero");
        main = this;
        toggleAutoSave();
        scene.setFill(Paint.valueOf(color));
//        Parent root = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
//        primaryStage.getScene().setRoot(root);
        load_login();
        primaryStage.show();
    }

    public SmallData getDb() {
        return db;
    }

    @Override
    public void init() {
    }

    public int index(String u) {
        for (int i = 0; i < Main.getInstance().getDb().getDetails().size(); i++) {
            if (Main.getInstance().getDb().getDetails().get(i).get(0).equals(u)) {
                return i;
            }

        }            return -1;
    }



}
