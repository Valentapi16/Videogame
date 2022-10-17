package model;

public class Level {
    public static final int SIZE_OF_TREASURES = 50;
    public static final int SIZE_OF_PLAYERS = 20;
    public static final int SIZE_OF_ENEMIES = 25;
    
    private int levelId;
    private int scoreRequired;

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

    
}
