import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {
	Calculator parent; // link to the Calculator window
	char selectedAction ='';     
	//+,-,/,*
	double currentResult =0;
	// constructor saves links to the calculator window in the  class instance variable
	CalculatorEngine (Calculator parent){
		this.parent = parent;
			}
	public void actionPerformed (ActionEvent e) {
		//get the source of action
					}
	JButton clickedButton = (JButton) e.getSource();
	String dispFieldText=parent.displayField.getText();
	double displayValue=0;
	//get a number from calculator's display it the field is not empty
	
	 if (!"".equals(dispFieldText)) {
		 displayValue = Double.parseDouble(dispFieldTesxt);
	 }
	 
	 Object src = e.getSource();
	 //for each button of action(+-/*)remember  the action and save current number in the variable currentResult, and clean the display
	 if (src ==parent.buttonPlus) {
		 
		 selectedAction ='+';
		 currentResult=displayValue;
		 parent.displayField.setText("");
		 
	 } else if (src == parent.bittonMinus) {  
		 
		 selectedAction = '-';
		 currentResult = displayValue;
		 parent.displayField.setText (""); 
		 
	 }else if)(src ==parent.buttonMinus) { 
		 
		 selectedAction = '/';
		 currentResult = displayValue;
		 parent.displayField.setText ("");
		 
	 }else if(src ==parent.button.Divide) {
		 
		 selectedAction ='*';
		 currentResult = displayValue;
		 parent.displayField.setText ("");
		 
	 }else if(src == parent.button.Multiply) {
		 
		 selectedAction = '*';
		 currentResult=displayValue;
		 parent.displayField.setText("");
		 
	 }else if (src ==parent.buttonEqual) { 
		 //execute action, depend on selectedAction, refresh variable currentResult and show result on the display
		 
		 if (selectedAction =='+') {
			 currentResult+=displayValue;
			 // convert result to the string,convert it, add it to the enpty field and show it
			 
			 parent.displayField.setText(""+currentResult);
			 
	 } else if (selectedAction=='-') {
			 
			 currentResult -=displayValue;
			 parent.displayField.set(""+currentResult);
			 
	 } else if (selectedAction == '/') {
			 
			 currentResult /=displayValue;
			 parent.displayField.setText (""+currentResult);
			 
	 } else if (selectedAction=='*') {
			 currentResult*=displayValue;
			 parent.displayField.setText)""+currentResult);
			  }
		 
	 }else {
		 
		 //for number button add title fpr the button to  title in the display
		 
		 String clickedButtonLabel = clickedButton.getText();
		 parent.displayField.setText (dispFieldText + clickedButtonLabel);
		 
		 
	 }
