
public class MyPoint implements Point {
	double x;
	double y;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public MyPoint(double n, double m) {
		x = n;
		y = m;
	}

	public void print() {
		System.out.println("현재 좌표 : (" + x + ", " + y + ")");
	}

	public void moveTo(double n, double m) {
		x = n + x;
		y = m + y;
		System.out.println("[move] x축으로 " + n + ", y축으로 " + m + "만큼 이동 완료 하였습니다.");
	}

	public void scaleTo(double n) {
		if (n > 0) {
			x = n * x;
			y = n * y;
			System.out.println("[scale] 좌표에 " + (int) n + "배를 하였습니다.");
		} else {
			System.out.println("[Error] 입력하신 " + (int) n + "는 양수가 아니므로 조건에 어긋납니다.");
		}
	}

}
