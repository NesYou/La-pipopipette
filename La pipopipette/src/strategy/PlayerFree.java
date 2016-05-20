package strategy;

import java.util.HashSet;
import java.util.Scanner;

import settings.Dynamic;
import settings.Function;
import settings.State;

/**
 * 
 * @author Elsa Collet
 * Elle permet a un joueur de choisir lui même
 * ses successeurs.
 **/

public class PlayerFree<K,V> extends Dynamic<State, State>{

	Scanner sc ;
	HashSet<Integer> it;  

	public PlayerFree(){
		super();
		super.setFunction(
				new Function<State, State>(){
					State succ;
					public State get(State s){
						
						int pos;
						succ = new State(s);
						it = s.possibleMotionUsers();
						do{
							sc = new Scanner(System.in);
							pos = controlInput(s);
						}while(pos==0);
						succ.addMotionUser(pos);
						return succ;

					}
					public int size(State k) {
						return 1;
					}
					public String toDot() {
						return succ.toDot(succ.getWeight());
					}
					public String getName() {
						return "humanPlayer";
					}
					
				}

				);


	}

	public int controlInput(State s) {
		int pos;
		System.out.println("(Saisir un nombres compris entre 0 et 23, ou entre 5 et 20 \n"
				+ "si le plateau a un contour)");
		System.out.println("Joueur 1 -:");
		try{
			pos =sc.nextInt();
			if(it.contains(pos)){
				return pos;
			}
		}catch (Exception e){
			return 0;
		}
		return 0;
	}
}
