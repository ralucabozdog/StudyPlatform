import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ModificareDate extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_5;
	public JTextField textField_6;
	public JTextField textField_7;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificareDate frame = new ModificareDate("Popa", "Mircea", "popamircea@gmail.com", "1234567890123", "Cluj-Napoca", "0723691257", "1234567890123456789012345678901234", "c90");
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
	public ModificareDate(String nume, String prenume, String email, String cnp, String adresa, String telefon, String iban, String nrContract) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 609, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCutareUtilizator = new JLabel("Modificare date");
		lblCutareUtilizator.setHorizontalAlignment(SwingConstants.CENTER);
		lblCutareUtilizator.setForeground(new Color(0, 139, 139));
		lblCutareUtilizator.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblCutareUtilizator.setBounds(194, 11, 218, 52);
		contentPane.add(lblCutareUtilizator);
		
		JLabel lblNewLabel_1_1 = new JLabel("nume:");
		lblNewLabel_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(50, 74, 136, 26);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField(nume);
		textField.setForeground(new Color(128, 0, 128));
		textField.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField.setColumns(10);
		textField.setBounds(186, 74, 376, 26);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("prenume:");
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1.setBounds(50, 111, 136, 26);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField(prenume);
		textField_1.setForeground(new Color(128, 0, 128));
		textField_1.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(186, 111, 376, 26);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel1 = new JLabel("");
		ImageIcon img = new ImageIcon(new ImageIcon("src\\ModificareDate.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		lblNewLabel1.setIcon(img);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(0, 380, 593, 113);
		contentPane.add(lblNewLabel1);
		
		JButton btnCautare = new JButton("Modificare");
		btnCautare.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mesajEroare = new String();
				
				ConexiuneBD conexiune = new ConexiuneBD();
				conexiune.init();
				mesajEroare = conexiune.modificareDate(textField_4.getText(), textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_5.getText(), textField_6.getText(), textField_7.getText());
				
				if(mesajEroare != null) {
					new MesajEroare(mesajEroare).setVisible(true);
					System.out.println(mesajEroare);
				}
				else {
					setVisible(false);
				}
				
			}
		});
		btnCautare.setForeground(new Color(230, 230, 250));
		btnCautare.setFont(new Font("Arial Nova Light", Font.BOLD, 14));
		btnCautare.setBackground(new Color(0, 139, 139));
		btnCautare.setActionCommand("OK");
		btnCautare.setBounds(229, 522, 138, 44);
		contentPane.add(btnCautare);
		
		textField_2 = new JTextField(cnp);
		textField_2.setForeground(new Color(128, 0, 128));
		textField_2.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(186, 182, 376, 26);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CNP:");
		lblNewLabel_1_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(50, 182, 136, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("telefon:");
		lblNewLabel_1_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(50, 219, 136, 26);
		contentPane.add(lblNewLabel_1_2);
		
		textField_3 = new JTextField(telefon);
		textField_3.setForeground(new Color(128, 0, 128));
		textField_3.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(186, 219, 376, 26);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("adres\u0103:");
		lblNewLabel_1_3.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_3.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(50, 256, 136, 26);
		contentPane.add(lblNewLabel_1_3);
		
		textField_5 = new JTextField(adresa);
		textField_5.setForeground(new Color(128, 0, 128));
		textField_5.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(186, 256, 376, 26);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField(iban);
		textField_6.setForeground(new Color(128, 0, 128));
		textField_6.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(186, 293, 376, 26);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("IBAN:");
		lblNewLabel_1_1_3.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1_3.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1_3.setBounds(50, 293, 136, 26);
		contentPane.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("num\u0103r contract:");
		lblNewLabel_1_4.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_4.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_4.setBounds(50, 330, 136, 26);
		contentPane.add(lblNewLabel_1_4);
		
		textField_7 = new JTextField(nrContract);
		textField_7.setForeground(new Color(128, 0, 128));
		textField_7.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_7.setColumns(10);
		textField_7.setBounds(186, 330, 376, 26);
		contentPane.add(textField_7);
		
		JButton btnStergeContul = new JButton("Sterge contul");
		btnStergeContul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mesajEroare = new String();
				ConexiuneBD conexiune = new ConexiuneBD();
				conexiune.init();
				mesajEroare = conexiune.stergereInformatii(email);
				if(mesajEroare != null) {
					new MesajEroare(mesajEroare).setVisible(true);
					System.out.println(mesajEroare);
				}
				else {
					setVisible(false);
				}
			}
		});
		btnStergeContul.setForeground(new Color(230, 230, 250));
		btnStergeContul.setFont(new Font("Arial Nova Light", Font.BOLD, 14));
		btnStergeContul.setBackground(new Color(0, 139, 139));
		btnStergeContul.setActionCommand("OK");
		btnStergeContul.setBounds(229, 577, 138, 44);
		contentPane.add(btnStergeContul);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("email:");
		lblNewLabel_1_2_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_2_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(50, 148, 136, 26);
		contentPane.add(lblNewLabel_1_2_1);
		
		textField_4 = new JTextField(email);
		textField_4.setForeground(new Color(128, 0, 128));
		textField_4.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(186, 148, 376, 26);
		textField_4.setEditable(false);
		contentPane.add(textField_4);
	}
}

