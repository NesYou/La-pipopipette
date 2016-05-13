package graph;

import java.util.*;

import state.*;

public class Dynamic<K,V> implements Function<K,V> {

	protected HashMap<K,V> map;
	Function<K,V> f;
	State root;
	
	
	public Dynamic(){
		this.map=new HashMap<K, V>();
		f=null;
	}
	public Dynamic(Function<K,V> f1){
		State root = new State();
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
	
}
