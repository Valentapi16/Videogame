package model;

public class Player {
    public static final int SIZE_OF_PLAYERS= 20;
    private String nickNamePlayer;
    private String name;
    private int scoreInitial;
    private int amountOfLifes;
    private String currentLevel;
    private String scoreToNextLevel;

    private String[] nickNamePlayers= new String[SIZE_OF_PLAYERS];

    private Player player;


    public Player(String anicknamePlayer, String aname,int ascoreInitial, int aamountOfLifes, String acurrentLevel, String ascoreToNextLevel){
        nickNamePlayer = anicknamePlayer;
        name = aname;
        scoreInitial = ascoreInitial;
        amountOfLifes = aamountOfLifes;
        currentLevel = acurrentLevel;
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

    public String setCurrentLevel(){
        currentLevel= "1";
        return currentLevel;
    }

    public String getScoreToNextLevel(){
        return scoreToNextLevel;
    }
}
