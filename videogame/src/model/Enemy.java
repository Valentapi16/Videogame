package model;
import java.util.Random;

public class Enemy {
    public static final int SIZE_OF_ENEMIES = 25;
    private String enemyName;
    private int lessPointsPlayer;
    private int morePointsPlayer;
    private TypeOfEnemy typeOfEnemy;
    private Level level;
    private int positionX;
    private int positionY;

    public Enemy(String enemyName,int typeOfEnemy, int lessPointsPlayer, int morePointsPlayer, Level level, int posX, int posY){
        this.enemyName = enemyName;
        this.lessPointsPlayer = lessPointsPlayer;
        this.morePointsPlayer = morePointsPlayer;
        this.level= level;
        Random random = new Random();
        positionX = random.nextInt(posX);
        positionY = random.nextInt(posY);

        switch(typeOfEnemy){
            case 1:
                this.typeOfEnemy = TypeOfEnemy.OGRE;
                break;

            case 2:
                this.typeOfEnemy = TypeOfEnemy.ABSTRACT;
                break;

            case 3:
                this.typeOfEnemy = TypeOfEnemy.BOSS;
                break;

            case 4:
                this.typeOfEnemy = TypeOfEnemy.MAGIC;
                break;         
        }
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
    public int getType(){
        switch(typeOfEnemy){
            case OGRE:
                return 1;

            case ABSTRACT:
                return 2;
            
            case BOSS:
                return 3;
            
            case MAGIC:
                return 4;
        
            default:
                return 0;
        }
    }
    public String addEnemy(Enemy newEnemy){
        return null;
    }
}
