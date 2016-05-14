package game;


public class Main {
	
	public static void arguments(String[] args) {
		if(args[0].equals("-name")) {
			System.out.println("--------------------- Equipe de developpement ---------------------\n");
			System.out.println("COLLET Elsa - Chef de projet - elsa.collet@etu.univ-orleans.fr");
			System.out.println("BOUAYADINE Younes - Developpeur - younes.bouayadine@etu.univ-orleans.fr");
			System.out.println("MOUSSI Cedric - Developpeur - cedric.moussi@etu.univ-orleans.fr");
			System.out.println("PALOS Killian - Developpeur - killian.palos@etu.univ-orleans.fr");
		}
		
		else if (args[0].equals("-h")) {
			System.out.println("--------------------- Liste des commandes disponibles ---------------------\n");
			System.out.println("-name ");
			System.out.println("\t Affiche les informations sur l'equipe de developpement\n");
			
			System.out.println("-h");
			System.out.println("\t Affiche la liste des commandes disponibles\n");
			
			System.out.println("-graphe type nbLignes nbColonnes ");
			System.out.println("\t Renvoie le graphe des configurations au format dot.\n");
			
			System.out.println("-joue joueur strategie");
			System.out.println("\t Offre la possibilité de jouer sur la console de manière interactive." );
			System.out.println("\t Le paramètre joueur vaut soit 1 ou 2 : ");
			System.out.println("\t \t - 1 indique que l’humain commence. \n \t \t - 2 Indique que l’ordinateur commence.\n");
			
			System.out.println("-cal strategie");
			System.out.println("\t Calcule une stratégie optimum face un joueur suivant la stratégie passée en paramètre. \n \t La commande renvoie le résultat le graphe réduit au format dot et la pondération des configurations définissant la stratégie calculée.\n");
			
			System.out.println("-apprend N alpha gready strategie");
			System.out.println("\t Calcule une stratégie par une méthode d’apprentissage en faisant en sorte que l’apprenti et le stratège commence chacun leur tour.");
			System.out.println("\t Les paramètres de l’apprentissage sont :"); 
			System.out.println("\t \t - N est le nombre de parties");
			System.out.println("\t \t - alpha est le taux d’apprentissage (compris entre 0 et 1)");
			System.out.println("\t \t - gready vaut 1 si la technique du epsilon-gready est utilisé sinon il vaut 1.\n");
			
			 System.out.println("-eval strategie strategie");
			 System.out.println("\t Evalue les deux stratégies en paramètre de manière exacte en faisant commencer la première stratégie passée en paramètre et renvoie le nombre moyen de carrés complétés par la première stratégie.\n");
			 
			 System.out.println("-simul N strategie strategie");
			 System.out.println("\t Evalue les deux stratégies en paramètre par simulation en lançant N parties en faisant commencer la première stratégie passée en paramètre et renvoie le nombre moyen de carrés complétés par la première stratégie.\n");
		}
		
		else if (args[0].equals("-graphe")) {
			int type = Integer.parseInt(args[1]);
			int nbLignes = Integer.parseInt(args[2]);
			int nbColonnes = Integer.parseInt(args[3]);
			System.out.println("Renvoie le graphe des configurations au format dot. type = "+type+", nbLignes = "+nbLignes+", nbColonnes = "+nbColonnes);
		}
		
		else if (args[0].equals("-joue")) {
			int joueur = Integer.parseInt(args[1]);
			String strategie = args[2];
			System.out.println("Mode interactif. Strategie: "+strategie+". "+((joueur == 1) ? "Le joueur" : "L'ordinateur")+ " commence." );
		}
		
		else if (args[0].equals("-cal")) {
			String strategie = args[1];
			System.out.println("Calcul de la strategie "+strategie+".");
		}
		
		else if (args[0].equals("-apprend")) {
			int n = Integer.parseInt(args[1]);
			int alpha = Integer.parseInt(args[2]);
			int gready = Integer.parseInt(args[3]);
			String strategie = args[4];
			System.out.println(strategie+ ". Sur "+n+" parties."+". Parametres alpha = "+alpha+" et gready = "+gready+".");
		}
		
		else if (args[0].equals("-eval")) {
			String strategie1 = args[1];
			String strategie2 = args[2];
			System.out.println("Evaluation des strategies "+strategie1+" et "+strategie2+".");
		}
		
		else if (args[0].equals("-simul")) {
			int n = Integer.parseInt(args[1]);
			String strategie1 = args[2];
			String strategie2 = args[3];
			System.out.println("Simulation des strategies "+strategie1+" et "+strategie2+". Sur "+n+" parties.");
		}
	}
	
	public static void main (String [] args) {
		arguments(args);
	}

}
