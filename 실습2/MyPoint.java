
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
		System.out.println("���� ��ǥ : (" + x + ", " + y + ")");
	}

	public void moveTo(double n, double m) {
		x = n + x;
		y = m + y;
		System.out.println("[move] x������ " + n + ", y������ " + m + "��ŭ �̵� �Ϸ� �Ͽ����ϴ�.");
	}

	public void scaleTo(double n) {
		if (n > 0) {
			x = n * x;
			y = n * y;
			System.out.println("[scale] ��ǥ�� " + (int) n + "�踦 �Ͽ����ϴ�.");
		} else {
			System.out.println("[Error] �Է��Ͻ� " + (int) n + "�� ����� �ƴϹǷ� ���ǿ� ��߳��ϴ�.");
		}
	}

}
