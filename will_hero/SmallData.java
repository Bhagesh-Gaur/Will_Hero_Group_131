package com.example.will_hero;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SmallData {
    private ArrayList<ArrayList<String>> Details;
    private String dropBox = "src/main/java/com/example/will_hero/Elements/hi";

    public SmallData(){
        this.Details = new ArrayList<>();
    }

    public ArrayList<ArrayList<String>> getDetails() {
        return Details;
    }

    public void setDetails(ArrayList<ArrayList<String>> details) {
        Details = details;
    }

    public void serialize(){
        ObjectOutputStream outputStream = null;
        System.out.println(Details);
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(dropBox));
        } catch (EOFException e){
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.writeObject(Details.clone());
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
            Details = (ArrayList<ArrayList<String>>) inputStream.readObject();
            System.out.println(Details);
        } catch (EOFException e){
            return;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
