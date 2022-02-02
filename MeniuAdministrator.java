import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Choice;
import java.awt.Dimension;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

public class MeniuAdministrator extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel_1 = new JLabel("New label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MeniuAdministrator frame = new MeniuAdministrator();
					MeniuAdministrator mn = new MeniuAdministrator("Popa", "George", "1234567891234", "0754321679", "popageorge@gmail.com", "Cluj-Napoca", "1234567890123456789012345678901234", "b50", "2");
					frame.setVisible(true);
					mn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public MeniuAdministrator() {
		
	}
	
	public MeniuAdministrator(String numeUser,
			String prenumeUser,
			String cnpUser,
			String telefonUser,
			String adrEmailUser,
			String adresaUser,
			String ibanUser,
			String contractUser,
			String tipUser) {
		setDefaultCloseOperation(MeniuAdministrator.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setForeground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setSize(610, 835);
        this.setLocationRelativeTo(null);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnNewMenu = new JMenu("Alege\u021Bi op\u021Biunea...");
        mnNewMenu.setForeground(new Color(0, 128, 128));
        mnNewMenu.setFont(new Font("Arial Narrow", Font.BOLD, 18));
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("C\u0103utare utilizatori");
        mntmNewMenuItem_1_1.addActionListener((ActionListener) new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CautareUtilizator cu = new CautareUtilizator();
        		cu.setVisible(true);
        	}
        });
        mntmNewMenuItem_1_1.setForeground(new Color(128, 0, 128));
        mntmNewMenuItem_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_1_1);
        
        JMenuItem mntmNewMenuItem_1_2 = new JMenuItem("Asignare profesor");
        mntmNewMenuItem_1_2.setForeground(new Color(128, 0, 128));
        mntmNewMenuItem_1_2.setFont(new Font("Arial Narrow", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_1_2);
        
        mntmNewMenuItem_1_2.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					new AsignareCursuri().setVisible(true);
			}
		});
        
        JMenuItem mntmNewMenuItem_1_3_1 = new JMenuItem("C\u0103utare curs");
        mntmNewMenuItem_1_3_1.setForeground(new Color(128, 0, 128));
        mntmNewMenuItem_1_3_1.setFont(new Font("Arial Narrow", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_1_3_1);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        mntmNewMenuItem_1_3_1.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					new CautareCursuri().setVisible(true);
			}
		});
        
        JTextArea txtrBunVenitn = new JTextArea();
        txtrBunVenitn.setBackground(new Color(230, 230, 250));
        txtrBunVenitn.setRows(2);
        txtrBunVenitn.setForeground(new Color(0, 128, 128));
        txtrBunVenitn.setFont(new Font("Arial Narrow", Font.BOLD, 34));
        txtrBunVenitn.setText("Bun venit \u00EEn aplica\u021Bia\r\npentru administratori");
        txtrBunVenitn.setBounds(149, 31, 290, 84);
        txtrBunVenitn.setEditable(false);
        contentPane.add(txtrBunVenitn);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\MeniuAdministrator.png"));
        lblNewLabel.setBounds(194, 520, 210, 213);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_2 = new JLabel("Nume");
        lblNewLabel_2.setForeground(new Color(0, 128, 128));
        lblNewLabel_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
        lblNewLabel_2.setBounds(74, 151, 121, 34);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("Prenume");
        lblNewLabel_2_1.setForeground(new Color(0, 128, 128));
        lblNewLabel_2_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
        lblNewLabel_2_1.setBounds(74, 186, 121, 34);
        contentPane.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2_2 = new JLabel("CNP");
        lblNewLabel_2_2.setForeground(new Color(0, 128, 128));
        lblNewLabel_2_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
        lblNewLabel_2_2.setBounds(74, 218, 121, 34);
        contentPane.add(lblNewLabel_2_2);
        
        JLabel lblNewLabel_2_3 = new JLabel("Telefon");
        lblNewLabel_2_3.setForeground(new Color(0, 128, 128));
        lblNewLabel_2_3.setFont(new Font("Arial Narrow", Font.BOLD, 20));
        lblNewLabel_2_3.setBounds(74, 250, 121, 34);
        contentPane.add(lblNewLabel_2_3);
        
        JLabel lblNewLabel_2_4 = new JLabel("E-mail");
        lblNewLabel_2_4.setForeground(new Color(0, 128, 128));
        lblNewLabel_2_4.setFont(new Font("Arial Narrow", Font.BOLD, 20));
        lblNewLabel_2_4.setBounds(74, 283, 121, 34);
        contentPane.add(lblNewLabel_2_4);
        
        JLabel lblNewLabel_2_5 = new JLabel("Adresa");
        lblNewLabel_2_5.setForeground(new Color(0, 128, 128));
        lblNewLabel_2_5.setFont(new Font("Arial Narrow", Font.BOLD, 20));
        lblNewLabel_2_5.setBounds(74, 315, 121, 34);
        contentPane.add(lblNewLabel_2_5);
        
        JLabel lblNewLabel_2_6 = new JLabel("IBAN");
        lblNewLabel_2_6.setForeground(new Color(0, 128, 128));
        lblNewLabel_2_6.setFont(new Font("Arial Narrow", Font.BOLD, 20));
        lblNewLabel_2_6.setBounds(74, 351, 121, 34);
        contentPane.add(lblNewLabel_2_6);
        
        JLabel lblNewLabel_2_7 = new JLabel("Num\u0103r contract");
        lblNewLabel_2_7.setForeground(new Color(0, 128, 128));
        lblNewLabel_2_7.setFont(new Font("Arial Narrow", Font.BOLD, 20));
        lblNewLabel_2_7.setBounds(74, 389, 132, 34);
        contentPane.add(lblNewLabel_2_7);
        
        JTextField txtFsadfsa = new JTextField(numeUser);
        txtFsadfsa.setEditable(false);
        txtFsadfsa.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        txtFsadfsa.setForeground(new Color(128, 0, 128));
        txtFsadfsa.setBounds(205, 158, 229, 20);
        contentPane.add(txtFsadfsa);
        txtFsadfsa.setColumns(10);
        
        JTextField textField = new JTextField(prenumeUser);
        textField.setEditable(false);
        textField.setForeground(new Color(128, 0, 128));
        textField.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        textField.setColumns(10);
        textField.setBounds(205, 193, 229, 20);
        contentPane.add(textField);
        
        JTextField textField_1 = new JTextField(cnpUser);
        textField_1.setEditable(false);
        textField_1.setForeground(new Color(128, 0, 128));
        textField_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        textField_1.setColumns(10);
        textField_1.setBounds(205, 225, 229, 20);
        contentPane.add(textField_1);
        
        JTextField textField_2 = new JTextField(telefonUser);
        textField_2.setEditable(false);
        textField_2.setForeground(new Color(128, 0, 128));
        textField_2.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        textField_2.setColumns(10);
        textField_2.setBounds(205, 260, 229, 20);
        contentPane.add(textField_2);
        
        JTextField textField_3 = new JTextField(adrEmailUser);
        textField_3.setEditable(false);
        textField_3.setForeground(new Color(128, 0, 128));
        textField_3.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        textField_3.setColumns(10);
        textField_3.setBounds(205, 293, 229, 20);
        contentPane.add(textField_3);
        
        JTextField textField_4 = new JTextField(adresaUser);
        textField_4.setEditable(false);
        textField_4.setForeground(new Color(128, 0, 128));
        textField_4.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        textField_4.setColumns(10);
        textField_4.setBounds(205, 325, 229, 20);
        contentPane.add(textField_4);
        
        JTextField textField_5 = new JTextField(ibanUser);
        textField_5.setEditable(false);
        textField_5.setForeground(new Color(128, 0, 128));
        textField_5.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        textField_5.setColumns(10);
        textField_5.setBounds(205, 358, 229, 20);
        contentPane.add(textField_5);
        
        JTextField textField_6 = new JTextField(contractUser);
        textField_6.setEditable(false);
        textField_6.setForeground(new Color(128, 0, 128));
        textField_6.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        textField_6.setColumns(10);
        textField_6.setBounds(205, 396, 229, 20);
        contentPane.add(textField_6);
        
        JButton btnNewButton = new JButton("Deautentificare");
        btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 22));
        btnNewButton.setBackground(new Color(0, 128, 128));
        btnNewButton.setForeground(new Color(230, 230, 250));
        btnNewButton.setBounds(183, 441, 221, 35);
        contentPane.add(btnNewButton);
        
        btnNewButton.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					setVisible(false);
					new LogIn().setVisible(true);
			}
		});
	}
}

