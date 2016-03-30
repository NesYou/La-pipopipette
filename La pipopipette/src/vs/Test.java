package vs;

public class Test {

	public static void main(String[] args) {

		Plateau p = new Plateau (3, 3, true);
		
		System.out.println(p.getNbTraits()+" traits.");
		System.out.println(p.toString());
		System.out.println();
		System.out.println(Long.toBinaryString(p.getBoard()));
		System.out.println();
		System.out.println(p.mouvementsPossibles().toString());
	}

}
