//��������� ��� �������� ����������� ����� ����� � �������� [-100] �� [100]
import java.util.Scanner;

public class Slozh {
	
	public static int Slozhenie(int x, int y) {
	int z=x+y;
	return z; }

	public static void main(String[] args) {
		
		int c=1986; System.out.println("������, � ���� ���������� ����� � �������� ���!");
		do {
		Scanner varX = new Scanner (System.in);
		Scanner varY = new Scanner (System.in);
		System.out.println("������� ������ ��������");
		int myX = varX.nextInt();
		System.out.println("������� ������ ��������");
		int myY = varY.nextInt();
		
		if ((myX>=101 | myX<=-101) | (myY>=101 | myY<=-101)) {
			System.out.println("��������� �������� �� ����� ���� ����������");
			return;
		}
		else {
		int otv=Slozhenie (myX,myY);
		
		System.out.println("���������: "+myX+"+"+myY+"="+otv+". ��� �����!");
		}
		} while (c>0);
		
	}

}
