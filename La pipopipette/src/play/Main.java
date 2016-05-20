package play;

import java.util.HashSet;

import settings.DefaultSettings;
import strategy.FarSighted;
import strategy.Idiot;
import strategy.Simple;
import strategy.Weighted;

public class Main {

	static HashSet<String> strategy;

	public static void arguments(String[] args) {
		if(args[0].equals("-name")) {
			System.out.println("--------------------- Equipe de developpement ---------------------\n");
			System.out.println("BOUAYADINE Younes- Chef de projet -  younes.bouayadine@etu.univ-orleans.fr");
			System.out.println("COLLET Elsa - Developpeuse - elsa.collet@etu.univ-orleans.fr");
			System.out.println("MOUSSI Cedric - Testeur - cedric.moussi@etu.univ-orleans.fr");
			System.out.println("PALOS Killian - Testeur - killian.palos@etu.univ-orleans.fr");
		}

		else if (args[0].equals("-h")) {
			System.out.println("--------------------- Liste des commandes disponibles ---------------------\n");
			System.out.println("-name ");
			System.out.println("\t Affiche les informations sur l'equipe de developpement.\n");

			System.out.println("-h");
			System.out.println("\t Affiche la liste des commandes disponibles.\n");

			System.out.println("-graphe type nbLignes nbColonnes ");
			System.out.println("\t Renvoie le graphe des configurations au format .dot.\n");

			System.out.println("-joue joueur strategie");
			System.out.println("\t Offre la possibilité de jouer sur la console de manière interactive." );
			System.out.println("\t Le paramètre joueur vaut soit 1 soit 2 : ");
			System.out.println("\t \t - Joueur 1 : humain \n \t \t - Joueur 2 : ordinateur.\n");

			System.out.println("--------------------- Liste des commandes non disponibles ---------------------\n");
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

			String type = args[1];
			boolean border;
			if(type.equalsIgnoreCase("S")){
				border=false;
			}else{
				border=true;
			}
			int rows = Integer.parseInt(args[2]);
			int cols = Integer.parseInt(args[3]);
			new DefaultSettings(rows, cols, border);
			System.out.println("Renvoie le graphe des configurations au format dot. Contour ? = "+DefaultSettings.border+", nbLignes = "+DefaultSettings.rows+", nbColonnes = "+DefaultSettings.cols);

			new DrowGraph("Graphe des configurations d'un joueur simplet et nombre de carre", "configuration.dot");

		}

		else if (args[0].equals("-joue")) {
			String strategie = args[1];

			System.out.println("Mode interactif. Strategie: "+strategie+". Patientez entre chaque coup." );

			if(strategie.equalsIgnoreCase("simplet"))
				new PlayAgainstStrategy(new Simple());

			if(strategie.equalsIgnoreCase("idiot"))
				new PlayAgainstStrategy(new Idiot());

			if(strategie.equalsIgnoreCase("prevoyant"))
				new PlayAgainstStrategy(new FarSighted());

			if(strategie.equalsIgnoreCase("pondere")){
				String path = args[2];

				new PlayAgainstStrategy(new Weighted(path));
			}			
		}

		else if (args[0].equals("-cal") ) {
			String strategie = args[2];
			String graphe = args[1]; 
			System.out.println("Cette option n'est pas implementee.");

		}

		else if (args[0].equals("-apprend")) {
			int n = Integer.parseInt(args[1]);
			int alpha = Integer.parseInt(args[2]);
			int gready = Integer.parseInt(args[3]);
			String strategie = args[4];
			System.out.println("Cette option n'est pas implementee.");
		}

		else if (args[0].equals("-eval")) {
			String strategie1 = args[1];
			String strategie2 = args[2];
			System.out.println("Cette option n'est pas implementee.");
		}

		else if (args[0].equals("-simul")) {
			int n = Integer.parseInt(args[1]);
			String strategy1 = args[2];
			String strategy2 = args[3];
			System.out.println("Cette option n'est pas implementee.");


		}
	}
	public final static void clearConsole(int size){
		for(int clear = 0; clear < size; clear++)
		  {
		     System.out.println("\b") ;
		  }
	}

	public static void main (String [] args) {
		new DefaultSettings(3,3,true);
		new Weighted("C3x3.pip");
		clearConsole(200);
		arguments(args);

		
		

	}
	

}