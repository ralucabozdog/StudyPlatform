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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Choice;
import java.awt.Dimension;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MeniuStudent extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel_1 = new JLabel("New label");
	private JTextField txtFsadfsa;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MeniuStudent frame = new MeniuStudent("Amariei", "Georgiana", "6000314567892", "0745123456",
							"amarieigeorge@gmail.com", "Cluj-Napoca", "5467891253647894568ssaq745db684s21", "a56", "0");
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
	public MeniuStudent() {
		
	}
	public MeniuStudent(String numeUser,
	String prenumeUser,
	String cnpUser,
	String telefonUser,
	String adrEmailUser,
	String adresaUser,
	String ibanUser,
	String contractUser,
	String tipUser) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setForeground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setSize(610, 835);
        this.setLocationRelativeTo(null);
        
        ConexiuneBD conexiune  = new ConexiuneBD();
		conexiune.init();
		int idS = conexiune.getIdStudent(adrEmailUser);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnNewMenu = new JMenu("Alege\u021Bi op\u021Biunea...");
        mnNewMenu.setForeground(new Color(0, 128, 128));
        mnNewMenu.setFont(new Font("Arial Narrow", Font.BOLD, 18));
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Vizualizare note");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ConexiuneBD c = new ConexiuneBD();
        		c.init();
        		c.vizualizareNoteStudent(idS);
        		
        		VizualizareNote note = new VizualizareNote();
        		note.setVisible(true);
        		note.setLocationRelativeTo(null);
        	}
        });
        mntmNewMenuItem_1.setForeground(new Color(128, 0, 128));
        mntmNewMenuItem_1.setFont(new Font("Arial Narrow", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_1);
        
        JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Vizualizare orar");
        mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		OrarStudent orar = new OrarStudent();
        		orar.setVisible(true);
        	}
        });
        mntmNewMenuItem_1_1.setForeground(new Color(128, 0, 128));
        mntmNewMenuItem_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_1_1);
        
        JMenuItem mntmNewMenuItem_1_2 = new JMenuItem("Vizualizare grupuri de studiu");
        mntmNewMenuItem_1_2.setForeground(new Color(128, 0, 128));
        mntmNewMenuItem_1_2.setFont(new Font("Arial Narrow", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_1_2);
        
        
        
        mntmNewMenuItem_1_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		ConexiuneBD conexiune2 = new ConexiuneBD();
        		conexiune2.init();
        		conexiune2.toateGrupurileStudentului(idS);
        		
        		
        		Scanner myReader = null;
        		File myObj = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\toate_grupurile_studentului.txt");
  		      	try {
  		      	 myReader = new Scanner(myObj);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
  		      	
  		      String data = myReader.nextLine();
		       String nb = new String();
		       String dataModified = new String();
		        
		       if(data.charAt(1) < '0' || data.charAt(1) > '9') {
		        	
		       	nb = data.substring(0,1);
		        dataModified = data.substring(2);
	        }
	        else {
	        	if(data.charAt(2) < '0' || data.charAt(2) > '9') {
		        	nb = data.substring(0,2);
				    dataModified = data.substring(3);
			    }
		        else {
		        	nb = data.substring(0,3);
				    dataModified = data.substring(4);
		       	}
		        }
		        
		       myReader.close();
			      if(myObj.delete())
			    	  System.out.println("deleted");
			      else
			    	  System.out.println("could not be deleted");
		        
		        int number = Integer.parseInt(nb);
  		      
        		System.out.println(number);
        		MesajeGrup mg = new MesajeGrup(number, idS);
        		mg.setVisible(true);
        	}
        });
        
        JMenuItem mntmNewMenuItem_1_3 = new JMenuItem("\u00CEnscriere curs");
        mntmNewMenuItem_1_3.setForeground(new Color(128, 0, 128));
        mntmNewMenuItem_1_3.setFont(new Font("Arial Narrow", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_1_3);
        
        mntmNewMenuItem_1_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		InscriereCurs ic = new InscriereCurs(idS);
        		ic.setVisible(true);
        	}
        });
        
        JMenuItem mntmNewMenuItem_1_3_1 = new JMenuItem("Renun\u021Bare curs");
        mntmNewMenuItem_1_3_1.setForeground(new Color(128, 0, 128));
        mntmNewMenuItem_1_3_1.setFont(new Font("Arial Narrow", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_1_3_1);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        mntmNewMenuItem_1_3_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		RenuntareCurs ic = new RenuntareCurs(idS);
        		ic.setVisible(true);
        	}
        });
        
        JTextArea txtrBunVenitn = new JTextArea();
        txtrBunVenitn.setBackground(new Color(230, 230, 250));
        txtrBunVenitn.setRows(2);
        txtrBunVenitn.setForeground(new Color(0, 128, 128));
        txtrBunVenitn.setFont(new Font("Arial Narrow", Font.BOLD, 34));
        txtrBunVenitn.setText("Bun venit \u00EEn aplica\u021Bia\r\n    pentru studen\u021Bi");
        txtrBunVenitn.setBounds(163, 31, 290, 84);
        txtrBunVenitn.setEditable(false);
        contentPane.add(txtrBunVenitn);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\MeniuStudent.png"));
        lblNewLabel.setBounds(194, 509, 210, 241);
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
        
        txtFsadfsa = new JTextField(numeUser);
        txtFsadfsa.setEditable(false);
        txtFsadfsa.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        txtFsadfsa.setForeground(new Color(128, 0, 128));
        txtFsadfsa.setBounds(205, 158, 229, 20);
        contentPane.add(txtFsadfsa);
        txtFsadfsa.setColumns(10);
        // plus setText din baza de date??????
        
        textField = new JTextField(prenumeUser);
        textField.setEditable(false);
        textField.setForeground(new Color(128, 0, 128));
        textField.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        textField.setColumns(10);
        textField.setBounds(205, 193, 229, 20);
        contentPane.add(textField);
        
        textField_1 = new JTextField(cnpUser);
        textField_1.setEditable(false);
        textField_1.setForeground(new Color(128, 0, 128));
        textField_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        textField_1.setColumns(10);
        textField_1.setBounds(205, 225, 229, 20);
        contentPane.add(textField_1);
        
        textField_2 = new JTextField(telefonUser);
        textField_2.setEditable(false);
        textField_2.setForeground(new Color(128, 0, 128));
        textField_2.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        textField_2.setColumns(10);
        textField_2.setBounds(205, 260, 229, 20);
        contentPane.add(textField_2);
        
        textField_3 = new JTextField(adrEmailUser);
        textField_3.setEditable(false);
        textField_3.setForeground(new Color(128, 0, 128));
        textField_3.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        textField_3.setColumns(10);
        textField_3.setBounds(205, 293, 229, 20);
        contentPane.add(textField_3);
        
        textField_4 = new JTextField(adresaUser);
        textField_4.setEditable(false);
        textField_4.setForeground(new Color(128, 0, 128));
        textField_4.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        textField_4.setColumns(10);
        textField_4.setBounds(205, 325, 229, 20);
        contentPane.add(textField_4);
        
        textField_5 = new JTextField(ibanUser);
        textField_5.setEditable(false);
        textField_5.setForeground(new Color(128, 0, 128));
        textField_5.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        textField_5.setColumns(10);
        textField_5.setBounds(205, 358, 229, 20);
        contentPane.add(textField_5);
        
        textField_6 = new JTextField(contractUser);
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