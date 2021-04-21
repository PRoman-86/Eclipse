/*
 Практическое упражнение (стр 151):
 1.   Создайте   Swing-­‐приложение   для 
размещения  заказов  на  покупку  велосипедов. 
Оно  должно  содержать  два  текстовых  поля 
Модель  велосипеда  и  Количество,  кнопку 
Разместить   заказ   и   сообщение   для 
подтверждения  заказа. 
2.   Используйте   код   из   примеров   с 
OrderWindow  и  TooManyBikesException. 
Попробуйте  несколько  комбинаций  моделей 
велосипедов   и   количества,   которые 
вызывали  бы  исключение. 
 */

import javax.swing.*; import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderWindow implements ActionListener {
	
	JFrame frame=new JFrame("Окно заказа");
	JPanel panel=new JPanel(new FlowLayout()); 
	JTextField txtFieldModel=new JTextField("", 20);
	JTextField txtFieldQuantity=new JTextField("0", 2);
	JButton orderButton=new JButton("Заказать");
	JLabel label=new JLabel("Количество:");
	JLabel label2=new JLabel("Выберите модель FireBird (<4) или Ukraina (<11)");
	JLabel txtFieldOrderConfirmation=new JLabel("Ваш заказ еще не сделан");
	String selectedModel; String selectedQuantity; int quantity;
	
	OrderWindow() {
		
		panel.add(label2);
		panel.add(txtFieldModel); panel.add(label);
		panel.add(txtFieldQuantity);
		panel.add(orderButton); panel.add(txtFieldOrderConfirmation);
		frame.add(panel); frame.pack(); frame.setVisible(true);
		frame.setSize(300,145); frame.setResizable(false);
		orderButton.addActionListener(this);
	}
		public static void main(String[] args) {
			new OrderWindow();
		}

	public void actionPerformed(ActionEvent e) {
		
		selectedModel=txtFieldModel.getText(); //получаем модель с текстового поля ввода модели велосипеда
		selectedQuantity=txtFieldQuantity.getText(); //получаем количество велосипедов с поля ввода количества
		
		try {
			/*
			 преобразуем текст из string-переменной selectedQuantity в целое число
			 и присваиваем его int-переменной quantity. В связи с этим может возникнуть исключение NumberFormatException, если 
			 пользователь введет вместо числа какие-либо символы. Поэтому обрабатываем исключение блоком
			 try/catch, в случае исключения задавая переменной quantity нулевое значение, очищая текстовое поле ввода
			 количества и выводим в поле подтвеждения заказа ошибку "Заказ разместить невозможно" посредством
			 метода getMessage().
			 */
			quantity=Integer.parseInt(selectedQuantity);
		} catch (NumberFormatException e1) {
			quantity=0; txtFieldQuantity.setText("");
			txtFieldOrderConfirmation.setText(e1.getMessage());
		}
		
		try {
			/*
			 Происходит вызов метода checkOrder(), проверяющего заказ. Его аргументы - наши переменные типа String и Int,
			 (selectedModel и quantity) содержащие в себе модель и количество велосипедов соответственно. 
			 Если заказ подходит под условия, описанные в теле метода, он не вызывает исключение и выполняется код
			 строкой ниже- в поле подтверждение заказа (txtFieldOrderConfirmation) выводится текст об успешном
			 размещении заказа.
			 В случае, если метод вызывает исключение в это поле выводится ошибка "Заказ разместить невозможно"
			 посредством метода getMessage().
			 Это исключение (TooManyBikesException) создано программистом (см ниже)
			 */
			checkOrder(selectedModel, quantity);
			txtFieldOrderConfirmation.setText("Заказ размещен успешно! "+selectedModel+": "+quantity+" шт.");
		} catch (TooManyBikesException e1) {
			txtFieldOrderConfirmation.setText(e1.getMessage());
		}
	}
	
	/*
	 Объявляем метод checkOrder(), который проверяет, может ли заказ быть выполнен с помощью блока if-else.
	 Также метод говорит нам (оператор throws), что может вызвать исключение класса TooManyBikesException и что обрабатываться
	 это исключение будет не внутри него, а в вызвавшем его методе, т.е. в actionPerformed().
	 Если заказ не может быть выполнен, то метод вызывает исключение, которое перехватывается блоком catch чуть выше.
	 */
    void checkOrder (String bikeModel, int quantity) throws TooManyBikesException {
    	//если модель велосипеда FireBird и количество меньше четырех и больше нуля
    	//или модель велосипеда Ukraina и количество меньше 11 и больше нуля, то исключение не вызывается
    	if (((bikeModel.equals("FireBird")) & (quantity<4) & (quantity>0)) | ((bikeModel.equals("Ukraina")) & (quantity<11) & (quantity>0))) {
    		System.out.println("Log: "+bikeModel+" ("+quantity+") - approved");
    		//в противном случае
    		} else {
    			System.out.println("Log: "+bikeModel+" ("+quantity+") - declined");
    			throw new TooManyBikesException(); //вызываем исключение оператором throw
    			//обращаясь к экземпляру класса TooManyBikesException c помощью оператора new
    		}
    }
}

/*
 Объявляем класс TooManyBikesException, который наследуется от класса-исключения Exception
Этот  класс  содержит  только  конструктор,  получающий  сообщение, 
которое  описывает  ошибку.  Это  сообщение  конструктор  передаёт  для 
хранения  суперклассу.  Когда  в  блок  catch  попадает  это  исключение, 
можно  узнать,  что  именно  произошло,  вызвав  метод  getMessage(). 
 */

class TooManyBikesException extends Exception {
	//объявляем конструктор
	TooManyBikesException() {
		super("Заказ разместить невозможно"); //вызываем конструктор суперкласса и передаем ему сообщения для отображения
	}
}