package model;

public class Player {
    public static final int SIZE_OF_PLAYERS= 20;
    private String nickNamePlayer;
    private String name;
    private int scoreInitial;
    private Level currentLevel;
 

    private Player player;


    public Player(String nicknamePlayer, String name, Level currentlevel){
        this.nickNamePlayer = nicknamePlayer;
        this.name = name;
        this.currentLevel = currentlevel;
        scoreInitial = 10;
    }

    public String getName(){
        return name;
    }

    public String getNicknamePlayer(){
        return nickNamePlayer;
    }

    public int getScore(){
        return scoreInitial;
    }

    public void setNickname(String anicknameplayer){
        nickNamePlayer = anicknameplayer;
    }

    public void setInitialScore(int scoreInitial){
        this.scoreInitial= scoreInitial;
    }
    
    public Level getLevel(){
        return currentLevel;
    }

    public void setLevel(Level level){
        this.currentLevel= level;
    }

}
