public class LinkedStack {

	private Node top = new Node();
	private int size;

	public LinkedStack() {
		size = 0;
		top = null;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public Object peek() {
		if (size == 0)
			throw new IllegalStateException("Stack is empty");
		return top.object;
	}

	public Object pop() {
		if (size == 0)
			throw new IllegalStateException("Stack is empty");
		Object object = top.object;
		top = top.next;
		--size;
		return object;
	}

	public void push(Object object) {
		top = new Node(object, top);
		++size;
	}

	public int size() {
		return size;
	}

	public void reverse() {
		Node p = top;
		for (int i = 1; i <= size - 1; i++) {
			Node temp = p.next;
			p.next = temp.next;
			temp.next = top;
			top = temp;
		}
	}

	public Object removesecond() {
		if (size == 0)
			throw new IllegalStateException("Stack is empty");

		Object object = top.next.object;
		top.next = top.next.next;
		--size;
		return object;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer(Integer.toString((int) top.object));
		Node p = top.next;
		while (p != null) {
			buf.append(" -> " + p.object);
			p = p.next;
		}
		return buf.toString();
	}

	private static class Node {
		Object object;
		Node next;

		public Node() {
		}

		public Node(Object object, Node next) {
			this.object = object;
			this.next = next;
		}

	}
}
