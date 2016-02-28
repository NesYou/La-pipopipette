package testJUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import vs.DejaPresentException;
import vs.Plateau;

public class PlateauTest {
	public void testPlateau() {
	}

	@Test
	public void testToString() {
		
		
		fail("Not yet implemented");
	}

	@Test
	public void testCaracteres() {
		fail("Not yet implemented");
	}
	@Test
	public void testCarre() {
		Plateau p = new Plateau(2,2, true);
		if(p.carre()!=0)
			fail("plateau initialisé");
		try {
			p.ajouterTrait(4);
			p.ajouterTrait(6);
		} catch (DejaPresentException e) {
			System.out.println(e.getMessage());
		}
		
		if(p.carre()!=1)
			fail("plateau initialisé");
		try {
			p.ajouterTrait(4);
			p.ajouterTrait(6);
		} catch (DejaPresentException e) {
			System.out.println(e.getMessage());
		}
	
	}


	@Test
	public void testAjouterTrait() {
		fail("Not yet implemented");
	}

	@Test
	public void testPartieContinue() {
		fail("Not yet implemented");
	}
}