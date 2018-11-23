public class LinkedList {

	private Node startNode;
	private Node lastNode;
	private int size = 0;

	public LinkedList() {

	}

	public void insertfirst(int x) {
		Node first = new Node(x);
		first.setNext(startNode);
		startNode = first;
		size++; //
		if (startNode.Next() == null) {
			lastNode = startNode;
		}
	}

	public void insertlast(int x) {
		Node last = new Node(x);
		if (size == 0) {
			insertfirst(x);
		} else {
			lastNode.setNext(last);
			lastNode = last;
			size++;
		}
	}

	public boolean contain(int x) {
		if (startNode.Value() == x) {
			return true;
		}
		while (startNode.Next() != null) {
			startNode = startNode.Next();
			if (startNode.Value() == x) {
				return true;
			}
		}
		return false;
	}

	public void print() {
		Node temp = startNode;
		System.out.print("List : ");
		while (temp != null) {
			System.out.print(temp.Value() + " ");
			temp = temp.Next();
		}
		System.out.println();
	}

}