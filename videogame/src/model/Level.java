package model;

public class Level {
    public static final int SIZE_OF_TREASURES = 50;
    public static final int SIZE_OF_PLAYERS = 20;
    public static final int SIZE_OF_ENEMIES = 25;
    
    private int levelId;
    private int scoreRequired;
    private ComplexLevel complexLevel;

    public Enemy[] enemies;
    public Player[] players;

    public Treasure[] treasures;

    public Level(int levelId, int scoreRequired){
        this.levelId = levelId;
        this.scoreRequired = scoreRequired;
       
        
        
    }

    public int getLevelId(){
        return levelId;
    }

    public int getScoreRequired(){
        return scoreRequired;
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

    
    //public void complexLevel(){

       // if(scoreRequired>10 && scoreRequired<=45){
           // complexLevel = "Easy";
        //}else if(scoreRequired>=46 && scoreRequired<= 70){
            //complexLevel  = "Medium";
       // }else if (scoreRequired>= 71 && scoreRequired<=100){
           // complexLevel="Heavy";
        //}
    //}
}
