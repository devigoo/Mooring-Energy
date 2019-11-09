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

	private JFrame frmEnergy;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblEnergy;

	
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
		double energy = ((firstPart * secondPart) - (thirdPart * fourthPart)) + (fifthPart * lastPart);
		String en = String.valueOf(energy);

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
					window.frmEnergy.setVisible(true);
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
		frmEnergy = new JFrame();
		frmEnergy.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmEnergy.setFont(new Font("Aharoni", Font.PLAIN, 12));
		frmEnergy.setForeground(Color.ORANGE);
		frmEnergy.getContentPane().setForeground(Color.WHITE);
		frmEnergy.setTitle("Energia cumowania wg V.Costy");
		frmEnergy.setBounds(100, 100, 735, 496);
		frmEnergy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnergy.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(43, 51, 216, 32);
		frmEnergy.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("");
		label.setBounds(127, 38, 46, 14);
		frmEnergy.getContentPane().add(label);

		JLabel virtualMass = new JLabel("Podaj mas\u0119 wirtualn\u0105 [t]");
		virtualMass .setBounds(88, 38, 165, 14);
		frmEnergy.getContentPane().add(virtualMass);

		textField_1 = new JTextField();
		textField_1.setBounds(43, 106, 216, 32);
		frmEnergy.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(43, 169, 216, 32);
		frmEnergy.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(43, 238, 216, 32);
		frmEnergy.getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(43, 302, 216, 32);
		frmEnergy.getContentPane().add(textField_4);

		JLabel lblInertRad = new JLabel("Promie\u0144 bezw\u0142adno\u015Bci [m]");
		lblInertRad.setBounds(88, 91, 171, 14);
		frmEnergy.getContentPane().add(lblInertRad);

		JLabel lblRotSpeed = new JLabel("Pr\u0119dko\u015B\u0107 obrotow\u0105 [rad/s]");
		lblRotSpeed.setBounds(88, 155, 165, 14);
		frmEnergy.getContentPane().add(lblRotSpeed);

		JLabel lblLinSpeed = new JLabel("Pr\u0119dko\u015B\u0107 liniow\u0105 [m/s]");
		lblLinSpeed.setBounds(94, 224, 165, 14);
		frmEnergy.getContentPane().add(lblLinSpeed);

		JLabel lblProjection = new JLabel("D\u0142ugo\u015B\u0107 rzutu r na lini\u0119 cumowania a [m]");
		lblProjection.setBounds(43, 290, 251, 14);
		frmEnergy.getContentPane().add(lblProjection);

		textField_5 = new JTextField();
		textField_5.setBounds(43, 369, 216, 32);
		frmEnergy.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		JLabel lblRotRadius = new JLabel("Promie\u0144 obrotu r [m]");
		lblRotRadius.setBounds(88, 356, 171, 14);
		frmEnergy.getContentPane().add(lblRotRadius);

		JButton btnOblicz = new JButton("Oblicz");
		btnOblicz.setBounds(324, 41, 304, 42);
		frmEnergy.getContentPane().add(btnOblicz);
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
		frmEnergy.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		lblEnergy = new JLabel("Energia cumowania statku [kJ]");
		lblEnergy.setBounds(394, 133, 216, 32);
		frmEnergy.getContentPane().add(lblEnergy);

	}
}
