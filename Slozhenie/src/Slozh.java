//программа для сложения натуральных целых чисел в пределах [-100] до [100]
import java.util.Scanner;

public class Slozh {
	
	public static int Slozhenie(int x, int y) {
	int z=x+y;
	return z; }

	public static void main(String[] args) {
		
		int c=1986; System.out.println("Привет, я могу складывать числа в пределах ста!");
		do {
		Scanner varX = new Scanner (System.in);
		Scanner varY = new Scanner (System.in);
		System.out.println("Введите первое значение");
		int myX = varX.nextInt();
		System.out.println("Введите второе значение");
		int myY = varY.nextInt();
		
		if ((myX>=101 | myX<=-101) | (myY>=101 | myY<=-101)) {
			System.out.println("Введенные значения не могут быть обработаны");
			return;
		}
		else {
		int otv=Slozhenie (myX,myY);
		
		System.out.println("Результат: "+myX+"+"+myY+"="+otv+". Еще разок!");
		}
		} while (c>0);
		
	}

}
