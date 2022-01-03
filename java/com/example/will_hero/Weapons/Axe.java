package com.example.will_hero.Weapons;

import com.example.will_hero.Game_Commiter.Collideable;

public class Axe extends Weapon implements Collideable {

    public int getAxe_damage() {
        return Axe_damage;
    }

    public void setAxe_damage(int axe_damage) {
        Axe_damage = axe_damage;
    }

    private int Axe_damage;

    public Axe(){
        this.Axe_damage = 0;
        String path = "src/main/resources/com/example/will_hero/Image_src/Collide/c_WeaponAxe.png";
        loadObjtoPane(path);
    }
}
