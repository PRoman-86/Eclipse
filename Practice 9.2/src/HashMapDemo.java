import java.util.HashMap;
import java.util.Map.Entry;
/*
 Согласно заданию, создаем программу HashMapDemo, похожую на ArrayListDemo,
 но в коллекции должны храниться имена и телефоны
 */
public class HashMapDemo {

	public static void main(String[] args) {
		//создаем экземпляр объекта HashMap.
		//и ключ, и значение в нем будут типа String
		HashMap <String, String> phoneBook = new HashMap <String, String>();
		phoneBook.put("Рома", "22-96-00");
		phoneBook.put("Женя", "22-96-39");
		phoneBook.put("Люба", "60-73-29");
		phoneBook.put("Волик", "отсутствует");
		//получаем в переменную количество пар(элементов)
		int notes=phoneBook.size();
		//перебираем пары с помощью цикла, выводим их на экран
		for (Entry<String, String> entry: phoneBook.entrySet()) {
			System.out.println(entry);
		}
		//выводим на экран количество элементов
		System.out.println("Всего записей: "+notes);
	}
}
