public class Task6 {

	public static void main(String[] args) {
		String s = "��������������� �������� �������� ��������";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '�')
				System.out.print(s.charAt(i));
		}

		s = "���������� ���������� ����������";
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '�')
				counter++;
		}

		System.out.println("\n" + counter);
		
		s = "���������� ��� ���� �������� ����";
		String lowText=s.toLowerCase();
		int ind=lowText.indexOf("���");
		while (ind!=-1) {
		System.out.print(ind+" ");
		ind=lowText.indexOf("���", ind+1);
		}
		
		String[][] array = { { "������", "����", "���" }, { "�������", "����", "����������������" }, { "java" } };
		String str = null;
		int wordsWithE = 0;
		int words = 0;
		for (int i = 0; i < array.length; i++) {
			words = words + array[i].length; // ������� ����� ���������� ����
			for (int k = 0; k < array[i].length; k++) {
				str = array[i][k].toString(); // ��������� ������ �� ������
				if (str.contains("�"))
					wordsWithE++; // ������� ���������� ���� � ������ "�"
			}
		}

		System.out.println("\n���������� ���� ��� ����� � � �������: " + (words - wordsWithE));
	}
}
