package com.example.will_hero.Elements;

import com.example.will_hero.Weapons.Axe;
import com.example.will_hero.Weapons.Spear;

import java.util.ArrayList;

public class Helmet {
    private boolean has_axe;
    private boolean has_spear;

    public Axe getAxe() {
        return axe;
    }

    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    public Spear getSpear() {
        return spear;
    }

    public void setSpear(Spear spear) {
        this.spear = spear;
    }

    private Axe axe;
    private Spear spear;

    public Helmet(){
        this.has_axe= false;
        this.has_spear = false;
        this.axe = new Axe();
        this.spear = new Spear();
    }

    public void Axe_levelup(){
        this.axe.setAxe_damage(axe.getAxe_damage()+5);
    }

    public void Stars_levelup(){
        this.spear.setSpear_damage(spear.getSpear_damage()+5);
    }

    public boolean isHas_axe() {
        return has_axe;
    }

    public boolean isHas_spear() {
        return has_spear;
    }

    public void setHas_axe(boolean a){
        this.has_axe = a;
    }
    public void setHas_Spear(boolean a) {
        this.has_spear = a;
    }

    }
