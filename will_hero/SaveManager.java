package com.example.will_hero;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SaveManager {
    public static void save(Serializable data, String filename) throws Exception{
        try (ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))) {
            os.writeObject(data);
        }
    }
    public static Object load(String fileName) throws Exception{
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return ois.readObject();
        }
    }
}