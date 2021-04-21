/*
���� "��������-������" �� ����� 3�3. � ����� ��������������, ��� ��� �����
�������� � ���� �������, ��� ������������� ������������ ������� ���������
������� � ���� � ���������� ����� ����� � ��������� � ���� main(). 
��� ��� ������� ��������, ��� ���������� �� ���������������� � �����.
��� ������� ��� ����� ������������ �������, �� ���� �������� ���������
��������� ���������� ������, ������� ������ ���� ������ � ��������
���������� ������������ �������. � ���������, �� ����������� ����, � �������
������ ���.
*/

import java.awt.*; import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {
	
	public static void main(String[] args) {
		new TicTacToe(); }
	
	//������� ����� ��� ����� ������ ���������� � ���������� ����������
	Button squares[] = new Button[9];
	Button newGameButton = new Button("����� ����");
	Panel mainPanel = new Panel();
	Panel topPanel = new Panel();
	Panel centerPanel = new Panel();
	Label score = new Label("���� ���!");
	JFrame frame = new JFrame("TicTacToe Game");
	int emptySquaresLeft=9;
	Font appletFont=new Font("Monospased",Font.BOLD, 20);
	Font buttonsFont=new Font("Monospased",Font.BOLD,55);
	
	//��������� �����������
	TicTacToe() {
		//��������� ����� ����������, ������ � ����� ����������
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(Color.CYAN);
		mainPanel.setFont(appletFont);
		//������������ ��������� �� ������ ����� ����. ��� ��� �����
		//������������ �������� � ���������, � ��������� this
		newGameButton.addActionListener(this);
		//���������, ����������� � ������� ������ � ���������� ���������� ����������
		topPanel.add(newGameButton);
		mainPanel.add(topPanel, "North");
		centerPanel.setLayout(new GridLayout(3,3));
		mainPanel.add(centerPanel, "Center");
		mainPanel.add(score, "South");
		//� ������� ������� � ����� ������� ������ ������ �������� ����,
		//������������ �� ��� ���������, ������������ ������ � ���������
		//�� ������
		for (int i=0;i<9;i++) {
			squares[i] = new Button();
			squares[i].addActionListener(this);
			squares[i].setBackground(Color.ORANGE);
			centerPanel.add(squares[i]);
		}
		//����������� ����� ��������� ���� � ��������� �� ���� ������� ������,
		//���������� ��������� ������ � ����������
		frame.add(mainPanel);
		frame.setSize(450, 400);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	/*
	����� lookForWinner() ���������� ����� ������� ����, ����� ������,
	���� �� ����������. �� ��������� ������ ���, �������
	� ���������, ����� ����� ��� ������ � ����������� ���������
	(�� �������).
	 �� ���������� "X" ��� "O", ���� "T" � �����, � ����� "" (�����) - ��� ���
	 �� ����������, �� �����. ������, ��� ����� ���� String, �.�. ����������
	 �����.
	 ���� �� ��������� ��� ���������:
	*/
	
	String lookForWinner() {
		String theWinner=""; //������� ���������� ���� String
		emptySquaresLeft--; //��������� ���������� �� ������� ��� ������ ����
		//��� ���������� ��� ������ ���� ������ ��� ��������� ��������� ����������
		//��������� ������ (������) ���� �� ����. �� ��������� �������� ����� 9,
		//��� ��������� � ������ ��� ����� ��� ����� ������.
		
		//������� �������: ���� ���������� ��������� ������ �������������� � ����,
		//��, ����� lookForWinner() ����� ������ "�", �� ���� �����.
		if (emptySquaresLeft==0) {
			return "T"; }
		
		/*
		���� ������� ���� ��������� ������ ���, ������� � ���������,
		�� ���������� �������� �� ������ �������� ���������� theWinner,
		������� ����� ����� �������� X ���� �.
		
		����� ������������ ������� ��������� � ��������, ������� ��� ����� �������
		���������, �������� �� �� ������. ����� � ������� ������������ ����������
		�������� "�" � ������� ����������� &&, ������� ��������� �� ��, ���
		��� ��������� ������ ���� ��������� ������������, �� ��� ����, ���� ������
		��������� ����� ������, ��������� ����������� �� �����, ��� ��� ��� ����������
		�������������. ��������� ��� ��������� �� ������� ������� �������:
		
		(!squares[0].getLabel().equals("") && squares[0].getLabel().equals(squares[1].getLabel()) && squares[0].getLabel().equals(squares[2].getLabel()))
		   
		  ����������� ������ ����� �������: !squares[0].getLabel().equals("") ��� ��������: "������ ������ �� ������". ������������ ���������
		  �������� ������� �� ������, ��� ���� �, ���� �, ���� "�����". ���� ��� ��� � ����, � ������ ������ �� ������,
		  �� ��������� ��������� �� ������ ����� �������:
		  
		  squares[0].getLabel().equals(squares[1].getLabel()) && squares[0].getLabel().equals(squares[2].getLabel())
		
		  ��������� ������ ��������� ������� �������: squares[0].getLabel().equals(squares[1].getLabel())
		  ��������� �������� ������� ������ ������ � ������������ � ������� equals() � ������. ���� ���������
		  �������, �� ���� ������� �� ������ � ������ ������� ���������, ��������� ��������� �� ������� ���������
		  ������� ������� squares[0].getLabel().equals(squares[2].getLabel() � ������� ����� �� ������� ��������
		  ������� �� ������� ������ � ����� ���������� �� � ������.
		  
		  �� ������ ��������: if (������ ������ �� ������, �� ��� ������������ �� ������, � ����� � �������). 
		  � ������, ���� ��� ������ ��������� �� ��������, ����� lookForWinner() ���������� ���������� (� ��� �) 
		  � ������� ���������� theWinner,������� ����� ������� � ������ ������.
		  ���� �� ���� �� ���� ������ ���������� ��� ������, �� ��������� ��������� � ���� ����� ����� else.
		  
		  ������ �������, ������� ���� ��������� ������ highlightWinner(), ������� ����� �� ����������, � ������
		  ���������� ���������� ���������� ������ � ������ ���� ��� �������. ���� ����� ���������� ����.
		  
		  ����� ��� �������������� ��������.
		  
		  
		 */
		
		// ��������� ��� 1 � �������� ������� 0,1,2
		if (!squares[0].getLabel().equals("") &&
		squares[0].getLabel().equals(squares[1].getLabel()) &&
		squares[0].getLabel().equals(squares[2].getLabel())) {
		theWinner = squares[0].getLabel();
		highlightWinner(0,1,2);
		// ��������� ��� 2 � �������� ������� 3,4,5
		} else if (!squares[3].getLabel().equals("") &&
		squares[3].getLabel().equals(squares[4].getLabel()) &&
		squares[3].getLabel().equals(squares[5].getLabel())) {
		theWinner = squares[3].getLabel();
		highlightWinner(3,4,5);
		// ��������� ��� 3 � �������� ������� 6,7,8
		} else if ( ! squares[6].getLabel().equals("") &&
		squares[6].getLabel().equals(squares[7].getLabel()) &&
		squares[6].getLabel().equals(squares[8].getLabel())) {
		theWinner = squares[6].getLabel();
		highlightWinner(6,7,8);
		// ��������� ������� 1 � �������� ������� 0,3,6
		} else if ( ! squares[0].getLabel().equals("") &&
		squares[0].getLabel().equals(squares[3].getLabel()) &&
		squares[0].getLabel().equals(squares[6].getLabel())) {
		theWinner = squares[0].getLabel();
		highlightWinner(0,3,6);
		// ��������� ������� 2 � �������� ������� 1,4,7
		} else if ( ! squares[1].getLabel().equals("") &&
		squares[1].getLabel().equals(squares[4].getLabel()) &&
		squares[1].getLabel().equals(squares[7].getLabel())) {
		theWinner = squares[1].getLabel();
		highlightWinner(1,4,7);
		// ��������� ������� 3 � �������� ������� 2,5,8
		} else if ( ! squares[2].getLabel().equals("") &&
		squares[2].getLabel().equals(squares[5].getLabel()) &&
		squares[2].getLabel().equals(squares[8].getLabel())) {
			theWinner = squares[2].getLabel();
			highlightWinner(2,5,8);
			// ��������� ������ ��������� � �������� ������� 0,4,8
			} else if ( ! squares[0].getLabel().equals("") &&
			squares[0].getLabel().equals(squares[4].getLabel()) &&
			squares[0].getLabel().equals(squares[8].getLabel())) {
			theWinner = squares[0].getLabel();
			highlightWinner(0,4,8);
			// ��������� ������ ��������� � �������� ������� 2,4,6
			} else if ( ! squares[2].getLabel().equals("") &&
			squares[2].getLabel().equals(squares[4].getLabel()) &&
			squares[2].getLabel().equals(squares[6].getLabel())) {
			theWinner = squares[2].getLabel();
			highlightWinner(2,4,6);
			
		}
		
		return theWinner; //���������� �������� ���������� - � ��� �
		
	}  //����� ������ lookTheWinner()
	
	/*
	����� computerMove() ��������� ����� ������, ����� �����
    ������ ������������ ���. ���� ������� ���
	�� ������, ���������� ��������� ������. ����� ������ ��
	����������. ����� �������� ������ � �������� findEmptySquare()
	� getRandomSquare().
	������ ��� ���������:
	*/
	
	void computerMove() {
		/*
		��������� ���������� ��� �������� ������������� ������� findEmptySquare()
		�������� � ��������� ������� ��� ����. � ����� �� ��������� �� ������
		����� ������������� � ������ findEmptySquare(), �������� � ��������� "�"
		�������� ���������� �� ����������� ������ findEmptySquare() ����� -1,
		���� �� ����� ������� ���� ������ � ����������� ��������� � ��� �.
		� ���� �� ������ ���� �������� �������� �� 0 �� 8.
		 */
		int selectedSquare; 
		selectedSquare=findEmptySquare("O");
		/*
		���� ����� ������ -1 ����� ����������, �� ��������� ������ ������,
		�� ��� � ���������� �.
		 */
		if (selectedSquare==-1) {
			selectedSquare=findEmptySquare("X");
		}
		/*
	    ���� ����� ������ -1 � ������������ ����������� ������
	    ���� ������, �� ����������� ���������� selectedSquare �������� 4
	    (4 - ������ ����������� ������ ���� � �������)
		 */
		if ((selectedSquare==-1)&&(squares[4].getLabel().equals(""))) {
			selectedSquare=4;
		}
		/*
		���� ����� ������ -1, �� ����������� ������ ���� ������, ��
		�������� ���������� selectedSquare ����� ���������� � ����������
		������ ������ getRandomSquare(), ������� ���������� ��������� ��������,
		�.�. ��������� ������� ��� ������.
		 */
		if (selectedSquare==-1) {
			selectedSquare=getRandomSquare();
		}
		/*
		��� ������ ���� ���������� ��������� ���� ���������� (�). ����������
		selectedSquare ��������� ��� ������ ������� � ��������.
		 */
		squares[selectedSquare].setFont(buttonsFont); //������������� ����� ��� ������
		squares[selectedSquare].setLabel("O"); //������ ����� �� ������
		
	} //����� ������ computerMove()
	
	/**
	����� findEmptySquare() ��������� ������ ���, ������� � ���������
	����� ������, ���� �� � ��� ��� ������ � ����������� ��������� � ������ �������.
	� ���������� ������ ���������� X � ��� ������������ � O � ��� ����������.
	����� ���������� (��� ������������ ������ - int) ���������� ��������� ������,
	��� -1, ���� �� ������� ��� ������ � ����������� ��������� (X ��� O).
	*/
	
	int findEmptySquare(String player) {
		
		int weight[] = new int[9]; //��������� ������
		/*
		� ������� ����� ��������� ������ ������ ���� � ��������
		������� ��������� ����.
		 */
		for ( int i = 0; i < 9; i++ ) {
		//���� ������ �������� �����, �� �����. ������ ������� ����� ����� �������� -1
		if ( squares[i].getLabel().equals("O") ) 
		weight[i] = -1;
		//���� ������ �������� �������, �� �����. ������ ������� ����� ����� �������� 1
		else if ( squares[i].getLabel().equals("X") )
		weight[i] = 1;
		//������ ������ - �������� = 0
		else
		weight[i] = 0; }
		
		/*
		����� ����������� int-����������, ������� ����� �����
		�������� ���� -2, ���� 2 � ����������� �� ����, ����� �� ���������
		player.equals("O"). �� ���� ���� � ����� ���������� �������� "�"
		����������� String-���������� player, ������� � ��������� ������,
		�� twoWeights ����� ����� -2, ���� ���������� "�", �� 2.
		����� equals() ���������� �������� ������ ��������� � ��������
		player. ����� ���� ����������� ����� if-else, �� ��� �������� �����
		���������. 
		 */
		
		int twoWeights = player.equals("O") ? -2 : 2;
		
		/*��������, ���� �� � ���� 1 ��� ���������� ������ �
		 ���� ������.
		������ ���� if-else ����� ��� ���������� ����� if-else
		*/
		
		/*
		� �������� ������� ����� ��� ���������� ������� weight[] ��� ����� ������������
		�������� �������� (��. ����), ��� ���� 1, ���� -1, ���� 0. �������� �������
		�������� ����������� ������ (�� 0 �� 8). ���������� twoWeights ����� �����
		�������� ���� -2, ���� 2. � ��������� ����������� �� ��������� �������� ���������
		������� � ����������. ��������, ��� ������ ����� |X| |X|:   1+0+1 == 2 (�������)
		���� �������� ������� �������, �� � ���� �������� ���������� �����:
		
		�� ����� ���������� ����� if-else ����������� �� ��������� � ���� �������� ������ ������
		����, � weight[0] == 0 ����� �������, ���� ������ ������ ���� ����� ������. ���� 
		��� � ����, �� ����� ������ 0.
		� ������ ���������� ����� if-else ����������� �� ��������� � ���� �������� ������ ������
		����. ���� ��������� �������, �� ����� ������ 1.
		���� ��� ������ �� ������, �� ����� ������ 2.
		����������, ��� ���������� ����� ����������, � ����� ������ ���� ������� ��� ���������.
		
		� ����� ������ |X| |X| ��������� ������� weight[1] == 0, ����� ������ 1, � ���������
		������ �� ������ ������ ����.
		
		����� �������, ����� ���������� ��������, ������� ����� �������� � ���������� selectedSquare,
		������� ���� ����������� � ������ computerMove() � �������� �������� �� ��, � ����� ������
		������ ���������. ����� ����� ����� ������� -1, ����� � ���� �������� �������, �������������
		� computerMove() ����.
		 */
		if ( weight[0] + weight[1] + weight[2] == twoWeights ) {
		if ( weight[0] == 0 )
		return 0;
		else if ( weight[1] == 0 )
		return 1;
		else
		return 2;
		}
		// ��������, ���� �� � ���� 2 ��� ���������� ������ �
		// ���� ������.
		if (weight[3] +weight[4] + weight[5] == twoWeights) {
		if ( weight[3] == 0 )
		return 3;
		else if ( weight[4] == 0 )
		return 4;
		else
		return 5;
		}
		// ��������, ���� �� � ���� 3 ��� ���������� ������ �
		// ���� ������.
		if (weight[6] + weight[7] +weight[8] == twoWeights ) {
		if ( weight[6] == 0 )
		return 6;
		else if ( weight[7] == 0 )
		return 7;
		else
		return 8;
		}
		// ��������, ���� �� � ������� 1 ��� ���������� ������ �
		// ���� ������.
		if (weight[0] + weight[3] + weight[6] == twoWeights) {
		if ( weight[0] == 0 )
		return 0;
		else if ( weight[3] == 0 )
		return 3;
		else
		return 6;
		}
		// ��������, ���� �� � ������� 2 ��� ���������� ������
		// � ���� ������.
		if (weight[1] +weight[4] + weight[7] == twoWeights ) {
		if ( weight[1] == 0 )
		return 1;
		else if ( weight[4] == 0 )
		return 4;
		else
		return 7;
		}
		// ��������, ���� �� � ������� 3 ��� ���������� ������
		// � ���� ������.
		if (weight[2] + weight[5] + weight[8] == twoWeights ){
		if ( weight[2] == 0 )
		return 2;
		else if ( weight[5] == 0 )
		return 5;
		else
		return 8;
		}
		// ��������, ���� �� � ��������� 1 ��� ���������� ������
		// � ���� ������.
		if (weight[0] + weight[4] + weight[8] == twoWeights ){
			if ( weight[0] == 0 )
				return 0;
				else if ( weight[4] == 0 )
				return 4;
				else
				return 8;
				}
				// ��������, ���� �� � ��������� 2 ��� ���������� ������
				// � ���� ������.
				if (weight[2] + weight[4] + weight[6] == twoWeights ){
				if ( weight[2] == 0 )
				return 2;
				else if ( weight[4] == 0 )
				return 4;
				else
				return 6;
				}
				//���������� -1, ���� �� ������� ���� ���������� �������� ������
				return -1; 
		
	} //����� ������ findEmptySquare()
	
	/*
	����� getRandomSquare() �������� ����� ������ ������
	� ���������� �������� ��������� ����� ������ � ������� int
	*/
	
	int getRandomSquare() {
		
		/*��������� ���������� ���� boolean �� ��������� false
		  ��� ����� ������ �������� �� true, ���� � �������� ��������
		  ������ �������� ������, ��� ��� ��������� �������� ����� ���������
		  �� ��������� ������, ������� ��� ������.
		 */
		boolean gotEmptySquare=false; 
		int selectedSquare=-1; //������� ��������� ���������� ���� int �� ��������� -1
		/*
		��������� ����, ������� ���������, ���� ���������� gotEmptySquare ����� �����
        ��������������� �������� (true) �� ���������� (false).
		 */
		do {
			selectedSquare=(int) (Math.random()*9); //��������� ��������� ���������� ������ �����
			/*
			���� ���������� ��������� �������� � ���������� �� 0 �� 9 ������� �� ������ ������,
			�� ���� ����������� � ����� ��������� ���������� ��������.
			���� ������� �� ������� ������, �� ����� ������ -1, ��� ������
			�� �����, � ���� ������ �� �����.
			 */
			if (squares[selectedSquare].getLabel().equals("")) {
				gotEmptySquare=true; //��������� ����
			}
			
		} while (!gotEmptySquare); //������� ���������� �����
		
		return selectedSquare; //������� ��������
		
	} //����� ������ getRandomSquare()
	
	/*
	����� highlightWinner() �������� ���������� �����.
	� ���������� ������ ������, ������ � ������ ������ ��� ���������.
	���������� ������ �� ���������, ������� void.
	*/
	
	void highlightWinner(int win1,int win2,int win3) {
		squares[win1].setBackground(Color.CYAN);
		squares[win2].setBackground(Color.CYAN);
		squares[win3].setBackground(Color.CYAN);
	} //����� ������ highlightWinner()
	
	/*
	����� endTHeGame() ������ ������������ ������ ���� � � �� ��
	����� ��������� ������ ����� ����. 
	*/
	
	void endTheGame() {
		newGameButton.setEnabled(true);
		for (int i=0;i<9;i++) {
			squares[i].setEnabled(false);
		}
	} //����� ������ endTheGame()
	
      //��������� ����� ���������
public void actionPerformed(ActionEvent e) {
		
		Button theButton = (Button) e.getSource(); //�������� �������� ������� � ����������� � ������ Button
		
		//��������� ������� ������ ����� ����
		if (theButton==newGameButton) {
			for (int i=0;i<9;i++) {
				squares[i].setEnabled(true); //������������� ������ ����
				squares[i].setLabel(""); //������� �������� �� ������� ����
				squares[i].setBackground(Color.ORANGE); //����������� ������ ����
			}
			
			emptySquaresLeft=9; //���������� ���������� ���-�� ��������� ������ � ��������� ��������
			score.setText("���� ���!"); //����� � �������������� ������ ��������� � ������
			newGameButton.setEnabled(false); //��������� ������ ����� ����
			return; //������� �� �����
		}
		
		/*��������� ���������� � ������ ���������.
		 ��� ����� ��������� ��������, ������������ �������� ������ lookForWinner(),
		 �� ���� �,�,� ��� "" (�����).
		*/
		String winner=""; 
		
	    //��������� ��� ������
		for (int i=0;i<9;i++) {
			if (theButton==squares[i]) {
				squares[i].setFont(buttonsFont);
				squares[i].setLabel("X");
				winner=lookForWinner(); //����������� ���������� ������������ �������� ������
				
				
				//���� ���������� ����� �� ������ ��������, �� ���� �������������
				
				if (!"".equals(winner)) {
					endTheGame();
					//� ��������� ������ ������������
				} else {
					computerMove();
					winner=lookForWinner();
					
					if (!"".equals(winner)) {
						endTheGame();
					}
				}
				break;
			}
		} //����� ����� for
		
		//����������� ������ �������������� ������ ��� ������
		if (winner.equals("X")) {
			score.setText("�� �������!");
		} else if (winner.equals("O")) {
			score.setText("�� ��������!");
		} else if (winner.equals("T")) {
			score.setText("��� �����!");
		}
	} //����� ������ ActionPerformed()
	

} //����� ������
