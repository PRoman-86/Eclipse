//программа перевода температур из цельси€ в фаренгейт и обратно

//объ€вл€ем публичный класс TemperatureConverter
public class TemperatureConverter {
	
    
	/*объ€вл€ем в нем публичный метод convertTemp, который ожидает тип данных int, а не
	  String, как написано в книге, так как яков ‘айн - мудак и ошибс€. Ћибо он забыл
	  преподать нам оператор Integer, который служит дл€ преобразовани€ одного типа данных
	  в другой. ≈сли укажем, что метод ожидает тип данных String, то не сможем вернуть
	  значение переменной temperature без Integer. 
	  
	  ¬ сигнатуре метода укажем ключевое слово static, чтобы не создавать экземпл€р объекта
	  и не загромождать код.
	*/ 
	public static int convertTemp (int temperature, char ConvertTo) {
		
		//воспользуемс€ оператором switch
		switch (ConvertTo) {
		
		case 'F':
			temperature=temperature*9/5+32;
			break;
		case 'C':
			temperature=(temperature-32)*5/9;
			break;	
		}
		//возвращаем данные, которые вычислены в переменной temperature
		return temperature;
	}	
	//объ€вл€ем вызывающий главный метод main()
	public static void main(String[] args) {
	
 //объ€вл€ем в нем переменную myRes с типом int и приравниваем ее к методу, задава€ значени€.
 //¬ыводим результат на экран		
		int myRes=convertTemp(100, 'C');
		
		System.out.println("Your Result="+myRes);
	}
}
