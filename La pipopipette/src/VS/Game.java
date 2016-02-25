package VS;

/**
 * Cette classe permet l'initialiation et le lancement d'une partie d'un joueur contre un autre
 * @author younes
 *
 */

import java.util.Scanner;
import java.awt.Event;

public class Game {
	
	public static void tableauBidon(int nbLignes, int nbColonnes) {
		int[][] tab = new int[nbLignes][nbColonnes];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				tab[i][j] = (int) (0 + Math.random() * 12);
				System.out.print(tab[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//Un Scanner pour les int
	static Scanner sc = new Scanner(System.in);
	//Un Scanner pour les String
	static Scanner scA = new Scanner(System.in);
	
	public static void main(String [] args) {
		boolean bord;
		boolean continuerPartie = true;
		String joueurJouant = "";
		int tour = 1;
		int nbLignes = 0;
		int nbColonnes = 0;
	
		System.out.println("Creation du plateau.");
		System.out.print("Nombre de lignes: ");
		
		//Boucle tant que l'utilisateur ne saisit pas un nombre correct de lignes
		while(!sc.hasNextInt()) {
			System.out.print("Saisir un nombre correct: ");
			sc.next();
		}
		nbLignes = sc.nextInt();
		System.out.println();
		
		System.out.print("Nombre de colonnes: ");
		
		//Boucle tant que l'utilisateur ne saisit pas un nombre correct de colonnes
		while(!sc.hasNextInt()) {
			System.out.print("Saisir un nombre correct: ");
			sc.next();
		}
		nbColonnes = sc.nextInt();
		System.out.println();
		
		System.out.println("Souhaitez vous un plateau avec bord ? (o/n): ");
		String choix = scA.nextLine();
		if(choix.equals("o")) bord = true;
		else bord = false;
		
		Plateau p = new Plateau(nbLignes, nbColonnes, bord);
		
		System.out.println("Début de la partie.");
		while(continuerPartie) {
			/*if(p.partieTerminee()) {
				return;
			}*/
			System.out.print((char)Event.ESCAPE + "7");
			System.out.println();
			tableauBidon(nbLignes, nbColonnes);
			System.out.println();
			if(tour % 2 !=0) {
				joueurJouant = "Joueur A";
			} else {
				joueurJouant = "Joueur B";
			}
			System.out.println("Tours du "+joueurJouant+": ");
			int mouvement = sc.nextInt();
			//p.ajouterTrait(mouvement);
			tour++;
			System.out.print((char)Event.ESCAPE + "8");
		}
		
	}
	
}