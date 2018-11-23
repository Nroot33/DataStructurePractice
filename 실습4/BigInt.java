public class BigInt {
	private Node start;

	private static class Node {
		int digit;
		Node next;

		Node(int digit) {
			this.digit = digit;
		}
	}

	public BigInt(int x) {
		if (x < 0) {
			System.out.print(x + "은 0보다 작습니다.");
		}
		start = new Node(x % 10);
		Node p = start;
		x = x / 10;
		while (x > 0) {
			p = p.next = new Node(x % 10);
			x = x / 10;
		}
	}

	public String toString() {
		StringBuffer buf = new StringBuffer(Integer.toString(start.digit));
		Node p = start.next;
		while (p != null) {
			buf.insert(0, Integer.toString(p.digit));
			p = p.next;
		}
		return buf.toString();
	}

	public BigInt multiplyone(BigInt y) {
		Node p = start, q = y.start;
		int temp = p.digit * q.digit;
		BigInt mo = new BigInt(temp % 10);
		Node r = mo.start;
		p = p.next;

		while (p != null) {
			temp = temp / 10 + (p.digit * q.digit);
			r.next = new Node(temp % 10);
			p = p.next;
			r = r.next;
		} // 각 노드를 곱하는 과정
		
		if (temp > 9)
			r.next = new Node(temp / 10); // 곱한 뒤 맨 앞자리 수 표현
		return mo;
	}

	public BigInt multiply(BigInt z) {
		Node p = start, q = z.start;
		int temp = 0;
		int number = 0;
		int n = 0;

		BigInt m = new BigInt(temp);
		Node r = m.start;
		Node s = m.start;

		while (q != null) {
			p = start;
			r = m.start;
			n = number;

			while (n > 0) {
				r = r.next;
				n--; // 곱의 자리 수를 한자리씩 밀어내는 식
			}

			temp = r.digit + (p.digit * q.digit);
			r.digit = temp % 10;
			p = p.next;

			while (p != null) {
				s = r;
				for (r = m.start; r != null; r = r.next) {
					if (r.digit > 9) {
						if (r.next == null) {
							r.next = new Node(r.digit / 10);
							r.digit = (r.digit % 10);
						} else {
							r.next.digit = r.next.digit + (r.digit / 10);
							r.digit = (r.digit % 10);
						}
					}
				}
				r = s; // BigInt m에 있는 값 중 @로 만들어진 숫자들을 더하는 식
				
				temp = temp / 10 + (p.digit * q.digit);
				
				if (r.next == null) {
					r.next = new Node(temp % 10);
				} else {
					r.next.digit = r.next.digit + (temp % 10);
				} // BigInt m에 있는 값들을 더하는 식
				
				p = p.next;
				r = r.next;
			}

			number++;
			q = q.next;

			if (temp > 9)
				r.next = new Node(temp / 10); // @
		}
		return m;
	}
}
