package com.example.will_hero;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class DataField implements Serializable {
    private final SimpleIntegerProperty gameCode;
    private final SimpleIntegerProperty score;
    DataField(Player p, int i){

        gameCode = new SimpleIntegerProperty(i);
        score = new SimpleIntegerProperty(p.getPlayerSavedGames().get(i).getScore());
    }

    DataField(int a, Integer b){
        gameCode = new SimpleIntegerProperty(a);
        score = new SimpleIntegerProperty(b);
    }

    public int getGameCode() {
        return gameCode.get();
    }

    public int getScore() {
        return score.get();
    }

}