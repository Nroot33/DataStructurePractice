public class SLinkedQueue implements Queue {

	private class Node {
		Object object;
		Node next;

		Node(Object object) {
			this.object = object;
		}

		Node(Object object, Node next) {
			this.object = object;
			this.next = next;
		}
	}

	private Node head;
	private Node rear;
	private int size;

	@Override
	public void add(Object object ) {
		Node p = new Node(object);
		if (empty()) {
			head = p;
			rear = p;
		} else {
			rear.next = p;
			rear = p;
		}
		size++;
	}

	@Override
	public Object first() {
		if (size == 0)
			System.out.println("Empty");
		return head.object;

	}

	@Override
	public Object remove() {
		Node p = head;
		if (empty())
			return null;
		else {
			p = head;
			head = p.next;
			size--;
			return p.object;
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	public boolean empty() {
		return this.head == null;
	}

	public void print() {
		System.out.println(this.toString() + "\n");
	}

	public String toString() {
		String str = " * Singly Linked Queue = head";

		Node ptr = this.head;

		while (ptr != null) {
			str = str + " -> " + ptr.object;
			ptr = ptr.next;
		}
		return str;
	}
}
