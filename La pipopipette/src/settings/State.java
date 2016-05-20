package settings;

import java.util.HashSet;

/**
 * 
 * @author Elsa Collet
 **/

public class State {
	int name;
	Storage stow;

	/** Constructeur de la classe State
	 * 
	 */

	public State(){
		this.name=0;
		this.stow= new Storage();
	}

	/** Constructeur de la classe State
	 * 
	 * @param s
	 */

	public State(State s){
		this.name = s.name+1;
		this.stow=new Storage(s.stow);
	}

	/** Constructeur de la classe State
	 * 
	 * @param p
	 */

	public State(Storage p){
		this.stow = new Storage(p);
		this.name=0;
	}
	/**
	 * 
	 * @param s
	 * @param name 
	 */
	public State(Storage s, int name){
		this.name = name;
		this.stow = new Storage(s);;
	}

	/** Constructeur de la classe State
	 * 
	 * @param s
	 * @param name
	 */

	public State(State s, int name){
		this.name = s.name;
		this.stow = new Storage(s.stow);
	}



	/**
	 * 
	 * @return la chaine representant le format de donnee pour l'affichage du graphe en .dot 
	 */
	public String toDot(Object n){
		return "N" + name + " [label= \"N"+ name  + ":V="+n  + stow.toDot() +"\"];\n" ;
	}

	/**
	 * toString()
	 */

	public String toString(){
		String out = "";
		out += "N"+ name + "\n" + stow.toString();
		return out;
	}

	/**
	 * Ajouter un trait. La position correspondant à la valeur physique
	 * 0 -> 0
	 */
	public void addMotion(int pos){
		this.stow.addMotion(pos);

	}


	/**
	 * Ajouter un trait. La position correspondant à la valeur donner par l'utilisateur.
	 * 1 -> vaut 11 ; 12 -> 0
	 */
	public void addMotionUser(int pos){

		stow.addMotiontUser(pos);

	}


	/**
	 * Retourne le plateau correspondant a cet etat
	 */
	public Board getBoard(){
		return stow.getBoard();
	}

	public Long getBoardGame(){
		return stow.getBoardGame();
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public Storage getStow() {
		return stow;
	}

	public void setStow(Storage stow) {
		this.stow = stow;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (stow == null) {
			if (other.stow != null)
				return false;
		} else if (!stow.equals(other.stow))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stow == null) ? 0 : stow.hashCode());
		return result;
	}

	public int restLine(){
		return stow.restLine();
	}


	public void completeSquare() {
		this.stow.completeSquare();

	}
	public Iterable<Integer> goodPosition(State s){

		State s2 = new State(s.stow);
		s2.completeSquare();
		if(!s.equals(s2)){
			s.completeSquare();
			return null;
		}
		return stow.possibleMotion();
	}

	public Iterable<Integer> possibleMotion2() {
		Iterable<Integer> pos=null;
		if(! this.gameOver()){
			pos = new HashSet<>();
			pos=goodPosition(this);
		}

		return pos;

	}
	public HashSet<Integer> possibleMotion1() {
		this.completeSquare();
		return stow.possibleMotion();

	}

	/** Methode qui permet de savoir si un carré peut être completé
	 * 
	 * @return
	 */

	public boolean canBeComplet(){
		State s_ = new State(this);
		s_.completeSquare();
		if(this.equals(s_)){
			return false;
		}else{
			return true;
		}
	}

	public int getWeight() {

		return stow.getWeight();
	}

	/**
	 * Retourne vrai si la partie est finie
	 * @return
	 */
	public boolean gameOver(){
		return getBoard().gameOver();
	}
	public HashSet<Integer> possibleMotionUsers() {

		return stow.possibleMotionUser();
	}
	public String displayGame() {
		return stow.toString();
	}



}
