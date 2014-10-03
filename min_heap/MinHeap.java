public class MinHeap {

	private int[] heap;
	private int size;
	private int maxsize;

	private static final int FRONT = 1;

	public MinHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		heap = new int[this.maxsize + 1];
		heap[0] = Integer.MIN_VALUE;
	}

	public int parent(int pos) {
		return pos/2;
	} 

	public int leftChild(int pos) {
		return 2 * pos;
	}

	public int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	public boolean isLeaf(int pos) {
		if(pos >= (size/2) && pos <= size) {
			return true;
		}
		return false;
	}

	public void swap(int fpos, int spos) {
		int tmp;
		tmp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = tmp;
	}

	public void minHeapify(int pos) {
		if(!isLeaf(pos)) {
			if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
				if(heap[leftChild(pos)] > heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				} else{
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}

	public void insert(int element) {
		heap[++size] = element;
		int current = size;

		while(heap[current] < heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public int remove() {
		int popped = heap[FRONT];
		heap[FRONT] = heap[size--];
		minHeapify(FRONT);
		return popped;
	}

	public void minHeap() {
		for(int pos = (size/2); pos >= 1; pos--) {
			minHeapify(pos);
		}
	}

	public void print() {
		for(int i = 1; i <= size/2; i++) {
			System.out.print(" Parent: "+heap[i] + " Left: " +heap[2*i] +" Right: " + heap[2*i+1]);
			System.out.println();
		}
	}

	public String toString() {
		String s = "";
		for(int i = 0; i < size; i++) {
			s += heap[i] + " ";
		}
		return s;
	}

}
