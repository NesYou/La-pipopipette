package graph;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import settings.Dynamic;
import settings.State;
import strategy.Simple;

/**
 * 
 * @author Elsa Collet
 *
 * Classe qui genere le graphe des configurations reduit d'une strategie s passee en parametre
 */
public class Configurations{
	State root;
	Dynamic<State, Iterable<State>> g = new Dynamic<>();
	HashMap<State,Integer> id;
	PrintWriter sc;


	public Configurations(String title, String fileName) throws FileNotFoundException{
		g = new Simple();
		this.root = new State();
		this.id = new HashMap<>();
		sc= new PrintWriter(fileName);
		generate(true, title);

	}

	public String successors(State s){
		String sc="";
		String display = "";
		s.completeSquare();

		if(!id.containsKey(s) ){
			id.put(s, id.size());
			s.setName(id.get(s));
			sc += s.toDot( s.getWeight() );
			if(!s.gameOver()){
				Iterable<State> i = (Iterable<State>) g.get(s);
				for(State s_: i){
					display+=successors( s_);
					try{
						Pattern p = Pattern .compile("a*b|c");
						String entree = "aabbbcab";
						Matcher m = p.matcher(entree);
						while (m.find())
							System.out.println(entree.substring(m.start(), m.end()));
					}catch(PatternSyntaxException pse){
					}
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
