package test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CalculateEightHours extends JFrame {
	public CalculateEightHours() {
		setLayout(new GridLayout(2, 2, 2, 2));
		((AbstractButton) add(new JButton("Press to Enter the Time you came in today")))
				.addActionListener(new timeInToday());
		((AbstractButton) add(new JButton("Press to Exit"))).addActionListener(new exit());

	}

	public static void main(String[] args) {
		CalculateEightHours frame = new CalculateEightHours();
		frame.setTitle("Calculate Eight Hours");
		frame.setSize(400, 100);

		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public class timeInToday implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String string1 = JOptionPane
					.showInputDialog("Please type in the time you came in today like this 8.40 instead of 8:40");
			double timeAm = Double.parseDouble(string1);

			String string2 = JOptionPane.showInputDialog(
					"Please type in the amount of time you took for lunch like .30 for 30 minutes - or .60 for 1 hour");
			double lunch = Double.parseDouble(string2);
			double total = timeAm + 8 + lunch;

			int ffinal = (int) (100 * total);
			Date date = new Date();
			try {
				date = new SimpleDateFormat("hhmm").parse(String.format("%04d", ffinal));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");

			JOptionPane.showMessageDialog(null, "The time you should leave is " + sdf.format(date));

		}

	}

	public class exit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

}
