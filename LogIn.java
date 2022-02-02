import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.io.*;
import java.lang.Integer;
import java.lang.Double;

public class LogIn extends javax.swing.JFrame {

	public JPanel contentPane;
	public JTextField txtAaa;
	public JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setSize(432, 562);
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblNewLabel.setBounds(0, 26, 416, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("e-mail:");
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1.setBounds(60, 110, 59, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("parola:");
		lblNewLabel_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(60, 147, 59, 26);
		contentPane.add(lblNewLabel_1_1);
		
		txtAaa = new JTextField();
		txtAaa.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		txtAaa.setForeground(new Color(128, 0, 128));
		txtAaa.setBounds(132, 110, 193, 26);
		contentPane.add(txtAaa);
		txtAaa.setColumns(10);
		
		textField = new JPasswordField();
		textField.setForeground(new Color(128, 0, 128));
		textField.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField.setColumns(10);
		textField.setBounds(132, 147, 193, 26);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("Autentificare");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConexiuneBD conexiune = new ConexiuneBD();
				conexiune.init();
				ArrayList<String> lista = conexiune.autentificare(txtAaa.getText(), textField.getText());
				
				if(lista.size() == 1) {
					new MesajEroare(lista.get(0)).setVisible(true);
				}
				else {
					if(lista.get(8).contentEquals("0")) {
						setVisible(false);
						new MeniuStudent(
								lista.get(0),
								lista.get(1),
								lista.get(2),
								lista.get(3),
								lista.get(4),
								lista.get(5),
								lista.get(6),
								lista.get(7),
								lista.get(8)).setVisible(true);
					}
					else {
						if(lista.get(8).contentEquals("1")) {
							setVisible(false);
							new MeniuProfesor(lista.get(0),
									lista.get(1),
									lista.get(2),
									lista.get(3),
									lista.get(4),
									lista.get(5),
									lista.get(6),
									lista.get(7),
									lista.get(8)).setVisible(true);
						}
						else {
							setVisible(false);
							new MeniuAdministrator(lista.get(0),
									lista.get(1),
									lista.get(2),
									lista.get(3),
									lista.get(4),
									lista.get(5),
									lista.get(6),
									lista.get(7),
									lista.get(8)).setVisible(true);
						}
					}
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setForeground(new Color(230, 230, 250));
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton.setBounds(132, 357, 147, 52);
		contentPane.add(btnNewButton);
		
		JButton btnCreareCont = new JButton("Modificare parolã");
		btnCreareCont.setForeground(new Color(230, 230, 250));
		btnCreareCont.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnCreareCont.setBackground(new Color(0, 139, 139));
		btnCreareCont.setBounds(132, 439, 147, 52);
		contentPane.add(btnCreareCont);
		
		
		btnCreareCont.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CreareCont().setVisible(true);
			}
		});
		
		
		JLabel lblNewLabel1 = new JLabel("");
		ImageIcon img = new ImageIcon(new ImageIcon("src\\LogIn.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		lblNewLabel1.setIcon(img);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(0, 210, 416, 113);
		contentPane.add(lblNewLabel1);
	}
}