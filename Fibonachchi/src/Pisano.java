public class Pisano {
	public static void main(String[] args) {
		long a=1,b=1,c=0;
		System.out.print("0 1 1 ");
		for (int i=3; i<15; i++) {
		c=a+b;
		System.out.print(c+" ");
		a=b;b=c;
} //конец цикла
 } //конец метода main()
  } //конец класса