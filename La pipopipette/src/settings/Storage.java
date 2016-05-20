package settings;

import java.util.HashSet;

/**
 * @author Elsa Collet
 **/

public class Storage {

	Board lng;
	Matrix mat;

	/** Constructeur de la classe Storage
	 * 
	 */

	public Storage(){
		this.lng = new Board();
		this.mat = new Matrix(this.lng);
	}

	/** Constructeur de classe Storage
	 * 
	 * @param b
	 */

	public Storage(Board b){
		this.lng=new Board(b);
		this.mat = new Matrix(this.lng);
	}

	/**Constructeur de la classe Storage
	 * 
	 * @param st
	 */

	public Storage(Storage st){
		this.lng = new Board(st.lng);
		this.mat =  new Matrix(st.lng);
	}

	/**Constructeur de la classe Storage
	 * 
	 * @param b
	 * @param m
	 */

	public Storage(Board b, Matrix m){
		this.lng=new Board(b);
		this.mat =  new Matrix(m);
	}

	public void addMotiontUser(int pos){

		int i;
		i=(DefaultSettings.nbLines-1) - (pos-1);
		addMotion(i);

	}
	public void addMotion(int pos){
		this.lng.addMvn(pos);
		this.mat = new Matrix(lng);
	}

	/** toString() de la classe Storage
	 * 
	 */

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



	/** Methode equals de la classe Storage
	 * 
	 */

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

	public Storage completeSquare1() {
		this.mat = new Matrix(this.lng);
		int mvn =  findSqr();
		Storage p = null;
		if(mvn >=0){
			p =  new Storage(lng);
			p.addMotion(mvn);
			p = p.completeSquare1();
		}
		if(p != null){
			return p;
		}
		return this;
	}
	public void completeSquare(){
		Storage s = new Storage(this);
		s= this.completeSquare1();
		this.lng = new Board(s.lng);
		this.mat = new Matrix(s.mat);
	}
	public int findSqr(){
		return mat.findSqr();

	}
	public HashSet<Integer> possibleMotion() {

		return lng.possibleMotion();
	}
	public int getWeight() {

		return lng.nbSquares();
	}
	public HashSet<Integer> possibleMotionUser() {
		HashSet<Integer> mvn = new HashSet<>();
		Iterable<Integer> it = possibleMotion(); 
		for(int i : it){
			mvn.add(DefaultSettings.nbLines-i);
		}
		return mvn;
	}


}
