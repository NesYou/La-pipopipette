package settings;

/**
 * @author Elsa Collet
 **/


public class Player {

	public int numPlayer;
	private int score;

	/** Constructeur de la classe Player
	 * 
	 * @param numPlayer
	 */

	public Player(int numPlayer){
		this.numPlayer=numPlayer;
		this.score=0;
	}

	/**
	 * @return le nombre de points
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @param nbPoints the nbPoints to set
	 */
	public void setScores(int nbPoints) {
		this.score = nbPoints;
	}

	/** ajoute le score
	 * 
	 * @param nb
	 */

	public void addScore(int nb){
		score+=nb;

	}

	/** toString de la classe Player
	 * 
	 */

	public String toString(){
		return 	  
				"| Joueur	" + numPlayer + "		" + score + "pts    |";

	}
}
