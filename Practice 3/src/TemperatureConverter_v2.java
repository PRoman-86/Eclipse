
public class TemperatureConverter_v2 {

	public static int convertTemp (int temperature, char ConvertTo) {
		
		switch (ConvertTo) {
		
		case 'F':
			temperature=temperature*9/5+32;
			System.out.println("��� ���������: "+temperature+"' �� �������");
			if (temperature==843) {
				System.out.println("������ �� ��� ��������");
			}
			break;
			
		case 'C':
			temperature=(temperature-32)*5/9;
			System.out.println("��� ���������: "+temperature+"' �� ����������");
			if (temperature==451) {
				System.out.println("�������� �� ������");
			}
			break;	
		default:
			System.out.println("������ �����");
		}
		
		return temperature;
	}	
	
	public static void main(String[] args) {
	
		convertTemp(844, 'C');
		
		
	}
}