package settings;

/**
 * @author Elsa Collet
 **/

public interface Function<K,V> {
	public V get(K k);

	public int size(K k);

	public String toDot();


}
