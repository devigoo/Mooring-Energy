import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class MooringEnergy {

	private JFrame frmEnergiaCumowaniaWg;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblEnergiaCumowaniaStatku;

	
	//Method which counts energy from user input and checks if all the fields are correctly filled in
	public void countEnergy() {
		if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty()
				|| textField_3.getText().isEmpty() || textField_4.getText().isEmpty() || textField_5.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Uzupe³nij wszystkie pola ");
		}

		
		try {
	//Get input from the user
		double mw = Double.parseDouble(textField.getText());
		double k = Double.parseDouble(textField_1.getText());
		double w0 = Double.parseDouble(textField_2.getText());
		double v = Double.parseDouble(textField_3.getText());
		double a = Double.parseDouble(textField_4.getText());
		double r = Double.parseDouble(textField_5.getText());
		
		double firstPart = (mw * v * v) / 2;
		double secondPart = 1 - ((a * a) / ((k * k) + (r * r)));
		double thirdPart = mw * v * w0;
		double fourthPart = ((k * k) / ((k * k) + (r * r)));
		double fifthPart = (mw * w0 * w0) / 2;
		double lastPart = ((k * k) * (r * r)) / ((k * k) + (r * r));
		double energia = ((firstPart * secondPart) - (thirdPart * fourthPart)) + (fifthPart * lastPart);
		String en = String.valueOf(energia);

		textField_6.setText(en);
		}
		catch(NumberFormatException e){
			
			JOptionPane.showMessageDialog(null, "Podana wartoœæ musi sk³adaæ siê z cyfr");
		}
	
	}

	//Launching the application
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MooringEnergy window = new MooringEnergy();
					window.frmEnergiaCumowaniaWg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the app
	public MooringEnergy() {
		initialize();
	}

	//Initialize contents of the frame
	private void initialize() {
		frmEnergiaCumowaniaWg = new JFrame();
		frmEnergiaCumowaniaWg.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmEnergiaCumowaniaWg.setFont(new Font("Aharoni", Font.PLAIN, 12));
		frmEnergiaCumowaniaWg.setForeground(Color.ORANGE);
		frmEnergiaCumowaniaWg.getContentPane().setForeground(Color.WHITE);
		frmEnergiaCumowaniaWg.setTitle("Energia cumowania wg V.Costy");
		frmEnergiaCumowaniaWg.setBounds(100, 100, 735, 496);
		frmEnergiaCumowaniaWg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnergiaCumowaniaWg.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(43, 51, 216, 32);
		frmEnergiaCumowaniaWg.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("");
		label.setBounds(127, 38, 46, 14);
		frmEnergiaCumowaniaWg.getContentPane().add(label);

		JLabel lblPodajMasWirtualn = new JLabel("Podaj mas\u0119 wirtualn\u0105 [t]");
		lblPodajMasWirtualn.setBounds(88, 38, 165, 14);
		frmEnergiaCumowaniaWg.getContentPane().add(lblPodajMasWirtualn);

		textField_1 = new JTextField();
		textField_1.setBounds(43, 106, 216, 32);
		frmEnergiaCumowaniaWg.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(43, 169, 216, 32);
		frmEnergiaCumowaniaWg.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(43, 238, 216, 32);
		frmEnergiaCumowaniaWg.getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(43, 302, 216, 32);
		frmEnergiaCumowaniaWg.getContentPane().add(textField_4);

		JLabel lblPromieBezwadnocim = new JLabel("Promie\u0144 bezw\u0142adno\u015Bci [m]");
		lblPromieBezwadnocim.setBounds(88, 91, 171, 14);
		frmEnergiaCumowaniaWg.getContentPane().add(lblPromieBezwadnocim);

		JLabel lblPrdkoObrotowrads = new JLabel("Pr\u0119dko\u015B\u0107 obrotow\u0105 [rad/s]");
		lblPrdkoObrotowrads.setBounds(88, 155, 165, 14);
		frmEnergiaCumowaniaWg.getContentPane().add(lblPrdkoObrotowrads);

		JLabel lblNewLabel = new JLabel("Pr\u0119dko\u015B\u0107 liniow\u0105 [m/s]");
		lblNewLabel.setBounds(94, 224, 165, 14);
		frmEnergiaCumowaniaWg.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("D\u0142ugo\u015B\u0107 rzutu r na lini\u0119 cumowania a [m]");
		lblNewLabel_1.setBounds(43, 290, 251, 14);
		frmEnergiaCumowaniaWg.getContentPane().add(lblNewLabel_1);

		textField_5 = new JTextField();
		textField_5.setBounds(43, 369, 216, 32);
		frmEnergiaCumowaniaWg.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		JLabel lblPromieObrotuR = new JLabel("Promie\u0144 obrotu r [m]");
		lblPromieObrotuR.setBounds(88, 356, 171, 14);
		frmEnergiaCumowaniaWg.getContentPane().add(lblPromieObrotuR);

		JButton btnOblicz = new JButton("Oblicz");
		btnOblicz.setBounds(324, 41, 304, 42);
		frmEnergiaCumowaniaWg.getContentPane().add(btnOblicz);
		btnOblicz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == btnOblicz) {
					countEnergy();

				}
			}
		});

		textField_6 = new JTextField();
		textField_6.setBounds(324, 169, 302, 37);
		frmEnergiaCumowaniaWg.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		lblEnergiaCumowaniaStatku = new JLabel("Energia cumowania statku [kJ]");
		lblEnergiaCumowaniaStatku.setBounds(394, 133, 216, 32);
		frmEnergiaCumowaniaWg.getContentPane().add(lblEnergiaCumowaniaStatku);

	}
}
