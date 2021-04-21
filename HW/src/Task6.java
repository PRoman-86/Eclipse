public class Task6 {

	public static void main(String[] args) {
		String s = "Перестановочный алгоритм быстрого действия";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'о')
				System.out.print(s.charAt(i));
		}

		s = "Перевыборы выбранного президента";
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'е')
				counter++;
		}

		System.out.println("\n" + counter);
		
		s = "Посмотрите как Рите нравится ритм";
		String lowText=s.toLowerCase();
		int ind=lowText.indexOf("рит");
		while (ind!=-1) {
		System.out.print(ind+" ");
		ind=lowText.indexOf("рит", ind+1);
		}
		
		String[][] array = { { "Привет", "всем", "кто" }, { "изучает", "язык", "программирования" }, { "java" } };
		String str = null;
		int wordsWithE = 0;
		int words = 0;
		for (int i = 0; i < array.length; i++) {
			words = words + array[i].length; // считаем общее количество слов
			for (int k = 0; k < array[i].length; k++) {
				str = array[i][k].toString(); // разбираем массив на строки
				if (str.contains("е"))
					wordsWithE++; // считаем количество слов с буквой "е"
			}
		}

		System.out.println("\nКоличество слов без буквы Е в массиве: " + (words - wordsWithE));
	}
}
