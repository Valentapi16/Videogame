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
				"9.Most repeated treasure \n" +
				"10.Highest-scoring enemy and its location  \n" +
				"11.Number of consonants in the enemy's name \n" +
				"12.Top 5 players \n " +
				"0.Exit. \n");
		option = validateIntegerOption(); 

		return option; 
	}

	public void executeOption(int option){
		String nickname, name, enemyName, levelId, typeOfEnemy, nameTreasure,linkImage, linkTreasure = "";
		int morePointsPlayer, lessPointsPlayer, scoreRequired, amountPerLevel, pointsToPlayer = 0;
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
	
					System.out.print("Enter the number of points that will be awarded if the enemy wins: ");
					lessPointsPlayer = reader.nextInt();
					System.out.print("Enter the number of points that will be awarded if the enemy is defeated: ");
					morePointsPlayer = reader.nextInt();
					System.out.print("Enter the type of the enemy:Ogre,Abstract,Boss,Magic");
					typeOfEnemy = reader.next();
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
				System.out.println("Enter the name of the Treasure: ");
				nameTreasure = reader.next();
				System.out.print("Enter the URl of the image according to the treasure: ");
				linkTreasure = reader.nextLine();
				System.out.print("Enter the amount of points that will give to the player if it is found: ");
				pointsToPlayer = reader.nextInt();
				System.out.println("To which level will this treasure belong");
				int level = reader.nextInt();
				if(level > 10 || level < 1){
					System.out.println("Nivel no valido");
				}
				System.out.print(game.createTreasure(nameTreasure, linkTreasure, pointsToPlayer, level));
			}
				
				break; 

			case 4: 
				
				break; 

			case 5: 
				
				break; 
			case 6:
			
			    break;

			case 7:	

			    break;
			case 8:	

			    break;
			case 9: 
				
				break; 

			case 10: 
				
				break; 
			case 11:
			
			    break;
			case 12: 
				
				break; 
			case 13:
			
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