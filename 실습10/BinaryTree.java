import java.util.*;

public class BinaryTree {
	private int[] tree;
	private int size;

	public BinaryTree(int size) {
		tree = new int[size];
		this.size = size;
		for (int i = 0; i < size; i++) {
			tree[i] = i;
		}
	}

	public BinaryTree(int size, int seed) {
		Random random = new Random(seed);
		tree = new int[size];
		this.size = size;
		for (int i = 0; i < size; i++) {
			tree[i] = random.nextInt(10);
		}
	}

	public int size() {
		return size;
	}

	public void levelOrder() {
		for (int i = 0; i < size; i++) {
			System.out.print(tree[i] + " ");
		}
		System.out.println(" ");
	}

	public void PreOrder(int index) {
		if (index >= tree.length)
			return;
		System.out.print(tree[index] + " ");
		PreOrder(2 * index + 1);
		PreOrder(2 * index + 2);
	}
}
