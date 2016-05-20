package strategy;

import java.util.HashSet;

import settings.Dynamic;
import settings.Function;
import settings.State;

/**
 * 
 * @author Elsa Collet
 * Elle est la stratégie du joueur Idiot. 
 *A l'inverse de FarSighted, elle prend le succésseur donc 
 *le poids est le plus élevé. 
 */

public class Idiot extends Dynamic<State, Iterable<State>>{

	public Idiot(){
		super();
		super.setFunction(

				new Function<State, Iterable<State>>(){
					HashSet<State> succ;

					public Iterable<State> get(State s){
						Simple eas = new Simple();
						Iterable<State> i = eas.get(s);
						int n= Integer.MIN_VALUE;
						s.completeSquare();
						succ =new HashSet<>();
						for(State s_ : i){
							//Recherche de la plus grande valeur dans i
							int wgh= s_.getWeight()-s.getWeight();
							if(wgh>n){
								n=wgh;
							}
							if(s_.getBoard().gameOver()){
								succ.add(s_);
								return succ;
							}
						}	
						for(State s_ : i){
							//creer succ
							if(n==s_.getWeight()){
								succ.add(s_);	
							}

						}
						//Si le prochain poids est 0
						if(succ.size() == 0){
							for(State s_ : i){
								succ.add(s_);	
							}
						}




					

					return succ;
				}

				@Override
				public int size(State k) {
					return succ.size();
				}

				@Override
				public String toDot() {
					String display = "";
					for(State s : succ){
						display +=s.toDot(s.getWeight());
					}
					return display;
				}

			
			
	}

				);

}


}
