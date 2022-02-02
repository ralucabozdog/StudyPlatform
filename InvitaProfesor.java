import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.border.TitledBorder;

import java.util.Scanner;

import javax.swing.JScrollPane;

public class InvitaProfesor extends JDialog {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvitaProfesor frame = new InvitaProfesor(1);
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
	public InvitaProfesor(int idActivitate) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumeGrup = new JLabel("Invitã profesor");
		lblNumeGrup.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeGrup.setForeground(new Color(0, 139, 139));
		lblNumeGrup.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblNumeGrup.setBounds(158, 11, 218, 52);
		contentPane.add(lblNumeGrup);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Profesori", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(45, 78, 445, 273);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 429, 246);
		panel.add(scrollPane);
		
		JList list = new JList();
		list.setForeground(new Color(128, 0, 128));
		list.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		scrollPane.setViewportView(list);
		
		DefaultListModel dlm = new DefaultListModel();
		
		
		JButton btnInvit = new JButton("Invit\u0103");
		btnInvit.setForeground(new Color(230, 230, 250));
		btnInvit.setFont(new Font("Arial Nova Light", Font.BOLD, 14));
		btnInvit.setBackground(new Color(0, 139, 139));
		btnInvit.setActionCommand("OK");
		btnInvit.setBounds(205, 379, 138, 44);
		contentPane.add(btnInvit);
		
		int[] vector = new int[100];
	    int i = 0;
		try {
		      File myObj = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\toti_profesorii.txt");
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
		        vector[i] = number;
		        i++;
		               
		        
		        dlm.addElement(dataModified);
		      }
		      myReader.close();
		      if(myObj.delete())
		    	  System.out.println("deleted");
		      else
		    	  System.out.println("could not be deleted");;
		    } catch (FileNotFoundException e) {
		      System.out.println("Eroare la citire");
		      e.printStackTrace();
		    }
		
		list.setModel(dlm);
				
		btnInvit.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = list.getSelectedIndex();
				int idProf = vector[index];

				ConexiuneBD conexiune = new ConexiuneBD();
				conexiune.init();
				conexiune.invitaProfesor(idActivitate, idProf);
				
				setVisible(false);
			}
		});
	}
}
