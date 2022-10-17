package model;

public class Player {
    public static final int SIZE_OF_PLAYERS= 20;
    private String nickNamePlayer;
    private String name;
    private int scoreInitial;
    private int amountOfLifes;
    private Level currentLevel;
    private String scoreToNextLevel;

    private String[] nickNamePlayers= new String[SIZE_OF_PLAYERS];

    private Player player;


    public Player(String nicknamePlayer, String name,int ascoreInitial, int aamountOfLifes, String ascoreToNextLevel){
        this.nickNamePlayer = nicknamePlayer;
        this.name = name;
        scoreInitial = ascoreInitial;
        amountOfLifes = aamountOfLifes;
        scoreToNextLevel = ascoreToNextLevel;

    }

    public String getName(){
        return name;
    }

    public String getNicknamePlayer(){
        return nickNamePlayer;
    }

    public String[] getNicknamePlayers(){
        return nickNamePlayers;
    }
    public int getScore(){
        return scoreInitial;
    }

    public void setNickname(String anicknameplayer){
        nickNamePlayer = anicknameplayer;
    }

    public int setInitialScore(int ascoreInitial){
        scoreInitial= 10;
        return scoreInitial;
    }
    public int setAmountOfLifes(){
        amountOfLifes= 5;
        return amountOfLifes;
    }
    
    public Level getLevel(){
        return currentLevel;
    }

    public void setLevel(Level level){
        this.currentLevel= level;
    }

    public String getScoreToNextLevel(){
        return scoreToNextLevel;
    }
}
