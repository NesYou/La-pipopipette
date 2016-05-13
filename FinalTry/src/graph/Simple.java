package graph;
import java.util.*;
import java.util.Map.Entry;

import game.DefaultSettings;
import state.*;


public class Simple extends Dynamic<State, Iterable<State>>{

	public Simple(){
		super();
		super.setFunction(
				new Function<State, Iterable<State>>(){
					public Iterable<State> get(State s){
						int n=s.getName();
						HashSet<State> succ= new HashSet<>();
						for(int i = 0; i < DefaultSettings.nbLines-1; i++) {
							if ( !s.getBoard().isFull(i) ) {
								Board b = new Board(s.getBoard());
								b.addMvn(i);
								Storage p = new Storage(b);
								State s_ = new State(p, n);
								s_ = s_.completeSquare();
								if(s_.getBoard().gameOver() ){
									succ.add(s_);
									return succ;
								}else{
									
									succ.add(s_);
								}
							}							
						}

						return succ;
					}
				}
				);

	}
	/*
	 * Iterable<Integer> it = s.possibleMotion();
							for (Integer i : it) {
								if ( !s.getBoard().isFull(i)) {
									n++;
									Board b = new Board(s.getBoard());
									
									State s2 = new State(b);
									s2.addMotion(i);
									s2 = s2.completeSquare();
									succ.add(s2);

									if(s2.getBoard().gameOver() ){
										return succ;
									}
								}	
							}
	 */

	public void to_String(){

		for(Entry<State, Iterable<State>> entry : map.entrySet()) {
			State cle = entry.getKey();
			System.out.println(cle.toString());
			Iterable<State> valeur = entry.getValue();
			Iterator<State> o = valeur.iterator();
			while(o.hasNext()){
				System.out.println("Succ "+o.next());
			}
			// traitements
		}
	}
}
