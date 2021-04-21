import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class scoreReader {

	public static void main(String[] args) {
		
		//������� ���������� ��� ������ � ����� � ����������� � ������������� ���������
		FileReader myFile=null;
		BufferedReader buff=null;
		
		try {
			//��������� ����� � ������������ ���
			myFile=new FileReader("D:\\Roman\\Eclipse\\Score Reader\\bin\\scores.txt");
			buff=new BufferedReader(myFile);
			
			while (true) {
				//��������� ��������� ��������� ���� c ������� readLine() ����� �����
				String line=buff.readLine();
				//� ������� �� �����, ���� line �������� null, �.�. ������ �����������
				//������������� ������� ��������� � ���, ��� ���� ����������
				if (line==null) {
					System.out.println("-----����� �����-----");
					break;
				}
				
				//������� ������ �� ����� � �������
				System.out.println(line);
			} //����� ����� while
			
		} catch (IOException e) {
			//� ������ ���������� ������� ��������� �� ������ � �������
			e.printStackTrace();
			
		} finally { //��� � ����� finally ���������� � ����� ������, ������ ���������� ��� ���
			//��� ��� ���������� ������� ������ � ����� ������, ����� ����� ����������� ������ ������
			
			try { //��� ��� ����� close() ����� � ������ ������ ����� ������������ 
				//���������� IOException, �� ����� �������� ��� � try/catch
				
				//��������� ������ ����� � ������ ������� close()
				buff.close();
				myFile.close();
			} catch (IOException e1) {
				//� ������ ���������� ������� ��������� �� ������ � �������
				e1.printStackTrace();
				
	 }		
    }
   } //����� ������ main()
 } //����� ������
