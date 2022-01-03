package com.example.will_hero.GameObj;

import com.example.will_hero.Game_Commiter.Collideable;
import com.example.will_hero.Game_Commiter.GameObjects;
import com.example.will_hero.GameObj.Controller.Coin_controller;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serializable;
import java.util.Random;

public class Coins extends GameObjects implements Collideable, Serializable {

    private int coinVal;

    private void setCoinVal(int coinVal) {
        this.coinVal = coinVal;
    }
    public void addValue(Coins c){
        this.coinVal += c.getCoinVal();
    }

    public Coins(int val){
        String path = "src/main/resources/com/example/will_hero/Image_src/coin.png";
        loadObjtoPane(path);
        this.coinVal = val;
    }


    private void redeem() {
//        coins_controller.coin.setImage(new Image("assets/animated-star.gif"));
//        coins_controller.coin.setOpacity(1);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        coins_controller.coin.setOpacity(0);
    }


    public void incrementCoinVal(){
        coinVal++;
    }

    public int getCoinVal() {
        return coinVal;
    }

    public void setCoinValue(int c) {
        this.coinVal = c;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Coins Earned: "+ coinVal;
    }

}
