package vs_ia;

import vs.Plateau;

public class TestIa {
	
	public static void main(String[] args) {
		Plateau a = new Plateau(3, 3, true);
		Plateau b = new Plateau(3, 3, true);
		
		a.setBoard(0b111110101010010001001111L);
		
		b.setBoard(0b111110110010010001001111L);
		
		System.out.println(a.toString());
		
		System.out.println(a.mouvementsPossibles().toString());
	
	}
}