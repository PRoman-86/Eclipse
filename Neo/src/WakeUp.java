import java.awt.*; 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException; 
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class WakeUp implements ActionListener {

	public static void main(String[] args) {
		new WakeUp(); }
	
	JFrame frame=new JFrame("Command Promt");
	JPanel mainPanel=new JPanel(); JPanel upPanel=new JPanel();
	JPanel downPanel=new JPanel();
	JTextArea monitor=new JTextArea("Microsoft Windows [Version 10.0.18362.720]"
			+ "\n(c) 2020 Microsoft Corporation. All rights reserved.\n\nC:\\>Wake Up, Neo...\n",27,65);
	JScrollPane scroll=new JScrollPane(monitor); //создаем скролл и прив€зываем его к объекту прокрутки
	JButton openButton=new JButton("Open"); JButton startButton=new JButton("Start");
	JButton aboutButton=new JButton("About");
	Font font=new Font("Monospased", Font.BOLD, 15);
	String aboutText="\n This program reads the selected file and displays its binary code on "
			+ "the screen. \n The Program is not affiliated with Microsoft Corporation or any feature "
			+ "film.All matches are random. \n The program is a non-profit project written in Java "
			+ "for educational purposes."+"\nC:\\>";
	JFileChooser openDialog=new JFileChooser();
	int selectDialog; String fileName; int bytes; String bits; File file;
	FileInputStream myFile=null; BufferedInputStream myBuffer=null;
	
	WakeUp() {
		
		frame.setSize(800,630); frame.setVisible(true); frame.setResizable(false);
		upPanel.add(scroll); //добавл€€ скролл, сам управл€емый им компонент(monitor) не добавл€етс€
		mainPanel.setLayout(new BorderLayout());
		downPanel.add(openButton); downPanel.add(startButton);
		downPanel.add(aboutButton);
		monitor.setFont(font); monitor.setLineWrap(true); monitor.setForeground(Color.GREEN);
		mainPanel.add(upPanel, "North"); mainPanel.add(downPanel);
		frame.add(mainPanel);
		startButton.setEnabled(false);
		openButton.setBorder(null); startButton.setBorder(null); aboutButton.setBorder(null);
		openButton.setFont(font); startButton.setFont(font); aboutButton.setFont(font);
		upPanel.setBackground(Color.BLACK); downPanel.setBackground(Color.BLACK);
		monitor.setBackground(Color.BLACK); monitor.setEditable(false);
		
		startButton.addActionListener(this); openButton.addActionListener(this);
		aboutButton.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton srcButton=(JButton)e.getSource();
		
		if (srcButton==aboutButton) {
			aboutButton.setBackground(Color.GREEN);
			openButton.setBackground(Color.WHITE);
			startButton.setBackground(Color.WHITE);
			monitor.append("\nC:\\>About this program:"+aboutText);
		}
		
		if (srcButton==startButton) {
			startButton.setBackground(Color.GREEN);
			openButton.setBackground(Color.WHITE);
			aboutButton.setBackground(Color.WHITE);
			
			try {
				
				myFile=new FileInputStream(file);
				myBuffer=new BufferedInputStream(myFile);
				monitor.setText("");
				monitor.append("C:\\>Start of file. Follow the white rabbit...\n\n");
				startButton.setEnabled(false);
				while (true) {
					bytes=myBuffer.read();
					bits=toBits(bytes);
					monitor.append(" "+bits);
					if (bytes==-1) {
						monitor.append("\n\n C:\\>End of file. Matrix has you...");
						break;
					}
				}
				
			} catch (FileNotFoundException e1) {
				monitor.append("\n"+e1.toString());
			} catch (IOException e2) {
				e2.printStackTrace();
			} finally {
						try {
							myBuffer.close(); myFile.close();
						} catch (Exception e3) {
							monitor.append("\nMethods close() exceptions handled \nC:\\>");
						}
					} 
			}
		
		if (srcButton==openButton) {
			openButton.setBackground(Color.GREEN);
			startButton.setBackground(Color.WHITE);
			aboutButton.setBackground(Color.WHITE);
			
			selectDialog=openDialog.showDialog(null, "Open File");
			if (selectDialog==JFileChooser.CANCEL_OPTION) {
				monitor.append("\nC:\\>File selection canceled. Please, select a file.\nC:\\>");
			} if (selectDialog==JFileChooser.APPROVE_OPTION) {
				file=openDialog.getSelectedFile(); 
				fileName=file.getName();
				monitor.append("\nC:\\>Selected file: '"+fileName+"'\n Press "
						+ "'Start' to start the binary output operation...");
				startButton.setEnabled(true);
			}
		}
	}
	
	public String toBits(final int val) {
		 final StringBuilder result = new StringBuilder(); 
		for (int i=0; i<8; i++) { 
		result.append((int)(val >> (8-(i+1)) & 0x0001)); 
		} 
		return result.toString();
		}
}
