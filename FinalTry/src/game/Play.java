package game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import graph.*;
import state.*;


public class Play {

	//Un Scanner pour les int
	static Scanner sc = new Scanner(System.in);
	//Un Scanner pour les String
	static Scanner scA = new Scanner(System.in);

	public static void main(String [] args) {
		boolean border;
		State root;
		int currentPlayer = 1;
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		int rows = 0;
		int cols = 0;

		System.out.println("Creation du plateau.");
		System.out.print("Nombre de lignes: ");

		//Boucle tant que l'utilisateur ne saisit pas un nombre correct de lignes.
		while(!sc.hasNextInt()) {
			System.out.print("Saisir un nombre correct: ");
			sc.next();
		}
		rows = sc.nextInt();
		System.out.println();

		System.out.print("Nombre de colonnes: ");

		//Boucle tant que l'utilisateur ne saisit pas un nombre correct de colonnes.
		while(!sc.hasNextInt()) {
			System.out.print("Saisir un nombre correct: ");
			sc.next();
		}
		cols = sc.nextInt();
		System.out.println();

		System.out.print("Souhaitez vous un plateau avec bord ? (o/n): ");
		String choix = scA.nextLine();
		System.out.println();
		if(choix.equalsIgnoreCase("o")) 
			border = true;
		else 
			border = false;

		//Initialisation d'un plateau avec les donnees saisies au prealable.
		DefaultSettings param=new DefaultSettings(rows, cols, border);
		root = new State();
		State s = new State();
		
		
		
		

		ToDot g = new ToDot();
	}
}
