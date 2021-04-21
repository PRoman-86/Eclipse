/*
Игра "Крестики-нолики" на доске 3х3. В книге предполагается, что она будет
написана в виде апплета, что подразумевает обязательное наличие некоторых
методов в коде и отсутствие точки входа в программу в виде main(). 
Так как апплеты устарели, код отличается от предоставленного в книге.
Код написан без учета практических заданий, то есть содержит некоторые
намеренно допущенные ошибки, которые должны быть решены в процессе
выполнения практических заданий. В частности, не блокируются поля, в которые
сделан ход.
*/

import java.awt.*; import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {
	
	public static void main(String[] args) {
		new TicTacToe(); }
	
	//создаем общие для всего класса переменные и компоненты интерфейса
	Button squares[] = new Button[9];
	Button newGameButton = new Button("НОВАЯ ИГРА");
	Panel mainPanel = new Panel();
	Panel topPanel = new Panel();
	Panel centerPanel = new Panel();
	Label score = new Label("Твой ход!");
	JFrame frame = new JFrame("TicTacToe Game");
	int emptySquaresLeft=9;
	Font appletFont=new Font("Monospased",Font.BOLD, 20);
	Font buttonsFont=new Font("Monospased",Font.BOLD,55);
	
	//объявляем конструктор
	TicTacToe() {
		//применяем схемы размещения, шрифты и цвета интерфейса
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(Color.CYAN);
		mainPanel.setFont(appletFont);
		//регистрируем слушателя на кнопку новой игры. Так как класс
		//одновременно содержит и слушателя, в аргументе this
		newGameButton.addActionListener(this);
		//добавляем, настраиваем и создаем панели и оставшиеся компоненты интерфейса
		topPanel.add(newGameButton);
		mainPanel.add(topPanel, "North");
		centerPanel.setLayout(new GridLayout(3,3));
		mainPanel.add(centerPanel, "Center");
		mainPanel.add(score, "South");
		//с помощью массива и цикла создаем девять кнопок игрового поля,
		//регистрируем на них слушателя, раскрашиваем кнопки и добавляем
		//на панель
		for (int i=0;i<9;i++) {
			squares[i] = new Button();
			squares[i].addActionListener(this);
			squares[i].setBackground(Color.ORANGE);
			centerPanel.add(squares[i]);
		}
		//настраиваем ранее созданное окно и добавляем на него главную панель,
		//содержащую остальные панели и компоненты
		frame.add(mainPanel);
		frame.setSize(450, 400);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	/*
	Метод lookForWinner() вызывается после каждого хода, чтобы узнать,
	есть ли победитель. Он проверяет каждый ряд, колонку
	и диагональ, чтобы найти три клетки с одинаковыми надписями
	(не пустыми).
	 Он возвращает "X" или "O", либо "T" – ничья, а также "" (пусто) - еще нет
	 ни победителя, ни ничьи. Помним, что метод типа String, т.е. возвращает
	 текст.
	 Ниже мы описываем его поведение:
	*/
	
	String lookForWinner() {
		String theWinner=""; //создаем переменную типа String
		emptySquaresLeft--; //уменьшаем переменную на единицу при каждом ходе
		//эта переменная при каждом ходе игрока или программы уменьшает количество
		//свободных клеток (кнопок) поля на одну. Ее начальное значение равно 9,
		//она объявлена в начале как общая для всего класса.
		
		//создаем условие: если количество свободных клеток приравнивается к нулю,
		//то, метод lookForWinner() сразу вернет "Т", то есть ничью.
		if (emptySquaresLeft==0) {
			return "T"; }
		
		/*
		Куча условий ниже проверяет каждые ряд, колонку и диагональ,
		по результату проверки он задает значение переменной theWinner,
		которая будет иметь значение X либо О.
		
		Здесь использованы сложные выражения в условиях, поэтому для более легкого
		понимания, разберем их на строки. Также в условии используется логический
		оператор "И" с двойным амперсандом &&, который указывает на то, что
		все выражения должны быть истинными одновременно, но при этом, если первое
		выражение будет ложным, остальные проверяться не будут, так как это становится
		бессмысленным. Разбираем эти выражения на примере первого условия:
		
		(!squares[0].getLabel().equals("") && squares[0].getLabel().equals(squares[1].getLabel()) && squares[0].getLabel().equals(squares[2].getLabel()))
		   
		  Проверяется первая часть условия: !squares[0].getLabel().equals("") что означает: "первая клетка не пустая". Одновременно выражение
		  получает надпись на кнопке, это либо Х, либо О, либо "пусто". Если так оно и есть, и первая клетка не пустая,
		  то программа переходит ко второй части условия:
		  
		  squares[0].getLabel().equals(squares[1].getLabel()) && squares[0].getLabel().equals(squares[2].getLabel())
		
		  Разбираем первое выражение второго условия: squares[0].getLabel().equals(squares[1].getLabel())
		  выражение получает надпись второй кнопки и приравнивает с помощью equals() к первой. Если выражение
		  истинно, то есть надписи на первой и второй кнопках идентичны, программа переходит ко второму выражению
		  второго условия squares[0].getLabel().equals(squares[2].getLabel() в котором таким же образом получает
		  надпись на третьей кнопке и также сравнивает ее с первой.
		  
		  На выходе получаем: if (первая кнопка не пустая, то она сравнивается со второй, а потом с третьей). 
		  В случае, если три кнопки совпадают по надписям, метод lookForWinner() возвращает победителя (Х или О) 
		  с помощью переменной theWinner,которая берет надпись с первой кнопки.
		  Если же хотя бы одна кнопка отличается или пустая, то программа переходит к след блоку через else.
		  
		  Помимо прочего, условие дает аргументы методу highlightWinner(), который нихуя не возвращает, а просто
		  окрашивает победившую комбинацию кнопок в другой цвет для красоты. Этот метод реализован ниже.
		  
		  Такой вот хитровыебанный алгоритм.
		  
		  
		 */
		
		// Проверяем ряд 1 – элементы массива 0,1,2
		if (!squares[0].getLabel().equals("") &&
		squares[0].getLabel().equals(squares[1].getLabel()) &&
		squares[0].getLabel().equals(squares[2].getLabel())) {
		theWinner = squares[0].getLabel();
		highlightWinner(0,1,2);
		// Проверяем ряд 2 – элементы массива 3,4,5
		} else if (!squares[3].getLabel().equals("") &&
		squares[3].getLabel().equals(squares[4].getLabel()) &&
		squares[3].getLabel().equals(squares[5].getLabel())) {
		theWinner = squares[3].getLabel();
		highlightWinner(3,4,5);
		// Проверяем ряд 3 – элементы массива 6,7,8
		} else if ( ! squares[6].getLabel().equals("") &&
		squares[6].getLabel().equals(squares[7].getLabel()) &&
		squares[6].getLabel().equals(squares[8].getLabel())) {
		theWinner = squares[6].getLabel();
		highlightWinner(6,7,8);
		// Проверяем колонку 1 – элементы массива 0,3,6
		} else if ( ! squares[0].getLabel().equals("") &&
		squares[0].getLabel().equals(squares[3].getLabel()) &&
		squares[0].getLabel().equals(squares[6].getLabel())) {
		theWinner = squares[0].getLabel();
		highlightWinner(0,3,6);
		// Проверяем колонку 2 – элементы массива 1,4,7
		} else if ( ! squares[1].getLabel().equals("") &&
		squares[1].getLabel().equals(squares[4].getLabel()) &&
		squares[1].getLabel().equals(squares[7].getLabel())) {
		theWinner = squares[1].getLabel();
		highlightWinner(1,4,7);
		// Проверяем колонку 3 – элементы массива 2,5,8
		} else if ( ! squares[2].getLabel().equals("") &&
		squares[2].getLabel().equals(squares[5].getLabel()) &&
		squares[2].getLabel().equals(squares[8].getLabel())) {
			theWinner = squares[2].getLabel();
			highlightWinner(2,5,8);
			// Проверяем первую диагональ – элементы массива 0,4,8
			} else if ( ! squares[0].getLabel().equals("") &&
			squares[0].getLabel().equals(squares[4].getLabel()) &&
			squares[0].getLabel().equals(squares[8].getLabel())) {
			theWinner = squares[0].getLabel();
			highlightWinner(0,4,8);
			// Проверяем вторую диагональ – элементы массива 2,4,6
			} else if ( ! squares[2].getLabel().equals("") &&
			squares[2].getLabel().equals(squares[4].getLabel()) &&
			squares[2].getLabel().equals(squares[6].getLabel())) {
			theWinner = squares[2].getLabel();
			highlightWinner(2,4,6);
			
		}
		
		return theWinner; //возвращаем значение переменной - Х или О
		
	}  //конец метода lookTheWinner()
	
	/*
	Метод computerMove() применяет набор правил, чтобы найти
    лучший компьютерный ход. Если хороший ход
	не найден, выбирается случайная клетка. Метод ничего не
	возвращает. Метод работает вместе с методами findEmptySquare()
	и getRandomSquare().
	Опишем его поведение:
	*/
	
	void computerMove() {
		/*
		Объявляем переменную для хранения возвращаемого методом findEmptySquare()
		значения с выбранной клеткой для хода. И сразу же реализуем ее работу
		путем приравнивания к методу findEmptySquare(), указывая в аргументе "О"
		Значение переменной по результатам работы findEmptySquare() будет -1,
		если не будет найдено двух клеток с одинаковыми надписями Х или О.
		В ином же случае сюда вернется значение от 0 до 8.
		 */
		int selectedSquare; 
		selectedSquare=findEmptySquare("O");
		/*
		Если метод вернул -1 через переменную, то повторяем работу метода,
		но уже с аргументом Х.
		 */
		if (selectedSquare==-1) {
			selectedSquare=findEmptySquare("X");
		}
		/*
	    Если метод вернул -1 и одновременно центральная клетка
	    поля пустая, то присваиваем переменной selectedSquare значение 4
	    (4 - индекс центральной клетки поля в массиве)
		 */
		if ((selectedSquare==-1)&&(squares[4].getLabel().equals(""))) {
			selectedSquare=4;
		}
		/*
		Если метод вернул -1, но центральная клетка поля занята, то
		значение переменной selectedSquare будет приравнено к результату
		работы метода getRandomSquare(), который возвращает рандомное значение,
		т.е. компьютер сделает ход наугад.
		 */
		if (selectedSquare==-1) {
			selectedSquare=getRandomSquare();
		}
		/*
		Две строки ниже графически реализуют ходы компьютера (О). Переменная
		selectedSquare выступает как индекс массива с кнопками.
		 */
		squares[selectedSquare].setFont(buttonsFont); //устанавливает шрифт для кнопки
		squares[selectedSquare].setLabel("O"); //рисует нолик на кнопке
		
	} //конец метода computerMove()
	
	/**
	Метод findEmptySquare() проверяет каждый ряд, колонку и диагональ
	чтобы узнать, есть ли в ней две клетки с одинаковыми надписями и пустой клеткой.
	В параметрах метода передается X – для пользователя и O – для компьютера.
	Метод возвращает (тип возвращаемых данных - int) количество свободных клеток,
	или -1, если не найдено две клетки с одинаковыми надписями (X или O).
	*/
	
	int findEmptySquare(String player) {
		
		int weight[] = new int[9]; //объявляем массив
		/*
		С помощью цикла проверяем каждую клетку поля и выясняем
		текущее состояние игры.
		 */
		for ( int i = 0; i < 9; i++ ) {
		//если клетка содержит нолик, то соотв. индекс массива будет иметь значение -1
		if ( squares[i].getLabel().equals("O") ) 
		weight[i] = -1;
		//если клетка содержит крестик, то соотв. индекс массива будет иметь значение 1
		else if ( squares[i].getLabel().equals("X") )
		weight[i] = 1;
		//клетка пустая - значение = 0
		else
		weight[i] = 0; }
		
		/*
		Далее объявляется int-переменная, которая будет иметь
		значение либо -2, либо 2 в зависимости от того, верно ли выражение
		player.equals("O"). То есть если в метод передается значение "О"
		посредством String-переменной player, стоящей в аргументе метода,
		то twoWeights будет равно -2, если передается "Х", то 2.
		Метод equals() сравнивает значение своего аргумента и значение
		player. Можно было реализовать через if-else, но так выглядит менее
		громоздко. 
		 */
		
		int twoWeights = player.equals("O") ? -2 : 2;
		
		/*Проверим, есть ли в ряду 1 две одинаковые клетки и
		 одна пустая.
		Каждый блок if-else имеет два внутренних блока if-else
		*/
		
		/*
		В основном условии блока все компоненты массива weight[] уже имеют определенное
		числовое значение (см. выше), это либо 1, либо -1, либо 0. Индексом массива
		задается проверяемая клетка (от 0 до 8). Переменная twoWeights также имеет
		значения либо -2, либо 2. В выражении проверяются на равенство значения элементов
		массива и переменной. Получаем, как пример ходов |X| |X|:   1+0+1 == 2 (истинно)
		Если основное условие истинно, то в дело вступают внутренние блоки:
		
		Во одном внутреннем блоке if-else проверяется на равенство к нулю значение первой клетки
		ряда, а weight[0] == 0 будет истинно, если первая клетка ряда будет пустой. Если 
		так и есть, то метод вернет 0.
		В другом внутреннем блоке if-else проверяется на равенство к нулю значение второй клетки
		ряда. Если выражение истинно, то метод вернет 1.
		Если обе клетки не пустые, то метод вернет 2.
		Получается, что внутренние блоки определяют, в какую клетку ряда сделает ход программа.
		
		В нашем случае |X| |X| сработает условие weight[1] == 0, метод вернет 1, и компьютер
		сходит во вторую клетку ряда.
		
		Таким образом, метод возвращает значение, которое затем хранится в переменной selectedSquare,
		которая была реализована в методе computerMove() и значение отвечает за то, в какую клетку
		сходит программа. Метод также может вернуть -1, тогда в дело вступают правила, реализованные
		в computerMove() выше.
		 */
		if ( weight[0] + weight[1] + weight[2] == twoWeights ) {
		if ( weight[0] == 0 )
		return 0;
		else if ( weight[1] == 0 )
		return 1;
		else
		return 2;
		}
		// Проверим, есть ли в ряду 2 две одинаковые клетки и
		// одна пустая.
		if (weight[3] +weight[4] + weight[5] == twoWeights) {
		if ( weight[3] == 0 )
		return 3;
		else if ( weight[4] == 0 )
		return 4;
		else
		return 5;
		}
		// Проверим, есть ли в ряду 3 две одинаковые клетки и
		// одна пустая.
		if (weight[6] + weight[7] +weight[8] == twoWeights ) {
		if ( weight[6] == 0 )
		return 6;
		else if ( weight[7] == 0 )
		return 7;
		else
		return 8;
		}
		// Проверим, есть ли в колонке 1 две одинаковые клетки и
		// одна пустая.
		if (weight[0] + weight[3] + weight[6] == twoWeights) {
		if ( weight[0] == 0 )
		return 0;
		else if ( weight[3] == 0 )
		return 3;
		else
		return 6;
		}
		// Проверим, есть ли в колонке 2 две одинаковые клетки
		// и одна пустая.
		if (weight[1] +weight[4] + weight[7] == twoWeights ) {
		if ( weight[1] == 0 )
		return 1;
		else if ( weight[4] == 0 )
		return 4;
		else
		return 7;
		}
		// Проверим, есть ли в колонке 3 две одинаковые клетки
		// и одна пустая.
		if (weight[2] + weight[5] + weight[8] == twoWeights ){
		if ( weight[2] == 0 )
		return 2;
		else if ( weight[5] == 0 )
		return 5;
		else
		return 8;
		}
		// Проверим, есть ли в диагонали 1 две одинаковые клетки
		// и одна пустая.
		if (weight[0] + weight[4] + weight[8] == twoWeights ){
			if ( weight[0] == 0 )
				return 0;
				else if ( weight[4] == 0 )
				return 4;
				else
				return 8;
				}
				// Проверим, есть ли в диагонали 2 две одинаковые клетки
				// и одна пустая.
				if (weight[2] + weight[4] + weight[6] == twoWeights ){
				if ( weight[2] == 0 )
				return 2;
				else if ( weight[4] == 0 )
				return 4;
				else
				return 6;
				}
				//возвращаем -1, если не найдено двух одинаковых соседних клеток
				return -1; 
		
	} //конец метода findEmptySquare()
	
	/*
	Метод getRandomSquare() выбирает любую пустую клетку
	и возвращает случайно выбранный номер клетки с помощью int
	*/
	
	int getRandomSquare() {
		
		/*объявляем переменную типа boolean со значением false
		  Она будет менять значение на true, если в процессе перебора
		  клеток найдется пустая, так как рандомное значение может совпадать
		  со значением клетки, которая уже занята.
		 */
		boolean gotEmptySquare=false; 
		int selectedSquare=-1; //создаем локальную переменную типа int со значением -1
		/*
		Объявляем цикл, который прервется, если переменная gotEmptySquare будет иметь
        противоположное значение (true) от начального (false).
		 */
		do {
			selectedSquare=(int) (Math.random()*9); //реализуем генератор случайного целого числа
			/*
			Если полученное рандомное значение в промежутке от 0 до 9 выпадет на пустую клетку,
			то цикл прерывается и метод возвратит полученное значение.
			Если выпадет на занятую клетку, то метод вернет -1, ход сделан
			не будет, а цикл пойдет по новой.
			 */
			if (squares[selectedSquare].getLabel().equals("")) {
				gotEmptySquare=true; //прерываем цикл
			}
			
		} while (!gotEmptySquare); //условие прерывания цикла
		
		return selectedSquare; //возврат значения
		
	} //конец метода getRandomSquare()
	
	/*
	Метод highlightWinner() выделяет выигравшую линию.
	В параметрах метода первая, вторая и третья клетки для выделения.
	Возвращать ничего не требуется, поэтому void.
	*/
	
	void highlightWinner(int win1,int win2,int win3) {
		squares[win1].setBackground(Color.CYAN);
		squares[win2].setBackground(Color.CYAN);
		squares[win3].setBackground(Color.CYAN);
	} //конец метода highlightWinner()
	
	/*
	Метод endTHeGame() делает недоступными клетки поля и в то же
	время доступной кнопку Новая Игра. 
	*/
	
	void endTheGame() {
		newGameButton.setEnabled(true);
		for (int i=0;i<9;i++) {
			squares[i].setEnabled(false);
		}
	} //конец метода endTheGame()
	
      //реализуем метод слушателя
public void actionPerformed(ActionEvent e) {
		
		Button theButton = (Button) e.getSource(); //получаем источник события с приведением к классу Button
		
		//реализуем нажатие кнопки новой игры
		if (theButton==newGameButton) {
			for (int i=0;i<9;i++) {
				squares[i].setEnabled(true); //разблокировка кнопок поля
				squares[i].setLabel(""); //очистка надписей на кнопках поля
				squares[i].setBackground(Color.ORANGE); //окрашивание кнопок поля
			}
			
			emptySquaresLeft=9; //возвращаем переменную кол-ва свободных клеток к исходному значению
			score.setText("Твой ход!"); //пишем в информационной панели обращение к игроку
			newGameButton.setEnabled(false); //блокируем кнопку новой игры
			return; //выходим из блока
		}
		
		/*объявляем переменную с пустым значением.
		 Она будет принимать значение, возвращаемое значение метода lookForWinner(),
		 то есть Х,О,Т или "" (пусто).
		*/
		String winner=""; 
		
	    //реализуем ход игрока
		for (int i=0;i<9;i++) {
			if (theButton==squares[i]) {
				squares[i].setFont(buttonsFont);
				squares[i].setLabel("X");
				winner=lookForWinner(); //присваиваем переменной возвращаемое значение метода
				
				
				//Если переменная имеет НЕ пустое значение, то игра заканчивается
				
				if (!"".equals(winner)) {
					endTheGame();
					//в противном случае продолжается
				} else {
					computerMove();
					winner=lookForWinner();
					
					if (!"".equals(winner)) {
						endTheGame();
					}
				}
				break;
			}
		} //конец цикла for
		
		//реализуется работа информационной панели для игрока
		if (winner.equals("X")) {
			score.setText("Ты победил!");
		} else if (winner.equals("O")) {
			score.setText("Ты проиграл!");
		} else if (winner.equals("T")) {
			score.setText("Это ничья!");
		}
	} //конец метода ActionPerformed()
	

} //конец класса
