//массивы и циклы на примере программы дл€ вывода результатов некоей игры
public class Game {
	public static void main(String[] args) {
		
		//задаем массив из 4 элементов и присваиваем им значени€
		String player[]=new String [4];
		player[0]="Luba";
		player[1]="Roma";
		player[2]="Volik";
		player[3]="Oksana";
		
		//определ€ем количество игроков с помощью команды length
		//по количеству элементов в массиве
		int totalPlayers=player.length;
		
		//выбираем победител€ theWinner и присваиваем ему один из элементов массива
		String theWinner=player[0];
		
		//выводим на экран количество игроков и победител€
		System.out.println(theWinner+" is a Winner! Amount of players: "+totalPlayers);
		
		//с помощью цикла поблагодарим игроков за игру
		int counter;
		for (counter=0; counter < totalPlayers; counter++)
		{ String thePlayer=player[counter];
		  System.out.println("Thanks for game, "+thePlayer); }
		
	}
}
