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

/*Print speed detection program
ver 1.0 - realase
ver 1.1 - source optimization

*/

public class Interface {

	public static void main(String[] args) {
		new Interface();
		System.out.println(new Date() + " - start app");
	}

	JFrame frame = new JFrame("Speed Writer 1.1");
	JPanel mainPanel = new JPanel();
	JTextArea mainArea = new JTextArea(20, 54);
	JScrollPane scroll = new JScrollPane(mainArea);
	JButton startButton = new JButton("START");
	JButton aboutButton = new JButton("ABOUT");
	JLabel timeLabel = new JLabel("60");

	Interface() {
		// create an engine object (class "Engine")
		Engine engine = new Engine(this);

		// UI
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
		startButton.addActionListener(engine);
		aboutButton.addActionListener(engine);

	}

}
