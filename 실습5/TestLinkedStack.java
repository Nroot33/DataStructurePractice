
public class TestLinkedStack {

	public static void main(String[] args) {
		LinkedStack a = new LinkedStack();

		for (int i = 1; i < 6; i++) {
			a.push(i);
			System.out.println("Push : " + i );
		}

		System.out.println("Current Elmentss of stack : top -> " + a.toString());

		
		a.removesecond();
		System.out.println(" ");
		System.out.println("removesecond()");
		System.out.println("Removed Node : 4");
		System.out.println("Current Elmentss of stack : top -> " + a.toString());

		a.reverse();
		System.out.println(" ");
		System.out.println("reverse()");
		System.out.println("Current Elmentss of stack : top -> " + a.toString());
	}

}
