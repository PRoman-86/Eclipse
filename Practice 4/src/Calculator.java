import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;


public class Calculator {
	
// Объявление всех компонентов калькулятора.
JPanel windowContent;
JFrame frame;
JFormattedTextField displayField; //меняем компонент на JFormattedTextField согл. заданию
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

//--------------------------------------------------------
// здесь мы выполняем задание "для умников" - объявляем массив numButtons и с помощью цикла
//внутри него создаем экземпляры объекта кнопок от 0 до 9.
JButton [] numButtons = new JButton[10];
for (int n=0; n<10; n++) {
	numButtons[n] = new JButton(""+n);
}
//--------------------------------------------------------

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
p1.add(numButtons[1]);
p1.add(numButtons[2]);
p1.add(numButtons[3]);
p1.add(numButtons[4]);
p1.add(numButtons[5]);
p1.add(numButtons[6]);
p1.add(numButtons[7]);
p1.add(numButtons[8]);
p1.add(numButtons[9]);
p1.add(numButtons[0]);
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
}


public static void main(String[] args) {
	
Calculator calc = new Calculator();

}
  }