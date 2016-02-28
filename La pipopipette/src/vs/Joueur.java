package vs;

public class Joueur {
	
	public int joueur;
	private int nbPoints;
	
	
	public Joueur(int numeroJoueur){
		this.joueur=numeroJoueur;
		this.nbPoints=0;
	}
	
	
	/**
	 * @return the nbPoints
	 */
	public int getNbPoints() {
		return nbPoints;
	}
	/**
	 * @param nbPoints the nbPoints to set
	 */
	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}
	
	public void ajoutPoints(int nb){
		nbPoints+=nb;
		
	}
	public String toString(){
		return 	  
			"| Joueur	" + joueur + "		" + nbPoints + "pts    |";
				
	}
	
}