package engine;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import screens.*;

/*
 Этот класс - обработчик событий мыши и клавиатуры, а также он рассчитывает движение
 мяча и ракеток, изменение их координат в процессе игры. Класс реализует след. интерфейсы:
 Runnable для создания паралелльного потока, MouseMotionListener для обработки движений мыши,
 KeyListener для обработки нажатий клавиш клавиатуры и GameConstants, хранящий final-переменные (константы).
 */

public class PingPongGameEngine implements Runnable, MouseMotionListener, KeyListener, GameConstants {
	
	private PingPongGreenTable table; //переменная table будет содержать ссылку на PingPongGreenTable
	private int kidRacket_Y=KID_RACKET_Y_START; //начальное значение ракетки игрока
	private int computerRacket_Y=COMPUTER_RACKET_Y_START; //начальное значение ракетки компьютера
	private int kidScore; //будет содержать счет игрока
	private int computerScore; //будет содержать счет компьютера
	private int ballX; //будет содержать текущие координаты Х мяча
	private int ballY; //будет содержать текущие координаты Y мяча
	private boolean movingLeft=true; //содержит факт движения мяча влево
	private boolean ballServed; //содержит факт движения мяча (вообще)
	private int verticalSlide; //будет содержать значение вертикального передвижения (шаг) мяча в пикселях
	private int level=SLEEP_TIME; //вводим переменную для изменения времени приостановки потока (скорость)
	
	/*
	 Конструктор. Присваивает переменной table ссылку на объект стола (PingPongGreenTable) через свой
	 аргумент. Объявленная в аргументе конструктора локальная переменная greenTable класса
	 PingPongGreenTable получает ссылку на класс стола через this при объявлении экземпляра этого класса
	 в классе стола.
	 Далее конструктор создает параллельный поток, присваивая ссылку на него переменной worker класса
	 Thread. This в аргументе означает, что поток будет реализован (через метод run()) в этом же классе.
	 Метод start() запускает поток - код, который содержит метод run().
	 */
	
	public PingPongGameEngine(PingPongGreenTable greenTable) {
		table=greenTable; //передаем ссылку на класс стола переменной table из greenTable аргумента
		
		Thread worker=new Thread(this); //создаем параллельный поток
		worker.start(); //запускаем параллельный поток
	}
	
	//Далее реализуются методы интерфейса MouseMotionListener. Ненужные нам методы будут пусты.
	
	public void mouseDragged(MouseEvent e) { } //пустой метод
	
	public void mouseMoved(MouseEvent e) { //движение мыши
		
		int mouse_Y=e.getY(); //текущая координата курсора мыши по оси Y в переменной mouse_Y
		
		/*
		 Если курсор мыши находится выше ракетки игрока и при этом не выходит за пределы стола,
		 то передвинуть ракетку вверх, в противном случае - опустить ракетку вниз
		 */
		
		if (mouse_Y<kidRacket_Y && kidRacket_Y>TABLE_TOP) {
			kidRacket_Y-=RACKET_INCREMENT; //передвигаем ракетку вверх
		} else if (kidRacket_Y<TABLE_BOTTOM) {
			kidRacket_Y+=RACKET_INCREMENT; //передвигаем ракетку вниз
		}
		
		//устанавливаем положение ракетки на столе для отрисовки через table в класс стола
		//путем вызова метода-сеттера setKidRacket() класса PingPongGreenTable и передачи
		//текущей координаты раккетки игрока через аргумент для отрисовки
		table.setKidRacket_Y(kidRacket_Y);
		
	}
	
	//Далее реализуются методы интерфейса KeyListener. Ненужные нам методы будут пусты.
	
	public void keyPressed(KeyEvent e) {
		
		char key=e.getKeyChar(); //текущая нажатая кнопка клавиатуры в переменной key
		
		//реализуем условия при нажатии кнопок N, Q, S. Как заглавных, так и строчных
		
		if (key=='n' || key=='N') {
			startNewGame(); //запуск новой игры
		} else if (key=='q' || key=='Q') {
			endGame();
			/*
			 Реализуем смену уровней кнопками A и Z за счет смены времени приостановки потока.
			 Самый медленный уровень - 10 мс, самый быстрый 1 мс. 
			 В этом же блоке реализуется управление ракеткой клавишами 8 и 5
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
	
	public void keyReleased(KeyEvent e) { } //пустой метод
	public void keyTyped(KeyEvent e) { } //пустой метод
	
	//реализуем начало новой игры при нажатии кнопки N в методе startNewGame()
	
	public void startNewGame() {
		//обнуляем счет
		computerScore=0; kidScore=0;
		//передаем надпись через сеттер setMessageText() на стол, переменная label
		table.setMessageText("Score Computer: 0  Player: 0");
		kidServe();
		
	}
	
	//реализуем завершение игры (закрытие программы) при нажатии Q в методе endGame()
	public void endGame() { System.exit(0); }
	
	/*
	 Далее реализуется метод run() интерфейса Runnable. Метод содержит код, который
	 будет выполняться как параллельный поток. Выполнение метода начинается после
	 вызова метода worker.start() и приостанавливается после вызова метода Thread.sleep() на
	 заданное в его аргументе время.
	 */
	
	public void run() {
		
		//переменная, определяющая факт отскока мяча от ракетки
		boolean canBounce=false; //логично, что начальное значение будет false
		
		//постоянный цикл, обеспечивающий движение мяча по столу
		while (true) {
			
			if (ballServed) { //если мяч движется
			
				//Шаг1: если мяч движется влево, т.е. в сторону ракетки компьютера
				if (movingLeft && ballX > BALL_MIN_X) {
					
					//определяем шаг мяча по оси Y в зав-сти от положения мяча
					verticalSlide = (ballY>TABLE_HEIGHT/2) ?1:-1;
					
					/*
					 переменная canBounce будет принимать значение либо true, либо false в
					 зависимости от выражения ниже. Это выражение определяет, отскочит ли мяч
					 от ракетки компьютера путем учета текущих координат мяча, текущей координаты левого
					 верхнего угла (начала) ракетки компьютера и ее длины по оси Y.
					 Выражение ballY>=computerRacket_Y && ballY<(computerRacket_Y+RACKET_LENGTH) означает, что
					 если текущая координата по оси Y мяча больше либо равна текущей координате по оси Y
					 левого верхнего угла ракетки компьютера И ПРИ ЭТОМ(&&-вторая половина выражения не проверяется, 
					 если первая ложна) текущая координата мяча по оси Y меньше длины ракетки с учетом текущей
					 координаты ее угла (то есть мяч летит в ракетку), ТО переменная canBounce получит значение
					 true, в противном случае - false. 				 
					 */
					canBounce = (ballY>=computerRacket_Y && ballY<(computerRacket_Y+RACKET_LENGTH) ? true: false);
					
					ballX-=BALL_INCREMENT; //двигаем мяч влево далее
					
					/*
					 Далее добавим смещение мяча по оси Y при движении мяча по оси X, чтобы он не летал
					 горизонтально, как дурак, а по диагонали, и устанавливаем его текущие координаты через
					 сеттер setBallPosition(), в аргументе которого будут переменные ballY и ballY.
					 Метод находится в классе стола, поэтому делаем это через table.
					 */
					
					ballY-=verticalSlide;
					table.setBallPosition(ballX, ballY);
					
					/*
					 Реализуем отскок мяча от ракетки компьютера. Если текущие координаты мяча по оси Х меньше,
					 либо равны координатам левого верхнего угла ракетки по оси Х, то есть мяч улетел за
					 ракетку И ПРИ ЭТОМ(&&-вторая половина выражения не проверяется, если первая ложна)
					 значение переменной canBounce=true (т.е. имеем факт отскока мяча), то движение мяча
					 влево прекращается - переменная movingLeft примет значение false.
					 */
					
					if (ballX<=COMPUTER_RACKET_X && canBounce) movingLeft=false;
					
					
				}
			}
			
			//Шаг2: если мяч движется вправо, т.е. в сторону ракетки игрока
			if (!movingLeft && ballX <= BALL_MAX_X) {
				
				//аналогичное условие для факта отскока, но при движении мяча вправо и для ракетки игрока
				canBounce = (ballY >= kidRacket_Y-2 && ballY <(kidRacket_Y+RACKET_LENGTH+2) ?true:false);
				
				//аналогично смещаем мяч вправо и устанавливаем координаты мяча для отрисовки
				ballX+=BALL_INCREMENT;
				ballY-=verticalSlide;
				table.setBallPosition(ballX, ballY);
				
				//реализуем отскок, на этот раз movingLeft становится true, т.е. мяч начинает движение влево
				if (ballX>=KID_RACKET_X-5 && canBounce) movingLeft=true;
				
			}

		
		/*
		 Шаг3: реализуем перемещение ракетки компьютера для парирования мяча.
		 Если координаты ракетки по оси Y меньше текущих координат мяча по оси Y и ПРИ ЭТОМ(&&-вторая половина 
		 выражения не проверяется, если первая ложна) координаты ракетки меньше, чем координата нижней границы стола,
		 то ракетка сдвигается вниз, иначе если координаты ракетки больше, чем координата верхней границы
		 стола, то ракетка поедет вверх.
		 Суть условия такова, что ракетка будет следовать за мячом вниз, а потом возвращаться в верхнее положение, пока
		 ее координаты не приравняются к координатам вернхней границы стола. Ракетка будет опускаться лишь для отбивания
		 мяча.
		 */
		
		if (computerRacket_Y < ballY && computerRacket_Y < TABLE_BOTTOM) {
			computerRacket_Y+=RACKET_INCREMENT;
		} else if (computerRacket_Y > TABLE_TOP) {
			computerRacket_Y-=RACKET_INCREMENT;
		}
		
		//устанавливаем координаты ракетки для отрисовки
		table.setComputerRacket_Y(computerRacket_Y);
		
		//Шаг4: приостановим поток, игра будет работать сликшм быстро для человека. Константа SLEEP_TIME - время в мс
		//метод Thread.sleep() обрабатывается, как метод, который может вызвать исключение InterruptedException.
		try {
			Thread.sleep(level);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 Шаг5: реализуем обновление счета, если мяч в зеленой области стола, то есть на поле, но при этом не движется.
		 Метод isBallOnTheTable() будет объявлен ниже, и будет возвращать либо true (если мяч в зеленой области), 
		 либо false (если он вылетел за зеленую область).
		 В зависимости от текущих координат мяча по оси X будет накидываться очко либо игроку, либо компьютеру, 
		 а затем метод displayScore() будет отрисовывать счет в игре и заодно проверять, не выиграл ли 
		 кто-нибудь матч по очкам. Кроме того, displayScore() останавливает мяч, меняя ballServerd на false.
		 Очко будет накидываться только в том случае, если мяч либо больше максимальных координат (компьютеру),
		 либо меньше минимальных координат (игроку). Все по оси Х, ессесно.
		 */
			
			if (ballX>630) {
				computerScore++;
				displayScore();
				kidServe();
			} else if (ballX==BALL_MIN_X) {
				kidScore++;
				displayScore();
			}
		  
		
	   } //конец while
	} //конец run()
	
	/*
	 Реализуем подачу мяча и с текущей позиции ракетки игрока. Метод kidServe() запускает движение мяча, а затем
	 задает координаты мяча, основываясь на координатах ракетки игрока. Причем если текущая координата мяча
	 по оси Y больше, чем половина высоты стола (мяч находится в нижней части стола), то смещение (шаг в пикселях) 
	 мяча по вертикали уменьшится на единицу, то есть будет нулевым; в ином же случае станет равным единице. Это
	 позволит двигаться мячу либо прямо, либо по диагонали в зависимости от начального положения ракетки и,
	 соответственно, мяча.
	 Затем метод задает позиции мяча и ракетки игрока на столе для отрисовки.
	*/
	private void kidServe() {
		
		ballServed=true; //запуск мяча
		ballX=KID_RACKET_X-1; //устанавливаем мяч по константным Х координатам ракетки игрока минус 1 пиксель
		ballY=kidRacket_Y; //устанавливаем мяч по Y координатам ракетки игрока
		
		//условие, определяющее траекторию мяча при подаче verticalSlide = (ballY>TABLE_HEIGHT/2) ?1:-1;
		if (ballY>TABLE_HEIGHT/2) {
			verticalSlide=1;
		} else {
			verticalSlide=-1;
		}
		//передаем координаты на отрисовку
		table.setBallPosition(ballX, ballY);
		table.setKidRacket_Y(kidRacket_Y);
	}
	
	//реализуем displayScore()
	private void displayScore() {
		
		//условие проверки победителя матча, если победителя нет, то просто обновляется счет в игре
		if (computerScore==WINNING_SCORE) {
			table.setMessageText("Computer WON! "+computerScore+":"+kidScore);
		} else if (kidScore==WINNING_SCORE) {
			table.setMessageText("You WON! "+kidScore+":"+computerScore);
		} else {
			table.setMessageText("Computer: "+computerScore+" Player: "+kidScore);
		}
	}
	
}
