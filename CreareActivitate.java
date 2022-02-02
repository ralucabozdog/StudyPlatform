import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class CreareActivitate extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreareActivitate frame = new CreareActivitate(1);
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
	public CreareActivitate(int idGrup) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 550);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreareActivitate = new JLabel("Creare Activitate");
		lblCreareActivitate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreareActivitate.setForeground(new Color(0, 139, 139));
		lblCreareActivitate.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblCreareActivitate.setBounds(106, 11, 218, 52);
		contentPane.add(lblCreareActivitate);
		
		JLabel lblNewLabel_1 = new JLabel("data: ");
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1.setBounds(37, 88, 116, 26);
		contentPane.add(lblNewLabel_1);
		
		JTextField txtMmddyyyy = new JTextField();
		txtMmddyyyy.setText("yyyy-mm-dd");
		txtMmddyyyy.setForeground(new Color(128, 0, 128));
		txtMmddyyyy.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		txtMmddyyyy.setColumns(10);
		txtMmddyyyy.setBounds(194, 88, 193, 26);
		contentPane.add(txtMmddyyyy);
		
		JTextField txtHhmm = new JTextField();
		txtHhmm.setText("hh:mm:ss");
		txtHhmm.setForeground(new Color(128, 0, 128));
		txtHhmm.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		txtHhmm.setColumns(10);
		txtHhmm.setBounds(194, 125, 193, 26);
		contentPane.add(txtHhmm);
		
		JLabel lblNewLabel_1_1 = new JLabel("ora: ");
		lblNewLabel_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(37, 125, 116, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JTextField textField_2 = new JTextField();
		textField_2.setForeground(new Color(128, 0, 128));
		textField_2.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(194, 162, 193, 26);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("durata: ");
		lblNewLabel_1_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(37, 162, 116, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		JTextField textField_3 = new JTextField();
		textField_3.setForeground(new Color(128, 0, 128));
		textField_3.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(194, 199, 193, 26);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("minim participan\u021Bi: ");
		lblNewLabel_1_1_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(37, 199, 147, 26);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JTextField textField_4 = new JTextField();
		textField_4.setForeground(new Color(128, 0, 128));
		textField_4.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(194, 236, 193, 26);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("timp expirare: ");
		lblNewLabel_1_1_1_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1_1_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1_1_2.setBounds(37, 236, 116, 26);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JButton btnCreare = new JButton("Creare");
		btnCreare.setForeground(new Color(230, 230, 250));
		btnCreare.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnCreare.setBackground(new Color(0, 139, 139));
		btnCreare.setBounds(154, 416, 126, 52);
		contentPane.add(btnCreare);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img = new ImageIcon(new ImageIcon("src\\CreareActivitate.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(img);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 285, 434, 113);
		contentPane.add(lblNewLabel);
		
		btnCreare.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int an = Integer.parseInt(txtMmddyyyy.getText().substring(0, 4)) - 1900;
				int luna = Integer.parseInt(txtMmddyyyy.getText().substring(5, 7)) - 1;
				int zi = Integer.parseInt(txtMmddyyyy.getText().substring(8, 10));
				
				int h = Integer.parseInt(txtHhmm.getText().substring(0, 2));
				int min = Integer.parseInt(txtHhmm.getText().substring(3, 5));
				int sec = Integer.parseInt(txtHhmm.getText().substring(6,8));
				
				
				Date dataDesfasurare = new Date(an, luna, zi);
				Time ora = new Time(h, min, sec);
				float durata = Float.parseFloat(textField_2.getText());
				float timpExpirare = Float.parseFloat(textField_4.getText());
				int minStudenti = Integer.parseInt(textField_3.getText());
				
				
				ArrayList<String> result = new ArrayList<String>();
				ConexiuneBD conexiune = new ConexiuneBD();
				conexiune.init();
				result = conexiune.creareActivitate(idGrup, dataDesfasurare, ora, durata, timpExpirare, minStudenti);
				
				if(result.get(0) != null) {
					new MesajEroare(result.get(0)).setVisible(true);
				}
				else {
					new ActivitateSucces(Integer.parseInt(result.get(1))).setVisible(true);
					setVisible(false);
				}
			}	
				
		});
	}

}
