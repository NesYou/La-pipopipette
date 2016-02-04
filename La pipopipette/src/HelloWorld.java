
public class HelloWorld {
	
	public static void Main(String [] args) {
		System.out.println("Hello world!");
		System.out.println("Hello world!");
		System.out.println("Elsa!");
		System.out.println("Hello world ! This is me, Younes");
		affichagePlateau();
		System.out.println("Fini !bfgf");
		
	}

	
	public static void affichagePlateau(){
		String[] ligne= new String[4];
		String[] colonne= new String[4];
		String a="111";
		ligne[0]=a;
		String b="000";
		ligne[1]=b;
		String c="000";
		ligne[2]=c;
		String d="111";
		ligne[3]=d;
		colonne[0]=a;
		colonne[1]=b;
		colonne[2]=c;
		colonne[3]=d;
		
		for(int i=0; i<ligne.length; i++){
			System.out.print(".");
			for(int j=0; j<ligne[i].length(); j++){
				String carac= ligne[i].substring(j, j+1);
				if(carac.equals("1")){
					System.out.print("_");
				}
				else{
					System.out.print(" ");
				}
			}
			for(int j=0; j<colonne[i].length(); j++){
				String carac= colonne[i].substring(j, j+1);
				if(carac.equals("1")){
					System.out.print("|");
				}
				else{
					System.out.print(" ");
				}
			}
		}
	}
	
	
}
