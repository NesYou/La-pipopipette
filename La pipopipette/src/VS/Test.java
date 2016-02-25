package VS;

public class Test {
	
	public static void main(String [] args) {
		
		int[][] tab = new int[10][10];
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				tab[i][j] = 12;
				System.out.print(tab[i][j]);
			}
			System.out.println();
		}
		
	}

}
