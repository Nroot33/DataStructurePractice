
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
		} else if (this.key.compareTo(key) < 0) { // ���� ����Ʈ��
			if (left != null) {
				left.recu_insert(key);
			} else { // null�� ���
				left = new BST(key);
			}
			this.size++;
		} else if (this.key.compareTo(key) > 0) { // ������ ����Ʈ��
			if (right != null) {
				right.recu_insert(key);
			} else { // null�� ���
				right = new BST(key);
			}
			this.size++;
		} else
			return false;

		return true;
	}

	public void inorder() {
		if (left != null)
			if (left.key != null)
			left.inorder();
		System.out.println("Visited : " + getKey() + "	" + "Treesize : " + size);
		if (right != null)
			if (right.key != null)
			right.inorder();

	}

	public boolean delete(int key) {

		if (this.key == null) { // �ƹ��͵� ���� ��
			return false;
		} else if (this.key.compareTo(key) < 0) { // ����
			if (left.delete(key) == false) {
				left = null;
			}
			this.size--;
		}

		else if (this.key.compareTo(key) > 0) { // ������
			if (right.delete(key) == false) {
				right = null;
			}
			this.size--;
		}

		else if (this.key.compareTo(key) == 0) {// ���� ����
			if (this.left == null && this.right == null) { // �����ؾ� �ϴ� ��尡 ���� ��� �� ���
				this.key = null;
				this.size--;
			}

			else if (this.left != null && this.right == null) { // �ڽ� 1�� -> �����ڽĸ� ����
					BST temp = this.left;
					this.key = temp.key;
					this.left = temp.left;
					this.right = temp.right;
					temp = null;
					this.size--;
			}

			else if (this.left == null && this.right != null) { // �ڽ� 1�� -> ������ �ڽĸ� ����
				BST temp = this.right;
				this.key = temp.key;
				this.left = temp.left;
				this.right = temp.right;
				temp = null;
				this.size--;
			}

			else if (this.left != null && this.right != null) { // �ڽ� 2��
				this.key = deleteMinimum(this);
				this.size--;
				System.out.println("Alternative Node : " + getKey());
			}

			else
				return false;
		}
		return true;
	}

	public Comparable deleteMinimum(BST T) {
		BST parent = this;
		BST temp = this.right;
	
		if (temp.left == null) {
			this.key = temp.key;
			this.right = temp.right;
			parent.size--;
			return this.key;
		} 
		
		else if (temp.left != null) {
			temp = temp.left;
			parent = parent.right;

			while (temp.left != null) {
				temp = temp.left;
				parent = parent.left;
			}

			this.key = temp.key;

			if (temp.right == null) {
				parent.left = null;
				parent.size--;

			} else if (temp.right != null) {
				parent.left.key = temp.right.key;
				parent.left = temp.right;
				parent.size--;
			}
			return this.key;
		}
		return key;
		}
}
