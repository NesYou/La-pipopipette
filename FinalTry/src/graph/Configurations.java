package graph;

import java.util.*;

/**
 * 
 * @author elsacollet
 *
 * @param <K>
 * @param <V>
 * Permet d'éviter de faire les mêmes calcules
 */
public class Configurations<K,V> implements Function<K,V>{
	HashMap<K,V> map;
	Function<K,V> f;
	
	public Configurations(Function<K,V> f1){
		this.map=new HashMap<K, V>();
		this.f=f1;
	}
	
	@Override
	public V get(K k) {
		V v = map.get(k);
		if(v==null){
			v=f.get(k);
			map.put(k, v);
		}
		return v;
	}
}
