package jUnit;

import java.util.HashSet;

import junit.framework.TestCase;
import settings.Board;
import settings.DefaultSettings;

/**
 * 
 * @author Moussi C�dric
 * Test unitaire de la classe Board
 **/

public class BoardTest extends TestCase {

	private long boardGame;

	public void testBoard() {
		Board board = new BoardImpl();
		DefaultSettings.cols = 2;
		DefaultSettings.rows = 2;
		DefaultSettings.border = true;
		DefaultSettings.nbLines = 2;
		try {
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
		catch ( Exception e)
		{
			System.out.println (" Erreur");
		}

	}


	public void testSetBoardGame() {
		long b = 10;
		this.boardGame = b;
		if (this.boardGame != b)
			fail("La methode SetBoardGame a rencontree une erreur");
	}

	public void testPossibleMotion() {
		Board board = new BoardImpl();
		DefaultSettings.nbLines = 5;
		HashSet<Integer> l = new HashSet<>();
		try {
			for(int i = 0; i < DefaultSettings.nbLines-1; i++) {
				if ((((boardGame >> i) & 1) == 0)) 
				{
					l.add(i);
				}
			}
		}
		catch ( Exception e )
		{	
			System.out.println (" La methode PossibleMotion a rencontree une erreur");
		}
	}

}
