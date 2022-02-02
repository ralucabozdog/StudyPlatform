import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class AdaugareNota extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdaugareNota frame = new AdaugareNota();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdaugareNota() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 591);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdugareNot = new JLabel("Ad\u0103ugare not\u0103");
		lblAdugareNot.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdugareNot.setForeground(new Color(0, 139, 139));
		lblAdugareNot.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblAdugareNot.setBounds(112, 11, 218, 52);
		contentPane.add(lblAdugareNot);
		
		JLabel lblNewLabel_1 = new JLabel("nume student:");
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1.setBounds(35, 114, 116, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("materie:");
		lblNewLabel_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(35, 187, 73, 26);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(128, 0, 128));
		textField.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField.setColumns(10);
		textField.setBounds(192, 114, 193, 26);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("\u00CEnregistrare");
		btnNewButton.setForeground(new Color(230, 230, 250));
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setBounds(152, 461, 126, 52);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("prenume student:");
		lblNewLabel_1_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(35, 150, 142, 26);
		contentPane.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(128, 0, 128));
		textField_2.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(192, 150, 193, 26);
		contentPane.add(textField_2);
		
		String[] materii = {"materie 1", "materie 2", "materie 3"};				//se vor alege doar materiile la care profesorul ii preda respectivului elev
		JComboBox comboBox = new JComboBox(materii);
		comboBox.setForeground(new Color(128, 0, 128));
		comboBox.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		comboBox.setBounds(192, 187, 193, 26);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("activitate:");
		lblNewLabel_1_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(35, 220, 92, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		String[] activitati = {"curs", "laborator", "seminar"};
		JComboBox comboBox_1 = new JComboBox(activitati);
		comboBox_1.setForeground(new Color(128, 0, 128));
		comboBox_1.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		comboBox_1.setBounds(192, 224, 193, 26);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img = new ImageIcon(new ImageIcon("src\\AdaugareNota.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(img);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 320, 434, 113);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_3 = new JLabel("nota:");
		lblNewLabel_1_3.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_3.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(35, 257, 116, 26);
		contentPane.add(lblNewLabel_1_3);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(128, 0, 128));
		textField_1.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(192, 257, 193, 26);
		contentPane.add(textField_1);
	}
}
