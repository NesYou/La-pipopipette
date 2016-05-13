package state;

import game.DefaultSettings;

public class Pair {

	private int y, x;

	public Pair(){
		x=-1;
		y=-1;
	}
	public Pair(int y, int x){
		this.y=y;
		this.x=x;
	}
	public int convertToLng(int[][] mat){
		int n=-1;
		for(int j=DefaultSettings.rows*2; j>=0; j--){
			for(int i = DefaultSettings.cols*2; i>=0; i--){
				if(mat[j][i] !=2){
					n++;
				}if(j==y && i==x){
					return n;
				}
			}
		}
		return n;
	}


	public Pair convertToMap(int pos, int[][] mat){
		Pair p=null;
		int n=0;
		for(int j=DefaultSettings.rows*2; j>=0; j--){
			for(int i = DefaultSettings.cols*2; i>=0; i--){
				if(mat[j][i] !=2){
					if(n==pos){			
						x=i;
						y=j;
						return this;
					}else{
						n++;
					}
				}
			}
		}
		return this;
	}


	public boolean isEmpty(){
		if(x == -1 && y == -1){
			return true;
		}
		return false;
	}
	public int getFst(){
		return y;
	}
	public int getSnd(){
		return x;
	}
}
