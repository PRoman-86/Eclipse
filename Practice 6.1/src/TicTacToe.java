/*
����� ��� ���������� ������������ ������� "��� ������� � �����".

1. ����������� �TicTacToe, ������ ��������� 
���������� �������, �������� ������� ������� 
JButton squares[]
�� ���������� ������� �3x3: 
JButton squares[][]
2. ���������� ���� ������������ �������� �� 
���������.
*/

import java.awt.*; import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {
	
	public static void main(String[] args) {
		new TicTacToe(); }
	
	Button squares[][] = new Button[3][3]; //��������� ����������� ������
	Button newGameButton = new Button("����� ����");
	Panel mainPanel = new Panel();
	Panel topPanel = new Panel();
	Panel centerPanel = new Panel();
	Label score = new Label("���� ���!");
	Label scoreline = new Label ("����: 0:0"); 
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
		
		/*������� ���� � �����. ���� � ���������� i ������� ������,
		� ���� � ���������� p ������� �������.
		�� ������, ��� ������� ������� ���������� �������� ������ �
		�������� �������.
		*/
		for (int i=0;i<3;i++) {
			for (int p=0;p<3;p++) {
				
			squares[i][p] = new Button();
			squares[i][p].addActionListener(this);
			squares[i][p].setBackground(Color.ORANGE);
			centerPanel.add(squares[i][p]);
		}
		  } //�������� ������ ���������
		
		frame.add(mainPanel);
		frame.setSize(450, 400);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	
	
public void actionPerformed(ActionEvent e) {
		
		System.out.print("event ");
		
	} //����� ������ ActionPerformed()
	

} //����� ������
