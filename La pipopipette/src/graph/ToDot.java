package graph;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import game.DefaultSettings;
import state.*;


public class ToDot<K, V>{

	State root;
	Simple g;
	HashMap<State,Integer> id;

	public ToDot(){
		this.root = new State();
		this.g = new Simple();
		this.id = new HashMap<>();
		generate();
	}
	public String successors(State s){
		if(!id.containsKey(s)){
			id.put(s, id.size());
			s.setName(id.get(s));
			Iterable<State> i = this.g.get(s);
			String sc="";
			sc+=(s.toDot()+"\n");

			for (State s_ : i) {
				sc+=successors(s_);
				s_.setName(id.get(s_));
				
				sc+=( "N"+ s.getName() + " -> " + "N" + s_.getName() +"\n");
				
				
			}
			return sc;
		}else{
			return "";
		}
	}
		

	public void generate(){
		PrintWriter sc;
		String display="";
		try {
			sc = new PrintWriter("Graphe.dot");
			sc.write("digraph pipopipetteStrategie {\n"
					+ "graph[labelloc=\"t\"  fontsize=16 fontcolor=\"blue\""
					+ "label=\"Graphe des configurations d'un jeu de pipopipette\\n et calcul d'une stratégie gagnante\\n\\n \" ]\n"
					+ "node [shape=box fontname = \"Courier New\" color=\"sienna\"]\n"
					+ "edge [fontname = \"Times\" fontcolor=\"sienna\"]\n\n" );


			display +=successors(this.root);

			sc.write(display);
			sc.write("\n }");
			sc.close();

		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}