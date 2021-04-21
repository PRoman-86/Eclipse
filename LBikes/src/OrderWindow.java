
import javax.swing.*; import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;



public class OrderWindow implements ActionListener,ItemListener {
	
	public static void main (String[]args) {
		new OrderWindow ();
	}
	JFrame mainframe = new JFrame ("BIKES ORDER");
	JButton orderbutton =new JButton ("ORDER");
	//JTextField txtFieldModel = new JTextField (18);
	JTextField txtFieldQuantity = new JTextField (12);
	JLabel bikeModel = new JLabel("Model       ");
	JLabel bikeNumber = new JLabel ("Number: ");
	JLabel txtFieldOrderConfirmation = new JLabel("   Welcome to BIKES ORDER");
	JPanel mainPanel = new JPanel();
	String selectedModel = "FireBird"; String selectedQuantity; int quantity;
	String [] value = {
			"FireBird",
			"Ukraine"
			};
	JComboBox txtFieldModel = new JComboBox(value);
		
		OrderWindow(){
			
			mainPanel.add(bikeModel); mainPanel.add(txtFieldModel);
			mainPanel.add(bikeNumber); mainPanel.add(txtFieldQuantity);
			mainPanel.add(orderbutton);
			mainPanel.add(txtFieldOrderConfirmation);
			orderbutton.addActionListener(this);
			txtFieldModel.addItemListener(this);
			
	mainframe.add(mainPanel);
	mainframe.setSize(250,200);
	mainframe.setVisible(true);
	mainframe.setResizable(false);
			}
		
		public void actionPerformed (ActionEvent e) {
		
		//String selectedModel = txtFieldModel.getText();
		String selectedQuantity = txtFieldQuantity.getText();
		int quantity;
		
			quantity = Integer.parseInt(selectedQuantity);
		
			try { 
				checkOrder (selectedModel, quantity);
				txtFieldOrderConfirmation.setText("You   ordered "+quantity+ selectedModel +"  bikes");	
			}catch (TooManyBikesException e1) {
				txtFieldOrderConfirmation.setText (e1.getMessage());
			}
			/*try { 
				checkOrder (selectedModel, quantity);
				txtFieldOrderConfirmation.setText("You   ordered "+quantity+ selectedModel +"  bikes");	
			}catch (TooManyBikesException e2) {
				txtFieldOrderConfirmation.setText (e2.getMessage());
			}*/
		}
		void checkOrder (String bikeModel, int quantity)
		                 throws TooManyBikesException{
			if (bikeModel.equals("FireBird")& quantity<4 & quantity>0| bikeModel.equals("Ukraine")& quantity<20 & quantity>0)
					{
				System.out.println ("You  ordered "+quantity+" bikes");
				}
			else {				
					throw new TooManyBikesException();
}
		}

		@Override
		public void itemStateChanged(ItemEvent e3) {
			 selectedModel = (String)txtFieldModel.getSelectedItem();
			
		}
}
		
class TooManyBikesException extends Exception {
	
	TooManyBikesException (){
		super ("Hey everyone! CyberPnk was declined");
		
	}
}

	

	
	


