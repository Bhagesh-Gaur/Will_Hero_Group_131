package com.example.will_hero.Elements;

import java.io.Serializable;
import java.util.Random;

public class Green_orc extends Orcs implements Serializable {
    public Green_orc(){
        super("Green","Normal");
        String path = get_on();
        loadObjtoPane(path);
    }

    public static String get_on(){
        int i = (new Random().nextInt(5)) + 1;
//        System.out.println(i);
        String path = "src/main/resources/com/example/will_hero/Image_src/Collide/Orc" + i +".png";
//        System.out.println(path);
        return path;
    }
}
