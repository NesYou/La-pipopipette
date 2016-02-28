package vs;

import java.awt.Event;
import java.util.Scanner;

public class Jeu {

	//Un Scanner pour les int
		static Scanner sc = new Scanner(System.in);
		//Un Scanner pour les String
		static Scanner scA = new Scanner(System.in);

		public static void main(String [] args) {
			boolean bord;
			int joueurJouant = 1;
			Joueur joueur1=new Joueur(1);
			Joueur joueur2=new Joueur(2);
			int nbLignes = 0;
			int nbColonnes = 0;
		
			System.out.println("Creation du plateau.");
			System.out.print("Nombre de lignes: ");

			//Boucle tant que l'utilisateur ne saisit pas un nombre correct de lignes.
			while(!sc.hasNextInt()) {
				System.out.print("Saisir un nombre correct: ");
				sc.next();
			}
			nbLignes = sc.nextInt();
			System.out.println();

			System.out.print("Nombre de colonnes: ");

			//Boucle tant que l'utilisateur ne saisit pas un nombre correct de colonnes.
			while(!sc.hasNextInt()) {
				System.out.print("Saisir un nombre correct: ");
				sc.next();
			}
			nbColonnes = sc.nextInt();
			System.out.println();

			System.out.print("Souhaitez vous un plateau avec bord ? (o/n): ");
			String choix = scA.nextLine();
			System.out.println();
			if(choix.equalsIgnoreCase("o")) 
				bord = true;
			else 
				bord = false;

			//Initialisation d'un plateau avec les donnees saisies au prealable.
			Plateau p = new Plateau(nbLignes, nbColonnes, bord);
			
			
			/*
			 * GAME START 
			 */
			int mouvement ;
			int nbCarre;
			int repeat;
			System.out.println("Début de la partie.");

			System.out.println(p.toString()+"\n");
			System.out.println(joueur1.toString());
			System.out.println(joueur2.toString());
			
			do{
				System.out.println((char)Event.ESCAPE + "7"+"\n");
				//On enregistre la position initial du curseur. On remonte ici (*).

				System.out.println("Tour du joueur "+joueurJouant+": ");
				
				while(!sc.hasNextInt()) {
					System.out.print("Saisir un nombre correct: ");
					sc.next();
				}
				mouvement = sc.nextInt();
				nbCarre=p.carre();
				repeat=0;
				try{			
					p.ajouterTrait(mouvement);
				}catch (DejaPresentException e){
					System.out.println(e.getMessage());
					repeat=joueurJouant;
				}
				
				if(p.carre()==nbCarre){
					if(joueurJouant==1)
						joueurJouant=2;
					else
						joueurJouant=1;

				}else{
					if(joueurJouant==1){
						joueur1.ajoutPoints(p.carre()-nbCarre);
						joueurJouant=1;
						p.carre();
					}else{
						joueur2.ajoutPoints(p.carre()-nbCarre);
						joueurJouant=2;
						p.carre();
					}
				}
				
				if(repeat !=0){
					joueurJouant=repeat;
				}

				System.out.println(p.toString()+"\n");
				System.out.println(joueur1.toString());
				System.out.println(joueur2.toString());
				
			}while(p.partieContinue());
			
			System.out.println(p.toString()+"\n");
			System.out.println(" ----------------------------------------e\n");
			System.out.println(joueur1.toString());
			System.out.println(joueur2.toString());
			System.out.println("\n ---------------------------------------\n");
			System.out.println((joueur1.getNbPoints()>joueur2.getNbPoints()?joueur1:joueur2)
									+" a gagné !!");
			
			//On reinitialise le curseur. On remonte a (*).
			System.out.print((char)Event.ESCAPE + "8");
		}
	

}