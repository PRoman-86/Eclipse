//����������� ����������� ����������
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

// ��������� ����� � ���������, ��� � ��� ����� ����������� ��� ������ ��������� ActionListener
public class CalculatorEngine implements ActionListener {

	Calculator parent; //������� ������ �� ����������� ����� (����) ������������.
	
	//��������� ���������� ��� �������� �����. �������� � ������ �� ������ ��������� ��������.
	char selectedAction=' '; 
	//��������� ���������� ��� �������� �������� ��������� ���������� � ����� double (�.4 ���������)
	//� ����� �� ��������� ������� ��������.
	double currentResult=0;
	int counter=0;
	//������� �����-����������� ��� �������� ������ �� ����� � ����������� ������ � ����������
	//���������� ������. ��� ���������� ��� �������� ���������� ����� ��������.
	CalculatorEngine(Calculator parent) {
		this.parent=parent;
	}
	
	//��������� ����� ���������� (���������) ActionListener ��� ����������� ������� �� ������
	public void actionPerformed(ActionEvent e) {
		//parent.buttonPoint.setEnabled(true);
	//�������� �������� �������� - ����� ������ ������ ���� ������ � ����������� ��� ��������
	//���������� clickedButton; �������� ��� ������ � ���� JButton
		JButton clickedButton = (JButton) e.getSource();
	//�������� ������� ����� �� ������� ������������ � ���������� dispFieldText � ������� �����
	//����������� ���������� parent ������ Calculator
		String dispFieldText = parent.displayField.getText();	

	//��������� ���������� ��� �������� ������������� �������� � ����� double (�.4 ���������)
	//� ������ �� ��������� ������� ��������
		double displayValue=0;
		
	//�������� ����� �� ������� ������������, ���� �� �� ������ (��������� �������� if ��� ��������)
		//� ����������� ��� ���������� displayValue
		if (!"".equals(dispFieldText)) {
			/*
			 ��������� ������������� ������� �� ����� 8.
			 ������������ ���������� � ���� ����� ������������ ��������. ���, ������, ����� ������
			 �������� � ������ ���������� ����� � ��������.
			 */
			try {
				displayValue= Double.parseDouble(dispFieldText);
			} catch (NumberFormatException e1) {
				parent.displayField.setText(""); parent.displayFieldErr.setText(""); 
				parent.displayFieldErr.setText("������ �����: "+e1.getMessage());
				return;
			} 
			 }
		
	//����������, ����� ������ ��������������� �������� ���� ������ � ������� ������ getSource(), 
	//������������� � ������ ActionEvent, ���������� ���� � ���������� src ���� (������) Object
		Object src = e.getSource();
		
	/* � ������� ��������� if ��� ������ ������� ������ ��������������� �������� ����� ��� ��� 
	 * ���������� ��������� ��������. 
	 * � ������� ��������� if ���������� src (������� ��� �������� ���������� � ���, ����� ������ 
	 * ���� ������) ������������ � ���������� ���������� ������ � ������ �� ���������� ���������
	 * ����������� ��� ��� ���� ��� � ���� ��������� if, � ������:
	 * 1. ���������� ��������� �������������� �������� � ����� char-���������� selectedAction.
	 * 2. ���������� ������� ����� �� ������� ������������ � ����� double-���������� currentResult 
	      (����� ��� �������� ��������� � ���������� displayValue, ����������� �� ������� ������������)
	   3. ������� ������� ��� ����� ������ ����� (������� �������� ��������������� ��������)
	   
	   ���������� ����� ��� ��� ������� ��������� ������ ��������������� �������� ����� 
	   ������ "=" (buttonEqual), � ������ + - / *. ��� ������ "=" � �������� ������ ��� ����� ����������.
	 */
	
		if (src==parent.buttonPlus) {
			selectedAction='+'; //�.1
			currentResult=displayValue; //�.2
			parent.displayFieldErr.setText(""); parent.displayFieldErr.setText("��������...");
			parent.displayField.setText(""); } //�.3 
		
		else if (src==parent.buttonMinus) {
			selectedAction='-';
			currentResult=displayValue;
			parent.displayFieldErr.setText(""); parent.displayFieldErr.setText("���������...");
			parent.displayField.setText(""); }
		
		else if (src==parent.buttonDivide) {
			selectedAction='/';
			currentResult=displayValue;
			parent.displayFieldErr.setText(""); parent.displayFieldErr.setText("�������...");
			parent.displayField.setText(""); }
		
		else if (src==parent.buttonMultiply) {
			selectedAction='*';
			currentResult=displayValue;
			parent.displayFieldErr.setText(""); parent.displayFieldErr.setText("���������...");
			parent.displayField.setText(""); }
		
		//��������� ������ ������ (�� ����������� ����������), �������� ���������� � ������� ������� �����.
		else if (src==parent.buttonErase) {
			selectedAction=' ';
			currentResult=0;
			displayValue=0;
			parent.displayField.setText("");
			parent.displayFieldErr.setText("");
			parent.buttonPoint.setEnabled(true);
		//�����--------------------------------------------------	
		}
		
		//��������� ������ ��� ������� ������ "=" (buttonEqual). ����� ������� ���� ������
		//����������� �������������� ��������. ��� ����� ����������� ����� � ������� if.
		else if (src==parent.buttonEqual) {
			parent.displayFieldErr.setText(""); parent.displayFieldErr.setText("���������");
			// ��������� �������������� ��������, � �����������
			// �� ���������� selectedAction, �������� ���������� currentResult
			// � �������� ��������� �� �������. ��������� ��� ��� ������� �����. �������� (selected Action)
		if (selectedAction=='+') {
			currentResult+=displayValue; //��������� ��������
			
			//������������ ��������� � ������, �������� ��� � ������ ������ �� ������� � ���������� ���
			parent.displayField.setText(""+currentResult); }
		
		else if (selectedAction=='-') {
			currentResult-=displayValue; //��������� ���������
			parent.displayField.setText(""+currentResult); }
		
		else if (selectedAction=='/') {
			//��������� ������������ ������� �� ��� 115. ��������� ������ �� ����.
			if (displayValue==0) {
				parent.displayFieldErr.setText("������: �� ���� ������ ������.");
				parent.displayField.setText("");
				
			} else {
			//������������ ������� ���������-------------------------------------
			currentResult/=displayValue; //��������� �������
			parent.displayField.setText(""+currentResult); } }
		    
		else if(selectedAction=='*') {
			currentResult*=displayValue; //��������� ���������
			parent.displayField.setText(""+currentResult); } }
		
		//� ��������� �����, else, ������������ ������� ��� ���� �������� ������: ������������ 
		//������� �� ������ � ������� �� �������
		
		else {
			//��������� clickedButtonLabel ���� String � ����������� �� ��������,
			//������� ������ (clickedButton), ��������� ����� getText()
			String clickedButtonLabel=clickedButton.getText();
			
			/*
			
			/*����������� ������������ ������� �� ���. 115 "��� ������� � �����" - ���������
			//���� ����� ����� �����. ������� (if) ����������� ���:
		    // https://www.cyberforum.ru/java-j2se/thread946454.html
			// �� �� ���� ������� ����� �� �������� � ������� indexOf().
			
			������, ������� ��������� ���������� �������� ������������� ����� �������� �����.
			������� �������� ���� � ������������ �������� ����� � �����������.
			
			int pointIndex=dispFieldText.indexOf('.');
			if (pointIndex>=2 & clickedButton == parent.buttonPoint) {
				selectedAction=' ';
				currentResult=0;
				displayValue=0;
				parent.displayField.setText("");
				parent.displayFieldErr.setText("");
				parent.displayFieldErr.setText("������: ��� ����� � ��������");
				parent.buttonPoint.setEnabled(false); //��������� ������
			} else { //���� ���������.
			
			*/
			
			//� ������� ������ setText() ������ ���� � ������� �� ������ �� ������� (displayField)
			//��������� � ���� � ������� ���������� parent, �.�. �� � �������� ������ � ��������. 
			//� �������� ������ setText() ���������� ������������ ����������, �������� ����� �� 
			//������� � ����� ������� ������������� �������� ������
			parent.displayField.setText(dispFieldText+clickedButtonLabel); }
  }	
 }