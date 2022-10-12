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
		System.out.println("<<<<< HI WELCOME TO THE GAME >>>>>");
		System.out.println(
				"1. Crear jugador\n" +
				"2. Registrar enemigo a un nivel \n"+
				"3. Registrar tesoro a un nivel \n"+
				"4. Modificar el puntaje de un jugador \n" +
				"5. Incremento de nivel \n" +
				"6. Cantidad de tesoros y enemigos en un nivel \n" +
				"7. Cantidad de tesoros en todos los niveles \n" +
				"8. Cantidad de un tipo de enemigo en todos los niveles \n" +
				"9. Tesoro más repetido \n" +
				"10.Enemigo que otorga mayor puntaje y su ubicacion \n" +
				"11.Cantidad de consonantes en el nombre del enemigo \n" +
				"12.Top 5 de jugadores \n" +
				"13. Registrar nivel.");
		option = reader.nextInt(); 

		return option; 
	}

	public void executeOption(int option){
		String nickname, name, msj, nameEnemy, levelId, typeOfEnemy, nameTreasure,linkImage = "";
		int morePointsPlayer, lessPointsPlayer, scoreRequired, amountPerLevel = 0;
		switch(option){
			case 1: 
			 System.out.println("For the new player we need the nickname \n" + "Remember that the nickname is unique");
			 nickname= reader.next();
			 System.out.println("Enter your name");
			 name= reader.next();	

			 msj = game.addPlayer(nickname, name);
			 System.out.println("\n"+msj); 

				break; 

			case 2: 
			System.out.println("Enter the name of the new enemy: ");
			nameEnemy = reader.next();
			System.out.println("Enter the number of level you want to allocate the enemy: ");
			levelId = reader.next();
			System.out.println("Enter the type of the enemy (Ogre, Abstract, Magic or boss): " );
			typeOfEnemy= reader.next();
			System.out.println("Enter the amount of score if the enemy win, the score that will lose the player: ");
			lessPointsPlayer = reader.nextInt();
			System.out.println("Enter the amount of score if is beaten, the score that will gain the player:");
			morePointsPlayer = reader.nextInt();
			
			String mssj = game.allocateEnemyToLevel(nameEnemy, levelId, typeOfEnemy, lessPointsPlayer, morePointsPlayer);
			System.out.println(mssj);
				break; 

			case 3:
			System.out.println("Enter the name of the new Treasure: ");
			nameTreasure = reader.next();
			System.out.println("Enter the number of level you want to allocate the treasure: ");
			levelId = reader.next();
			System.out.println("Enter the amount of score required for the treasure: " );
			scoreRequired= reader.nextInt();
			System.out.println("Enter the URL of the image according of the treasure you want ");
			linkImage = reader.next();
			System.out.println("Enter the amount of treasures you want in this level: ");
			amountPerLevel= reader.nextInt(); 

			msj = game.allocateTreasureToLevel(nameTreasure, levelId, scoreRequired, linkImage, amountPerLevel);
			System.out.println(msj);
				
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