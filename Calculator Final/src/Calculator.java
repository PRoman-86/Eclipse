//импортируем необходиыме компоненты
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

//объявляем класс
public class Calculator {
	
	//объявляем и инициализируем компоненты окна
	//кнопки
	JButton button0=new JButton("0");
	JButton button1=new JButton("1");
	JButton button2=new JButton("2");
	JButton button3=new JButton("3");
	JButton button4=new JButton("4");
	JButton button5=new JButton("5");
	JButton button6=new JButton("6");
	JButton button7=new JButton("7");
	JButton button8=new JButton("8");
	JButton button9=new JButton("9");
	JButton buttonPoint=new JButton(".");
	JButton buttonEqual=new JButton("=");
	JButton buttonPlus=new JButton("+");
	JButton buttonMinus=new JButton("-");
	JButton buttonDivide=new JButton("/");
	JButton buttonMultiply=new JButton("*");
	
	//объявляем панель
	JPanel windowContent=new JPanel();
	
	//объявляем и инициализируем текстовое поле (дисплей) длиной в 30 символов
	JTextField displayField=new JTextField(30);
	
	//объявляем метод-конструктор
	Calculator() {
		
		//объявляем менеджер расположения
		BorderLayout bl = new BorderLayout();
		//устанавливаем его для нашей панели
		windowContent.setLayout(bl);
		//добавляем текстовое поле (дисплей) на северную область панели
		windowContent.add("North",displayField);
		
		//объявляем вторую панель
		//объявляем менеджер расположения GridLayout c параметрами в 4 строки и 3 столбца
		//устанавливаем менеджер расположения для второй панели
		JPanel p1 = new JPanel();
		GridLayout gl = new GridLayout(4,3);
		p1.setLayout(gl);
		
		/*
		 Вторая панель отдельно создавалась для цифровых кнопок и кнопок "точка" и "равно",
		 итого для 12 кнопок. Кулькулятор должен выглядеть красиво, а один менеджер расположения
		 не сможет реализовать задуманное. Потом мы добавим еще одну панель для оставшихся кнопок.
		 
		 Далее добавляем наши кнопки на панель р1
		 */
		
		p1.add(button0);
		p1.add(button1);
		p1.add(button2);
		p1.add(button3);
		p1.add(button4);
		p1.add(button5);
		p1.add(button6);
		p1.add(button7);
		p1.add(button8);
		p1.add(button9);
		p1.add(buttonPoint);
		p1.add(buttonEqual);
		
		//добавляем вторую панель р1 в центр основной панели windowContent
		windowContent.add("Center",p1);
		
		//объявляем третью панель
		//объявляем менеджер расположения GridLayout c параметрами в 4 строки и 1 столбец
		//устанавливаем менеджер расположения для третьей панели
		JPanel p2 = new JPanel();
		GridLayout gl2 = new GridLayout(4,1);
		p2.setLayout(gl2);
		
		//добавляем на третью панель оставшиеся кнопки + - * /
		p2.add(buttonPlus);
		p2.add(buttonMinus);
		p2.add(buttonMultiply);
		p2.add(buttonDivide);
		
		//добавляем третью панель p2 в правую часть основной панели windowContent
		windowContent.add("East",p2);
		
		//создаем фрейм (окно)
		//прикручиваем к нему нашу основную панель windowContent
		JFrame frame = new JFrame("Калькулятор");
		frame.setContentPane(windowContent);
		
		//устанавливаем размер окна так, чтобы уместились все компоненты
		//запрещаем изменять размеры окна, я так захотел
		//делаем окно видимым
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
		//теперь создаем экземпляр класса-слушателя событий. Не забываем в параметрах поставить this
		//чтобы была возможность обмена инфы с соседним классом CalculatorEngine, 
		//которая уже реализована
		CalculatorEngine calcEngine = new CalculatorEngine(this);
		
		//регистрируем слушателя в каждой кнопке
		button0.addActionListener(calcEngine);
		button1.addActionListener(calcEngine);
		button2.addActionListener(calcEngine);
		button3.addActionListener(calcEngine);
		button4.addActionListener(calcEngine);
		button5.addActionListener(calcEngine);
		button6.addActionListener(calcEngine);
		button7.addActionListener(calcEngine);
		button8.addActionListener(calcEngine);
		button9.addActionListener(calcEngine);
		
		buttonPoint.addActionListener(calcEngine);
		buttonEqual.addActionListener(calcEngine);
		buttonPlus.addActionListener(calcEngine);
		buttonMinus.addActionListener(calcEngine);
		buttonDivide.addActionListener(calcEngine);
		buttonMultiply.addActionListener(calcEngine);
	}
	
	//объявляем метод входа в программу и создаем в нем экзампляр класса Calculator
	public static void main (String[] args) {
		Calculator myCalc = new Calculator();
	}
}