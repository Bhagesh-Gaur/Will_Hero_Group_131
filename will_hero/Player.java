package com.example.will_hero;
//import global.GameNotFoundException;

//import com.example.will_hero.Obstacles.Coins;

import com.example.will_hero.Elements.Helmet;
import com.example.will_hero.GameObj.Coins;
import com.example.will_hero.Weapons.Weapon;

import java.io.Serializable;
import java.util.*;

public class Player implements Serializable, Cloneable {
    private  ArrayList<Game> PLAYER_SAVED_GAMES;
    private int level;

    public ArrayList<Game> getPlayerSavedGames() {
        return PLAYER_SAVED_GAMES;
    }

    private final String username;
    private Coins coin;
    private final String password;
    private int currentScore;
    private String weap;

    private int id;

    public void setPLAYER_SAVED_GAMES(ArrayList<Game> PLAYER_SAVED_GAMES) {
        this.PLAYER_SAVED_GAMES = PLAYER_SAVED_GAMES;
    }

    public void setCoin(Coins coin) {
        this.coin = coin;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }

    public ArrayList<Game> getPLAYER_SAVED_GAMES() {
        return PLAYER_SAVED_GAMES;
    }

    private Helmet helmet;

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void setWeap(String weap) {
        this.weap = weap;
    }

    public Helmet getHelmet() {
        return helmet;
    }

    //    private Coins coin_earned;
    private int highScore;
//    private static final byte[] salt = "MyPasswordSalt".getBytes();
//    private Map<Long, Game> savedGamesMap;
//    private static final long serialversionUID = 7L;

    public Player(String user_name, String password) {
        this.username = user_name;
        this.coin = new Coins(0);
        this.PLAYER_SAVED_GAMES = new ArrayList<Game>();
        this.password = password;//generatePasswordHash(password);
//        this.coin_earned = new Coins(0);
        this.highScore = 0;
        this.weap = "";
        this.currentScore = 0;
        this.level = 0;
        this.helmet = new Helmet();
//        savedGamesMap = new HashMap<Long, Game>();
//    public void
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Player(String un, String pw, int hs, int cc, int cs, String w, int ll){
        this.username = un;
        this.password = pw;
        this.setHighScore(hs);
        this.coin = new Coins(0);
        this.coin.setCoinValue(cc);
        this.currentScore = cc;
        this.weap = w;
        this.level = ll;
        this.helmet = new Helmet();

    }
    public void res(){
        coin.setCoinValue(coin.getCoinVal()-10);
    }

    public Weapon getWeapon(){
        if (helmet.isHas_axe()){
            return helmet.getAxe();
        } else if (helmet.isHas_spear()){
            return helmet.getSpear();
        } else return null;
    }
    public Weapon getWeapon(String w, int level){
        if (w.equals("axe")){
            while (level!=0){
                helmet.Axe_levelup();level--;
            }
            return helmet.getAxe();
        } else if (w.equals("spear")){
            while (level!=0){
                helmet.Stars_levelup();level--;
            }return helmet.getSpear();
        } else return null;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public String getWeap() {
        return weap;
    }

    public Coins getCoin() {
        return this.coin;
    }

    @Override
    public boolean equals(Object o1){
        if (o1 != null && getClass() == o1.getClass()){
            Player p = (Player) o1;
            return (this.username.equals(p.username));
        }
        else{
            return false;
        }
    }

    public void collisionWithCoin(Coins c){
        this.coin.addValue(c);
    }

    @Override
    public String toString(){
        //                Arrays.toString(salt) + "\n";
//        return this.username + "\n" +
//                this.password + "\n" +
//                Integer.toString(getHighScore()) + "\n" + (coin_earned) + "\n";
        return "";
    }

    public void print_player(){
        System.out.println(toString());
    }
//
//    public String getFileName(){
//        String file_prefix = "player_";
//        String file_suffix = ".txt";
//        String filename = file_prefix + this.getUsername() + file_suffix;
//
//        return filename;
//    }

//    private static byte[] generateSalt(){
//        SecureRandom random = new SecureRandom();
//        byte[] salt = new byte[16];
//        random.nextBytes(salt);
//        return salt;
//    }

//    public String generatePasswordHash(String input_password){
//        String hashed_password = null;
//        try{
//            MessageDigest sha = MessageDigest.getInstance("SHA-512");
//            sha.update(salt);
//            byte[] bytes = sha.digest(input_password.getBytes());
//            StringBuilder hashed_hexa = new StringBuilder();
//
//            for(int i=0; i < bytes.length; i++){
//                hashed_hexa.append( Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//            }
//            // password hashed and converted to hexadecimal format
//            hashed_password = hashed_hexa.toString();
//        }
//        catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        return hashed_password;
//    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Player cloned =  (Player) super.clone();
        cloned.setPLAYER_SAVED_GAMES((ArrayList<Game>) PLAYER_SAVED_GAMES.clone());
        cloned.setCoin((Coins) getCoin().clone());
        return cloned;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

//    public Coins getcoinsEarned() {
//        return coin_earned;
//    }

    public void incrementCoinsEarned() {
//        this.coin_earned.incrementCoinVal();
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

//    public Map<Long, Game> getSavedGamesMap(){
//        return savedGamesMap;
//    }


//    public Game findGame(long input_id) {
//        if (savedGamesMap.containsKey(input_id)){
//            return savedGamesMap.get(input_id);
//        }
//        else{
//            return null;
//        }
//    }
//
//    public void saveGame(Game game){
//
//        DateTimeFormatter dt_format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        String date_time = dt_format.format(now);
//        System.out.println(dt_format.format(now));
//
//        game.setDateTime(date_time);
//        savedGamesMap.put(game.getId(), game);
//    }
//
//    public void deleteSavedGame(Game game){
//        savedGamesMap.remove(game.getId());
//    }
//
//    /* For testing purpose only */
//    public Game getPlayerGame(){
//        Iterator iterator = savedGamesMap.entrySet().iterator();
//        if (iterator.hasNext()){
//            Map.Entry map_entry = (Map.Entry) iterator.next();
//            Game g = (Game) map_entry.getValue();
//            return g;
//        }
//        else{
//            System.out.println("No game in hashmap!");
//            return null;
//        }
//    }
}