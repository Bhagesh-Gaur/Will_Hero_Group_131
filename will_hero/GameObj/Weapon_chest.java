package com.example.will_hero.GameObj;

import com.example.will_hero.Game_Commiter.Collideable;
import com.example.will_hero.Game_Commiter.GameObjects;
import com.example.will_hero.Weapons.Axe;
import com.example.will_hero.Weapons.Spear;
import com.example.will_hero.Weapons.Weapon;

import java.util.Random;

public class Weapon_chest extends Chest implements Collideable {

    public Weapon getWeapon1() {
        return weapon1;
    }

    public void setWeapon1(Weapon weapon1) {
        this.weapon1 = weapon1;
    }

    public Weapon getWeapon2() {
        return weapon2;
    }

    public void setWeapon2(Weapon weapon2) {
        this.weapon2 = weapon2;
    }

    private Weapon weapon1;
    private Weapon weapon2;


    public Weapon_chest(){
        String path = "src/main/resources/com/example/will_hero/Image_src/Collide/c_chestweaponfull1.png";
        loadObjtoPane(path);
        isOpen = false;
        this.money = false;
        this.weapon1 = new Spear();
        this.weapon2 = new Axe();

    }

    public static int get_weapon(){
        int i = (new Random().nextInt(2)) + 1;
        return i;
    }

}
