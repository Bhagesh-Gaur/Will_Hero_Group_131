package com.example.will_hero;

import com.example.will_hero.Game;
import com.example.will_hero.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class DataBase {
    private ArrayList<Game> games;
    private HashMap<String, Player> users;
    private String dropBox = "src/main/java/com/example/will_hero/Elements/hi";


//    public DataBase() throws IOException, ClassNotFoundException {
    public DataBase(){
        deserialize();
        if (games == null){
            games = new ArrayList<>();
        } if (users == null){
            users = new HashMap<>();
        }
    }
    public void serialize(){
        ObjectOutputStream outputStream = null;
        System.out.println(games);
        System.out.println(users);
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(dropBox));
        } catch (EOFException e){
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.writeObject(games);
        }  catch (EOFException e){
            return;
        }catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.writeObject(users);
        }  catch (EOFException e){
            return;
        }catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.flush();
        }  catch (EOFException e){
            return;
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deserialize(){
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(dropBox));
        }  catch (EOFException e){
            return;
        }catch (IOException e) {
            e.printStackTrace();
        }
        try {
            games = (ArrayList<Game>) inputStream.readObject();
            System.out.println(games);
        } catch (EOFException e){
            return;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            users = (HashMap<String, Player>) inputStream.readObject();
            System.out.println(users);
        }  catch (EOFException e){
            return;
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public HashMap<String, Player> getUsers() {
        return users;
    }

    public String getDropBox() {
        return dropBox;
    }
}
