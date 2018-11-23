
public class TestQueue {
	public static void main(String[] args) {
		
		ArrayQueue Q1 = new ArrayQueue(10);
		for (int i = 1; i < 6; i++) {
			Q1.add(i);
		}

		System.out.println(Q1.toString());

		Q1.remove();
		Q1.remove();
		
		System.out.println(Q1.toString());
		
		//
		
		SLinkedQueue Q2 = new SLinkedQueue();
		
		for (int i = 6; i < 10; i++) {
			Q2.add(i);
		}
		
		System.out.println(Q2.toString());
		
		Q2.remove();
		Q2.remove();
		Q2.remove();
		Q2.remove();
		
		System.out.println(Q2.toString());
		
		Q2.add(10);
		Q2.add(11);
		Q2.add(12);
		
		System.out.println(Q2.toString());
		
		System.out.println("[Change from SLinked_Q to Array_Q]");
		
		ArrayQueue Q4 = Q2.toArrayQueue();
		
		System.out.println(Q4.toString());
	}
}
