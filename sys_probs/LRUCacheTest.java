import java.util.HashMap;

public class LRUCacheTest {	
	public static void main(String args[]) {
		LRUCacheImpl lru = new LRUCacheImpl(5);
		for(int i = 1; i < 10; i++) {
			lru.set(i, i*i);
		}

		System.out.println("" + lru.get(7));
		System.out.println("" + lru.get(11));
	}
}

class LRUCacheImpl {
	private HashMap<Integer, DLinkedList> map = new HashMap<Integer, DLinkedList>();
	private DLinkedList head;
	private DLinkedList end;
	private int capacity;
	private int length;

	public LRUCacheImpl(int capacity) {
		this.capacity = capacity;
		this.length = length;
	}

	public int get(int key) {
		if(map.containsKey(key)) {
			DLinkedList latest = map.get(key);
			removeNode(latest);
			setHead(latest);
			return latest.value;

		} else{
			return -1;
		}
	}

	private void removeNode(DLinkedList node) {
		DLinkedList cur = node;
		DLinkedList prev = cur.prev;
		DLinkedList next = cur.next;

		if(prev != null) prev.next = next;
		else head = next;

		if(next != null) next.prev = prev;
		else end = prev;

	}

	private void setHead(DLinkedList node) {
		node.next = head;
		node.prev = null;
		
		if(head != null) head.prev = node;
		head = node;
		if(end == null) end = node;

	}

	public void set(int key, int value) {
		if(map.containsKey(key)) {
			DLinkedList oldNode = map.get(key);
			oldNode.value = value;
			removeNode(oldNode);
			setHead(oldNode);
	
		} else {
			DLinkedList newNode = new DLinkedList(key, value);
			if(length < capacity) {
				setHead(newNode);
				map.put(key, newNode);
				length++;
			} else {
				map.remove(end.key);
				end = end.prev;
				if(end != null) end.next = null;
				setHead(newNode);
				map.put(key, newNode);
			}
		}
	}

}

class DLinkedList {
	int key;
	int value;
	DLinkedList next;
	DLinkedList prev;

	public DLinkedList(int key, int value) {
		this.key = key;
		this.value = value;
	}
}


