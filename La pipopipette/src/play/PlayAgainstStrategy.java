package play;

import java.util.Scanner;

import settings.Dynamic;
import settings.Player;
import settings.State;
import strategy.PlayerFree;
import strategy.RandomSon;

/**
 * 
 * @author Elsa Collet
 * C'est classe fait jouer l'utilisateur contre la strategie de son choix
 * Elle utilise les classes :
 * PlayerFree
 * Random(strategie);
 **/

public class PlayAgainstStrategy {
	//Un Scanner pour les int
	private static Scanner sc = new Scanner(System.in);
	private Dynamic<State, State> strategy = new Dynamic<>();
	private PlayerFree<State, State> player = new PlayerFree<>();

	private int currentPlayer;
	private Player player1;
	private Player player2;
	private int nbSquares;
	private State s;

	public PlayAgainstStrategy(Dynamic<State, Iterable<State>> str){
		player1 = new Player(1);
		player2 = new Player(2);

		Dynamic<State, Iterable<State>> st = str; 
		this.strategy = new RandomSon(str);

		currentPlayer = (Math.random() <= 0.5) ? 1 : 2;
		nbSquares=0;
		s = new State();
		play();
	}

	/**
	 * Fonction permettant d'alterner entre le joueur1 humain et joueur2 strategie
	 * Si le joueur 1 complete un carre, alors il rejoue.
	 * Le joueur 2 le fait automatiquement.
	 */
	public void play(){
		System.out.println("Début de la partie :");
		System.out.println();
		System.out.println("Joueur "+currentPlayer+" commence.");
		report(0);

		nbSquares = s.getWeight();
		while(!s.gameOver() || currentPlayer==0){
			if(currentPlayer==1){
				play1();
				if(currentPlayer ==1){
					nbSquares = s.getWeight();
					report(1);
					nbSquares = nbSquares - player2.getScore();
					System.out.println("Vous gagnez "+ nbSquares +" points !");
				}
				else{
					report(1);
				}
			}else{
				play2();
				report(2);
			}
		}
		end();
	}


	/**
	 * Affiche les resulats finaux
	 */
	public void end(){
		System.out.println(s.displayGame()+"\n");
		System.out.println(" ---------------------------------------\n");
		System.out.println(player1.toString());
		System.out.println(player2.toString());
		System.out.println("\n ---------------------------------------\n");
		System.out.println((player1.getScore()>player2.getScore()?"Joueur 1":"Joueur 2")
				+" a gagné !!");
		Main.clearConsole(20);


	}
	/**
	 * Fait jouer le joueur 1.
	 * Soit elle complete les carres soit elle determine le coup du joueur par
	 * la classe PlayerFree
	 * Elle augmente son score si le nombre de carres de l'etat actuel
	 * est superieur a celui qu'elle avait avnt de rentrer dans la fonction.
	 * Elle change aussi le current player en fonction des situations
	 * @see PlayerFree
	 */
	public void play1(){
		nbSquares = this.s.getWeight();
		if(this.s.canBeComplet()){
			this.s.completeSquare();
			currentPlayer =1;
		}else{
			this.s = player.get(this.s);
			currentPlayer =2;
		}
		if(s.getWeight()>nbSquares)
			player1.addScore( s.getWeight() - nbSquares);

	}

	/**
	 * Fait jouer l'ordinateur
	 * On recupere un unique successeur par la classe Random sur La strategie voulue
	 * par l'utilisateur.
	 * Si il n'a pas de successeur alors on complete le plateau.
	 * On change le joueur actuel en fonction.
	 */
	public void play2(){
		nbSquares = this.s.getWeight();
		s.completeSquare();
		s =strategy.get(this.s);	

		if(!this.s.gameOver())
			currentPlayer =1;

		if(s.getWeight()>nbSquares)
			player2.addScore(s.getWeight() - nbSquares);

	}

	/**
	 * Affiche qui a joue, le plateau resultant ainsi que le contre rendu
	 * des scores.
	 * @param joueur
	 */
	public void report(int joueur){
		if(joueur!=0){
			Main.clearConsole(20);
			System.out.println("Joueur "+joueur+"\n");
		}
		System.out.println(s.displayGame() );
		System.out.println(player1.toString());
		System.out.println(player2.toString());
		Main.clearConsole(20);
		if(joueur == 2 || joueur ==0){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
