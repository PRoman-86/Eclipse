//������� �����������, ��� �� �������� 80 �����.

import javax.swing.*;
import java.awt.FlowLayout;

public class SimpleCalculator {

	public static void main(String[] args) {

	//������� ������
		
		JPanel windowContent = new JPanel();
		
	//������ �������� ����������� ��� ���� ������
		
		FlowLayout fl = new FlowLayout();
		windowContent.setLayout(fl);
		
	//������� ���������� � ������
		
		JLabel label1 = new JLabel("�������� 1:");
		JTextField field1 = new JTextField(10);
		JLabel label2 = new JLabel("�������� 2:");
		JTextField field2 = new JTextField(10);
		JLabel label3 = new JLabel("��������� =");
		JTextField result = new JTextField(10);
		JButton go = new JButton("�������");
		
		JLabel label4 = new JLabel("��� ����� ��������");
		
	//��������� ���������� �� ������
		
		windowContent.add(label1);
		windowContent.add(field1);
		windowContent.add(label2);
		windowContent.add(field2);
		windowContent.add(label3);
		windowContent.add(result);
		windowContent.add(go);
		
		windowContent.add(label4);
		
	//������� ����� � ������ ��� ���� ������
		
		JFrame frame = new JFrame("MyCalc 0.9");
		frame.setContentPane(windowContent);
		
	//������ ������ � ������ ����� �������
		
		frame.setSize(250,150);
		frame.setVisible(true);
	}
}
