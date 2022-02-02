import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class CreareCont extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreareCont frame = new CreareCont();
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
	public CreareCont() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreareCont = new JLabel("Modificare parolã");
		lblCreareCont.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreareCont.setForeground(new Color(0, 139, 139));
		lblCreareCont.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblCreareCont.setBounds(10, 11, 416, 52);
		contentPane.add(lblCreareCont);
		
		JLabel lblNewLabel_1 = new JLabel("e-mail:");
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1.setBounds(23, 95, 119, 26);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(128, 0, 128));
		textField.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField.setColumns(10);
		textField.setBounds(207, 95, 193, 26);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("noua parol\u0103:");
		lblNewLabel_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(23, 168, 119, 26);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(128, 0, 128));
		passwordField.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		passwordField.setColumns(10);
		passwordField.setBounds(207, 168, 193, 26);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setForeground(new Color(128, 0, 128));
		passwordField_1.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		passwordField_1.setColumns(10);
		passwordField_1.setBounds(207, 205, 193, 26);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("confirm\u0103 noua parol\u0103:");
		lblNewLabel_1_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(23, 205, 180, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnCreare = new JButton("Modificare");
		btnCreare.setForeground(new Color(230, 230, 250));
		btnCreare.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnCreare.setBackground(new Color(0, 139, 139));
		btnCreare.setBounds(157, 272, 126, 52);
		contentPane.add(btnCreare);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("vechea parol\u0103:");
		lblNewLabel_1_1_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBounds(23, 132, 119, 26);
		contentPane.add(lblNewLabel_1_1_2);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setForeground(new Color(128, 0, 128));
		passwordField_2.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		passwordField_2.setColumns(10);
		passwordField_2.setBounds(207, 131, 193, 26);
		contentPane.add(passwordField_2);
		
		btnCreare.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String mesajEroare = new String();
				
				ConexiuneBD c = new ConexiuneBD ();
				c.init();
				mesajEroare = c.contNou(textField.getText(), passwordField.getText(), passwordField_1.getText());
				
				if(mesajEroare != null) {
					new MesajEroare(mesajEroare).setVisible(true);
				}
				else {
					setVisible(false);
					new LogIn().setVisible(true);
				}
			}
		});
	}
}
