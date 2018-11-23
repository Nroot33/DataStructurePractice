public class SLinkedQueue implements Queue {

	private Node head;
	private Node rear;
	private int size;

	private static class Node {
		Object object;
		Node next;

		Node(Object object) {
			this.object = object;
		}

	}

	public SLinkedQueue() {
		head = null;
		rear = null;
		size = 0;
	}

	public void add(int n) {
		Node p = new Node(n);
		if (isEmpty()) {
			head = p;
			rear = p;
		} else {
			rear.next = p;
			rear = p;
		}
		size++;
	}

	public Object first() {
		if (size == 0)
			System.out.println("Empty");
		return head.object;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Object remove() {
		Node p=head;

		if (isEmpty())
			return null;
		else {
			p = head;
			head = p.next;
			size--;
			return p.object;
		}
		

	}

	public int size() {
		return size;
	}

	ArrayQueue toArrayQueue(){
		ArrayQueue Q3 = new ArrayQueue(10);
		for(Node p = head; p!=null; p = p.next)
			Q3.add((int) p.object);
		return Q3;
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer("Singly Linked Queue : head" );
		Node p = head;

		while (p != null) {
			if (p.object == null)
				buf.append(" ");
			else
				buf.append(" -> " + p.object);
			p = p.next;
		}
		return buf.toString();
	}

}
