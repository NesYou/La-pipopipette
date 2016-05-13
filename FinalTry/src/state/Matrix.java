package state;

import java.util.Arrays;

import javax.swing.text.Position;

import game.*;
public class Matrix {

	public int mat[][];

	/**
	 * Creer la matrice racine
	 */
	public Matrix(){
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

	public Matrix addMvn(int motion){
		Pair p = new Pair();
		p = p.convertToMap(motion, mat);
		mat[p.getFst()][p.getSnd()]=1;
		return this;
	}

	/**
	 * Creer une matrice à partir d'un plateau
	 * @param board le plateau à transformer en matrice
	 */
	public Matrix(Board board){
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


	/**
	 * Recopie d'une matrice passee en parametre
	 * @param m Matrice a recopier
	 */
	public Matrix(Matrix m){
		this.mat = m.mat;
	}

	/**
	 * Effectue la rotation de la mat de t
	 * @param t
	 * @return
	 */
	public int[][] rotation(int[][] t){
		int r[][]=new int[DefaultSettings.cols*2+1][DefaultSettings.rows * 2+1];
		for(int j=0;j<=DefaultSettings.cols*2;j++){
			for(int i=0;i<=DefaultSettings.rows*2;i++){
				r[j][i]=t[i][DefaultSettings.cols*2-j];
			}
		}

		return r;
	}

	/**
	 * Rotation de la matrice this
	 * @return la matrice ayant subit une rotation
	 */
	public Matrix rotationMatrice() {
		Matrix m=new Matrix();
		m.mat=rotation(this.mat);
		return m;

	}

	/**
	 * Symetrie par rapport aux abscisses
	 * @return la matrice echange par rapport à l'axe des abscisses
	 */
	public Matrix symAbscisse(){

		Matrix m = new Matrix();
		for(int j=0; j<=DefaultSettings.rows*2; j++){
			for(int i=0; i<=DefaultSettings.cols*2; i++){
				m.mat[j][i]=mat[DefaultSettings.rows*2-j][i];
			}
		}
		return m;
	}

	/**
	 * Symetrie par rapport aux ordonnees
	 * @return la matrice echange par rapport à l'axe des ordonnees
	 */
	public Matrix symOrdonnee(){
		Matrix m=new Matrix();
		for(int j=0; j<=DefaultSettings.rows*2; j++){
			for(int i=0; i<=DefaultSettings.cols*2; i++){
				m.mat[j][i]=this.mat[j][DefaultSettings.cols*2-i];
			}
		}
		return m;

	}

	/**
	 * Affichage d'une matrice.
	 * @return la String representant la matrice graphiquement
	 */
	public String toString(){
		String display="Matrice : \n ";
		for(int j=0; j<= DefaultSettings.rows*2; j++){
			for(int i=0; i<= DefaultSettings.cols * 2; i++){
				if(mat[j][i]==0){
					display+=" 0 ";
				}
				if(mat[j][i]==1){
					display+=" 1 ";
				}
				if(mat[j][i]==2){
					display+=".";
				}
			}
			display+="\n";
		}	
		return display;
	}


	/**
	 * Verifie que m est symetrique de this
	 * @param m
	 * @return
	 */
	private boolean isSymetric(Matrix m) {
		Matrix m2, m3;
		Matrix m1 = new Matrix(m);
		if(DefaultSettings.cols == DefaultSettings.rows){
			for(int n=0; n<4; n++){
				m2= m1.symAbscisse();
				m3= m2.symOrdonnee();
				m1= m1.rotationMatrice();

				if(Arrays.deepEquals(this.mat, m1.mat)){
					return true;	
				}
				if(Arrays.deepEquals(this.mat, m2.mat)){
					return true;
				}
				if(Arrays.deepEquals(this.mat, m3.mat)){
					return true;
				}
			}
		}else{
			m2= m1.symAbscisse();
			m3= m2.symOrdonnee();
			if(Arrays.deepEquals(this.mat, m2.mat)){
				return true;
			}
			if(Arrays.deepEquals(this.mat, m3.mat)){
				return true;
			}
		}
		return false;
	}


	public int findSqr(){
		for(int j=DefaultSettings.rows*2-1; j>0; j-=2){
			for(int i=DefaultSettings.cols*2-1; i>0; i-=2){
				if( this.mat[j][i]==2){
					int val1= this.mat[j][i+1];
					int val2= this.mat[j][i-1];
					int val3= this.mat[j-1][i];
					int val4= this.mat[j+1][i];
					if( (val1==1 && val2==1 && val3==1 && val4==0)){
						Pair p= new Pair(j+1, i);
						return p.convertToLng(mat);
					}
					if((val1==1 && val2==1 && val3==0 && val4==1) ){
						Pair p= new Pair(j-1, i);
						return p.convertToLng(mat);
					}
					if((val1==1 && val2==0 && val3==1 && val4==1) ){
						Pair p= new Pair(j, i-1);
						return p.convertToLng(mat);
					}
					if((val1==0 && val2==1 && val3==1 && val4==1) ){
						Pair p= new Pair(j, i+1);
						return p.convertToLng(mat);
					}
				}
			}
		}
		return -1;
	}




	public int restLine() {
		int n=0;
		for(int j=DefaultSettings.rows*2; j>=0; j--){
			for(int i = DefaultSettings.cols*2; i>=0; i--){
				if(this.mat[j][i] ==0){
					n++;
				}
			}
		}
		return n;
	}



	@Override
	public int hashCode() {
		int n = 0;
		Matrix m = new Matrix(this);


		if(DefaultSettings.cols == DefaultSettings.rows){
			for (int i = 0; i < 4; i++) {
				n = Math.max(n, Arrays.deepHashCode((m.symAbscisse().mat)));
				n = Math.max(n, Arrays.deepHashCode((m.symAbscisse().mat)));
				m= m.rotationMatrice();
			}
		}else{
			n = Math.max(n, Arrays.deepHashCode((m.mat)));
			n = Math.max(n, Arrays.deepHashCode((m.symAbscisse().mat)));
			n = Math.max(n, Arrays.deepHashCode((m.symOrdonnee().mat)));
		}

		return n;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matrix other = (Matrix) obj;
		if (Arrays.deepEquals(mat, other.mat))
			return true;
		if(this.isSymetric(other))
			return true;
		return false;
	}










}
