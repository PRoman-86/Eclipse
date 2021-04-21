import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;

public class ScoreWriter3 {
	
/** Метод main выполняет следующие действия:
1. Создает экземпляр массива
2. Создает объекты Score и заполняет ими массив
3. Записывает счет игры в файл
*/
	
 public static void main(String[] args) {
	 
FileWriter myFile = null;
 BufferedWriter buff = null;
Date today = new Date();
 Score scores[] = new Score[3];
 
 /*
  Согласно заданию, заполняем экземпляры класса Score в аргументах
  конструктора; таким образом данные будут переданы через конструктор
  в момент создания объектов внутри массива. Ненужные теперь сеттеры в
  массиве закомментим, чтобы наглядно были видны изменения в коде.
  */
 
// The player #1
 scores[0]=new Score("Николай", "Смирнов", 250, today);
 //scores[0].setFirstName("Николай");
 //scores[0].setLastName("Смирнов");
 //scores[0].setScore(250);
 //scores[0].setPlayDate(today);
 
// The player #2
 scores[1]=new Score("Анна", "Егорова", 300, today);
 //scores[1].setFirstName("Анна");
 //scores[1].setLastName("Егорова");
 //scores[1].setScore(300);
 //scores[1].setPlayDate(today);
 
// The player #3
 scores[2]=new Score("Сергей", "Волик", 190, today);
 //scores[2].setFirstName("Сергей");
 //scores[2].setLastName("Данилов");
 //scores[2].setScore(190);
//scores[2].setPlayDate(today);
 
 try {
	 
myFile = new FileWriter("c:\\scores2.txt");
 buff = new BufferedWriter(myFile);
 
for (int i=0; i < scores.length; i++) {
 // Преобразует каждый счет в объект String
 // и записывает его в scores2.txt
 buff.write(scores[i].toString());
 System.out.println("Запись " +
 scores[i].getLastName());
 }

 System.out.println("Запись файла завершена");
 
 }catch (IOException e) {
 e.printStackTrace();
 
 } finally {
	 
 try {
	 
 buff.flush();
 buff.close();
 myFile.close();
 
 } catch (IOException e1) {
 e1.printStackTrace();
   }
  }
 }
}