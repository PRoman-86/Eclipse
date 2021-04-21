
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Calculator {
	JButton button0=new JButton("0");
	JButton button1=new JButton("1");
	JButton button2=new JButton("2");
	JButton button3=new JButton("3"); 
	JButton button4=new JButton("4");
	JButton button5=new JButton("5");
	JButton button6=new JButton("6");
	JButton button7=new JButton("7");
	JButton button8=new JButton("8");
	JButton button9=new JButton("9");
	JButton buttonPoint=new JButton(".");	
	JButton buttonEqual=new JButton("=");
	JButton buttonPlus= new JButton("+");
	JButton buttonMinus= new JButton ("-");
	JButton buttonDivide = new JButton ("/");
	JButton buttonMultiply = new JButton ("*");
	
	JPanel windowContent = new JPanel ();
	JTextField displayField = new JTextField (30);
	//constructor
	Calculator (){
		
		//set  manager of placing for pane
		BorderLayout b1 = new BorderLayout();
		windowContent.setLayout(b1);
	//add display in the top of window
		windowContent.add("North", displayField);
		
	// create the panel with manager of placing GridLayout (4;3);
		
		JPanel p1 = new JPanel ();
		GridLayout g1 =new GridLayout(4,3);		
		p1.setLayout(g1);
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
		

		// placing the panel p1 to the center place of window
		windowContent.add("Center",p1);
		
		//Create p2
		
		JPanel p2 = new JPanel();
		GridLayout g12=new GridLayout(4,1);
		
		p2.setLayout (g12);
		p2.add(buttonPlus);
		p2.add(buttonMinus);
		p2.add(buttonMinus);
		p2.add(buttonMultiply);
		p2.add(buttonDivide);
		
		//add panel p2 in the left part of window
		
		windowContent.add("East",p2);
		//create the frame
		
		JFrame frame = new JFrame ("Calculator");
		frame.setContentPane(windowContent);
		
		// make windows size sufficient to accommodate all components
		frame.pack();
		//display the window
		frame.setVisible (true);
		//create listener of event and register it on each button
		CalculatorEngine calcEngine = new CalculatorEngine (this);
		
		button0.addActionListener(calcEngine); 
		button1.addActionListener(calcEngine); 
		button2.addActionListener(calcEngine); 
		button3.addActionListener(calcEngine); 
		button4.addActionListener(calcEngine); 
		button5.addActionListener(calcEngine); 
		button6.addActionListener(calcEngine); 
		button7.addActionListener(calcEngine); 
		button8.addActionListener(calcEngine); 
		button9.addActionListener(calcEngine);
		
		buttonPoint.addActionListener(calcEngine); 
		buttonPlus.addActionListener(calcEngine);
		buttonMinus.addActionListener(calcEngine); 
		buttonDivide.addActionListener(calcEngine); 
		buttonMultiply.addActionListener(calcEngine); 
		buttonEqual.addActionListener(calcEngine); 
		
		}
	public static void main (String[] args) {
		Calculator calc = new Calculator();
	}
		
}
	
	
	
	
	


