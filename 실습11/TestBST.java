
public class TestBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BST a= new BST();
		
		a.recu_insert(5);
		a.recu_insert(10);
		a.recu_insert(1);
		a.recu_insert(3);
		a.recu_insert(7);
		a.inorder();
		
		
		System.out.println("----------------------------");
		
		a.iter_insert(13);
		a.iter_insert(11);
		a.iter_insert(15);
		a.iter_insert(12);
		a.inorder();
	}

}
