package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

import settings.Board;
import settings.Dynamic;
import settings.State;
import settings.Storage;

/**
 * Created by killian on 14.05.16.
 */
/**
 * Lis un fichier ".pip" et le retranscrit
 * en une Map<State, Integer> 
 */
public class ReadFromPip<K, V> extends Dynamic<State, Integer> {

	/**
	 * @author Killian Palos
	 * Lis un fichier ".pip" et le retranscrit
	 * en une forme utilisable par notre code
	 */


	public ReadFromPip() {
		super();
	}

	public ReadFromPip(String filepath) {
		super();
		readFromPip(filepath);
	}

	public Integer get(State s){
		if(map.get(s)==null)
			return 0;
		return map.get(s);
	}

	public void readFromPip(String filepath) {
		BufferedReader in = null;
		try {
			String line = null;
			boolean border;
			int nbLignes, nbColonnes;
			in = new BufferedReader(new FileReader(new File(filepath)));

			//On regarde la 1ère ligne du fichier pour connaître la config
			line = in.readLine();
			StringTokenizer tk = new StringTokenizer(line);

			border = (tk.nextToken().equals("C"));
			nbLignes = Integer.parseInt(tk.nextToken());
			nbColonnes = Integer.parseInt(tk.nextToken());

			//Puis tout le reste
			while((line = in.readLine()) != null) {

				tk = new StringTokenizer(line);

				Board b = new Board();
				b.setBoardGame(this.convertisPipLigne(border,nbLignes,tk.nextToken()));
				State s = new State(new Storage(b));

				//On ajoute à notre hashmap l'état en Key et le poids en Value
				map.put(s, Integer.parseInt(tk.nextToken()));

			}
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}

	}


	/**
	 * Convertis le premier "mot" d'une ligne de d'un fichier
	 * pip en un long, image du tableau
	 * @return long représentant un état du jeu
	 */
	private long convertisPipLigne(boolean border, int nbLignes,String s) {
		long board = 0;

		if(border) {
			String borders = "";
			for(int i = 0; i <= nbLignes; i++) {
				borders += "1";
			}
			//On remplace les "points" par des 1 (c'est la bordure) et on rajoute le haut et le bas du tableau
			//BigInteger nous permet de convertir un String en une valeur en fonction de la base, ici en binaire.
			board = new BigInteger(borders.concat(s.replace(".","1")).concat(borders),2).longValue();
		}
		else {
			board = new BigInteger(s.replace(".",""),2).longValue();
		}
		return board;
	}

	public HashMap<State,Integer> getMap() {
		return map;
	}

}

