/*
 * getNode(index)
 * addToTail 
 * addToFront
 * insertAt
 * remove
 * removeAll
 * print
 * getLength
 * getMiddleNode
 * deleteLinkedList
 * countElement
 */

public class LinkedList {
	int data;
	LinkedList next;

	public LinkedList(int data) {
		this.data = data;
		this.next = null;
	}

	public int getElementCount(int key) {
		LinkedList head = this;	
		int count = 0;
		while(head != null) {
			if(head.data == key) count++;
			head = head.next; 
		}
		return count;
	}

	public void deleteLinkedList() {
		LinkedList current = this;
		LinkedList next = null;
		while(current != null) {
			next = current.next;
			// free;
			current.next = null;
			current = next;
		}
	}

	public LinkedList getMiddleNode() {
		LinkedList slow = this;
		LinkedList fast = this;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;

	}

	public int getLength() {
		LinkedList temp = this;
		int len = 0;
		while(temp != null)  {
			temp = temp.next;
			len++;
		}

		return len;
	}

	public LinkedList getNode(int position) {
		if(position == 0) return this;
		else {
			LinkedList temp = this;
			while(position > 1 && temp != null) {
				position--;
				temp = temp.next;

			}
			return temp;
		}
	}

	public LinkedList remove(int key) {
		LinkedList head = this;
		LinkedList temp = this;
		// if head is removed
		if(temp != null && temp.data == key) {
			return temp.next;
		}
		while(temp.next != null) {
			if(temp.next.data == key) {
				temp.next = temp.next.next;
				break;
			} else{
				temp = temp.next;
			}
		}
		return head;
		
	}

	public LinkedList removeAll(int key) {
                LinkedList head = this;                                             
                LinkedList temp = this;                                            

                // if head is removed                                                    
                if(temp != null && temp.data == key) {
                        //return temp.next;
			head = temp.next;
			temp = head;
                }

                while(temp.next != null) {
                        if(temp.next.data == key) {
                                temp.next = temp.next.next;
                        } else{
                                temp = temp.next;
                        }
                }

                return head;
        } 

	public void addToTail(int data) {
		LinkedList head = this;
		LinkedList node = new LinkedList(data);
		while(head.next != null) {
			head = head.next;
		}
		head.next = node;
	}

	public LinkedList addToFront(int data) {
		LinkedList head = new LinkedList(data);
		head.next = this;
		return head;
	}	

	public LinkedList insertAt(int position, int data){
		if(position >= 0) {		
			LinkedList node = new LinkedList(data);
			if(position == 0) 
				return addToFront(data);
			else {
				LinkedList temp = this;
				LinkedList head = this;
				while(position > 1 && temp != null) {
					temp = temp.next;
					position--;
				}
				node.next = temp.next;
				temp.next = node;
				return head;
			}
		} else {
			return this;
		}
	}

	public void print() {
		LinkedList head = this;
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}
