import java.util.ArrayList;

public class BST {
	private Comparable key;
	private BST left, right;
	private int size;

	private class Node implements Comparable {
		public int key;

		public Node(int key) {
			this.key = key;
		}

		@Override
		public int compareTo(Object other) {
			if (this.key < (int) other)
				return 1;
			else if (this.key == (int) other)
				return 0;
			else
				return -1;
		}
	}

	public BST() {
	}

	public BST(int key) {
		this.key = new Node(key);
		this.left = null;
		this.right = null;
		this.size = 1;
	}

	public int getKey() {
		Node a = (Node) this.key;
		return a.key;
	}

	public int treesize() {
		return this.size;
	}

	public boolean recu_insert(int key) {
		if (this.key == null) {
			this.key = new Node(key);
			this.size = 1;
			return true;
		} else if (this.key.compareTo(key) < 0) { // 왼쪽 서브트리
			if (left != null) {
				left.recu_insert(key);
			} else { // null인 경우
				left = new BST(key);
			}
			this.size++;
		} else if (this.key.compareTo(key) > 0) { // 오른쪽 서브트리
			if (right != null) {
				right.recu_insert(key);
			} else { // null인 경우
				right = new BST(key);
			}
			this.size++;
		} else
			return false;

		return true;
	}

	public boolean iter_insert(int key) {
		BST tree = this;
		ArrayList<BST> stack = new ArrayList<BST>();

		while (true) {
			if (tree.key == null) {
				tree.key = new Node(key);
				tree.size++;
				break;
			}

			else if (tree.key.compareTo(key) < 0) {
				if (tree.left == null)
					tree.left = new BST();
				else {
					stack.add(tree);
					tree = tree.left;
				}
			}

			else if (tree.key.compareTo(key) > 0) {
				if (tree.right == null)
					tree.right = new BST();
				else {
					stack.add(tree);
					tree = tree.right;
				}
			}

			else
				return false;
		}

		while (stack.size() > 0) {
			(stack.remove(stack.size() - 1)).size++;
		}

		return true;
	}

	public void inorder() {
		if (left != null)
			left.inorder();
		System.out.println("Visited : " + getKey() + "	" + "Treesize : " + size);
		if (right != null)
			right.inorder();

	}
}
