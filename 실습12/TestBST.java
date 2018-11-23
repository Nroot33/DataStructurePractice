
public class TestBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BST a= new BST();
		
		
		System.out.println("========== insert ==========");
		
		a.recu_insert(5);
		a.recu_insert(10);
		a.recu_insert(1);
		a.recu_insert(3);
		a.recu_insert(7);
		a.recu_insert(13);
		a.recu_insert(11);
		a.recu_insert(15);
		a.recu_insert(12);
		a.inorder();
		
		System.out.println("========== delete ==========");
		
		a.delete(12);
		a.delete(1);
		a.delete(10);
		a.inorder();
		
	
	}

}
