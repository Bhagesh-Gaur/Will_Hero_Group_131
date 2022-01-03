package com.example.will_hero;
import com.example.will_hero.Elements.*;
import com.example.will_hero.Elements.Controller.Hero_controller;
import com.example.will_hero.GameObj.Chest;
import com.example.will_hero.GameObj.Coin_chest;
import com.example.will_hero.GameObj.Coins;
import com.example.will_hero.GameObj.Weapon_chest;
import com.example.will_hero.Game_Commiter.Collideable;
import com.example.will_hero.Game_Commiter.GameObjects;

import com.example.will_hero.Islands.Island;
import com.example.will_hero.Weapons.Weapon;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.util.Pair;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Game implements Serializable, Cloneable {
//    private static final List<Class> map = Arrays.asList();
    private  ArrayList<Island> Island_List;
    private  ArrayList<GameObjects> CoObj_List;
    private  ArrayList<GameObjects> DoneObj;
    private  ArrayList<Orcs> Orc_List;
    private  ArrayList<Coins> Coins_List;
    private  ArrayList<Chest> Chest_List;
    private Hand tap;
    private boolean dead;
    private boolean bossCalled;
    private boolean rebornS;
    private boolean clickable;
    private boolean BOSSdead;
    private boolean start;
    private transient ImageView princess;

    public int getScore() {
        return score;
    }
    private String dateTimeStamp;

    public String getDateTimeStamp() {
        return dateTimeStamp;
    }

    private int coin_here;
    private transient Thread collisionThread;

    private static final int[] size1 = {300, 180};
    private static final int[] size2 = {200, 150};
    private static final int[] size3 = {400, 174};


    private Hero hero;
    private long id;
    private Player player;
    private List<GameObjects> gameObjects;
    private List<DoubleProperty> objectsPosProperty;
    private List<Pair<Class, Double>> objectsPosition;
    private boolean gameOver;
    private int score, coin_count;
    private transient Game_controller gameController;
    @FXML
    private transient Pane obstaclesBox, root;

    private ArrayList<Island> islands;
//    private Thread O_collisionThread;
//    private final Queue<Island>

    public ArrayList<Island> getIslands() {
        return islands;
    }

    public Game(Player player, Scene scene) {
        this.player = player;
        this.dateTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        this.islands = new ArrayList<>();
//        id = assignID();
        id = 0;

        this.coin_here = 0;
        bossCalled = false;
        gameObjects = new ArrayList<>();
        objectsPosProperty = new ArrayList<>();
        score = 0;
        coin_count = player.getCoin().getCoinVal();
        this.rebornS = false;
        try {
            princess =new ImageView(new Image(new FileInputStream("src/main/resources/com/example/will_hero/Image_src/Collide/nc_princess.png")));
            princess.setLayoutX(1000);
            princess.setLayoutY(350);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.clickable = true;
        this.start = false;

//        initialiseDateTime();
        objectsPosition = new ArrayList<>();
        Island_List = new ArrayList<>();
        CoObj_List = new ArrayList<>();
        Orc_List = new ArrayList<>();
        Coins_List = new ArrayList<>();
        Chest_List = new ArrayList<>();
        DoneObj = new ArrayList<>();
        dead = false;
        BOSSdead = false;

        tap = new Hand();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
            root = loader.load();
            scene.setRoot(root);
            Main.getInstance().scale(root);
            gameController = loader.getController();
            gameController.setGame(this);
            obstaclesBox = gameController.obstaclesBox;

//            Parent root = FXMLLoader.load(Main.class.getResource("Game.fxml"));
//            FadeTransition fade = new FadeTransition();
//            fade.setNode(Main.getInstance().getPrimaryStage().getScene().getRoot());
//            fade.setDuration(Duration.millis(350));
//            fade.setFromValue(1);
//            fade.setToValue(0);
//            fade.play();
//            fade.setOnFinished((ActionEvent e)->{
//                Main.getInstance().getPrimaryStage().getScene().setRoot(root);
//                FadeTransition fade1 = new FadeTransition();
//                fade1.setNode(Main.getInstance().getPrimaryStage().getScene().getRoot());
//                fade1.setDuration(Duration.millis(350));
//                fade1.setFromValue(0);
//                fade1.setToValue(1);
//                fade1.play();
//            });


        } catch (IOException e) {
            e.printStackTrace();
        }
//        hero = new Hero();
        hero = new Hero();
        hero.getImage().setFitWidth(40);
        hero.getImage().setPreserveRatio(true);
        hero.getImage().setLayoutX(180);
        hero.getImage().setLayoutY(200);
        player.getHelmet().getSpear().getImage().setLayoutX(215);
        player.getHelmet().getSpear().getImage().setLayoutY(200);
        player.getHelmet().getSpear().getImage().setPreserveRatio(true);
        player.getHelmet().getSpear().getImage().setFitWidth(10);
        player.getHelmet().getAxe().getImage().setFitWidth(10);
        player.getHelmet().getAxe().getImage().setLayoutX(215);
        player.getHelmet().getAxe().getImage().setLayoutY(200);
        player.getHelmet().getAxe().getImage().setPreserveRatio(true);
        player.getHelmet().getAxe().getImage().setOpacity(0);
        player.getHelmet().getSpear().getImage().setOpacity(0);
        obstaclesBox.getChildren().add(player.getHelmet().getSpear().getImage());
        obstaclesBox.getChildren().add(player.getHelmet().getAxe().getImage());




        obstaclesBox.getChildren().add(hero.getImage());



        gameOver = false;
        gameController.setScore(score);
        gameController.setCoinCount(coin_count);
        initializeGame();


//        if (Main.getInstance().isAutoSave()) player.saveGame(this);
    }



    public Game(Scene scene){
        this.player = Main.getInstance().getCurrentPlayer();

        this.islands = new ArrayList<>();
//        id = assignID();
        id = 0;
        this.coin_here = 0;
        bossCalled = false;
        gameObjects = new ArrayList<>();
        objectsPosProperty = new ArrayList<>();
        System.out.println("hi");
        score = Integer.parseInt(String.valueOf(Main.getInstance().getDb().getDetails().get(player.getId()).get(4)));
        coin_count = Integer.parseInt(String.valueOf(Main.getInstance().getDb().getDetails().get(player.getId()).get(3)));
        System.out.println("yp");
        if(score > 100){
            //Call Ending
            load_ending();
        }
        if(Main.getInstance().getDb().getDetails().get(player.getId()).get(5).equals("axe")){
            this.player.getHelmet().setHas_axe(true);
            this.player.getHelmet().getAxe().setLevel(Integer.parseInt(String.valueOf(Main.getInstance().getDb().getDetails().get(6))));
        }else if(Main.getInstance().getDb().getDetails().get(player.getId()).get(5).equals("spear")){
            //set spear opacity to 1
            this.player.getHelmet().setHas_Spear(true);
            this.player.getHelmet().getSpear().setLevel(Integer.parseInt(String.valueOf(Main.getInstance().getDb().getDetails().get(6))));
        }


        this.rebornS = false;
        try {
            princess =new ImageView(new Image(new FileInputStream("src/main/resources/com/example/will_hero/Image_src/Collide/nc_princess.png")));
            princess.setLayoutX(1000);
            princess.setLayoutY(350);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.clickable = true;
        this.start = false;

//        initialiseDateTime();
        objectsPosition = new ArrayList<>();
        Island_List = new ArrayList<>();
        CoObj_List = new ArrayList<>();
        Orc_List = new ArrayList<>();
        Coins_List = new ArrayList<>();
        Chest_List = new ArrayList<>();
        DoneObj = new ArrayList<>();
        dead = false;
        BOSSdead = false;

        tap = new Hand();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
            root = loader.load();
            scene.setRoot(root);
            Main.getInstance().scale(root);
            gameController = loader.getController();
            gameController.setGame(this);
            obstaclesBox = gameController.obstaclesBox;

//            Parent root = FXMLLoader.load(Main.class.getResource("Game.fxml"));
//            FadeTransition fade = new FadeTransition();
//            fade.setNode(Main.getInstance().getPrimaryStage().getScene().getRoot());
//            fade.setDuration(Duration.millis(350));
//            fade.setFromValue(1);
//            fade.setToValue(0);
//            fade.play();
//            fade.setOnFinished((ActionEvent e)->{
//                Main.getInstance().getPrimaryStage().getScene().setRoot(root);
//                FadeTransition fade1 = new FadeTransition();
//                fade1.setNode(Main.getInstance().getPrimaryStage().getScene().getRoot());
//                fade1.setDuration(Duration.millis(350));
//                fade1.setFromValue(0);
//                fade1.setToValue(1);
//                fade1.play();
//            });


        } catch (IOException e) {
            e.printStackTrace();
        }
//        hero = new Hero();
        hero = new Hero();
        hero.getImage().setFitWidth(40);
        hero.getImage().setPreserveRatio(true);
        hero.getImage().setLayoutX(180);
        hero.getImage().setLayoutY(200);
        player.getHelmet().getSpear().getImage().setLayoutX(215);
        player.getHelmet().getSpear().getImage().setLayoutY(200);
        player.getHelmet().getSpear().getImage().setPreserveRatio(true);
        player.getHelmet().getSpear().getImage().setFitWidth(10);
        player.getHelmet().getAxe().getImage().setFitWidth(10);
        player.getHelmet().getAxe().getImage().setLayoutX(215);
        player.getHelmet().getAxe().getImage().setLayoutY(200);
        player.getHelmet().getAxe().getImage().setPreserveRatio(true);
        if(player.getHelmet().isHas_axe()){
            player.getHelmet().getAxe().getImage().setOpacity(1);
        }
        else if(player.getHelmet().isHas_spear()){
            player.getHelmet().getSpear().getImage().setOpacity(1);
        }
        else{
            player.getHelmet().getAxe().getImage().setOpacity(0);
            player.getHelmet().getSpear().getImage().setOpacity(0);
        }

        obstaclesBox.getChildren().add(player.getHelmet().getSpear().getImage());
        obstaclesBox.getChildren().add(player.getHelmet().getAxe().getImage());




        obstaclesBox.getChildren().add(hero.getImage());



        gameOver = false;
        gameController.setScore(score);
        gameController.setCoinCount(coin_count);
        initializeGame();
    }












    public ArrayList<Island> getIsland_List() {
        return Island_List;
    }

    public ArrayList<GameObjects> getCoObj_List() {
        return CoObj_List;
    }

    public ArrayList<GameObjects> getDoneObj() {
        return DoneObj;
    }

    public ArrayList<Orcs> getOrc_List() {
        return Orc_List;
    }

    public ArrayList<Coins> getCoins_List() {
        return Coins_List;
    }

    public ArrayList<Chest> getChest_List() {
        return Chest_List;
    }

    public Hand getTap() {
        return tap;
    }

    public boolean isDead() {
        return dead;
    }

    public boolean isBossCalled() {
        return bossCalled;
    }

    public boolean isRebornS() {
        return rebornS;
    }

    public boolean isClickable() {
        return clickable;
    }

    public boolean isBOSSdead() {
        return BOSSdead;
    }

    public boolean isStart() {
        return start;
    }

    public ImageView getPrincess() {
        return princess;
    }

    public int getCoin_here() {
        return coin_here;
    }

    public Thread getCollisionThread() {
        return collisionThread;
    }

    public long getId() {
        return id;
    }

    public List<GameObjects> getGameObjects() {
        return gameObjects;
    }

    public List<DoubleProperty> getObjectsPosProperty() {
        return objectsPosProperty;
    }

    public List<Pair<Class, Double>> getObjectsPosition() {
        return objectsPosition;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public Game_controller getGameController() {
        return gameController;
    }

    public Pane getObstaclesBox() {
        return obstaclesBox;
    }

    public Pane getRoot() {
        return root;
    }


    public Hero_controller getController() {
        return controller;
    }

    public int getCnt() {
        return cnt;
    }

    public Green_orc getGg() {
        return gg;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Game cloned = (Game) super.clone();
//        cloned.se
        cloned.setIsland_List((ArrayList<Island>) Island_List.clone());
        cloned.setCoObj_List((ArrayList<GameObjects>) CoObj_List.clone());
        cloned.setDoneObj((ArrayList<GameObjects>)(DoneObj.clone()));
        cloned.setOrc_List((ArrayList<Orcs>) getOrc_List().clone());
        cloned.setCoins_List((ArrayList<Coins>) Coins_List.clone());
        cloned.setChest_List((ArrayList<Chest>) Chest_List.clone());
        cloned.setTap((Hand) tap.clone());
        cloned.setHero((Hero) getHero().clone());
//        private final long id;
        cloned.setPlayer((Player) getPlayer().clone());
        cloned.setIslands((ArrayList<Island>) getIslands().clone());
        return cloned;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setGameObjects(List<GameObjects> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public void setObjectsPosProperty(List<DoubleProperty> objectsPosProperty) {
        this.objectsPosProperty = objectsPosProperty;
    }

    public void setIslands(ArrayList<Island> islands) {
        this.islands = islands;
    }

    public Player getPlayer() {
        return player;
    }

    public void setBossCalled(boolean bossCalled) {
        this.bossCalled = bossCalled;
    }

    public void setBOSSdead(boolean BOSSdead) {
        this.BOSSdead = BOSSdead;
    }

    public  void setChest_List(ArrayList<Chest> chest_List) {
        this.Chest_List = chest_List;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public void setCoin_here(int coin_here) {
        this.coin_here = coin_here;
    }

    public  void setCoins_List(ArrayList<Coins> coins_List) {
        this.Coins_List = coins_List;
    }

    public  void setIsland_List(ArrayList<Island> island_List) {
        this.Island_List = island_List;
    }

    public  void setCoObj_List(ArrayList<GameObjects> coObj_List) {
        this.CoObj_List = coObj_List;
    }

    public  void setDoneObj(ArrayList<GameObjects> doneObj) {
        DoneObj = doneObj;
    }

    public  void setOrc_List(ArrayList<Orcs> orc_List) {
        this.Orc_List = orc_List;
    }

    public void setTap(Hand tap) {
        this.tap = tap;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void setRebornS(boolean rebornS) {
        this.rebornS = rebornS;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setPrincess(ImageView princess) {
        this.princess = princess;
    }

    public void setDateTimeStamp(String dateTimeStamp) {
        this.dateTimeStamp = dateTimeStamp;
    }

    public void setCollisionThread(Thread collisionThread) {
        this.collisionThread = collisionThread;
    }

    public void setObjectsPosition(List<Pair<Class, Double>> objectsPosition) {
        this.objectsPosition = objectsPosition;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setGameController(Game_controller gameController) {
        this.gameController = gameController;
    }

    public void setObstaclesBox(Pane obstaclesBox) {
        this.obstaclesBox = obstaclesBox;
    }

    public void setRoot(Pane root) {
        this.root = root;
    }

    public void setController(Hero_controller controller) {
        this.controller = controller;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public void setGg(Green_orc gg) {
        this.gg = gg;
    }

    private transient Hero_controller controller;

    //    private TNT T;
    private void initializeGame() {

        Island is = new Island("src/main/resources/com/example/will_hero/Image_src/Collide/c_island9.png");
        System.out.println(is);
//        is.getImage().setFitHeight(size1[1]);
        is.getImage().setFitWidth(size1[0]);
        is.getImage().setPreserveRatio(true);
        Island_List.add(is);
        is.getImage().setLayoutX(-6);
        is.getImage().setLayoutY(380);
        obstaclesBox.getChildren().add(Island_List.get(0).getImage());

        is = new Island("src/main/resources/com/example/will_hero/Image_src/Collide/c_island7.png");
//        is.getImage().setFitHeight(size1[1]);
        is.getImage().setFitWidth(size2[0]);
        is.getImage().setPreserveRatio(true);
        Island_List.add(is);
        is.getImage().setLayoutX(380);
        is.getImage().setLayoutY(400);
        obstaclesBox.getChildren().add(Island_List.get(1).getImage());

        is = new Island("src/main/resources/com/example/will_hero/Image_src/Collide/c_island6.png");
        is.getImage().setFitWidth(size3[0]);
        is.getImage().setPreserveRatio(true);
        Island_List.add(is);
        is.getImage().setLayoutX(700);
        is.getImage().setLayoutY(370);
        obstaclesBox.getChildren().add(Island_List.get(2).getImage());

        Green_orc goc1 = new Green_orc();
        goc1.getImage().setFitWidth(40);
        goc1.getImage().setPreserveRatio(true);
        Orc_List.add(goc1);
        goc1.getImage().setLayoutX(is.getImage().getLayoutX() + 90);
        goc1.getImage().setLayoutY(is.getImage().getLayoutY() - goc1.getImage().minHeight(goc1.getImage().getFitWidth()) - 60);
        obstaclesBox.getChildren().add(Orc_List.get(0).getImage());


        goc1 = new Green_orc();
        goc1.getImage().setFitWidth(40);
        goc1.getImage().setPreserveRatio(true);
        Orc_List.add(goc1);
        goc1.getImage().setLayoutX(is.getImage().getLayoutX() + 190);
        goc1.getImage().setLayoutY(is.getImage().getLayoutY() - goc1.getImage().minHeight(goc1.getImage().getFitWidth()) - 40);
        obstaclesBox.getChildren().add(Orc_List.get(1).getImage());

        is = new Island("src/main/resources/com/example/will_hero/Image_src/Collide/c_island8.png");
//        is.getImage().setFitHeight(size1[1]);
        is.getImage().setFitWidth(size2[0]);
        is.getImage().setPreserveRatio(true);
        Island_List.add(is);
        is.getImage().setLayoutX(800);
        is.getImage().setLayoutY(-150);
        obstaclesBox.getChildren().add(Island_List.get(3).getImage());


        is = new Island("src/main/resources/com/example/will_hero/Image_src/Collide/c_island10.png");
//        is.getImage().setFitHeight(size1[1]);
        is.getImage().setFitWidth(size1[0]);
        is.getImage().setPreserveRatio(true);
        Island_List.add(is);
        is.getImage().setLayoutX(1200);
        is.getImage().setLayoutY(360);
        obstaclesBox.getChildren().add(Island_List.get(4).getImage());


        createDefaultCoins();
        tap.getImage().setFitWidth(50);
        tap.getImage().setPreserveRatio(true);
        tap.getImage().setLayoutX(470);
        tap.getImage().setLayoutY(410);
        obstaclesBox.getChildren().add(tap.getImage());
        tap.start();
        threadWork();
        hero.gravity();
        player.getHelmet().getSpear().gravity();
        player.getHelmet().getAxe().gravity();
        for (Orcs o :
                Orc_List) {
            o.gravity();
        }


    }

    public void setCoin_count(int coin_count) {
        this.coin_count = coin_count;
    }


    public void add_island() {
        Island is = new Island();
//        is.getImage().setFitHeight(size1[1]);
        is.getImage().setFitWidth(size1[0]);
        is.getImage().setPreserveRatio(true);
        Island_List.add(is);
        int i = new Random().nextInt(30);
        int j = i % 2;
        is.getImage().setLayoutX(Island_List.get(4).getImage().getLayoutX() + Island_List.get(4).getImage().getFitWidth() + i + 10);
        if (j == 0) {
            j = -1;
        }
        is.getImage().setLayoutY(360 + j * i);
        obstaclesBox.getChildren().add(is.getImage());
    }
    private int cnt = 0;
    private Green_orc gg;
    public synchronized void jum() {
        if (bossCalled && (Orc_List.get(Orc_List.size()-1).getImage().getLayoutX()+Orc_List.get(Orc_List.size()-1).getImage().getFitWidth())<hero.getImage().getLayoutX()){
            BOSSdead = true;
        }
        if (BOSSdead && (Island_List.get(Island_List.size()-1).getImage().getLayoutX())+Island_List.get(Island_List.size()-1).getImage().getFitWidth() < 1000){
            ImageView img = null;
            try {

                img = new ImageView(new Image(new FileInputStream("src/main/resources/com/example/will_hero/Image_src/Collide/c_hero.png")));
                princess.setFitWidth(70);
                princess.setPreserveRatio(true);
                princess.setLayoutX(920);
                princess.setLayoutY(300);
                img.setFitWidth(40);
                img.setPreserveRatio(true);
                img.setLayoutX(870);
                img.setLayoutY(300);
                obstaclesBox.getChildren().add(princess);
                obstaclesBox.getChildren().add(img);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            gm(coin_count, score);
        }
        if (!dead && clickable) {
            if (!start) {
                tap.getImage().setOpacity(0);
                tap.getImage().setLayoutX(1500);
                tap.getImage().setLayoutY(0);
                obstaclesBox.getChildren().remove(tap);
                start = true;

            }
            for (int i = 0; i < Island_List.size(); i++) {
                Island_List.get(i).movX();
            }
            for (int i = 0; i < CoObj_List.size(); i++) {
                CoObj_List.get(i).movX();
            }
            for (int i = 0; i < Orc_List.size(); i++) {
                Orc_List.get(i).movX();
            }
            for (int i = 0; i < Chest_List.size(); i++) {
                Chest_List.get(i).movX();
            }
            for (int i = 0; i < DoneObj.size(); i++) {
                DoneObj.get(i).movX();
            }
//            if (BOSSdead && cnt<1){
//                cnt++;
//                                princess.setLayoutX(800);
//                                princess.setLayoutY(290);
//                                princess.setFitWidth(120);
//                                princess.setPreserveRatio(true);
//                obstaclesBox.getChildren().add(princess);
//
//
////                 gg = new Green_orc();
////                gg.setImg(princess);
////                double offset = hero.getImage().minHeight(hero.getImage().getFitWidth());//Island_List.get(i).getImage().getFitWidth()
////                gg.getImage().setFitWidth(40);
////                gg.getImage().setPreserveRatio(true);
////                gg.getImage().setLayoutX(Island_List.get(5).getImage().getLayoutX() + 100);
////                gg.getImage().setLayoutY(Island_List.get(5).getImage().getLayoutY() - gg.getImage().minHeight(gg.getImage().getFitWidth()));
//////                    obstaclesBox.getChildren().add(princess);
////                obstaclesBox.getChildren().add(gg.getImage());
//
//            } if(cnt==1){
////                gg.movX();
//
//            }


            /*new*/
            score++;
            gameController.setScore(score);


            if (Island_List.get(0).getImage().getLayoutX() + Island_List.get(0).getImage().getFitWidth() < 0) {
                if (score < 100) {
                    add_island();
                    if ((coin_here++) % 6 == 0) {
                        add_coins();
                    }

                    if ((coin_here + 1) % 4 == 0) {
                        //addOrcs;;
                        addOrcs();
                    }
                    if ((coin_here + 1) % 10 == 0) {
                        //addOrcs;;
                        addROrcs();
                    }
                    if ((coin_here + 1) % 5 == 0) {
                        //addOrcs;;
                        gen_weaponChest();
                    }
                    if ((coin_here + 1) % 7 == 0) {
                        //addOrcs;;
                        gen_CoinChest();
                    }
                    obstaclesBox.getChildren().remove(Island_List.get(0));
//                        Island_List.get(0).getImage().setOpacity(0);
                    Island_List.remove(0);
                }
                if (score >= 100 && !bossCalled && (Island_List.get(Island_List.size()-1).getImage().getLayoutX()+Island_List.get(Island_List.size()-1).getImage().getFitWidth())<1000){
//                    addBOrcs();
                    System.out.println("Loaded end");
                    load_ending();
                    bossCalled = true;
                }



            }
        }


    }


    public void load_ending(){
        Island is = new Island("src/main/resources/com/example/will_hero/Image_src/Collide/c_island9.png");
        System.out.println(is);
//        is.getImage().setFitHeight(size1[1]);
        is.getImage().setFitWidth(size1[0]);
        is.getImage().setPreserveRatio(true);
        int i = new Random().nextInt(30);
        is.getImage().setLayoutX(Island_List.get(Island_List.size()-1).getImage().getLayoutX()+Island_List.get(Island_List.size()-1).getImage().getFitWidth()+i+10);
        is.getImage().setLayoutY(380);
        Island_List.add(is);
        obstaclesBox.getChildren().add(Island_List.get(Island_List.size()-1).getImage());

        Boss_orc goc1 = new Boss_orc();
        goc1.getImage().setFitWidth(80);
        goc1.getImage().setPreserveRatio(true);
        Orc_List.add(goc1);
        goc1.getImage().setLayoutX(Island_List.get(Island_List.size()-1).getImage().getLayoutX() + 100);
        goc1.getImage().setLayoutY(Island_List.get(Island_List.size()-1).getImage().getLayoutY() - goc1.getImage().minHeight(goc1.getImage().getFitWidth()) - 40);
        goc1.gravity();
        obstaclesBox.getChildren().add(Orc_List.get(Orc_List.size()-1).getImage());

        is = new Island("src/main/resources/com/example/will_hero/Image_src/Collide/c_island7.png");
//        is.getImage().setFitHeight(size1[1]);
        is.getImage().setFitWidth(size2[0]);
        is.getImage().setPreserveRatio(true);
        i = new Random().nextInt(30);
        is.getImage().setLayoutX(Island_List.get(Island_List.size()-1).getImage().getLayoutX()+Island_List.get(Island_List.size()-1).getImage().getFitWidth()+i+10);
        is.getImage().setLayoutY(400);
        Island_List.add(is);
        obstaclesBox.getChildren().add(Island_List.get(Island_List.size()-1).getImage());

        is = new Island("src/main/resources/com/example/will_hero/Image_src/Collide/c_island6.png");
        is.getImage().setFitWidth(size3[0]);
        is.getImage().setPreserveRatio(true);
        i = new Random().nextInt(30);
        is.getImage().setLayoutX(Island_List.get(Island_List.size()-1).getImage().getLayoutX()+Island_List.get(Island_List.size()-1).getImage().getFitWidth()+i+10);
        is.getImage().setLayoutY(370);
        Island_List.add(is);
        obstaclesBox.getChildren().add(Island_List.get(Island_List.size()-1).getImage());




        is = new Island("src/main/resources/com/example/will_hero/Image_src/Collide/c_island10.png");
//        is.getImage().setFitHeight(size1[1]);
        is.getImage().setFitWidth(size1[0]);
        is.getImage().setPreserveRatio(true);
        i = new Random().nextInt(30);
        is.getImage().setLayoutX(Island_List.get(Island_List.size()-1).getImage().getLayoutX()+Island_List.get(Island_List.size()-1).getImage().getFitWidth()+i+10);
        is.getImage().setLayoutY(360);
        Island_List.add(is);
        obstaclesBox.getChildren().add(Island_List.get(Island_List.size()-1).getImage());

    }


//    public ImageView get_island(){
//        Image img;
//        ImageView island;
//        int i = (new Random().nextInt(12)) + 1;
//        System.out.println(i);
//        String path = "Image_src/Collide/c_island" + i +".png";
//        System.out.println(path);
//        img = new Image(getClass().getResourceAsStream(path));
//        island = new ImageView(img);
//        Island ils = new Island(island);
//        obstaclesBox.getChildren().add(island);
//        island.setLayoutX(400);
//        island.setLayoutY(400);
//        island.setFitHeight(150);
//        island.setFitWidth(200);
//        islands.add(ils);
//        System.out.println(islands);
//        return island;
//    }


    private void attachGameObject(GameObjects t) {
        double pos = 0;
        System.out.println(obstaclesBox + " ob");
        t.attachToPane((Pane) obstaclesBox.getParent(), 500, 20);

//        Pane tn = (Pane)p.getChildren().get(0);
//        System.out.println(tn.getLayoutX()+" "+ tn.getLayoutY());
//        tn.setLayoutX(500);
//        tn.setLayoutY(350);
//        tn.setOpacity(1);
    }

    @Override
    public boolean equals(Object o1) {
        if (o1 != null && getClass() == o1.getClass()) {
            Game g = (Game) o1;
            return (this.id == g.id);
        } else {
            return false;
        }
    }

    public void gen_weaponChest(){
        double offset = hero.getImage().minHeight(hero.getImage().getFitWidth());//Island_List.get(i).getImage().getFitWidth()

        Weapon_chest goc1 = new Weapon_chest();
        goc1.getImage().setFitWidth(80);
        goc1.getImage().setPreserveRatio(true);
        Chest_List.add(goc1);
        goc1.getImage().setLayoutX(Island_List.get(5).getImage().getLayoutX() + 100);
        goc1.getImage().setLayoutY(Island_List.get(5).getImage().getLayoutY() - goc1.getImage().minHeight(goc1.getImage().getFitWidth()));
        obstaclesBox.getChildren().add(goc1.getImage());
    }

    public void gen_CoinChest(){
        double offset = hero.getImage().minHeight(hero.getImage().getFitWidth());//Island_List.get(i).getImage().getFitWidth()

        Coin_chest goc1 = new Coin_chest(10);
        goc1.getImage().setFitWidth(80);
        goc1.getImage().setPreserveRatio(true);
        Chest_List.add(goc1);
        goc1.getImage().setLayoutX(Island_List.get(5).getImage().getLayoutX() + 100);
        goc1.getImage().setLayoutY(Island_List.get(5).getImage().getLayoutY() - goc1.getImage().minHeight(goc1.getImage().getFitWidth()));
        obstaclesBox.getChildren().add(goc1.getImage());
    }

//    private void attachGameObject(GameObjects ob) {
//        double pos = height;
//        if(gameObjects.size() != 0) {
//            pos = gameObjects.get(gameObjects.size() - 1).getPosY().getValue();
//
//            // To reduce gap in case of Colour Switchers
//            if(gameObjects.get(gameObjects.size() - 1) instanceof ColourSwitcher || ob instanceof ColourSwitcher)
//                pos += margin/2;
//
//            // To add some offset
//            // ColourSwitcher loads faster than Obstacle, and have less excess gap due to latency
//            if(ob instanceof ColourSwitcher)
//                pos -= margin/5;
//        }
//        pos -= margin + ob.getHeight();
//        if(gameObjects.isEmpty()) {
//            pos += margin;
//            pos -= 30;
//        }
//        else if(gameObjects.size() <= 2) {
//            pos += margin/2;
//        }
//
//        ob.attachToPane(obstaclesBox, (width-ob.getWidth())/2, pos);
//        gameObjects.add(ob);
//        objectsPosProperty.add(ob.getPosY());
//    }
//
//    private void newObstacle() {
//        try {
//            Class obsType = null;
//            // No two consecutive Obstacles Should be Same
//            while(obsType == null || (gameObjects.size() != 0 && obsType == gameObjects.get(gameObjects.size()-1).getClass())){
//                obsType = map.get((int)(Math.random()*map.size()));
//                if(map.size() == 1)
//                    break;
//            }
//            Obstacle ob = (Obstacle) (obsType.getDeclaredConstructor().newInstance());
//            attachGameObject(ob);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public boolean reborn() {
        clickable = false;
        player.getHelmet().getSpear().getImage().setOpacity(0);
        player.getHelmet().getAxe().getImage().setOpacity(0);
        gameController.resurrect_open();
        return true;
    }

    public int getCoin_count() {
        return coin_count;
    }

    public Hero getHero() {
        return this.hero;
    }
    public int getScoreCount() {
        return score;
    }


    public synchronized void gm(int coin_count, int score) {
        collisionThread.stop();
//        O_collisionThread.stop();
        if(Main.getInstance().getCurrentPlayer().getPassword().length() > 0) {
            Main.getInstance().getCurrentPlayer().setHighScore(Math.max(score, Main.getInstance().getCurrentPlayer().getHighScore()));
            Main.getInstance().getDb().getDetails().get(Main.getInstance().getCurrentPlayer().getId()).set(2, Main.getInstance().getCurrentPlayer().getHighScore() + "");
            Main.getInstance().getDb().getDetails().get(Main.getInstance().getCurrentPlayer().getId()).set(3, Main.getInstance().getCurrentPlayer().getCoin().getCoinVal() + "");
            Main.getInstance().getDb().getDetails().get(Main.getInstance().getCurrentPlayer().getId()).set(4, Main.getInstance().getCurrentPlayer().getCurrentScore() + "");
        }


        player.getHelmet().getSpear().getImage().setOpacity(0);
        player.getHelmet().getAxe().getImage().setOpacity(0);
        player.getHelmet().setHas_Spear(false);
        player.getHelmet().setHas_axe(false);
        gameController.gameover(coin_count, score);
//        Main.getInstance().getDb().getDetails().get(Main.getInstance().getDb().getDetails().size()-1).add(0, u);
//        Main.getInstance().getDb().getDetails().get(Main.getInstance().getDb().getDetails().size()-1).add(1, p);

    }


    private void createDefaultCoins() {
        Random random = new Random();
        for (int i = 1; i < Island_List.size(); i += 2) {
            double offset = hero.getImage().minHeight(hero.getImage().getFitWidth());//Island_List.get(i).getImage().getFitWidth()
            double coinY = Island_List.get(i).getImage().layoutYProperty().getValue() - offset;
            int num = (int) Island_List.get(i).getImage().getFitWidth() / 50;
            for (int j = 0; j < num; j++) {
                Coins coin = new Coins(1);
                coin.getImage().setFitWidth(25);
                coin.getImage().setPreserveRatio(true);
                double coinX = Island_List.get(i).getImage().layoutXProperty().getValue() + 40 + 30 * j;//Island_List.get(i).getImage().getFitWidth()/5;

//                coin.getImage().setLayoutX(470);
//                coin.getImage().setLayoutY(350);
                coin.attachToPane(obstaclesBox, coinX, coinY);
                Coins_List.add(coin);
                CoObj_List.add(coin);
            }
        }
    }

    public void add_coins() {
        double offset = hero.getImage().minHeight(hero.getImage().getFitWidth());//Island_List.get(i).getImage().getFitWidth()
        double coinY = Island_List.get(5).getImage().layoutYProperty().getValue() - offset;
        int num = (int) Island_List.get(5).getImage().getFitWidth() / 50;
        for (int j = 0; j < num; j++) {
            Coins coin = new Coins(1);
            coin.getImage().setFitWidth(25);
            coin.getImage().setPreserveRatio(true);
            double coinX = Island_List.get(5).getImage().layoutXProperty().getValue() + 40 + 30 * j;//Island_List.get(i).getImage().getFitWidth()/5;

//                coin.getImage().setLayoutX(470);
//                coin.getImage().setLayoutY(350);
            coin.attachToPane(obstaclesBox, coinX, coinY);
            Coins_List.add(coin);
            CoObj_List.add(coin);
        }
    }
    public void addOrcs(){
        double offset = hero.getImage().minHeight(hero.getImage().getFitWidth());//Island_List.get(i).getImage().getFitWidth()

        Green_orc goc1 = new Green_orc();
        goc1.getImage().setFitWidth(40);
        goc1.getImage().setPreserveRatio(true);
        Orc_List.add(goc1);
        goc1.getImage().setLayoutX(Island_List.get(5).getImage().getLayoutX() + 100);
        goc1.getImage().setLayoutY(Island_List.get(5).getImage().getLayoutY() - goc1.getImage().minHeight(goc1.getImage().getFitWidth()) - 40);
        obstaclesBox.getChildren().add(goc1.getImage());
        goc1.gravity();
    }
    public void addROrcs(){
        double offset = hero.getImage().minHeight(hero.getImage().getFitWidth());//Island_List.get(i).getImage().getFitWidth()

        Red_orc goc1 = new Red_orc();
        goc1.getImage().setFitWidth(70);
        goc1.getImage().setPreserveRatio(true);
        Orc_List.add(goc1);
        goc1.getImage().setLayoutX(Island_List.get(5).getImage().getLayoutX() + 100);
        goc1.getImage().setLayoutY(Island_List.get(5).getImage().getLayoutY() - goc1.getImage().minHeight(goc1.getImage().getFitWidth()) - 40);
        obstaclesBox.getChildren().add(goc1.getImage());
        goc1.gravity();
    }
    public void addBOrcs(){
        double offset = hero.getImage().minHeight(hero.getImage().getFitWidth());//Island_List.get(i).getImage().getFitWidth()

        Boss_orc goc1 = new Boss_orc();
        goc1.getImage().setFitWidth(80);
        goc1.getImage().setPreserveRatio(true);
        Orc_List.add(goc1);
        goc1.getImage().setLayoutX(Island_List.get(5).getImage().getLayoutX() + 100);
        goc1.getImage().setLayoutY(Island_List.get(5).getImage().getLayoutY() - goc1.getImage().minHeight(goc1.getImage().getFitWidth()) - 40);
        obstaclesBox.getChildren().add(goc1.getImage());
        goc1.gravity();
    }


    //Function started in which collision for starting and function calls
    void threadWork() {
//        SCORE.setText("0");
//        fall();
//        TIMELINE_fall();
//        TIMELINE_jump();
//        TIMELINE_move();

        collisionThread = new Thread(new Game.Collision(), "Collision Thread");
        try {
            collisionThread.start();
        } catch (PlayerDeadSignal pds) {
            collisionThread.interrupt();
        }
//        O_collisionThread = new Thread(new ORCS_COLL(), "ORCS_COLL Thread");
//        try {
//            O_collisionThread.start();
//        } catch (PlayerDeadSignal pds) {
//            O_collisionThread.interrupt();
//        }

    }


    class Collision implements Runnable {

        @Override
        public void run() {

            long counter = 0;
            boolean a = true;

            while (!dead) {
                player.getHelmet().getSpear().getImage().setLayoutY(hero.getImage().getLayoutY()+23);
                player.getHelmet().getAxe().getImage().setLayoutY(hero.getImage().getLayoutY()+23);
                try {
                    System.out.println("In thread 1");

                    ArrayList<Integer> colWithIsls = new ArrayList<>();
                    System.out.println(hero.getImage().getLayoutX() + " " + hero.getImage().getLayoutY() + " " + hero.getImage().getFitWidth() + " " + hero.getImage().minHeight(hero.getImage().getFitWidth()));
                    System.out.println(Island_List.get(0).getImage().getLayoutX() + " " + Island_List.get(0).getImage().getLayoutY() + " " + Island_List.get(0).getImage().getFitWidth() + " " + Island_List.get(0).getImage().minHeight(Island_List.get(0).getImage().getFitWidth()));
                    for (int i = 0; i < Island_List.size(); i++) {
                        colWithIsls.add(i, hero.hasCollided(hero.getImage(), Island_List.get(i).getImage()));
                    }
                    int col_Isls_Summary = 0;
                    for (int i = 0; i < colWithIsls.size(); i++) {
                        col_Isls_Summary += colWithIsls.get(i);
                    }

//                    col_Isls_Summary = hero.hasCollided(hero.getImage(), Island_List.get(0).getImage());
                    System.out.println(col_Isls_Summary);

                    //Island Col Actions
                    if (colWithIsls.contains(100) || colWithIsls.contains(1100)) {
                        hero.getJumpTimeline().pause();
                        hero.gravity();
                    } else if (colWithIsls.contains(1000)) {
                        hero.jump();
                    }

                    for (int i = 0; i < Coins_List.size(); i++) {
                        if (i >= (Coins_List.size())) {
                            break;
                        }
                        if (hero.hasCollided(hero.getImage(), Coins_List.get(i).getImage()) > 0) {
                            coin_count++;
                            player.collisionWithCoin(Coins_List.get(i));
                            Coins_List.get(i).getImage().setOpacity(0);
                            CoObj_List.remove(Coins_List.get(i));
                            Coins_List.remove(i);
                            i--;
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    gameController.setCoinCount(coin_count);
                                }
                            });
                        }
                    }



                    if (colWithIsls.contains(1)) {
                        clickable = false;
                        for (int i = 0; i < Island_List.size(); i++) {
                            Island_List.get(i).getxTimeline().stop();
                        }
                        for (int i = 0; i < Coins_List.size(); i++) {
                            Coins_List.get(i).getxTimeline().stop();
                        }for (int i = 0; i < Chest_List.size(); i++) {
                            Chest_List.get(i).getxTimeline().stop();
                        }
                    }


                    if (hero.getImage().getLayoutX() + hero.getImage().getLayoutY() > 670) {

                        if(player.getCoin().getCoinVal() >= 10){
                            rebornS =  reborn();
                            dead = false;
                            clickable = true;
                        }
                        if(player.getCoin().getCoinVal() < 10){
                            dead = true;
                            player.setHighScore(score);
                            throw new PlayerDeadSignal("Player Died");
                        }

                    }

//                }
//                 catch (PlayerDeadSignal pds){
//                    Thread.currentThread().interrupt();
//                }
                    for (int k = 0; k < Orc_List.size(); k++) {
                        for (int i = 0; i < Island_List.size(); i++) {
                            if (Orc_List.get(k).isCollision(Orc_List.get(k).getImage(), Island_List.get(i).getImage())){
                                Orc_List.get(k).getJumpTimeline().pause();
                                Orc_List.get(k).jump();
                            }
                        }
                    }

                    for (int k = 0; k < Chest_List.size(); k++){
                        if(hero.isCollision(hero.getImage(), Chest_List.get(k).getImage())){
                            double disty1 = Chest_List.get(k).getImage().minHeight(Chest_List.get(k).getImage().getFitWidth());
                            Chest_List.get(k).opened();
                            double disty2 = Chest_List.get(k).getImage().minHeight(Chest_List.get(k).getImage().getFitWidth());
                            Chest_List.get(k).getImage().setLayoutY(Chest_List.get(k).getImage().getLayoutY()+disty1-disty2);
                            if(Chest_List.get(k).isMoney()){
                                player.collisionWithCoin(((Coin_chest)Chest_List.get(k)).getCoin());
                                coin_count+=((Coin_chest)Chest_List.get(k)).getCoin().getCoinVal();
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameController.setCoinCount(coin_count);
                                    }
                                });
                            } else {
                                System.out.println("Got chest");

                                int i = new Random().nextInt(2);
                                if(i == 0) {
                                    if(player.getHelmet().isHas_spear()){
                                        player.getHelmet().Stars_levelup();
                                    } else {
                                        System.out.println("In");
                                        if(!player.getHelmet().isHas_axe()){
                                            System.out.println("Got Axe");
                                            player.setWeap("axe");
                                            player.getHelmet().getAxe().getImage().setOpacity(1);
                                        }

//                                            if(!player.getHelmet().isHas_axe()){
//                                                player.getHelmet().getAxe().getImage().setLayoutX(hero.getImage().getLayoutX()+45);
//                                                player.getHelmet().getAxe().getImage().setLayoutY(hero.getImage().getLayoutY());
//                                                obstaclesBox.getChildren().add(player.getHelmet().getAxe().getImage());
//                                            }
                                        player.getHelmet().setHas_axe(true);
                                        player.getHelmet().Axe_levelup();

                                    }
                                } else {
                                    System.out.println("Out");
                                    if(player.getHelmet().isHas_axe()){
                                        player.getHelmet().Axe_levelup();
                                    } else {
//                                            if(!player.getHelmet().isHas_spear()){
//                                                player.getHelmet().getSpear().getImage().setLayoutX(hero.getImage().getLayoutX()+45);
//                                                player.getHelmet().getSpear().getImage().setLayoutY(hero.getImage().getLayoutY());
//                                                obstaclesBox.getChildren().add(player.getHelmet().getSpear().getImage());
//                                            }
                                        if(!player.getHelmet().isHas_spear()){
                                            System.out.println("Got Spear");
                                            player.setWeap("spear");
                                            player.getHelmet().getSpear().getImage().setOpacity(1);
                                        }



                                        player.getHelmet().setHas_Spear(true);
                                        player.getHelmet().Stars_levelup();
                                    }
                                }
                            }
                            DoneObj.add(Chest_List.get(k));
                            Chest_List.remove(k);
                            break;

                        }
                    }
//                    Weapon w = player.getHelmet().

//                    for(int i = 0; i < Orc_List.size(); i++){
//
//                    }


                    for (int i = 0; i < Orc_List.size(); i++) {
                        int p = hero.hasCollidedNow(hero.getImage(), Orc_List.get(i).getImage());
                        if (p > 0) {
                            if (p >= 1000) {
                                hero.getJumpTimeline().pause();
                                hero.jump();

                            } else if (p >= 100) {
                                Orc_List.get(i).getJumpTimeline().stop();
                                hero.getJumpTimeline().stop();
                                if(player.getCoin().getCoinVal() >= 10){

                                    rebornS = reborn();
                                    dead = false;
                                    clickable = true;
                                }
                                if(player.getCoin().getCoinVal() < 10){
                                    dead = true;
                                    player.setHighScore(score);
                                    throw new PlayerDeadSignal("Player Died by Orc Tackle Move...");
                                }


                            } else if (p >= 10) {
                                // Boss
                            } else if (p >= 1) {
                                // move Orc...
                                hero.getxTimeline().pause();
//                                hero.movX();
                                if(Orc_List.get(i).getOrc_type().equals("Boss")){
                                    Orc_List.get(i).movX(-1);
                                    if(player.getHelmet().isHas_axe() || player.getHelmet().isHas_spear()){
                                        if(((Boss_orc)Orc_List.get(i)).damage(player.getWeapon().getLevel())){
                                            Orc_List.get(i).getImage().setOpacity(0);
                                            Orcs o = Orc_List.get(i);
                                            Platform.runLater(new Runnable() {
                                                @Override
                                                public void run() {
                                                    obstaclesBox.getChildren().remove(o);
                                                    Orc_List.remove(o);
                                                    BOSSdead = true;
                                                }
                                            });

                                        }
                                    }
                                }
                                else {
                                    Orc_List.get(i).movX(-1);

                                    if(player.getHelmet().isHas_axe() || player.getHelmet().isHas_spear()){
                                        Orc_List.get(i).getImage().setOpacity(0);
                                        Orcs o = Orc_List.get(i);
                                        Platform.runLater(new Runnable() {
                                            @Override
                                            public void run() {
                                                obstaclesBox.getChildren().remove(o);
                                                Orc_List.remove(o);
                                            }
                                        });

                                    }
                                }
                            }

                            break;
                        }
                    }

                    try {
                        Thread.sleep(7);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (PlayerDeadSignal pds) {
                    System.out.println("Player has DIED. GAME OVER......");
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            gm(coin_count, score);

                        }
                    });
                }

            }
        }
    }

    class ORCS_COLL implements Runnable {
        Island g = new Island();

        @Override
        public void run() {
            long counter = 0;
            boolean a = true;

            while (!dead) {
                try {
                    System.out.println("In thread 2");


//                    ArrayList<Integer> O_colWithIsls = new ArrayList<>();
//                    for (int k = 0; k < Orc_List.size(); k++) {
//                        for (int i = 0; i < Island_List.size(); i++) {
//                            O_colWithIsls.add(i,g.hasCollidedNow(Orc_List.get(k).getImage(), Island_List.get(i).getImage()));
//                        }
//                        int O_col_Isls_Summary = 0;
//                        for (int j = 0; j < Island_List.size(); j++) {
//                            O_col_Isls_Summary += g.hasCollidedNow(Orc_List.get(k).getImage(), Island_List.get(j).getImage());
//                        }
//                        if (O_colWithIsls.contains(100)|| O_colWithIsls.contains(1100)) {
//                            Orc_List.get(k).getJumpTimeline().pause();
//                            Orc_List.get(k).gravity();
//
//                        } else if (O_colWithIsls.contains(1000)) {
//                            Orc_List.get(k).getJumpTimeline().pause();
//                            Orc_List.get(k).jump();
//
//
//                        }
//                    }
                    for (int k = 0; k < Orc_List.size(); k++) {
                        for (int i = 0; i < Island_List.size(); i++) {
                            if (Orc_List.get(k).isCollision(Orc_List.get(k).getImage(), Island_List.get(i).getImage())){
                                Orc_List.get(k).getJumpTimeline().pause();
                                Orc_List.get(k).jump();
                            }
                        }
                    }


                    for (int i = 0; i < Orc_List.size(); i++) {
                        int p = g.hasCollidedNow(hero.getImage(), Orc_List.get(i).getImage());
                        if (p > 0) {
                            if (p >= 1000) {
                                hero.getJumpTimeline().pause();
                                hero.jump();

                            } else if (p >= 100) {
                                dead = true;
                                Orc_List.get(i).getJumpTimeline().stop();
                                hero.getJumpTimeline().stop();
                                throw new PlayerDeadSignal("Player Died by Orc Tackle Move...");
                            } else if (p >= 10) {
                                // Boss
                            } else if (p >= 1) {
                                // move Orc...
                                hero.getxTimeline().pause();
//                                hero.movX();
                                Orc_List.get(i).movX(-1);
                            }

                            break;
                        }
                    }
//                }
//                 catch (PlayerDeadSignal pds){
//                    Thread.currentThread().interrupt();
//                }

                    try {
                        Thread.sleep(7);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (PlayerDeadSignal pds) {
                    System.out.println("Player has DIED. GAME OVER......");
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            gm(coin_count, score);

                        }
                    });
                }

            }
        }
    }
}