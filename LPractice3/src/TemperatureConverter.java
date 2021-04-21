public class TemperatureConverter {
	

	
	public int convertTemp (int temperature, char convertTo) {
		
		
		if (convertTo=='F' ) {
			temperature=temperature*9/5+32;
			System.out.println("Temperature="+temperature+"C");
		}
		else if (convertTo=='C' ) {
			temperature=(temperature-32)*5/9;
			System.out.println("Temperature="+temperature+"F");
		}
		
		else
		{
			System.out.println("error");
		
		}
		
		return temperature;
	}
	

	
  public static void main (String[]args) {
	
	TemperatureConverter tc= new TemperatureConverter ();	
	int convertTo=tc.convertTemp(100, 'Y');
	
			}
}
