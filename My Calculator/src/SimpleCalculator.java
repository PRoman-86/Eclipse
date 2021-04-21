//простой калькулятор, код со страницы 80 книги.

import javax.swing.*;
import java.awt.FlowLayout;

public class SimpleCalculator {

	public static void main(String[] args) {

	//создаем панель
		
		JPanel windowContent = new JPanel();
		
	//задаем менеджер отображения для этой панели
		
		FlowLayout fl = new FlowLayout();
		windowContent.setLayout(fl);
		
	//создаем компоненты в памяти
		
		JLabel label1 = new JLabel("Значение 1:");
		JTextField field1 = new JTextField(10);
		JLabel label2 = new JLabel("Значение 2:");
		JTextField field2 = new JTextField(10);
		JLabel label3 = new JLabel("Результат =");
		JTextField result = new JTextField(10);
		JButton go = new JButton("Считать");
		
		JLabel label4 = new JLabel("Все права защищены");
		
	//добавляем компоненты на панель
		
		windowContent.add(label1);
		windowContent.add(field1);
		windowContent.add(label2);
		windowContent.add(field2);
		windowContent.add(label3);
		windowContent.add(result);
		windowContent.add(go);
		
		windowContent.add(label4);
		
	//создаем фрейм и задаем для него панель
		
		JFrame frame = new JFrame("MyCalc 0.9");
		frame.setContentPane(windowContent);
		
	//задаем размер и делаем фрейм видимым
		
		frame.setSize(250,150);
		frame.setVisible(true);
	}
}
