package model;

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
    /**
	* getPlayer: Method that will get the object player 
	* @return Player player: will retunr the object player
	*/
    public Player getPlayer(){
        return player;
    }
    /**
	* getPlayer: Method that will get the array of the object player 
	* @return Player player: will retunr the object player
	*/
    public Player[] getAllPlayer(){
        return players;
    }

    public Enemy getEnemy(){
        return enemy;
    }
    
    public Treasure[] getAllTreasures(){
        return treasures;
    }
    /**
	* createPlayer: Method that will create the player
    * @param nickName: the nickname of the player
    * @param name : The real name of the player
	* @return String msj: A confirmation messaje after the player has been created
	*/
    public String createPlayer(String nickname, String name){
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
    /**
	* thereIsASpaceForPlayer: Method that will look in the array if there are space for another player
	* @return String msj: Depending to the space in the arrary will display a messaje
	*/
    public String thereIsASpaceForPlayer(){
        String msj ="Available position";
        if(players[0] == null){
            msj = "No hay jugadores ";
        }else if(players[ALL_PLAYERS-1] != null){
            msj = "The player limit was filled";
        }
        return msj;
    } 
    /**
	* lookForPlayer: Method that will search across the array for the name of the player
    * @param nickName: the name of the player
	* @return Depending to the space in the arrary will display a messaje
	*/
    public Player lookForPlayer(String nickName){
        Player player = null;
        for(int i = 0; i < ALL_PLAYERS; i++){
            if(players[i] != null && players[i].getNicknamePlayer().equalsIgnoreCase(nickName)){
               player = players[i];
            }            
        }
        return player;
    }
    /**
	* spaceForEnemies: Method that will look in the array if there are space for another player
	* @return String msj: Depending to the space in the arrary will display a messaje
	*/
    public String spaceForEnemies(){
        String msj ="Available Position";
        if(enemies[0] == null){
            msj = "There are no enemies ";
        }else if(enemies[ALL_ENEMIES-1] != null){
            msj = "The enemies limit was filled";
        }
        return msj;
    }
    /**
	* lookForEnemy: Method that will search across the array a enemy
    * @param enemyName: the name of the Enemy 
	* @return String msj: Depending to the space in the arrary will display a messaje
	*/
    public Enemy lookForEnemy (String enemyName){
        Enemy enemy = null;
        for(int i = 0; i < ALL_ENEMIES; i++){
            if(enemies[i] != null && enemies[i].getName().equalsIgnoreCase(enemyName)){
               enemy = enemies[i];
            }            
        }
        return enemy;
    }
    /**
	* createTreasure: Method used to create a treasure
    * @param nameEnemy: String The name of the Treasure
    * @param morePointsPLayer: int The amount of points that will give to player if the enemy is defeated
    * @param lessPointsPlayer: int is the amount of points that will lose the player if the enemy win
    * @param typeOfEnemy: String The type of Enemy
	* @return String msj: the message displaying a messaje of confirmation after the enemy has been created
	*/
    public String createEnemy(String nameEnemy, int lessPointsPlayer,int morePointsPlayer, String typeOfEnemy, int level){
        String msj = "The enemy has been created";
        boolean isEmpty = false;
        for(int i = 0; i < ALL_ENEMIES && !isEmpty; i++){
            if(enemies[i] == null){
                enemies[i] =  new Enemy(nameEnemy, lessPointsPlayer, morePointsPlayer, typeOfEnemy, null, level, i);
                isEmpty = true;
            }
        }
        return msj;
    }
    /**
	* spaceForTreasures: Method that will look in the array if there are space for another treasure
	* @return String msj: Depending to the space in the arrary will display a messaje
	*/
    public String spaceForTreasures(){
        String msj ="Available";
        if(treasures[0]==null){
            msj = "No hay tesoros";
        }else if(treasures[ALL_TREASURES-1] != null){
            msj = "The treasure limit was filled";
        }
        return msj;
    }
    /**
	* createTreasure: Method used to create a treasure
    * @param nameTreasure: String The name of the Treasure
    * @param linkTreasure: String The link of the image according to the treasure
    * @param pointsToPlayer: int is the amount of points that will give to the player
    * @param level: int The level that will be the treasure created
	* @return String msj: the message displaying a messaje of confirmation after the treasure has been created
	*/
    public String createTreasure(String nameTreasure, String linkTreasure, int pointsToPlayer, int level){
        String msj = "The treasure has been created";
        boolean isEmpty = false;
        for(int i = 0; i < ALL_TREASURES && !isEmpty; i++){
            if(treasures[i] == null){
                treasures[i] =  new Treasure(nameTreasure, linkTreasure, pointsToPlayer, i, null, level, i);
                isEmpty = true;
            }
        }
        return msj;
    }

    /**
	* modifiedScorePlayer: Method used to modified the score of one player
    * @param Points: int The amount Score of the player
    * @param nickName: String the nickname of the player
	* @return String msj: the message displaying the score of the player after been modified
	*/
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
    /**
	* upgradeLevelPlayer:  Method used to increase the level of the player
    * @param nickName : The nickname of the player
	* @return String msj: the message displaying the informacion about the upgrade according to the score
	*/
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
    /**
	* theEnemies:  Shows a list of the enemies found in a level
    * @param level :The level at which the information is being requested
	* @return String msj: Displays a list of the enemies
	*/
    public String theEnemies(int level){
        String msj = "The enemies: ";
        for(int i= 0;i<ALL_ENEMIES; i++){
            if(enemies[i] != null && enemies[i].getLevelEnemy().getLevelId()== level){
                msj += enemies[i].getName() + ",";
            }
        }
        return msj;
    }
    /**
	* theTreasures:  Shows a list of the treasures found in a level
    * @param Level : The level at which the information is being requested
	* @return String msj: Displays a list of the names treasures
	*/
    public String theTreasures(int level){
        String msj = "The treasures: ";
        for(int i = 0; i<ALL_TREASURES; i ++){
            if(treasures[i] != null && treasures[i].getTreasureLevel().getLevelId() == level){
                msj += treasures[i].getNameTrea() + ",";
            }
        }
        return msj;
    }
    /**
	* allTreasuresAlongTheGame:  Search for the number of treasures with the same name in the whole game
	* @return String:msj the message displaying the number of treasures
	*/ 
    public String allTreasuresAlongTheGame(String treasureName){
        String msj = "The treasures found: ";
        int count = 0;
        for(int i = 0; i<ALL_TREASURES; i ++){
            if(treasures[i] != null && treasures[i].getNameTrea().equalsIgnoreCase(treasureName)){
                count ++;
            }
        }
        if(count == 0){
            msj= "At this moment, there are no treasures by that name";
        }else{
            msj += count;
        }
        return msj;
    }
    /**
	* amountOfTreasure:  Search for the item with the lowest price
	* @return the message displaying the lowest priced item of those in the array
	*/
    public String amountOfTreasures(){
        String msj = "The treasure is Found: ";
        int count = 0;
        int amountOfTreasures = 0;
        String maximumNameTreasure = null;
        for(int i = 0; i< ALL_TREASURES; i++){

            for(int j = 0; j < ALL_TREASURES; j++){
                if(treasures[i]!=null && treasures[j]!= null && treasures[i].getNameTrea().equalsIgnoreCase(treasures[j].getNameTrea())){
                    count ++;
                }
            
            }
            if(count > amountOfTreasures ){
                amountOfTreasures =count;
                maximumNameTreasure = treasures[i].getNameTrea();
            }
        }
        msj += amountOfTreasures;

        return msj;

    }
}
