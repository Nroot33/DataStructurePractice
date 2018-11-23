
public class ArrayQueue implements Queue {

	private Object[] q;
	private int size;
	private int front = -1;
	private int rear = -1;

	public ArrayQueue(int n) {
		q = new Object[n];
	}

	public void add(int n) {
		if (rear == q.length - 1)
			System.out.println("Full");
		q[rear + 1] = n;
		rear = rear + 1;
		++size;
	}

	public Object first() {
		if (front == rear)
			System.out.println("Empty");
		Object temp = q[front + 1];
		return temp;
	}

	public Object remove() {
		if (front == rear)
			System.out.println("Empty");
		Object temp = q[front + 1];
		front = front + 1;
		q[front] = null;
		--size;
		return temp;
	}

	public boolean isEmpty() {
		return size ==0;
	}
	
	public int size() {
		return size;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer("ArrayQueue : [");
		int index = 0;
		while (index <= rear) {
			if (q[index] == null) {
				buf.append(" 0");
				++index;
			} else
				buf.append(" " + q[index++].toString());
		}
		buf.append(" ] (front : " + Integer.toString(front) + ", rear : " + Integer.toString(rear) + ")");
		return buf.toString();
	}

}
