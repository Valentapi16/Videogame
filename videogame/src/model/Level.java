package model;

public class Level {
    public static final int SIZE_OF_TREASURES = 50;
    public static final int SIZE_OF_PLAYERS = 20;
    public static final int SIZE_OF_ENEMIES = 25;
    
    private String levelId;
    private int scoreRequired;
    private int treasuresInGame;
    private int enemiesInGame;

    public Enemy[] enemies;
    public Player[] players;

    public Treasure[] treasures;

    public Level(String alevelId, int ascoreRequired, int atreasuresInGame, int aenemiesInGame){
        levelId = alevelId;
        scoreRequired = ascoreRequired;
        treasuresInGame = atreasuresInGame;
        enemiesInGame = aenemiesInGame;
    }

    public String getLevelId(){
        return levelId;
    }

    public String addEnemyToTheLevel(Enemy enemy){
        String msj = "Enemy limit has been reached";
        boolean isEmpty = false;
        for(int j= 0; j<SIZE_OF_ENEMIES && !isEmpty; j++){
            if(enemies[j] == null){
                enemies[j] = enemy;
                isEmpty= true;
                msj= "The enemy has been added";
            }
        }
        return msj;
    }

    public String addTreasureToTheLevel(Treasure treasure){
        String msj = "Treasure limit has been reached";
        boolean isEmpty = false;
        for(int j= 0; j<SIZE_OF_TREASURES && !isEmpty; j++){
            if(treasures[j] == null){
                treasures[j] = treasure;
                isEmpty= true;
                msj= "The treasure has been added";
            }
        }
        return msj;
    }


    public String addPlayerObject(Player player){
        String msj = "Player limit has been reached";
        boolean isEmpty = false;
        for(int j= 0; j<SIZE_OF_PLAYERS && !isEmpty; j++){
            if(players[j] == null){
                players[j] = player;
                isEmpty= true;
                msj= "The player has been added";
            }
        }
        return msj;
    }

    public int searchPlayerByNickName(String nicknamePlayer){
        int pos = -1;
        boolean isFound= false;
        for(int j = 0; j <SIZE_OF_PLAYERS && !isFound; j ++){
            if(players[j] != null && players[j].getNicknamePlayer().equals(nicknamePlayer)){
                pos = j;
                isFound = true;
            }
        }
        return pos;
    }

    public String removePlayer(String nicknamePlayer){
        String msj = "The player is not found";
        int pos = searchPlayerByNickName(nicknamePlayer);
        if(pos !=-1){
            players[pos] = null;
            msj = "The player has been deleted";
        }
        return msj;
    }
}
