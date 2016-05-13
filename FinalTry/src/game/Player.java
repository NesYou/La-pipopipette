package game;

public class Player {

	public int numPlayer;
	private int score;
	
	
	public Player(int numPlayer){
		this.numPlayer=numPlayer;
		this.score=0;
	}
	
	
	
	/**
	 * @return the nbPoints
	 */
	public int getNbPoints() {
		return score;
	}
	/**
	 * @param nbPoints the nbPoints to set
	 */
	public void setNbPoints(int nbPoints) {
		this.score = nbPoints;
	}
	
	public void ajoutPoints(int nb){
		score+=nb;
		
	}
	public String toString(){
		return 	  
			"| Joueur	" + score + "		" + score + "pts    |";
				
	}
}
