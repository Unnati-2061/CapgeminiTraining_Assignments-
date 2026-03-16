package com.dice.game;

import java.util.Random;
import java.util.Scanner;

class Player {
	private String name;
	
	Player(String name) {
		this.name = name;
	}
	
	public String getName() { return name; }
	
	public int rollDice() {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		Random rand = new Random();
		
		int min = 1;
		int max = 6;
		int n = rand.nextInt(max - min + 1) + min;
		
		return n;
	}
}

public class DiceGame {
	public static void main(String[] args) {
		gameloop();
		System.out.println("GAME OVER!");
		sc.close();
	}
	
	private static void gameloop() {
		playGame = true;
		
		while(playGame) {
			turn = 0;
			int currentMax = 0;
			int winningPlayerIdx = 0;

			while (turn < players.length) {
				Player player = players[turn];
				System.out.print(player.getName() + " is rolling dice (Press Enter to roll)");
				int playerValue = player.rollDice();
				System.out.println("Dice: " + playerValue);
				
				if (playerValue > currentMax) {
					currentMax = playerValue;
					winningPlayerIdx = turn;
				}

				turn++;
			}

			Player winningPlayer = players[winningPlayerIdx];
			System.out.println("Winner: " + winningPlayer.getName());
			
			System.out.print("\nWanna Play Again (y/n): ");
			char choice = sc.next().charAt(0);
			if (choice == 'n' || choice == 'N')
				playGame = false;
		}
	}
	
	private static int turn = 0;
	private static boolean playGame = false;
	private static Scanner sc = new Scanner(System.in);
	
	private static Player []players = {
		new Player("Devansh Seth"),
		new Player("Vedansh Seth"),
		new Player("Mansi Sharma")
	};
}
