package model;

public class Treasure {

    public static final int SIZE_OF_TREASURES= 50;
    private String nameTreasure;
    private String linkTreasure;
    private int pointsPlayer;
    private double positionInPixels;
    private int amountPerLevel;


    public Treasure(String anameTreasure, String alinkTreasure, int apointsPlayer, double apositionInPixels, int aamountPerLevel){
        nameTreasure = anameTreasure;
        linkTreasure = alinkTreasure;
        pointsPlayer = apointsPlayer;
        amountPerLevel = aamountPerLevel;
    }
    
    public String getNameTrea(){
        return nameTreasure;
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
