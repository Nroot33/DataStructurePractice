public class Node {
	
	private int value;
	private Node next;

	public Node() {
	}

	public Node(int value) {
		this.value = value;
	}

	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}

	public int Value() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node Next() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}