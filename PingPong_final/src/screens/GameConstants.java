package screens;

//��������� �������� ��� ���������, ������� ������������ � ����
public interface GameConstants {
	
	//������� �����
	public final int TABLE_WIDTH=640;
	public final int TABLE_HEIGHT = 360;
	public final int TABLE_TOP = 10;
	public final int TABLE_BOTTOM = 320;
	
	// ��� ����������� ���� � ��������
	public final int BALL_INCREMENT = 4;
	
	// ������������ � ����������� ���������� ����
	public final int BALL_MIN_X = 1 + BALL_INCREMENT;
	public final int BALL_MIN_Y = 1 + BALL_INCREMENT;
	public final int BALL_MAX_X = TABLE_WIDTH - BALL_INCREMENT;
	public final int BALL_MAX_Y = TABLE_HEIGHT - BALL_INCREMENT;
	
	// ��������� ���������� ����
	public final int BALL_START_X = 315;//TABLE_WIDTH/2;
	public final int BALL_START_Y = TABLE_HEIGHT/2;
	
	//�������, ������������ � ��� ����������� �������
	public final int KID_RACKET_X = 620;
	public final int KID_RACKET_Y_START = 100;
	public final int COMPUTER_RACKET_X = 15;
	public final int COMPUTER_RACKET_Y_START = 100;
	public final int RACKET_INCREMENT = 4;
	public final int RACKET_LENGTH = 30;
	public final int RACKET_WIDTH = 5;
	public final int WINNING_SCORE = 21;
	
	// ��������� ������� ���������� � �������� ��� ��������, ���� �����������
	public final int SLEEP_TIME = 10; //����� � �������������

}
