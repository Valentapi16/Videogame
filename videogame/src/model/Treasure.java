package model;
import java.util.Random;
public class Treasure {

    public static final int SIZE_OF_TREASURES= 50;
    private String nameTreasure;
    private String linkTreasure;
    private int pointsPlayer;
    private int positionX;
    private int positionY;
    private Level level;


    public Treasure(String anameTreasure, String alinkTreasure, int apointsPlayer, double apositionInPixels,Level level, int resX, int resY){
        nameTreasure = anameTreasure;
        linkTreasure = alinkTreasure;
        pointsPlayer = apointsPlayer;
        this.level = level;
        Random random = new Random();
        positionX = random.nextInt(resX);
        positionY = random.nextInt(resY);
    }
    
    public String getNameTrea(){
        return nameTreasure;
    }

    public Level getTreasureLevel(){
        return level;
    }

    public void setNameTrea(String anameTreasure){
        nameTreasure = anameTreasure;
    }

    public String getImageURL(){
        return linkTreasure;
    }

    public void setImageLink(String alinkTreasure){
        linkTreasure = alinkTreasure;
    }

    public int getPointsPlayer(){
        return pointsPlayer;
    }
}
