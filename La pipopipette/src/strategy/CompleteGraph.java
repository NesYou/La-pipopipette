package strategy;

import java.util.HashSet;

import settings.Board;
import settings.Dynamic;
import settings.Function;
import settings.State;
import settings.Storage;

/**
 * @author Elsa Collet
 * De manière similaire à SimpleGraphe, seulement elle ne complète pas les carré. 
 *Elle est, notamment, utilisée dans le mode de jeu Joueur vs Stratégie.
 */
public class CompleteGraph extends Dynamic<State, Iterable<State>>{

	public CompleteGraph(){
		super();
		super.setFunction(
				new Function<State, Iterable<State>>(){
					HashSet<State> succ;
					public Iterable<State> get(State s){
						int n=s.getName();
						succ = new HashSet<>();
						s.completeSquare();
						Iterable<Integer> it = s.possibleMotion1();
						for (Integer i : it) {
							Board b = new Board(s.getBoard());
							b.addMvn(i);

							Storage p = new Storage(b);
							State s_ = new State(p, n);
							s_.completeSquare();
							succ.add(s_);

							if ( s.getBoard().isFull(i) ) {
								return succ;
							}

						}

						return succ;
					}
					public int size(State k) {
						return succ.size();
					}
					@Override
					public String toDot() {
						// TODO Auto-generated method stub
						return null;
					}
				
				}
				);


	}
}
