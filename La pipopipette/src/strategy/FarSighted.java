package strategy;

import java.util.HashSet;

import settings.Dynamic;
import settings.Function;
import settings.State;

/**
 * 
 * @author Elsa Collet
 *Elle est la stratégie du joueur prévoyant.
 *Elle prends l'ensemble des états successeurs
 *de SimpleGraphe et récupère celui dont le poids
 *est le plus faible.
 **/

public class FarSighted extends Dynamic<State, Iterable<State>>{

	
	

	public FarSighted(){
		super();
		super.setFunction(

				new Function<State, Iterable<State>>(){
					HashSet<State> succ;

					public Iterable<State> get(State s){
						Simple eas = new Simple();
						Iterable<State> i = eas.get(s);
						int n= Integer.MAX_VALUE;
						s.completeSquare();
						succ =new HashSet<>();
						for(State s_ : i){
							//Recherche de la plus petite valeur dans i
							int wgh= s_.getWeight()-s.getWeight();
							if(wgh<n){
								n=wgh;
							}
							if(s_.getBoard().gameOver() ){
								succ.add(s_);
								return succ;
							}
						}
						for(State s_ : i){
							//Recherche de la plus petite valeur dans i
							if(n==s_.getWeight()){
								succ.add(s_);	
							}
						}
						return succ;
					}

					public int size(State k) {
						return succ.size();
					}

					public String toDot() {
						String display = "";
						for(State s : succ){
							display +=s.toDot(s.getWeight());
						}
						return display;
					}

					public String getName() {
						return "prevoyant";
					}



				}

				);

	}


}
