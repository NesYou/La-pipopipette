package play;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import settings.Dynamic;
import settings.State;
import strategy.CompleteGraph;



/**
 * 
 * @author Elsa Collet
 *
 * Classe qui genere le graphe des configurations reduit d'une strategie s passee en parametre
 */
public class DrowGraph{
	State root;
	Dynamic<State, Iterable<State>> g = new Dynamic<>();
	HashMap<State,Integer> id;
	PrintWriter sc;


	public DrowGraph(String title, String fileName){
		g = new CompleteGraph();
		this.root = new State();
		this.id = new HashMap<>();

		try {
			sc= new PrintWriter(fileName);
			generate(true, title);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public String successors(State s){
		String sc="";
		String display = "";
		if(!id.containsKey(s) ){
			id.put(s, id.size());
			s.setName(id.get(s));
			sc += s.toDot( s.getWeight() );
			if(!s.gameOver()){
				Iterable<State> i = (Iterable<State>) g.get(s);
				for(State s_: i){
					display+=successors(s_);
					display+= "N"+s.getName() + " -> N"+s_.getName() + ";\n";
				}
			}
			
			return sc + display;
		}
		s.setName(id.get(s));
	
		return sc + display;

	}



	public void generate(boolean b, String title){
		id = new HashMap<>();
		String display="digraph pipopipetteStrategie {\n"
				+ "graph[labelloc=\"t\"  fontsize=16 fontcolor=\"blue\""
				+ "label=\""+ title +" \" ]\n"
				+ "node [shape=box fontname = \"Courier New\" color=\"sienna\"]\n"
				+ "edge [fontname = \"Times\" fontcolor=\"sienna\"]\n\n";

		display +=successors(root);
		sc.write(display);
		sc.write("\n }");
		sc.close();
	}
}
