import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class scoreReader {

	public static void main(String[] args) {
		
		//объ€вим переменные дл€ потока с файла и буферизации с отсутствующим значением
		FileReader myFile=null;
		BufferedReader buff=null;
		
		try {
			//открываем поток и буферизируем его
			myFile=new FileReader("D:\\Roman\\Eclipse\\Score Reader\\bin\\scores.txt");
			buff=new BufferedReader(myFile);
			
			while (true) {
				//считываем построчно текстовый файл c помощью readLine() через буфер
				String line=buff.readLine();
				//и выходим из цикла, если line получает null, т.е. строки закончились
				//дополнительно выведем сообщение о том, что файл закончилс€
				if (line==null) {
					System.out.println("-----конец файла-----");
					break;
				}
				
				//выводим строки из файла в консоль
				System.out.println(line);
			} //конец цикла while
			
		} catch (IOException e) {
			//в случае исключени€ выводим сообщение об ошибке в консоль
			e.printStackTrace();
			
		} finally { //код в блоке finally выполнитс€ в любом случае, кинуло исключение или нет
			//так как необходимо закрыть потоки в любом случае, иначе будет происходить утечка пам€ти
			
			try { //так как метод close() также в случае ошибки может генерировать 
				//исключение IOException, то также помещаем его в try/catch
				
				//закрываем потоки файла и буфера методом close()
				buff.close();
				myFile.close();
			} catch (IOException e1) {
				//в случае исключени€ выводим сообщение об ошибке в консоль
				e1.printStackTrace();
				
	 }		
    }
   } //конец метода main()
 } //конец класса
