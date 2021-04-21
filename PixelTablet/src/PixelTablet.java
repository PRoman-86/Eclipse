import java.awt.*; import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PixelTablet implements ActionListener {

	public static void main(String[] args) {
		new PixelTablet(); }
	
	JFrame frame=new JFrame("PixelPaint v.1.2");
	JButton clearButton=new JButton("RESET");
	JButton blackButton=new JButton(); JButton whiteButton=new JButton();
	JButton redButton=new JButton(); JButton greenButton=new JButton();
	JButton yellowButton=new JButton(); JButton blueButton=new JButton();
	JButton orangeButton=new JButton(); JButton grayButton=new JButton();
	JButton delCelButton=new JButton("ENDING");
	JButton cells[]=new JButton[2750];
	JPanel mainPanel=new JPanel(new BorderLayout()); 
	JPanel topPanel=new JPanel (new GridLayout(1,9));
	JPanel cellPanel=new JPanel(new GridLayout(50,55));
	JLabel label=new JLabel("COUNT: 0");
	Font topFont=new Font("Verdana",Font.BOLD,11);
	int pixels=0; //переменная хранящая количество касаний для счетчика
	Color paint; //переменная класса Color, хранящая выбранный цвет в селекторе
	Color getPaint; //переменная, хранящая цвет закрашенной клетки

	PixelTablet() {
		//оформляем кнопки селектора цвета и сброса
		redButton.setBackground(Color.red); blackButton.setBackground(Color.BLACK);
		yellowButton.setBackground(Color.YELLOW); orangeButton.setBackground(Color.ORANGE);
		blueButton.setBackground(Color.BLUE); greenButton.setBackground(Color.GREEN);
		whiteButton.setBackground(Color.WHITE); grayButton.setBackground(Color.GRAY);
		label.setFont(topFont); //оформляем окно счетчика касаний
		label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		//добавляем кнопки селектора цвета и сброса на панель
		topPanel.add(whiteButton); topPanel.add(blackButton); topPanel.add(redButton);
		topPanel.add(greenButton); topPanel.add(yellowButton); topPanel.add(blueButton);
		topPanel.add(orangeButton); topPanel.add(grayButton); topPanel.add(clearButton);
		topPanel.add(delCelButton); topPanel.add(label);
		//регистрируем слушателя на кнопки селектора и сброса
		whiteButton.addActionListener(this); blackButton.addActionListener(this);
		redButton.addActionListener(this); greenButton.addActionListener(this);
		yellowButton.addActionListener(this); blueButton.addActionListener(this);
		orangeButton.addActionListener(this); grayButton.addActionListener(this);
		clearButton.addActionListener(this); delCelButton.addActionListener(this);
		/*регистрируем слушателя на клетки рабочего поля, добавляем их на панель,
		устанавливаем белый как начальный цвет и создаем экземпляры клеток в памяти;
		опционально включаем\выключаем границы клеток */
		for (int c=0;c<2750;c++) {
			cells[c]=new JButton();
			cells[c].setBackground(Color.WHITE);
			//cells[c].setBorder(null); //при включении исчезнут границы клеток
			cellPanel.add(cells[c]);
			cells[c].addActionListener(this);
		}
		//размещаем панели в фрейме, настраиваем фрейм
		mainPanel.add(topPanel, "North"); mainPanel.add(cellPanel, "Center");
		frame.pack();
		frame.setSize(1024,768); frame.setResizable(false);
		frame.add(mainPanel);
		frame.setVisible(true);
		
	}
	//объявляем и пишем поведение метода-счетчика
	void touchCounter () {
		pixels++;
		label.setText("COUNT: "+pixels);
		return;
	} //конец метода-счетчика

	public void actionPerformed(ActionEvent e) {
		JButton pushButton = (JButton) e.getSource();
		//реализуем работу селектора цвета
		if (pushButton==redButton) {
			paint=Color.RED;
		} else if (pushButton==blackButton) {
			paint=Color.BLACK;
		} else if (pushButton==whiteButton) {
			paint=Color.WHITE;
		} else if (pushButton==greenButton) {
			paint=Color.GREEN;
		} else if (pushButton==yellowButton) {
			paint=Color.YELLOW;
		} else if (pushButton==blueButton) {
			paint=Color.BLUE;
		} else if (pushButton==orangeButton) {
			paint=Color.ORANGE;
		} else if (pushButton==grayButton) {
			paint=Color.GRAY;
		} else if (pushButton==clearButton) { 
			paint=Color.WHITE;
			getPaint=paint;
			label.setText("COUNT: 0");
			pixels=0;
			for (int c=0;c<2750;c++) {
				/*
				 Здесь мы возвращаем все в исходное состояние: закрашиваем
				 клетки белым, снова рисуем границы и делаем клетки активными
				 */
				cells[c].setBackground(paint);
				cells[c].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				cells[c].setEnabled(true);
			}
			
			 //Реализуем нажатие кнопки завершения рисунка для каждой клетки
		} else if (pushButton==delCelButton) {
			for (int c=0; c<2750;c++) {
				getPaint=cells[c].getBackground(); //получаем цвет клетки
				cells[c].setEnabled(false); //блокируем клетки
				//если клетка белая, то убираем ее границы
				if (getPaint==Color.WHITE) {
					cells[c].setBorder(null);
				}
			}
		} //конец реализации кнопки завершения
		
		//реализуем работу с каждой выбранной клеткой
		for (int c=0;c<2750;c++) {
		if (pushButton==cells[c]) {
				cells[c].setBackground(paint);
				touchCounter(); //вызываем метод-счетчик
   } //конец условия
  } //конец цикла
 } //конец метода ActionPerformed()
} //конец класса