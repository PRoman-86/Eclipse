import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

//Print speed detection program
public class Interface {

	public static void main(String[] args) {
		new Interface();
		System.out.println(new Date() + " - start app");
	}

	JFrame frame = new JFrame("Speed Writer 1.0");
	JPanel mainPanel = new JPanel();
	JTextArea mainArea = new JTextArea(20, 54);
	JScrollPane scroll = new JScrollPane(mainArea);
	JButton startButton = new JButton("START");
	JButton aboutButton = new JButton("ABOUT");
	JLabel timeLabel = new JLabel("60");

	Interface() {

		frame.setSize(680, 410);
		frame.setVisible(true);
		frame.setResizable(false);
		mainArea.setLineWrap(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // close window - stop program
		mainArea.setWrapStyleWord(true);
		mainPanel.setVisible(true);
		mainPanel.add(scroll);
		mainPanel.add(aboutButton);
		mainPanel.add(startButton);
		mainArea.setFont(new Font("Verdana", Font.BOLD, 12));
		timeLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		timeLabel.setForeground(Color.DARK_GRAY);
		mainPanel.add(timeLabel);
		frame.add(mainPanel);
		mainArea.setEditable(false);
		mainArea.setBackground(Color.LIGHT_GRAY);
		mainArea.setForeground(Color.BLUE);

		// the listener is registered to the button
		// when the button is pressed, an object of the class "Engine" is created
		// reference to the current object is passed (this)
		startButton.addActionListener(new Engine(this));
		aboutButton.addActionListener(new Engine(this));

	}

}
