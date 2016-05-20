package settings;

public class DefaultSettings {

	public static int cols;
	public static int rows;
	public static boolean border;
	public static int nbLines;
	public String filePath;


	/**
	 * @author Elsa Collet
	 * Regroupe tous les paramètres de bases
	 * ( notamment ceux qui définissent un plateau)
	 * et permet d'éviter la duplication de ces derniers.
	 * Initialisation du plateau
	 * @param nbRows le nombre de lignes du plateau
	 * @param nbCols nombre de colonnes du plateau
	 * @param configuration prends 1(=avec bordure) ou 2(=sans bordure) en valeurs
	 **/
	public DefaultSettings(int nbRows, int nbCols, boolean border){
		DefaultSettings.rows=nbRows;
		DefaultSettings.cols=nbCols;
		DefaultSettings.border=border;
		DefaultSettings.nbLines=cols*(rows+1)+rows*(cols+1);
	}

	public void setFilePath(String filepath){
		this.filePath = filepath;
	}
}
