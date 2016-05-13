package state;

import java.util.ArrayList;
import java.util.HashSet;

import game.DefaultSettings;

public class Board {

	private Long boardGame;
	/**
	 * Creation du plateau racine a partir des parametres initiaux
	 * @author ELsa Collet
	 * */
	public Board(){
		if(DefaultSettings.border){
			long haut=0;
			for(int i=0; i<DefaultSettings.cols; i++)
				haut=(haut<<1) | 1;
			long milieu=(1<<DefaultSettings.cols ) | 1;
			this.boardGame=(haut<<DefaultSettings.cols+1) | milieu;
			for(int i=0; i<DefaultSettings.rows-1; i++)
				boardGame=(boardGame<<DefaultSettings.cols*2+1) | (milieu);
			this.boardGame = (boardGame<<DefaultSettings.cols) | haut;
		}else{
			boardGame=0b0L;
		}
	}
	public Board(Board p){
		this.setBoardGame(p.boardGame);
	}

	/**
	 * Creation d'un plateau par copie d'un autre
	 * @param b Plateau a recopier
	 * @author ELsa Collet
	 */
	public void setBoardGame(Long b){
		this.boardGame=b;
	}
	public Long getBoardGame(){
		return boardGame;
	}


	/**
	 *	La fonction isFull test la présence d'un 1 alors elle renvoie vrai, faux si c'est 0. 
	 * @param numTrait Le trait courant (position de 0 à nbLines-1)
	 * @return boolean true si le trait n'a pas été place false sinon
	 * @author ELsa Collet
	 */
	public boolean isFull(int numTrait){
		return (((boardGame >> numTrait) & 1) == 1);
	}

	/**
	 * 
	 * @return true si la partie est finie, faux sinon
	 */
	public boolean gameOver(){
		if(nbSquares()>=(DefaultSettings.cols*DefaultSettings.rows)){
			return true;
		}
		return false;

	}


	public int nbSquares() {
		int nbCarre=0;
		int t=DefaultSettings.nbLines-1;
		while(t>=0){
			for(int i=DefaultSettings.cols; i>0; i--){
				boolean b= ((boardGame >> t) & 1) == 1 
						&& ((boardGame >> t-DefaultSettings.cols) & 1) == 1 
						&& ((boardGame >> t-DefaultSettings.cols-1) & 1) == 1 
						&& ((boardGame >> t-(DefaultSettings.cols*2+1)) & 1) == 1;
				if(b)
					nbCarre++;
				t--;
			}
			t=t-(DefaultSettings.cols+1);	
		}
		return nbCarre;
	}
	

	/**
	 * 	Representation graphique du plateau.
	 * 	Si il n'y a pas de trait à l'endroit recherche on affiche des espaces inseccables
	 * 	sinon | ou --
	 * @return une String.
	 * @author ELsa Collet
	 */
	public String toString(boolean param){
		String displayRowEmpty;
		String displayColsEmpty;
		String displayRowsFull;
		String displayColsFull;
		String diplayEndLine;
		if(param){
			displayRowEmpty = "  .";
			displayColsEmpty = "\u00A0\u00A0\u00A0";
			displayRowsFull= "--.";
			displayColsFull ="|  ";
			diplayEndLine = "\n";
		}else{
			displayRowEmpty = "  .";
			displayColsEmpty = "\u00A0\u00A0\u00A0";
			displayRowsFull= "--.";
			displayColsFull =" | ";
			diplayEndLine = "\\n";

		}
		String display="";
		int t=DefaultSettings.nbLines-1;
		while(t>=0){
			display+=diplayEndLine+ ".";
			for(int j=0; j < DefaultSettings.cols; j++) {
				if(t>=0){
					if (isFull(t)){
						display += displayRowsFull;
					}else{
						display += displayRowEmpty;
					}
					t--;
				}
			}
			display+=diplayEndLine;
			if(t> DefaultSettings.cols-1){
				for(int j= 0; j < DefaultSettings.cols+1; j++) {
					if(t>0){	
						if (isFull(t)){
							display += displayColsFull;
						}else{
							display += displayColsEmpty;
						}
						t--;
					}
				}
			}
		}
		return display;
	}

	/**
	 * Ajouter un trait
	 * 
	 */
	public void addMvn(int motion){
		double move = new Double(motion);
		Long line = new Long((long) Math.pow(2.0, motion));
		this.boardGame= this.boardGame + line ;
	}

	/**
	 * ArrayList des mouvements possibles d'effectuer
	 * Calcul l'ensemble des coups restant sur board
	 * @return liste l d'Integer contenant les coups possibles.
	 */
	public Iterable<Integer> possibleMotion() {
		HashSet<Integer> l = new HashSet<>();
		for(int i = 0; i < DefaultSettings.nbLines-1; i++) {
			if ((((boardGame >> i) & 1) == 0)) {
				l.add(i);
			}
		}
		return l;
	}
	

		
		
		
		
	


}

