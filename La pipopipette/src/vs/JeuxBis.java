package vs;

import java.util.Scanner;

import java.util.List;

public class JeuxBis {
	
	public static void main(String[] args) {
		System.out.println("Vous affrontez le joueur simplet!");
		boolean bord;
		int nbLignes = 0;
		int nbColonnes = 0;
		int dernierJoueur = 0;
		boolean repeat = false;
		int nbPointJoueur = 0;
		int nbPointBot = 0;
		List<Integer> l;
		
		Scanner sc = new Scanner(System.in);
		Scanner sl = new Scanner(System.in);
		
		
		
	
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
		String choix = sl.nextLine();
		System.out.println();
		if(choix.equalsIgnoreCase("o")) 
			bord = true;
		else 
			bord = false;
		
		

		//Initialisation d'un plateau avec les donnees saisies au prealable.
		Plateau p = new Plateau(nbLignes, nbColonnes, bord);
		int nbCarre = p.carre();
		int cpt = 0;
		
				
		while(p.partieContinue()) {
			cpt ++;
			System.out.println("Tour: "+cpt);
			System.out.println(p.toString());
			System.out.println("Nb carres: "+p.carre());
			System.out.println(Long.toBinaryString(p.getBoard()));
			if(repeat && !p.partieContinue()) {
				if(dernierJoueur == 0) {
					System.out.println("Tours du joueur, nbPoint: "+nbPointJoueur);
					System.out.println("Mouvement: ");
					int mouvement = sc.nextInt();
					try {
						p.ajouterTrait(mouvement);
					} catch (DejaPresentException e) {
						System.out.println(e.getMessage());
					}
					if(nbCarre != p.carre()) {
						nbCarre = p.carre();
						nbPointJoueur ++;
						repeat = true;
						
					}
					else {
						repeat = false;
						dernierJoueur = 1;
					}
				}
				else if (dernierJoueur == 1){
					System.out.println("Tour du joueur simplet, nbPoint: "+nbPointBot);
					l = p.mouvementsPossibles();
					try {
						int mouvement = l.get((int) (Math.random() * (l.size() - 0)));
						System.out.println("Simplet tente de jouer: "+mouvement);
						System.out.println("Coups possibles: "+l.toString());
						p.ajouterTrait(mouvement);
					} catch (DejaPresentException e) {
						System.out.println(e.getMessage());
					}
					if(nbCarre != p.carre()) {
						nbCarre = p.carre();
						nbPointBot ++;
						repeat = true;
					}
					else {
						repeat = false;
						dernierJoueur = 0;
					}
				}
			}
			else {
				if(dernierJoueur == 0) {
					System.out.println("Tours du joueur, nbPoint: "+nbPointJoueur);
					System.out.println("Mouvement: ");
					int mouvement = sc.nextInt();
					try {
						p.ajouterTrait(mouvement);
					} catch (DejaPresentException e) {
						System.out.println(e.getMessage());
					}
					if(nbCarre != p.carre()) {
						nbCarre = p.carre();
						nbPointJoueur ++;
						repeat = true;
						
					}
					else {
						repeat = false;
						dernierJoueur = 1;
					}
				}
				else {
					System.out.println("Tour du joueur simplet, nbPoint: "+nbPointBot);
					l = p.mouvementsPossibles();
					try {
						int mouvement = l.get((int) (Math.random() * (l.size() - 0)));
						System.out.println("Simplet tente de jouer: "+mouvement);
						System.out.println("Coups possibles: "+l.toString());
						p.ajouterTrait(mouvement);
					} catch (DejaPresentException e) {
						System.out.println(e.getMessage());
					}
					if(nbCarre != p.carre()) {
						nbCarre = p.carre();
						nbPointBot ++;
						repeat = true;
						
					}
					else {
						repeat = false;
						dernierJoueur = 0;
					}
				}
			}			
		}
		sc.close();
		sl.close();
	}
}