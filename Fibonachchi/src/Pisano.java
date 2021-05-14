public class Pisano {
	public static void main(String[] args) {
		new Pisano(10);
	}

	Pisano(int val) {
		long a = 1, b = 1, c = 0;
		if (val <= 3) {
			System.out.println("Incorrect value");
			return;
		}

		System.out.print("0 1 1 ");
		for (int i = 3; i < val; i++) {
			c = a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}
	}
}
