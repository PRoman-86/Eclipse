/*
 Выполняем задание для "умников и умниц":
 1. Измените приложение из предыдущего
задания, заменив текстовое поле Модель
велосипеда выпадающим меню с
несколькими моделями, чтобы пользователь
мог выбрать из списка, вместо того, чтобы
вводить с клавиатуры.
2. Прочитайте в Интернете про Swing
компоненты JComboBox и ItemListener
для обработки событий, когда пользователь
выбирает модель велосипеда.
 */

import javax.swing.*; import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*
 Реализовывать выпадающее меню будем через интерфейс ItemListener,
 поэтому добавляем его в класс, хотя при желании можно это сделать
 и через ActionListener. Интерфейс ItemListener имеет одн метод
 itemStateChanged().
 */
public class OrderWindow implements ActionListener, ItemListener {
	
	JFrame frame=new JFrame("Окно заказа");
	JPanel panel=new JPanel(new FlowLayout()); 
	JTextField txtFieldModel=new JTextField("", 20);
	JTextField txtFieldQuantity=new JTextField("0", 2);
	JButton orderButton=new JButton("Заказать");
	JLabel label=new JLabel("Количество:");
	JLabel label2=new JLabel("Модель FireBird (<4) или Ukraina (<11)");
	JLabel txtFieldOrderConfirmation=new JLabel("Ваш заказ еще не сделан");
	/*
	 Зададим переменной selectedModel начальной значение в виде "FireBird" 
	 вместо пустого, так как это первый пункт будущего 
	 выпадающего меню, и он будет отображаться при запуске
	 программы; поэтому если пользователь просто укажет количество велосипедов, не трогая
	 меню, это приведет к ошибке, так как переменная selectedModel будет пуста вследствие
	 того, что метод itemStateChanged() не сработает и не присвоит ей значение.
	 */
	String selectedModel="FireBird"; String selectedQuantity="0"; int quantity=0;
	//Создаем компоненты для выпадающего меню с помощью массива
	String items[] = {"FireBird","Ukraina"};
	//и создаем экземпляр выпадающего меню
	JComboBox comboBox=new JComboBox(items);
	
	OrderWindow() {
		
		panel.add(label2);
		panel.add(comboBox); //добавляем выпадающее меню на панель
		panel.add(label);
		panel.add(txtFieldQuantity);
		panel.add(orderButton); panel.add(txtFieldOrderConfirmation);
		frame.add(panel); frame.pack(); frame.setVisible(true);
		frame.setSize(300,145); frame.setResizable(false);
		orderButton.addActionListener(this);
		comboBox.addItemListener(this);
	}
		public static void main(String[] args) {
			new OrderWindow();
		}
		
		@Override
		/*
		 Реализуем метод интерфейса ItemListener. При выборе элемента
		 выпадающего меню метод будет задавать значение переменной
		 selectedModel с помощью метода getSelectedItem с приведением
		 до String.
		 */
		public void itemStateChanged(ItemEvent e) {
				selectedModel=(String) comboBox.getSelectedItem();
			
		} //конец метода itemStateChanged()

	public void actionPerformed(ActionEvent e) {
		
		selectedQuantity=txtFieldQuantity.getText();
		try {
			quantity=Integer.parseInt(selectedQuantity);
		} catch (NumberFormatException e1) {
			quantity=0; txtFieldQuantity.setText("");
			txtFieldOrderConfirmation.setText(e1.getMessage());
		}
		
		try {
			checkOrder(selectedModel, quantity);
			txtFieldOrderConfirmation.setText("Заказ размещен успешно! "+selectedModel+": "+quantity+" шт.");
		} catch (TooManyBikesException e1) {
			txtFieldOrderConfirmation.setText(e1.getMessage());
		}
	}
	
    void checkOrder (String bikeModel, int quantity) throws TooManyBikesException {
    	
    	if (((bikeModel.equals("FireBird")) & (quantity<4) & (quantity>0)) | ((bikeModel.equals("Ukraina")) & (quantity<11) & (quantity>0))) {
    		System.out.println("Log: "+bikeModel+" ("+quantity+") - approved");
    		} else {
    			System.out.println("Log: "+bikeModel+" ("+quantity+") - declined");
    			throw new TooManyBikesException();
    		}
    }
}

class TooManyBikesException extends Exception {
	
	TooManyBikesException() {
		super("Заказ разместить невозможно");
	}
}