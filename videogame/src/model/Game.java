package model;

import model.Level;
import model.Player;
import model.Treasure;
import model.Enemy;

public class Game {

    public static final int ALL_PLAYERS = 20;
    public static final int ALL_ENEMIES = 25;
    public static final int ALL_LEVELS = 10;
    public static final int ALL_TREASURES = 50;

    private Player[] players;
    private Enemy [] enemies;
    private Level [] levels;
    private Treasure [] treasures; 

    private Player player;
    private Enemy enemy;
    private Treasure treasure;

    private int resolutionX;
    private int resolutionY;

    public Game(){
        resolutionX = 1280;
        resolutionY = 720;
        levels = new Level[ALL_LEVELS];
        players = new Player[ALL_PLAYERS];
        enemies = new Enemy[ALL_ENEMIES];
        treasures = new Treasure[ALL_TREASURES];
        for(int i = 0; i < ALL_LEVELS; i++){
            levels[i] = new Level(i + 1, (i + 1)*20);
        }
    }

    public Player getPlayer(){
        return player;
    }

    public Player[] getAllPlayer(){
        return players;
    }

    public Enemy getEnemy(){
        return enemy;
    }
    
    public Treasure[] getAllTreasures(){
        return treasures;
    }

    public String addPlayer(String nickname, String name){
        String msj = "There're no more space for more players";
        boolean isEmpty = false;
        for(int j = 0; j<ALL_PLAYERS && !isEmpty; j++){
            if(players[j] == null){
                players[j] = player;
                isEmpty = true;
                msj = "The player has been added";
            }
        }
        return msj;
    }
    public String thereIsASpaceForPlayer(){
        String msj ="Posicion disponible";
        if(players[0] == null){
            msj = "No hay jugadores ";
        }else if(players[ALL_PLAYERS-1] != null){
            msj = "Limite de jugadores alcanzado";
        }
        return msj;
    } 

    public Player searchPlayer(String nickName){
        Player player = null;
        for(int i = 0; i < ALL_PLAYERS; i++){
            if(players[i] != null && players[i].getNicknamePlayer().equalsIgnoreCase(nickName)){
               player = players[i];
            }            
        }
        return player;
    }

    public Enemy searchEnemy(String nameEnemy){
        Enemy enemy = null;
        for(int i = 0; i < ALL_ENEMIES; i++){
            if(enemies[i] != null && enemies[i].getName().equalsIgnoreCase(nameEnemy)){
               enemy = enemies[i];
            }            
        }
        return enemy;
    }

    public String addEnemy(String nameEnemy, int scorePlus, int scoreLess, int type, int level){
        String msj = "Se creo un enemigo";
        boolean isEmpty = false;
        for(int i = 0; i < ALL_ENEMIES && !isEmpty; i++){
            if(enemies[i] == null){
                enemies[i] =  new Enemy(nameEnemy, i, i, msj, null, level, i);
                isEmpty = true;
            }
        }
        return msj;
    }

    public String treasureAvailability(){
        String msj ="Posicion Disponible";
        if(treasures[0]==null){
            msj = "No hay tesoros";
        }else if(treasures[ALL_TREASURES-1] != null){
            msj = "Limite de tesoros alcanzado ";
        }
        return msj;
    }

    public String addTreasure(String nameTreasure, String UrlImage, int  scorePlusTreasure, int level){
        String msj = "Se creo un tesoro";
        boolean isEmpty = false;
        for(int i = 0; i < ALL_TREASURES && !isEmpty; i++){
            if(treasures[i] == null){
                treasures[i] =  new Treasure(nameTreasure, nameTreasure, i, i, null, level, i);
                isEmpty = true;
            }
        }
        return msj;
    }


    public String modifiedScorePlayer(int Points, String nickName){
        String msj = "The score player has been modified";
        for(int i = 0; i<ALL_PLAYERS; i++){
            if(players[i] != null && players[i].getNicknamePlayer().equalsIgnoreCase(nickName)){
                if(players[i].getScore() >= Points){
                    msj= "Only can assign more score to the actual";
                }else{
                    players[i].setInitialScore(Points);
                }
            }
        }
        return msj;
    }

    public String upgradeLevelPlayer(String nickName){
        String msj = "The upgrade of Score has been succesfull";
        for(int i = 0; i<ALL_PLAYERS; i++){
            if(players[i] != null && players[i].getNicknamePlayer().equalsIgnoreCase(nickName)){
                if(players[i].getScore()< players[i].getLevel().getScoreRequired()){
                    msj="You dont have the score needed to upgrade level";
                }else if(players[i].getLevel().getLevelId() == 10){
                    msj= "Sorry, you have been reached the maximum level";
                }else{
                    players[i].setLevel(levels[players[i].getLevel().getLevelId()]);
                    msj += "You upgrade level: " + players[i].getLevel().getLevelId();
                }
            }
        }
        return msj;
    }

    public String theEnemies(int level){
        String msj = "The enemies: ";
        for(int i= 0;i<ALL_ENEMIES; i++){
            if(enemies[i] != null && enemies[i].getLevelEnemy().getLevelId()== level){
                msj += enemies[i].getName() + ",";
            }
        }
        return msj;
    }

    public String theTreasures(int Level){
        String msj = "The treasures: ";
        for(int i = 0; i<ALL_TREASURES; i ++){
            if(treasures[i] != null && treasures[i].getTreasureLevel().getLevelId() == Level){
                msj += treasures[i].getNameTrea() + ",";
            }
        }
        return msj;
    }
}
