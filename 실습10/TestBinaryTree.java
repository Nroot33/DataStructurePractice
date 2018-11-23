
public class TestBinaryTree {
	public static void main(String[] args) {
		
		BinaryTree tree2 = new BinaryTree(9,10);
		System.out.println("tree1");
		System.out.print("levelOrder : ");
		tree2.levelOrder();
		System.out.print("PreOrder : ");
		tree2.PreOrder(0);
		
		System.out.println(" ");
		
		BinaryTree tree1 = new BinaryTree(9);
		System.out.println("tree2");
		System.out.print("levelOrder : ");
		tree1.levelOrder();
		System.out.print("PreOrder : ");
		tree1.PreOrder(0);
	}
}
