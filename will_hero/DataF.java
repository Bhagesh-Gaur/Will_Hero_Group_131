package com.example.will_hero;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class DataF implements Serializable {
    private final SimpleStringProperty gameCode;
    private final SimpleIntegerProperty score;


    DataF(String a, Integer b){
        gameCode = new SimpleStringProperty(a);
        score = new SimpleIntegerProperty(b);
    }

    public String getGameCode() {
        return gameCode.get();
    }

    public int getScore() {
        return score.get();
    }

}
