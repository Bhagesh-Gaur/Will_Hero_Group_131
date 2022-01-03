package com.example.will_hero.GameObj;

import com.example.will_hero.Game_Commiter.Collideable;
import com.example.will_hero.Game_Commiter.GameObjects;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Chest extends GameObjects {
    protected boolean isOpen;
    protected boolean money;
    public void opened(){
        try {
//            ImageView img = new ImageView(new Image(new FileInputStream("src/main/resources/com/example/will_hero/Image_src/NonCollide/nc_openchest.png")));
            this.getImage().setImage(new Image(new FileInputStream("src/main/resources/com/example/will_hero/Image_src/NonCollide/nc_openchest.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean isMoney() {
        return money;
    }
}
