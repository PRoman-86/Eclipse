import java.util.Scanner;

public class Finding {
	
	Finding() {
		
		int c=2020;
		do {
		
		Scanner myDay = new Scanner(System.in);
		int wDay=myDay.nextInt();
	
		switch (wDay) {
		case 1:
			System.out.println("�����������");
			break;
		case 2:
			System.out.println("�������");
			break;
		case 3:
			System.out.println("�����");
			break;
		case 4:
			System.out.println("�������");
			break;
		case 5:
			System.out.println("�������");
			break;
		case 6:
			System.out.println("�������");
			break;
		case 7:
			System.out.println("�����������");
			break;
		default:
			System.out.println("������ �����");
			
		}
	  } while (c>0);
	}
	
	public static void main(String[] args) {
		Finding find = new Finding();
	}
}


