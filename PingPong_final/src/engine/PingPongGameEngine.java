package engine;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import screens.*;

/*
 ���� ����� - ���������� ������� ���� � ����������, � ����� �� ������������ ��������
 ���� � �������, ��������� �� ��������� � �������� ����. ����� ��������� ����. ����������:
 Runnable ��� �������� ������������� ������, MouseMotionListener ��� ��������� �������� ����,
 KeyListener ��� ��������� ������� ������ ���������� � GameConstants, �������� final-���������� (���������).
 */

public class PingPongGameEngine implements Runnable, MouseMotionListener, KeyListener, GameConstants {
	
	private PingPongGreenTable table; //���������� table ����� ��������� ������ �� PingPongGreenTable
	private int kidRacket_Y=KID_RACKET_Y_START; //��������� �������� ������� ������
	private int computerRacket_Y=COMPUTER_RACKET_Y_START; //��������� �������� ������� ����������
	private int kidScore; //����� ��������� ���� ������
	private int computerScore; //����� ��������� ���� ����������
	private int ballX; //����� ��������� ������� ���������� � ����
	private int ballY; //����� ��������� ������� ���������� Y ����
	private boolean movingLeft=true; //�������� ���� �������� ���� �����
	private boolean ballServed; //�������� ���� �������� ���� (������)
	private int verticalSlide; //����� ��������� �������� ������������� ������������ (���) ���� � ��������
	private int level=SLEEP_TIME; //������ ���������� ��� ��������� ������� ������������ ������ (��������)
	
	/*
	 �����������. ����������� ���������� table ������ �� ������ ����� (PingPongGreenTable) ����� ����
	 ��������. ����������� � ��������� ������������ ��������� ���������� greenTable ������
	 PingPongGreenTable �������� ������ �� ����� ����� ����� this ��� ���������� ���������� ����� ������
	 � ������ �����.
	 ����� ����������� ������� ������������ �����, ���������� ������ �� ���� ���������� worker ������
	 Thread. This � ��������� ��������, ��� ����� ����� ���������� (����� ����� run()) � ���� �� ������.
	 ����� start() ��������� ����� - ���, ������� �������� ����� run().
	 */
	
	public PingPongGameEngine(PingPongGreenTable greenTable) {
		table=greenTable; //�������� ������ �� ����� ����� ���������� table �� greenTable ���������
		
		Thread worker=new Thread(this); //������� ������������ �����
		worker.start(); //��������� ������������ �����
	}
	
	//����� ����������� ������ ���������� MouseMotionListener. �������� ��� ������ ����� �����.
	
	public void mouseDragged(MouseEvent e) { } //������ �����
	
	public void mouseMoved(MouseEvent e) { //�������� ����
		
		int mouse_Y=e.getY(); //������� ���������� ������� ���� �� ��� Y � ���������� mouse_Y
		
		/*
		 ���� ������ ���� ��������� ���� ������� ������ � ��� ���� �� ������� �� ������� �����,
		 �� ����������� ������� �����, � ��������� ������ - �������� ������� ����
		 */
		
		if (mouse_Y<kidRacket_Y && kidRacket_Y>TABLE_TOP) {
			kidRacket_Y-=RACKET_INCREMENT; //����������� ������� �����
		} else if (kidRacket_Y<TABLE_BOTTOM) {
			kidRacket_Y+=RACKET_INCREMENT; //����������� ������� ����
		}
		
		//������������� ��������� ������� �� ����� ��� ��������� ����� table � ����� �����
		//����� ������ ������-������� setKidRacket() ������ PingPongGreenTable � ��������
		//������� ���������� �������� ������ ����� �������� ��� ���������
		table.setKidRacket_Y(kidRacket_Y);
		
	}
	
	//����� ����������� ������ ���������� KeyListener. �������� ��� ������ ����� �����.
	
	public void keyPressed(KeyEvent e) {
		
		char key=e.getKeyChar(); //������� ������� ������ ���������� � ���������� key
		
		//��������� ������� ��� ������� ������ N, Q, S. ��� ���������, ��� � ��������
		
		if (key=='n' || key=='N') {
			startNewGame(); //������ ����� ����
		} else if (key=='q' || key=='Q') {
			endGame();
			/*
			 ��������� ����� ������� �������� A � Z �� ���� ����� ������� ������������ ������.
			 ����� ��������� ������� - 10 ��, ����� ������� 1 ��. 
			 � ���� �� ����� ����������� ���������� �������� ��������� 8 � 5
			 */
		} else if (key=='a' || key=='A') {
			level--;
			if (level<1) level=1;
		} else if (key=='z' || key=='Z') {
			level++;
			if (level>10) level=10;
		} else if (key=='8') {
			kidRacket_Y-=RACKET_INCREMENT+10;
			if (kidRacket_Y<TABLE_TOP) kidRacket_Y=TABLE_TOP;
			table.setKidRacket_Y(kidRacket_Y);
		} else if (key=='5') {
			kidRacket_Y+=RACKET_INCREMENT+10;
			if (kidRacket_Y>TABLE_BOTTOM) kidRacket_Y=TABLE_BOTTOM;
			table.setKidRacket_Y(kidRacket_Y);
		}
		
	}
	
	public void keyReleased(KeyEvent e) { } //������ �����
	public void keyTyped(KeyEvent e) { } //������ �����
	
	//��������� ������ ����� ���� ��� ������� ������ N � ������ startNewGame()
	
	public void startNewGame() {
		//�������� ����
		computerScore=0; kidScore=0;
		//�������� ������� ����� ������ setMessageText() �� ����, ���������� label
		table.setMessageText("Score Computer: 0  Player: 0");
		kidServe();
		
	}
	
	//��������� ���������� ���� (�������� ���������) ��� ������� Q � ������ endGame()
	public void endGame() { System.exit(0); }
	
	/*
	 ����� ����������� ����� run() ���������� Runnable. ����� �������� ���, �������
	 ����� ����������� ��� ������������ �����. ���������� ������ ���������� �����
	 ������ ������ worker.start() � ������������������ ����� ������ ������ Thread.sleep() ��
	 �������� � ��� ��������� �����.
	 */
	
	public void run() {
		
		//����������, ������������ ���� ������� ���� �� �������
		boolean canBounce=false; //�������, ��� ��������� �������� ����� false
		
		//���������� ����, �������������� �������� ���� �� �����
		while (true) {
			
			if (ballServed) { //���� ��� ��������
			
				//���1: ���� ��� �������� �����, �.�. � ������� ������� ����������
				if (movingLeft && ballX > BALL_MIN_X) {
					
					//���������� ��� ���� �� ��� Y � ���-��� �� ��������� ����
					verticalSlide = (ballY>TABLE_HEIGHT/2) ?1:-1;
					
					/*
					 ���������� canBounce ����� ��������� �������� ���� true, ���� false �
					 ����������� �� ��������� ����. ��� ��������� ����������, �������� �� ���
					 �� ������� ���������� ����� ����� ������� ��������� ����, ������� ���������� ������
					 �������� ���� (������) ������� ���������� � �� ����� �� ��� Y.
					 ��������� ballY>=computerRacket_Y && ballY<(computerRacket_Y+RACKET_LENGTH) ��������, ���
					 ���� ������� ���������� �� ��� Y ���� ������ ���� ����� ������� ���������� �� ��� Y
					 ������ �������� ���� ������� ���������� � ��� ����(&&-������ �������� ��������� �� �����������, 
					 ���� ������ �����) ������� ���������� ���� �� ��� Y ������ ����� ������� � ������ �������
					 ���������� �� ���� (�� ���� ��� ����� � �������), �� ���������� canBounce ������� ��������
					 true, � ��������� ������ - false. 				 
					 */
					canBounce = (ballY>=computerRacket_Y && ballY<(computerRacket_Y+RACKET_LENGTH) ? true: false);
					
					ballX-=BALL_INCREMENT; //������� ��� ����� �����
					
					/*
					 ����� ������� �������� ���� �� ��� Y ��� �������� ���� �� ��� X, ����� �� �� �����
					 �������������, ��� �����, � �� ���������, � ������������� ��� ������� ���������� �����
					 ������ setBallPosition(), � ��������� �������� ����� ���������� ballY � ballY.
					 ����� ��������� � ������ �����, ������� ������ ��� ����� table.
					 */
					
					ballY-=verticalSlide;
					table.setBallPosition(ballX, ballY);
					
					/*
					 ��������� ������ ���� �� ������� ����������. ���� ������� ���������� ���� �� ��� � ������,
					 ���� ����� ����������� ������ �������� ���� ������� �� ��� �, �� ���� ��� ������ ��
					 ������� � ��� ����(&&-������ �������� ��������� �� �����������, ���� ������ �����)
					 �������� ���������� canBounce=true (�.�. ����� ���� ������� ����), �� �������� ����
					 ����� ������������ - ���������� movingLeft ������ �������� false.
					 */
					
					if (ballX<=COMPUTER_RACKET_X && canBounce) movingLeft=false;
					
					
				}
			}
			
			//���2: ���� ��� �������� ������, �.�. � ������� ������� ������
			if (!movingLeft && ballX <= BALL_MAX_X) {
				
				//����������� ������� ��� ����� �������, �� ��� �������� ���� ������ � ��� ������� ������
				canBounce = (ballY >= kidRacket_Y-2 && ballY <(kidRacket_Y+RACKET_LENGTH+2) ?true:false);
				
				//���������� ������� ��� ������ � ������������� ���������� ���� ��� ���������
				ballX+=BALL_INCREMENT;
				ballY-=verticalSlide;
				table.setBallPosition(ballX, ballY);
				
				//��������� ������, �� ���� ��� movingLeft ���������� true, �.�. ��� �������� �������� �����
				if (ballX>=KID_RACKET_X-5 && canBounce) movingLeft=true;
				
			}

		
		/*
		 ���3: ��������� ����������� ������� ���������� ��� ����������� ����.
		 ���� ���������� ������� �� ��� Y ������ ������� ��������� ���� �� ��� Y � ��� ����(&&-������ �������� 
		 ��������� �� �����������, ���� ������ �����) ���������� ������� ������, ��� ���������� ������ ������� �����,
		 �� ������� ���������� ����, ����� ���� ���������� ������� ������, ��� ���������� ������� �������
		 �����, �� ������� ������ �����.
		 ���� ������� ������, ��� ������� ����� ��������� �� ����� ����, � ����� ������������ � ������� ���������, ����
		 �� ���������� �� ������������ � ����������� �������� ������� �����. ������� ����� ���������� ���� ��� ���������
		 ����.
		 */
		
		if (computerRacket_Y < ballY && computerRacket_Y < TABLE_BOTTOM) {
			computerRacket_Y+=RACKET_INCREMENT;
		} else if (computerRacket_Y > TABLE_TOP) {
			computerRacket_Y-=RACKET_INCREMENT;
		}
		
		//������������� ���������� ������� ��� ���������
		table.setComputerRacket_Y(computerRacket_Y);
		
		//���4: ������������ �����, ���� ����� �������� ������ ������ ��� ��������. ��������� SLEEP_TIME - ����� � ��
		//����� Thread.sleep() ��������������, ��� �����, ������� ����� ������� ���������� InterruptedException.
		try {
			Thread.sleep(level);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 ���5: ��������� ���������� �����, ���� ��� � ������� ������� �����, �� ���� �� ����, �� ��� ���� �� ��������.
		 ����� isBallOnTheTable() ����� �������� ����, � ����� ���������� ���� true (���� ��� � ������� �������), 
		 ���� false (���� �� ������� �� ������� �������).
		 � ����������� �� ������� ��������� ���� �� ��� X ����� ������������ ���� ���� ������, ���� ����������, 
		 � ����� ����� displayScore() ����� ������������ ���� � ���� � ������ ���������, �� ������� �� 
		 ���-������ ���� �� �����. ����� ����, displayScore() ������������� ���, ����� ballServerd �� false.
		 ���� ����� ������������ ������ � ��� ������, ���� ��� ���� ������ ������������ ��������� (����������),
		 ���� ������ ����������� ��������� (������). ��� �� ��� �, �������.
		 */
			
			if (ballX>630) {
				computerScore++;
				displayScore();
				kidServe();
			} else if (ballX==BALL_MIN_X) {
				kidScore++;
				displayScore();
			}
		  
		
	   } //����� while
	} //����� run()
	
	/*
	 ��������� ������ ���� � � ������� ������� ������� ������. ����� kidServe() ��������� �������� ����, � �����
	 ������ ���������� ����, ����������� �� ����������� ������� ������. ������ ���� ������� ���������� ����
	 �� ��� Y ������, ��� �������� ������ ����� (��� ��������� � ������ ����� �����), �� �������� (��� � ��������) 
	 ���� �� ��������� ���������� �� �������, �� ���� ����� �������; � ���� �� ������ ������ ������ �������. ���
	 �������� ��������� ���� ���� �����, ���� �� ��������� � ����������� �� ���������� ��������� ������� �,
	 ��������������, ����.
	 ����� ����� ������ ������� ���� � ������� ������ �� ����� ��� ���������.
	*/
	private void kidServe() {
		
		ballServed=true; //������ ����
		ballX=KID_RACKET_X-1; //������������� ��� �� ����������� � ����������� ������� ������ ����� 1 �������
		ballY=kidRacket_Y; //������������� ��� �� Y ����������� ������� ������
		
		//�������, ������������ ���������� ���� ��� ������ verticalSlide = (ballY>TABLE_HEIGHT/2) ?1:-1;
		if (ballY>TABLE_HEIGHT/2) {
			verticalSlide=1;
		} else {
			verticalSlide=-1;
		}
		//�������� ���������� �� ���������
		table.setBallPosition(ballX, ballY);
		table.setKidRacket_Y(kidRacket_Y);
	}
	
	//��������� displayScore()
	private void displayScore() {
		
		//������� �������� ���������� �����, ���� ���������� ���, �� ������ ����������� ���� � ����
		if (computerScore==WINNING_SCORE) {
			table.setMessageText("Computer WON! "+computerScore+":"+kidScore);
		} else if (kidScore==WINNING_SCORE) {
			table.setMessageText("You WON! "+kidScore+":"+computerScore);
		} else {
			table.setMessageText("Computer: "+computerScore+" Player: "+kidScore);
		}
	}
	
}
