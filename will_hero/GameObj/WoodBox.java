package com.example.will_hero.GameObj;


import com.example.will_hero.Game_Commiter.Collideable;
import com.example.will_hero.Game_Commiter.GameObjects;
import javafx.fxml.Initializable;

public class WoodBox extends GameObjects implements Collideable {

    private boolean active;

    public WoodBox(){
        String path = "Image_src/Collide/c_woodenBox.png";
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

//        tntcontroller.tnt.setOpacity(0);
    }

}
