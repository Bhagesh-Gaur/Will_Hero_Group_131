package com.example.will_hero;

public class PlayerDeadSignal extends RuntimeException{
    PlayerDeadSignal(String msg) {
        super(msg);
    }
}
