import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PixelTablet implements ActionListener, Runnable {

	public static void main(String[] args) {
		new PixelTablet();
	}

	JFrame frame = new JFrame("PixelPaint v2.1");
	JButton clearButton = new JButton("RESET");
	JButton blackButton = new JButton();
	JButton whiteButton = new JButton("ERASER");
	JButton randomButton = new JButton("DEMO");
	JButton redButton = new JButton();
	JButton greenButton = new JButton();
	JButton yellowButton = new JButton();
	JButton blueButton = new JButton();
	JButton orangeButton = new JButton();
	JButton grayButton = new JButton();
	JButton delCelButton = new JButton("ENDING");
	static JButton cells[] = new JButton[3300];
	JPanel mainPanel = new JPanel(new BorderLayout());
	JPanel topPanel = new JPanel(new GridLayout(1, 9));
	JPanel cellPanel = new JPanel(new GridLayout(50, 55));
	JLabel label = new JLabel("COUNT: 0");
	Font topFont = new Font("Verdana", Font.BOLD, 11);
	private int pixels = 0; // ���������� �������� ���������� ������� ��� ��������
	Color paint = Color.WHITE; // ���������� ������ Color, �������� ��������� ���� � ���������
	Color getPaint = Color.WHITE; // ����������, �������� ���� ����������� ������
	Thread twoThread = new Thread(this);

	PixelTablet() {
		// ��������� ������ ��������� ����� � ������
		redButton.setBackground(Color.red);
		blackButton.setBackground(Color.BLACK);
		yellowButton.setBackground(Color.YELLOW);
		orangeButton.setBackground(Color.ORANGE);
		blueButton.setBackground(Color.BLUE);
		greenButton.setBackground(Color.GREEN);
		grayButton.setBackground(Color.GRAY);
		label.setFont(topFont); // ��������� ���� �������� �������
		label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		// ��������� ������ ��������� ����� � ������ �� ������
		topPanel.add(whiteButton);
		topPanel.add(randomButton);
		topPanel.add(blackButton);
		topPanel.add(redButton);
		topPanel.add(greenButton);
		topPanel.add(yellowButton);
		topPanel.add(blueButton);
		topPanel.add(orangeButton);
		topPanel.add(grayButton);
		topPanel.add(clearButton);
		topPanel.add(delCelButton);
		topPanel.add(label);
		// ������������ ��������� �� ������ ��������� � ������
		whiteButton.addActionListener(this);
		blackButton.addActionListener(this);
		redButton.addActionListener(this);
		greenButton.addActionListener(this);
		yellowButton.addActionListener(this);
		blueButton.addActionListener(this);
		orangeButton.addActionListener(this);
		grayButton.addActionListener(this);
		clearButton.addActionListener(this);
		delCelButton.addActionListener(this);
		randomButton.addActionListener(this);
		/*
		 * ������������ ��������� �� ������ �������� ����, ��������� �� �� ������,
		 * ������������� ����� ��� ��������� ���� � ������� ���������� ������ � ������
		 */
		for (int c = 0; c < cells.length; c++) {
			cells[c] = new JButton();
			cells[c].setBackground(Color.WHITE);
			cellPanel.add(cells[c]);
			cells[c].addActionListener(this);
		}
		// ��������� ������ � ������, ����������� �����
		mainPanel.add(topPanel, "North");
		mainPanel.add(cellPanel, "Center");
		frame.pack();
		frame.setSize(1024, 768);
		frame.setResizable(false);
		frame.add(mainPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Paints.pixelPaint();

	}

	// ��������� � ����� ��������� ������-��������
	private void touchCounter() {
		if (paint == Color.WHITE)
			return;
		pixels++;
		label.setText("COUNT: " + pixels);
	} // ����� ������-��������

	public void actionPerformed(ActionEvent e) {
		JButton pushButton = (JButton) e.getSource();

		if (pushButton == randomButton) {
			twoThread.start();
		}

		// ��������� ������ ��������� �����
		if (pushButton == redButton) {
			paint = Color.RED;
		} else if (pushButton == blackButton) {
			paint = Color.BLACK;
		} else if (pushButton == whiteButton) {
			paint = Color.WHITE;
		} else if (pushButton == greenButton) {
			paint = Color.GREEN;
		} else if (pushButton == yellowButton) {
			paint = Color.YELLOW;
		} else if (pushButton == blueButton) {
			paint = Color.BLUE;
		} else if (pushButton == orangeButton) {
			paint = Color.ORANGE;
		} else if (pushButton == grayButton) {
			paint = Color.GRAY;
		} else if (pushButton == clearButton) {
			paint = Color.WHITE;
			getPaint = paint;
			label.setText("COUNT: 0");
			pixels = 0;
			for (int c = 0; c < cells.length; c++) {
				/*
				 * ����� �� ���������� ��� � �������� ���������: ����������� ������ �����, �����
				 * ������ ������� � ������ ������ ���������
				 */
				cells[c].setBackground(paint);
				cells[c].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				cells[c].setEnabled(true);
			}

			// ��������� ������� ������ ���������� ������� ��� ������ ������
		} else if (pushButton == delCelButton) {

			if (twoThread != null) {
				twoThread.interrupt();
			}

			for (int c = 0; c < cells.length; c++) {
				getPaint = cells[c].getBackground(); // �������� ���� ������
				cells[c].setEnabled(false); // ��������� ������
				// ���� ������ �����, �� ������� �� �������
				if (getPaint == Color.WHITE) {
					cells[c].setBorder(null);
				}
			}
		} // ����� ���������� ������ ����������

		// ��������� ������ � ������ ��������� �������
		for (int c = 0; c < cells.length; c++) {
			if (pushButton == cells[c]) {
				cells[c].setBackground(paint);
				touchCounter(); // �������� �����-�������
			} // ����� �������
		} // ����� �����
	} // ����� ������ ActionPerformed()

	@Override
	public void run() {
		randomButton.setEnabled(false);
		while (!twoThread.isInterrupted()) {
			int randomCell = (int) (Math.random() * cells.length);
			cells[randomCell].setBackground(colorRandomator((int) (Math.random() * 6)));
		}

	}

	public Color colorRandomator(int numColor) {
		if (numColor == 0) {
			return Color.WHITE;
		} else if (numColor == 1) {
			return Color.RED;
		} else if (numColor == 2) {
			return Color.BLUE;
		} else if (numColor == 3) {
			return Color.GRAY;
		} else if (numColor == 4) {
			return Color.GREEN;
		} else if (numColor == 5) {
			return Color.ORANGE;
		} else if (numColor == 6) {
			return Color.YELLOW;
		} else
			return Color.BLACK;
	}

} // ����� ������