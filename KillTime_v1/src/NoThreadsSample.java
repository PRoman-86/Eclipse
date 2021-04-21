import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class NoThreadsSample extends JFrame implements ActionListener, Runnable {
 // Конструктор
 NoThreadsSample(){
 // Создать окно с кнопкой и текстовым полем
GridLayout gl =new GridLayout(2,1);
 this.setLayout(gl);
JButton myButton = new JButton("Kill Time");
 myButton.addActionListener(this);
this.add(myButton);
 this.add(new JTextField());
}
// Обработчик нажатия кнопки
public void actionPerformed(ActionEvent e){
	
	Thread worker=new Thread(this);
	worker.start();
 }

public static void main(String[] args) {
//Создать окно
NoThreadsSample myWindow = new NoThreadsSample();
//Убедиться, что окно закрывается при нажатии на крестик в углу
myWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
// Установить размеры окна – координаты левого верхнего
//угла и высоту с шириной
myWindow.setBounds(0,0,250, 200);
//Сделать окно видимым
myWindow.setVisible(true);
}
@Override
public void run() {
	for (int i=0; i<100000;i++){
		this.setTitle("i="+i);
	
}
 }
  }