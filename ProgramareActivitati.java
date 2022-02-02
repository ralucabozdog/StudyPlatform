import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ProgramareActivitati extends JFrame {

	private JPanel contentPane;
	private JTextField txtMmddyyyy;
	private JTextField txtMmddyyyy_1;
	private JTextField txtHhmm;
	private JTextField txtIntroduceiNumrulMaxim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramareActivitati frame = new ProgramareActivitati();
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
	public ProgramareActivitati() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 628);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Programa\u021Bi o activitate...");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblNewLabel.setBounds(103, 11, 287, 65);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Materie:");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1.setBounds(35, 87, 87, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tip:");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(35, 124, 87, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Data \u00EEnceput:");
		lblNewLabel_1_2.setForeground(new Color(0, 128, 128));
		lblNewLabel_1_2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(35, 161, 87, 26);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Data final:");
		lblNewLabel_1_3.setForeground(new Color(0, 128, 128));
		lblNewLabel_1_3.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(35, 198, 87, 26);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ziua:");
		lblNewLabel_1_4.setForeground(new Color(0, 128, 128));
		lblNewLabel_1_4.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(35, 235, 87, 26);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Ora:");
		lblNewLabel_1_5.setForeground(new Color(0, 128, 128));
		lblNewLabel_1_5.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(35, 272, 87, 26);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Num\u0103r participan\u021Bi:");
		lblNewLabel_1_6.setForeground(new Color(0, 128, 128));
		lblNewLabel_1_6.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(35, 309, 144, 26);
		contentPane.add(lblNewLabel_1_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"materie1", "materie2", "materie3"}));
		comboBox.setForeground(new Color(128, 0, 128));
		comboBox.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		comboBox.setBounds(160, 87, 287, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"curs", "seminar", "laborator"}));
		comboBox_1.setForeground(new Color(128, 0, 128));
		comboBox_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		comboBox_1.setBounds(160, 126, 287, 22);
		contentPane.add(comboBox_1);
		
		txtMmddyyyy = new JTextField();
		txtMmddyyyy.setText("mm-dd-yyyy");
		txtMmddyyyy.setForeground(new Color(128, 0, 128));
		txtMmddyyyy.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		txtMmddyyyy.setBounds(160, 165, 287, 20);
		contentPane.add(txtMmddyyyy);
		txtMmddyyyy.setColumns(10);
		
		txtMmddyyyy_1 = new JTextField();
		txtMmddyyyy_1.setText("mm-dd-yyyy");
		txtMmddyyyy_1.setForeground(new Color(128, 0, 128));
		txtMmddyyyy_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		txtMmddyyyy_1.setColumns(10);
		txtMmddyyyy_1.setBounds(160, 202, 287, 20);
		contentPane.add(txtMmddyyyy_1);
		
		txtHhmm = new JTextField();
		txtHhmm.setText("hh:mm");
		txtHhmm.setForeground(new Color(128, 0, 128));
		txtHhmm.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		txtHhmm.setColumns(10);
		txtHhmm.setBounds(160, 276, 287, 20);
		contentPane.add(txtHhmm);
		
		txtIntroduceiNumrulMaxim = new JTextField();
		txtIntroduceiNumrulMaxim.setText("Introduce\u021Bi num\u0103rul maxim de participan\u021Bi...");
		txtIntroduceiNumrulMaxim.setForeground(new Color(128, 0, 128));
		txtIntroduceiNumrulMaxim.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		txtIntroduceiNumrulMaxim.setColumns(10);
		txtIntroduceiNumrulMaxim.setBounds(160, 313, 287, 20);
		contentPane.add(txtIntroduceiNumrulMaxim);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"luni", "mar\u021Bi", "miercuri", "joi", "vineri"}));
		comboBox_1_1.setForeground(new Color(128, 0, 128));
		comboBox_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		comboBox_1_1.setBounds(160, 238, 287, 22);
		contentPane.add(comboBox_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("src\\ProgramareActivitati.png"));
		lblNewLabel_2.setBounds(170, 353, 154, 147);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Programa\u021Bi");
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setForeground(new Color(230, 230, 250));
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton.setBounds(180, 516, 136, 46);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
	}
}