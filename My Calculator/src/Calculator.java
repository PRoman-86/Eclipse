import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;


public class Calculator {
	
// Объявление всех компонентов калькулятора.
JPanel windowContent;
JFrame frame;
JFormattedTextField displayField; //меняем компонент на JFormattedTextField согл. заданию
JButton button0;
JButton button1;
JButton button2;
JButton button3;
JButton button4;
JButton button5;
JButton button6;
JButton button7;
JButton button8;
JButton button9;
JButton buttonPoint;
JButton buttonEqual;
JPanel p1;
//далее объявляем панель p2 и кнопки + - / * согласно заданию
JPanel p2;
JButton buttonPlus;
JButton buttonMinus;
JButton buttonDivision;
JButton buttonMultiply;

// В конструкторе создаются все компоненты
// и добавляются на фрейм с помощью комбинации
// Borderlayout и Gridlayout
Calculator() {
windowContent= new JPanel();
p2 = new JPanel(); //создаем экземпляр панели согласно заданию.

// Задаём схему для этой панели
BorderLayout bl = new BorderLayout();
windowContent.setLayout(bl);

// Создаём и отображаем поле
// Добавляем его в Северную область окна (изменено на JFormattedTextField согл. заданию)
displayField = new JFormattedTextField();
displayField.setColumns(20); //установим ширину текстового поля в 20 символов (своя инициатива)
displayField.setHorizontalAlignment(SwingConstants.RIGHT);
windowContent.add("North", displayField);


// Создаём кнопки, используя конструктор
// класса JButton, который принимает текст
// кнопки в качестве параметра
button0=new JButton("0");
button1=new JButton("1");
button2=new JButton("2");
button3=new JButton("3");
button4=new JButton("4");
button5=new JButton("5");
button6=new JButton("6");
button7=new JButton("7");
button8=new JButton("8");
button9=new JButton("9");
buttonPoint = new JButton(".");
buttonEqual=new JButton("=");
//создаем кнопки + - / * согласно заданию
buttonPlus=new JButton("+");
buttonMinus=new JButton("-");
buttonDivision=new JButton("/");
buttonMultiply=new JButton("*");

// Создаём панель с GridLayout
// которая содержит 12 кнопок - 10 кнопок с числами
// и кнопки с точкой и знаком равно
p1 = new JPanel();
GridLayout gl =new GridLayout(4,3);
p1.setLayout(gl);

// здесь мы создаем панель согласно заданию и задаем ей схему GridLayout 
// в виде одного столбца и четырех строк 
p2 = new JPanel();
GridLayout gltwo = new GridLayout(4,1);
p2.setLayout(gltwo);

// Добавляем кнопки на панель p1
p1.add(button1);
p1.add(button2);
p1.add(button3);
p1.add(button4);
p1.add(button5);
p1.add(button6);
p1.add(button7);
p1.add(button8);
p1.add(button9);
p1.add(button0);
p1.add(buttonPoint);
p1.add(buttonEqual);

//добавляем кнопки + - \ * на панель p2 согласно заданию
p2.add(buttonPlus);
p2.add(buttonMinus);
p2.add(buttonDivision);
p2.add(buttonMultiply);

// Помещаем панель p1 в центральную область окна
windowContent.add("Center",p1);
// Помещаем панель р2 в восточную область окна согласно заданию
windowContent.add("East", p2);

//Создаём фрейм(окно) и задаём его основную панель
frame = new JFrame("Calculator");
frame.setContentPane(windowContent);

// делаем размер окна достаточным
// для того, чтобы вместить все компоненты
frame.pack();

// отображаем окно
frame.setVisible(true);

// запретим изменение размеров и пропорций окна по своей инициативе
frame.setResizable(false);

//регистрируем вывод сообщения на кнопку 0
CalculatorEngine calcEngine = new CalculatorEngine();
button0.addActionListener(calcEngine);

}


public static void main(String[] args) {
	
Calculator calc = new Calculator();

}
  }