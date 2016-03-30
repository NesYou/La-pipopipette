package vs;

import java.util.List;
import java.util.ArrayList;

public class Plateau implements PlateauInterface{		
	/*
	 * Classe plateau
	 * 	La classe plateau permet la specification du plateau et son évolution
	 * 
	 * 
	 */
	private int nbLignes;
	private int nbColonnes;
	private long board;
	private int nbTraits;
	public boolean border;
	
	public int getNbTraits() { return this.nbTraits; }
	/*
	 * Initialisation du plateau
	 * 
	 * @param nbLigne le nombre de lignes du plateau
	 * @param nbColonne nombre de colonne du plateau
	 * @param configuration prends 1(=avec bordure) ou 2(=sans bordure) en valeurs
	 * */
	public Plateau(int nbLignes, int nbColonnes, boolean border){

		this.nbLignes=nbLignes;
		this.nbColonnes=nbColonnes;
		this.border=border;
		this.nbTraits= nbColonnes*(nbLignes+1)+nbLignes*(nbColonnes+1);


		if(border){
			long top=0;
			for(int i=0; i<nbColonnes; i++)
				top=(top<<1) | 1;
			long milieu=(1<<nbColonnes ) | 1;
			long interne=
					board=(top<<nbColonnes+1) | milieu;
			for(int i=0; i<nbLignes-1; i++)
				board=(board<<nbColonnes*2+1) | (milieu);

			board = (board<<nbColonnes) | top;
		}else{
			board=0b0L;
		}
	}
	
	public long getBoard() { return this.board; }
	
	public void setBoard(Long board) { this.board = board; }


	/*
	 * 		Fonction toString permettant l'affichage du plateau sous forme physique
	 * @see java.lang.Object#toString()
	 */
	public String toString(){

		String chaine="\nPlateau : \n";
		//position dans le long
		int t=nbTraits-1;

		while(t>=0){
			chaine+="\n";
			for(int j=0; j < nbColonnes; j++) {
				if(t>=0){	
					chaine += caracteres(t, " --");
					t--;
				}
			}
			chaine+="\n";
			if(t>nbColonnes-1){
				for(int j= 0; j < nbColonnes+1; j++) {
					if(t>0){	
						chaine+=caracteres(t, "|\u00A0\u00A0");
						t--;
					}
				}
			}
		}
		return chaine;
	}

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
	public String caracteres(int numTrait, String carac){

		String chaine="";
		boolean etatDuBitN = (((board >> numTrait) & 1) == 1);
		if(etatDuBitN){
			chaine+=carac;
		}else{
			chaine+="\u00A0\u00A0\u00A0";
		}
		return chaine;
	}
	
	/**
	 * Calcul l'ensemble des coups restant sur board
	 * @return liste l d'Integer contenant les coups possibles.
	 */
	public List<Integer> mouvementsPossibles() {
		List<Integer> l = new ArrayList<>();
		for(int i = 1; i <= nbTraits; i++) {
			
			if(Long.toBinaryString(board).charAt(i-1) == '0') {
				l.add(i);
			}
		}
		return l;
	}

	/*
	 * Fonction qui calcul le nombre de petits carrés,
	 *		qui redéfinit la variable global nbCarre,
	 *		et qui la retourne.
	 *
	 *@return nbCarre nombif ((((board >> i-1) & 1) == 0)) {
				l.add(i);
			}re de carrés dans la configuration actuelle		
	 * */
	public int carre(){
		int plus=(nbColonnes*2+1);
		int nbCarre=0;
		int t=nbTraits-1;
		while(t>=0){
			for(int i=nbColonnes; i>0; i--){
				boolean b= ((board >> t) & 1)==1 && ((board >> t-nbColonnes) & 1)==1 && ((board >> t-nbColonnes-1) & 1)==1 && ((board >> t-(nbColonnes*2+1)) & 1)==1;
				if(b)
					nbCarre++;
				t--;
			}
			t=t-plus+nbColonnes;	
		}
		return nbCarre;
	}


	/*
	 * Fonction d'ajout d'if ((((board >> i-1) & 1) == 0)) {
				l.add(i);
			}un trait dans la configuration actuelle. Si la position choisie
	 * 		contient déjà un 1, elle renvoie une exception sinon elle l'ajoute
	 * 		La position effective dans le long est determiné par (le nombre de traits - le mouvement)
	 * 
	 * @param mouvement position choisie par le joueur
	 * @exception DejaPresentException 
	 * @see vs.PlateauInterface#ajouterTrait(int)
	 */

	public void ajouterTrait(int mouvement)throws DejaPresentException {
		if(mouvement<1 && mouvement>nbTraits){
			throw new IllegalArgumentException("La position choisie doit être "
							+ "comprise entre 1 et "+nbTraits+".");
		}
		else{
			if(((board >> nbTraits-mouvement) & 1)==1){
				throw new DejaPresentException("Ce trait est déjà placé.");
			}else{
				long trait=1<<(nbTraits-mouvement);
				board = board | trait;
			}	
		}
	}

	/*
	 * Fonction qui détermine si la partie continue. 
	 * 		Si le nombre de carrés en cours est inférieur 
	 * 		aux nombres de cases possibles alors elle continue,
	 *  	sinon false la partie est terminée.
	 * 
	 * @see vs.PlateauInterface#partieContinue()
	 */
	public boolean partieContinue(){
		if(carre()<(nbColonnes*nbLignes)){

			return true;
		}
		System.out.println("La partie est terminée");
		return false;

	}
}