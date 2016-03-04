package vs;

public interface PlateauInterface {
	
//Commit?
	

	/*
	 * 		Fonction toString permettant l'affichage du plateau sous forme physique
	 * @see java.lang.Object#toString()
	 */
	String toString();

	/*
	 *	La fonction caractère vérifie l'état du bit numtrait et creer une chaine 
	 * 		de caractère contenant carac sinon deux espaces inséccables.
	 * 	
	 * @param numTrait Le trait courant (position de 0 à taille-1
	 * @param carac Pouvant contenir les valeurs "  –—" ou "|\u00A0"
	 * @return chaine Chaine de caratère contenant carac ou espace insécable.
	 * @link package.vs#toString affichage  de _ ou |
	 * @see vs.PlateauInterface#caracteres(int, java.lang.Long, java.lang.String)
	 */
	String caracteres(int numTrait, String carac);

	/*
	 * Fonction qui calcul le nombre de petits carrés,
	 *		qui redéfinit la variable global nbCarre,
	 *		et qui la retourne.
	 *
	 *@return nbCarre nombre de carrés dans la configuration actuelle		
	 * */
	int carre();

	/*
	 * Fonction d'ajout d'un trait dans la configuration actuelle. Si la position choisie
	 * 		contient déjà un 1, elle renvoie une exception sinon elle l'ajoute
	 * 		La position effective dans le long est determiné par (le nombre de traits - le mouvement)
	 * 
	 * @param mouvement position choisie par le joueur
	 * @exception DejaPresentException 
	 * @see vs.PlateauInterface#ajouterTrait(int)
	 */

	void ajouterTrait(int mouvement)throws DejaPresentException ;

	/*
	 * Fonction qui détermine si la partie continue. 
	 * 		Si le nombre de carrés en cours est inférieur 
	 * 		aux nombres de cases possibles alors elle continue,
	 *  	sinon false la partie est terminée.
	 * 
	 * @see vs.PlateauInterface#partieContinue()
	 */
	boolean partieContinue();
	public static void test();
}