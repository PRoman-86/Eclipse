/*
Игра "Крестики-нолики" на доске 3х3. В книге предполагается, что она будет
написана в виде апплета, что подразумевает обязательное наличие некоторых
методов в коде и отсутствие входа в программу в виде main(). Так как апплеты
устарели, код отличается от предоставленного в книге. Это финальная версия,
практические задания обычной сложности реализованы.
*/

import java.awt.*; import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {
	
	public static void main(String[] args) {
		new TicTacToe(); }
	
	Button squares[] = new Button[9];
	Button newGameButton = new Button("НОВАЯ ИГРА");
	Panel mainPanel = new Panel();
	Panel topPanel = new Panel();
	Panel centerPanel = new Panel();
	Label score = new Label("Твой ход!");
	Label scoreline = new Label ("Счет: 0:0"); 
	JFrame frame = new JFrame("TicTacToe Game");
	int emptySquaresLeft=9;
	Font appletFont=new Font("Monospased",Font.BOLD, 20);
	Font buttonsFont=new Font("Monospased",Font.BOLD,55);
	int playerscore=0; int aiscore=0;
	
	TicTacToe() {
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(Color.CYAN);
		mainPanel.setFont(appletFont);
		
		newGameButton.addActionListener(this);
		
		topPanel.add(newGameButton);
		topPanel.add(scoreline);
		mainPanel.add(topPanel, "North");
		centerPanel.setLayout(new GridLayout(3,3));
		mainPanel.add(centerPanel, "Center");
		mainPanel.add(score, "South");
		
		for (int i=0;i<9;i++) {
			squares[i] = new Button();
			squares[i].addActionListener(this);
			squares[i].setBackground(Color.ORANGE);
			centerPanel.add(squares[i]);
		}
		
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
		String theWinner="";
		emptySquaresLeft--;
		if (emptySquaresLeft==0) {
			return "T"; }
		
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
		
		return theWinner;
		
	}  //конец метода lookTheWinner()
	
	/*
	Метод computerMove() применяет набор правил, чтобы найти
    лучший компьютерный ход. Если хороший ход
	не найден, выбирается случайная клетка. 
	Опишем его поведение:
	*/
	
	void computerMove() {
		int selectedSquare;
		selectedSquare=findEmptySquare("O");
		
		if (selectedSquare==-1) {
			selectedSquare=findEmptySquare("X");
		}
		
		if ((selectedSquare==-1)&&(squares[4].getLabel().equals(""))) {
			selectedSquare=4;
		}
		
		if (selectedSquare==-1) {
			selectedSquare=getRandomSquare();
		}
		
		squares[selectedSquare].setFont(buttonsFont);
		squares[selectedSquare].setLabel("O");
		squares[selectedSquare].setEnabled(false);
		
	} //конец метода computerMove()
	
	/**
	Метод findEmptySquare() проверяет каждый ряд, колонку и диагональ
	чтобы узнать, есть ли в ней две клетки с одинаковыми надписями и пустой клеткой.
	В параметрах метода передается X – для пользователя и O – для компьютера.
	Метод возвращает (тип возвращаемых данных - int) количество свободных клеток,
	или -1, если не найдено две клетки с одинаковыми надписями (X или O).
	*/
	
	int findEmptySquare(String player) {
		
		int weight[] = new int[9];
		
		for ( int i = 0; i < 9; i++ ) {
		if ( squares[i].getLabel().equals("O") )
		weight[i] = -1;
		else if ( squares[i].getLabel().equals("X") )
		weight[i] = 1;
		else
		weight[i] = 0; }
		
		int twoWeights = player.equals("O") ? -2 : 2; //узнать функции строки
		
		// Проверим, есть ли в ряду 1 две одинаковые клетки и
		// одна пустая.
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
				//возвращаем -1, если не найдено двух одинаовых соседних клеток
				return -1; 
		
	} //конец метода findEmptySquare()
	
	/*
	Метод getRandomSquare() выбирает любую пустую клетку
	и возвращает случайно выбранный номер клетки с помощью int
	*/
	
	int getRandomSquare() {
		
		boolean gotEmptySquare=false;
		int selectedSquare=-1;
		
		do {
			selectedSquare=(int) (Math.random()*9);
			if (squares[selectedSquare].getLabel().equals("")) {
				gotEmptySquare=true; //прерываем цикл
			}
			
		} while (!gotEmptySquare);
		
		return selectedSquare;
		
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
	
public void actionPerformed(ActionEvent e) {
		
		Button theButton = (Button) e.getSource();
		
		if (theButton==newGameButton) {
			for (int i=0;i<9;i++) {
				squares[i].setEnabled(true);
				squares[i].setLabel("");
				squares[i].setBackground(Color.ORANGE);
			}
			
			emptySquaresLeft=9;
			score.setText("Твой ход!");
			newGameButton.setEnabled(false);
			return;
		}
		
		String winner="";
		
		for (int i=0;i<9;i++) {
			if (theButton==squares[i]) {
				squares[i].setFont(buttonsFont);
				squares[i].setLabel("X");
				squares[i].setEnabled(false);
				winner=lookForWinner();
				
				if (!"".equals(winner)) {
					endTheGame();
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
		
		if (winner.equals("X")) {
			score.setText("Ты победил!");
			playerscore++;
		} else if (winner.equals("O")) {
			score.setText("Ты проиграл!");
			aiscore++;
		} else if (winner.equals("T")) {
			score.setText("Это ничья!");
		}
		
		scoreline.setText("Счет: "+playerscore+":"+aiscore);
		
	} //конец метода ActionPerformed()
	

} //конец класса
