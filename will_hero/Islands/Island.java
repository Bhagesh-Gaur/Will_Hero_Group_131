package com.example.will_hero.Islands;

import com.example.will_hero.Game_Commiter.Collideable;
import com.example.will_hero.Game_Commiter.GameObjects;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class Island extends GameObjects implements Collideable {
    public Island(){
        String path = get_islandPath();
        loadObjtoPane(path);
    }


    public Island(String path) {
        loadObjtoPane(path);
//        Image i = null;
//        try {
//            i = new Image(new FileInputStream(path));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        this.setPane(new ImageView(i));
    }

    public static String get_islandPath(){
        int i = (new Random().nextInt(12)) + 1;
//        System.out.println(i);
        String path = "src/main/resources/com/example/will_hero/Image_src/Collide/c_island" + i +".png";
//        System.out.println(path);
        return path;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
