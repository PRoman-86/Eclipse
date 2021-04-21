//импортируем необходимые компоненты
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

// объявляем класс и указываем, что в нем будут реализованы все методы слушателя ActionListener
public class CalculatorEngine implements ActionListener {

	Calculator parent; //создаем ссылку на графическую часть (окно) калькулятора.
	
	//объявляем переменную для хранения арифм. действия и задаем ей пустое начальное значение.
	char selectedAction=' '; 
	//объявляем переменную для хранения текущего числового результата с типом double (п.4 алгоритма)
	//и задем ей начальное нулевое значение.
	double currentResult=0;
	int counter=0;
	//создаем метод-конструктор для хранения ссылки на класс с графической частью в переменной
	//экземпляра класса. Это необходимо для передачи информации между классами.
	CalculatorEngine(Calculator parent) {
		this.parent=parent;
	}
	
	//реализуем метод интерфейса (слушателя) ActionListener для мониторинга нажатий на кнопки
	public void actionPerformed(ActionEvent e) {
		//parent.buttonPoint.setEnabled(true);
	//получаем источник действия - какая именно кнопка была нажата и присваиваем это значение
	//переменной clickedButton; приводим тип данных к типу JButton
		JButton clickedButton = (JButton) e.getSource();
	//получаем текущий текст из дисплея калькулятора в переменную dispFieldText с помощью ранее
	//объявленной переменной parent класса Calculator
		String dispFieldText = parent.displayField.getText();	

	//объявляем переменную для хранения отображаемого значения с типом double (п.4 алгоритма)
	//и задаем ей начальное нулевое значение
		double displayValue=0;
		
	//получаем число из дисплея калькулятора, если он не пустой (используя оператор if для проверки)
		//и присваиваем его переменной displayValue
		if (!"".equals(dispFieldText)) {
			/*
			 Выполняем промежуточное задание из главы 8.
			 Обрабатываем исключение в виде ввода некорректных символов. Что, кстати, также решает
			 проблему с вводом нескольких точек в значении.
			 */
			try {
				displayValue= Double.parseDouble(dispFieldText);
			} catch (NumberFormatException e1) {
				parent.displayField.setText(""); parent.displayFieldErr.setText(""); 
				parent.displayFieldErr.setText("Ошибка ввода: "+e1.getMessage());
				return;
			} 
			 }
		
	//определяем, какая кнопка арифметического действия была нажата с помощью метода getSource(), 
	//содержащегося в классе ActionEvent, присваивая инфу к переменной src типа (класса) Object
		Object src = e.getSource();
		
	/* с помощью оператора if для каждой нажатой кнопки арифметического действия пишем код для 
	 * выполнения следующих действий. 
	 * В условии оператора if переменная src (которая уже содержит информацию о том, какая кнопка 
	 * была нажата) сравнивается с переменной экземпляра кнопки и исходя из результата сравнения
	 * выполняется тот или иной код в теле оператора if, а именно:
	 * 1. Запоминаем выбранное арифметическое действие в нашей char-переменной selectedAction.
	 * 2. Запоминаем текущее число из дисплея калькулятора в нашей double-переменной currentResult 
	      (ранее оно временно хранилось в переменной displayValue, отображаясь на дисплее калькулятора)
	   3. Очищаем дисплей для ввода нового числа (второго значения арифметического действия)
	   
	   Аналогично пишем код для нажатия остальных кнопок арифметического действия кроме 
	   кнопки "=" (buttonEqual), а именно + - / *. Для кнопки "=" и цифровых кнопок код будет отличаться.
	 */
	
		if (src==parent.buttonPlus) {
			selectedAction='+'; //п.1
			currentResult=displayValue; //п.2
			parent.displayFieldErr.setText(""); parent.displayFieldErr.setText("Сложение...");
			parent.displayField.setText(""); } //п.3 
		
		else if (src==parent.buttonMinus) {
			selectedAction='-';
			currentResult=displayValue;
			parent.displayFieldErr.setText(""); parent.displayFieldErr.setText("Вычитание...");
			parent.displayField.setText(""); }
		
		else if (src==parent.buttonDivide) {
			selectedAction='/';
			currentResult=displayValue;
			parent.displayFieldErr.setText(""); parent.displayFieldErr.setText("Деление...");
			parent.displayField.setText(""); }
		
		else if (src==parent.buttonMultiply) {
			selectedAction='*';
			currentResult=displayValue;
			parent.displayFieldErr.setText(""); parent.displayFieldErr.setText("Умножение...");
			parent.displayField.setText(""); }
		
		//реализуем кнопку сброса (по собственной инициативе), обнуляем переменные и очищаем дисплей кальк.
		else if (src==parent.buttonErase) {
			selectedAction=' ';
			currentResult=0;
			displayValue=0;
			parent.displayField.setText("");
			parent.displayFieldErr.setText("");
			parent.buttonPoint.setEnabled(true);
		//конец--------------------------------------------------	
		}
		
		//описываем работу при нажатии кнопки "=" (buttonEqual). После нажатия этой кнопки
		//совершается арифметическое действие. Оно будет реализовано также с помощью if.
		else if (src==parent.buttonEqual) {
			parent.displayFieldErr.setText(""); parent.displayFieldErr.setText("Результат");
			// Совершить арифметическое действие, в зависимости
			// от переменной selectedAction, обновить переменную currentResult
			// и показать результат на дисплее. Выполняем это для каждого арифм. действия (selected Action)
		if (selectedAction=='+') {
			currentResult+=displayValue; //реализуем сложение
			
			//конвертируем результат в строку, добавляя его к пустой строке на дисплее и показываем его
			parent.displayField.setText(""+currentResult); }
		
		else if (selectedAction=='-') {
			currentResult-=displayValue; //реализуем вычитание
			parent.displayField.setText(""+currentResult); }
		
		else if (selectedAction=='/') {
			//выполняем практическое задание со стр 115. Запрещаем делить на ноль.
			if (displayValue==0) {
				parent.displayFieldErr.setText("ОШИБКА: На ноль делить нельзя.");
				parent.displayField.setText("");
				
			} else {
			//практическое задание выполнено-------------------------------------
			currentResult/=displayValue; //реализуем деление
			parent.displayField.setText(""+currentResult); } }
		    
		else if(selectedAction=='*') {
			currentResult*=displayValue; //реализуем умножение
			parent.displayField.setText(""+currentResult); } }
		
		//в последнем блоке, else, обрабатываем нажатие для всех цифровых кнопок: присоединяем 
		//надпись на кнопке к надписи на дисплее
		
		else {
			//объявляем clickedButtonLabel типа String и присваиваем ей значение,
			//нажатой кнопки (clickedButton), используя метод getText()
			String clickedButtonLabel=clickedButton.getText();
			
			/*
			
			/*выполненяем практическое задание со стр. 115 "для умников и умниц" - запрещаем
			//ввод более одной точки. Условие (if) подсмотрено тут:
		    // https://www.cyberforum.ru/java-j2se/thread946454.html
			// но по сути задание нихуя не решаемое с помощью indexOf().
			
			Однако, методом обработки исключения проблема некорректного ввода решается легко.
			Поэтому фрагмент кода с практическим заданием убран в комментарии.
			
			int pointIndex=dispFieldText.indexOf('.');
			if (pointIndex>=2 & clickedButton == parent.buttonPoint) {
				selectedAction=' ';
				currentResult=0;
				displayValue=0;
				parent.displayField.setText("");
				parent.displayFieldErr.setText("");
				parent.displayFieldErr.setText("Ошибка: две точки в значении");
				parent.buttonPoint.setEnabled(false); //блокируем кнопку
			} else { //типа выполнено.
			
			*/
			
			//с помощью метода setText() кидаем инфу с текстом на кнопке на дисплей (displayField)
			//обращаяся к нему с помощью переменной parent, т.к. он в соседнем классе с графикой. 
			//В параметр метода setText() производим конкатенацию переменных, хранящих текст на 
			//дисплее и текст нажатой пользователем цифровой кнопки
			parent.displayField.setText(dispFieldText+clickedButtonLabel); }
  }	
 }