package com.example.will_hero.GameObj;

import com.example.will_hero.Game_Commiter.Collideable;
import com.example.will_hero.Game_Commiter.GameObjects;
//import com.example.will_hero.Obstacles.Controller.TNT_controller;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.Image;

public class TNT extends GameObjects implements Collideable{// implements Collideable {
//    private TNT_controller tntcontroller;
    private boolean active;

    public TNT(){
        String path = "Image_src/Collide/c_tnt.png";
        this.active = true;
        loadObjtoPane(path);
    }


    private void explode() {
//        tntcontroller.img.setImage(new Image("Image_src/Collide/c_bossorg.png"));
//        tntcontroller.tnt.setOpacity(1);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.active = false;

//        tntcontroller.tnt.setOpacity(0);
    }
}


