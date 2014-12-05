import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LRUCache<K, V> {
	private final int capacity;
	private ConcurrentLinkedQueue<K> queue;
	private ConcurrentHashMap<K, V> map;

	public LRUCache(final int capacity) {
		this.capacity = capacity;
		this.queue = new ConcurrentLinkedQueue<K>();
		this.map = new ConcurrentHashMap<K, V>(capacity);
	
	}

	// if null doesn't exist in cache
	public V get(final K key) {
		return map.get(key);
	}

	public synchronized void put(final K key, final V value) {
		if(key == null || value == null) {
			throw NullPointerException();
		}

		if(map.containsKey(key)) {
			map.remove(key);
		}

		while(queue.size() >= capacity) {
			K expired = queue.poll();
			if(expired != null) {
				map.remove(expired);
			}
		}

		queue.add(key);
		map.put(key, value);

	}

	public static void main(String args[]) {

	}
}
