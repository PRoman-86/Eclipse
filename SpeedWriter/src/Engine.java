import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;

public class Engine implements ActionListener, Runnable {

	Interface ui; // variable for reference to class object "Interface"
	String inputText = null;
	String textTime = null;
	int result = 0;
	String aboutText = " Speed Writer - это программа для проверки скорости набора текста. "
			+ "Писать разрешается произвольный текст, однако орфографические ошибки недопустимы, "
			+ "хотя и не проверяются при окончании теста. Пробелы учитываются при подсчете. "
			+ "На тест дается ровно одна минута. Нажмите кнопку START и начинайте печать.\r\n"
			+ "Написана на Java, версия 1.0. sourcecode\r\n" + "(С)Pesticide, 2021\r\n"

			+ "\r\n" + " Нормальная скорость набора составляет около 200 знаков в минуту. Профессионал "
			+ "печатает со скоростью 300 знаков и больше. Чтобы записать речь говорящего, то "
			+ "нужно набирать 450 знаков в минуту, а для конспектирования собраний и диспутов "
			+ "стучать пальцами требуется еще быстрее: от 700 до 900 ударов в минуту.";

	Engine(Interface ui) {
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) { // implement the ActionListener interface
		JButton clickAboutButton = (JButton) e.getSource();
		if (clickAboutButton == ui.aboutButton) {
			ui.mainArea.setText("");
			ui.mainArea.append(aboutText);
			System.out.println("ABOUT");
			return;
		}
		ui.mainArea.setText("");
		ui.timeLabel.setForeground(Color.DARK_GRAY);
		ui.mainArea.setEditable(true);
		ui.startButton.setEnabled(false);
		ui.aboutButton.setEnabled(false);
		ui.mainArea.requestFocus(); // set focus to the text field, the cursor will appear automatically

		// creating a parallel thread for timer
		new Thread(this).start();

	}

	public void run() { // this method implementing interface Runnable for work parallel thread
		for (int i = 60; i >= 0; i--) { // implement a timer in a loop
			textTime = Integer.toString(i);
			ui.timeLabel.setText(textTime);
			if (i == 15)
				ui.timeLabel.setForeground(Color.RED);
			if (i == 0) // time for the test is over
				endOfTest();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void endOfTest() { // completion of the test
		ui.mainArea.setEditable(false);
		ui.startButton.setEnabled(true);
		ui.aboutButton.setEnabled(true);
		inputText = ui.mainArea.getText();

		if ("sourcecode".equalsIgnoreCase(inputText))
			outputSourceCode(); // easter egg

		result = inputText.length();
		ui.mainArea.append("\n---------------------\nТест завершен. Результат: " + result + " символ(-ов)");
		ui.mainArea.setCaretPosition(ui.mainArea.getDocument().getLength()); // move the scroll down
		System.out.println(new Date() + " - end test, result: " + result);

	}

	public void outputSourceCode() {
		ui.mainArea.setText("");
		ui.mainArea.append("public class Engine implements ActionListener, Runnable {\r\n" + "\r\n"
				+ "	Interface ui;\r\n" + "	String inputText = null;\r\n" + "	String textTime = null;\r\n"
				+ "	int result = 0;\r\n" + "	String aboutText = \" Speed Writer - это\";\r\n" + "\r\n"
				+ "	Engine(Interface ui) {\r\n" + "		this.ui = ui;\r\n" + "	}\r\n" + "\r\n" + "	@Override\r\n"
				+ "	public void actionPerformed(ActionEvent e) { \r\n"
				+ "		JButton clickAboutButton = (JButton) e.getSource();\r\n"
				+ "		if (clickAboutButton==ui.aboutButton) {\r\n" + "			ui.mainArea.setText(\"\");\r\n"
				+ "			ui.mainArea.append(aboutText);\r\n" + "			System.out.println(\"ABOUT\");\r\n"
				+ "			return;\r\n" + "		}\r\n" + "		ui.mainArea.setText(\"\");\r\n"
				+ "		ui.mainArea.setEditable(true);\r\n" + "		ui.startButton.setEnabled(false);\r\n"
				+ "		ui.aboutButton.setEnabled(false);\r\n" + "		ui.mainArea.requestFocus(); \r\n" + "\r\n"
				+ "		new Thread(this).start();\r\n" + "\r\n" + "	}\r\n" + "\r\n" + "	public void run() { \r\n"
				+ "		for (int i = 60; i >= 0; i--) { \r\n" + "			textTime = Integer.toString(i);\r\n"
				+ "			ui.timeLabel.setText(textTime);\r\n" + "			if (i == 15)\r\n"
				+ "				ui.timeLabel.setForeground(Color.RED);\r\n" + "			if (i == 0) \r\n"
				+ "				endOfTest();\r\n" + "			try {\r\n" + "				Thread.sleep(1000);\r\n"
				+ "			} catch (InterruptedException e) {\r\n" + "				e.printStackTrace();\r\n"
				+ "			}\r\n" + "		}\r\n" + "	}\r\n" + "\r\n" + "	public void endOfTest() { \r\n"
				+ "		ui.mainArea.setEditable(false);\r\n" + "		ui.startButton.setEnabled(true);\r\n"
				+ "		ui.aboutButton.setEnabled(true);\r\n" + "		\r\n"
				+ "		inputText=ui.mainArea.getText();\r\n" + "		result=inputText.length();\r\n"
				+ "		ui.mainArea.append(\"\\nРезультат: \"+result+\" символ(-ов)\");\r\n"
				+ "		ui.mainArea.setCaretPosition(ui.mainArea.getDocument().getLength());\r\n"
				+ "		System.out.println(new Date() + \" - end test, result: \"+result);\r\n" + "		\r\n"
				+ "	}\r\n" + "\r\n" + "}");
	}

}
