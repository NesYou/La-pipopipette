
package VS;
public class Plateau {
	/*
	 * Nom de la classe : Plateau
	 * Description : Permet la gestion du plateau, constructeur, toString 
	 * Version : 1.0
	 * Date : 11/02/2015
	 * @author Elsa Collet
	 * */
	private int nbLignes;
	private int nbColonnes;
	private long board;
	private int nbTraits;
	private  boolean border;
	/*
	 * Initialisation du plateau
	 * @param nbLigne le nombre de lignes du plateau
	 * @param nbColonne nombre de colonne du plateau
	 * @param configuration prends 1(=avec bordure) ou 2(=sans bordure) en valeurs
	 * */
	public Plateau(int nbLignes, int nbColonnes, boolean border){
		
		this.nbLignes=nbLignes;
		this.nbColonnes=nbColonnes;
		this.border=border;
		this.nbTraits= nbColonnes*(nbLignes+1)+nbLignes*(nbColonnes+1);
		
		//Creation du plateau
		//De moins en moins
		int t=nbTraits;//58
		while(t>=0){
			for(int j=0; j < nbColonnes; j++) {
				if(t>=0){	
					//t={0,1,2,3} || t={58, 57, 56, 55) 
					if((t<=nbColonnes && t>0)  || (t>nbTraits-nbColonnes-1 && t<=nbTraits)){
						
			            board += 1 << nbTraits-t;
					}
					t--;
				}
			}

			for(int j=0; j < nbColonnes+1; j++) {
				if(t>0){	
					if(j==0 || j==nbColonnes){
						
						 board += 1 << nbTraits-t;
					}
					t--;
				}
				
			}
			
		}
		System.out.println("\nPlateau1 : "+Long.toBinaryString(board)+"\n");
		//this.board=0b111010010111L	;
		//this.board=0b111 100100010010001001000111L;
		System.out.println("\nPlateau : "+Long.toBinaryString(board)+"\n");
		System.out.println("Bord "+board);
		/*this.nbTraits= nbColonnes*(nbLignes+1)+nbLignes*(nbColonnes+1);
		System.out.println("nbTrait 1 : "+nbTraits);*/
	}
	
	/* Getters */
	public int getNbLignes() {
		return nbLignes;
	}

	public int getNbColonnes() {
		return nbColonnes;
	}

	public long getBoard() {
		return board;
	}

	public int getNbTraits() {
		return nbTraits;
	}

	public boolean isBorder() {
		return border;
	}

	public String toString(){
		
		String chaine="\nPlateau : "+Long.toBinaryString(board)+"\n";
		int t=nbTraits-1;

		chaine+="\n";
		
		while(t>=0){
			for(int j=0; j < nbColonnes; j++) {
				if(t>=0){	
					chaine+=caracteres(t, board, " –");
					t--;
					if(t<0){
						break;
					}
				}
			}
			chaine+="\n";
			if(t>nbColonnes-1){
				for(int j= 0; j < nbColonnes+1; j++) {
					if(t>0){	
						chaine+=caracteres(t, board, "|\u00A0");
						t--;
					}
				}
			}
			chaine+="\n";
		}
		return chaine;
	}

	public String caracteres(int numTrait, Long plateau, String carac){
		
		String chaine="";
		boolean etatDuBitN = (((board >> numTrait) & 1) == 1);
		if(etatDuBitN){
			chaine+=carac;
		}else{
			chaine+="\u00A0\u00A0";
		}
		return chaine;
	}

	public boolean partieTerminee() {
		// TODO Auto-generated method stub
		return false;
	}

	public void ajouterTrait(int mouvement) {
		// TODO Auto-generated method stub
		
	}




}