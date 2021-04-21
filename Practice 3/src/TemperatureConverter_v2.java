
public class TemperatureConverter_v2 {

	public static int convertTemp (int temperature, char ConvertTo) {
		
		switch (ConvertTo) {
		
		case 'F':
			temperature=temperature*9/5+32;
			System.out.println("Ваш результат: "+temperature+"' по Цельсию");
			if (temperature==843) {
				System.out.println("Привет от Рэя Бредбери");
			}
			break;
			
		case 'C':
			temperature=(temperature-32)*5/9;
			System.out.println("Ваш результат: "+temperature+"' по Фаренгейту");
			if (temperature==451) {
				System.out.println("Бредбери бы оценил");
			}
			break;	
		default:
			System.out.println("Ошибка ввода");
		}
		
		return temperature;
	}	
	
	public static void main(String[] args) {
	
		convertTemp(844, 'C');
		
		
	}
}