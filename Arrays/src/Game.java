//������� � ����� �� ������� ��������� ��� ������ ����������� ������ ����
public class Game {
	public static void main(String[] args) {
		
		//������ ������ �� 4 ��������� � ����������� �� ��������
		String player[]=new String [4];
		player[0]="Luba";
		player[1]="Roma";
		player[2]="Volik";
		player[3]="Oksana";
		
		//���������� ���������� ������� � ������� ������� length
		//�� ���������� ��������� � �������
		int totalPlayers=player.length;
		
		//�������� ���������� theWinner � ����������� ��� ���� �� ��������� �������
		String theWinner=player[0];
		
		//������� �� ����� ���������� ������� � ����������
		System.out.println(theWinner+" is a Winner! Amount of players: "+totalPlayers);
		
		//� ������� ����� ������������ ������� �� ����
		int counter;
		for (counter=0; counter < totalPlayers; counter++)
		{ String thePlayer=player[counter];
		  System.out.println("Thanks for game, "+thePlayer); }
		
	}
}
