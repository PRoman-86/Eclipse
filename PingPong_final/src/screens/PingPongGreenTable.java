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

//класс рисует стол для пинг-понга, шар, ракетки, отображает счет

public class PingPongGreenTable extends JPanel implements GameConstants {
	
	/*
	 Объявляем необходимые переменные и задаем им значения. Значениями являются
	 константы конструктора GameConstants. Необходимо помнить, что имена
	 констант нужно всегда указывать заглавными буквами, чтобы было видно, что
	 это не просто переменные, а именно константы. Этот класс реализует
	 конструктор GameConstants.
	 */
	
	private JLabel label;
	private int computerRacket_Y=COMPUTER_RACKET_Y_START;
	private int kidRacket_Y=KID_RACKET_Y_START;
	private int ballX=BALL_START_X;
	private int ballY=BALL_START_Y;
	
	/*
	 Для того, чтобы установить размеры стола, создается экземпляр класса
	 Dimension из Swing. JVM необходимо знать о размерах окна, поэтому она
	 вызывает метод getPreferredSize(). Этот метод (геттер) возвращает
	 объект Dimension, который создан в соответствии с размерами стола
	 */
	
	/*
	 Создаем экземпляр в переменной preferredSize, передавая в конструктор
	 класса Dimension две константы определяющие длину и ширину стола
	 */
	Dimension preferredSize=new Dimension(TABLE_WIDTH,TABLE_HEIGHT);
	/*
	 Объявляем метод-геттер, возвращающий значение переменной preferredSize
	 класса Dimension
	 */
	public Dimension getPreferredSize() {
		return preferredSize;
	}
		
	/*
	 Конструктор. Создаем экземпляр объекта PingPongGameEngine, при этом
	 передаем в него ссылку на этот объект с помощью this для создания переменной
	 table, содержащей ссылку на этот объект.
	 Регистрируем слушателей для мыши и клавиатуры.
	 */
		PingPongGreenTable() {
			
			PingPongGameEngine gameEngine=new PingPongGameEngine(this);
			addMouseMotionListener(gameEngine);
			addKeyListener(gameEngine);
		} //конец конструктора
		
	/*
	 Добавим в окно панель c JLabel. Метод принимает в виде аргумента переменную
	 container типа Container (содержит экземпляр объекта JPanel), а затем устанавливает
	 на эту же панель схему размещения (BoxLayout) и добавляет панель в окно.
	 Затем создается надпись и также добавляется на панель.
	 */
		
		void addPaneltoFrame (Container container) {
			
			container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
			container.add(this); //добавялем на окно панель, this - класс наследуется от JPanel
			label=new JLabel("'N'- новая игра, 'Q'- выход, '8' , '5' или мышь - управление ракеткой, "
					+ "'A' , 'Z'- скорость мяча");
			container.add(label); //добавляем надпись на панель
			
		}
		
	/*
	 Перерисовать окно. Этот метод вызывает JVM, когда нужно обновить стол или вызывается
	 метод repaint() из PingPongGameEngine
	 */
		
		public void paintComponent(Graphics g) {
	/*
	 Обращение к методу paintComponent() с помощью ключевого слова super. Наш класс
	 наследуется от класса JPanel, а тот, в свою очередь, наследуется от класса
	 JComponent, в котором и имеется данный метод. Немного теории:
	 
	 super, помимо всего прочего, дает возможность обратиться к любому члену 
	 родительского класса - методу или переменной, если они не определены модификатором
	 private.
	 
	 Метод paintComponent() также может быть явно вызван методом repaint(), 
	 определенным в классе Component. Эффект вызова repaint() заключается в том, 
	 что Swing автоматически очищает графику на панели и выполняет метод paintComponent() 
	 для перерисовки графики на этой панели.
	 
	 На выходе мы имеем, что при вызове метода paintComponent() класса PingPongGreenTable
	 с аргументом g типа Graphics, он вызывает paintComponent() класса JComponent, с этим
	 же аргументом для начала перерисовки стола, а затем, через g устанавливает параметры
	 перерисовки, такие как цвет стола, его размер, ракетки, мяч их координаты и т.д.
	 */
			super.paintComponent(g);
			
			//нарисовать зеленый стол
			g.setColor(Color.green);
			g.fillRect(0,0,TABLE_WIDTH, TABLE_HEIGHT);
			
			//нарисовать правую ракетку
			g.setColor(Color.yellow);
			g.fillRect(KID_RACKET_X, kidRacket_Y, RACKET_WIDTH, RACKET_LENGTH);
			
			//нарисовать левую ракетку
			g.setColor(Color.blue);
			g.fillRect(COMPUTER_RACKET_X, computerRacket_Y, RACKET_WIDTH, RACKET_LENGTH);
			
			//нарисовать мяч
			g.setColor(Color.red);
			g.fillOval(ballX, ballY, 10, 10);
			
			//нарисовать белые линии
			g.setColor(Color.white);
			g.drawRect(10,10,620,340);
			g.drawLine(320,10,320,350);
			
			//установить фокус на стол, чтобы обработчик клавиатуры мог посылать команды столу
			requestFocus();
		}
		
		/*
		 Устанавливаем текущее положение ракетки игрока, с помощью метода-сеттера setKidRacket_Y()
		 Он принимает в виде аргумента переменную yCoordinate типа int и меняет начальное значение нашей 
		 переменной kidRacket_Y, объявленной в начале класса.
		 */

		public void setKidRacket_Y(int yCoordinate) {
			this.kidRacket_Y=yCoordinate;
			repaint(); //перерисовываем стол, вызывая метод paintComponent() с помощью метода repaint()
		}
		
		//геттер, возвращающий текущее положение ракетки игрока
		public int getKidRacket_Y() {
			return kidRacket_Y;
		}
		
		//устанавливаем текущее положение ракетки компьютера
		public void setComputerRacket_Y(int yCoordinate) {
			this.computerRacket_Y=yCoordinate;
			repaint();
		}
		
		//установить игровое сообщение-метод принимает строку в виде параметра и устанавливает ее
		public void setMessageText(String text) {
			label.setText(text);
		}
		
		//установить позицию мяча
		public void setBallPosition(int xPos, int yPos) {
			ballX=xPos;
			ballY=yPos;
			repaint();
		}
		
		public static void main(String[] args) {
			
			//создаем экземпляр окна
			JFrame f=new JFrame ("Ping Pong Green Table");
			
			//даем возможность закрыть приложение при закрытии окна [Х]
			f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			/*
			 Создаем экземпляр объекта этого класса и добавляем панель с элементами на окно
			 путем вызова нашего метода выше addPanelToFrame() с аргументом f.getContentPane()
			 */
			
			PingPongGreenTable table=new PingPongGreenTable();
			table.addPaneltoFrame(f.getContentPane());
			
			//устанавливаем размер окна и делаем окно видимым
			f.setBounds(0, 0, 656, 420);
			f.setResizable(false);
			f.setVisible(true);
		}
}
