package com.example.will_hero.Weapons;

import com.example.will_hero.Game_Commiter.GameObjects;

public class Weapon extends GameObjects {
    protected int level;

    public Weapon(){
        this.level = 1;
    }

    public Weapon(int level){
        this.level = level;
    }

    public void collsisionWithChest(){
        this.setLevel(getLevel()+1);
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
    //throw fit damage function
}
