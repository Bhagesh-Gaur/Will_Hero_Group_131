package com.example.will_hero.Elements;

import java.util.Random;

public class Red_orc extends Orcs {
    public Red_orc(){
        super("Red","Normal");
        String path = get_on();
        loadObjtoPane(path);

    }
    public static String get_on(){
        int i = (new Random().nextInt(5)) + 1;
//        System.out.println(i);
        String path = "src/main/resources/com/example/will_hero/Image_src/Collide/c_redorg" + i +".png";
//        System.out.println(path);
        return path;
    }
}
