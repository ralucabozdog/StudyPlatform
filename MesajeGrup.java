import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class MesajeGrup extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MesajeGrup frame = new MesajeGrup(1, 1);
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
	
	public MesajeGrup() {
		
	}
	
	public MesajeGrup(int idGrup, int idStudent) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 1025);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ConexiuneBD conexiune = new ConexiuneBD();
		conexiune.init();
		
		JLabel lblNumeGrup = new JLabel(conexiune.getNumeGrup(idGrup));
		lblNumeGrup.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeGrup.setForeground(new Color(0, 139, 139));
		lblNumeGrup.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblNumeGrup.setBounds(155, 11, 218, 52);
		contentPane.add(lblNumeGrup);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 139, 139));
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(null, "Mesaje grup", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(78, 71, 376, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		DefaultListModel dlm = new DefaultListModel();
		
		ConexiuneBD conexiune1 = new ConexiuneBD();
		conexiune1.init();
		conexiune1.afisareMesaje(idGrup);
		
		try {
		      File myObj = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\afisare_mesaje.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        dlm.addElement(data);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 364, 360);
		panel.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setBackground(new Color(255, 255, 255));
		list.setForeground(new Color(128, 0, 128));
		list.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		
		list.setModel(dlm);
		
		JButton btnAratMembrii = new JButton("Arat\u0103 membrii");
		btnAratMembrii.setForeground(new Color(230, 230, 250));
		btnAratMembrii.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnAratMembrii.setBackground(new Color(0, 139, 139));
		btnAratMembrii.setBounds(191, 552, 170, 52);
		contentPane.add(btnAratMembrii);
		
		btnAratMembrii.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ConexiuneBD c = new ConexiuneBD ();
				c.init();
				c.afisareMembri(idGrup);
				new MembriGrup(idGrup).setVisible(true);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("scrie:");
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1.setBounds(78, 460, 116, 26);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(128, 0, 128));
		textField.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField.setColumns(10);
		textField.setBounds(78, 497, 267, 26);
		contentPane.add(textField);
		
		JButton btnTrimite = new JButton("Trimite");
		btnTrimite.setForeground(new Color(230, 230, 250));
		btnTrimite.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnTrimite.setBackground(new Color(0, 139, 139));
		btnTrimite.setBounds(345, 497, 109, 26);
		contentPane.add(btnTrimite);
		
		btnTrimite.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ConexiuneBD conexiune2 = new ConexiuneBD();
				conexiune2.init();
				conexiune2.trimitereMesaj(textField.getText(), idStudent, idGrup);
				
				/*ArrayList<String> result = conexiune2.getNumeStudent(idStudent);
				dlm.addElement(result.get(0) + " " + result.get(1) + ": " + textField.getText());*/
				
				ConexiuneBD conexiune3 = new ConexiuneBD();
				conexiune3.init();
				conexiune3.afisareMesaje(idGrup);
				
				dlm.clear();
				
				try {
				      File myObj = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\afisare_mesaje.txt");
				      Scanner myReader = new Scanner(myObj);
				      while (myReader.hasNextLine()) {
				        String data = myReader.nextLine();
				        dlm.addElement(data);
				      }
				      myReader.close();
				      if(myObj.delete())
				    	  System.out.println("deleted");
				      else
				    	  System.out.println("could not be deleted");;
				    } catch (FileNotFoundException e1) {
				      System.out.println("Eroare la citire");
				      e1.printStackTrace();
				    }
				
				textField.setText("");
			}
		});
		
		JButton btnGrupNou = new JButton("Activit\u0103\u021Bi disponibile");
		btnGrupNou.setForeground(new Color(230, 230, 250));
		btnGrupNou.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnGrupNou.setBackground(new Color(0, 139, 139));
		btnGrupNou.setBounds(191, 615, 170, 52);
		contentPane.add(btnGrupNou);
		
		btnGrupNou.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ConexiuneBD conexiune = new ConexiuneBD();
				conexiune.init();
				conexiune.toateActivitatileCuProfesor();
				
				ConexiuneBD conexiune1 = new ConexiuneBD();
				conexiune1.init();
				conexiune1.toateActivitatileFaraProfesor();
				
				new InscriereActivitate(idStudent).setVisible(true);
				
				
			}
		});
		
		JButton btnCreareActivitate = new JButton("Creare activitate");
		btnCreareActivitate.setForeground(new Color(230, 230, 250));
		btnCreareActivitate.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnCreareActivitate.setBackground(new Color(0, 139, 139));
		btnCreareActivitate.setBounds(191, 678, 170, 52);
		contentPane.add(btnCreareActivitate);
		
		btnCreareActivitate.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CreareActivitate ca = new CreareActivitate(idGrup);
				ca.setVisible(true);
				ca.setLocationRelativeTo(null);
			}
		});
		
		JButton btnGrupNou_1_1 = new JButton("\u00CEnscriere grup");
		btnGrupNou_1_1.setForeground(new Color(230, 230, 250));
		btnGrupNou_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnGrupNou_1_1.setBackground(new Color(0, 139, 139));
		btnGrupNou_1_1.setBounds(191, 741, 170, 52);
		contentPane.add(btnGrupNou_1_1);
		
		btnGrupNou_1_1.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ConexiuneBD conexiune = new ConexiuneBD();
				conexiune.init();
				conexiune.toateGrupurile();
				new InscriereGrup(idStudent).setVisible(true);
			}
		});
		
		
		JButton btnGrupNou_1_1_1 = new JButton("Creare grup");
		btnGrupNou_1_1_1.setForeground(new Color(230, 230, 250));
		btnGrupNou_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnGrupNou_1_1_1.setBackground(new Color(0, 139, 139));
		btnGrupNou_1_1_1.setBounds(191, 804, 170, 52);
		contentPane.add(btnGrupNou_1_1_1);
		
		JButton btnGrupNou_1_1_1_1 = new JButton("Sugestii participan\u021Bi");
		btnGrupNou_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SugestiiParticipanti(idGrup).setVisible(true);
			}
		});
		
		btnGrupNou_1_1_1_1.setForeground(new Color(230, 230, 250));
		btnGrupNou_1_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnGrupNou_1_1_1_1.setBackground(new Color(0, 139, 139));
		btnGrupNou_1_1_1_1.setBounds(191, 867, 170, 52);
		contentPane.add(btnGrupNou_1_1_1_1);
		
		btnGrupNou_1_1_1.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreareGrup(idStudent).setVisible(true);
			}
		});
		
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Grupurile mele...                                                                                                              ");
		mnNewMenu.setForeground(new Color(128, 0, 128));
		mnNewMenu.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		ConexiuneBD conexiune2 = new ConexiuneBD();
		conexiune2.init();
		conexiune2.toateGrupurileStudentului(idStudent);
		
		
		int[] vector = new int[100];
	    int i = 0;
		
		try {
		      File myObj = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\toate_grupurile_studentului.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
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
			        
			        
			        int number = Integer.parseInt(nb);
			        
		        JMenuItem mntmNewMenuItem = new JMenuItem(dataModified);
				mntmNewMenuItem.addActionListener((ActionListener) new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                MesajeGrup mg = new MesajeGrup(number, idStudent);
		                mg.setVisible(true);
		                setVisible(false);
		            }
		        });
				mntmNewMenuItem.setForeground(new Color(128, 0, 128));
				mntmNewMenuItem.setFont(new Font("Arial Narrow", Font.BOLD, 18));
				mnNewMenu.add(mntmNewMenuItem);
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
	}
}
