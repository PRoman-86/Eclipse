import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy implements ActionListener {

	public static void main(String[] args) {
		new FileCopy();
	}

	JFrame frame = new JFrame("FileCopy");
	JPanel mainPanel = new JPanel();
	JButton fromButton = new JButton("Browse");
	JButton toButton = new JButton("Browse");
	JButton copyButton = new JButton("COPY");
	JTextField fromText = new JTextField(15);
	JTextField toText = new JTextField(15);
	JFileChooser winDialog = new JFileChooser();
	File srcFile = null;
	File copyFile = null;
	int selFile;
	FileInputStream sourceFile = null;
	BufferedInputStream srcBuff = null;
	FileOutputStream finalFile = null;
	BufferedOutputStream finBuff = null;
	int bytes;

	FileCopy() {

		frame.setSize(360, 140);
		frame.setVisible(true);
		frame.add(mainPanel);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // close window - stop program
		frame.setResizable(false);
		fromText.setEditable(false);
		toText.setEditable(false);
		mainPanel.add(new Label("Copy from:  "));
		mainPanel.add(fromText);
		mainPanel.add(fromButton);
		mainPanel.add(new Label("Copy to:       "));
		mainPanel.add(toText);
		mainPanel.add(toButton);
		mainPanel.add(copyButton);

		fromButton.addActionListener(this);
		toButton.addActionListener(this);
		copyButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object pushButton = e.getSource();

		if (pushButton == fromButton) {
			fromText.setText("");
			toText.setText("");
			selFile = winDialog.showDialog(null, "Select");
			if (selFile == JFileChooser.APPROVE_OPTION) {
				srcFile = winDialog.getSelectedFile();
				fromText.setText(srcFile.getName());
			}
		}

		if (pushButton == toButton) {
			fromText.setText("");
			toText.setText("");
			try {
				fromText.setText(srcFile.getName());
			} catch (NullPointerException e3) {
				fromText.setText("" + "Select the source file");
			}
			selFile = winDialog.showDialog(null, "Select");
			if (selFile == JFileChooser.APPROVE_OPTION) {
				copyFile = winDialog.getSelectedFile();
				toText.setText(copyFile.getName());
			}
		}

		if (pushButton == copyButton) {
			try {
				fileCopier();
				fromText.setText("" + "Copy completed successfully");
			} catch (IOException e1) {
				System.out.println("Method fileCopier() exception handled");
				errorText();
			} catch (NullPointerException e2) {
				errorText();
			} finally {
				try {
					finBuff.flush();
					sourceFile.close();
					finalFile.close();
					srcBuff.close();
					finBuff.close();
					System.out.println("Bytes successfully streamed");
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (NullPointerException e2) {
					System.out.println("Methods flush(), close() exception handled");
				}
			}
		}
	}

	void fileCopier() throws IOException, NullPointerException {

		sourceFile = new FileInputStream(srcFile);
		finalFile = new FileOutputStream(copyFile);
		srcBuff = new BufferedInputStream(sourceFile);
		finBuff = new BufferedOutputStream(finalFile);

		while (true) {
			bytes = srcBuff.read();
			if (bytes == -1)
				break;
			finBuff.write(bytes);
		}
	}

	void errorText() {
		fromText.setText("" + "IOError");
		toText.setText("" + "IOError");
	}
}