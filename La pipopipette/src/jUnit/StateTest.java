package jUnit;

import junit.framework.TestCase;
import settings.Storage;

/**
 * 
 * @author Moussi Cedric
 * Test unitaire de la classe State
 **/


public class StateTest extends TestCase {


	public void testAddMotion() {
		Storage stow = new Storage();
		int pos = 2;
		try {
			stow.addMotion(pos);
		}
		catch ( Exception e)
		{
			System.out.println ("La methode AddMotion a rencontree une erreur");
		}
	}


	public void testAddMotionUser() {
		Storage stow = new Storage();
		int pos = 2;
		try {
			stow.addMotiontUser(pos);
		}
		catch ( Exception e)
		{
			System.out.println ("La methode AddMotionUser a rencontree une erreur");
		}
	}

}
