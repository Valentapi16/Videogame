package ui; 

import java.util.Scanner;
import model.Game;


public class Main{

	private Scanner reader; 
	private Game game;


	public Main(){
		reader = new Scanner(System.in); 
		game = new Game();
	}

	public Game getGame(){
		return game;
	}

	public Scanner getReader(){
		return reader;
	}

	public static void main(String[] args){
		Main main = new Main(); 
		int option = 0; 
				do{
					option = main.getOptionShowMenu(); 
					main.executeOption(option);

				}while(option != 0);

				main.getReader().close();
	}
	/**
	* getOptionShowMenu: This method will show the menu
	* @return the message displaying will return an option when the user choose one
	*/
	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println("<<<<< HI, WELCOME TO THE GAME >>>>>");
		System.out.println(
				"1. Create player \n" +
				"2. Register enemy to one level \n"+
				"3. Register treasure to one level \n"+
				"4. Modified score player \n" +
				"5. Upgrade level \n" +
				"6. Number of treasures and enemies in a level \n" +
				"7. Number of treasures at all levels \n" +
				"8. Number of one type of enemy at all levels \n" +
				"9. Most repeated treasure \n" +
				"10.Highest-scoring enemy and its location  \n" +
				"11.Number of consonants in the enemy's name \n" +
				"12.Top 5 players \n " +
				"0. Exit. \n");
		option = validateIntegerOption(); 

		return option; 
	}

	public void executeOption(int option){
		String nickname, name, enemyName, nameTreasure, linkTreasure = "";
		int morePointsPlayer, lessPointsPlayer,typeOfEnemy,pointsToPlayer, amountOfTreasures = 0;
		switch(option){
			case 1: 
			if(game.thereIsASpaceForPlayer().equals("The player limit was filled")){
				System.out.println(game.thereIsASpaceForPlayer());
				
			}else{
				reader.nextLine();
				System.out.print("Give me the nickname of the player: ");
				nickname = reader.nextLine();
				if(game.lookForPlayer(nickname) != null){
					
					System.out.println("This nickname is already taken");

				}else{
					System.out.print("Enter the name of the player: ");
					name = reader.nextLine();
					System.out.println(game.createPlayer(nickname, name));
				}
			}
				break; 

			case 2: 
			if(game.spaceForEnemies().equals("The enemies limit was filled")){
				System.out.println(game.spaceForEnemies());
			}else{
				reader.nextLine();
				System.out.println("Enter the name of the enemy ");
				enemyName = reader.next();
				if(game.lookForEnemy(enemyName) != null){
					System.out.println("Error, este enemigos ya existe");
				}else{
	
					System.out.print("Enter the number of points that will loose if the enemy wins: ");
					lessPointsPlayer = reader.nextInt();
					System.out.print("Enter the number of points that will be awarded if the enemy is defeated: ");
					morePointsPlayer = reader.nextInt();
					System.out.print("Dime de que tipo es este enemigo\n"+
					"\n1. Ogro"+
					"\n2. Abstracto"+
					"\n3. Jefe"+
					"\n4. Magico"+
					"\nOpcion: ");
					typeOfEnemy = reader.nextInt();
					System.out.print("To which level will this enemy belong: ");
					int level = reader.nextInt();
					if(level > 10 || level < 1){
						System.out.println("Level not available");
					}else{
						System.out.println(game.createEnemy(enemyName,morePointsPlayer, lessPointsPlayer,typeOfEnemy,level));
					}

				}
			}
				break; 

			case 3:

			if(game.spaceForTreasures().equals("The treasure limit was filled")){
				System.out.println(game.spaceForTreasures());
			}else{
				reader.next();
				System.out.println("How many treasures you want to register: ");
				amountOfTreasures = reader.nextInt();
				System.out.println("Enter the name of the Treasure: ");
				nameTreasure = reader.next();
				System.out.print("Enter the URl of the image according to the treasure: ");
				linkTreasure = reader.next();
				System.out.print("Enter the amount of points that will give to the player if it is found: ");
				pointsToPlayer = reader.nextInt();
				System.out.println("To which level will this treasure belong");
				int level = reader.nextInt();
				if(level > 10 || level < 1){
					System.out.println("No valid level");
				}
				System.out.print(game.createTreasure(nameTreasure, linkTreasure, pointsToPlayer, level));
			}
				break; 

			case 4: 
			if(game.thereIsASpaceForPlayer().equals("There are no players in the game ")){
				System.out.println(game.thereIsASpaceForPlayer());
			
			}else{
				reader.next();
				System.out.print("Which is the nickname of the player: ");
				String nickName = reader.next();
				if(game.lookForPlayer(nickName) == null){
						
					System.out.println("Sorry but that nickname doesnt exists");

				}else{
					System.out.print("Enter the new player's score: ");

					System.out.println(game.modifiedScorePlayer(reader.nextInt(),nickName));
				}
			}
				break; 

			case 5: 
			if(game.thereIsASpaceForPlayer().equals("There are no players in the game ")){
				System.out.println(game.thereIsASpaceForPlayer());
			}else{
				reader.next();
				System.out.print("Which is the nickname of the player : ");
				String nickName = reader.next();
				if(game.lookForPlayer(nickName) == null){
						
					System.out.println("Sorry, but that nickname doesnt exists");

				}else{
					System.out.println(game.upgradeLevelPlayer(nickName));
				}
			}
				
				break; 
			case 6:
			if(game.spaceForTreasures().equals("There are no treasures")){
				System.out.println(game.spaceForTreasures());
			}else{
				System.out.println("Type the number of the level you wish to consult");
				int level = reader.nextInt();
				System.out.println(game.theTreasures(level));
			}
			if(game.spaceForEnemies().equals("There are no enemies ")){
				System.out.println(game.spaceForEnemies());
			}else{
				System.out.println("Type the number of the level you wish to consult");
				int level = reader.nextInt();
				System.out.println(game.theEnemies(level));
			}
			    break;
			case 7:

			if(game.spaceForTreasures().equals("There are no treasures")){
				System.out.println(game.spaceForTreasures());
			}else{
				System.out.println("Type the name of the treasure you wish to consult");
				reader.nextLine();
				System.out.println(game.allTreasuresAlongTheGame(reader.next()));
			}	

			    break;
			case 8:	
			if(game.spaceForEnemies().equals("There are no enemies ")){
				System.out.println(game.spaceForEnemies());
			}else{

				System.out.print("\nWich enemy do you want to know"+
				"\n1.Ogre"+
				"\n2.Abstract"+
				"\n3.Boss"+
				"\n4.Magic"+
				"\nOpcion: ");
				int type = reader.nextInt();
				if(type > 4 || type < 1){
					System.out.println("Invalid Option");
				}else{
					System.out.println(game.enemiesType(type));
				}
			}

			    break;
			case 9: 
			if(game.spaceForTreasures().equals("No hay tesoros")){
				System.out.println(game.spaceForTreasures());
			}else{
				System.out.println(game.amountOfTreasures());
			}
				
				break; 

			case 10: 
				
				break; 
			case 11:
			System.out.println("Enter the name of the Enemy:");
			enemyName = reader.next();

			System.out.println(game.consonantsEnemyName());
			
			    break;
			case 12: 
			System.out.println(game.topFivePlayers());
				
				break; 

			case 0: 
				System.out.println("Exit program.");
				break; 

			default: 
				System.out.println("Invalid Option");
				break; 
		}
	}

	public int validateIntegerOption(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}




}