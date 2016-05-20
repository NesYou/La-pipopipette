package jUnit;

import junit.framework.TestCase;
import settings.Board;
import settings.DefaultSettings;
import settings.Matrix;
import settings.Pair;

/**
 * 
 * @author Moussi C�dric
 * Test unitaire de la classe Matrix
 **/

public class MatrixTest extends TestCase {
	public int mat[][];


	public void testMatrix() {
		Matrix mat = new MatrixImpl();
		DefaultSettings.rows = 4;
		DefaultSettings.cols = 5;
		this.mat = new int[DefaultSettings.rows * 2+1][DefaultSettings.cols * 2+1];
		for(int j=0; j<=DefaultSettings.rows*2; j++){
			for(int i=0; i<= DefaultSettings.cols * 2; i++){
				//Présence d'un nombre ou d'un point ?
				if(j%2 == 0){
					if(i%2==0){
						this.mat[j][i]=2;
					}else{
						if(DefaultSettings.border){
							if(j==0 || j==DefaultSettings.rows * 2){
								this.mat[j][i]=1;
							}else{
								this.mat[j][i]=0;
							}
						}else{
							this.mat[j][i]=0;
						}
					}
				}else{
					if(i%2==0){
						if(DefaultSettings.border){
							if(i==0 || i==DefaultSettings.cols * 2){
								this.mat[j][i]=1;
							}else{
								this.mat[j][i]=0;
							}
						}else{
							this.mat[j][i]=0;
						}
					}else{
						this.mat[j][i]=2;
					}
				}
			}
		}
	}

	public void testAddMvn() {
		int motion = 2;
		try {
			Pair p = new Pair();
			p = p.convertToMap(motion, mat);
			mat[p.getFst()][p.getSnd()]=1;
		}
		catch ( Exception e)
		{ 
			System.out.println("La methode AddMvn a rencontree une erreur"); 
		}
	}

	public void testMatrixBoard() {
		Board board = new Board();
		DefaultSettings.rows = 4;
		DefaultSettings.cols = 3;
		try {
			if(board != null){
				boolean val;
				int h=0;
				this.mat= new int[DefaultSettings.rows*2+1][DefaultSettings.cols * 2+1];
				for(int j=DefaultSettings.rows * 2; j>= 0; j--){
					for(int i=DefaultSettings.cols * 2; i>=0 ; i--){
						//Présence d'un nombre ou d'un point ?
						if(j%2 == 0){
							if(i%2==0){
								val=false;
							}else{
								val=true;
							}
						}else{
							if(i%2==0){
								val=true;
							}else{
								val=false;
							}
						}
						if( !val){
							//C'est un point
							mat[j][i]=2;
						}else{
							if( board.isFull(h) ){
								mat[j][i]=1;
							}else{
								mat[j][i]=0;
							}
							h++;
						}
					}
				}
			}
		}
		catch ( Exception e)
		{ 
			System.out.println ( "La methode MatrixBoard a rencontree une erreur"); 
		}
	}

	public void testMatrixMatrix() {
		Matrix m = new Matrix();
		try {
			this.mat = m.mat;
		}
		catch ( Exception e)
		{
			System.out.println (" La methode MatrixMatrix a rencontree une erreur");
		}
	}

	public void testRotation() {
		DefaultSettings.cols = 10;
		DefaultSettings.rows = 5;
		try {
			int t[][] = new int [DefaultSettings.cols*2+1][DefaultSettings.rows * 2+1];
			int r[][]=new int[DefaultSettings.cols*2+1][DefaultSettings.rows * 2+1];
			for(int j=0;j<=DefaultSettings.cols*2;j++){
				for(int i=0;i<=DefaultSettings.rows*2;i++){
					r[j][i]=t[i][DefaultSettings.cols*2-j];
				}
			}
		}
		catch ( Exception e)
		{
			System.out.println("La methode Rotation a rencontree une erreur");
		}
	}

	public void testRotationMatrice() {
		try {
			Matrix m=new MatrixImpl();
			m.mat=m.rotation(this.mat);
		}
		catch ( Exception e)
		{
			System.out.println("La methode RotationMatrice a rencontree une erreur");
		}
	}

	public void testSymAbscisse() {
		try {
			Matrix m = new MatrixImpl();
			DefaultSettings.rows = 4;
			DefaultSettings.cols = 2;
			for(int j=0; j<=DefaultSettings.rows*2; j++){
				for(int i=0; i<=DefaultSettings.cols*2; i++){
					m.mat[j][i]=mat[DefaultSettings.rows*2-j][i];
				}
			}
		}
		catch ( Exception e)
		{
			System.out.println("Probl�me lors de la symetrie abscisse");
		}
	}

	public void testSymOrdonnee() {
		try {
			Matrix m = new MatrixImpl();
			DefaultSettings.rows = 4;
			DefaultSettings.cols = 4;
			for(int j=0; j<=DefaultSettings.rows*2; j++){
				for(int i=0; i<=DefaultSettings.cols*2; i++){
					m.mat[j][i]=this.mat[j][DefaultSettings.cols*2-i];
				}
			}
		}
		catch ( Exception e)
		{
			System.out.println("Probl�me lors de la symetrie ordonnee");
		}
	}


	public void testFindSqr() {
		try {

			DefaultSettings.rows = 8;
			DefaultSettings.cols = 8;
			int mat[][] = new int [DefaultSettings.rows][DefaultSettings.cols];
			for(int j=DefaultSettings.rows*2-1; j>0; j-=2){
				for(int i=DefaultSettings.cols*2-1; i>0; i-=2){
					if( this.mat[j][i]==2){
						int val1= this.mat[j][i+1];
						int val2= this.mat[j][i-1];
						int val3= this.mat[j-1][i];
						int val4= this.mat[j+1][i];
						if( (val1==1 && val2==1 && val3==1 && val4==0)){
							Pair p= new Pair(j+1, i);
							return;
						}
						if((val1==1 && val2==1 && val3==0 && val4==1) ){
							Pair p= new Pair(j-1, i);
							return;
						}
						if((val1==1 && val2==0 && val3==1 && val4==1) ){
							Pair p= new Pair(j, i-1);
							return;
						}
						if((val1==0 && val2==1 && val3==1 && val4==1) ){
							Pair p= new Pair(j, i+1);
							return;
						}
					}
				}
			}
		}
		catch ( Exception e)
		{
			System.out.println("Erreur lors de la m�thode findSqr");
		}
	}


	public void testRestLine() {
		try { 
			DefaultSettings.rows = 8;
			DefaultSettings.cols = 6;
			int n=0;
			for(int j=DefaultSettings.rows*2; j>=0; j--){
				for(int i = DefaultSettings.cols*2; i>=0; i--){
					if(this.mat[j][i] ==0){
						n++;
					}
				}
			}
		}
		catch ( Exception e)
		{
			System.out.println("Erreur lors de la methode RestLine");
		}
	}

}
