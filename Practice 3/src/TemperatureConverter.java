//��������� �������� ���������� �� ������� � ��������� � �������

//��������� ��������� ����� TemperatureConverter
public class TemperatureConverter {
	
    
	/*��������� � ��� ��������� ����� convertTemp, ������� ������� ��� ������ int, � ��
	  String, ��� �������� � �����, ��� ��� ���� ���� - ����� � ������. ���� �� �����
	  ��������� ��� �������� Integer, ������� ������ ��� �������������� ������ ���� ������
	  � ������. ���� ������, ��� ����� ������� ��� ������ String, �� �� ������ �������
	  �������� ���������� temperature ��� Integer. 
	  
	  � ��������� ������ ������ �������� ����� static, ����� �� ��������� ��������� �������
	  � �� ������������ ���.
	*/ 
	public static int convertTemp (int temperature, char ConvertTo) {
		
		//������������� ���������� switch
		switch (ConvertTo) {
		
		case 'F':
			temperature=temperature*9/5+32;
			break;
		case 'C':
			temperature=(temperature-32)*5/9;
			break;	
		}
		//���������� ������, ������� ��������� � ���������� temperature
		return temperature;
	}	
	//��������� ���������� ������� ����� main()
	public static void main(String[] args) {
	
 //��������� � ��� ���������� myRes � ����� int � ������������ �� � ������, ������� ��������.
 //������� ��������� �� �����		
		int myRes=convertTemp(100, 'C');
		
		System.out.println("Your Result="+myRes);
	}
}
