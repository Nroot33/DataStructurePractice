
public class IntArraysTest {

	public static void main(String[] args) {
		IntArrays a = new IntArrays(10);
		a.print(); // 랜덤 숫자 배열 생성
		
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		a.print(); // 1~7까지 원소를 추가하여 출력
		
		a.remove(1);
		a.remove(3);
		a.remove(7);
		a.print(); // 원소 1,3,7를 제거하여 출력

			}
	
}
