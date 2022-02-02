import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ImpartireProcentuala extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImpartireProcentuala frame = new ImpartireProcentuala(1);
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
	public ImpartireProcentuala(int idProf) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 525);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblmprireProcentual = new JLabel("\u00CEmp\u0103r\u021Bire procentual\u0103");
		lblmprireProcentual.setHorizontalAlignment(SwingConstants.CENTER);
		lblmprireProcentual.setForeground(new Color(0, 139, 139));
		lblmprireProcentual.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblmprireProcentual.setBounds(90, 11, 253, 52);
		contentPane.add(lblmprireProcentual);
		
		JLabel lblNewLabel_1_1 = new JLabel("procent curs:");
		lblNewLabel_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(38, 128, 136, 26);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(128, 0, 128));
		textField.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField.setColumns(10);
		textField.setBounds(204, 128, 143, 26);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("procent laborator:");
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1.setBounds(38, 165, 151, 26);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(128, 0, 128));
		textField_1.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(204, 165, 143, 26);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("procent seminar:");
		lblNewLabel_1_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(38, 202, 136, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(128, 0, 128));
		textField_2.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(204, 202, 143, 26);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("%");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBounds(357, 128, 49, 26);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("%");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1_2_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1_2_1.setBounds(357, 165, 49, 26);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("%");
		lblNewLabel_1_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1_2_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1_2_2.setBounds(357, 202, 49, 26);
		contentPane.add(lblNewLabel_1_1_2_2);
		
		JLabel lblNewLabel1 = new JLabel("");
		ImageIcon img = new ImageIcon(new ImageIcon("src\\ImpartireProcentuala.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		lblNewLabel1.setIcon(img);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(0, 252, 434, 113);
		contentPane.add(lblNewLabel1);
		
		String[] materii = new String[20];
		int[] iduri = new int[20];
		int i = 0;
		ConexiuneBD conexiune1 = new ConexiuneBD();
		conexiune1.init();
		conexiune1.toateMateriileProfesorului(idProf);
		
		try {
		      File myObj = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\toate_materiile_profesorului.txt");
		      Scanner myReader = new Scanner(myObj);
		      
		      while (myReader.hasNextLine()) {
		    	
		        String data = myReader.nextLine();
		        
		        int number = Integer.parseInt(data);
		        ConexiuneBD conexiune = new ConexiuneBD();
		        conexiune.init();
		        iduri[i] = number;
		        materii[i] = conexiune.getNumeMaterie(number);
		        i++;
		      }
		      myReader.close();
		     if(myObj.delete())
		    	  System.out.println("deleted");
		      else
		    	  System.out.println("could not be deleted");
		    } catch (FileNotFoundException e) {
		      System.out.println("Eroare la citire");
		      e.printStackTrace();
		    }
		
		JComboBox comboBox = new JComboBox(materii);
		comboBox.setForeground(new Color(128, 0, 128));
		comboBox.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		comboBox.setBounds(204, 91, 193, 26);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_2 = new JLabel("materie:");
		lblNewLabel_1_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(38, 91, 73, 26);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnOk = new JButton("OK");
		btnOk.setForeground(new Color(230, 230, 250));
		btnOk.setFont(new Font("Arial Nova Light", Font.BOLD, 14));
		btnOk.setBackground(new Color(0, 139, 139));
		btnOk.setActionCommand("OK");
		btnOk.setBounds(148, 396, 138, 44);
		contentPane.add(btnOk);
		
		btnOk.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String mesajEroare = new String();
				
				ConexiuneBD c = new ConexiuneBD ();
				c.init();
				mesajEroare = c.incarcareProcentuala(iduri[comboBox.getSelectedIndex()], idProf, Integer.parseInt(textField.getText()), Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()));
				
				if(mesajEroare != null) {
					new MesajEroare(mesajEroare).setVisible(true);
				}
				else {
					setVisible(false);
				}
			}
		});
	}
}
