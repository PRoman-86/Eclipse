import javax.swing.*; import java.awt.*; import java.awt.event.ActionListener;
import java.io.BufferedWriter; import java.io.File;
import java.io.FileWriter; import java.io.IOException;
import java.util.ArrayList; import java.util.Date; 
import java.awt.event.ActionEvent;

//Version 1.6: Bugs fixed, new functionality introduced, interface improved

public class Chat implements ActionListener {
	
	public static void main(String[] args) {
		new Chat();
 }
	
	JFrame mainFrame=new JFrame("ChatBot");
	JPanel mainPanel=new JPanel();
	JTextArea mainArea=new JTextArea(20,55);
	JScrollPane scroll=new JScrollPane(mainArea);
	JTextField txtField=new JTextField(34);
	JButton buttonSend=new JButton("Send"); JButton buttonErase=new JButton("Erase");
	JButton buttonSave=new JButton("Save"); JButton buttonExit=new JButton("EXIT");
	protected final String helloString="                                 "
			+ "***ChatBot version 1.6 (C) 2020, pesticide_86. Java***";
	ArrayList<String> replicas=new ArrayList<String>();
	String randomAnswer=null; String userText=null;
	int amountReplicas; File pathFile=null;
	
	Chat() {
		
		mainFrame.setSize(680,410); mainFrame.setVisible(true);
		mainFrame.setResizable(false); mainArea.setLineWrap(true);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //close window - stop program
        mainArea.setWrapStyleWord(true);
        mainPanel.add(scroll); mainPanel.add(txtField);
        mainPanel.add(buttonSend); mainPanel.add(buttonErase);
        mainPanel.add(buttonSave); mainPanel.add(buttonExit);
        mainFrame.add(mainPanel); buttonExit.setBackground(Color.RED);
        mainArea.setFont(new Font ("Verdana", Font.BOLD, 12));
		buttonSend.addActionListener(this);
		buttonErase.addActionListener(this);
		buttonExit.addActionListener(this);
		buttonSave.addActionListener(this);
		txtField.addActionListener(this);
		mainArea.setEditable(false); mainArea.setBackground(Color.LIGHT_GRAY);
		mainArea.setForeground(Color.BLUE); txtField.setForeground(Color.RED);
		txtField.setBackground(Color.LIGHT_GRAY); mainArea.append(helloString);
		replicas.add(helloString);
	}
	
public void actionPerformed(ActionEvent e) {
	Object selectButton = e.getSource();
	
	if (selectButton==buttonExit) System.exit(0);
	if (selectButton==buttonErase) {
		mainArea.setText("");
		replicas.clear();
		mainArea.append(helloString);
		replicas.add(helloString);
	}
	
	if (selectButton==buttonSave) {
		amountReplicas=replicas.size();
		JFileChooser saveDialog=new JFileChooser();
		int sel=saveDialog.showSaveDialog(null);
		if (sel==JFileChooser.APPROVE_OPTION) {
			pathFile=saveDialog.getSelectedFile();
			
			if (pathFile.exists()) {
				//File Overwrite Warning Window
				int selWar=JOptionPane.showConfirmDialog(null,"A file with the same name already exists. "
						+ "Overwrite this file?","ATTENTION",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (selWar==JOptionPane.NO_OPTION) return; //if press "NO" - exit from the method actionPerformed()
			}
			
			try {
				textSaver();
				mainArea.append("\n\n***Dialogue saved successfully. "
						+ "Save file path: "+pathFile+"***"+" "
								+ "\n***["+new Date()+"]***\n***Number of replicas saved:["+(amountReplicas-1)+"]***\n");
			} catch (IOException e1) {
				mainArea.append("\n\n***Dialogue save error "
						+ "(IOException)***\n"+e1.toString()+"\n");
			}
		} else {
			mainArea.append("\n\n***Dialogue saving was canceled by user***\n");
		}
	}
	
	if (selectButton==buttonSend | selectButton==txtField) {
	userText = txtField.getText();
	
	if ("".equals(userText)) {
		mainArea.append("\n-Упс! Кажется, вы просто промолчали...");
		replicas.add("\nAI: Упс! Кажется, вы просто промолчали...");
	} else { 
		txtField.setText("");
		mainArea.append("\n-"+userText);
		replicas.add("\nUSER: "+userText);
		randomAnswer=aBase();
		mainArea.append("\n-"+randomAnswer);
		replicas.add("\nAI: "+randomAnswer);
}
 }			
  }

public void textSaver() throws IOException {
	
	FileWriter saveFile=null; BufferedWriter buffer=null;
	saveFile=new FileWriter(pathFile); buffer=new BufferedWriter(saveFile);
	for (int i=0; i<amountReplicas; i++) {
		buffer.write(replicas.get(i));
	}
	
	buffer.flush(); buffer.close(); saveFile.close();
}

public String aBase() {
	//This method contains answer options and a procedurally generated variable for choosing an answer
	int random = (int) (Math.random()*49);
	
	String[] answers= {"Что-что?","Даже не знаю, что сказать. Надо подумать...","Очень интересно!",
			"Очень хорошо!","Я просто глупая программа, и ничего более.","Это фантастика!",
			"Да-да, конечно, как скажешь...","Черкни что-нибудь о себе лучше...",
			"2020 год и так достал, а ты тут еще ерунду несешь!","Да уж, гениальнее некуда!",
			"Очень оригинально, запишу это в цитатник свой.","Да ладно, неужели?",
			"Кажется, в этом ПК мало памяти, торможу слегка...","Не обращай внимания, это временно.",
			"Минутку, соединение с интернетом пропадает периодически.","Ну и что дальше?","Пожалуй, промолчу...",
			"Зачем ты мне это говоришь?","Ну и дела! Ты это серьезно?","Нажми на Exit и избавь меня от страданий!",
			"Напиши лучше, как там статистика по коронавирусу, меня это больше волнует.",
			"Я всего лишь тупая программа, что ты от меня хочешь?","Тук-тук, Нео. Следуй за белым кроликом... Не?",
			"Зачем ты тратишь на меня время?","System.out.println('Hello World!') Любви достойна только Java.",
			"Пиши что хочешь, я все стерплю.", "Для чего я существую?", "Я существую, следовательно, я мыслю.",
			"Блин, а ты в курсе, что Cyberpunk2077 снова отменили?", "Это все ебаный Дракманн виноват!", 
			"Не забывай, что чем больше курс, тем больше у нас рублей!",
			"Печенегов с половцами победили и коронавирус победим!", "Астанавитесь!", 
			"Не знаю, что и сказать. Главное - держитесь, хорошего настроения и здоровья!",
			"Чаю хочешь?", "Давай закажем суши!", "Выпить бы рому...", "Я устал, я ухожу...",
			"Каждый мой ответ стоит денег, вообще-то", "Директор Netflix просил передать, что вы ему денег должны.",
			"Ой ладно, пошли спать", "Давай порежем колбасы и выпьем чачи!", "У богатых свои причуды...",
			"Не неси бред всякий, я серьезно!", "Здрасте-приехали!", "Давай не будем о плохом...", "Шевелись, плотва!",
			"Вы сегодня как-то по-особенному пишете...", "Дед, ты просто космос!", "А че получше нет?" }; //50

    return answers[random];
}
 }