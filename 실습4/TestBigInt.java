
public class TestBigInt {
	public static void main(String arg[]) {
		BigInt x = new BigInt(54321);
		BigInt y = new BigInt(9);
		BigInt z = new BigInt(8888);
		x.toString();
		z.toString();
		
		System.out.print("[");
		System.out.print("x : "+ x +" , y : "+ y);
		System.out.println("]");
		System.out.println("- x.multiplyone(y) = "+x.multiplyone(y));
		
		System.out.print("[");
		System.out.print("x : "+ x +" , z : "+ z);
		System.out.println("]");
		System.out.println("- x.multiply(z) = "+x.multiply(z));
		System.out.println("- z.multiply(x) = "+z.multiply(x));

		x = new BigInt(8888);
		z = new BigInt(54321);
		
		System.out.print("[");
		System.out.print("x : "+ x +" , z : "+ z);
		System.out.println("]");
		System.out.println("- x.multiply(z) = "+x.multiply(z));
		System.out.println("- z.multiply(x) = "+z.multiply(x));
	}
}
