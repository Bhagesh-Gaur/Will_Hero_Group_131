package com.example.will_hero;

import javafx.animation.FadeTransition;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.action.Action;

//import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class General_Controller implements Initializable {
    private Main main;
    @FXML
    private TextField usernameTxt;
    @FXML
    private TextField passwordTxt;
    @FXML
    private ImageView close_but;
    @FXML
    private Text high_score, total_stars;
    @FXML
    private TableView game_table;
    @FXML
    private ToggleButton play_bgmusic_btn, play_sounds_btn, autosave_btn;
    @FXML
    private TextField game_id_input;
    @FXML
    private Text game_found_status;
    @FXML
    private GridPane savedGames;
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
    private ScrollPane saved_games;
    @FXML
    private ScrollPane scroll_LeaderBoard;
//    @FXML
//    private TableView<DataField> gameTable;
//    @FXML
//    private TableColumn<DataField, Integer> game_code;
//    @FXML
//    private TableColumn<DataField, Integer> score;
//    @FXML
//    private TableColumn<DataField, String > time_stamp;
//    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

//    General_Controller(){}
//    General_Controller(Main main){
//        this.main = main;
//    }


    @FXML
    private void handleFeedback() throws Exception {
//        System.out.println("Feedback Button was pressed");
//        // Open feedback form
//        URI uri = new URI("mailto:bhagesh20558@iiitd.ac.in?subject=Will%20Hero%20Feedback");
//        if (Desktop.isDesktopSupported()){
//            new Thread(() -> {
//                try {
//                    Desktop.getDesktop().browse(uri);
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//            }).start();
//        }

    }

    public void loadSGs() {
//        System.out.println(gameTable.getColumns());

//        ObservableList<Game> list = (ObservableList<Game>) Main.getInstance().getCurrentPlayer();
//        score.setCellValueFactory(new PropertyValueFactory<Game, Integer>("score"));
//        game_table.setItems();

        TableView<DataField> gameTable = new TableView<DataField>();
        gameTable.setPrefWidth(saved_games.getPrefWidth());

        TableColumn<DataField, Integer> gCode = new TableColumn<>("Game Code");
        TableColumn<DataField, Integer> sCore = new TableColumn<>("Score");
        gameTable.getColumns().add(gCode);
        gameTable.getColumns().add(sCore);
        gCode.setCellValueFactory(new PropertyValueFactory<>("gameCode"));
        gCode.setPrefWidth(gameTable.getPrefWidth() / 2);
        sCore.setCellValueFactory(new PropertyValueFactory<>("score"));
        sCore.setPrefWidth(gameTable.getPrefWidth() / 2);

        ObservableList<DataField> tempDataList = FXCollections.observableArrayList();
        if(Main.getInstance().getCurrentPlayer().getPassword().length()>0){
            for (int i = 0; i < 1; i++) {
                tempDataList.add(new DataField(i,
                        (Integer.parseInt(Main.getInstance().getDb().getDetails().get(Main.getInstance().getCurrentPlayer().getId()).get(4)))));
            }
        }

        gameTable.setItems(tempDataList);
//        System.out.println(tempDataList);
        saved_games.setContent(gameTable);


//        System.out.println(gameTable.getItems());
//        for (int i = 0; i < Main.getInstance().getCurrentPlayer().getPlayerSavedGames().size(); i++ ) {
//            gameTable.getItems().add(new DataField(Main.getInstance().getCurrentPlayer(), i));
//        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        music = true;
        sound = true;
        bi = true;
        inpause = false;
        //
        if (saved_games != null) {
            loadSGs();
        }
        if (scroll_LeaderBoard != null) {
            LoadHighScores();
        }
        //
//        final int items = 7;
//        RotateTransition[] r = new RotateTransition[items];
//
//        for(int i=0; i<items; ++i) {
//            r[i] = new RotateTransition();
//            r[i].setAxis(Rotate.Z_AXIS);
//            r[i].setByAngle((Math.pow(-1, i))*360);
//            r[i].setCycleCount(Animation.INDEFINITE);
//            r[i].setInterpolator(Interpolator.LINEAR);
//            if(i<3)
//                r[i].setDuration(Duration.millis(3000 - 250*i));
//            else
//                r[i].setDuration(Duration.millis(2500));
//        }
//
//        r[0].setNode(ring_1);
//        r[1].setNode(ring_2);
//        r[2].setNode(ring_3);
//        r[3].setNode(icon_1);
//        r[4].setNode(produced_btn);
//        r[5].setNode(ring_4);
//        r[6].setNode(ring_5);
//
//        for(int i=0; i<items; ++i)
//            r[i].play();

    }

    public void updateStats() {
//        total_stars.setText(Integer.toString(Main.getInstance().getCurrentPlayer().getStarsEarned()));
        high_score.setText((Integer.toString(Main.getInstance().getCurrentPlayer().getHighScore())));
    }

    @FXML
    private void loadPauseset(MouseEvent me) throws Exception {
        Main.getInstance().load_pauseset();
    }

    @FXML
    private void loadPrivacypage(MouseEvent me) throws Exception {
        Main.getInstance().load_privacypage();
    }

    @FXML
    private void loadCredits(MouseEvent me) throws Exception {
        Main.getInstance().load_creditspage();
    }

    @FXML
    private void Anonym(){
        Main.getInstance().setCurrentPlayer(new Player("", "", 0, 0, 0, "", 0));
        try {
            Main.getInstance().load_homepage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadHomepage(MouseEvent me) throws Exception {
//        Main.getInstance().setCurrentPlayer(new Player("",""));
        Main.getInstance().load_homepage();
    }

    @FXML
    private void loadSavedGames(MouseEvent me) throws Exception {
        Main.getInstance().load_SavedGames();
    }

    @FXML
    private void loadGame(ActionEvent me) throws Exception {
//        String un = game_id_input.getText();
        if(Main.getInstance().getCurrentPlayer().getPassword().length()>0){
            Main.getInstance().loadGame();
        }

    }

    @FXML
    private void loadLeaderboard(MouseEvent me) throws Exception {
        Main.getInstance().load_leaderboard();

    }

    public void LoadHighScores() {
        TableView<DataF> gameTable = new TableView<DataF>();
        gameTable.setPrefWidth(scroll_LeaderBoard.getPrefWidth());


        TableColumn<DataF, Integer> gCode = new TableColumn<>("Player Username");
        TableColumn<DataF, Integer> sCore = new TableColumn<>("Score");
        gameTable.getColumns().add(gCode);
        gameTable.getColumns().add(sCore);
        gCode.setCellValueFactory(new PropertyValueFactory<>("gameCode"));
        gCode.setPrefWidth(gameTable.getPrefWidth() / 2);
        sCore.setCellValueFactory(new PropertyValueFactory<>("score"));
        sCore.setPrefWidth(gameTable.getPrefWidth() / 2);

        ObservableList<DataF> tempDataList = FXCollections.observableArrayList();
        for (int i = 0; i < Main.getInstance().getDb().getDetails().size(); i++) {
            tempDataList.add(new DataF( (Main.getInstance().getDb().getDetails().get(i).get(0)),
                    (Integer.parseInt(Main.getInstance().getDb().getDetails().get(i).get(2)))));
        }
        gameTable.setItems(tempDataList);
//        System.out.println(tempDataList);
        scroll_LeaderBoard.setContent(gameTable);


        System.out.println(gameTable.getItems());
    }

    @FXML
    public void exitGame(MouseEvent me) throws IOException {
//        LoginController.serialize(Main.getInstance().getCurrentPlayer());
//
//        System.out.println("\nexit game serialize:");
//        Main.getInstance().getCurrentPlayer().print_player();
//
//        Main.getInstance().setCurrentPlayer(null);
//        Platform.exit();
    }

    public void logoutGame(MouseEvent mouseEvent) throws Exception {
//        LoginController.serialize(Main.getInstance().getCurrentPlayer());
//
//        System.out.println("\nlogout serialize:");
//        Main.getInstance().getCurrentPlayer().print_player();
//
//        Main.getInstance().setCurrentPlayer(null);
//        Main.getInstance().loadUserLogin();
    }

    public void loadLogin(MouseEvent mouseEvent) throws Exception {
        Main.getInstance().setCurrentPlayer(null);
        Main.getInstance().load_login();
    }

    public void displaySavedGames() {
//        Object[][] matrix = getTableMatrix();
//        String[] headings = {"Game Id", "Last Played", "Score"};
//        for(int i=0; i<3; ++i) {
//            Text text = new Text(headings[i]+"  ");
//            text.setFill(Paint.valueOf("#ffffff"));
//            savedGames.add(text, i, 0, 1, 1);
//        }
//        for(int i=0; i<Main.getInstance().getCurrentPlayer().getSavedGamesMap().size(); ++i) {
//            for(int j=0; j<3; ++j) {
//                Text text = new Text(matrix[i][j]+"  ");
//                text.setFill(Paint.valueOf("#ffffff"));
//                savedGames.add(text, j, i+1, 1, 1);
//            }
//        }
    }

    public Object[][] getTableMatrix() {
//        Map<Long, Game> game_map = Main.getInstance().getCurrentPlayer().getSavedGamesMap();
//        int col = 3;
//        int row = game_map.size();
//
//        Object[][] game_data = new Object[row][col];
//
//        int i = 0;
//
//        for (Map.Entry<Long, Game> map_element : game_map.entrySet()){
//            long id  = map_element.getKey();
//            String date_time = map_element.getValue().getDateTime();
//            int score = map_element.getValue().score;
//
//            game_data[i][0] = id;
//            game_data[i][1] = date_time;
//            game_data[i][2] = score;
//
//            i++;
//        }
//        return game_data;
        return null;
    }

    public void playBgMusic(MouseEvent mouseEvent) throws URISyntaxException {
//        Main.getInstance().toggleMusic();
//        Main.getInstance().playBackgroundMusic();
    }

    public void playSounds(MouseEvent mouseEvent) {
//        Main.getInstance().toggleGameSounds();
    }

    public void toggleAutoSave(MouseEvent mouseEvent) {
        Main.getInstance().toggleAutoSave();
    }

    public void fetch_saved_game(MouseEvent mouseEvent) {
//        try {
//            if (game_id_input.getText() == null || game_id_input.getText().trim().isEmpty()) {
//                throw new NullPointerException();
//            }
//
//            String input_id = game_id_input.getText();
//
//            Game selected_game = Main.getInstance().getCurrentPlayer().findGame(Integer.parseInt(input_id));
//            if (selected_game != null){
//                selected_game.resumeGame(Main.getInstance().getPrimaryStage().getScene());
//            }
//            else{
//                throw new GameNotFoundException("No game found for entered ID");
//            }
//
//        }
//        catch (NullPointerException | NumberFormatException e){
//            game_found_status.setFill(Color.RED);
//            game_found_status.setText("Invalid ID entered");
//        }
//        catch (GameNotFoundException e) {
//            game_found_status.setFill(Color.RED);
//            game_found_status.setText("No saved game found for entered ID");
//        }
    }

    @FXML
    public void music_onoff(MouseEvent event) throws IOException {
        try {
            if (music) {
                m_i = new javafx.scene.image.Image(getClass().getResourceAsStream("Image_src/music_off.png"));
                music = false;
            } else {
                m_i = new javafx.scene.image.Image(getClass().getResourceAsStream("Image_src/music_on.png"));
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
                s_i = new javafx.scene.image.Image(getClass().getResourceAsStream("Image_src/sound_off.png"));
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

    public void getLoadInfo(ActionEvent e) throws IOException {
        String text = game_id_input.getText();
        int a;
        System.out.println(text);
        try {
            a = Integer.parseInt(text);
        } catch (NumberFormatException num) {
            a = -1;
        }
        if (a < 0) {
            a = -1;
            System.out.println("Invalid");

        }
        if (a >= Main.getInstance().getCurrentPlayer().getPlayerSavedGames().size()) {
            System.out.println("No such Game");
        }
        if (a > -1) {
            System.out.println(a);
        }
    }

    public void getLoginInfo(MouseEvent e) throws IOException {
        String un = usernameTxt.getText();
        String ps = passwordTxt.getText();

        if (un.length() == 0 || ps.length() == 0) {
            //prompt...
            System.out.println(un);
            System.out.println(ps);

            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Incomplete Info");
            a.setHeaderText("You have not entered username or password");

            if (un.length() == 0 && ps.length() == 0) {
                a.setContentText("Enter username and password");
            } else if (un.length() == 0) {
                a.setContentText("Enter username");
            } else if (ps.length() == 0) {
                a.setContentText("Enter password");
            }
            if (a.showAndWait().get() == ButtonType.OK) {
                Stage stage = Main.getInstance().getPrimaryStage();
                System.out.println("Will Hero Exited Successfully!");
            }

        } else {
            boolean mm = authenticate_Login(un, ps);
            if (mm) {
                try {
                    System.out.println("hi");
                    Main.getInstance().load_homepage();
                } catch (Exception e1) {
                    System.out.println("bye");
                }
            } else {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Invalid Info");
        a.setHeaderText("You have not entered correct username or password");
        a.setContentText("Enter correct/valid username and password");

        if(a.showAndWait().get() == ButtonType.OK){
            Stage stage = Main.getInstance().getPrimaryStage();
            System.out.println("Will Hero Exited Successfully!");
        }
            }
        }


    }

    public void getCreateAccInfo(MouseEvent e) throws IOException {
        String un = usernameTxt.getText();
        String ps = passwordTxt.getText();

        if (un.length() == 0 || ps.length() == 0) {
            //prompt...
            System.out.println(un);
            System.out.println(ps);

            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Incomplete Info");
            a.setHeaderText("You have not entered username or password");

            if (un.length() == 0 && ps.length() == 0) {
                a.setContentText("Enter username and password");
            } else if (un.length() == 0) {
                a.setContentText("Enter username");
            } else if (ps.length() == 0) {
                a.setContentText("Enter password");
            }
            if (a.showAndWait().get() == ButtonType.OK) {
                Stage stage = Main.getInstance().getPrimaryStage();
                System.out.println("Will Hero Exited Successfully!");
            }

        } else {
            boolean mm = authenticate_CreateAcc(un, ps);
            if (mm) {
                try {
                    Main.getInstance().load_homepage();
                } catch (Exception e1) {
                }
            } else {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setTitle("Invalid Info");
                a.setHeaderText("You have not entered correct username or password");
                a.setContentText("Enter correct/valid username and password");

                if(a.showAndWait().get() == ButtonType.OK){
                    Stage stage = Main.getInstance().getPrimaryStage();
                    System.out.println("Will Hero Exited Successfully!");
                }
            }
        }


    }



    public boolean authenticate_Login(String u, String p){
        if(Main.getInstance().getDb().getDetails().size() == 0){
            System.out.println("false");
            return false;
        }
        for (int i = 0; i < Main.getInstance().getDb().getDetails().size(); i++) {
            if(Main.getInstance().getDb().getDetails().get(i).get(0).equals(u) && Main.getInstance().getDb().getDetails().get(i).get(1).equals(p)){
                System.out.println("true");
                ArrayList<String>  a = Main.getInstance().getDb().getDetails().get(i);
                Main.getInstance().setCurrentPlayer(
                        new Player(a.get(0), a.get(1),Integer.parseInt(a.get(2)), Integer.parseInt(a.get(3)),
                                Integer.parseInt(a.get(4)), a.get(5), Integer.parseInt(a.get(6)) ));
                Main.getInstance().getCurrentPlayer().setId(i);
                return true;
            }
        }
        System.out.println("false");

        return false;

    }
    public boolean authenticate_CreateAcc(String u, String p){
        for (int i = 0; i < Main.getInstance().getDb().getDetails().size(); i++) {
            if(Main.getInstance().getDb().getDetails().get(i).get(0).equals(u) || Main.getInstance().getDb().getDetails().get(i).get(1).equals(p)){
                return false;
            }
        }
        Main.getInstance().setCurrentPlayer(new Player(u, p));
        Main.getInstance().getDb().getDetails().add(new ArrayList<>());
        Main.getInstance().getCurrentPlayer().setId(Main.getInstance().getDb().getDetails().size()-1);
        Main.getInstance().getDb().getDetails().get(Main.getInstance().getDb().getDetails().size()-1).add(0, u);
        Main.getInstance().getDb().getDetails().get(Main.getInstance().getDb().getDetails().size()-1).add(1, p);
        Main.getInstance().getDb().getDetails().get(Main.getInstance().getDb().getDetails().size()-1).add(2, 0+"");
        Main.getInstance().getDb().getDetails().get(Main.getInstance().getDb().getDetails().size()-1).add(3, 0+"");
        Main.getInstance().getDb().getDetails().get(Main.getInstance().getDb().getDetails().size()-1).add(4, 0+"");
        Main.getInstance().getDb().getDetails().get(Main.getInstance().getDb().getDetails().size()-1).add(5, "");
        Main.getInstance().getDb().getDetails().get(Main.getInstance().getDb().getDetails().size()-1).add(6, 0+"");

        return true;
    }



}
