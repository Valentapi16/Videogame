package model;

import model.Level;
import model.Player;
import model.Treasure;
import model.Enemy;

public class Game {

    public static final int ALL_PLAYERS= 20;
    public static final int ALL_ENEMIES= 25;
    public static final int ALL_LEVELS= 10;
    public static final int ALL_TREASURES = 50;

    private Player[] players;
    private Enemy [] enemies;
    private Level [] levels;
    private Treasure [] treasures; 

    private Player player;
    private Enemy enemy;
    private Treasure treasure;

    public Game(){
        levels = new Level[ALL_LEVELS];
        levels[0]= new Level("1", 0, 0, 0);
        levels[1]= new Level("2", 0, 0, 0);
        levels[2]= new Level("3", 0, 0, 0);
        levels[3]= new Level("4", 0, 0, 0);
        levels[4]= new Level("5", 0, 0, 0);
        levels[5]= new Level("6", 0, 0, 0);
        levels[6]= new Level("7", 0, 0, 0);
        levels[7]= new Level("8", 0, 0, 0);
        levels[8]= new Level("9",0 , 0, 0);
        levels[9]= new Level("10", 0, 0, 0);
        players = new Player[ALL_PLAYERS];
        enemies = new Enemy[ALL_ENEMIES];
        treasures = new Treasure[ALL_TREASURES];
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

    public int searchLevel(String levelId){
        int pos = -1;
        boolean isFound = false;
        for(int j = 0; j< ALL_LEVELS && !isFound; j++){
            if(levels[j].getLevelId().equalsIgnoreCase(levelId)){
                pos = j;
                isFound = true;
            }
        }
        return pos;
    }

    public String allocateTreasureToLevel(String nameTreasure,String levelId, int scoreRequired, String linkImage, int amountPerLevel){
        String msj = "Unable to complete the action ";
        Treasure newTreasure = new Treasure(nameTreasure, nameTreasure, amountPerLevel, scoreRequired, amountPerLevel);
        int posLevel = searchLevel(levelId);
        if(posLevel != -1){
            msj = levels[posLevel].addTreasureToTheLevel(newTreasure);
        }
        return msj;
    }

    public String allocateEnemyToLevel(String nameEnemy,String levelId, String typeOfEnemy, int lessPointsPlayer, int morePointsPlayer){
        String msj ="Unable to complete the action";
        Enemy newEnemy = new Enemy(nameEnemy, lessPointsPlayer, morePointsPlayer, typeOfEnemy);
        int posLevel = searchLevel(levelId);
        if(posLevel != -1){
            msj = levels[posLevel].addEnemyToTheLevel(newEnemy);
        }
        return msj;
    }

    public Player searchPlayerByNickName(String nickName){
		Player playerFound = null;
		for(int i=0; i < ALL_PLAYERS && playerFound ==null; i++){
			if(players[i] !=null && players[i].getNicknamePlayer().equals(nickName)){
				playerFound = players[i];
			}
		}
		return playerFound;
	}

    public int playerUbication(String nickNameToFind){
		int levelIndex = -1;
		for(int i=0; i< ALL_LEVELS && levelIndex == -1; i++){
			if(levels[i] != null && levels[i].searchPlayerByNickName(nickNameToFind)!=-1){
				levelIndex=i;
			}
		}
		return levelIndex;

	}

    public void addChangedPlayerToAnotherLevel(Player toAdd, String levelId){
        String msj = "Player cannot be added to level";
        int pos = searchLevel(levelId); 
        if(pos != -1){
            msj = levels[pos].addPlayerObject(toAdd);
        }
    }

    public String changePlayerToAnotherLevel(String nicknamePlayer,String otherLevel){
        String msj = "Try again, there must be a mistake";
        Player toChange = searchPlayerByNickName(nicknamePlayer);
        int lastLevel = -1;
        if(toChange != null){
            lastLevel = playerUbication(nicknamePlayer);
        }
        if(lastLevel != -1){
            levels[lastLevel].removePlayer(nicknamePlayer);
            addChangedPlayerToAnotherLevel(toChange, otherLevel);
            msj = "Player level has been changed";

        }
        return msj;
    }
    private boolean modifiedScorePlayer(){
        
    }
}
