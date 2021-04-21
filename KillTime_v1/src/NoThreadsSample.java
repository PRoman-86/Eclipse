import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class NoThreadsSample extends JFrame implements ActionListener, Runnable {
 // �����������
 NoThreadsSample(){
 // ������� ���� � ������� � ��������� �����
GridLayout gl =new GridLayout(2,1);
 this.setLayout(gl);
JButton myButton = new JButton("Kill Time");
 myButton.addActionListener(this);
this.add(myButton);
 this.add(new JTextField());
}
// ���������� ������� ������
public void actionPerformed(ActionEvent e){
	
	Thread worker=new Thread(this);
	worker.start();
 }

public static void main(String[] args) {
//������� ����
NoThreadsSample myWindow = new NoThreadsSample();
//���������, ��� ���� ����������� ��� ������� �� ������� � ����
myWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
// ���������� ������� ���� � ���������� ������ ��������
//���� � ������ � �������
myWindow.setBounds(0,0,250, 200);
//������� ���� �������
myWindow.setVisible(true);
}
@Override
public void run() {
	for (int i=0; i<100000;i++){
		this.setTitle("i="+i);
	
}
 }
  }