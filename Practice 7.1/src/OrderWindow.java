/*
 ��������� ������� ��� "������� � �����":
 1. �������� ���������� �� �����������
�������, ������� ��������� ���� ������
���������� ���������� ���� �
����������� ��������, ����� ������������
��� ������� �� ������, ������ ����, �����
������� � ����������.
2. ���������� � ��������� ��� Swing
���������� JComboBox � ItemListener
��� ��������� �������, ����� ������������
�������� ������ ����������.
 */

import javax.swing.*; import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*
 ������������� ���������� ���� ����� ����� ��������� ItemListener,
 ������� ��������� ��� � �����, ���� ��� ������� ����� ��� �������
 � ����� ActionListener. ��������� ItemListener ����� ��� �����
 itemStateChanged().
 */
public class OrderWindow implements ActionListener, ItemListener {
	
	JFrame frame=new JFrame("���� ������");
	JPanel panel=new JPanel(new FlowLayout()); 
	JTextField txtFieldModel=new JTextField("", 20);
	JTextField txtFieldQuantity=new JTextField("0", 2);
	JButton orderButton=new JButton("��������");
	JLabel label=new JLabel("����������:");
	JLabel label2=new JLabel("������ FireBird (<4) ��� Ukraina (<11)");
	JLabel txtFieldOrderConfirmation=new JLabel("��� ����� ��� �� ������");
	/*
	 ������� ���������� selectedModel ��������� �������� � ���� "FireBird" 
	 ������ �������, ��� ��� ��� ������ ����� �������� 
	 ����������� ����, � �� ����� ������������ ��� �������
	 ���������; ������� ���� ������������ ������ ������ ���������� �����������, �� ������
	 ����, ��� �������� � ������, ��� ��� ���������� selectedModel ����� ����� ����������
	 ����, ��� ����� itemStateChanged() �� ��������� � �� �������� �� ��������.
	 */
	String selectedModel="FireBird"; String selectedQuantity="0"; int quantity=0;
	//������� ���������� ��� ����������� ���� � ������� �������
	String items[] = {"FireBird","Ukraina"};
	//� ������� ��������� ����������� ����
	JComboBox comboBox=new JComboBox(items);
	
	OrderWindow() {
		
		panel.add(label2);
		panel.add(comboBox); //��������� ���������� ���� �� ������
		panel.add(label);
		panel.add(txtFieldQuantity);
		panel.add(orderButton); panel.add(txtFieldOrderConfirmation);
		frame.add(panel); frame.pack(); frame.setVisible(true);
		frame.setSize(300,145); frame.setResizable(false);
		orderButton.addActionListener(this);
		comboBox.addItemListener(this);
	}
		public static void main(String[] args) {
			new OrderWindow();
		}
		
		@Override
		/*
		 ��������� ����� ���������� ItemListener. ��� ������ ��������
		 ����������� ���� ����� ����� �������� �������� ����������
		 selectedModel � ������� ������ getSelectedItem � �����������
		 �� String.
		 */
		public void itemStateChanged(ItemEvent e) {
				selectedModel=(String) comboBox.getSelectedItem();
			
		} //����� ������ itemStateChanged()

	public void actionPerformed(ActionEvent e) {
		
		selectedQuantity=txtFieldQuantity.getText();
		try {
			quantity=Integer.parseInt(selectedQuantity);
		} catch (NumberFormatException e1) {
			quantity=0; txtFieldQuantity.setText("");
			txtFieldOrderConfirmation.setText(e1.getMessage());
		}
		
		try {
			checkOrder(selectedModel, quantity);
			txtFieldOrderConfirmation.setText("����� �������� �������! "+selectedModel+": "+quantity+" ��.");
		} catch (TooManyBikesException e1) {
			txtFieldOrderConfirmation.setText(e1.getMessage());
		}
	}
	
    void checkOrder (String bikeModel, int quantity) throws TooManyBikesException {
    	
    	if (((bikeModel.equals("FireBird")) & (quantity<4) & (quantity>0)) | ((bikeModel.equals("Ukraina")) & (quantity<11) & (quantity>0))) {
    		System.out.println("Log: "+bikeModel+" ("+quantity+") - approved");
    		} else {
    			System.out.println("Log: "+bikeModel+" ("+quantity+") - declined");
    			throw new TooManyBikesException();
    		}
    }
}

class TooManyBikesException extends Exception {
	
	TooManyBikesException() {
		super("����� ���������� ����������");
	}
}