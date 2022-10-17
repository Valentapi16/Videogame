package model;
import java.util.Random;

public class Enemy {
    public static final int SIZE_OF_ENEMIES = 25;
    private String enemyName;
    private int lessPointsPlayer;
    private int morePointsPlayer;
    private Level level;
    private String typeOfEnemy;
    private int positionX;
    private int positionY;

    public Enemy(String aenemyName, int alessPointsPlayer, int amorePointsPlayer, String atypeOfEnemy, Level level, int posX, int posY){
        enemyName =aenemyName;
        lessPointsPlayer = alessPointsPlayer;
        morePointsPlayer = amorePointsPlayer;
        typeOfEnemy = atypeOfEnemy;
        Random random = new Random();
        positionX = random.nextInt(posX);
        positionY = random.nextInt(posY);
    }

    public String getName(){
        return enemyName;
    }
    public Level getLevelEnemy(){
        return level;
    }

    public int getLessPointsPlayer(){
        return lessPointsPlayer;
    }

    public int getMorePointsPlayer(){
        return morePointsPlayer;
    }


    public String getTypeOfEnemy(){
        return typeOfEnemy;
    }

    public String addEnemy(Enemy newEnemy){
        return null;
    }
}
