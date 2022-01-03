package com.example.will_hero.Game_Commiter;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public interface Collideable {

    Object o = new Object();

    public default int hasCollided(ImageView img, ImageView obs){
        synchronized (o){
            int col_status = 0;
            double x =  img.getLayoutX();
            double y =  img.getLayoutY();
            double w =  img.getFitWidth();
            double h =  img.minHeight(img.getFitWidth());

            double x_ =  obs.getLayoutX();
            double y_ =  obs.getLayoutY();
            double w_ =  obs.getFitWidth();
            double h_ =  obs.minHeight(obs.getFitWidth());

            boolean fxfx;
            fxfx = (x_ <= x+w && x+w <= x_+w_) || (x <= x_+w_ && x_+w_ <= x+w);
            boolean fyfy;
            fyfy = (y_ <= y && y <= y_+h_) || (y <= y_ && y_ <= y+h);

            // Right
            if ( ( x_<=x+w && x+w<=x_+w_ && (x+w-x_ < w/5) &&  fyfy )){
                col_status+=1;
            } else {
                col_status+=0;
            }
            // Left
            if ( ( x_<=x && x<=x_+w_ && (x_+w_-x < w/5)) &&  fyfy ){
                col_status+=10;
            }
            // Up
            if ( ( y_ <= y && y <= y_+h_ && (y_ + h_ - y < h/5)) &&  fxfx ){
                col_status+=100;
            }
            // Down
            if ( ( y_ <= y+h && y+h <= y_+h_ && (y+h-y_ < h/5)) &&  fxfx ){
                col_status+=1000;
            }
            return col_status;
        }
    }

    public default int hasCollidedNow(ImageView img, ImageView obs){

        int col_status = 0;
        double x =  img.getLayoutX();
        double y =  img.getLayoutY();
        double w =  img.getFitWidth();
        double h =  img.minHeight(img.getFitWidth());

        double x_ =  obs.getLayoutX();
        double y_ =  obs.getLayoutY();
        double w_ =  obs.getFitWidth();
        double h_ =  obs.minHeight(obs.getFitWidth());

        boolean fxfx;
        fxfx = (x_ <= x+w && x+w <= x_+w_) || (x <= x_+w_ && x_+w_ <= x+w);
        boolean fyfy;
        fyfy = (y_ <= y && y <= y_+h_) || (y <= y_ && y_ <= y+h);

        // Right
        if ( ( x_<=x+w && x+w<=x_+w_ && (x+w-x_ < w/5) &&  fyfy )){
            col_status+=1;
        } else {
            col_status+=0;
        }
        // Left
        if ( ( x_<=x && x<=x_+w_ && (x_+w_-x < w/5)) &&  fyfy ){
            col_status+=10;
        }
        // Up
        if ( ( y_ <= y && y <= y_+h_ && (y_ + h_ - y < h/5)) &&  fxfx ){
            col_status+=100;
        }
        // Down
        if ( ( y_ <= y+h && y+h <= y_+h_ && (y+h-y_ < h/5)) &&  fxfx ){
            col_status+=1000;
        }
        return col_status;
    }

    public default boolean isCollision(ImageView a, ImageView b) {

        int col_status = 0;
        double x = a.getLayoutX();
        double y = a.getLayoutY();
        double w = a.getFitWidth();
        double h = a.minHeight(a.getFitWidth());

        double x_ = b.getLayoutX();
        double y_ = b.getLayoutY();
        double w_ = b.getFitWidth();
        double h_ = b.minHeight(b.getFitWidth());

        boolean fxfx;
        fxfx = (x_ <= x + w && x + w <= x_ + w_) || (x <= x_ + w_ && x_ + w_ <= x + w);
        boolean fyfy;
        fyfy = (y_ <= y && y <= y_ + h_) || (y <= y_ && y_ <= y + h);
        return fyfy&&fxfx;
    }



}