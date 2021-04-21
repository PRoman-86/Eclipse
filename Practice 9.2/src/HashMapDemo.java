import java.util.HashMap;
import java.util.Map.Entry;
/*
 �������� �������, ������� ��������� HashMapDemo, ������� �� ArrayListDemo,
 �� � ��������� ������ ��������� ����� � ��������
 */
public class HashMapDemo {

	public static void main(String[] args) {
		//������� ��������� ������� HashMap.
		//� ����, � �������� � ��� ����� ���� String
		HashMap <String, String> phoneBook = new HashMap <String, String>();
		phoneBook.put("����", "22-96-00");
		phoneBook.put("����", "22-96-39");
		phoneBook.put("����", "60-73-29");
		phoneBook.put("�����", "�����������");
		//�������� � ���������� ���������� ���(���������)
		int notes=phoneBook.size();
		//���������� ���� � ������� �����, ������� �� �� �����
		for (Entry<String, String> entry: phoneBook.entrySet()) {
			System.out.println(entry);
		}
		//������� �� ����� ���������� ���������
		System.out.println("����� �������: "+notes);
	}
}
