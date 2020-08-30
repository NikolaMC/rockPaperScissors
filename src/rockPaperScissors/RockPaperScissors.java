package rockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		Scanner menuChoice = new Scanner(System.in); // Pick between playing against player or computer
		System.out.println("Would you like to play against a player or the computer? ");
		System.out.println("1. Player");
		System.out.println("2. Computer");
		String menuChoiceInput = menuChoice.nextLine();
		
		if(menuChoiceInput.equals("1") || menuChoiceInput.equalsIgnoreCase("player")) { // If against a player
			Scanner player1NameInput = new Scanner(System.in);
			Scanner player2NameInput = new Scanner(System.in);
			
			System.out.print("Player 1 name: ");
			String player1Name = player1NameInput.nextLine();
			
			System.out.print("Player 2 name: ");
			String player2Name = player2NameInput.nextLine();
			
			Scanner player1PlayInput = new Scanner(System.in);
			Scanner player2PlayInput = new Scanner(System.in);
			
			while(true) { // Keep playing until a player chooses "exit"
				System.out.println();
				System.out.println(player1Name + ", choose one:");
				System.out.println("1. Rock");
				System.out.println("2. Paper");
				System.out.println("3. Scissors");
				System.out.println("4. Exit");				
				String player1Play = player1PlayInput.nextLine().toLowerCase();
				
				if(player1Play.equals("4") || player1Play.equals("exit")) {
					break;
				}
				
				System.out.println();
				System.out.println(player2Name + ", choose one:");
				System.out.println("1. Rock");
				System.out.println("2. Paper");
				System.out.println("3. Scissors");
				System.out.println("4. Exit");
				String player2Play = player2PlayInput.nextLine().toLowerCase();
				
				if(player2Play.equals("4") || player2Play.equals("exit")) {
					break;
				}
				
				compareInput(player1Name, player2Name, player1Play, player2Play); // Compare the play choices and determine the winner or if it's a tie
			}
			
			player1NameInput.close();
			player2NameInput.close();
			player1PlayInput.close();
			player2PlayInput.close();
		}
		
		if(menuChoiceInput.equals("2") || menuChoiceInput.equalsIgnoreCase("computer")) { // If against computer
			Scanner player1NameInput = new Scanner(System.in);
			
			System.out.print("Player 1 name: ");
			String player1Name = player1NameInput.nextLine();
			String player2Name = "Computer";
			
			Scanner player1PlayInput = new Scanner(System.in);
			
			while(true) { // Keep playing until a player chooses "exit"
				System.out.println();
				System.out.println(player1Name + ", choose one:");
				System.out.println("1. Rock");
				System.out.println("2. Paper");
				System.out.println("3. Scissors");
				System.out.println("4. Exit");				
				String player1Play = player1PlayInput.nextLine().toLowerCase();
				
				if(player1Play.equals("4") || player1Play.equals("exit")) {
					break;
				}
				
				String player2Play = computerPlay(); // Generate the computer's play choice
				
				System.out.println("Computer chose: " + player2Play);
				
				compareInput(player1Name, player2Name, player1Play, player2Play); // Compare the play choices and determine the winner or if it's a tie
			}
			
			player1NameInput.close();
			player1PlayInput.close();
		}
		
		menuChoice.close();
		
	}
	
	static void compareInput(String player1Name, String player2Name, String player1Input, String player2Input) { // Method that compares play choices to determine the winner or if it's a tie
		
		switch(player1Input) { // Convert player1's input to a number if a word was written
		case "rock":
			player1Input = "1";
			break;
		case "paper":
			player1Input = "2";
			break;
		case "scissors":
			player1Input = "3";
			break;
		}
		
		switch(player2Input) { // Convert player1's input to a number if a word was written
		case "rock":
			player2Input = "1";
			break;
		case "paper":
			player2Input = "2";
			break;
		case "scissors":
			player2Input = "3";
			break;
		}
		
		if(player1Input.equals(player2Input)) { // Compare play choices and see who wins, or if it's a tie
			System.out.println("It's a tie!");
		} else if(player1Input.equals("1") && player2Input.equals("2")) { // Rock/paper. Player 2 wins
			System.out.println(player2Name + " wins!");
		} else if(player1Input.equals("1") && player2Input.equals("3")) { // Rock/scissors. Player 1 wins
			System.out.println(player1Name + " wins!");
		} else if(player1Input.equals("2") && player2Input.equals("1")) { // Paper/rock. Player 1 wins
			System.out.println(player1Name + " wins!");
		} else if(player1Input.equals("2") && player2Input.equals("3")) { // Paper/scissors. Player 2 wins
			System.out.println(player2Name + " wins!");
		} else if(player1Input.equals("3") && player2Input.equals("2")) { // Scissors/paper. Player 1 wins
			System.out.println(player1Name + " wins!");
		} else if(player1Input.equals("3") && player2Input.equals("1")) { // Scissors/rock. Player 2 wins
			System.out.println(player2Name + " wins!");
		}
		
	}
	
	static String computerPlay() { // Generate computer play choice
		Random rand = new Random();
		int randomGenerator = rand.nextInt(3); // Generate a number between 0-2
		randomGenerator += 1; // Increase the generated number by 1
		
		String playChoice = null;
		
		switch(randomGenerator) { // Convert the number to a string
			case 1:
				playChoice = "rock";
				break;
			case 2:
				playChoice = "paper";
				break;
			case 3:
				playChoice = "scissors";
				break;
		}
		
		return playChoice; // Return the generated result
	}

}
