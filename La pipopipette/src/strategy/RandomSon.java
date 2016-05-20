package strategy;

import java.util.Random;

import settings.Dynamic;
import settings.Function;
import settings.State;

public class RandomSon extends Dynamic<State, State>{

	
	Dynamic<State, Iterable<State>> strS ;
	public RandomSon(Dynamic<State, Iterable<State>> str1){
		super();
		strS = new  Dynamic<State, Iterable<State>>();
		strS =str1;
		super.setFunction(
				new Function<State, State>(){
					State succ;
					Iterable<State> possibleSucc;
					Dynamic<State, Iterable<State>> str;

					
					public State get(State k) {
						succ = new State(k);
						succ.completeSquare();
						str = strS;
						possibleSucc = str.get(k);
						
						if(str.size(k)>0){
							int item = new Random().nextInt(str.size(k));
							
							int j=0;
							for(State si : possibleSucc){
								if(j == item){
									succ = new State(si);
									succ.setName(k.getName()+j);
									return succ;
								}else{
									j++;
								}
							}
						}else{
							if(k.gameOver()){
								return k;
							}
							succ.completeSquare();
							
						}
						
						return succ;
					}

					public int size(State k) {

						if(succ == null){
							return 0;
						}
						return 1;
					}

					public String toDot() {
						return succ.toDot(succ.getWeight());
					}

				
				}
				);

	}


}
