import java.util.Scanner;

public class Finding {
	
	Finding() {
		
		int c=2020;
		do {
		
		Scanner myDay = new Scanner(System.in);
		int wDay=myDay.nextInt();
	
		switch (wDay) {
		case 1:
			System.out.println("Понедельник");
			break;
		case 2:
			System.out.println("Вторник");
			break;
		case 3:
			System.out.println("Среда");
			break;
		case 4:
			System.out.println("Четверг");
			break;
		case 5:
			System.out.println("Пятница");
			break;
		case 6:
			System.out.println("Суббота");
			break;
		case 7:
			System.out.println("Воскресенье");
			break;
		default:
			System.out.println("Ошибка ввода");
			
		}
	  } while (c>0);
	}
	
	public static void main(String[] args) {
		Finding find = new Finding();
	}
}


