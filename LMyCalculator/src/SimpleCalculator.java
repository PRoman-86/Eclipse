
import javax.swing.*;
import java.awt.FlowLayout;
public class SimpleCalculator {
	public static void main (String []args) {
		//create the panel
		JPanel windowContent = new JPanel();
		// set the layout managers
		FlowLayout f1= new FlowLayout ();
		windowContent.setLayout(f1);
	// create components in the memory	
	JLabel label1=new JLabel("Number 1");
	JTextField field1= new JTextField(10);
	JLabel label2= new JLabel("Number 2");
	JTextField field2= new JTextField(10);
	JLabel label3=new JLabel("Sum");
	JTextField result =new JTextField(10);
	JButton go = new JButton("Add");
	//Add components to the pane
    windowContent.add(label1);
    windowContent.add(field1);
    windowContent.add(label2);
    windowContent.add(field2);
    windowContent.add(label3);
    windowContent.add(result);
    windowContent.add(go);
    // Create frame and set panel for it
    JFrame frame = new JFrame("MyFirstCalculator");
    frame.setContentPane(windowContent);
    // set the size and make file visible
    frame.setSize(400,100);
    frame.setVisible(true);
    frame.setResizable(false);
	  
	}
}
