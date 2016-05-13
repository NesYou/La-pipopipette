package state;

import java.util.*;

import game.DefaultSettings;

public class Storage {

	Board lng;
	Matrix mat;
	
	public Storage(){
		this.lng = new Board();
		this.mat = new Matrix(lng);
	}
	public Storage(Board b){
		this.lng=b;
		this.mat = new Matrix(b);
	}
	
	public Storage(Storage st){
		this.lng = st.lng;
		this.mat = st.mat;
	}
	public Storage(Board b, Matrix m){
		this.lng=b;
		this.mat=m;
	}
	
	public void addMotiontUser(int pos){
		int i;
		i=(DefaultSettings.nbLines-1) - (pos-1);
		addMotion(i);
	}
	public void addMotion(int pos){
		this.lng.addMvn(pos);
		this.mat.addMvn(pos);
	}
	
	public String toString(){
		return lng.toString(true);
	}
	public String toDot(){
		return lng.toString(false);
	}

	public int nbSquares(){
		return lng.nbSquares();
	}
	

	public Board getBoard(){
		return lng;
	}
	public Long getBoardGame() {
		return lng.getBoardGame();
	}

	public void setBoard(Board lng) {
		this.lng = lng;
	}

	public Matrix getMatrix() {
		return mat;
	}

	public void setMatrix(Matrix mat) {
		this.mat = mat;
	}
	public void setMatrix(Board b) {
		this.mat = new Matrix(b);
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Storage other = (Storage) obj;
		if (mat == null) {
			if (other.mat != null)
				return false;
		} else if (!mat.equals(other.mat))
			return false;
		return true;
	}
	
	public int restLine() {
		return mat.restLine();
	}

	public int hashCode() {
		int result = 0;
		result = ((mat == null) ? 0 : mat.hashCode());
		return result;
	}
	public Storage completeSquare() {
		int mvn =  findSqr();
		Storage p = null;
		if(mvn >=0){
			p =  new Storage(lng);
			p.addMotion(mvn);
			p = p.completeSquare();
		}
		if(p != null){
			return p;
		}
		return this;
	}
	public int findSqr(){
		return mat.findSqr();
		
	}
	public Iterable<Integer> possibleMotion() {
		
		return lng.possibleMotion();
	}
	
	
}
