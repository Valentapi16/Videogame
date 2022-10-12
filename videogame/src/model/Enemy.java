package model;

public class Enemy {
    public static final int SIZE_OF_ENEMIES = 25;
    private String enemyName;
    private int lessPointsPlayer;
    private int morePointsPlayer;
    private double randomPixelPosition;
    private String typeOfEnemy;

    public Enemy(String aenemyName, int alessPointsPlayer, int amorePointsPlayer, String atypeOfEnemy){
        enemyName =aenemyName;
        lessPointsPlayer = alessPointsPlayer;
        morePointsPlayer = amorePointsPlayer;
        typeOfEnemy = atypeOfEnemy;
    }

    public String getName(){
        return enemyName;
    }

    public int getLessPointsPlayer(){
        return lessPointsPlayer;
    }

    public int getMorePointsPlayer(){
        return morePointsPlayer;
    }

    public double getRandomPixelPosition(){
        return randomPixelPosition;
    }

    public String getTypeOfEnemy(){
        return typeOfEnemy;
    }

    public String addEnemy(Enemy newEnemy){
        return null;
    }
}
