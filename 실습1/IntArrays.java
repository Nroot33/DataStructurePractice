import java.util.Random;

class IntArrays {
	int[] Arr;
	int size;

	public IntArrays(int n) {
		Random random = new Random();
		Arr = new int[n];
		for (int i = 0; i < n / 2; i++) {
			Arr[i] = random.nextInt(10) + 1;
		}
		size = n / 2;
	} // IntArrary ������

	public void print() {
		System.out.println("���̰� " + Arr.length+"�迭�� �����Ǿ����ϴ�.");
		for (int i = 0; i < Arr.length; i++) {
			if (Arr[i] == 0)
				break;
			System.out.print(Arr[i] + " ");
		}
		System.out.println("");
		System.out.println("");
	} // print �޼ҵ�

	public void add(int n) {
		Arr[size++] = n;
		System.out.println("������:" + n + "���ԵǾ����ϴ�.");
		if (size == Arr.length)
			resize();
	} // add �޼ҵ�

	public void resize() {
		int[] aa = Arr;
		Arr = new int[2 * aa.length];
		System.arraycopy(aa, 0, Arr, 0, size);
	} // �迭 ũ�⸦ 2�踦 ���ִ� resize �޼ҵ�

	public void remove(int n) {
		for (int i = 0; i < Arr.length; i++) {
			if (Arr[i] == n) {
				int a = n;
				System.arraycopy(Arr, i + 1, Arr, i, Arr.length - i - 1);
				System.out.println("������:" + n + "���ŵǾ����ϴ�.");
			}
		}
	} // ���Ҹ� �����ϴ� remove �޼�
}