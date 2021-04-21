
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Calculator {
	JPanel windowContent;
	JFormattedTextField displayField;
	JButton button0;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;
	JButton buttonPoint;
	
	JButton buttonEqual;
	JButton buttonAdd;
	JButton buttonSubstract;
	JButton buttonDivide;
	JButton buttonMultiply;
	JPanel p1;
	JPanel p2;
	// creation all elements in constructor
	// and add new elements to frame using combination Borderlayout and Cridlayout
	
	Calculator (){
		windowContent= new JPanel();
		//set the scheme for this panel
		BorderLayout b1 = new BorderLayout();
		windowContent.setLayout(b1);
		displayField = new JFormattedTextField();
		displayField.setHorizontalAlignment(JFormattedTextField.RIGHT);
		windowContent.add("North", displayField);
		
		// Create buttons using constructor of class JButton
		// which accepts text
	   //button as parameter
		
		button0=new JButton ("0");
		button1=new JButton ("1");
		button2=new JButton ("2");
		button3=new JButton ("3");
		button4=new JButton ("4");
		button5=new JButton ("5");
		button6=new JButton ("6");
		button7=new JButton ("7");
		button8=new JButton ("8");
		button9=new JButton ("9");
		buttonPoint = new JButton (".");
		buttonEqual = new JButton("=");
		buttonAdd = new JButton("+");
		buttonSubstract = new JButton("-");
		buttonMultiply = new JButton ("*");
		
		
// Create panel with GridLayout
		// that consist 12 buttons - 10 buttons with numbers
		// and button with point and equal
		
		p1 = new JPanel ();
		GridLayout g1 = new GridLayout (4,3);
		p1.setLayout(g1);
		
		p2 = new JPanel ();
		GridLayout g2 = new GridLayout (4,3);
		p2.setLayout(g2);
		
	// Add button to the panel p1
		p1.add(button1);
		p1.add(button2);
		p1.add(button3);
		p1.add(button4);
		p1.add(button5);
		p1.add(button6);
		p1.add(button7);
		p1.add(button8);
		p1.add(button9);
		p1.add(button0);
			
		p1.add(buttonPoint);
		p1.add(buttonEqual);
		
		p2.add(buttonEqual);
		p2.add(buttonAdd);
		p2.add(buttonSubstract);
		p2.add(buttonMultiply);
				
		// placing the panel p1 to the center place of window
		windowContent.add("Center",p1);
		windowContent.add("West", p2);
		
		//Create the frame and set main panel
		JFrame frame = new JFrame ("Calculator");
		frame.setContentPane(windowContent);
		
		// make windows size sufficient to accommodate all components
		frame.pack();
		//display the window
		frame.setVisible (true);
		
	}
	public static void main (String[] args) {
		new Calculator();
	}
		
		
	}
	
	
	
	


