package state;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class State {
	int name;
	Storage stow;

	public State(){
		this.name=0;
		this.stow= new Storage();
	}
	public State(State s){
		this.name = s.name+1;
		this.stow=new Storage(s.stow);
	}

	public State(Storage p){
		this.stow = p;
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
	
	public State(State s, int name){
		this.name = s.name;
		this.stow = new Storage(s.stow);
	}


	
	/**
	 * 
	 * @return la chaine representant le format de donnee pour l'affichage du graphe en .dot 
	 */
	public String toDot(){
		return "N" + name + " [label= \"N"+ name  + ":V="  + stow.toDot() +"\"];\n" ;
	}

	/**
	 * 
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
		stow.addMotion(pos);
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

	public State completeSquare() {
		Storage r = this.stow.completeSquare();
		State e = new State(r);
		return e;
	}
	public Iterable<Integer> possibleMotion() {
		return stow.possibleMotion();
	}





}
