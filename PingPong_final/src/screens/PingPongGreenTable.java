package screens;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Color;
import engine.PingPongGameEngine;

//����� ������ ���� ��� ����-�����, ���, �������, ���������� ����

public class PingPongGreenTable extends JPanel implements GameConstants {
	
	/*
	 ��������� ����������� ���������� � ������ �� ��������. ���������� ��������
	 ��������� ������������ GameConstants. ���������� �������, ��� �����
	 �������� ����� ������ ��������� ���������� �������, ����� ���� �����, ���
	 ��� �� ������ ����������, � ������ ���������. ���� ����� ���������
	 ����������� GameConstants.
	 */
	
	private JLabel label;
	private int computerRacket_Y=COMPUTER_RACKET_Y_START;
	private int kidRacket_Y=KID_RACKET_Y_START;
	private int ballX=BALL_START_X;
	private int ballY=BALL_START_Y;
	
	/*
	 ��� ����, ����� ���������� ������� �����, ��������� ��������� ������
	 Dimension �� Swing. JVM ���������� ����� � �������� ����, ������� ���
	 �������� ����� getPreferredSize(). ���� ����� (������) ����������
	 ������ Dimension, ������� ������ � ������������ � ��������� �����
	 */
	
	/*
	 ������� ��������� � ���������� preferredSize, ��������� � �����������
	 ������ Dimension ��� ��������� ������������ ����� � ������ �����
	 */
	Dimension preferredSize=new Dimension(TABLE_WIDTH,TABLE_HEIGHT);
	/*
	 ��������� �����-������, ������������ �������� ���������� preferredSize
	 ������ Dimension
	 */
	public Dimension getPreferredSize() {
		return preferredSize;
	}
		
	/*
	 �����������. ������� ��������� ������� PingPongGameEngine, ��� ����
	 �������� � ���� ������ �� ���� ������ � ������� this ��� �������� ����������
	 table, ���������� ������ �� ���� ������.
	 ������������ ���������� ��� ���� � ����������.
	 */
		PingPongGreenTable() {
			
			PingPongGameEngine gameEngine=new PingPongGameEngine(this);
			addMouseMotionListener(gameEngine);
			addKeyListener(gameEngine);
		} //����� ������������
		
	/*
	 ������� � ���� ������ c JLabel. ����� ��������� � ���� ��������� ����������
	 container ���� Container (�������� ��������� ������� JPanel), � ����� �������������
	 �� ��� �� ������ ����� ���������� (BoxLayout) � ��������� ������ � ����.
	 ����� ��������� ������� � ����� ����������� �� ������.
	 */
		
		void addPaneltoFrame (Container container) {
			
			container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
			container.add(this); //��������� �� ���� ������, this - ����� ����������� �� JPanel
			label=new JLabel("'N'- ����� ����, 'Q'- �����, '8' , '5' ��� ���� - ���������� ��������, "
					+ "'A' , 'Z'- �������� ����");
			container.add(label); //��������� ������� �� ������
			
		}
		
	/*
	 ������������ ����. ���� ����� �������� JVM, ����� ����� �������� ���� ��� ����������
	 ����� repaint() �� PingPongGameEngine
	 */
		
		public void paintComponent(Graphics g) {
	/*
	 ��������� � ������ paintComponent() � ������� ��������� ����� super. ��� �����
	 ����������� �� ������ JPanel, � ���, � ���� �������, ����������� �� ������
	 JComponent, � ������� � ������� ������ �����. ������� ������:
	 
	 super, ������ ����� �������, ���� ����������� ���������� � ������ ����� 
	 ������������� ������ - ������ ��� ����������, ���� ��� �� ���������� �������������
	 private.
	 
	 ����� paintComponent() ����� ����� ���� ���� ������ ������� repaint(), 
	 ������������ � ������ Component. ������ ������ repaint() ����������� � ���, 
	 ��� Swing ������������� ������� ������� �� ������ � ��������� ����� paintComponent() 
	 ��� ����������� ������� �� ���� ������.
	 
	 �� ������ �� �����, ��� ��� ������ ������ paintComponent() ������ PingPongGreenTable
	 � ���������� g ���� Graphics, �� �������� paintComponent() ������ JComponent, � ����
	 �� ���������� ��� ������ ����������� �����, � �����, ����� g ������������� ���������
	 �����������, ����� ��� ���� �����, ��� ������, �������, ��� �� ���������� � �.�.
	 */
			super.paintComponent(g);
			
			//���������� ������� ����
			g.setColor(Color.green);
			g.fillRect(0,0,TABLE_WIDTH, TABLE_HEIGHT);
			
			//���������� ������ �������
			g.setColor(Color.yellow);
			g.fillRect(KID_RACKET_X, kidRacket_Y, RACKET_WIDTH, RACKET_LENGTH);
			
			//���������� ����� �������
			g.setColor(Color.blue);
			g.fillRect(COMPUTER_RACKET_X, computerRacket_Y, RACKET_WIDTH, RACKET_LENGTH);
			
			//���������� ���
			g.setColor(Color.red);
			g.fillOval(ballX, ballY, 10, 10);
			
			//���������� ����� �����
			g.setColor(Color.white);
			g.drawRect(10,10,620,340);
			g.drawLine(320,10,320,350);
			
			//���������� ����� �� ����, ����� ���������� ���������� ��� �������� ������� �����
			requestFocus();
		}
		
		/*
		 ������������� ������� ��������� ������� ������, � ������� ������-������� setKidRacket_Y()
		 �� ��������� � ���� ��������� ���������� yCoordinate ���� int � ������ ��������� �������� ����� 
		 ���������� kidRacket_Y, ����������� � ������ ������.
		 */

		public void setKidRacket_Y(int yCoordinate) {
			this.kidRacket_Y=yCoordinate;
			repaint(); //�������������� ����, ������� ����� paintComponent() � ������� ������ repaint()
		}
		
		//������, ������������ ������� ��������� ������� ������
		public int getKidRacket_Y() {
			return kidRacket_Y;
		}
		
		//������������� ������� ��������� ������� ����������
		public void setComputerRacket_Y(int yCoordinate) {
			this.computerRacket_Y=yCoordinate;
			repaint();
		}
		
		//���������� ������� ���������-����� ��������� ������ � ���� ��������� � ������������� ��
		public void setMessageText(String text) {
			label.setText(text);
		}
		
		//���������� ������� ����
		public void setBallPosition(int xPos, int yPos) {
			ballX=xPos;
			ballY=yPos;
			repaint();
		}
		
		public static void main(String[] args) {
			
			//������� ��������� ����
			JFrame f=new JFrame ("Ping Pong Green Table");
			
			//���� ����������� ������� ���������� ��� �������� ���� [�]
			f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			/*
			 ������� ��������� ������� ����� ������ � ��������� ������ � ���������� �� ����
			 ����� ������ ������ ������ ���� addPanelToFrame() � ���������� f.getContentPane()
			 */
			
			PingPongGreenTable table=new PingPongGreenTable();
			table.addPaneltoFrame(f.getContentPane());
			
			//������������� ������ ���� � ������ ���� �������
			f.setBounds(0, 0, 656, 420);
			f.setResizable(false);
			f.setVisible(true);
		}
}
