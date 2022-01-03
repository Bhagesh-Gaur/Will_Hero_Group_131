package com.example.will_hero.GameObj;

import com.example.will_hero.Game_Commiter.Collideable;
import com.example.will_hero.Game_Commiter.GameObjects;
import com.example.will_hero.Weapons.Weapon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Coin_chest extends Chest implements Collideable {
    private Coins coin;



    public Coin_chest(int val){
        String path = "src/main/resources/com/example/will_hero/Image_src/Collide/c_chestcoinfull3.png";
        loadObjtoPane(path);
        this.money = true;
        this.coin = new Coins(val);
        this.isOpen = false;
    }

    public Coins getCoin() {
        return coin;
    }
}
