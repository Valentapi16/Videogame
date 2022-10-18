package model;

public class Level {

    
    private int levelId;
    private int scoreRequired;

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
