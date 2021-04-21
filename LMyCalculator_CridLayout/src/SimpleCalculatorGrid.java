import javax.swing.*;
import java.awt.GridLayout;
public class SimpleCalculatorGrid {
	public static void main(String[]args) {
		//create the panel
		JPanel windowContent= new JPanel();
		// set layout manager for this panel
		GridLayout g1=new GridLayout(4,2);
		windowContent.setLayout(g1);
		// create components in the memory
		JLabel label1 = new JLabel("Number 1:");
		JTextField field1 = new JTextField (10);
		JLabel label2 = new JLabel ("Num 2");
		JTextField field2 = new JTextField(10);
		JLabel label3 = new JLabel ("Sum");
		JTextField result = new JTextField(10);
		JButton go=new JButton ("Add");
		//add components to the panel
		windowContent.add(label1);
		windowContent.add(field1);
		windowContent.add(label2);
		windowContent.add(field2);
		windowContent.add(label3);
		windowContent.add(result);
		windowContent.add(go);
		//create the frame and set panel for the frame
		JFrame frame = new JFrame ("My second calculator");
		frame.setContentPane(windowContent);
		//set the size and make window visible
		frame.setSize(400,100);
		frame.setVisible(true);
		
	}
}
