package com.example.will_hero.Weapons;

import com.example.will_hero.Game_Commiter.Collideable;

public class Spear extends Weapon implements Collideable {

    public int getSpear_damage() {
        return Spear_damage;
    }

    public void setSpear_damage(int spear_damage) {
        Spear_damage = spear_damage;
    }

    private int Spear_damage;
    public Spear(){
        this.Spear_damage = 0;
        String path = "src/main/resources/com/example/will_hero/Image_src/Collide/WeaponKnife.png";
        loadObjtoPane(path);
    }

}
