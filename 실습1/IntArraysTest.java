
public class IntArraysTest {

	public static void main(String[] args) {
		IntArrays a = new IntArrays(10);
		a.print(); // ���� ���� �迭 ����
		
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		a.print(); // 1~7���� ���Ҹ� �߰��Ͽ� ���
		
		a.remove(1);
		a.remove(3);
		a.remove(7);
		a.print(); // ���� 1,3,7�� �����Ͽ� ���

			}
	
}
