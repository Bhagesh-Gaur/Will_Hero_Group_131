package com.example.will_hero;

import com.example.will_hero.Game_Commiter.Collideable;
import com.example.will_hero.Game_Commiter.GameObjects;
//import com.example.will_hero.Obstacles.Coins;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class Obstacle extends GameObjects implements Collideable {
    // We will center the pane
    // Movement open only in Y axis

    // It will have a star if required
    // Stores Null if No Star is present inside the Obstacle
//    private ArrayList<Coins> coins;

//    public Obstacle() {
//        coins = new ArrayList<>();
//    }

    // Getters and Setters

    // To be verified, which type of bound is required

    public int hasCollidedWithStar(Node b) {
        // Returns 1 if it has collided with the star
        int res = 0;
//        for(Coins c: coins) {
//            if(c.hasCollided(b) == 1) {
//                res = -1;
//                break;
//            }
//        }
        return res;
    }

    protected void loadStar(Pane customPane) {
//        if(customPane != null) {
//            Coins c = new Coins();
//            c.attachToPane(customPane, 0, 0);
//            coins.add(c);
//        }
    }
}
