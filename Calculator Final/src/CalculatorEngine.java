//����������� ����������� ����������
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

// ��������� ����� � ���������, ��� � ��� ����� ����������� ��� ������ ��������� ActionListener
public class CalculatorEngine implements ActionListener {

	Calculator parent; //������� ������ �� ����������� ����� (����) ������������.
	
	//��������� ���������� ��� �������� �����. �������� � ������ �� ������ ��������� ��������.
	char selectedAction=' '; 
	//��������� ���������� ��� �������� �������� ��������� ���������� � ����� double (�.4 ���������)
	//� ����� �� ��������� ������� ��������.
	double currentResult=0;
	
	//������� �����-����������� ��� �������� ������ �� ����� � ����������� ������ � ����������
	//���������� ������. ��� ���������� ��� �������� ���������� ����� ��������.
	CalculatorEngine(Calculator parent) {
		this.parent=parent;
	}
	
	//��������� ����� ���������� (���������) ActionListener ��� ����������� ������� �� ������
	public void actionPerformed(ActionEvent e) {
		
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
			displayValue= Double.parseDouble(dispFieldText); }
		
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
			parent.displayField.setText(""); } //�.3 
		
		else if (src==parent.buttonMinus) {
			selectedAction='-';
			currentResult=displayValue;
			parent.displayField.setText(""); }
		
		else if (src==parent.buttonDivide) {
			selectedAction='/';
			currentResult=displayValue;
			parent.displayField.setText(""); }
		
		else if (src==parent.buttonMultiply) {
			selectedAction='*';
			currentResult=displayValue;
			parent.displayField.setText(""); }
		
		//��������� ������ ��� ������� ������ "=" (buttonEqual). ����� ������� ���� ������
		//����������� �������������� ��������. ��� ����� ����������� ����� � ������� if.
		else if (src==parent.buttonEqual) {
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
			currentResult/=displayValue; //��������� �������
			parent.displayField.setText(""+currentResult); }
		
		else if(selectedAction=='*') {
			currentResult*=displayValue; //��������� ���������
			parent.displayField.setText(""+currentResult); } }
		
		//� ��������� �����, else, ������������ ������� ��� ���� �������� ������: ������������ 
		//������� �� ������ � ������� �� �������
		
		else {
			//��������� clickedButtonLabel ���� String � ����������� �� ��������,
			//������� ������ (clickedButton), ��������� ����� getText()
			String clickedButtonLabel=clickedButton.getText();
			
			//� ������� ������ setText() ������ ���� � ������� �� ������ �� ������� (displayField)
			//��������� � ���� � ������� ���������� parent, �.�. �� � �������� ������ � ��������. 
			//� �������� ������ setText() ���������� ������������ ����������, �������� ����� �� 
			//������� � ����� ������� ������������� �������� ������
			parent.displayField.setText(dispFieldText+clickedButtonLabel); }
		
 }
}
