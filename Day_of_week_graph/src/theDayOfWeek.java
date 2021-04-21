import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class theDayOfWeek {
	
	JButton but01=new JButton ("One");
	JButton but02=new JButton ("Two");
	JButton but03=new JButton ("Three");
	JButton but04=new JButton ("Four");
	JButton but05=new JButton ("Five");
	JButton but06=new JButton ("Six");
	JButton but07=new JButton ("Seven");
	JButton butSend=new JButton("Send");
	JButton butView=new JButton("View your text");
	JPanel mainPanel=new JPanel();
	JPanel panel1=new JPanel();
	JPanel panel2=new JPanel();
	JPanel panel3=new JPanel();
	JFrame frame=new JFrame("CYD v1.7");
	JLabel northLabel=new JLabel("Ñhoose Your Day now!");
	JLabel tabLabel=new JLabel("<html>This program was written as part of the<br>" +
            "training and does not have any purpose.<br></html>");
	JLabel supportLabel=new JLabel("Write a review here:");
	JLabel sendText = new JLabel("<html>Your message has been sent.<br>" +
            "Thank you!<br></html>");
	JTextField supportText=new JTextField(10);
	
	
	theDayOfWeek() {
		
		mainPanel.setLayout(new BorderLayout());
		
		Font fontNorthLabel = new Font ("Century Gothic", Font.BOLD, 25);
		northLabel.setHorizontalAlignment(JLabel.CENTER);
		northLabel.setForeground(Color.blue);
		northLabel.setFont(fontNorthLabel);
		
		Font fontTabLabel = new Font ("Verdana", Font.ITALIC, 14);
		tabLabel.setForeground(Color.red);
		tabLabel.setHorizontalAlignment(JLabel.CENTER);
		tabLabel.setFont(fontTabLabel);
		
		sendText.setFont(fontTabLabel);
		sendText.setForeground(Color.blue);
		
		Font supportTabLabel=new Font("Verdana",Font.ITALIC,11);
		supportLabel.setForeground(Color.gray);
		supportLabel.setFont(supportTabLabel);
		
		JTabbedPane tabs=new JTabbedPane(JTabbedPane.TOP);
		panel1.setLayout(new GridLayout(2,4));
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		panel1.add(but01); panel1.add(but02);
		panel1.add(but03); panel1.add(but04);		
		panel1.add(but05); panel1.add(but06);
		panel1.add(but07);
		panel1.add(new JLabel(" (C)PRV, may 2020"));
		panel2.add(tabLabel);
		panel3.add(supportLabel);
		panel3.add(supportText);
		panel3.add(butView); panel3.add(butSend);
		tabs.addTab("Select", panel1);
		tabs.addTab("About the program", panel2);
		tabs.addTab("Support", panel3);
		
		mainPanel.add("North", northLabel);
		mainPanel.add("South", tabs);
		
		frame.add(mainPanel);
		frame.pack();	
		frame.setVisible(true);
		frame.setResizable(false);
		
		but01.addActionListener(new buttonListener (this));
		but02.addActionListener(new buttonListener (this));
		but03.addActionListener(new buttonListener (this));
		but04.addActionListener(new buttonListener (this));
		but05.addActionListener(new buttonListener (this));
		but06.addActionListener(new buttonListener (this));
		but07.addActionListener(new buttonListener (this));
		butSend.addActionListener(new buttonListener (this));
		butView.addActionListener(new buttonListener (this));
	}
		
	public static void main(String[] args) {
		new theDayOfWeek();
}
 }

class buttonListener implements ActionListener {
	
	theDayOfWeek graph;
	buttonListener(theDayOfWeek graph) {
		this.graph=graph;
	}
	public void actionPerformed(ActionEvent e) {
		
		Object pushBut = e.getSource();
		String userText=graph.supportText.getText();
		
		if (pushBut==graph.but01) {
			JOptionPane.showMessageDialog(null, "<html><i>You chose:</i><p><font size=\"5\" "
					+ "color=\"black\" face=\"Arial\">MONDAY</font>");
		} else if (pushBut==graph.but02) {
			JOptionPane.showMessageDialog(null, "<html><i>You chose:</i><p><font size=\"5\" "
					+ "color=\"black\" face=\"Arial\">TUESDAY</font>");
		} else if (pushBut==graph.but03) {
			JOptionPane.showMessageDialog(null, "<html><i>You chose:</i><p><font size=\"5\" "
					+ "color=\"black\" face=\"Arial\">WEDNESDAY</font>");
		} else if (pushBut==graph.but04) {
			JOptionPane.showMessageDialog(null, "<html><i>You chose:</i><p><font size=\"5\" "
					+ "color=\"black\" face=\"Arial\">THURSDAY</font>");
		} else if (pushBut==graph.but05) {
			JOptionPane.showMessageDialog(null, "<html><i>You chose:</i><p><font size=\"5\" "
					+ "color=\"black\" face=\"Arial\">FRIDAY</font>");
		} else if (pushBut==graph.but06) {
			JOptionPane.showMessageDialog(null, "<html><i>You chose:</i><p><font size=\"5\" "
					+ "color=\"red\" face=\"Arial\">SATURDAY</font>");
		} else if (pushBut==graph.but07) {
			JOptionPane.showMessageDialog(null, "<html><i>You chose:</i><p><font size=\"5\" "
					+ "color=\"red\" face=\"Arial\">SUNDAY</font>");
		
		} else if (pushBut==graph.butView) {

			JPanel userTextPanel = new JPanel();
			userTextPanel.setLayout(new FlowLayout());
			JTextArea userTextArea = new JTextArea(10,25);
			JFrame userTextFrame = new JFrame("View entered text");
			Border userTextBorder = BorderFactory.createLineBorder(Color.red, 1);
			
			userTextArea.setBorder(userTextBorder);
			userTextArea.setFont(new Font ("Verdana", Font.ITALIC, 14));
			userTextArea.setForeground(Color.BLUE);
			userTextArea.setText(userText);
			userTextArea.setWrapStyleWord(true);
			userTextArea.setLineWrap(true);
			userTextArea.setEditable(false);
			
			userTextPanel.add(userTextArea);
			userTextFrame.add(userTextPanel);
			userTextFrame.setResizable(false);
			userTextFrame.setSize(450, 250);
			userTextFrame.setVisible(true);
			
        } else if (pushBut==graph.butSend) {
			if (!"".equals(userText)) {
				graph.supportText.setText("");
				JOptionPane.showMessageDialog(null, graph.sendText); }
			else {
				JOptionPane.showMessageDialog(null, "<html><i>Field is empty</i><p><font size=\"5\" "
						+ "color=\"red\" face=\"Arial\">ERROR</font>"); }
			
			
} 
 }
  }