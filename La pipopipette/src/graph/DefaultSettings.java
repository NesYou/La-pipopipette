package graph;

import state.State;

/**
 * 
 * @author Elsa Collet
 * Classe permettant de definir les parametres du jeu 
 */

public class DefaultSettings {
	
	public static int cols;
	public static int rows;
	public static boolean border;
	public static State root;
	public static int nbLines;
	
	/**
	 * @author Elsa Collet
	 * Initialisation du plateau
	 * @param nbLigne le nombre de lignes du plateau
	 * @param nbColonne nombre de colonne du plateau
	 * @param configuration prends 1(=avec bordure) ou 2(=sans bordure) en valeurs
	 * */
	public DefaultSettings(int nbRows, int nbCols, boolean border){
		DefaultSettings.rows=nbRows;
		DefaultSettings.cols=nbCols;
		DefaultSettings.border=border;
		DefaultSettings.root = new State();
	}

}
