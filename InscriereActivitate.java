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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class InscriereActivitate extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriereActivitate frame = new InscriereActivitate(4);
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
	public InscriereActivitate(int idStudent) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 495);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlegeOActivitate = new JLabel("Alege o activitate");
		lblAlegeOActivitate.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlegeOActivitate.setForeground(new Color(0, 139, 139));
		lblAlegeOActivitate.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblAlegeOActivitate.setBounds(329, 11, 218, 52);
		contentPane.add(lblAlegeOActivitate);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Activitati disponibile", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(37, 80, 800, 292);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 784, 270);
		panel.add(scrollPane);
		
		JList list = new JList();
		list.setForeground(new Color(128, 0, 128));
		list.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		scrollPane.setViewportView(list);
		
		DefaultListModel dlm = new DefaultListModel();
		
		int[] vector = new int[10000];
	    int i = 0;
		try {
		      File myObj = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\toate_activitatile_cu_profesor.txt");
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
		        		if(data.charAt(2) < '0' || data.charAt(2) > '9') {
			        		
				        	nb = data.substring(0,3);
					        dataModified = data.substring(4);
				        }
		        		else {
		        			nb = data.substring(0,4);
					        dataModified = data.substring(5);
		        		}
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
		
		
		try {
		      File myObj = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\toate_activitatile_fara_profesor.txt");
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
		        		if(data.charAt(2) < '0' || data.charAt(2) > '9') {
			        		
				        	nb = data.substring(0,3);
					        dataModified = data.substring(4);
				        }
		        		else {
		        			nb = data.substring(0,4);
					        dataModified = data.substring(5);
		        		}
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
		
		JButton btnnscriere = new JButton("\u00CEnscriere");
		btnnscriere.setForeground(new Color(230, 230, 250));
		btnnscriere.setFont(new Font("Arial Nova Light", Font.BOLD, 14));
		btnnscriere.setBackground(new Color(0, 139, 139));
		btnnscriere.setActionCommand("OK");
		btnnscriere.setBounds(356, 383, 163, 44);
		contentPane.add(btnnscriere);
		
		btnnscriere.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = list.getSelectedIndex();
				int idActivitate = vector[index];

				ConexiuneBD conexiune = new ConexiuneBD();
				conexiune.init();
				conexiune.inscriereActivitateGrup(idStudent, idActivitate);
				
				setVisible(false);
			}
		});
	}
}
