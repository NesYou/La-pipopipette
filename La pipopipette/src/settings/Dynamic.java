package settings;

import java.util.HashMap;

/**
 * @author Elsa Collet
 * Elle implémente Function<K, V>,  
 * c'est la classe mère, polymorphe,
 * dont hérite toutes les stratégies.
 * */

public class Dynamic<K,V> implements Function<K,V> {

	protected HashMap<K,V> map;
	Function<K,V> f;
	State root;


	public Dynamic(){
		this.map=new HashMap<K, V>();
		f=null;
	}
	public Dynamic(Function<K,V> f1){
		this.map=new HashMap<K, V>();
		f=f1;		
	}

	public void setFunction(Function<K,V> f1){
		f=f1;	
	}

	public V get(K k) {
		V v = map.get(k);
		if(v==null){
			v=f.get(k);
			map.put(k, v);
		}
		return v;
	}

	public HashMap<K,V> getMap(){
		return map;
	}


	@Override
	public int size(K k) {
		int n= f.size(k);
		return n;
	}

	public void put(K k, V v) {
		map.put(k, v);

	}

	public String toDot() {
		return f.toDot();
	}
	
}



























