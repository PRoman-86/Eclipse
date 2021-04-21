/*
Класс для реализации прктического задания "Для умников и умниц".

1.  Перепишите  TicTacToe,  чтобы  заменить 
одномерный  массив,  который  хранит  кнопки 
JButton squares[]
на  двумерный  массив  3x3: 
JButton squares[][]
2.  Почитайте  про  многомерные  массивы  в 
интернете.
*/

import java.awt.*; import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {
	
	public static void main(String[] args) {
		new TicTacToe(); }
	
	Button squares[][] = new Button[3][3]; //объявляем многомерный массив
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
		
		/*создаем цикл в цикле. Цикл с переменной i добавит строки,
		а цикл с переменной p добавит столбцы.
		По теории, два индекса массива называются индексом строки и
		индексом столбца.
		*/
		for (int i=0;i<3;i++) {
			for (int p=0;p<3;p++) {
				
			squares[i][p] = new Button();
			squares[i][p].addActionListener(this);
			squares[i][p].setBackground(Color.ORANGE);
			centerPanel.add(squares[i][p]);
		}
		  } //создание кнопок закончено
		
		frame.add(mainPanel);
		frame.setSize(450, 400);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	
	
public void actionPerformed(ActionEvent e) {
		
		System.out.print("event ");
		
	} //конец метода ActionPerformed()
	

} //конец класса
