import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
public class CalculatorEngine implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		JOptionPane.showConfirmDialog(null,"Нахой нажал?!","Просто тест",JOptionPane.PLAIN_MESSAGE);
	}
}
