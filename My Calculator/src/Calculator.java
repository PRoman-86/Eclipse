import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;


public class Calculator {
	
// ���������� ���� ����������� ������������.
JPanel windowContent;
JFrame frame;
JFormattedTextField displayField; //������ ��������� �� JFormattedTextField ����. �������
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
//����� ��������� ������ p2 � ������ + - / * �������� �������
JPanel p2;
JButton buttonPlus;
JButton buttonMinus;
JButton buttonDivision;
JButton buttonMultiply;

// � ������������ ��������� ��� ����������
// � ����������� �� ����� � ������� ����������
// Borderlayout � Gridlayout
Calculator() {
windowContent= new JPanel();
p2 = new JPanel(); //������� ��������� ������ �������� �������.

// ����� ����� ��� ���� ������
BorderLayout bl = new BorderLayout();
windowContent.setLayout(bl);

// ������ � ���������� ����
// ��������� ��� � �������� ������� ���� (�������� �� JFormattedTextField ����. �������)
displayField = new JFormattedTextField();
displayField.setColumns(20); //��������� ������ ���������� ���� � 20 �������� (���� ����������)
displayField.setHorizontalAlignment(SwingConstants.RIGHT);
windowContent.add("North", displayField);


// ������ ������, ��������� �����������
// ������ JButton, ������� ��������� �����
// ������ � �������� ���������
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
//������� ������ + - / * �������� �������
buttonPlus=new JButton("+");
buttonMinus=new JButton("-");
buttonDivision=new JButton("/");
buttonMultiply=new JButton("*");

// ������ ������ � GridLayout
// ������� �������� 12 ������ - 10 ������ � �������
// � ������ � ������ � ������ �����
p1 = new JPanel();
GridLayout gl =new GridLayout(4,3);
p1.setLayout(gl);

// ����� �� ������� ������ �������� ������� � ������ �� ����� GridLayout 
// � ���� ������ ������� � ������� ����� 
p2 = new JPanel();
GridLayout gltwo = new GridLayout(4,1);
p2.setLayout(gltwo);

// ��������� ������ �� ������ p1
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

//��������� ������ + - \ * �� ������ p2 �������� �������
p2.add(buttonPlus);
p2.add(buttonMinus);
p2.add(buttonDivision);
p2.add(buttonMultiply);

// �������� ������ p1 � ����������� ������� ����
windowContent.add("Center",p1);
// �������� ������ �2 � ��������� ������� ���� �������� �������
windowContent.add("East", p2);

//������ �����(����) � ����� ��� �������� ������
frame = new JFrame("Calculator");
frame.setContentPane(windowContent);

// ������ ������ ���� �����������
// ��� ����, ����� �������� ��� ����������
frame.pack();

// ���������� ����
frame.setVisible(true);

// �������� ��������� �������� � ��������� ���� �� ����� ����������
frame.setResizable(false);

//������������ ����� ��������� �� ������ 0
CalculatorEngine calcEngine = new CalculatorEngine();
button0.addActionListener(calcEngine);

}


public static void main(String[] args) {
	
Calculator calc = new Calculator();

}
  }