package strategy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import graph.ReadFromPip;
import settings.Dynamic;
import settings.Function;
import settings.State;

/**
 * 
 * @author elsa collet
 * Fonction qui retourne les successeurs d'un etat donne s dans un fichier pip.
 * Fait jouer la strategie definie par ReadFromPip avec la Simple
 */
public class Weighted extends Dynamic<State, Iterable<State>>{
	ReadFromPip<State, Integer> r;

	public Weighted(String path){
		super();
		r=new ReadFromPip<State, Integer>(path);

		super.setFunction( 
				new Function<State, Iterable<State>>(){
					HashMap<State, Integer> pds = new HashMap<>();
					HashSet<State> succ = new HashSet<>();
					ReadFromPip<State, Integer> point = r;
					Simple eas = new Simple();

					/**
					 * Fonction qui permet de recuperer le successeur d'un etat s.
					 * Elle prend en compte le poids des etats definit par le fichier pip
					 * Si s n'a pas de successeurs, la map renvoie un iterable vide.
					 * @param State s
					 * @return Iterable<State> 
					 */
					public Iterable<State> get(State s){
						int n= Integer.MAX_VALUE;
						int wgh;
						Iterable<State> it = new HashSet<>();
						Iterator<State> ut = eas.get(s).iterator();
						while(ut.hasNext()){
							State s_ = ut.next();
							wgh=s.getWeight() - s_.getWeight() + point.get(s_);
							if(wgh<=n){
								if(wgh<n){
									succ= new HashSet<State>();
									n=wgh;
								}
								succ.add(s_);
							}
						}

						if(s.gameOver()){
							pds.put(s, 0);
							return it;
						}else{
							pds.put(s, n);
						}
						return succ;
					}

					public int size(State k) {
						if(k.gameOver()){
							return 0;
						}
						return succ.size();
					}
					
					 
					
					public String toDot(){
						String sc="";
						Set<Entry<State, Integer>> it = pds.entrySet();
						for(Entry<State, Integer> entry : it){
							State s = entry.getKey();
							int wgh = entry.getValue();
							sc+=s.toDot(wgh);
						}
						return sc;
					}
					public String getName() {
						return "ponderer";
					}

					
				}
				);
	}
}

