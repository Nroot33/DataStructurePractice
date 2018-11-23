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
	} // IntArrary 생성자

	public void print() {
		System.out.println("길이가 " + Arr.length+"배열이 생성되었습니다.");
		for (int i = 0; i < Arr.length; i++) {
			if (Arr[i] == 0)
				break;
			System.out.print(Arr[i] + " ");
		}
		System.out.println("");
		System.out.println("");
	} // print 메소드

	public void add(int n) {
		Arr[size++] = n;
		System.out.println("데이터:" + n + "삽입되었습니다.");
		if (size == Arr.length)
			resize();
	} // add 메소드

	public void resize() {
		int[] aa = Arr;
		Arr = new int[2 * aa.length];
		System.arraycopy(aa, 0, Arr, 0, size);
	} // 배열 크기를 2배를 해주는 resize 메소드

	public void remove(int n) {
		for (int i = 0; i < Arr.length; i++) {
			if (Arr[i] == n) {
				int a = n;
				System.arraycopy(Arr, i + 1, Arr, i, Arr.length - i - 1);
				System.out.println("데이터:" + n + "제거되었습니다.");
			}
		}
	} // 원소를 제거하는 remove 메소
}