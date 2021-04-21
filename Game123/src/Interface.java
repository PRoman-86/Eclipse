import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface {
	JFrame frame = new JFrame("Game");
	JPanel panel = new JPanel();
	JButton button = new JButton("“Ë!");

	Interface() {
		panel.add(new JLabel(" ¿Ã≈Õ‹, ÕŒ∆Õ»÷€, ¡”Ã¿√¿: –¿«, ƒ¬¿..."));
		panel.add(button);
		frame.add(panel);
		frame.setSize(300, 100);
		frame.setVisible(true);
		frame.setResizable(false);
		button.addActionListener(new Engine());
	}

	public static void main(String[] args) {
		new Interface();
	}

	class Engine implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int random = (int) (Math.random() * 3);
			if (random == 0) {
				JOptionPane.showMessageDialog(null,
						"<html><font size=\"8\" " + "color=\"black\" face=\"Arial\"> ¿Ã≈Õ‹</font>");
			} else if (random == 1) {
				JOptionPane.showMessageDialog(null,
						"<html><font size=\"8\" " + "color=\"blue\" face=\"Arial\">ÕŒ∆Õ»÷€</font>");
			} else {
				JOptionPane.showMessageDialog(null,
						"<html><font size=\"8\" " + "color=\"red\" face=\"Arial\">¡”Ã¿√¿</font>");
			}
		}
	}
}
